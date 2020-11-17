
public class FileSystemTest {
	public static void main(String [] args) {
		//Create a file system with root directory
		FileSystemTree myFileSystem = new FileSystemTree("root");
		myFileSystem.printFileSystem();
		
		/* Removing a directory or file, when the file system has
		   no directory or file except for root directory */
		try{
			myFileSystem.remove("root/first_directory");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Adding a directory
		myFileSystem.addDir("root/first_directory");
		/* Adding a directory to the directory but there is
		   a directory with the same name in the directory */
		try{
			myFileSystem.addDir("root/first_directory");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		//Adding a file
		myFileSystem.addFile("root/first_file.txt");
		/* Adding a file to the directory but there is
		   a file with the same name in the directory */
		try{
			myFileSystem.addFile("root/first_file.txt");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Removing root directory
		try{
			myFileSystem.remove("root");
		} catch (Exception e) {
			System.out.println(e);
		}

		myFileSystem.printFileSystem();
		
		/* Adding a directory to the directory 
		   that is not in the system */
		try{
			myFileSystem.addDir("root/third_directory/directory");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		/* Adding a file to the directory 
		   that is not in the system */
		try{
			myFileSystem.addFile("root/third_directory/file.txt");
		} catch (Exception e) {
			System.out.println(e);
		}

		/* Searching with string that is not in any directory 
		   or file on the file system. */
		
		System.out.println("Search file or directory names including “new”");
		myFileSystem.search("new");
		System.out.println("There are no results.");
		
		myFileSystem.addDir("root/photos");
		myFileSystem.addDir("root/photos/family");
		myFileSystem.addDir("root/first_directory/new_directory");
		myFileSystem.addDir("root/first_directory/new_directory/files");
		myFileSystem.addDir("root/members");
		myFileSystem.addFile("root/members/file1.txt");
		myFileSystem.addFile("root/members/file2.txt");
		
		// Searching with the valid string
		myFileSystem.printFileSystem();
		System.out.println("Search file or directory names including “f”");
		myFileSystem.search("f");
		
		//Removing the directory/file that is not in the system
		try{
			myFileSystem.remove("root/third_directory");
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// Removing a empty directory
		myFileSystem.remove("root/first_directory/new_directory/files");
		myFileSystem.printFileSystem();
		System.out.println();
		
		// Removing a file
		myFileSystem.remove("root/first_file.txt");
		myFileSystem.printFileSystem();
		System.out.println();
		
		// Removing a directory that is not empty
		myFileSystem.remove("root/members");
		myFileSystem.printFileSystem();
		
		

		
		
	}
}
