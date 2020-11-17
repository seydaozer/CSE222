
/**
 * @author Seyda Ozer
 * Implements the insertion sort algorithm.
 */
public class InsertionSort {

	/** Sort the table using insertion sort algorithm.
	 * pre: table contains Comparable objects.
	 * post: table is sorted.
	 * @param <T> The type of the elements of the array
	 * @param table The array to be sorted
	 */
	public static <T extends Comparable<T>> void sort(T[] table) {
		for(int nextPos = 1; nextPos < table.length; nextPos++) {
			// Invariant: table[0 . . . nextPos - 1] is sorted.
			// Insert element at position nextPos
			// in the sorted subarray.
			insert(table, nextPos);
		} // End for.
	} // End sort.
	
	/** Insert the element at nextPos where it belongs
	 *  in the array.
	 *  pre: table[0 . . . nextPos - 1] is sorted.
	 *  post: table[0 . . . nextPos] is sorted.
	 * @param <T> The type of the elements of the array
	 * @param table The array being soerted
	 * @param nextPos The position of the element to insert
	 */
	private static <T extends Comparable<T>> void insert(T[] table,
														 int nextPos) {
		T nextVal = table[nextPos]; // Element to insert.
		while(nextPos > 0
			  && nextVal.compareTo(table[nextPos - 1]) < 0) {
			table[nextPos] = table[nextPos - 1]; // Shift down.
			nextPos--;  // Check next smaller element.
		}
		// Insert nextVal at nextPos.
		table[nextPos] = nextVal;
	}
}
