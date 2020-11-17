import java.util.Scanner;

public class LibrarySystemTest {
	public static void main(String [] args) {
		LibrarySystem library = new LibrarySystem();
		//test1
		library.searchAuthor("Seyda");
		//test2
		library.searchBook("book1");
		//test3
		library.addBook();
		//test4
		library.deleteBook();
		//test5
		library.update();
		
		library.loginAdmin("12345");
		//test6
		library.addBook();
		//test7
		library.addBook();
		//test8
		library.addBook();
		//test9
		library.addBook();
		//test10
		library.addBook();
		//test11
		library.searchAuthor("Seyda");
		//test12
		library.searchBook("book1");
		//test13
		library.deleteBook();
		//test14
		library.deleteBook();
		
		library.searchBook("book1");
		//test15
		library.deleteBook();
		library.deleteBook();
		library.deleteBook();
		//test16
		library.update();
		//test16 result
		library.searchBook("book2");
	}

}
