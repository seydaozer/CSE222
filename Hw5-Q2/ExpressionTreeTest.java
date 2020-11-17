
public class ExpressionTreeTest {
	public static void main(String [] args) {
		//Create a tree for preorder expression 
		ExpressionTree expTree1 = new ExpressionTree("+ + 10 * 5 15 20"); 
		
		//Create a tree for postorder expression
		ExpressionTree expTree2 = new ExpressionTree("10 5 15 * + 20 +"); 
		
		// Printing the tree as a preorder traversa
		System.out.println(expTree1.toString());
		System.out.println();
		
		// Printing the tree as a postorder traversal
		System.out.println(expTree1.toString2());
		System.out.println();
		
		// Printing the tree as a preorder traversal
		System.out.println(expTree2.toString());
		System.out.println();
		
		// Printing the tree as a postorder traversal
		System.out.println(expTree2.toString2());
		System.out.println();
		
		//Evaluating a tree with preorder expression
		System.out.println("The result of the evaluating of the tree1");
		System.out.println(expTree1.eval());
		System.out.println();
		
		//Evaluating a tree with postorder expression
		System.out.println("The result of the evaluating of the tree2");
		System.out.println(expTree2.eval());
	}
}
