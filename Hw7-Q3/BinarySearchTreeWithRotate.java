
/**
 * @author Seyda Ozer
 * This class extends the BinarySearchTree by adding the rotate operations. Rotation will
 * change the balance of a search tree while preserving the search tree property.
 * Used as a common base class for self-balancing trees.
 * @param <E> the element type
 */
public class BinarySearchTreeWithRotate<E extends Comparable<E>> extends BinarySearchTree<E> {
	// Methods
	
	/**
	 * Method to perform a right rotation.
	 * @param root The root of the binary tree to be rotated
	 * @return The new root of the rotated tree
	 */
	protected Node<E> rotateRight(Node<E> root){
		Node<E> temp = root.left;
		root.left = temp.right;
		temp.right = root;
		return temp;
	}
	
	/**
	 * Method to perform a left rotation.
	 * @param root The root of the binary tree to be rotated
	 * @return The new root of the rotated tree
	 */
	protected Node<E> rotateLeft(Node<E> root){
		Node<E> temp = root.right;
		root.right = temp.left;
		temp.left = root;
		return temp;
	}

}
