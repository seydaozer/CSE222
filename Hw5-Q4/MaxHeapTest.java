
public class MaxHeapTest {
	public static void main(String [] args) {
		//Create an empty heap
		MaxHeap<AgeData> heap = new MaxHeap<AgeData>(); 
		
		//Adding a element to tree
		heap.add(new AgeData(10));
		//Finding 10
		System.out.println(heap.find(new AgeData(10)));
		System.out.println();
		
		heap.add(new AgeData(5));
		heap.add(new AgeData(70));
		
		//Adding the same element to tree again
		heap.add(new AgeData(10));
		//Finding 10
		System.out.println(heap.find(new AgeData(10)));
		System.out.println();
		
		heap.add(new AgeData(50));
		heap.add(new AgeData(5));
		heap.add(new AgeData(15)); 
		
		//Control of the order of the elements
		System.out.println(heap);
		
		//Using youngerThan method
		System.out.print("The number of people younger than 15: ");
		System.out.println(heap.youngerThan(15));
		
		//Using olderThan method
		System.out.print("The number of people older than 10: ");
		System.out.println(heap.olderThan(10));
		System.out.println();
		
		/*Removing an object that has number of 
		  people data greater than 1*/
		System.out.println("The element 10 is removing");
		heap.remove(new AgeData(10));
		System.out.println(heap);
		
		//Removing an element from the tree
		System.out.println("The element 15 is removing");
		heap.remove(new AgeData(15));
		System.out.println(heap);
		
		//Removing an element that is not in the tree
		System.out.println("The element(80) is removing");
		heap.remove(new AgeData(80));
		System.out.print(heap);
		System.out.println("There is no change in the tree.\n");

		//Finding an element
		System.out.println(heap.find(new AgeData(50)));
		System.out.println();
		
		//Finding an element that is not in the tree
		if(heap.find(new AgeData(80)) == null)
			System.out.println("The element(80) is not found.");
		
	}
}
