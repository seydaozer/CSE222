import java.util.ArrayList;
import java.util.List;

/**
 * @author Koffman and Wolfgang
 * An implementation of the B-tree. A B-tree is a search tree in which
 * each node contains n data items where n is between (order-1)/2 and order-1.
 * (For the root, n may be between 1 and order-1) Each node not a leaf has n+1 children.
 * The tree is always balanced in that all leaves are on the same level, i.e.,
 * the length of the path from the root to a leaf is constant.
 * @param <E> This is type of the data for the BTree.
 */
public class BTree<E extends Comparable<E>> implements SearchTree<E> {
	// Nested class
	/**
	 * A Node represents a node in a B-tree.
	 * @param <E> The element type
	 */
	private static class Node<E>{
		// Data Fields
		/** The number of data items in this node. */
		private int size = 0;
		/** The information */
		private E[] data;
		/** The links to the children. child[i] refers to
		 *  the subtree of children < data[i] for i < size
		 *  and to the subtree of children > data[size-1]
		 *  for i == size */
		 private Node<E>[] child;
		 
		 /**
		 * Create an empty node of size order
		 * @param order The size of a node
		 */
		 @SuppressWarnings("unchecked")
		public Node(int order) {
			 data = (E[]) new Comparable[order - 1];
			 child = (Node<E>[]) new Node[order];
			 size = 0;
		 }
	}
	
	/** The root node. */ 
	private Node<E> root = null;
	/** The maximum number of children of a node */
	private int order;
    /** The parent of a split node returned from insert */
    private E newParent;
    /** The right half of a split node returned from insert */
    private Node<E> newChild;
	
	/**
	 * Construct a B-tree with node size order
	 * @param order the size of a node
	 */
	public BTree(int order) {
		this.order = order;
		root = null;
	}
	
	public boolean add(E item) {
		if(root == null) {
			root = new Node<E>(order);
			root.data[0] = item;
			root.size = 1;
			return true;
		}
		newChild = null;
		boolean added = insert(root, item);
		if(newChild != null) {
			Node<E> temp = new Node<E>(order);
			temp.child[0] = root;
			temp.child[1] = newChild;
			temp.data[0] = newParent;
			temp.size = 1;
			root = temp;
		}
		return added;
	}
	
	/**
	 * Recursively insert an item into the B-tree.
	 * Inserted item must implement the Comparable interface.
	 * @param root The local root
	 * @param item The item to be inserted
	 * @return true if the item was inserted, false
	 * if the item is already in the tree.
	 */
	private boolean insert(Node<E> root, E item) {
		int index = binarySearch(item, root.data, 0, root.size);
		if(index != root.size && item.compareTo(root.data[index]) == 0) {
			return false;
		}
		newChild = new Node<E>(order);
		if(root.child[index] == null) {
			if(root.size < order - 1) {
				insertIntoNode(root, index, item, null);
				newChild = null;
			} else {
				splitNode(root, index, item, null);
			}
			return true;
		} else {
			boolean result = insert(root.child[index], item);
			if(newChild != null) {
				newParent = null;
				if(root.size < order - 1) {
					insertIntoNode(root, index, newParent, newChild);
					newChild = null;
				} else {
					splitNode(root, index, newParent, newChild);
				}
			}
			return result;
		}
	}
	
	private int binarySearch(E item, E [] data, int index, int size) {
		if(index == size)
			return size;
		if(size - index == 1) {
			if(item.compareTo(data[index]) <= 0)
				return index;
			return size;
		}
		
		int middle = index + (size - index) / 2;
		if(item.compareTo(data[middle]) == 0)
			return middle;
		else if(item.compareTo(data[middle]) < 0)
			return binarySearch(item, data, index, middle);
		else
			return binarySearch(item, data, middle + 1, size);
	}
	
	/** 
	 * Method to insert a new value into a node
	 * pre: node.data[index-1] < item < node.data[index];
	 * post: node.data[index] == item and old values are moved right one position
	 * @param node The node to insert the value into
	 * @param index The index where the inserted item is to be placed
	 * @param item The value to be inserted
	 * @param child The right child of the value to be inserted
	 */
	private void insertIntoNode(Node<E> node, int index, E item, Node<E> child) {
		for(int i = node.size; i > index; i--) {
			node.data[i] = node.data[i - 1];
			node.child[i + 1] = node.child[i];
		}
		node.data[index] = item;
		node.child[index + 1] = child;
		node.size++;
	}
	
	private void splitNode(Node<E> node, int index, E item, Node<E> child) {
		// Create new child
		newChild = new Node<E>(order);
		// Determine number of items to move
		int numToMove = (order - 1) - ((order - 1) / 2);
		// If insertion points is in the right half, move one less item
		if(index > (order - 1) / 2) {
			numToMove--;
		}
		
		// Move items and their children
		System.arraycopy(node.data, order - numToMove - 1, newChild.data, 0, numToMove);
		System.arraycopy(node.child, order - numToMove, newChild.child, 1, numToMove);
		node.size = order - numToMove - 1;
		newChild.size = numToMove;
		
		// Insert new item
		if(index == ((order - 1) / 2)) { // Insert as middle item
			newParent = item;
			newChild.child[0] = child;
		} else {
			if(index < ((order - 1) / 2)) { // Insert into the left 
				insertIntoNode(node, index, item, child);
			} else {
				insertIntoNode(newChild, index - ((order - 1) / 2) - 1, item, child);
			}
			// The rightmost item of the node is the new parent
			newParent = node.data[node.size - 1];
			// Its child is the left child of the split-off node
			newChild.child[0] = node.child[node.size];
			node.size--;
		}
		
		// Remove items and references to moved items
		for(int i = node.size; i < node.data.length; i++) {
			node.data[i] = null;
			node.child[i + 1] = null;
		}
	}
	
	/**
	 * Return a list that contains the elements of the tree in ascending order.
	 * @return list The list of the elements
	 */
	public List<E> toList() {
		List<E> list = new ArrayList<E>();
		inOrderTraverse(root, list);
		return list;
	}
	
	/**
	 * Perform a inorder traversal. 
	 * While traversing the tree, the elements of the tree are added to list.
	 * @param node The local root
	 * @param list The list contains the elements of the tree
	 */
	public void inOrderTraverse(Node<E> node, List<E> list) {
		if(node == null)
			return;
		
		for(int i = 0; i <= node.size; i++) {
			inOrderTraverse(node.child[i], list);
			if( i != node.size )
				list.add(node.data[i]);
		}	
	}

    /**
     * Determine if an item is in the tree
     * @param target Item being sought in tree
     * @return true If the item is in the tree, false otherwise
     */
	@Override
	public boolean contains(E target) {
		E item = find(target);
		if( item != null )
			return true;
		else
			return false;
	}

	  /**
     * Find an object in the tree
     * @param target The object sought, must be Comparable
     * @return The object in the tree, or null
     *         if the object is not in the tree
     */
	@Override
	public E find(E target) {
		// TODO Auto-generated method stub
		return null;
	}

	 /**
     * Delete an object from the tree.
     * @param target The object to be deleted
     * @return The deleted object or null if not in the tree
     */
	@Override
	public E delete(E target) {
		// TODO Auto-generated method stub
		return null;
	}

    /**
     * Remove an object from the tree.
     * @param target The object to be removed
     * @return true if the object is removed, otherwise null
     */
	@Override
	public boolean remove(E target) {
		// TODO Auto-generated method stub
		return false;
	}
}
