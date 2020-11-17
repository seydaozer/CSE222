import java.util.*;

/**
 * @author Seyda Ozer
 * FileSystemTree Class
 */
public class FileSystemTree {
	/**
	 * @author Seyda Ozer
	 * Class to encapsulate a file system tree node.
	 * @param <E> This is type of the data for the FileNode.
	 */
	private static class FileNode {
		/**
		 * The information stored in this node.
		 */
		private String data;
		/**
		 * References to the children.
		 */
		private LinkedList<FileNode> children = new LinkedList<FileNode>();
		/**
		 * This value determines the type of node.
		 * If it is equals to 1, the node is a directory.
		 * If it is equals to 2, the node is a file.
		 */
		private int type;

		/**
		 * Construct a node with given data and no children.
		 * @param theData The data to store in this node
		 * @param _type The type for the node
		 */
		public FileNode(String theData, int _type) {
			data = theData;
			type = _type;
		}
		
		/**
		 * This method checks whether the node is an file.
		 * @return true if the node is file, false otherwise
		 */
		public boolean isFile() {
			return (type == 2);
		}
		
		/**
		 * Return a string representation of the node.
		 * @return A string representation of the data fields
		 */
		@Override
		public String toString() {
			StringBuilder s = new StringBuilder();
			s.append(data);
		
			return s.toString();	
		}		
	}
	
	// Data Field
	
	/**
	 * The root of the file system tree
	 */
	private FileNode root;
	
	// Constructor
	
	/**
	 * The one-parameter constructor
	 * @param data to be referenced by the root node
	 */
	public FileSystemTree(String data) {
		root = new FileNode(data, 1);
	}
	
	// Methods
	
	/**
	 * This method inserts the file the tree.
	 * @param file The path of the file to be added
	 * @throws NullPointerException if the path is invalid, this method throws exception.
	 * @throws UnsupportedOperationException if this file is already added, this method throws exception.
	 */
	public void addFile(String file) throws NullPointerException {
		ArrayList<String> path = new ArrayList<String>();
		directories(file, path);
		
		FileNode parent = controlPath(root, path, 0);

		if(parent == null)
			throw new NullPointerException("The path cannot be found!");
		
		if(!parent.isFile()) {
			FileNode child = new FileNode(path.get(path.size()-1), 2);
			if(!isChild(parent, child))
				parent.children.add(child);
			else
				throw new UnsupportedOperationException("This file is already added.");
		}	
	}
	
	/**
	 * This method inserts the directory the tree.
	 * @param dir The path of the directory to be inserted
	 * @throws NullPointerException if the path is invalid, this method throws exception.
	 * @throws UnsupportedOperationException if this directory is already added, this method throws exception.
	 */
	public void addDir(String dir) throws NullPointerException {
		ArrayList<String> path = new ArrayList<String>();
		directories(dir, path);

		FileNode parent = controlPath(root, path, 0);
		
		if(parent == null)
			throw new NullPointerException("The path cannot be found!");

		if(!parent.isFile()) {
			FileNode child = new FileNode(path.get(path.size()-1), 1);
			if(!isChild(parent, child))
				parent.children.add(child);
			else
				throw new UnsupportedOperationException("This directory is already added.");
		}
	}
	
	/**
	 * Returns true if this directory node contains the specified node
	 * @param parent the parent node whose children will be checked
	 * @param child the node being sought
	 * @return true if this parent node contains the child node
	 */
	private boolean isChild(FileNode parent, FileNode child) {
		for(int i=0; i<parent.children.size(); i++) {
			if(parent.children.get(i).data.equals(child.data) &&
					parent.children.get(i).type == child.type)
				return true;
		}
		return false;
	}
	
	/**
	 * This method adds the files or directories in the taken string to ArrayList.
	 * @param path The path of the directory (or file)
	 * @param files The ArrayList includes the directories in the path
	 */
	private void directories(String path, ArrayList<String> files) {
		if(path.isEmpty())
			return;
		
		if(! path.contains("/") ) {
			files.add(path);
			return;
		}
		
		int index = path.indexOf('/');
		files.add(path.substring(0, index));
		directories(path.substring(index+1), files);
	
	}
	
	/**
	 * This method checks whether the taken path is valid
	 * @param localRoot The local subtree's root
	 * @param files The ArrayList keeps the files on the path
	 * @param index The index for ArrayList
	 * @return The last directory/file (except for the file to be processed) on the path, if the path is valid
	 */
	private FileNode controlPath(FileNode localRoot, ArrayList<String> files, int index) {
		if(localRoot == null)
			return null;
		
		if(index == files.size()-2)
			return localRoot;
		
		String file = files.get(index);
		
		if(localRoot.data.equals(file)) {
			FileNode child = findDir(localRoot, files.get(index+1));
			if(child != null) {
				return controlPath(child, files, index+1);
			}
		}
		return null;
	}
	
	/**
	 * If the taken file name is equals to a child of the taken directory node,
	 * this method returns the child, otherwise null.
	 * @param dir The directory node to be checked
	 * @param fileName The name of the searched file
	 * @return returns a child of the directory if there is a match, otherwise null.
	 */
	private FileNode findDir(FileNode dir, String fileName) {
		Iterator<FileNode> iter = dir.children.listIterator();
		
		while(iter.hasNext()) {
			FileNode temp = iter.next();
			if(temp.data.equals(fileName))
				return temp;
		}
		
		return null;
	}
	
	/**
	 * This method removes the directory/file from the tree.
	 * @param path The path of the directory/file to be removed
	 * @throws NullPointerException if the path is invalid, this method throws exception.
	 * @throws  UnsupportedOperationException if the file to be removed is equals the root or 
	 * 			The file system has no file or directory except for root directory, this method throws exception.
	 */
	public void remove(String path) throws NullPointerException{
		if(isEmpty()) 
			throw new UnsupportedOperationException("The file system has no file or directory except for root directory.");
		
		ArrayList<String> thePath = new ArrayList<String>();	
		directories(path, thePath);
		
		if(thePath.size() == 1 && root.data.equals(thePath.get(0)))
			throw new UnsupportedOperationException("The root cannot removed!");

		FileNode parent = controlPath(root, thePath, 0);
		FileNode child = findDir(parent, thePath.get(thePath.size()-1));
		
		if(child == null)
			throw new NullPointerException("The path cannot be found!!");
		
		if(child.isFile())
			parent.children.remove(child);
		else {
			if(child.children.size() == 0)
				parent.children.remove(child);
			else {
				System.out.println("The directory includes some other directories and files:");
				for(int i=0; i<child.children.size(); i++) {
					System.out.print(child.children.get(i));
					if(i != child.children.size()-1)
						System.out.print(" - ");
				}
				System.out.println("\nare you sure you want to remove the directory? (y/Y)");
				Scanner scan = new Scanner(System.in);
				String choice = scan.next();
				
				if(choice.equals("y") || choice.equals("Y")) {
					child.children.clear();
					parent.children.remove(child);
				}
			}
		}
	}
	
	/**
	 * Return true, if the file system has no directory or file except for root directory
	 * @return true if there is no file or directory other than root
	 */
	public boolean isEmpty() {
		if(root.children.isEmpty())
			return true;
		return false;
	}
		
	/**
	 * This method prints the whole tree.
	 * This method takes an node and prints the all children of the node.
	 * If the node is file or has no children, this method prints the path.
	 */
	public void printFileSystem() {
		if(isEmpty()) {
			System.out.println("root");
			return;
		}
		ArrayList<String> path = new ArrayList<String>();
		path.add(root.data);
		printFileSystem(root, path);
	}
	
	/**
	 * Recursive printFileSystem method
	 * This method takes an node and prints the all children of the node.
	 * If the node is file or has no children, this method prints the path.
	 * @param localRoot The local subtree's root
	 * @param path The ArrayList contains the path for each file/directory.
	 */
	private void printFileSystem(FileNode localRoot, ArrayList<String> path) {		
		Iterator<FileNode> iter = localRoot.children.listIterator();
		
		while(iter.hasNext()) {			
			FileNode child = iter.next();
			path.add(child.toString());
			
			if(child.children.isEmpty() || child.isFile())
				System.out.println(printPath(path));
			
			else if(!child.children.isEmpty())
				printFileSystem(child, path);
			
			//removes the printed nodes from the list.
			removeFileToPath(localRoot, path);
		}
	}
	
	/**
	 * This method removes the part of the tree is printed from the ArrayList path.
	 * If all children of the parent node have been printed, that node is removed.
	 * that parent node is removes from Arraylist path.
	 * @param parent The FileNode to be checkhed
	 * @param path The path of directories and files
	 */
	private void removeFileToPath(FileNode parent, ArrayList<String> path) {
		boolean flag = false;
		Iterator<FileNode> iter = parent.children.listIterator();

		while(iter.hasNext()) {
			FileNode node = iter.next();
			path.remove(node.data);
			
			if(path.contains(node.data))
				flag = true;
			else
				flag = false;
		}
		//If the path contains all the children of the parent node, the parent node is removed.
		if(flag == true)
			path.remove(parent.data);
	}
	
	/**
	 * This method converts the String ArrayList to String and
	 * adds the '/' character between the elements of ArrayList.
	 * @param path The ArrayList to be converted
	 * @return The String of the path
	 */
	private String printPath(ArrayList<String> path) {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<path.size(); i++) {
			sb.append(path.get(i));
			if(i != path.size()-1)
				sb.append(" / ");
		}
		return sb.toString();
	}
	
	/**
	 * This method searches the file system for a directory 
	 * or a file including the given string.
	 * This method takes a node and controls all the children of the node.
	 * If this node contains the target, the method prints the path and continues searching.
	 * @param target The string being sought
	 */
	public void search(String target) {
		ArrayList<String> path = new ArrayList<String>();
		path.add(root.data);
		search(root, path, target);	
	}
	
	/**
	 * Recursive search method
	 * This method takes a node and controls all the children of the node.
	 * If this node contains the target, the method prints the path and continues searching.
	 * @param localRoot The local subtree's root
	 * @param path The ArrayList contains the path for each file/directory.
	 * @param target The string being sought
	 */
	private void search(FileNode localRoot, ArrayList<String> path, String target) {
		Iterator<FileNode> iter = localRoot.children.listIterator();
		
		while(iter.hasNext()) {			
			FileNode child = iter.next();
			path.add(child.toString());
			
			if(child.data.contains(target)) {
				if(child.isFile())
					System.out.print("file - ");
				else
					System.out.print("dir - ");
				System.out.println(printPath(path));
			}
			if(!child.children.isEmpty())
				search(child, path, target);
			
			//removes the printed nodes from the list.
			removeFileToPath(localRoot, path);
		}
	}

}
