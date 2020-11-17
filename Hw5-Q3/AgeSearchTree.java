
/**
 * @author Seyda Ozer
 * AgeSearchTree Class
 * @param <E> This is type of the data for the AgeSearchTree.
 */
public class AgeSearchTree<E extends Comparable<E>> extends BinarySearchTree<E> {
	//Constructors
	/**
	 * The no-parameter constructor merely sets the root to null.
	 */
	public AgeSearchTree() {
		root = null;
	}
	
	/**
	 * One-parameter constructor takes an object and creates the root using this object.
	 * @param data The data object for the root
	 */
	public AgeSearchTree(E data) {
		root = new Node<E>(data);
	}
	
	//Methods
	/**
	 * Starter method add.
	 * pre: The object to insert must implement the
	 * 		Comparable interface.
	 * @param item The object being inserted
	 * @return true if the object is inserted, false
	 * 			if the object already exists in the tree
	 */
	@Override
	public boolean add(E item) {
		root = add(root, item);
		return addReturn;
	}
	/**
	 * Recursive add method.
	 * post: The data field addReturn is set true if the item is added to
	 * 		the tree, false if the item is already in the tree. 
	 * If the item is already in the tree, the number of people increases one.
	 * @param localRoot The local root of the subtree
	 * @param item The object to be inserted
	 * @return The new local root that now contains the
	 * 			inserted item
	 */
	private Node<E> add(Node<E> localRoot, E item){
		if (localRoot == null) {
			// tree is empty - insert it.
			addReturn = true;
			return new Node<E>(item);
		} else if (item.compareTo(localRoot.data) == 0) {
			// item is equal the localRoot.data
			if(localRoot.data.getClass() == AgeData.class) {
				AgeData data = (AgeData) localRoot.data;
				data.setNumberOfPeople(data.getNumberOfPeople()+1);
			}
			addReturn = true;
			return localRoot;
		} else if (item.compareTo(localRoot.data) < 0) {
			// item is less than localRoot.data
			localRoot.left = add(localRoot.left, item);
			return localRoot;
		} else {
			// item is greater than localRoot.data
			localRoot.right = add(localRoot.right, item);
			return localRoot;
		}
	}
	
	/**
	 * Starter method delete.
	 * post: The object is not in the tree.
	 * @param target The object to be deleted
	 * @return The object deleted from the tree
	 * 			or null if the object was not in the tree
	 * @throws ClassCastException if target does not implement
	 * 			Comparable
	 */
	@Override
	public E delete(E target) {
		root = delete(root, target);
		return deleteReturn;
	}
	
	/**
	 * Recursive delete method.
	 * post: The item is not in the tree;
	 * 		deleteReturn is equals to the deleted item
	 * 		as it was stored in the tree or null
	 * 		if the item was not found.
	 * If the item is in the tree and its number of people data is
	 * greater than 1, this method will decrease the number of people data 1.
	 * Otherwise, the item is deleted from the tree.
	 * @param localRoot The root of the current subtree
	 * @param item The item to be deleted
	 * @return The modified local root that does not contain
	 * 			the item
	 */
	private Node<E> delete(Node<E> localRoot, E item){
		if(localRoot == null) {
			// tree is empty.
			deleteReturn = null;
			return localRoot;
		}
		
		// Search for item to delete.
		int compResult = item.compareTo(localRoot.data);
		if (compResult < 0) {
			// item is smaller than localRoot.data.
			localRoot.left = delete(localRoot.left, item);
			return localRoot;
		} else if (compResult > 0) {
			// item is larger than localRoot.data.
			localRoot.right = delete(localRoot.right, item);
			return localRoot;
		} else {
			// item is at local root.
			if(localRoot.data.getClass() == AgeData.class) {
				AgeData data = (AgeData) localRoot.data;
				int counter = data.getNumberOfPeople();
				if( counter > 1) {
					data.setNumberOfPeople(counter-1);
					deleteReturn = localRoot.data;
					return localRoot;
				}
			}
			deleteReturn = localRoot.data;
			if (localRoot.left == null) {
				// If there is no left child, return right child
				// which can also be null.
				return localRoot.right;
			} else if (localRoot.right == null) {
				// If there is no right child, return left child
				return localRoot.left;
			} else {
				// Node being deleted has 2 children, replace the data
				// with inorder predecessor.
				if(localRoot.left.right == null) {
					// The left child has no right child.
					// Replace the data with the data in the
					// left child.
					localRoot.data = localRoot.left.data;
					// Replace the left child with its left child.
					localRoot.left = localRoot.left.left;
					return localRoot;
				} else {
					// Search for the inorder predecessor (ip) and
					// replace deleted node's data with ip.
					localRoot.data = findLargestChild(localRoot.left);
					return localRoot;
				}
			}
		}
	}
	
	/**
	 * Perform a preorder traversal.
	 * @param node The local root
	 * @param depth the depth
	 * @param sb The string buffer to save the output
	 */
	@Override
	public void preOrderTraverse(Node<E> node, int depth, StringBuilder sb) {
		if(node == null) {
			sb.append("null\n");
		} else {
			sb.append(node.toString());
			sb.append("\n");
			preOrderTraverse(node.left, depth+1, sb);
			preOrderTraverse(node.right, depth+1, sb);
		}
	}
	
	/**
	 * This method which returns the number of people younger than an age. 
	 * @param age The value to compare with other ages in the tree
	 * @return The number of people younger than the age
	 */
	public int youngerThan(int age) {
		// I created an AgeData object to compare with the objects in the tree.
		E data = (E) new AgeData(age);
		int compResult = data.compareTo(root.data);
		
		if(compResult == 0 || compResult < 0) 
			return youngerLeftSubtree(root.left, data);
		
		else {
			AgeData tempRoot = (AgeData) root.data;
			int numRoot = tempRoot.getNumberOfPeople();
			
			int left = youngerLeftSubtree(root.left, data);
			int right = youngerRightSubtree(root.right, data);

			return  left + numRoot + right ;
		}
	}
	
	/**
	 * This method checks the left subtree of the tree for the youngerThan method.
	 * @param localRoot The local subtree's root
	 * @param target The Comparable object
	 * @return The number of people younger than the age in the subtree
	 */
	private int youngerLeftSubtree(Node<E> localRoot, E target) {
		if(localRoot == null)
			return 0;
		
		int compResult = target.compareTo(localRoot.data);
		AgeData data = (AgeData) localRoot.data;
		
		if(compResult > 0)
			return data.getNumberOfPeople() + youngerLeftSubtree(localRoot.left, target) + youngerLeftSubtree(localRoot.right, target);
		else
			return youngerLeftSubtree(localRoot.left, target);
	}
	
	/**
	 * This method checks the right subtree of the tree for the youngerThan method.
	 * @param localRoot The local subtree's root
	 * @param target The Comparable object
	 * @return The number of people younger than the age in the subtree
	 */
	private int youngerRightSubtree(Node<E> localRoot, E target) {
		if(localRoot == null)
			return 0;
		
		int compResult = target.compareTo(localRoot.data);
		AgeData data = (AgeData) localRoot.data;
		
		if(compResult > 0)
			return data.getNumberOfPeople() +  youngerRightSubtree(localRoot.right, target) +  youngerRightSubtree(localRoot.left, target);
		else
			return youngerRightSubtree(localRoot.left, target);
	}
	
	/**
	 * This method which returns the number of people older than an age.
	 * @param age The value to compare with other ages in the tree
	 * @return The number of people older than the age
	 */
	public int olderThan(int age) {
		// I created an AgeData object to compare with the objects in the tree.
		E data = (E) new AgeData(age);
		int compResult = data.compareTo(root.data);
		
		if(compResult == 0 || compResult > 0) 
			return olderRightSubtree(root.right, data);
		else {
			AgeData tempRoot = (AgeData) root.data;
			int numRoot = tempRoot.getNumberOfPeople();
			
			int left = olderLeftSubtree(root.left, data);
			int right = olderRightSubtree(root.right, data);

			return  left + numRoot + right ;
		}	
	}
	
	/**
	 * This method checks the left subtree of the tree for the olderThan method.
	 * @param localRoot The local subtree's root
	 * @param target The Comparable object
	 * @return The number of people younger than the age in the subtree
	 */
	private int olderLeftSubtree(Node<E> localRoot, E target) {
		if(localRoot == null)
			return 0;
		
		int compResult = target.compareTo(localRoot.data);
		AgeData data = (AgeData) localRoot.data;
		
		if(compResult < 0)
			return data.getNumberOfPeople() + olderLeftSubtree(localRoot.right, target) + olderLeftSubtree(localRoot.left, target);
		else
			return olderLeftSubtree(localRoot.right, target);
	}
	
	/**
	 * This method checks the right subtree of the tree for the olderThan method.
	 * @param localRoot The local subtree's root
	 * @param target The Comparable object
	 * @return The number of people younger than the age in the subtree
	 */
	private int olderRightSubtree(Node<E> localRoot, E target) {
		if(localRoot == null)
			return 0;
		
		int compResult = target.compareTo(localRoot.data);
		AgeData data = (AgeData) localRoot.data;
		
		if(compResult < 0)
			return data.getNumberOfPeople() + olderRightSubtree(localRoot.left, target) + olderRightSubtree(localRoot.right, target);
		else
			return olderRightSubtree(localRoot.right, target);
	}
	
}
