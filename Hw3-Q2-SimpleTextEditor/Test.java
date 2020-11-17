import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * @author Seyda Ozer
 * Test Class for the SimpleTextEditor
 */
public class Test {
    /**
     * This main method of this application.
     * @param args array of string arguments.
     */
    public static void main(String [] args){
        String filename = "Text.txt";
        char [] arr2 = {'M', 'A', 'R', 'M', 'A', 'L', 'A', 'D', 'E'};
        //char [] arr2 = {'C', 'A', 'N'};

        try {
            Logger log = Logger.getLogger("SimpleTextEditor");

            FileHandler fh = new FileHandler("LogFile.log");
            log.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            log.info("SimpleTextEditor\n");

            //*******************ARRAYLIST********************//
            //USING LOOP//
            log.info("Using ArrayList");
            SimpleTextEditor textArrayList = new SimpleTextEditor(1);
            log.info("Using Loop methods");
            //Read with loop
            Instant start = Instant.now();
            textArrayList.readWithLoop(filename);
            Instant end = Instant.now();
            Duration timeElapsed = Duration.between(start, end);
            double tr1 = timeElapsed.toNanos();
            log.info("Running time for the read method with loop(ArrayList): " + tr1 + " nanoseconds");
            log.info(textArrayList.toString());
            //Add with loop
            start = Instant.now();
            textArrayList.addWithLoop("WONDERFUL ", 1704);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            double tr2 = timeElapsed.toNanos();
            log.info("Running time for the add method with loop(ArrayList): " + tr2 + " nanoseconds");
            log.info(textArrayList.toString());
            //Find with Loop
            start = Instant.now();
            int index = textArrayList.findWithLoop(arr2);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            double tr3 = timeElapsed.toNanos();
            log.info("Running time for the find method with loop(ArrayList): " + tr3 + " nanoseconds");
            log.info("This string " + " found on " + index + ". index.");
            //Replace with Loop
            start = Instant.now();
            textArrayList.replaceWithLoop('a', 'A');
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            double tr4 = timeElapsed.toNanos();
            log.info("Running time for the replace method with loop(ArrayList): " + tr4 + " nanoseconds");
            log.info(textArrayList.toString());

            textArrayList = new SimpleTextEditor(1);
            //USING ITERATOR//
            log.info("Using Iterator methods");
            //Read with iterator
            start = Instant.now();
            textArrayList.readWithIterator(filename);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr1 = timeElapsed.toNanos();
            log.info("Running time for the read method with iterator(ArrayList): " + tr1 + " nanoseconds");
            log.info(textArrayList.toString());
            //Add with iterator
            start = Instant.now();
            textArrayList.addWithIterator("WONDERFUL ", 1704);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr2 = timeElapsed.toNanos();
            log.info("Running time for the add method with iterator(ArrayList): " + tr2 + " nanoseconds");
            log.info(textArrayList.toString());
            //Find with iterator
            start = Instant.now();
            index = textArrayList.findWithIterator(arr2);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr3 = timeElapsed.toNanos();
            log.info("Running time for the find method with iterator(ArrayList): " + tr3 + " nanoseconds");
            log.info("This string " + " found on " + index + ". index.");
            //Replace with iterator
            start = Instant.now();
            textArrayList.replaceWithIterator('a', 'A');
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr4 = timeElapsed.toNanos();
            log.info("Running time for the replace method with iterator(ArrayList): " + tr4 + " nanoseconds");
            log.info(textArrayList.toString());


            //*******************LINKEDLIST********************//
            //USING LOOP//
            log.info("Using LinkedList");
            SimpleTextEditor textLinkedList = new SimpleTextEditor(2);
            log.info("Using Loop methods");
            //Read with loop
            start = Instant.now();
            textLinkedList.readWithLoop(filename);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr1 = timeElapsed.toNanos();
            log.info("Running time for the read method with loop(LinkedList): " + tr1 + " nanoseconds");
            log.info(textLinkedList.toString());
            //Add with loop
            start = Instant.now();
            textLinkedList.addWithLoop("WONDERFUL ", 1704);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr2 = timeElapsed.toNanos();
            log.info("Running time for the add method with loop(LinkedList): " + tr2 + " nanoseconds");
            log.info(textLinkedList.toString());
            //Find with Loop
            start = Instant.now();
            index = textLinkedList.findWithLoop(arr2);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr3 = timeElapsed.toNanos();
            log.info("Running time for the find method with loop(LinkedList): " + tr3 + " nanoseconds");
            log.info("This string " + " found on " + index + ". index.");
            //Replace with Loop
            start = Instant.now();
            textLinkedList.replaceWithLoop('a', 'A');
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr4 = timeElapsed.toNanos();
            log.info("Running time for the replace method with loop(LinkedList): " + tr4 + " nanoseconds");
            log.info(textLinkedList.toString());

            textLinkedList = new SimpleTextEditor(2);
            //USING ITERATOR//
            log.info("Using Iterator methods");
            //Read with iterator
            start = Instant.now();
            textLinkedList.readWithIterator(filename);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr1 = timeElapsed.toNanos();
            log.info("Running time for the read method with iterator(LinkedList): " + tr1 + " nanoseconds");
            log.info(textLinkedList.toString());
            //Add with iterator
            start = Instant.now();
            textLinkedList.addWithIterator("WONDERFUL ", 1704);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr2 = timeElapsed.toNanos();
            log.info("Running time for the add method with iterator(LinkedList): " + tr2 + " nanoseconds");
            log.info(textLinkedList.toString());
            //Find with iterator
            start = Instant.now();
            index = textLinkedList.findWithIterator(arr2);
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr3 = timeElapsed.toNanos();
            log.info("Running time for the find method with iterator(LinkedList): " + tr3 + " nanoseconds");
            log.info("This string " + " found on " + index + ". index.");
            //Replace with iterator
            start = Instant.now();
            textLinkedList.replaceWithIterator('a', 'A');
            end = Instant.now();
            timeElapsed = Duration.between(start, end);
            tr4 = timeElapsed.toNanos();
            log.info("Running time for the replace method with iterator(LinkedList): " + tr4 + " nanoseconds");
            log.info(textLinkedList.toString());

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println(e);
        }


    }
}
