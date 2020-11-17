/**
 * @author Seyda Ozer
 */
public class Company {
	/**
	 * This static array of Package is the package array.
	 */
	protected static Package [] packages = new Package[0];
	
	/**
	 * This static array of Branch is the branch array.
	 */
	protected static Branch [] branches = new Branch[0];
	
	/**
	 * This static array of Customer is the customer array.
	 */
	protected static Customer [] customers = new Customer[0];
	
	/**
	 * This Administrator is the administrator.
	 */
	private Administrator admin;
	
	/**
	 * Company no-parameter Constructor
	 */
	public Company() { }
	
	/**
	 * This method gets the customer.
	 * @param ssn string of the social security number of the customer.
	 * @return Customer of the customer.
	 */
	public Customer getCustomer(String ssn) {
		for (Customer customer : customers) {
			if(ssn.equals(customer.getSsn()))
				return customer;
			else
				throw new NullPointerException("This company has not the customer.");
		}
		return null;	
	}
	
	/**
	 * @return the admin
	 */
	public Administrator getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}

	/**
	 *This method returns string representation of Company object.
	 *@return string of representation of Company object
	 */
	@Override
	public String toString() {
		String str = "";
		if(branches.length > 0) {
			str += "------------------------------\n";
			str += "This company's branches(name):\n";
			for(int i=0; i<branches.length; i++)
				str += branches[i].getName() + " ";
			str += "\n------------------------------\n";
		}
		if(packages.length > 0) {
			str += "-----------------------------------------\n";
			str += "This company's packages(tracking number):\n";
			for(int i=0; i<packages.length; i++)
				str += packages[i].getTrackingNumber() + " ";
			str += "\n-----------------------------------------\n";
		}
		if(customers.length > 0) {
			str += "---------------------------------------\n";
			str += "This company's customers(name-surname):\n";
			for(int i=0; i<customers.length; i++) {
				str += customers[i].getName() + " " + customers[i].getSurname();
				if(i != customers.length-1)
					str += ",";
				str += " ";
			}
			str += "\n---------------------------------------\n";
		}	
		return str;
	}
}