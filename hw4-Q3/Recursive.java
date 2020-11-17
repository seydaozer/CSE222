import java.util.Stack;
import java.lang.Math;

/**
 * @author Seyda Ozer
 *		   171044023
 *		   Recursive Class includes recursive methods(Homework 4 - Q3).
 */
public class Recursive {
	//Part 1
	/**
	 * This method reverse a string word by word.
	 * @param str string to be reversed
	 * @return String reversed string
	 */
	public String reverseString(String str) {
		if(str == null || str.equals(""))
			return "";
		
		StringBuilder result1 = new StringBuilder();
		StringBuilder result2 = new StringBuilder();
		
		if(str.contains(" ")) {
			String [] parts = str.split(" ", 2);
			result1.append(" ");
			result1.append(parts[0]);
			result2.append(parts[1]);
		}
		else {
			result1.append(str);
			result2.append("");
		}
		
		return (reverseString(result2.toString()) + result1.toString());
	}
	// end of the part1
	
	
	//Part 2
	/**
	 *  Determining whether a word is elfish or not.
	 *  A word is considered elfish if it contains the letters:
	 *  e, l, and f in it, in any order.
	 * @param word string to be checked
	 * @param count When one of the letters e, l and f is found, the counter increments one.
	 * @return true if the word is elfish
	 */
	public boolean IsElfish(String word, int count) {
		final char [] elfish = {'e', 'l', 'f'};
		
		if( count == 3 )
			return true;
		
		if (word == null || word.equals(""))
			return false;
		
		if(word.charAt(0) == elfish[0] || word.charAt(0) == elfish[1] || word.charAt(0) == elfish[2]) {
			StringBuilder c = new StringBuilder();
			c.append(word.charAt(0));
			word = elfishHelper(word.substring(1), c.toString());
			count++;
			return IsElfish(word, count);
		}
		
		return IsElfish(word.substring(1), count);
	}
	
	
	/**
	 * This method is a helper method for the IsElfish method.
	 * When one of the letters E, l, and f is found, this method
	 * removes other characters (that are the same as the founded character) from the word.
	 * 
	 * @param word string to be checked
	 * @param c character to be removed ( e, l or f)
	 * @return string of the new version of the word
	 */
	private String elfishHelper(String word, String c) {
		if(!(word.contains(c)))
			return word;
		
		if(word.charAt(0) == c.charAt(0))
			return elfishHelper(word.substring(1), c);

		else {
			String[] w = word.split(c, 2);
			return w[0] + elfishHelper(w[1], c);
		}
		
	}
	// end of the part2
	
	
	//Part3
	/**
	 * This method sorts the array of elements. (ascending order)
	 * @param array int array to be sorted
	 * @param index index increments one for each item. (from 0 to the size of the string)
	 */
	public void selectionSort(int [] array, int index) {
		if(array.length == 0 || array == null)
			return;
		
		if(index == array.length-1)
			return;
		
		int i = indexOfMin(array, index, array.length-1);
		
		if(i != index)
			swapForArray(array, index, i);
		
		selectionSort(array, index+1);
		
	}
	
	/**
	 * This method is a helper method for the selectionSort method.
	 * This method goes from the given index to the end of the array 
	 * and finds the index of the smallest element.
	 * @param array to be used
	 * @param index this is starting index
	 * @param size size of the array
	 * @return the index of the smallest element
	 */
	private int indexOfMin(int [] array, int index, int size) {
		if(size == index)
			return index;
		
		int i = indexOfMin(array, index+1, size);

		return (array[index] < array[i])? index : i;
	}
	
	/**
	 * This method is a helper method for the selectionSort method.
	 * This method swaps two elements in the array.
	 * @param array to be used
	 * @param i index of first element
	 * @param j index of second element
	 */
	private void swapForArray(int [] array, int i, int j) {
		int temp;
		
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	// end of the part3
	
	
	//Part 4
	/**
	 * This method evaluates the postfix expression.
	 * If the given string null or empty, this method returns zero.
	 * @param postfix string of the postfix expression
	 * @param stack Stack is used for pushing operands.
	 * @return int value of the result of this operation.
	 */
	public int evaluatePostfix(String postfix, Stack<Integer> stack) {
		if(postfix == null || postfix.equals("")) {
			if(!(stack.isEmpty()))
					return stack.pop();
			return 0;
		}
		
		StringBuilder part1 = new StringBuilder();
		StringBuilder part2 = new StringBuilder();
		
		if(postfix.contains(" ")) {
		String [] parts = postfix.split(" ", 2);
		
		part1.append(parts[0]);
		part2.append(parts[1]);
		}
		else {
			part1.append(postfix);
			part2.append("");
		}
		
		char c = part1.charAt(0);
		
		if(Character.isDigit(c)) {
			int value = stringToInt(part1.toString());
			stack.push(value);
		}
		
		else {
			int number1 = stack.pop();
			int number2 = stack.pop();
			
			if(c == '*')
				stack.push(number2 * number1);
			else if(c == '/')
				stack.push(number2 / number1);
			else if(c == '+')
				stack.push(number2 + number1);
			else if(c == '-')
				stack.push(number2 - number1);
		}
		
		return evaluatePostfix(part2.toString(), stack);
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
	// end of the part4
	
	//Part 5
	/**
	 * This method evaluates the prefix expression.
	 * If the given string null or empty, this method returns zero.
	 * @param prefix string of the prefix expression
	 * @param stack Stack is used for pushing operands.
	 * @return int value of the result of this operation.
	 */
	public int evaluatePrefix(String prefix, Stack<Integer> stack) {
		if(prefix == null || prefix.equals("")) {
			if(!(stack.isEmpty()))
				return stack.pop();
			return 0;
		}
		
		StringBuilder part1 = new StringBuilder();
		StringBuilder part2 = new StringBuilder();
		
		if(prefix.contains(" ")) {
			int index = spaceIndex(prefix.substring(prefix.indexOf(' ')+1), prefix.indexOf(' '));
			
			part1.append(prefix.substring(0, index));
			part2.append(prefix.substring(index+1));	
		}
		else {
			part2.append(prefix);
			part1.append("");
		}
		
		char c = part2.charAt(0);
		
		if(Character.isDigit(c)) {
			int value = stringToInt(part2.toString());
			stack.push(value);
			
		}
		
		else {
			int number1 = stack.pop();
			int number2 = stack.pop();
			
			if(c == '*')
				stack.push(number2 * number1);
			else if(c == '/')
				stack.push(number2 / number1);
			else if(c == '+')
				stack.push(number2 + number1);
			else if(c == '-')
				stack.push(number2 - number1);
		}
		
		return evaluatePrefix(part1.toString(), stack);

	}
	
	/**
	 * This method is a helper method for the evaluatePrefix method.
	 * This method finds the index of the last space character in the given string.
	 * @param str string to be searched
	 * @param index the first index of the space character
	 * @return the last index of the space character in the string
	 */
	private int spaceIndex(String str, int index) {
		if( !(str.contains(" ")) )
			return index;
		
		return spaceIndex(str.substring(1), index+1);
	}
	// end of the part 5
	
	//Part6
	
	/**
	 * This method prints the elements of an mxn array.
	 * It travels on the elements of the array in a spiral form.
	 * @param array to be printed
	 * @param i x coordinate
	 * @param j y coordinate
	 * @param counter the counter increments one for each time.
	 * 		 (from 1 to m*n)
	 * @param lowerBound_i is the lower bound of the x coordinate (0 value should be used for starting)
	 * @param upperBound_i is the upper bound of the x coordinate (value of the m should be used for starting)
	 * @param lowerBound_j is the lower bound of the y coordinate (0 value should be used for starting)
	 * @param upperBound_j is the upper bound of the y coordinate (value of the n should be used for starting)
	 */
	public void printMatrix(int [][] array, int i, int j, int counter, int lowerBound_i, int upperBound_i, int lowerBound_j, int upperBound_j) {
		if(array.length == 0)
			return;
		
		if( counter == (array.length * array[0].length) ) {
			System.out.print(array[i][j]);
			return;
		}
		
		System.out.print(array[i][j] + " ");
		
		if(i == lowerBound_i+1 && j == lowerBound_j) {
			lowerBound_i++;
			lowerBound_j++;
			upperBound_i--;
			upperBound_j--;
		}

		if(j == lowerBound_j && i != lowerBound_i)
			i--;

		else if(i == upperBound_i)
			j--;

		else if(j == upperBound_j)
			i++;

		else if(i == lowerBound_i)
			j++;

		counter++;
		
		printMatrix(array, i, j, counter, lowerBound_i, upperBound_i, lowerBound_j, upperBound_j);
	}

	
	
	/**
     * This main method of this application.
     * @param args array of string arguments.
     */
	public static void main(String [] args) {
		Recursive rec = new Recursive();
		
		
		//Part1
		//reverseString
		
		System.out.println("Seyda");
		System.out.println(rec.reverseString("Seyda"));
		
		System.out.println("this function writes the sentence in reverse");
		System.out.println(rec.reverseString("this function writes the sentence in reverse"));
		
		System.out.println("Deque is a queue that supports adding or removing items from both ends of the data structure");
		System.out.println(rec.reverseString("Deque is a queue that supports adding or removing items from both ends of the data structure"));
		
		System.out.println("Testing null");
		System.out.println(rec.reverseString(null));
		
		System.out.println("Testing empty string");
		System.out.println(rec.reverseString(""));
		
		//Part2
		//IsElfish
		
		System.out.println(rec.IsElfish("elfish", 0));
		
		System.out.println("result (cell): " + rec.IsElfish("cell", 0));
		
		System.out.println("result (tasteful): " + rec.IsElfish("tasteful", 0));
		
		System.out.println("result (unfriendly): " + rec.IsElfish("unfriendly", 0));
		
		System.out.println("result (waffles): " + rec.IsElfish("waffles", 0));
		
		System.out.println("result (Seyda): " + rec.IsElfish("Seyda", 0));
		
		System.out.println("result (translate): " + rec.IsElfish("translate", 0));
		
		System.out.println("result (safe): " + rec.IsElfish("safe", 0));
		
		System.out.println("result (empty string): " + rec.IsElfish("", 0));
		
		System.out.println("result null: " + rec.IsElfish(null, 0));
		
		System.out.println();
		System.out.println();
		
		//Part3
		//selectionSort
		
		int [] array1 = {4, 6, 7, 2, 5};
		
		for(int i=0; i<array1.length; i++)
			System.out.print(array1[i] + " ");
		System.out.println();
		
		rec.selectionSort(array1, 0);
		
		System.out.println("The sorting array: ");
		for(int i=0; i<array1.length; i++)
			System.out.print(array1[i] + " ");
		System.out.println();
		
		int [] array2 = {10, 15, 70, 40, 22, 9, 2, 25, 46, 0};
		
		for(int i=0; i<array2.length; i++)
			System.out.print(array2[i] + " ");
		System.out.println();
		
		rec.selectionSort(array2, 0);
		
		System.out.println("The sorting array: ");
		for(int i=0; i<array2.length; i++)
			System.out.print(array2[i] + " ");
		System.out.println();
		
		int [] array3 = {};
		
		for(int i=0; i<array3.length; i++)
			System.out.print(array3[i] + " ");
		System.out.println();
		
		rec.selectionSort(array3, 0);
		
		System.out.println("The sorting array: ");
		for(int i=0; i<array3.length; i++)
			System.out.print(array3[i] + " ");
		System.out.println();
		
		//Part4
		//evaluatePostfix
		
		Stack<Integer> stack1 = new Stack<>();
		System.out.println("Result of this postfix expression ( 10 23 32 + * ): " + rec.evaluatePostfix("10 23 32 + *", stack1));
		
		stack1 = new Stack<>();
		System.out.println("Result of this postfix expression ( 12 2 * 7 - 135 * 12 + ): " + rec.evaluatePostfix("12 2 * 7 - 135 * 12 +", stack1));
		
		stack1 = new Stack<>();
		System.out.println("Result of this postfix expression ( 35 1000 * 2000 - 33 / 19000 16 + 26 - ): " + 
							rec.evaluatePostfix("35 1000 * 2000 - 33 / 19000 16 + 26 -", stack1));
		
		stack1 = new Stack<>();
		System.out.println("Result of this postfix expression ( empty string ): " + rec.evaluatePostfix("", stack1));
		
		stack1 = new Stack<>();
		System.out.println("Result of this postfix expression ( null ): " + rec.evaluatePostfix(null, stack1));
		
		System.out.println();
		System.out.println();
		
		//Part5
		//evaluatePrefix
		
		Stack<Integer> stack2 = new Stack<>();
		System.out.println("Result of this prefix expression ( * + 32 23 10 ): " + rec.evaluatePrefix("* + 32 23 10", stack2));
		
		stack2 = new Stack<>();
		System.out.println("Result of this prefix expression ( + 12 * 135 - 7 * 2 12 ): " + rec.evaluatePrefix("+ 12 * 135 - 7 * 2 12", stack2));
		
		stack2 = new Stack<>();
		System.out.println("Result of this prefix expression ( - 26 + 16 19000 / 33 - 2000 * 1000 35 ): " 
							+ rec.evaluatePrefix("- 26 + 16 19000 / 33 - 2000 * 1000 35", stack2));
		
		stack2 = new Stack<>();
		System.out.println("Result of this postfix expression ( empty string ): " + rec.evaluatePrefix("", stack1));
		
		stack2 = new Stack<>();
		System.out.println("Result of this postfix expression ( null ): " + rec.evaluatePrefix(null, stack1));
		
		System.out.println();
		System.out.println();
		
		//Part6
		//printMatrix
		
		int [][] arr = {{0,1,2,3}, {13,14,15,4}, {12,19,16,5}, {11,18,17,6}, {10,9,8,7} };
		
		rec.printMatrix(arr, 0, 0, 1, 0, arr.length-1, 0, arr[0].length-1);
		
		System.out.println();
		System.out.println();
		
		int [][] arr2 = {{1, 2, 3, 4, 5, 6, 7},
						{ 8, 9,10,11,12,13,14},
						{15,16,17,18,19,20,21},
						{22,23,24,25,26,27,28},
						{29,30,31,32,33,34,35},
						{36,37,38,39,40,41,42}};
		
		rec.printMatrix(arr2, 0, 0, 1, 0, arr2.length-1, 0, arr2[0].length-1);
		
		System.out.println();
		System.out.println();
		
		
		int [][] arr3 = {{1, 2, 3, 4, 5, 6, 7, 8},
						{ 9,10,11,12,13,14,15,16},
						{17,18,19,20,21,22,23,24},
						{25,26,27,28,29,30,31,32},
						{33,34,35,36,37,38,39,40},
						{41,42,43,44,45,46,47,48},
						{49,50,51,52,53,54,55,56},
						{57,58,59,60,61,62,63,64}};
		
		rec.printMatrix(arr3, 0, 0, 1, 0, arr3.length-1, 0, arr3[0].length-1);
		
		System.out.println();
		System.out.println();
	
		
	}
}
