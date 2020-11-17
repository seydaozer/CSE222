import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LibrarySystem {
	/**
	 * This String is the password for admin login. 
	 */
	private final String PASSWORD = "12345";
	
	/**
	 * The map contains the books.
	 * key: author name of the book
	 * value: the other map ( inner map )
	 * The inner map : 
	 * key: title of the book
	 * value: set of the location of the book
	 */
	private Map< String, Map< String, Set<String> > > library;
	
	/**
	 * If this variable is true, the user is admin.
	 */
	private boolean access;
	
	/**
	 * LibrarySystem Constructor
	 */
	public LibrarySystem(){
		library = new HashMap();
		access = false;
	}
	
	/**
	 * Search by author name.
	 * All books of the author in the library will be listed on the screen.
	 * Then, the location(s) of the selected book will be displayed.
	 * @param author The author name
	 */
	public void searchAuthor(String author) {
		// author name is outer map's key.
		Map< String, Set<String> > lib = library.get(author);
		if(lib == null) {
			System.out.println("No books for this author were found.");
			return;
		}
		
		Set<String> books = lib.keySet();
		int i = 1;
		System.out.println("The author's books:");
		for(String book : books) {
			System.out.println(i + " - " + book);
			i++;
		}
		System.out.println("\nEnter the title of the book.");
		Scanner scan = new Scanner(System.in);
		String choice = scan.next();
		
		Set<String> locations = lib.get(choice);
		if(locations == null) {
			System.out.println("This book is not found.");
			return;
		}
		System.out.println("\nThe locations of the book:");
		for(String loc : locations) {
			System.out.println("- " + loc);
		}
		
	}
	
	/**
	 * Search by book name.
	 * Show the information about the book.
	 * @param title The title of the book
	 */
	public void searchBook(String title) {
		boolean flag = false;
		Set<String> authors = library.keySet();
		for(String aut : authors) {
			Set<String> locations = library.get(aut).get(title);
			if(locations != null) {
				flag = true;
				System.out.println("\nInformations of the book(" + title + ") :");
				System.out.println("Author name: " + aut);
				System.out.println("Location(s):");
				for(String loc : locations)
					System.out.println("- " + loc);		
			}
		}
		if(flag == false)
			System.out.println("This book is not found!");
	}
	
	/**
	 * Administrator login with password
	 * @param password The password for entering the system
	 */
	public void loginAdmin(String password) {
		if( password.equals(PASSWORD) )
			access = true;
	}
	
	/**
	 * Adding a book to the library system.
	 * This method gets the book information from user and adds the book to system.
	 */
	public void addBook( ) {
		if(access == false)
			return;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\nAdding book process\nEnter the book informations:");
		System.out.println("The book's name: ");
		String title = scan.next();
		System.out.println("The author's name: ");
		String author = scan.next();
		System.out.println("The location: ");
		String location = scan.next();
		
		addBook(author, title, location);
	}
	
	/**
	 * Helper add method
	 * @param author The author name of the book
	 * @param title The title of the book
	 * @param location The location of the book
	 */
	private void addBook(String author, String title, String location) {
		boolean added = true;
		// searching author
		Map< String, Set<String> > aut = library.get(author); 
		if(aut == null) { // the system does not have the author
			// creating the book
			Map< String, Set<String> > book = new HashMap();
			Set<String> locations = new HashSet();
			locations.add(location);
			book.put(title, locations);
			//adding the author and author's book to the system
			library.put(author, book);
		} else {  // the system has the author
			// searching book
			Set<String> locations = aut.get(title); 
			if(locations == null) { // the author does not have the book
				// adding the book
				locations = new HashSet();
				locations.add(location); // create location
				aut.put(title, locations); // add book
			} else { // the author has the book already
				// adding location
				if(locations.contains(location))
					added = false;
				else {
					locations.add(location);
					//update
					aut.put(title, locations);
				}
			}
		}
		if(added == true)
			System.out.println("This book is added.\n");
		else
			System.out.println("This book is already added.\n");
	}
	
	/**
	 * Deleting a book to the library system.
	 * This method gets the book information from user and deletes the book from system.
	 */
	public void deleteBook() {
		if(access == false)
			return;
		
		Scanner scan = new Scanner(System.in);
		System.out.println("\nDeleting book process\nEnter the book informations:");
		System.out.println("The book's name: ");
		String title = scan.next();
		System.out.println("The author's name: ");
		String author = scan.next();
		System.out.println("The location: ");
		String location = scan.next();
		
		deleteBook(author, title, location);
	}
	
	/**
	 * Helper delete method
	 * @param author The author name of the book
	 * @param title The title of the book
	 * @param location The location of the book
	 */
	private void deleteBook(String author, String title, String location) {
		// searching author
		Map< String, Set<String> > aut = library.get(author); 

		if(aut != null) {  // the system has the author
		// searching book
			Set<String> locations = aut.get(title);
			if(locations != null) { // the author has the book
				// control location
				if(!locations.contains(location))
					System.out.println("This book is not found.\n");
				else{
					if(locations.size() == 1) { // there is one copy
						//deleting the book
						aut.remove(title);
					} else { // there is more than one copy
						// deleting one of the copies
						locations.remove(location);
					}
					System.out.println("This book is deleted.\n");
				}
			} else {
				System.out.println("This book is not found.\n");
			}
		} else {
			System.out.println("This book is not found.\n");
		}
	
	}
	
	/**
	 * This method update the book location.
	 */
	public void update() {
		if(access == false)
			return;
		
		// location update
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the name and author of the book you want to update, respectively.");
		String title = scan.next();
		String author = scan.next();

		System.out.println("Location(s) of the book:");
		for(String loc : library.get(author).get(title)) {
			System.out.println("- " + loc);
		}
		
		System.out.println("Please enter the location you want to remove and add, respectively.");
		String oldLoc = scan.next();
		String newLoc = scan.next();
		for(String loc : library.get(author).get(title)) {
			if(loc.equals(oldLoc)){
				library.get(author).get(title).remove(oldLoc);
				library.get(author).get(title).add(newLoc);
			}
		}
	}
	
}
