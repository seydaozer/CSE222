
/**
 * @author Seyda Ozer
 * Hash Table
 * @param <K> type of key
 * @param <V> type of value
 */
public class HashTableChain<K, V> implements KWHashMap<K, V> {
	// The table
	private BinaryTree<Entry<K, V>> [] table;
	// The number of keys
	private int numKeys;
	// The capacity
	private static final int CAPACITY = 101;
	// The maximum load factor
	private static final double LOAD_THRESHOLD = 3.0;
	
	/**
	 * @author Seyda Ozer
	 * Contains key-value pairs for a hash table.
	 * @param <K> type of key
	 * @param <V> type of value
	 */
	private static class Entry<K, V>{
		//The key
		private K key;
		//The value
		private V value;
		
		/**
		 * Creates a new key-value pair.
		 * @param key The key
		 * @param value The value
		 */
		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		/**
		 * Retrieves the key.
		 * @return The key
		 */
		public K getKey() {
			return key;
		}
		
		/**
		 * Retrieves the value.
		 * @return The value
		 */
		public V getValue() {
			return value;
		}
		
		/**
		 * Sets the value.
		 * @param val The new value
		 * @return The old value
		 */
		public V setValue(V val) {
			V oldVal = value;
			value = val;
			return oldVal;
		}
		
		/**
	    * This method returns a string representation of the Entry object.
	    * 
	    * @return a string representation of the Entry object.
	    */
		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("[" + key.toString() + "- " + value.toString() + "]");
			return sb.toString();
		}
	}
	
	/**
	 * Constructor
	 */
	public HashTableChain() {
		table = new BinaryTree[CAPACITY];
		numKeys = 0;
	}
	
	/**
	 * Method get for class HashTableChain
	 * @param key The key being sought
	 * @return The value associated with this key if found;
	 * otherwise, null
	 */
	@Override
	public V get(Object key) {
		int index = key.hashCode() % table.length;
		
		if( index < 0 )
			index += table.length;
		
		if(table[index] == null)
			return null; // key is not in the table.
		
		// Search the list at table[index] to find the key.
		return find(table[index].root, key);

	}
	
	/**
	 * Recursive Find Method for a binary tree
	 * @param node The node is the local root
	 * @param key The key being sought
	 * @return The value associated with this key if found;
	 * otherwise, null
	 */
	private V find(BinaryTree.Node<Entry<K, V>> node, Object key) {
		if(node == null)
			return null;
		
		if(key.equals(node.data.key))
			return node.data.value;
		
		
		V val = find(node.left, key);
		val = find(node.right, key);
		
		return val;
	}

	/**
	 * Returns true if this table contains no key-value mappings.
	 * @return true if this table contains no key-value mappings;
	 * otherwise, false.
	 */
	@Override
	public boolean isEmpty() {
		return (numKeys == 0);
	}

	/**
	 * Method put for class HashTableChain.
	 * post: This key-value pair is inserted in the
	 * table and numKeys is incremented. If the key is already
	 * in the table, its value is changed to the argument
	 * value and numKeys is not changed.
	 * @param key The key of item being inserted
	 * @param value The value for this key
	 * @return The old value associated with this key if
	 * found; otherwise, null
	 */
	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % table.length;
		if(index < 0)
			index += table.length;
		
		if(table[index] == null) {
			// Create a new Binary tree at table[index]
			table[index] = new BinaryTree<Entry<K, V>>();
		}
		
		// Search the tree at table[index] to find the key.
		V oldValue = findForPut(table[index].root, key, value);
		if(oldValue != null)
			return oldValue;
		
		// assert: key is not in the table, add new item.
		table[index].root = addKey(table[index].root, key, value);
		numKeys++;
		if(numKeys > (LOAD_THRESHOLD * table.length))
			rehash();
		
		return null;
	}
	
	/**
	 * Recursive add method
	 * Add new item into specified tree.
	 * @param node The node is the local root
	 * @param key The key of item being inserted
	 * @param value The value for this key
	 * @return The new local root that now contains the
	 * inserted item
	 */
	private BinaryTree.Node<Entry <K, V>> addKey(BinaryTree.Node<Entry <K, V>> node, K key, V value) {	
		if(node == null) {
			Entry<K, V> entry = new Entry<K, V>(key, value);
			node = new BinaryTree.Node<Entry <K, V>>(entry);
			return node;
		}
		
		if(node.left != null && node.right !=  null) {
			node.left = addKey(node.left, key, value);
			return node;
		}
		
		else if(node.left == null) {
			Entry<K, V> entry = new Entry<K, V>(key, value);
			node.left = new BinaryTree.Node<Entry <K, V>>(entry);
			return node;
		}
		
		else if(node.right == null) {
			Entry<K, V> entry = new Entry<K, V>(key, value);
			node.right = new BinaryTree.Node<Entry <K, V>>(entry);
			return node;
		}
		return node;
	}
	
	/**
	 * The recursive find method.
	 * This method finds the key. If the key is found, this method sets the key.
	 * @param node The Node is the local root
	 * @param key The key being sought
	 * @return The value associated with this key if found;
	 * otherwise, null
	 */
	private V findForPut(BinaryTree.Node<Entry <K, V>> node, K key, V value) {
		if(node == null)
			return null;
		
		if(key.equals(node.data.key)) {
			// Replace value for this key.
			V oldVal = node.data.value;
			node.data.setValue(value);
			return oldVal;
		}
		
		V oldValue = findForPut(node.left, key, value);
		oldValue = findForPut(node.right, key, value);
		
		return oldValue;
	}

	/**
	 * Removes the mapping for this key from this table if it is present.
	 * @param key The key being removed
	 * @return The previous value associated with
	 * the specified key, or null if there was no mapping.
	 */
	@Override
	public V remove(Object key) {
		int index = key.hashCode() % table.length;
		
		if(index < 0)
			index += table.length;
		
		if(table[index] == null)
			return null;
		
		// Search the tree at table[index] to find key.
		V val = find(table[index].root, key);
		
		if(val != null) {
			numKeys--;
			table[index].root = remove(table[index].root, key);
			if(table[index].root == null)
				table[index] = null;
			return val;
		}
		
		return null;
	}
	
	/**
	 * Recursive remove method for a binary tree.
	 * @param node The node is local root.
	 * @param key The key being removed
	 * @return The modified local root that does not contain
	 * the item
	 */
	private BinaryTree.Node<Entry <K, V>> remove(BinaryTree.Node<Entry <K, V>> node, Object key) {
		if(node == null)
			return node;
		
		if(node.data.key.equals(key)) {
			if(node.right == null)
				return node.left;
			else if(node.left == null)
				return node.right;
			else {
				if(node.right.left == null) {
					node.data = node.right.data;
					node = node.left.right;
					return node;
				}
				else {
					node.data = findLastChild(node.right);
					return node;
				}
			}
		}
		node.left = remove(node.left, key);
		node.right = remove(node.right, key);
		return node;
	}
	
	/**
	 * This method finds the last right child in specified tree.
	 * @param parent The node is the local root
	 * @return The Entry of the last right child.
	 */
	private Entry<K, V> findLastChild(BinaryTree.Node<Entry <K, V>> parent) {
		if(parent.right.right == null) {
			Entry<K, V> data;
			if(parent.right.left != null) {
				data = parent.right.left.data;
				parent.right.left = null;
			}
			else {
				data = parent.right.data;
				parent.right = null;
			}
			return data;
		}
		return findLastChild(parent.right);
	}

	/**
	 * Returns the size of the table.
	 * @return size of the table.
	 */
	@Override
	public int size() {
		return numKeys;
	}

	/**
	 * Expands table size when loadFactor exceeds LOAD_THRESOHLD
	 * post: The size of the table is doubled and is an odd integer.
	 * The value of numKeys is reset to the number of items
	 * actually inserted.
	 */
	private void rehash() {
		// Save a reference to oldTable.
		BinaryTree<Entry<K, V>> [] oldTable = table;
		
		// Double capacity of this table.
		table = new BinaryTree[2 * oldTable.length + 1];
		
		// Reinsert all items in oldTable into expanded table.
		numKeys = 0;
		for(int i=0; i<oldTable.length; i++) {
			if(oldTable[i] != null) {
				// Insert entry in expanded table
				reInsert(oldTable[i].root);
			}
		}
		
	}
	
	/**
	 * Recursive insert method for a binary tree.
	 * This method reinserts all items in specified tree into the table.
	 * @param node The node is local root of the specified tree.
	 */
	private void reInsert(BinaryTree.Node<Entry <K, V>> node) {
		if(node == null)
			return;
		
		put(node.data.key, node.data.value);
		
		reInsert(node.left);
		reInsert(node.right);
	}
	
	/**
	* This method returns a string representation of the HashTableChain object.
	* 
	* @return a string representation of the HashTableChain object.
	*/
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<table.length; i++) {
			if(table[i] != null) {
				sb.append(table[i]);
				sb.append("\n");
			}
		}
		
		return sb.toString();
	}
}
