import java.util.LinkedList;

/**
 * @author Seyda Ozer
 * Implements the quicksort algorithm.
 */
public class MyQuickSort {
	
	/** Sort the table using the quicksort algorithm.
	 * pre: table contains Comparable objects.
	 * post: table is sorted.
	 * @param <T> The type of the elements of the linked list
	 * @param table The linked list to be sorted
	 */
	public static <T extends Comparable<T>> void sort(LinkedList<T> table) {
		// Sort the whole table.
		quickSort(table, 0, table.size() - 1);
	}
	
	/** Sort a part of the table using the quicksort algorithm.
	 * post: The part of table from first through last is sorted.
	 * @param <T> The type of the elements of the linked list
	 * @param table The linked list to be sorted
	 * @param first The index of the low bound
	 * @param last The index of the high bound
	 */
	private static <T extends Comparable<T>> void quickSort(LinkedList<T> table,
															int first,
															int last) {
		if(first < last) { 	// There is data to be sorted.
			// Partition the table.
			int pivIndex = partition(table, first, last);
			// Sort the left half.
			quickSort(table, first, pivIndex - 1);
			// Sort the right half.
			quickSort(table, pivIndex + 1, last);	
		}
	}
	
	/** Partition the table so that values from first to pivIndex
	 * are less than or equal to the pivot value, and values from
	 * pivIndex to last are greater than the pivot value.
	 * @param <T> The type of the elements of the linked list
	 * @param table The table to be partitioned
	 * @param first The index of the low bound
	 * @param last The index of the high bound
	 * @return The location of the pivot value
	 */
	private static <T extends Comparable<T>> int partition(LinkedList<T> table,
															int first,
														   	int last) {
		/* Put the median of table[first], table[middle], table[last]
		 * into table[first], and use this value as the pivot.
		 */
		bubbleSort3(table, first, last);
		// Swap first element with median.
		swap(table, first, (first + last) / 2);
		
		T pivot = table.get(first);
		int up = first;
		int down = last;
		do {
			/* Invariant:
			 * All items in table[first . . . up - 1] <= pivot
			 * All items in table[down + 1 . . . last] £ pivot
			 */
			while( (up < last) && (pivot.compareTo(table.get(up)) >= 0) ) {
				up++;
			}
			// assert: up equals last or table[up] > pivot.
			while(pivot.compareTo(table.get(down)) < 0) {
				down--;
			}
			// assert: down equals first or table[down] <= pivot.
			if(up < down) { // if up is to the left of down.
				// Exchange table[up] and table[down].
				swap(table, up, down);
			}
		} while(up < down); // Repeat while up is left of down.
		// Exchange table[first] and table[down] thus putting the
		// pivot value where it belongs.
		swap(table, first, down);
		// Return the index of the pivot value.
		return down;
	}
	
	/** Sort table[first], table[middle], and table[last].
	 * @param <T> The type of the elements of the linked list
	 * @param table The table to be sorted
	 * @param first Index of the first element
	 * @param last Index of the last element
	 */
	private static <T extends Comparable<T>> void bubbleSort3(LinkedList<T> table,
																int first,
																int last) {
		int middle = (first + last) / 2;
		/* Perform bubble sort in table[first], table[middle], table[last]. */
		if(table.get(middle).compareTo(table.get(first)) < 0) {
			swap(table, first, middle);
		}
		// assert: table[first] <= table[middle]
		if(table.get(last).compareTo(table.get(middle)) < 0) {
			swap(table, middle, last);
		}
		// assert: table[last] is the largest value of the three.
		if(table.get(middle).compareTo(table.get(first)) < 0) {
			swap(table, first, middle);
		}
		// assert: table[first] <= table[middle] <= table[last].
	}
	
	/** Swap the items in table[i] and table[j].
	 * @param <T>
	 * @param table The linked list that contains the items
	 * @param i The index of one item
	 * @param j The index of the other item
	 */
	private static <T extends Comparable<T>> void swap(LinkedList<T> table, int i, int j) {
		T temp = table.get(i);
		table.set(i, table.get(j));
		table.set(j, temp);
	}
}
