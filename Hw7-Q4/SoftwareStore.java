
/**
 * @author Seyda Ozer
 *
 * @param <E> This is type of the data for the SoftwareStore.
 */
public class SoftwareStore<E> {
	/**
	 * This String is the password for admin login. 
	 */
	private final String PASSWORD = "12345";	
	/**
	 * If this variable is true, the user is admin.
	 */
	private boolean access;
	/**
	 * software packages in the store.
	 */
	private SearchTree<E> softwares;

	/**
	 * Constructor
	 * @param tree The search tree object determines the type of the softwares tree.
	 */
	@SuppressWarnings("unchecked")
	public SoftwareStore(SearchTree<E> tree) {
		softwares = tree;
		softwares.add((E) new Software("Adobe Photoshop 6.0", 100));
		softwares.add((E) new Software("Adobe Photoshop 6.2", 150));
		softwares.add((E) new Software("Norton 4.5", 100));
		softwares.add((E) new Software("Norton 5.5", 200));
		softwares.add((E) new Software("Adobe Flash 3.3", 100));
		softwares.add((E) new Software("Adobe Flash 4.0", 125));
	}
	
	// Methods
	/**
	 * Search by name
	 * @param name The name of the software package
	 * @return true if the package is found, otherwise false
	 */
	public boolean search(String name) {
		E obj = softwares.find((E) new Software(name, 0));
		if(obj == null) 
			return false;
		return true;
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
	 * Add software package into the store
	 * @param name The name of the package
	 * @param quantity The quantity of the package
	 * @param price The price of the package
	 */
	public void addPackage(String name, int quantity, double price) {
		if(access == false)
			return;
		
		Software item = new Software(name, quantity, price);
		E obj = softwares.find((E) item);
		if(obj == null) 
			softwares.add((E) item);
		else {
			int oldQuantity = ((Software) obj).getQuantity();
			((Software) obj).setQuantity(oldQuantity + quantity);
		}
	}
	
	/**
	 * Delete software package from the store
	 * @param name The name of the package
	 * @param quantity The quantity of the package
	 */
	public void deletePackage(String name, int quantity) {
		if(access == false)
			return;
		
		Software item = new Software(name, 0);
		E obj = softwares.find((E) item);
		if(obj != null) {
			int oldQuantity = ((Software) obj).getQuantity();
			if(oldQuantity - quantity >= 1)
				((Software) obj).setQuantity(oldQuantity - quantity);
			else
				softwares.delete((E) item);
		}
	}
	
	/**
	 * Update software package name
	 * @param name The new name
	 * @return true if the software name is replaced by the new name.
	 */ 
	public boolean updateName(String oldName, String newName) {
		if(access == false)
			return false;
		
		Software item = new Software(oldName, 0);
		@SuppressWarnings("unchecked")
		E obj = softwares.find((E) item);
		if(obj != null) {
			softwares.delete(obj);
			((Software) obj).setName(newName);
			softwares.add(obj);
			return true;
		}
		else
			return false;
	}
	
	/** Update software package quantity
	 * @param name The package name
	 * @param quantity The new quantity
	 * @return true if the software quantity is updated.
	 */
	public boolean updateQuantity(String name, int quantity) {
		if(access == false)
			return false;
		
		Software item = new Software(name, 0);
		E obj = softwares.find((E) item);
		if(obj != null) {
			((Software) obj).setQuantity(quantity);
			return true;
		}
		else
			return false;
	}
	
	/** Update software package price
	 * @param name The package name
	 * @param price The new price
	 * @return true if the software price is updated.
	 */
	public boolean updatePrice(String name, double price) {
		if(access == false)
			return false;
		
		Software item = new Software(name, 0);
		E obj = softwares.find((E) item);
		if(obj != null) {
			((Software) obj).setPrice(price);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Update the system when new software packages arrive at the store
	 * @param name The name
	 * @param quantity The quantity
	 * @param price The price
	 */
	public void arriveStore(String name, int quantity, double price) {
		access = true;
		addPackage(name, quantity, price);
		access = false;
	}
	
	/**
	 * Update the system when a software package is sold.
	 * @param name The name
	 * @param quantity The quantity
	 */
	public void leaveStore(String name, int quantity) {
		access = true;
		deletePackage(name, quantity);
		access = false;
	}
	
	 /**
     * This method returns a string representation of the SoftwareStore object.
     * @return a string representation of the SoftwareStore object.
     */
	@Override
	public String toString() {
		return softwares.toString();
	}
}
