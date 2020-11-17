
public class HashTableChainTest {
	public static void main(String [] args) {
		HashTableChain<Integer, String> cMap = new HashTableChain<Integer, String>();
		
		//test1
		if(cMap.isEmpty())
			System.out.println("The map is empty.");
		else
			System.out.println("The map is not empty.");
		
		//test2
		cMap.put(1, "A");
		System.out.println(cMap);
		
		//test3
		if(cMap.isEmpty())
			System.out.println("The map is empty.");
		else
			System.out.println("The map is not empty.");
		
		cMap.put(2, "C");
		System.out.println(cMap);
		
		cMap.put(3, "D");
		System.out.println(cMap);
		
		//test4
		cMap.put(1, "a");
		System.out.println(cMap);
		
		//test5
		System.out.print("The value of key(2): ");
		System.out.println(cMap.get(2));
		
		//test6
		System.out.print("The value of key(4): ");
		System.out.println(cMap.get(4));
		
		//test7
		System.out.print("The value of removed key(3): ");
		System.out.println(cMap.remove(3));
		
		System.out.println(cMap);
		
		//test8
		System.out.print("The value of removed key(4): ");
		System.out.println(cMap.remove(4));
	}
}
