
public class AgeSearchTreeTest {
	
	public static void main(String [] args) {
		//Create an empty tree
		AgeSearchTree<AgeData> ageTree = new AgeSearchTree<AgeData>();
		
		//Adding a element to tree
		ageTree.add(new AgeData(10));
		//Finding 10
		System.out.println(ageTree.find(new AgeData(10)));
		System.out.println();
		//Adding the same element to tree again
		ageTree.add(new AgeData(10));
		//Finding 10
		System.out.println(ageTree.find(new AgeData(10)));
		System.out.println();
		
		ageTree.add(new AgeData(20));
		ageTree.add(new AgeData(5));
		ageTree.add(new AgeData(15));
		ageTree.add(new AgeData(5));
		
		//Control of the order of the elements
		System.out.println(ageTree);
		
		//Using youngerThan method
		System.out.print("The number of people younger than 15: ");
		System.out.println(ageTree.youngerThan(15));
		
		//Using olderThan method
		System.out.print("The number of people older than 10: ");
		System.out.println(ageTree.olderThan(10));
		System.out.println();
		
		/*Removing an object that has number of 
		  people data greater than 1.*/
		System.out.println(ageTree);
		System.out.println("The element 5 is removing");
		ageTree.remove(new AgeData(5));
		System.out.println(ageTree);
		
		//Removing an element from the tree
		System.out.println("The element 15 is removing");
		ageTree.remove(new AgeData(15));
		System.out.println(ageTree);
		
		//Removing an element that is not in the tree
		System.out.println("The element 80 is removing");
		ageTree.remove(new AgeData(80));
		System.out.print(ageTree);
		System.out.println("There is no change in the tree.\n");

		//Finding an element
		System.out.println(ageTree.find(new AgeData(20)));
		System.out.println();
		
		//Finding an element that is not in the tree
		if(ageTree.find(new AgeData(80)) == null)
			System.out.println("The element(80) is not found.");
	
	}
	
}
