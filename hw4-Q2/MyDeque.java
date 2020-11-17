import java.util.*;

/**
 * @author Seyda Ozer
 * 		   171044023
 *
 * @param <E> This is type of the data of the Deque class.
 */
public class MyDeque<E> extends AbstractCollection<E> implements Deque<E> {
	/**
	 *  My first linked list for the elements in the deque.
	 *	It has two nodes.
	 */
	/**
	 * This node is the front of the deque.
	 */
	private Node<E> front;
	/**
	 * This node is the rear of the deque.
	 */
	private Node<E> rear;
	/**
	 * This int value is size of the deque.
	 */
	private int size;

	/**
	 *  My second linked list keeps the nodes removed.
	 * This node is the head of the nodes removed.
	 */
	private Node<E> headRemoved;
	
	/**
	 * MyDeque Constructor
	 */
	public MyDeque(){
		front = null;
		rear = null;
		size = 0;
		headRemoved = null;
	}

	/**
	 * @author Seyda Ozer
	 *
	 * @param <E> This is type of the data of the Node.
	 */
	private static class Node<E>{
		/**
		 * This value is the data of the node.
		 */
		private E data;
		/**
		 * This node is previous node of the current node.
		 */
		private Node<E> prev;
		/**
		 * This node is next node of the current node.
		 */
		private Node<E> next;

        /**
         * Node Constructor
         */
        private Node(Node<E> prevNode, E item, Node<E> nextNode) {
        	data = item;
            prev = prevNode;
            next = nextNode;
        }

		/**
		 * This method sets the previous node, next node, and data of the node.
		 * @param prevNode the new previous node
		 * @param item the new data of the node
		 * @param nextNode the new next node
		 */
		private void regenerate(Node<E> prevNode, E item, Node<E> nextNode){
			data = item;
			prev = prevNode;
			next = nextNode;
		}	
	}

	/**
	 * @author Seyda Ozer
	 *
	 * @param <E> This is type of the data of the Queue class.
	 */
	private class MyIterator<E> implements Iterator<E>{
		/**
		 * Index of element in the Deque.
		 */
		private int index;
		/**
		 * This is the current node.
		 */
		private Node<E> node;
		/**
		 * This is the node last returned.
		 */
		private Node<E> lastNode;

		/**
		 * MyIterator Constructor
		 */
		@SuppressWarnings("unchecked")
		public MyIterator(){
			index = 0;
			node = (Node<E>) front;
			lastNode = node;
		}

		/**
		 * MyIterator Constructor
		 * @param theIndex is the index of the iterator.
		 */
		public MyIterator(int theIndex){
			index = theIndex;
			node = currentNode(theIndex);
			lastNode = node;
		}

		/**
		 * This method finds the node at the specified index.
		 * @param theIndex is the index of the iterator.
		 * @return return the current node
		 */
		private Node<E> currentNode(int theIndex){
			Node<E> temp = (Node<E>) front;

			for(int i=0; temp != null && i<theIndex; i++)
				temp = temp.next;
			
			return temp;
		}

        /**
		 * This method returns true if the iteration has more elements.
		 * @return true if the iteration has more elements
         */
		@Override
		public boolean hasNext() {
			return index < size();
		}

		/**
		 * This method returns the next element in the deque.
		 * @return the next element in the iteration
		 * @throws NoSuchElementException if the iteration has no more elements
		 */
		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();

			lastNode = node;
			node = node.next;
			index++;
			return lastNode.data;
		}
		/**
         * This method returns true if this iterator has more elements
         * when traversing the deque in the reverse direction.
         * @return true if the iterator has more elements.
         */
		public boolean hasPrevious() {
			return index > -1;
		}

		/**
		 * This method returns the previous element in the deque.
		 * @return the previous element in the deque
		 * @throws NoSuchElementException if the iteration has no previous
		 *         element
		 */
		public E previous(){
			if(!hasPrevious())
				throw new NoSuchElementException();

			lastNode = node;
			if(node != front)
				node = node.prev;
		
			index--;
			
			return lastNode.data;
		}

		/**
		 * This method is not supported by this iterator.
		 * @throws UnsupportedOperationException if the remove
		 *         operation is not supported by this iterator
		 */
		@Override
		public void remove(){
			throw new UnsupportedOperationException();
		}

	}

	/**
	 * This method inserts the specified element at the front of this deque and it
	 * throws an IllegalStateException if the element cannot be added.
	 *
	 * @param e the element to add
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 */
	@Override
	public void addFirst(E e) throws NullPointerException {
		if( e == null )
			throw new NullPointerException("This deque does not insert null elements.");
		offerFirst(e);
	}

	/**
	 * This method inserts the specified element at the end of this deque and it
	 * throws an IllegalStateException if the element cannot be added.
	 *
	 * @param e the element to add
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 */
	@Override
	public void addLast(E e) throws NullPointerException {
		if( e == null )
			throw new NullPointerException("This deque does not insert null elements.");
		offerLast(e);
	}

	/**
	 * This method inserts the specified element at the front of this deque.
	 *
	 * @param e the element to add
	 * @return true if the element was added to this deque, else false
	 */
	@Override
	public boolean offerFirst(E e) {
		if (e == null)
			return false;
		
		if(headRemoved == null){
			Node<E> f = front;
			Node<E> newNode = new Node<>(null, e, f);
			front = newNode;
			if(f == null)
				rear = newNode;
			else 
				f.prev = newNode;
			
			size++;
			return true;
		}
		else if(headRemoved != null){
			Node<E> f = front;
			Node<E> temp = headRemoved;

			front = temp;

			if(headRemoved.next != null)
				headRemoved = headRemoved.next;
			else
				headRemoved = null;

			front.regenerate(null, e, f);

			if(f == null)
				rear = temp;
			else
				f.prev = temp;

			size++;
			return true;
		}
		return false;
	}

	/**
	 * This method inserts the specified element at the end of this deque.
	 *
	 * @param e the element to add
	 * @return true if the element was added to this deque, else false
	 */
	@Override
	public boolean offerLast(E e) {
		if (e == null)
			return false;
		
		if(headRemoved == null){
			Node<E> r = rear;
			Node<E> newNode = new Node<>(r, e, null);
			rear = newNode;
			if(r == null)
				front = newNode;
			else
				r.next = newNode;
			size++;
			return true;
		}
		else if(headRemoved != null){
			Node<E> r = rear;
			Node<E> temp = headRemoved;

			rear = temp;

			if(headRemoved.next != null)
				headRemoved = headRemoved.next;
			else
				headRemoved = null;

			rear.regenerate(r, e, null);

			if(r == null)
				front = temp;
			else
				r.next = temp;

			size++;
			return true;
		}
		return false;
	}

	/**
	 * This method retrieves and removes the first element of this deque.
	 * It throws an exception if this deque is empty.
	 *
	 * @return the head of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E removeFirst() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("This deque is empty.\n");
		return pollFirst();
	}

	/**
	 * This method retrieves and removes the last element of this deque.
	 * It throws an exception if this deque is empty.
	 *
	 * @return the tail of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E removeLast() throws NoSuchElementException {
		if (isEmpty())
			throw new NoSuchElementException("This deque is empty.\n");
		return pollLast();
	}

	/**
	 * This method retrieves and removes the first element of this deque,
	 * or returns null if this deque is empty.
	 *
	 * @return the head of this deque, or null if this deque is empty
	 */
	@Override
	public E pollFirst() {
		if (isEmpty())
			return null;
		
		final Node<E> f = front;
		final Node<E> next = front.next;
		E data = f.data;
		
		addRemoves(f);

		front = next;

		if(front == null)
			rear = null;
		else
			front.prev = null;

		size--;
		return data;
	}

	/**
	 * This method adds a new node to my second linked list.
	 * This new node is removed from the deque.
	 * @param newNode the node to add
	 */
	private void addRemoves(Node<E> newNode){
		Node<E> temp = headRemoved;
		E data = newNode.data;

		if( temp == null )
			newNode.regenerate(null, data, null);
		
		else {
			while(temp.next != null)
				temp = temp.next;
			
			newNode.regenerate(temp, data, null);
		}
		
		temp = newNode;
	}

	/**
	 * this method retrieves and removes the last element of this deque,
	 * or returns null if this deque is empty.
	 *
	 * @return the tail of this deque, or null if this deque is empty
	 */
	@Override
	public E pollLast() {
		if (isEmpty())
			return null;
		
		final Node<E> r = rear;
		final Node<E> prev = rear.prev;
		E data = r.data;
		
		addRemoves(r);

		rear = prev;

		if (rear == null)
			front = null;
		else
			rear.next = null;

		size--;
		return data;
	}

	/**
	 * This method retrieves, but does not remove, the first element of this deque.
	 *
	 * @return the head of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E getFirst() throws NoSuchElementException {
		if(isEmpty())
			throw new NoSuchElementException("This deque is empty.\n");
		final Node<E> f = front;
		return f.data;
	}

	/**
	 * This method retrieves, but does not remove, the last element of this deque.
	 *
	 * @return the tail of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E getLast() throws NoSuchElementException {
		if(isEmpty())
			throw new NoSuchElementException("This deque is empty.\n");
		final Node<E> r = rear;
		return r.data;
	}

	/**
	 * This method retrieves, but does not remove, the first element of this deque,
	 * or returns null if this deque is empty.
	 *
	 * @return the head of this deque, or null if this deque is empty
	 */
	@Override
	public E peekFirst() {
		if(isEmpty())
			return null;
		final Node<E> f = front;
		return f.data;
	}

	/**
	 * This method retrieves, but does not remove, the last element of this deque,
	 * or returns null if this deque is empty.
	 *
	 * @return the tail of this deque, or null if this deque is empty
	 */
	@Override
	public E peekLast() {
		if(isEmpty())
			return null;
		final Node<E> r = rear;
		return r.data;
	}

	/**
	 * This method removes the first occurrence of the specified element from this deque.
	 * If the deque does not contain the element, it is unchanged.
	 * This method returns true if this deque contained the specified element

	 * @param o element to be removed from this deque, if present
	 * @return true if an element was removed as a result of this call
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean removeFirstOccurrence(Object o) {
		E item = (E) o;

		for(Node<E> temp = front; temp != null; temp = temp.next){
			if(temp.data.equals(item)){
				removeNode(temp);
				size--;
				return true;
			}
		}
		
		return false;
	}

	private void removeNode(Node<E> node){
		final Node<E> prev = node.prev;
		final Node<E> next = node.next;

		if(prev == null)
			front = next;
		else
			prev.next = next;

		if(next == null)
			rear = prev;
		else
			next.prev = prev;

		addRemoves(node);
	}

	/**
	 * This method removes the last occurrence of the specified element from this deque.
	 * If the deque does not contain the element, it is unchanged.
	 * This method returns true if this deque contained the specified element

	 * @param o element to be removed from this deque, if present
	 * @return true if an element was removed as a result of this call
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean removeLastOccurrence(Object o) {
		E item = (E) o;

		for(Node<E> temp = rear; temp != null; temp = temp.prev){
			if(temp.data.equals(item)){
				removeNode(temp);
				size--;
				return true;
			}
		}
		return false;
	}


	/**
	 * This method inserts the specified element at the end of this deque and it
	 * throws an IllegalStateException if the element cannot be added.
	 *
	 * @param e the element to add
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 */
	public boolean add(E e) throws NullPointerException{
		if( e == null )
			throw new NullPointerException();
		return offerLast(e);
	}

	/**
	 * This method inserts the specified element into the deque
	 * (in other words, at the tail of this deque)
	 *
	 * @param e the element to add
	 * @return true if the element was added to this deque, else false
	 */
	@Override
	public boolean offer(E e) {
		return offerLast(e);
	}

	/**
	 * Retrieves and removes the front of the deque
	 * (in other words, the first element of this deque).
	 *
	 * @return the front of the deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E remove() throws NoSuchElementException {
		return removeFirst();
	}

	/**
	 * Retrieves and removes the front of the deque
	 * (in other words, the first element of this deque),
	 * or returns null if this deque is empty.
	 *
	 * @return the first element of this deque, or null if
	 *         this deque is empty
	 */
	@Override
	public E poll() {
		return pollFirst();
	}

	/**
	 * Retrieves, but does not remove, the front of the deque
	 * (in other words, the first element of this deque).
	 *
	 * @return the front of the deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E element() throws NoSuchElementException {
		return getFirst();
	}

	/**
	 * Retrieves, but does not remove, the front of the deque
	 * (in other words, the first element of this deque),
	 * or returns null if this deque is empty.
	 *
	 * @return the front of the deque, or
	 *         null if this deque is empty
	 */
	@Override
	public E peek() {
		return peekFirst();
	}

	/**
	 * Pushes an element onto the deque
	 * (in other words, at the front of this deque)
	 *
	 * @param e the element to push
	 * @throws NullPointerException if the specified element is null and this
	 *         deque does not permit null elements
	 */
	@Override
	public void push(E e)throws NullPointerException {
		addFirst(e);
	}

	/**
	 * Pops an element from the deque.
	 * In other words, removes and returns the first element of this deque.
	 *
	 * @return the element at the front of this deque
	 * @throws NoSuchElementException if this deque is empty
	 */
	@Override
	public E pop() throws NoSuchElementException{
		return removeFirst();
	}

	/**
     * Returns an iterator over the elements in this deque in reverse
     * sequential order.  The elements will be returned in order from
     * last (tail) to first (head).
     *
     * @return an iterator over the elements in this deque in reverse
     * sequence
     */
	@Override
	public Iterator<E> descendingIterator() {
		return new DescendingIterator<E>();
	}

	/**
	 * @author Seyda Ozer
	 *
	 * @param <E> This is type of the data of the Queue class.
	 */
	private class DescendingIterator<E> implements Iterator<E> {
	    /**
	     * Adapter to provide descending iterators via MyIterator.previous
	     */
		private final MyIterator<E> iterator = new MyIterator<>(size()-1);
		/**
         * This method returns true if this iterator has more elements
         * when traversing the deque in the reverse direction.
         * @return true if the iterator has more elements.
         */
		@Override
		public boolean hasNext() {
			return iterator.hasPrevious();
		}
		/**
         * This method returns the previous element in the deque.
         * @return previous element
         * @throws NoSuchElementException if the iteration has no previous
		 *         element
         */
		@Override
		public E next() throws NoSuchElementException {
			return iterator.previous();
		}
		/**
		 * This method is not supported by this iterator.
		 * @throws UnsupportedOperationException if the remove
		 *         operation is not supported by this iterator
		 */
		@Override
		public void remove() throws UnsupportedOperationException {
			iterator.remove();
		}
	}

    /**
     * Returns an iterator over the elements in this deque in proper sequence.
     * The elements will be returned in order from first (head) to last (tail).
     *
     * @return an iterator over the elements in this deque in proper sequence
     */
	@Override
	public Iterator<E> iterator() {
		return new MyIterator<>();
	}

    /**
     * Returns the number of elements in this deque.
     *
     * @return the number of elements in this deque
     */
	@Override
	public int size() {
		return size;
	}

	/**
     * This method returns true if the deque is empty.
     * @return true if the deque is empty.
     */
	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	 /**
     * Returns a string representation of this deque.  The string
     * representation consists of a list of the deque's elements in the
     * order they are returned by its iterator.
     * @return a string representation of this deque
     */
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		MyIterator<E> iter = new MyIterator<>();
		sb.append("[ ");

		while(iter.hasNext())
			sb.append(iter.next() + " ");

		sb.append(']');
		
		return sb.toString();
	}

}
