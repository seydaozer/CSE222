import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

public class TestSortAlgorithms {

	/** Driver program to test sorting methods.
	 * @param args Not used
	 */
	public static void main(String [] args) {
		int size1 = 10000;
		int size2 = 40000;
		int size3 = 100000;
		int size4 = 150000;
		int size5 = 180000;
		
		//int size = size1;
		int size = size2;
		//int size = size3;
		//int size = size4;
		//int size = size5;
		
		Integer[] array1 = new Integer[size];
		Integer[] array2 = new Integer[size];
		Integer[] array3 = new Integer[size];
		Integer[] array4 = new Integer[size];
		Integer[] array5 = new Integer[size];
		Integer[] array6 = new Integer[size];
		Integer[] array7 = new Integer[size];
		Integer[] array8 = new Integer[size];
		Integer[] array9 = new Integer[size];
		Integer[] array10 = new Integer[size];
		Integer[] array11 = new Integer[size];
		Integer[] array12 = new Integer[size];
		Integer[] array13 = new Integer[size];
		Integer[] array14 = new Integer[size];
		Integer[] array15 = new Integer[size];
		Integer[] array16 = new Integer[size];
		Integer[] array17 = new Integer[size];
		Integer[] array18 = new Integer[size];
		Integer[] array19 = new Integer[size];
		Integer[] array20 = new Integer[size];
		
		Integer[] copy1 = new Integer[size];
		Integer[] copy2 = new Integer[size];
		Integer[] copy3 = new Integer[size];
		Integer[] copy4 = new Integer[size];
		Integer[] copy5 = new Integer[size];
		Integer[] copy6 = new Integer[size];
		Integer[] copy7 = new Integer[size];
		Integer[] copy8 = new Integer[size];
		Integer[] copy9 = new Integer[size];
		Integer[] copy10 = new Integer[size];
		Integer[] copy11 = new Integer[size];
		Integer[] copy12 = new Integer[size];
		Integer[] copy13 = new Integer[size];
		Integer[] copy14 = new Integer[size];
		Integer[] copy15 = new Integer[size];
		Integer[] copy16 = new Integer[size];
		Integer[] copy17 = new Integer[size];
		Integer[] copy18 = new Integer[size];
		Integer[] copy19 = new Integer[size];
		Integer[] copy20 = new Integer[size];

		LinkedList<Integer> list = new LinkedList<Integer>();
		
		Random rInt = new Random(); // For random number generation
		
		for(int i = 0; i<array1.length; i++) {
			array1[i] = rInt.nextInt();
			copy1[i] = array1[i];
		}
		for(int i = 0; i<array2.length; i++) {
			array2[i] = rInt.nextInt();
			copy2[i] = array2[i];
		}
		for(int i = 0; i<array3.length; i++) {
			array3[i] = rInt.nextInt();
			copy3[i] = array3[i];
		}
		for(int i = 0; i<array4.length; i++) {
			array4[i] = rInt.nextInt();
			copy4[i] = array4[i];
		}
		for(int i = 0; i<array5.length; i++) {
			array5[i] = rInt.nextInt();
			copy5[i] = array5[i];
		}
		for(int i = 0; i<array6.length; i++) {
			array6[i] = rInt.nextInt();
			copy6[i] = array6[i];
		}
		for(int i = 0; i<array7.length; i++) {
			array7[i] = rInt.nextInt();
			copy7[i] = array7[i];
		}
		for(int i = 0; i<array8.length; i++) {
			array8[i] = rInt.nextInt();
			copy8[i] = array8[i];
		}
		for(int i = 0; i<array9.length; i++) {
			array9[i] = rInt.nextInt();
			copy9[i] = array9[i];
		}
		for(int i = 0; i<array10.length; i++) {
			array10[i] = rInt.nextInt();
			copy10[i] = array10[i];
		}
		for(int i = 0; i<array11.length; i++) {
			array11[i] = rInt.nextInt();
			copy11[i] = array11[i];
		}
		for(int i = 0; i<array12.length; i++) {
			array12[i] = rInt.nextInt();
			copy12[i] = array12[i];
		}
		for(int i = 0; i<array13.length; i++) {
			array13[i] = rInt.nextInt();
			copy13[i] = array13[i];
		}
		for(int i = 0; i<array14.length; i++) {
			array14[i] = rInt.nextInt();
			copy14[i] = array14[i];
		}
		for(int i = 0; i<array15.length; i++) {
			array15[i] = rInt.nextInt();
			copy15[i] = array15[i];
		}
		for(int i = 0; i<array16.length; i++) {
			array16[i] = rInt.nextInt();
			copy16[i] = array16[i];
		}
		for(int i = 0; i<array17.length; i++) {
			array17[i] = rInt.nextInt();
			copy17[i] = array17[i];
		}
		for(int i = 0; i<array18.length; i++) {
			array18[i] = rInt.nextInt();
			copy18[i] = array18[i];
		}
		for(int i = 0; i<array19.length; i++) {
			array19[i] = rInt.nextInt();
			copy19[i] = array19[i];
		}
		for(int i = 0; i<array20.length; i++) {
			array20[i] = rInt.nextInt();
			copy20[i] = array20[i];
		}
		for(int i = 0; i<array1.length; i++) {
			list.add(copy1[i]);
		}
		
		long startTime;
		
		// Sorted Array ///
		Integer[] array0 = new Integer[size];
		for(int i = 0; i<array0.length; i++) {
			array0[i] = i + 1;
		}
		System.out.println("SORTED ARRAY");
		
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array0);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array0));
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array0);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array0));
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array0);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array0));
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array0);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array0));

		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array0);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array0));

		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array0);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array0));

		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array0);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array0));
		
		//copy
		for(int i = 0; i<array1.length; i++) {
			list.set(i, array0[i]);
		}
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		
		// 1. array //
		System.out.println("1. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array1);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array1));
		
		// copy
		for(int i = 0; i<array1.length; i++)
			array1[i] = copy1[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array1);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array1));
		
		// copy
		for(int i = 0; i<array1.length; i++)
			array1[i] = copy1[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array1);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array1));
	
		// copy
		for(int i = 0; i<array1.length; i++)
			array1[i] = copy1[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array1);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array1));

		// copy
		for(int i = 0; i<array1.length; i++)
			array1[i] = copy1[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array1);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array1));
		
		// copy
		for(int i = 0; i<array1.length; i++)
			array1[i] = copy1[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array1);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array1));

		// copy
		for(int i = 0; i<array1.length; i++)
			array1[i] = copy1[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array1);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array1));
		
		// copy
		for(int i = 0; i<array1.length; i++)
			list.set(i, copy1[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array1.length; i++)
			list.set(i, copy1[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//2. array//
		System.out.println("\n\n2. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array2);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array2));
		
		// copy
		for(int i = 0; i<array2.length; i++)
			array2[i] = copy2[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array2);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array2));
		
		// copy
		for(int i = 0; i<array2.length; i++)
			array2[i] = copy2[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array2);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array2));
	
		// copy
		for(int i = 0; i<array2.length; i++)
			array2[i] = copy2[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array2);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array2));

		// copy
		for(int i = 0; i<array2.length; i++)
			array2[i] = copy2[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array2);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array2));
		
		// copy
		for(int i = 0; i<array2.length; i++)
			array2[i] = copy2[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array2);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array2));

		// copy
		for(int i = 0; i<array2.length; i++)
			array2[i] = copy2[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array2);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array2));
		
		// copy
		for(int i = 0; i<array2.length; i++)
			list.set(i, copy2[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array2.length; i++)
			list.set(i, copy2[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//3. array//
		System.out.println("\n\n3. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array3);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array3));
		
		// copy
		for(int i = 0; i<array3.length; i++)
			array3[i] = copy3[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array3);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array3));
		
		// copy
		for(int i = 0; i<array3.length; i++)
			array3[i] = copy3[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array3);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array3));
	
		// copy
		for(int i = 0; i<array3.length; i++)
			array3[i] = copy3[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array3);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array3));

		// copy
		for(int i = 0; i<array3.length; i++)
			array3[i] = copy3[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array3);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array3));
		
		// copy
		for(int i = 0; i<array3.length; i++)
			array3[i] = copy3[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array3);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array3));

		// copy
		for(int i = 0; i<array3.length; i++)
			array3[i] = copy3[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array3);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array3));
	
		// copy
		for(int i = 0; i<array3.length; i++)
			list.set(i, copy3[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array3.length; i++)
			list.set(i, copy3[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
		///4. ARRAY///
		System.out.println("\n\n4. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array4);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array4));
		
		// copy
		for(int i = 0; i<array4.length; i++)
			array4[i] = copy4[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array4);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array4));
		
		// copy
		for(int i = 0; i<array4.length; i++)
			array4[i] = copy4[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array4);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array4));
	
		// copy
		for(int i = 0; i<array4.length; i++)
			array4[i] = copy4[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array4);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array4));

		// copy
		for(int i = 0; i<array4.length; i++)
			array4[i] = copy4[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array4);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array4));
		
		// copy
		for(int i = 0; i<array4.length; i++)
			array4[i] = copy4[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array4);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array4));

		// copy
		for(int i = 0; i<array4.length; i++)
			array4[i] = copy4[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array4);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array4));
		
		// copy
		for(int i = 0; i<array4.length; i++)
			list.set(i, copy4[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array4.length; i++)
			list.set(i, copy4[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		///5. ARRAY//
		System.out.println("\n\n5. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array5);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array5));
		
		// copy
		for(int i = 0; i<array5.length; i++)
			array5[i] = copy5[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array5);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array5));
		
		// copy
		for(int i = 0; i<array5.length; i++)
			array5[i] = copy5[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array5);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array5));
	
		// copy
		for(int i = 0; i<array5.length; i++)
			array5[i] = copy5[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array5);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array5));

		// copy
		for(int i = 0; i<array5.length; i++)
			array5[i] = copy5[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array5);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array5));
		
		// copy
		for(int i = 0; i<array5.length; i++)
			array5[i] = copy5[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array5);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array5));

		// copy
		for(int i = 0; i<array5.length; i++)
			array5[i] = copy5[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array5);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array5));
		
		// copy
		for(int i = 0; i<array5.length; i++)
			list.set(i, copy5[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array5.length; i++)
			list.set(i, copy5[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//6. array///
		System.out.println("\n\n6. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array6);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array6));
		
		// copy
		for(int i = 0; i<array6.length; i++)
			array6[i] = copy6[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array6);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array6));
		
		// copy
		for(int i = 0; i<array6.length; i++)
			array6[i] = copy6[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array6);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array6));
	
		// copy
		for(int i = 0; i<array6.length; i++)
			array6[i] = copy6[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array6);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array6));

		// copy
		for(int i = 0; i<array6.length; i++)
			array6[i] = copy6[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array6);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array6));
		
		// copy
		for(int i = 0; i<array6.length; i++)
			array6[i] = copy6[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array6);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array6));

		// copy
		for(int i = 0; i<array6.length; i++)
			array6[i] = copy6[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array6);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array6));
		
		// copy
		for(int i = 0; i<array6.length; i++)
			list.set(i, copy6[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array6.length; i++)
			list.set(i, copy6[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//7. array////
		System.out.println("\n\n7. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array7);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array7));
		
		// copy
		for(int i = 0; i<array7.length; i++)
			array7[i] = copy7[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array7);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array7));
		
		// copy
		for(int i = 0; i<array7.length; i++)
			array7[i] = copy7[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array7);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array7));
	
		// copy
		for(int i = 0; i<array7.length; i++)
			array7[i] = copy7[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array7);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array7));

		// copy
		for(int i = 0; i<array7.length; i++)
			array7[i] = copy7[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array7);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array7));
		
		// copy
		for(int i = 0; i<array7.length; i++)
			array7[i] = copy7[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array7);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array7));

		// copy
		for(int i = 0; i<array7.length; i++)
			array7[i] = copy7[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array7);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array7));
		
		// copy
		for(int i = 0; i<array7.length; i++)
			list.set(i, copy7[i]);
	
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array7.length; i++)
			list.set(i, copy7[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//8. array////
		System.out.println("\n\n8. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array8);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array8));
		
		// copy
		for(int i = 0; i<array8.length; i++)
			array8[i] = copy8[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array8);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array8));
		
		// copy
		for(int i = 0; i<array8.length; i++)
			array8[i] = copy8[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array8);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array8));
	
		// copy
		for(int i = 0; i<array8.length; i++)
			array8[i] = copy8[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array8);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array8));

		// copy
		for(int i = 0; i<array8.length; i++)
			array8[i] = copy8[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array8);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array8));
		
		// copy
		for(int i = 0; i<array8.length; i++)
			array8[i] = copy8[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array8);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array8));

		// copy
		for(int i = 0; i<array8.length; i++)
			array8[i] = copy8[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array8);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array8));
		
		// copy
		for(int i = 0; i<array8.length; i++)
			list.set(i, copy8[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array8.length; i++)
			list.set(i, copy8[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//9. array//
		System.out.println("\n\n9. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array9);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array9));
		
		// copy
		for(int i = 0; i<array9.length; i++)
			array9[i] = copy9[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array9);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array9));
		
		// copy
		for(int i = 0; i<array9.length; i++)
			array9[i] = copy9[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array9);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array9));
	
		// copy
		for(int i = 0; i<array9.length; i++)
			array9[i] = copy9[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array9);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array9));

		// copy
		for(int i = 0; i<array9.length; i++)
			array9[i] = copy9[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array9);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array9));
		
		// copy
		for(int i = 0; i<array9.length; i++)
			array9[i] = copy9[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array9);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array9));

		// copy
		for(int i = 0; i<array9.length; i++)
			array9[i] = copy9[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array9);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array9));
		
		// copy
		for(int i = 0; i<array9.length; i++)
			list.set(i, copy9[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array9.length; i++)
			list.set(i, copy9[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//10. array//
		System.out.println("\n\n10. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array10);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array10));
		
		// copy
		for(int i = 0; i<array10.length; i++)
			array10[i] = copy10[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array10);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array10));
		
		// copy
		for(int i = 0; i<array10.length; i++)
			array10[i] = copy10[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array10);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array10));
	
		// copy
		for(int i = 0; i<array10.length; i++)
			array10[i] = copy10[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array10);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array10));

		// copy
		for(int i = 0; i<array10.length; i++)
			array10[i] = copy10[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array10);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array10));
		
		// copy
		for(int i = 0; i<array10.length; i++)
			array10[i] = copy10[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array10);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array10));

		// copy
		for(int i = 0; i<array10.length; i++)
			array10[i] = copy10[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array10);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array10));
		
		// copy
		for(int i = 0; i<array10.length; i++)
			list.set(i, copy10[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array10.length; i++)
			list.set(i, copy10[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//11.array///
		System.out.println("\n\n11. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array11);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array11));
		
		// copy
		for(int i = 0; i<array11.length; i++)
			array11[i] = copy11[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array11);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array11));
		
		// copy
		for(int i = 0; i<array11.length; i++)
			array11[i] = copy11[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array11);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array11));
	
		// copy
		for(int i = 0; i<array11.length; i++)
			array11[i] = copy11[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array11);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array11));

		// copy
		for(int i = 0; i<array11.length; i++)
			array11[i] = copy11[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array11);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array11));
		
		// copy
		for(int i = 0; i<array11.length; i++)
			array11[i] = copy11[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array11);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array11));

		// copy
		for(int i = 0; i<array11.length; i++)
			array11[i] = copy11[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array11);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array11));

		// copy
		for(int i = 0; i<array11.length; i++)
			list.set(i, copy11[i]);
	
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array11.length; i++)
			list.set(i, copy11[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//12. array///
		System.out.println("\n\n12. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array12);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array12));
		
		// copy
		for(int i = 0; i<array12.length; i++)
			array12[i] = copy12[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array12);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array12));
		
		// copy
		for(int i = 0; i<array12.length; i++)
			array12[i] = copy12[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array12);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array12));
	
		// copy
		for(int i = 0; i<array12.length; i++)
			array12[i] = copy12[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array12);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array12));

		// copy
		for(int i = 0; i<array12.length; i++)
			array12[i] = copy12[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array12);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array12));
		
		// copy
		for(int i = 0; i<array12.length; i++)
			array12[i] = copy12[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array12);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array12));

		// copy
		for(int i = 0; i<array12.length; i++)
			array12[i] = copy12[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array12);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array12));
		
		// copy
		for(int i = 0; i<array12.length; i++)
			list.set(i, copy12[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array12.length; i++)
			list.set(i, copy12[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//13. array////
		System.out.println("\n\n13. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array13);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array13));
		
		// copy
		for(int i = 0; i<array13.length; i++)
			array13[i] = copy13[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array13);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array13));
		
		// copy
		for(int i = 0; i<array13.length; i++)
			array13[i] = copy13[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array13);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array13));
	
		// copy
		for(int i = 0; i<array13.length; i++)
			array13[i] = copy13[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array13);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array13));

		// copy
		for(int i = 0; i<array13.length; i++)
			array13[i] = copy13[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array13);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array13));
		
		// copy
		for(int i = 0; i<array13.length; i++)
			array13[i] = copy13[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array13);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array13));

		// copy
		for(int i = 0; i<array13.length; i++)
			array13[i] = copy13[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array13);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array13));

		// copy
		for(int i = 0; i<array13.length; i++)
			list.set(i, copy13[i]);
	
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array13.length; i++)
			list.set(i, copy13[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//14.array ///
		System.out.println("\n\n14. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array14);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array14));
		
		// copy
		for(int i = 0; i<array14.length; i++)
			array14[i] = copy14[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array14);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array14));
		
		// copy
		for(int i = 0; i<array14.length; i++)
			array14[i] = copy14[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array14);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array14));
	
		// copy
		for(int i = 0; i<array14.length; i++)
			array14[i] = copy14[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array14);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array14));

		// copy
		for(int i = 0; i<array14.length; i++)
			array14[i] = copy14[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array14);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array14));
		
		// copy
		for(int i = 0; i<array14.length; i++)
			array14[i] = copy14[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array14);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array14));

		// copy
		for(int i = 0; i<array14.length; i++)
			array14[i] = copy14[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array14);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array14));

		// copy
		for(int i = 0; i<array14.length; i++)
			list.set(i, copy14[i]);
	
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array14.length; i++)
			list.set(i, copy14[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//15. array///
		System.out.println("\n\n15. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array15);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array15));
		
		// copy
		for(int i = 0; i<array15.length; i++)
			array15[i] = copy15[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array15);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array15));
		
		// copy
		for(int i = 0; i<array15.length; i++)
			array15[i] = copy15[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array15);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array15));
	
		// copy
		for(int i = 0; i<array15.length; i++)
			array15[i] = copy15[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array15);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array15));

		// copy
		for(int i = 0; i<array15.length; i++)
			array15[i] = copy15[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array15);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array15));
		
		// copy
		for(int i = 0; i<array15.length; i++)
			array15[i] = copy15[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array15);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array15));

		// copy
		for(int i = 0; i<array15.length; i++)
			array15[i] = copy15[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array15);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array15));

		// copy
		for(int i = 0; i<array15.length; i++)
			list.set(i, copy15[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array15.length; i++)
			list.set(i, copy15[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//16. array//
		System.out.println("\n\n16. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array16);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array16));
		
		// copy
		for(int i = 0; i<array16.length; i++)
			array16[i] = copy16[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array16);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array16));
		
		// copy
		for(int i = 0; i<array16.length; i++)
			array16[i] = copy16[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array16);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array16));
	
		// copy
		for(int i = 0; i<array16.length; i++)
			array16[i] = copy16[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array16);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array16));

		// copy
		for(int i = 0; i<array16.length; i++)
			array16[i] = copy16[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array16);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array16));
		
		// copy
		for(int i = 0; i<array16.length; i++)
			array16[i] = copy16[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array16);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array16));

		// copy
		for(int i = 0; i<array16.length; i++)
			array16[i] = copy16[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array16);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array16));
		
		// copy
		for(int i = 0; i<array16.length; i++)
			list.set(i, copy16[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array16.length; i++)
			list.set(i, copy16[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//17. array ///
		System.out.println("\n\n17. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array17);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array17));
		
		// copy
		for(int i = 0; i<array17.length; i++)
			array17[i] = copy17[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array17);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array17));
		
		// copy
		for(int i = 0; i<array17.length; i++)
			array17[i] = copy17[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array17);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array17));
	
		// copy
		for(int i = 0; i<array17.length; i++)
			array17[i] = copy17[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array17);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array17));

		// copy
		for(int i = 0; i<array17.length; i++)
			array17[i] = copy17[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array17);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array17));
		
		// copy
		for(int i = 0; i<array17.length; i++)
			array17[i] = copy17[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array17);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array17));

		// copy
		for(int i = 0; i<array17.length; i++)
			array17[i] = copy17[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array17);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array17));
		
		// copy
		for(int i = 0; i<array17.length; i++)
			list.set(i, copy17[i]);
	
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array17.length; i++)
			list.set(i, copy17[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//18. array/////
		System.out.println("\n\n18. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array18);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array18));
		
		// copy
		for(int i = 0; i<array18.length; i++)
			array18[i] = copy18[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array18);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array18));
		
		// copy
		for(int i = 0; i<array18.length; i++)
			array18[i] = copy18[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array18);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array18));
	
		// copy
		for(int i = 0; i<array18.length; i++)
			array18[i] = copy18[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array18);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array18));

		// copy
		for(int i = 0; i<array18.length; i++)
			array18[i] = copy18[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array18);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array18));
		
		// copy
		for(int i = 0; i<array18.length; i++)
			array18[i] = copy18[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array18);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array18));

		// copy
		for(int i = 0; i<array18.length; i++)
			array18[i] = copy18[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array18);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array18));
		
		// copy
		for(int i = 0; i<array18.length; i++)
			list.set(i, copy18[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array18.length; i++)
			list.set(i, copy18[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//19. array//////
		System.out.println("\n\n19. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array19);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array19));
		
		// copy
		for(int i = 0; i<array19.length; i++)
			array19[i] = copy19[i];
		
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array19);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array19));
		
		// copy
		for(int i = 0; i<array19.length; i++)
			array19[i] = copy19[i];
		
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array19);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array19));
	
		// copy
		for(int i = 0; i<array19.length; i++)
			array19[i] = copy19[i];
	
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array19);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array19));

		// copy
		for(int i = 0; i<array19.length; i++)
			array19[i] = copy19[i];
		
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array19);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array19));
		
		// copy
		for(int i = 0; i<array19.length; i++)
			array19[i] = copy19[i];
		
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array19);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array19));

		// copy
		for(int i = 0; i<array19.length; i++)
			array19[i] = copy19[i];
	
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array19);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array19));

		// copy
		for(int i = 0; i<array19.length; i++)
			list.set(i, copy19[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array19.length; i++)
			list.set(i, copy19[i]);
	
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

		//20. array//////
		System.out.println("\n\n20. RANDOM ARRAY");
		// selection sort
		startTime = System.currentTimeMillis();
		SelectionSort.sort(array20);
		System.out.println("Selection sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Selection sort succesfull (true/false): " + verify(array20));
	
		// copy
		for(int i = 0; i<array20.length; i++)
			array20[i] = copy20[i];
				
		// bubble sort
		startTime = System.currentTimeMillis();
		BubbleSort.sort(array20);
		System.out.println("Bubble sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Bubble sort succesfull (true/false): " + verify(array20));
				
		// copy
		for(int i = 0; i<array20.length; i++)
			array20[i] = copy20[i];
				
		// insertion sort
		startTime = System.currentTimeMillis();
		InsertionSort.sort(array20);
		System.out.println("Insertion sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Insertion sort succesfull (true/false): " + verify(array20));
			
		// copy
		for(int i = 0; i<array20.length; i++)
			array20[i] = copy20[i];
			
		// shell sort
		startTime = System.currentTimeMillis();
		ShellSort.sort(array20);
		System.out.println("Shell sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Shell sort succesfull (true/false): " + verify(array20));

		// copy
		for(int i = 0; i<array20.length; i++)
			array20[i] = copy20[i];
				
		// merge sort
		startTime = System.currentTimeMillis();
		MergeSort.sort(array20);
		System.out.println("Merge sort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort succesfull (true/false): " + verify(array20));
				
		// copy
		for(int i = 0; i<array20.length; i++)
				array20[i] = copy20[i];
				
		// heapsort
		startTime = System.currentTimeMillis();
		HeapSort.sort(array20);
		System.out.println("Heapsort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Heapsort succesfull (true/false): " + verify(array20));

		// copy
		for(int i = 0; i<array20.length; i++)
			array20[i] = copy20[i];
			
		// quicksort
		startTime = System.currentTimeMillis();
		QuickSort.sort(array20);
		System.out.println("Quicksort time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort succesfull (true/false): " + verify(array20));

		// copy
		for(int i = 0; i<array20.length; i++)
			list.set(i, copy20[i]);
		
		// my merge sort
		startTime = System.currentTimeMillis();
		MyMergeSort.sort(list);
		System.out.println("Merge sort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Merge sort with linked list succesfull (true/false): " + verify(list));

		// copy
		for(int i = 0; i<array20.length; i++)
			list.set(i, copy20[i]);
			
		// my quicksort
		startTime = System.currentTimeMillis();
		MyQuickSort.sort(list);
		System.out.println("Quicksort with linked list time is "
							+ (System.currentTimeMillis()
							- startTime) + "ms");
		//System.out.println("Quicksort with linked list succesfull (true/false): " + verify(list));
		/////////////////////////////////////////////////////////////////////////////////////////////////////////
				
	}
	
	private static boolean verify(Comparable[] test) {
		boolean ok = true;
		int i = 0;
		while(ok && i < test.length - 1) {
			ok = test[i].compareTo(test[i + 1]) <= 0;
			i++;
		}
		return ok;
	}
	
	private static <T extends Comparable<T>> boolean verify(LinkedList<T> test) {
		boolean ok = true;
		int i = 0;
		while(ok && i < test.size() - 1) {
			ok = test.get(i).compareTo(test.get(i + 1)) <= 0;
			i++;
		}
		return ok;
	}
}
