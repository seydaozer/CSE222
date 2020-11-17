import java.util.Scanner;

/**
 * @author Seyda Ozer
 * ExpressionTree Class
 */
public class ExpressionTree extends BinaryTree<String>{
	/**
	 * The tree is a expression tree. 
	 */
	BinaryTree<String> tree;
	
	/**
	 * ExpressionTree Constructor
	 * @param expression The string expression to store in this tree.
	 */
	public ExpressionTree(String expression) {

		if(!isOperator(expression.charAt(0))) {
			Scanner scan = new Scanner(expression);
			expression = reverse(scan);
		}
		
		Scanner scan = new Scanner(expression);
		tree = readBinaryTree(scan);
	}
	
	/**
	 * This method reverses the string in the Scanner.
	 * @param scan to be reversed
	 * @return a new String
	 */
	private String reverse(Scanner scan) {
		if(!scan.hasNext())
			return "";
		
		String data = scan.next();
		String next = reverse(scan);
		
		if(!next.equals(""))
			data = " " + data;
			
		return next + data;	
	}
	
	/**
	 * Method to read a expression tree.
	 * pre: The input consists of a preorder traversal
	 * 		of the tree. The line "null" indicates a null tree.
	 * @param scan the Scanner attached to the input file.
	 * @return The binary tree
	 */
	public static BinaryTree<String> readBinaryTree(Scanner scan){
		String data = scan.next();
		
		char c = data.charAt(0);
		if(isOperator(c)) {
			BinaryTree<String> left = readBinaryTree(scan);
			BinaryTree<String> right = readBinaryTree(scan);
			return new BinaryTree<String>(data, left, right);
		}
		else
			return new BinaryTree<String>(new Node<String>(data));
	}
	
	/**
	 * This method checks whether the character is an operator.
	 * @param c the character to be controlled
	 * @return true if the character is operator, false otherwise
	 */
	private static boolean isOperator(char c) {
		return (c == '+' || c == '-' || c == '*' || c == '/');
	}
	
    /**
     * This method returns a string representation of the BinaryTree object.
     * 
     * @return a string preorder representation of the BinaryTree object.
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(tree.root, 1, sb);
		return sb.toString();
	}
	
    /**
     * This method returns a string representation of the BinaryTree object.
     * 
     * @return a string postorder representation of the BinaryTree object.
     */
	public String toString2() {
		StringBuilder sb = new StringBuilder();
		postOrderTraverse(tree.root, sb);
		return sb.toString();
	}
	
	/**
	 * Perform a preorder traversal.
	 * @param node The local root
	 * @param depth the depth
	 * @param sb The string buffer to save the output
	 */
	@Override
	public void preOrderTraverse(Node<String> node, int depth, StringBuilder sb) {
		if(node == null) {
			return;
		} else {
			sb.append(node.toString() + " ");
			preOrderTraverse(node.left, depth, sb);
			preOrderTraverse(node.right, depth, sb);
		}
	}
	
	/**
	 * Perform a postorder traversal.
	 * @param node The local root
	 * @param sb The string buffer to save the output
	 */
	public void postOrderTraverse(Node<String> node, StringBuilder sb) {
		if(node == null) {
			return;
		} else {
			postOrderTraverse(node.left, sb);
			postOrderTraverse(node.right, sb);
			sb.append(node.toString() + " ");
		}
	}
	
	public int eval() {
		Node<String> temp = tree.root;
	
		return evaluate(temp);
	}
	
	private int evaluate(Node<String> node) {
		char c = node.data.charAt(0);
		
		if(Character.isDigit(c))
			return stringToInt(node.data);
		
		
		if(isOperator(c)) {
			int left = evaluate(node.left);
			int right = evaluate(node.right);
			
			switch(c) {
			case '+':
				return (left + right);
			case '-':
				return (left - right);
			case '*':
				return (left * right);
			case '/':
				return (left / right);
			}
		}
		return (Integer) null;
	}
	
	/**
	 * This method is a helper method for the evaluatePostfix and evaluatePrefix methods.
	 * This method converts the given string to the integer value.
	 * @param str string to be converted
	 * @return int value of the string
	 */
	private int stringToInt(String str) {
		if(str == null || str.equals("") || str.length() == 0)
			return 0;
		
		char c = str.charAt(0);
		
		return (int) ((c - '0') * Math.pow(10, str.length() - 1) + stringToInt(str.substring(1)));
	}
	
}
