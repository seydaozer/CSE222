import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author  Seyda Ozer
 *			171044023
 * @param <E> This is type of the data for the LinkedArrayList.
 */
public class LinkedArrayList<E> extends AbstractList<E> implements List<E> {
    /**
     * The int value is the size of the array in a Node.
     */
    private final int array_size = 5;
    /**
     * The int value is the size of the LinkedArrayList.
     */
    private int size;
    /**
     * This Node is the head of the LinkedArrayList.
     */
    private Node<E> head;
    /**
     * This Node is the tail of the LinkedArrayList.
     */
    private Node<E> tail;
    /**
     * This is type of the data for the LinkedArrayList.
     */
    private Class<E> type;

    /**
     * LinkedArrayList Constructor
     * @param _type This is type of the LinkedArrayList's data.
     */
    public LinkedArrayList(Class<E> _type){
        size = 0;
        head = null;
        tail = null;
        type = _type;
    }

    /**
     * Node Class
     * @param <E> This is type of the data for the Node.
     */
    private static class Node<E>{
        /**
         * The array of data for the LinkedArrayList
         */
        private E [] data;
        /**
         * The int value is the capacity of the data array.
         */
        private int capacity;
        /**
         * The int value is number of used size in the data array.
         */
        private int used;
        /**
         * This is next node for the current node.
         */
        private Node<E> next;
        /**
         * This is previous node for the current node.
         */
        private Node<E> prev;

        /**
         * Node Constructor
         * @param type of the array's data.
         * @param size int value of the capacity.
         */
        private Node(Class<E> type, int size) {
            capacity = size;
            used = 0;
            next = null;
            prev = null;
            data = (E[])(Array.newInstance(type, capacity));
        }

        /**
         * Node Constructor
         * @param type of the array's data.
         * @param size int value of the capacity.
         * @param dataItem one element for the array.
         */
        private Node(Class<E> type, int size, E dataItem) {
            this(type, size, null, dataItem, null);
        }

        /**
         * Node Constructor
         * @param type of the array's data.
         * @param size int value of the capacity.
         * @param prevNode of the previous node for the current node.
         * @param dataItem one element for the array.
         * @param nextNode of the next node for the current node.
         */
        private Node(Class<E> type, int size, Node<E> prevNode, E dataItem, Node<E> nextNode) {
            capacity = size;
            used = 1;
            next = nextNode;
            prev = prevNode;
            data = (E[])(Array.newInstance(type, capacity));
            data[0] = dataItem;
        }

        /**
         * This method adds a element to array.
         * @param element to be added.
         * @return returns true if the element is added.
         */
        private boolean addElement(E element){
            if(isFull())
                return false;

            data[used] = element;
            used++;

            return true;
        }

        /**
         * This method inserts to array one element with shifting.
         * @param index of the element.
         * @param element to be added.
         */
        private void addWithShifting(int index, E element){
            if( used == capacity )
                used--;

            for(int i = used; i > index; i--)
                data[i] = data[i-1];

            data[index] = element;
            used++;
        }

        /** This method deletes the element at the index.
         * @param index of the element to be removed.
         */
        private void remove(int index){
            for(int i=index; i<used-1; i++)
                data[i] = data[i+1];

            used--;
        }

        /**
         * This method returns true if the array in the node is full.
         * @return returns true if the array in the node is full.
         */
        private boolean isFull(){
            return used == capacity;
        }

        /**
         * This method gets the element at the index.
         * @param index of the element.
         * @return returns an element.
         */
        private E getElement(int index){
            return data[index];
        }

        /**
         * This method sets the data for the index.
         * @param index of the index to be set.
         * @param element of the new element.
         */
        private void setElement(int index, E element){
            data[index] = element;
        }

        /**
         * This method returns a string representation of the node object.
         * @return a string representation of the node object.
         */
        @Override
        public String toString(){
            StringBuilder s = new StringBuilder();
            for(int i=0; i<used; i++){
                s.append(data[i]);
                if(i != used - 1)
                    s.append(" - ");
            }
            return s.toString();
        }

        /**
         * This method returns the used size in the node.
         * @return returns number of the used.
         */
        private int getUsed(){ return used; }

    }// End of the NODE CLASS

    /**
     * MyIterator Class
     * @param <E> This is type of the data for the MyIterator.
     */
    public class MyIterator<E> implements ListIterator<E> {
        /**
         * Index of element in the current node.
         */
        int position;
        /**
         * Index of element in the LinkedArrayList.
         */
        int indexOfList;
        /**
         * Index of node.
         */
        int nodePosition;
        /**
         * The first node.
         */
        Node<E> node = (Node<E>) head;
        /**
         * the size of array in the current node.
         */
        int arraySize;

        /**
         * MyIterator Constructor
         */
        public MyIterator(){
            nodePosition = 0;
            position = -1;
            indexOfList = -1;
            arraySize = node.getUsed();
        }

        /** MyIterator Constructor
         * @param index of the current index.
         */
        public MyIterator(int index){
            if(index == 0){
                nodePosition = 0;
                position = -1;
                indexOfList = -1;
                arraySize = node.getUsed();
                return;
            }
            nodePosition = 0;
            arraySize = node.getUsed();
            position = findPosition(index);
            indexOfList = index;
        }

        /**
         * This method finds the current position of node and position of element in the node.
         * @return returns the position for the current element's position.
         */
        private int findPosition(int index){
            Node<E> temp = node;
            int used = 0; // number of the used size of the nodes in the list
            int bound = temp.getUsed(); // size of the current node
            int count = 0; // index of the current node

            for(int i=0; i<index; i++) {
                if(count == bound - 1){ // end of the current node
                    used += bound;

                    temp = temp.next;
                    nodePosition++;

                    bound = temp.getUsed();
                    count = 0;
                }
                count++;
            }

            return (index - used); // return position
        }

        /**
         * This method returns true if this iterator has more elements
         *  when traversing the list in the forward direction.
         * @return true if the iterator has more elements.
         */
        @Override
        public boolean hasNext() {
            if(node != tail)
                return true;

            else return position < tail.getUsed() - 1;

        }

        /**
         * This method returns true if this iterator has more elements
         * when traversing the list in the reverse direction.
         * @return true if the iterator has more elements.
         */
        @Override
        public boolean hasPrevious() {
            if (currentNode() != head)
                return true;
            else return position > 0;
        }

        /**
         * This method finds the current node and returns it.
         * @return returns current node.
         */
        public Node<E> currentNode(){
            return node;
        }

        /**
         * This method returns the next element in the LinkedArrayList.
         * @return next element
         */
        @Override
        public E next(){
            position++;
            indexOfList++;

            if(position == arraySize){ // end of the current node
                if(node == tail) // if node will equal to its next, this node should not equal to the tail.
                    return null;

                node = node.next;
                nodePosition++;

                arraySize = node.getUsed();
                position = 0;
            }

            return node.getElement(position);
        }

        /**
         * This method returns the previous element in the LinkedArrayList.
         * @return previous element
         */
        @Override
        public E previous(){
            position--;
            indexOfList--;

            if(position == -1){ // it is the time of the back to the previous node

                if(node == head) // if node will equal to its previous, this node should not equal to the head.
                    return null;

                node = node.prev;
                nodePosition--;

                arraySize = node.getUsed();
                position = arraySize - 1;
            }

            return node.getElement(position);
        }

        /**
         * This method returns the index of the next element.
         * It returns the size if the iterator at the end of the LinkedArrayList.
         * @return index of the next element
         */
        @Override
        public int nextIndex(){
            if(node == tail && position == node.getUsed())
                return size();

            int next = indexOfList + 1;

            return next;
        }

        /**
         * This method returns the index of the previous element.
         * It returns -1 if the iterator at the beginning of the LinkedArrayList.
         * @return index of the previous element
         */
        @Override
        public int previousIndex(){
            if(node == head && position == 0)
                return -1;

            int prev = indexOfList - 1;

            return prev;
        }

        /**
         * This method removes from the list the last element
         */
        @Override
        public void remove() {
            node.remove(position);
            if(node.getUsed() == 0) {
                node = node.prev;
                position = node.getUsed()-1;
                indexOfList--;
            }
        }

        /**
         * This method replaces the last element returned with the specified element.
         * @param e the element with which to replace the last element.
         */
         @Override
        public void set(E e) {
            node.setElement(position, e);
        }

        /**
         * This method inserts the specified element into the list
         * @param e the element to insert
         * @throws UnsupportedOperationException if the current node is full,
         * this method is not supported by this iterator.
         */
        @Override
        public void add(E e) throws UnsupportedOperationException {
            if( !(node.isFull()) )
                node.addWithShifting(position, e);
            else
                throw new UnsupportedOperationException();
        }

        /**
         * This method returns the current element in the LinkedArrayList.
         * @return current element
         */
        public E current(){
            return node.getElement(position);
        }

    }// end of the ITERATOR CLASS

    /**
     *This method returns the number of elements in the LinkedArrayList.
     *@return the number of elements
     */
    @Override
    public int size() {
        return this.size;
    }

    /**
     * This method returns true if this LinkedArrayList contains no elements.
     * @return true if this LinkedArrayList is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * This method add the specified element to the end of this LinkedArrayList.
     * @param element to be added
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public boolean add(E element) throws IndexOutOfBoundsException {
        add(size, element);
        return true;
    }

    /**
     * This method returns the element at the specified position in this LinkedArrayList.
     * @param index index of the element to return
     * @return the element at the specified position in this LinkedArrayList
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E get(int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);

        MyIterator<E> iter = new MyIterator<>();

        for (int i = 0; i <= index; i++)
            iter.next();

        E element = iter.current();

        return element;
    }

    /**
     * This method replaces the element at the specified position in this LinkedArrayList
     * with the specified element.
     * @param index index of the element to replace
     * @param element element to be stored at the specified position
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E set(int index, E element) throws IndexOutOfBoundsException {
        checkElementIndex(index);

        MyIterator<E> iter = new MyIterator<>();

        for(int i=0; i <= index; i++)
            iter.next();

        E data = iter.current(); // this data is the old value on the index.

        iter.set(element);

        return data;
    }

    /**
     * This method add the specified element to the beginning of this LinkedArrayList.
     * @param element to be added
     */
    public void addFirst(E element){
        if(isEmpty()){ // LinkedArrayList is empty.
            Node<E> newNode = new Node<>(type, array_size,null, element, head);
            head = newNode;
            tail = newNode;
        }
        else{ // LinkedArrayList is not empty.
            Node<E> first = head;

            if(first.isFull()){ // this node is full
                E data = first.getElement(array_size - 1);
                first.addWithShifting(0, element);

                Node<E> newNode = new Node<>(type, array_size, first, data, first.next);

                first.next = newNode;
                tail = newNode;
            }
            else // this node is empty
                first.addWithShifting(0, element);
        }
        size++;
    }

    /**
     * This method add the specified element to this LinkedArrayList.
     * (not beginning or end of this LinkedArrayList)
     * @param index index at which the specified element is to be inserted
     * @param element to be added
     */
    public void addMiddle(int index, E element){
        MyIterator<E> iter = new MyIterator<>();

        int count = -1; // this counter is the index of the current node.
        Node<E> temp = head;

        for(int i=0; i <= index; i++) {
            iter.next();

            if(temp != iter.currentNode()) {
                temp = iter.currentNode(); // if the iterators's current node is changes, temp will be equal to it.
                count = -1; // and the counter starts again.
            }

            count++;
        }

        Node<E> current = iter.currentNode();

        if(current.isFull()){ // this node is full
            E data = current.getElement(array_size - 1);
            current.addWithShifting(count, element);

            Node<E> newNode = new Node<>(type, array_size, current, data, current.next);
            current.next = newNode;
            if(current == head)
                tail = newNode;
        }
        else // this node is empty
            current.addWithShifting(count, element);

        size++;
    }

    /**
     * This method add the specified element to the end of this LinkedArrayList.
     * @param element to be added
     */
    public void addLast(E element){
        Node<E> temp = tail;

        boolean flag = temp.addElement(element); // if it is true, the element is added.

        if(flag == false) { // when the element is not added, a new node will be created.
            Node<E> newNode = new Node<>(type, array_size, temp, element, null);
            temp.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * This method inserts the specified element at the specified position in this LinkedArrayList.
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public void add(int index, E element) throws IndexOutOfBoundsException {
        checkElementIndex(index);

        if (index == 0)
            addFirst(element);
        else if (index == size)
            addLast(element);
        else
            addMiddle(index, element);

    }

    /**
     * This method removes the first occurrence of the specified element from this LinkedArrayList.
     * @param o element to be removed from this list, if present
     * @return true if this list contained the specified element
     */
    @Override
    public boolean remove(Object o) {
        E obj = (E) o;

        E removed = null;

        int index = indexOf(obj);

        if(indexOf(obj) != -1)
            removed = remove(index);

        if(removed == obj)
            return true;

        return false;
    }

    /**
     * This method removes the element at the specified position in this LinkedArrayList.
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public E remove(int index) throws IndexOutOfBoundsException {
        checkElementIndex(index);

        E removed = get(index); // it is element to be removed.

        MyIterator<E> iter = new MyIterator<>();
        for(int i=0; i<=index; i++)
            iter.next();

        Node<E> temp1 = iter.currentNode();

        iter.remove();
        size--;

        Node<E> temp2 = iter.currentNode();

        if(temp1.next != null)
            temp2.next = temp1.next;
        else {
            temp2.next = null;
            tail = temp2;
        }

        return removed;
    }

    /**
     * This method returns the index of the first occurrence of the specified element
     * in this LinkedArrayList, or -1 if this LinkedArrayList does not contain the element.
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     * this list, or -1 if this list does not contain the element
     */
    @Override
    public int indexOf(Object o) {
        E item = (E) o;

        MyIterator<E> iter = new MyIterator<>();
        int index = 0;

        while(iter.hasNext()){
            iter.next();

            if(iter.current() == item)
                return index;

            index++;
        }

        return -1;
    }

    /**
     * This method returns a string representation of the LinkedArrayList object.
     * @return a string representation of the LinkedArrayList object.
     */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        s.append("My List :\n");

        MyIterator<E> iter = new MyIterator<>();
        Node<E> temp = iter.currentNode();
        s.append(temp);

        while(iter.hasNext()){
            iter.next();
            if(temp != iter.currentNode()) {
                s.append(" - ");
                s.append(iter.currentNode());
                temp = iter.currentNode();
            }
        }

        s.append("\n");
        return s.toString();
    }

    /**
     * Returns a MyIterator over the elements in this LinkedArrayList,
     * starting at the specified position in the list.
     * @param index index of the first element to be returned from the MyIterator
     * @return a MyIterator over the elements in this LinkedArrayList,
     * starting at the specified position in the LinkedArrayList
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    @Override
    public ListIterator<E> listIterator(final int index) {
        checkElementIndex(index);
        return new MyIterator<>(index);
    }

    /**
     * This method checks if the index is out of bounds.
     * @param index to be checked
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private void checkElementIndex(int index) throws IndexOutOfBoundsException {
        if ( index < 0 || index > size )
            throw new IndexOutOfBoundsException(Integer.toString(index));
    }

}
