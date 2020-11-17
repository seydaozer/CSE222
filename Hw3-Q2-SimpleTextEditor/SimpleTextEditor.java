import java.io.*;
import java.lang.invoke.WrongMethodTypeException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * @author Seyda Ozer
 *SimpleTestEditor
 */
public class SimpleTextEditor {
    /**
     * This text is the List ( ArrayList or LinkedList )
     */
    private List<Character> text;

    /**
     * Constructor
     * @param choice this choice is ArrayList and LinkedList.
     * @throws WrongMethodTypeException if the choice is not equal to 1 or 2,
     * this method throws an exception.
     */
    public SimpleTextEditor(int choice) throws WrongMethodTypeException {
        if(choice == 1)
            text = new ArrayList<Character>();
        else if(choice == 2)
            text = new LinkedList<Character>();
        else
            throw new WrongMethodTypeException();
    }

    /**
     * This method reads from file with using loop.
     * @param filename string is the file name.
     */
    public void readWithLoop(String filename){
        try(FileReader file = new FileReader(filename)) {
            int ch;
            while ( (ch = file.read()) != -1 )
                text.add((char) ch);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This method reads from file with using iterator.
     * @param filename string is the file name.
     */
    public void readWithIterator(String filename){
        try(FileReader file = new FileReader(filename)) {
            ListIterator<Character> iter = text.listIterator();
            int ch;
            while ( (ch = file.read()) != -1 )
                iter.add((char) ch);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * This function adds with using loop the given string at the specified index.
     * @param str is string to be added
     * @param index is the specified index for adding string
     */
    public void addWithLoop(String str, int index) {
        ArrayList<Character> temp = new ArrayList<Character>();

        for(int i=0; i<index; i++)
            temp.add(text.get(i));

        for(int i=0; i<str.length(); i++)
            temp.add(str.charAt(i));

        for(int i=index; i<text.size(); i++)
            temp.add(text.get(i));

        text = new ArrayList<Character>(temp.size());
        for(int i=0; i<temp.size(); i++)
            text.add(temp.get(i));
    }

    /**
     * This function adds with using iterator the given string at the specified position.
     * @param str is string to be added
     * @param index is the specified position for adding string
     */
    public void addWithIterator(String str, int index){
        ArrayList<Character> temp = new ArrayList<Character>();
        ListIterator<Character> tempIter = temp.listIterator();

        ListIterator<Character> iter = text.listIterator();

        do {
            tempIter.add(iter.next());
        } while(iter.nextIndex() != index);

        for(int i=0; i<str.length(); i++)
            tempIter.add(str.charAt(i));

        do {
            tempIter.add(iter.next());
        } while(iter.nextIndex() != text.size());

        text = new ArrayList<Character>(temp.size());
        iter = text.listIterator();
        tempIter = temp.listIterator();
        while(tempIter.hasNext() != false)
            iter.add(tempIter.next());

    }

    /**
     * This method finds with using loop the given char array in the text.
     * It returns the start index of the first occurrence of the searched group of characters, otherwise returns -1.
     * @param find is the char array to be find
     * @return index is the start index of the char array
     */
    public int findWithLoop(char [] find){
        int index = 0, counter = 0;
        boolean flag;

        for(int i=0; i<text.size(); i++){
            if (text.get(i) == find[counter]) {
                if(counter == 0)
                    index = i;
                counter++;
                flag = true;
            }
            else{
                flag = false;
                counter = 0;
            }
            if(flag == true && counter == find.length)
                return index;
        }

        return -1;
    }

    /**
     * This method finds with using iterator the given char array in the text.
     * It returns the start index of the first occurrence of the searched group of characters, otherwise returns -1.
     * @param find is the char array to be find
     * @return index is the start index of the char array
     */
    public int findWithIterator(char [] find) {
        int index = 0, counter = 0;
        boolean flag;

        ListIterator<Character> iter = text.listIterator();

        while (iter.hasNext()){
            if(iter.next() == find[counter]){
                if(counter == 0)
                    index = iter.nextIndex() - 1;
                counter++;
                flag = true;
            }
            else{
                flag = false;
                counter = 0;
            }
            if(flag == true && counter == find.length)
                return index;
        }

        return -1;
    }

    /**
     * This method that replaces with using loop all occurrences of a character with another character.
     * @param removed char to be removed
     * @param added char to be added
     */
    public void replaceWithLoop(char removed, char added){
        for(int i=0; i<text.size(); i++) {
            if (text.get(i) == removed)
                text.set(i, added);
        }
    }

    /**
     * This method that replaces with using loop all occurrences of a character with another character.
     * @param removed char to be removed
     * @param added char to be added
     */
    public void replaceWithIterator(char removed, char added){
        ListIterator<Character> iter = text.listIterator();

        while(iter.hasNext() != false){
            if(iter.next() == removed)
                iter.set(added);
        }
    }

    /**
     * This method returns a string representation of the SimpleTextEditor object.
     * @return a string representation of the SimpleTextEditor object.
     */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();
        ListIterator<Character> iter = text.listIterator();

        while(iter.hasNext() != false)
            s.append(iter.next());
        s.append("\n");

        return s.toString();
    }
}
