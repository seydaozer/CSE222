public class BranchEmployee extends Branch implements User {
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
	 * This method checks whether the object is there.
	 * @param object the Branch object.
	 * @return returns true if the object is there.
	 */
	@Override
	public boolean isInThere(Branch object) {
		BranchEmployee employee = (BranchEmployee) object;
		for(Branch b : branches) {
			if( employee.getBranchID() == b.getBranchID() ) {
				int index = b.employees.indexOf(employee);
				if(index != -1) 
					return true;
				else 
					return false;	
			}
		}
		return false;
	}
	
	/**
	 * This method adds the new package to company's array of packages.
	 * @param shipment Package of the package to be added.
	 */
	public void addPackage(Package shipment) {
		for( Package p : packages) {
			if(p.getTrackingNumber() == shipment.getTrackingNumber()) {
				System.out.println("Package with " + shipment.getTrackingNumber() + " tracking number is not added because it is already added.\n");
				return;
			}
		}
		packages.add(shipment);
		System.out.println("Package with " + shipment.getTrackingNumber() + " tracking number is added.\n");
	}

	/**
	 * This method removes the package from the company's array of packages.
	 * @param trackingNumber int value of the tracking number of the package to be removed.
	 */
	public void removePackage(int trackingNumber) {
		int index = -1;
		for( Package p : packages ) {
			if(p.getTrackingNumber() == trackingNumber) {
				index = packages.indexOf(p);
				p.setCurrentStatus("Transportation.");
			}
		}
		if(index == -1)
			System.out.println("package with " + trackingNumber + " tracking number is not removed because it is not found.\n");
		else {
			packages.remove(index);
			System.out.println("package with " + trackingNumber + " tracking number is removed.\n");
		}
	}
	
	/**
	 * This method This method adds the new customer to company's array of customers.
	 * @param newCustomer Customer of the customer to be added.
	 */
	public void addCustomer(Customer newCustomer) {
		for( Customer c : customers ) {
			if(c.getSsn() == newCustomer.getSsn()) {
				System.out.println("Customer named " + newCustomer.getName() + " " + newCustomer.getSurname() + " is not added because it is already added.\n");
				return;
			}
		}
		customers.add(newCustomer);
		System.out.println("Customer named " + newCustomer.getName() + " " + newCustomer.getSurname() + " is added.\n");
	}
	
	/**
	 * This method removes the customer from the company's array of customers.
	 * @param ssn string of the social security number of the customer to be removed.
	 */
	public void removeCustomer(String ssn) {
		int index = -1;
		for( Customer c : customers ) {
			if( ssn.equals(c.getSsn()) ) 
				index = customers.indexOf(c);
		}
		if(index == -1)
			System.out.println("Customer with " + ssn + " SSN is not removed because it is not found.\n");
		else {
			Customer c = customers.remove(index);
			System.out.println("Customer named " + c.getName() + " with " + ssn + " SSN is removed.\n");
		}
	}
	
	/**
	 * This method updates the current status of the package arriving at the branch.
	 * @param trackingNumber int value of the package's tracking number.
	 * @param branchID int value of the branch's ID that the package reached.
	 */
	public void packageInBranch(int trackingNumber, int branchID) {
		String currentStatus = "";
		for( Package p : packages ) {
			if( trackingNumber == p.getTrackingNumber() ) {
				for( Branch b : branches ) {
					if( branchID == b.getBranchID() ) {
						currentStatus += b.getBranchName() + " - " + branchID;
						p.setCurrentStatus(currentStatus);
						p.setBranchID(branchID);
					}
				}
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
		for( Package p : packages ) {
			if(trackingNumber == p.getTrackingNumber() && branchID == p.getBranchID() )
				p.setCurrentStatus(currentStatus);
		}
	}
	
	/**
	 * This method gets the branch employee's name.
	 * @return name string of the branch employee's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * This method sets the branch employee's name.
	 * @param name string of the branch employee's name.
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method gets the branch employee's surname.
	 * @return surname string of the branch employee's surname.
	 */
	@Override
	public String getSurname() {
		return surname;
	}

	/**
	 * This method sets the branch employee's surname.
	 * @param surname string of the branch employee's surname.
	 */
	@Override
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
