import java.util.ArrayList;
import java.util.Comparator;

public class MaxHeap<E>{
	// Data Fields
	/**
	 * The ArrayList to hold the data
	 */
	private ArrayList<E> tree;
	/**
	 * An optional reference to a Comparator object
	 */
	private Comparator<E> comparator = null;
	
	// Constructor
	public MaxHeap() {
		this((Comparator<E>) new AgeData());
	}
	
	/**
	 * @param comp The comparator used to order this heap
	 */
	public MaxHeap(Comparator<E> comp) {
		tree = new ArrayList<E>();
		comparator = comp;
	}
	
	// Methods
	
	/**
	 * Insert an item into the MaxHeap.
	 * pre: The ArrayList tree is in heap order.
	 * post: The item is in the MaxHeap and
	 *       tree is in heap order.
	 * @param item The item to be inserted
	 * @return true if the item is inserted, otherwise false.
	 * @throws NullPointerException if the item to be inserted is null.
	 */
	public boolean add(E item) {
		if(contains(item)) {
			int index = indexOf(item);
			AgeData data = (AgeData) tree.get(index);
			data.setNumberOfPeople(data.getNumberOfPeople() + 1);
		}
		else {
			// Add the item to the heap.
			tree.add(item);
		}
		// child is newly inserted item.
		int child = tree.size() - 1;
		int parent = (child - 1) / 2; // Find child's parent.
		// Reheap
		while (parent >= 0 && 
				compare(tree.get(parent), tree.get(child)) < 0) {
			swap(parent, child);
			child = parent;
			parent = (child - 1) / 2;

		}
		return true;
	}
	
	/**
	 * Returns the index of the specified element in this list,
     * or -1 if this heap does not contain the element.
	 * @param item The item being sought
	 * @return The index of the item
	 */
	public int indexOf(E item) {
		for(int i=0; i<tree.size(); i++) {
			if( ((Comparable<E>) item).compareTo(tree.get(i)) == 0)
				return i;
		}
		return -1;
	}
	
    /**
     * Returns true if this heap contains the specified element.
     * @param data The element being sought
     * @return true if this heap contains the specified element
     */
	public boolean contains(E data) {
		if(indexOf(data) == -1)
			return false;
		return true;
	}
	
	/**
	 * Remove an specified element from the MaxHeap
	 * pre: The ArrayList tree is in heap order.
	 * post: Removed the specified item, tree is in heap order.
	 * @param target The object being sought
	 * @return The removed item or null if empty.
	 */
	public E remove(E target) {
		if(isEmpty() || !contains(target))
			return null;
			
		int index = indexOf(target);
		AgeData data = (AgeData) tree.get(index);
		
		if(data.getNumberOfPeople() > 1) {
			data.setNumberOfPeople(data.getNumberOfPeople() - 1);
		} else if(data.getNumberOfPeople() == 1) {
			if(index == tree.size()-1)
				tree.remove(index);
			else
				tree.set(index, tree.remove(tree.size()-1));
		}
		// The parent starts at the top.
		int parent = 0;
		while (true) {
			int leftChild = 2 * parent + 1;
			if(leftChild >= tree.size()) {
				break; // Out of heap.
			}
			int rightChild = leftChild + 1;
			int maxChild = leftChild; // Assume leftChild is bigger.
			// See whether rightChild is bigger.
			if (rightChild < tree.size() &&
				compare(tree.get(leftChild), tree.get(rightChild)) < 0) {
				maxChild = rightChild;
			}
			// assert: maxChild is the index if the bigger child.
			// Move bigger child up heap if necessary.
			if (compare(tree.get(parent), tree.get(maxChild)) < 0) {
				swap(parent, maxChild);
				parent = maxChild;
			} else { // Heap property is restored.
				break;
			}
		}
		return (E) data;
	}
	
	/**
	 * The method finds the specified element in the heap, and returns it.
	 * @param target The object being sought
	 * @return The object, if found, otherwise null
	 */
	public E find(E target) {
		if(!contains(target) || isEmpty())
			return null;
		
		int index = indexOf(target);
		return tree.get(index);
	}
	
	public boolean isEmpty() {
		return tree.isEmpty();
	}
	
	/**
	 * This method which returns the number of people younger than an age. 
	 * @param age The value to compare with other ages in the tree
	 * @return The number of people younger than the age
	 */
	public int youngerThan(int age) {
		int counter = 0;
		AgeData target = new AgeData(age);
		for(int i=0; i<tree.size(); i++) {
			AgeData data = (AgeData) tree.get(i);
			if( target.compareTo(data) > 0 ) {
				counter += data.getNumberOfPeople();
			}
		}
		return counter;
	}
	
	/**
	 * This method which returns the number of people older than an age.
	 * @param age The value to compare with other ages in the tree
	 * @return The number of people older than the age
	 */
	public int olderThan(int age) {
		int counter = 0;
		AgeData target = new AgeData(age);
		for(int i=0; i<tree.size(); i++) {
			AgeData data = (AgeData) tree.get(i);
			if( target.compareTo(data) < 0 ) {
				counter += data.getNumberOfPeople();
			}
		}
		return counter;
	}

	/**
	 * Compare two items using either a Comparator object's compare method
	 * or their natural ordering using method compareTo.
	 * pre : If comparator is null, left and right implement Comparable<E>.
	 * @param left One item
	 * @param right The other item
	 * @return 	Negative int if left less than right,
	 * 			0 if left equals right,
	 * 			positive int if left greater than right.
	 * @throws ClassCastException if items are not Comparable
	 */
	private int compare(E left, E right) {
		if(comparator != null) {	// A Comparator is defined.
			return comparator.compare(left, right);
		} else {					// Use left's compareTo method.
			return ((Comparable<E>) left).compareTo(right);
		}
	}
	
	/**
	 * This method exchanges the object references
	 * in tree ArrayList at indexes i and j.
	 * @param i The one index
	 * @param j The other index
	 */
	private void swap(int i, int j) {
		E temp = tree.get(i);
		tree.set(i, tree.get(j));
		tree.set(j, temp);
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<tree.size(); i++) {
			sb.append(tree.get(i).toString() + "\n");
		}
		return sb.toString();
	}

}
