import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @author Seyda Ozer
 * Test Class for the Deque Class
 */
public class Test {
	/**
     * This main method of this application.
     * @param args array of string arguments.
     */
	public static void main(String [] args) {
		MyDeque<Integer> deque = new MyDeque<Integer>();
		
		//Deque is empty//
		if(deque.isEmpty())	System.out.println("This deque is empty.");
		else	System.out.println("This deque is not empty.");
		
		System.out.println();
		
		System.out.println(deque.peek());
		
		System.out.println();
		
		System.out.println(deque.peekFirst());
		
		System.out.println();
		
		System.out.println(deque.peekLast());
		
		System.out.println();
		
		System.out.println(deque.poll());
		
		System.out.println();
		
		System.out.println(deque.pollFirst());
		
		System.out.println();
		
		System.out.println(deque.pollLast());
		
		System.out.println();
		

		try {
			deque.getFirst();
		} catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
		try {
			deque.getLast();
		} catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
		try {
			deque.element();
		} catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
		try {
			deque.removeFirst();
		} catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
		try {
			deque.removeLast();
		} catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
		try {
			deque.remove();
		} catch(NoSuchElementException e) {
			System.out.println(e);
		}
		
		deque.offerFirst(1);
		System.out.println(deque);
		
		deque.offerFirst(null);
		System.out.println(deque);
		
		deque.offerFirst(2);
		System.out.println(deque);

		
		try {
		deque.addFirst(3);
		System.out.println(deque);

		deque.addFirst(null);
		System.out.println(deque);
		
		deque.addFirst(4);
		System.out.println(deque);
		} catch(NullPointerException e) {
			System.out.println(e);
		}
		
		deque.offerLast(5);
		System.out.println(deque);

		deque.offerLast(null);
		System.out.println(deque);
		
		deque.offerLast(6);
		System.out.println(deque);
		
		try {
		deque.addLast(7);
		System.out.println(deque);

		deque.addLast(null);
		System.out.println(deque);
		deque.addLast(8);
		
		System.out.println(deque);
		} catch(NullPointerException e) {
			System.out.println(e);
		}
		
		System.out.println();
		
		System.out.println("The front element of the deque: " + deque.peekFirst());
		
		System.out.println("The rear element of the deque: " + deque.peekLast());

		System.out.println("The element of the deque: " + deque.peek());
		
		System.out.println();
		
		System.out.println();
		
		System.out.println("The front element of the deque: " + deque.getFirst());
		
		System.out.println("The rear element of the deque: " + deque.getLast());

		System.out.println("The element of the deque: " + deque.element());
		
		System.out.println();
		

		deque.pollFirst();
		System.out.println(deque);

		deque.pollLast();
		System.out.println(deque);
		
		deque.poll();
		System.out.println(deque);
		
		deque.removeFirst();
		System.out.println(deque);
		
		deque.removeLast();
		System.out.println(deque);
		
		deque.add(9);
		System.out.println(deque);
		
		deque.remove();
		System.out.println(deque);
		
		deque.offerFirst(10);
		deque.offerLast(11);
		deque.offerFirst(11);
		deque.offerLast(10);
		deque.offerFirst(9);
		deque.offerLast(10);
		System.out.println(deque);
		
		if(deque.removeFirstOccurrence(10))
			System.out.println("The element 10 is removed");
		else
			System.out.println("The element 10 is not removed");
		System.out.println(deque);
		
		if(deque.removeFirstOccurrence(1))
			System.out.println("The element 1 is removed");
		else
			System.out.println("The element 1 is not removed");
		System.out.println(deque);
		
		if(deque.removeLastOccurrence(11))
			System.out.println("The element 11 is removed");
		else
			System.out.println("The element 11 is not removed");
		System.out.println(deque);
		
		if(deque.removeFirstOccurrence(2))
			System.out.println("The element 2 is removed");
		else
			System.out.println("The element 2 is not removed");
		System.out.println(deque);
		
		System.out.println();
		
		Iterator<Integer> iter = deque.iterator();
		System.out.print("My deque: ");
		while(iter.hasNext())
			System.out.print(iter.next() + " ");
		
		Iterator<Integer> descIter = deque.descendingIterator();
		System.out.print("\nMy deque: ");
		while(descIter.hasNext())
			System.out.print(descIter.next() + " ");
		
}
	
}
