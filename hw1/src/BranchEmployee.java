/**
 * @author Seyda Ozer
 *
 */
public class BranchEmployee extends Branch {
	/**
	 * This string is the name of the branch employee.
	 */
	private String name;
	
	/**
	 * This string is the surname of the branch employee.
	 */
	private String surname;
	
	/**
	 * This int value is the ID of the branch employee.
	 */
	private int ID;
	
	/**
	 * BranchEmployee six-parameter Constructor
	 * @param branchName string of the branch's name.
	 * @param address string of the branch's address.
	 * @param branchID int value of the branch's ID.
	 * @param name string of the branch employee's name.
	 * @param surname string of the branch employee's surname.
	 * @param ID int value of the branch employee's ID.
	 */
	public BranchEmployee(String branchName, String address, int branchID, String name, String surname, int ID) {
		super(branchName, address, branchID);
		this.name = name;
		this.surname = surname;
		this.ID = ID;
	}
	
	/**
	 * This method updates the current status of the package arriving at the branch.
	 * @param trackingNumber int value of the package's tracking number.
	 * @param branchID int value of the branch's ID that the package reached.
	 */
	public void packageInBranch(int trackingNumber, int branchID) {
		String currentStatus = "";
		for(int i=0; i<packages.length; i++) {
			if(trackingNumber == packages[i].getTrackingNumber()) {
				for(int j=0; j<branches.length; j++) {
					if(branchID == branches[j].getID()) {
						currentStatus += branches[j].getName() + " - " + branchID;
					}
				}
				packages[i].setCurrentStatus(currentStatus);
				packages[i].setBranchID(branchID);
			}
		}	
	}
	
	/**
	 * This method updates the current status of the package leaving the branch.
	 * @param trackingNumber int value of the package's tracking number.
	 * @param branchID int value of the branch's ID.
	 */
	public void packageOutBranch(int trackingNumber, int branchID) {
		String currentStatus = "in transfer";
		for(int i=0; i<packages.length; i++) {
			if(trackingNumber == packages[i].getTrackingNumber() && branchID == packages[i].getBranchID())
				packages[i].setCurrentStatus(currentStatus);
		}
	}
	
	/**
	 * This method adds the new package to company's array of packages.
	 * @param shipment Package of the package to be added.
	 */
	public void addPackage(Package shipment) {
		if(packages.length == 0) {
			packages = new Package[1];
			packages[0] = shipment;
		}
		else {
			for(int i=0; i<packages.length; i++) {
				if(shipment.getTrackingNumber() == packages[i].getTrackingNumber()) {
					System.out.println("package with " + shipment.getTrackingNumber() + " tracking number is not added because it is already added.\n");
					return;
				}
			}
			Package [] temp = new Package[packages.length];
			for(int i=0; i<packages.length; i++)
				temp[i] = packages[i];
			
			packages = new Package[packages.length+1];
			int i;
			for(i=0; i<temp.length; i++)
				packages[i] = temp[i];
			
			packages[i] = shipment;
		}
		System.out.println("package with " + shipment.getTrackingNumber() + " tracking number is added.\n");
	}
	
	/**
	 * This method creates a new package.
	 * @param sender string of the sender's name.
	 * @param receiver string  of the receiver's name.
	 * @param branchID int value of the ID of the branch where the package will be added.
	 * @param currentStatus string of the current status of the package.
	 * @param trackingNumber int value of the tracking number of the package.
	 */
	public void createPackage(String sender, String receiver, int branchID, String currentStatus, int trackingNumber) {
		Package temp = new Package(sender, receiver, branchID, currentStatus, trackingNumber);
		addPackage(temp);
	}
	
	/**
	 * This method removes the package from the company's array of packages.
	 * @param trackingNumber int value of the tracking number of the package to be removed.
	 */
	public void removePackage(int trackingNumber) {
		if(packages.length == 0) { //Package array is empty.
			System.out.println("This package is not found!");
			return;
		}
		boolean isIn = false;
		int index;
		for(index=0; index<packages.length; index++) {
			if(packages[index].getTrackingNumber() == trackingNumber) {
				packages[index].setCurrentStatus("Transportation.");
				isIn = true;
				break;
			}
		}
		if(isIn == true) {
			for(int i=index; i<packages.length-1; i++)
				packages[i] = packages[i+1];
			
			Package [] temp = new Package[packages.length-1];
			for(int i=0; i<temp.length; i++)
				temp[i] = packages[i];
			
			packages = new Package[packages.length-1];
			for(int i=0; i<packages.length; i++)
				packages[i] = temp[i];
			System.out.println("package with " + trackingNumber + " tracking number is removed.\n");
		}
		else 
			System.out.println("package with " + trackingNumber + " tracking number is not removed because it is not found.\n");
	}
	
	/**
	 * This method This method adds the new customer to company's array of customers.
	 * @param newCustomer Customer of the customer to be added.
	 */
	public void addCustomer(Customer newCustomer) {
		if(customers.length == 0) {
			customers = new Customer[1];
			customers[0] = newCustomer;
		}
		else {
			for(int i=0; i<customers.length; i++) {
				if(newCustomer.getSsn() == customers[i].getSsn()) {
					System.out.println("Customer named " + newCustomer.getName() + " " + newCustomer.getSurname() + " is not added because it is already added.\n");
					return;
				}
			}
			Customer [] temp = new Customer[customers.length];
			for(int i=0; i<customers.length; i++)
				temp[i] = customers[i];
			
			customers = new Customer[customers.length+1];
			int i;
			for(i=0; i<temp.length; i++)
				customers[i] = temp[i];
			
			customers[i] = newCustomer;
		}
		System.out.println("Customer named " + newCustomer.getName() + " " + newCustomer.getSurname() + " is added.\n");
	}
	
	/**
	 * This method removes the customer from the company's array of customers.
	 * @param ssn string of the social security number of the customer to be removed.
	 */
	public void removeCustomer(String ssn) {
		if(customers.length == 0)
			return;
		
		else {
			String name = "";
			boolean isIn = false;
			int index;
			for(index=0; index<customers.length; index++) {
				if( customers[index].getSsn().equals(ssn)) {
					isIn = true;
					name += customers[index].getName() + " " + customers[index].getSurname();
					break;
				}
			}
			if(isIn == true) {
				for(int i=index; i<customers.length-1; i++)
					customers[i] = customers[i+1];
				
				Customer [] temp = new Customer[customers.length-1];
				for(int i=0; i<temp.length; i++)
					temp[i] = customers[i];
				
				customers = new Customer[customers.length-1];
				for(int i=0; i<customers.length; i++)
					customers[i] = temp[i];
				System.out.println("Customer named " + name + " with " + ssn + " SSN is removed.\n");
			}
			else 
				System.out.println("Customer with " + ssn + " SSN is not removed because it is not found.\n");
		}
	}

	/**
	 * This method gets the branch employee's name.
	 * @return name string of the branch employee's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the branch employee's name.
	 * @param name string of the branch employee's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method gets the branch employee's surname.
	 * @return surname string of the branch employee's surname.
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * This method sets the branch employee's surname.
	 * @param surname string of the branch employee's surname.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}

	/**
	 * This method gets the branch employee's ID.
	 * @return ID int value of the branch employee's ID.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * This method sets the branch employee's ID.
	 * @param ID int value of the branch employee's ID.
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
}
