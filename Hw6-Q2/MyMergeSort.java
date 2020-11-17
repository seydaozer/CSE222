import java.util.LinkedList;

/**
 * @author Seyda Ozer
 * Implements the recursive merge sort algorithm. In this version, copies
 * of the subtables are made, sorted, and then merged.
 */
public class MyMergeSort {

	/** Sort the linked list using the merge sort algortihm.
	 * pre: table contains Comparable objects.
	 * post: table is sorted.
	 * @param <T> The type of the elements of the linked list
	 * @param table The linked list to be sorted
	 */
	public static <T extends Comparable<T>> void sort(LinkedList<T> table) {
		// A table with one element is sorted already.
		if(table.size() > 1) {
			// Split table into halves.
			int halfSize = table.size() / 2;
			LinkedList<T> leftTable = new LinkedList();
			LinkedList<T> rightTable = new LinkedList();
			for(int i = 0; i < halfSize; i++) {
				leftTable.add(table.get(i));
			}
			for(int i = halfSize; i < table.size(); i++) {
				rightTable.add(table.get(i));
			}
			// Sort the halves.
			sort(leftTable);
			sort(rightTable);
			
			// Merge the halves.
			merge(table, leftTable, rightTable);
		}
	}
	
	/** Merge two sequences.
	 * pre: leftSequence and rightSequence are sorted.
	 * post: outputSequence is the merged result and is stored.
	 * @param <T> The type of the elements of the linked list
	 * @param outputSequence The destination
	 * @param leftSequence The left input
	 * @param rightSequence The right input
	 */
	private static <T extends Comparable<T>> void merge(LinkedList<T> outputSequence, 
														LinkedList<T> leftSequence,
														LinkedList<T> rightSequence) {
		int i = 0; // Index into the left input sequence.
		int j = 0; // Index into the right input sequence.
		int k = 0; // Index into the output sequence.
		// While there is data in both input sequences
		while(i < leftSequence.size() && j < rightSequence.size()) {
		// Find the smaller and
		// insert it into the output sequence.
			if(leftSequence.get(i).compareTo(rightSequence.get(j)) < 0) {
				T element = leftSequence.get(i);
				outputSequence.set(k, element);
				k++;
				i++;
			} else {
				T element = rightSequence.get(j);
				outputSequence.set(k, element);
				k++;
				j++;
			}
		}
		// assert: one of the sequences has more items to copy.
		// Copy remaining input from left sequence into the output.
		while(i < leftSequence.size()) {
			T element = leftSequence.get(i);
			outputSequence.set(k, element);
			k++;
			i++;
		}
		// Copy remaining input from right sequence into the output.
		while(j < rightSequence.size()) {
			T element = rightSequence.get(j);
			outputSequence.set(k, element);
			k++;
			j++;
		}
	}
}
