
public class SoftwareStoreTest {
	public static void main(String [] args) {
		SoftwareStore<Software> store = new SoftwareStore<Software>(new BinarySearchTree<Software>());
		System.out.println(store);
		
		// Test1
		
		System.out.println("The item is searching: " 
							+ store.search("Norton 4.5"));
		
		// Test2
		
		System.out.println("The item is searching: " 
							+ store.search("Norton 1.0") + "\n");
		
		//Test3
		
		store.arriveStore("Adobe Photoshop CC", 5, 75);
		
		System.out.println(store);
		
		//Test4
		
		store.leaveStore("Adobe Photoshop 6.0", 1);
		
		System.out.println(store);
		
		//test5
		
		store.addPackage("Norton 4.5", 1, 100);
		
		//test6
		
		store.deletePackage("Norton 4.5", 1);
		
		//test7
		
		System.out.println("The package updating: "
				+ store.updateName("Adobe Flash 3.3", "Adobe Flash 5.0"));
		
		//test8
		
		System.out.println("The package updating: "
				+ store.updateQuantity("Adobe Flash 3.3", 6));
		
		//test9
		
		System.out.println("The package updating: "
				+ store.updatePrice("Norton 4.5", 125));
		
		//test10
		
		store.loginAdmin("12345");
		
		//test11
		
		store.addPackage("Norton 4.5", 1, 100);
		
		//test12
		
		store.addPackage("Adobe XD", 3, 50);
		
		System.out.println(store);
		
		//test13
		
		store.deletePackage("Norton 4.5", 1);
		
		//test14
		
		store.deletePackage("Adobe Photoshop 6.2", 1);
		
		System.out.println(store);
		
		//test 15
		
		store.updateName("Adobe Flash 3.3", "Adobe Flash 5.0");
		
		System.out.println(store);
		
		//test 16
		
		store.updateQuantity("Adobe Flash 5.0", 6);
		
		//test 17
		
		store.updatePrice("Norton 4.5", 125);
		
		System.out.println(store);
	}
}
