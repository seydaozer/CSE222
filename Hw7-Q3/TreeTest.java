import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentSkipListSet;

public class TreeTest {
	public static void main(String [] args) {
		int size1 = 10000;
		int size2 = 20000;
		int size3 = 40000;
		int size4 = 80000;
		
		// Binary Search Tree
		BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst2 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst3 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst4 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst5 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst6 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst7 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst8 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst9 = new BinarySearchTree<Integer>();
		BinarySearchTree<Integer> bst10 = new BinarySearchTree<Integer>();
		
		// Red Black Tree
		RedBlackTree<Integer> rbt1 = new RedBlackTree<Integer>();
		RedBlackTree<Integer> rbt2 = new RedBlackTree<Integer>();
		RedBlackTree<Integer> rbt3 = new RedBlackTree<Integer>();
		RedBlackTree<Integer> rbt4 = new RedBlackTree<Integer>();
		RedBlackTree<Integer> rbt5 = new RedBlackTree<Integer>();
		RedBlackTree<Integer> rbt6 = new RedBlackTree<Integer>();
		RedBlackTree<Integer> rbt7 = new RedBlackTree<Integer>();
		RedBlackTree<Integer> rbt8 = new RedBlackTree<Integer>();
		RedBlackTree<Integer> rbt9 = new RedBlackTree<Integer>();
		RedBlackTree<Integer> rbt10 = new RedBlackTree<Integer>();
		
		// Red Black Tree in Java
		TreeSet<Integer> ts1 = new TreeSet<Integer>();
		TreeSet<Integer> ts2 = new TreeSet<Integer>();
		TreeSet<Integer> ts3 = new TreeSet<Integer>();
		TreeSet<Integer> ts4 = new TreeSet<Integer>();
		TreeSet<Integer> ts5 = new TreeSet<Integer>();
		TreeSet<Integer> ts6 = new TreeSet<Integer>();
		TreeSet<Integer> ts7 = new TreeSet<Integer>();
		TreeSet<Integer> ts8 = new TreeSet<Integer>();
		TreeSet<Integer> ts9 = new TreeSet<Integer>();
		TreeSet<Integer> ts10 = new TreeSet<Integer>();
		
		// Skip List
		SkipList<Integer> sl1 = new SkipList<Integer>();
		SkipList<Integer> sl2 = new SkipList<Integer>();
		SkipList<Integer> sl3 = new SkipList<Integer>();
		SkipList<Integer> sl4 = new SkipList<Integer>();
		SkipList<Integer> sl5 = new SkipList<Integer>();
		SkipList<Integer> sl6 = new SkipList<Integer>();
		SkipList<Integer> sl7 = new SkipList<Integer>();
		SkipList<Integer> sl8 = new SkipList<Integer>();
		SkipList<Integer> sl9 = new SkipList<Integer>();
		SkipList<Integer> sl10 = new SkipList<Integer>();
		
		// Skip List in Java
		ConcurrentSkipListSet<Integer> csl1 = new ConcurrentSkipListSet<Integer>();
		ConcurrentSkipListSet<Integer> csl2 = new ConcurrentSkipListSet<Integer>();
		ConcurrentSkipListSet<Integer> csl3 = new ConcurrentSkipListSet<Integer>();
		ConcurrentSkipListSet<Integer> csl4 = new ConcurrentSkipListSet<Integer>();
		ConcurrentSkipListSet<Integer> csl5 = new ConcurrentSkipListSet<Integer>();
		ConcurrentSkipListSet<Integer> csl6 = new ConcurrentSkipListSet<Integer>();
		ConcurrentSkipListSet<Integer> csl7 = new ConcurrentSkipListSet<Integer>();
		ConcurrentSkipListSet<Integer> csl8 = new ConcurrentSkipListSet<Integer>();
		ConcurrentSkipListSet<Integer> csl9 = new ConcurrentSkipListSet<Integer>();
		ConcurrentSkipListSet<Integer> csl10 = new ConcurrentSkipListSet<Integer>();
		
		Random rInt = new Random(); // For random number generation
		
		int size = size4;
		// 1.data structures
		for(int i = 0; i<size; i++) {
			int r = rInt.nextInt(); // random number
			bst1.add(r);         // binary search tree
			rbt1.add(r);         // red black tree
			ts1.add(r);	        // tree set
			sl1.add(r);          // skip list
			csl1.add(r);         // concurrent skip list set
		}
		// 2.data structures
		for(int i = 0; i<size; i++) {
			int r = rInt.nextInt(); // random number
			bst2.add(r);         // binary search tree
			rbt2.add(r);         // red black tree
			ts2.add(r);	        // tree set
			sl2.add(r);          // skip list
			csl2.add(r);         // concurrent skip list set
		}
		// 3.data structures
		for(int i = 0; i<size; i++) {
			int r = rInt.nextInt(); // random number
			bst3.add(r);         // binary search tree
			rbt3.add(r);         // red black tree
			ts3.add(r);	        // tree set
			sl3.add(r);          // skip list
			csl3.add(r);         // concurrent skip list set
		}
		// 4.data structures
		for(int i = 0; i<size; i++) {
			int r = rInt.nextInt(); // random number
			bst4.add(r);         // binary search tree
			rbt4.add(r);         // red black tree
			ts4.add(r);	        // tree set
			sl4.add(r);          // skip list
			csl4.add(r);         // concurrent skip list set
		}
		// 5.data structures
		for(int i = 0; i<size; i++) {
			int r = rInt.nextInt(); // random number
			bst5.add(r);         // binary search tree
			rbt5.add(r);         // red black tree
			ts5.add(r);	        // tree set
			sl5.add(r);          // skip list
			csl5.add(r);         // concurrent skip list set
		}
		// 6.data structures
		for(int i = 0; i<size; i++) {
			int r = rInt.nextInt(); // random number
			bst6.add(r);         // binary search tree
			rbt6.add(r);         // red black tree
			ts6.add(r);	        // tree set
			sl6.add(r);          // skip list
			csl6.add(r);         // concurrent skip list set
		}
		// 7.data structures
		for(int i = 0; i<size; i++) {
			int r = rInt.nextInt(); // random number
			bst7.add(r);         // binary search tree
			rbt7.add(r);         // red black tree
			ts7.add(r);	        // tree set
			sl7.add(r);          // skip list
			csl7.add(r);         // concurrent skip list set
		}
		// 8.data structures
		for(int i = 0; i<size; i++) {
			int r = rInt.nextInt(); // random number
			bst8.add(r);         // binary search tree
			rbt8.add(r);         // red black tree
			ts8.add(r);	        // tree set
			sl8.add(r);          // skip list
			csl8.add(r);         // concurrent skip list set
		}
		// 9.data structures
		for(int i = 0; i<size; i++) {
			int r = rInt.nextInt(); // random number
			bst9.add(r);         // binary search tree
			rbt9.add(r);         // red black tree
			ts9.add(r);	        // tree set
			sl9.add(r);          // skip list
			csl9.add(r);         // concurrent skip list set
		}
		// 10.data structures
		for(int i = 0; i<size; i++) {
			int r = rInt.nextInt(); // random number
			bst10.add(r);         // binary search tree
			rbt10.add(r);         // red black tree
			ts10.add(r);	        // tree set
			sl10.add(r);          // skip list
			csl10.add(r);         // concurrent skip list set
		}
		
		Integer [] array = new Integer[10];
		for(int i = 0; i<10; i++) {
			int r = rInt.nextInt();
			array[i] = r;
		}
		
		long startTime;
		
		// Binary Search Tree
		System.out.println("Binary Search Tree insert running times are: (size = " + size + ")");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			bst1.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			bst2.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst3.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst4.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst5.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst6.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst7.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst8.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst9.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst10.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		
		
		// Red Black Tree
		System.out.println("Red Black Tree insert running times are: (size = " + size + ")");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			rbt1.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			rbt2.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			rbt3.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			rbt4.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			rbt5.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			rbt6.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			rbt7.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			rbt8.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			rbt9.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			rbt10.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		
		// Tree Set
		System.out.println("Tree Set insert running times are: (size = " + size + ")");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts1.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts2.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts3.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts4.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts5.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts6.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts7.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts8.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts9.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts10.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		
		// Skip List
		System.out.println("Skip List insert running times are: (size = " + size + ")");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl1.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl2.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl3.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl4.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl5.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl6.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl7.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl8.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl9.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl10.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		
		// Concurrent Skip List Set
		System.out.println("Concurrent Skip List Set insert running times are: (size = " + size + ")");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl1.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl2.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl3.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl4.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl5.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl6.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl7.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl8.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl9.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl10.add(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		
		
		// Binary Search Tree
		System.out.println("Binary Search Tree delete running times are: (size = " + size + ")");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			bst1.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			bst2.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst3.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst4.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst5.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst6.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst7.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst8.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst9.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		for(int i=0; i<10; i++) {
			bst10.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
			
		// Tree Set
		System.out.println("Tree Set delete running times are: (size = " + size + ")");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts1.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts2.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts3.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts4.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts5.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts6.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts7.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts8.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts9.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			ts10.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		
		//Skip List
		System.out.println("Skip List insert delete times are: (size = " + size + ")");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl1.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl2.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl3.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl4.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl5.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl6.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl7.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl8.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl9.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			sl10.delete(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		
		//Concurrent Skip List Set
		System.out.println("Concurrent Skip List Set delete running times are: (size = " + size + ")");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl1.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl2.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl3.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl4.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl5.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl6.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl7.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl8.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl9.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		startTime = System.currentTimeMillis();
		for(int i=0; i<10; i++) {
			csl10.remove(array[i]);
		}
		System.out.println((System.currentTimeMillis() - startTime) + "ms");
		
		/* 
		// verify
		ArrayList<Integer> list = (ArrayList<Integer>) bst1_s1.toList();
		System.out.println("The list is sorted(BST): " + verify(list));
		
		list = (ArrayList<Integer>) rbt1_s1.toList();
		System.out.println("The list is sorted(Red-Black): " + verify(list));
		
		list = new ArrayList<Integer>();
		sl1_s1.inOrderTraverse(list);
		System.out.println("The list is sorted(SkipList): " + verify(list));
		*/
			
	}
	
	private static <T extends Comparable<T>> boolean verify(ArrayList<T> test) {
		boolean ok = true;
		int i = 0;
		while(ok && i < test.size() - 1) {
			ok = test.get(i).compareTo(test.get(i + 1)) <= 0;
			i++;
		}
		return ok;
	}
}
