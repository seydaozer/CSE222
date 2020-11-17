import java.util.ListIterator;

/**
 * @author Seyda Ozer
 * Test Class for the LinkedListArray
 */
public class Test {
    /**
     * This main method of this application.
     * @param args array of string arguments.
     */
    public static void main(String [] args){
        LinkedArrayList<Character> myList = new LinkedArrayList<Character>(Character.class);

        System.out.println("--------------------------------------------------------");
        if(myList.isEmpty())
            System.out.println("This list is empty.");
        else
            System.out.println("This list is not empty.");
        System.out.println("--------------------------------------------------------");
        System.out.println("The character 'S' is adding to the end of the list.");
        myList.add('S');
        System.out.println("The character 'E' is adding to the end of the list.");
        myList.add('E');
        System.out.println("--------------------------------------------------------");
        if(myList.isEmpty())
            System.out.println("This list is empty.");
        else
            System.out.println("This list is not empty.");
        System.out.println("--------------------------------------------------------");
        System.out.print(myList);
        System.out.println("--------------------------------------------------------");
        System.out.println("The character 'A' is adding to the 0. index of the list.");
        myList.add(0, 'A');
        System.out.print(myList);
        System.out.println("--------------------------------------------------------");
        System.out.println("The character 'K' is adding to the 1. index of the list.");
        myList.add(1, 'K');
        System.out.print(myList);
        System.out.println("--------------------------------------------------------");
        System.out.println("The character 'L' is adding to the end of the list.");
        myList.add('L');
        System.out.print(myList);
        System.out.println("--------------------------------------------------------");
        try {
            myList.add(20, 'J');
            System.out.println("The character 'J' is adding to the 20. index of the list.");
            System.out.print(myList);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
            System.out.println("The character 'J' is not added.");
        }
        try {
            myList.add(-1, 'Z');
            System.out.println("The character 'Z' is adding to the -1. index of the list.");
            System.out.print(myList);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
            System.out.println("The character 'Z' is not added.");
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("The character 'M' is adding to the 3. index of the list.");
        myList.add(3, 'M');
        System.out.print(myList);
        System.out.println("--------------------------------------------------------");
        System.out.print("The last character is: ");
        char c = myList.get(5);
        System.out.println(c);
        System.out.println("The character '" + c + "' is removing from the list.");
        myList.remove((Object) c);
        System.out.println("This character is removed.");
        System.out.print(myList);
        System.out.println("--------------------------------------------------------");
        System.out.println("The character 'A' is removing from the list.");
        myList.remove(0);
        System.out.print(myList);
        System.out.println("--------------------------------------------------------");

        try{
            myList.remove(-1);
            System.out.print(myList);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
            System.out.println("not removed.");
        }
        try{
            myList.remove(20);
            System.out.print(myList);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
            System.out.println("not removed.");
        }

        System.out.println("--------------------------------------------------------");
        try{
            c = myList.get(2);
            System.out.println("Element in index 2: " + c);
            System.out.println("Set index 2 with character 'V'");
            myList.set(2, 'V');
            System.out.println(myList);
        } catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }
        System.out.println("--------------------------------------------------------");

        System.out.println("The character 'L' is removing from the list.");
        if(myList.remove((Object) 'L'))
            System.out.println("This element 'L' is removed");
        else
            System.out.println("This element 'L' is not removed");
        System.out.println("--------------------------------------------------------");

        int index = myList.indexOf('S');
        if(index == -1)
            System.out.println("This element 'S' is not found in the list");
        else
            System.out.println("Index of 'S': " + index);

        System.out.println("First ýterator");
        ListIterator<Character> iterator = myList.listIterator();
        while(iterator.hasNext())
            System.out.println(iterator.next());

        System.out.println("Second ýterator");
        ListIterator<Character> iterator2 = myList.listIterator(2);
        while(iterator2.hasNext())
            System.out.println(iterator2.next());
    }
}
