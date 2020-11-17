/**
 * @author Seyda Ozer
 *
 */
public class Branch extends Company {
	/**
	 * This string is the name of the branch.
	 */
	private String name;
	
	/**
	 * This string is the address of the branch.
	 */
	private String address;
	
	/**
	 * This int value is the private ID of the branch.
	 */
	private int ID;
	
	/**
	 * This array of the BranchEmployee includes branch employees.
	 */
	protected BranchEmployee [] employees;
	
	/**
	 * This array of the TransportationPersonel includes transportation personnel.
	 */
	protected TransportationPersonel [] personnel;
	
	
	/**
	 * Branch three-parameter Constructor
	 * @param name string of the branch's name.
	 * @param address string of the branch's address.
	 * @param ID int value of the branch's ID.
	 */
	public Branch(String name, String address, int ID) {
		super();
		this.name = name;
		this.address = address;
		this.ID = ID;
		employees = new BranchEmployee[0];
		personnel = new TransportationPersonel[0];
	}
	
	/**
	 * This method gets the branch employee.
	 * @param ID int value of the ID of the branch employee.
	 * @return BranchEmployee of the branch employee.
	 */
	public BranchEmployee getBranchEmployee(int ID) {
		for (BranchEmployee employee : employees) {
			if(ID == employee.getID())
				return employee;
			else
				throw new NullPointerException("This branch has not the employee.");
		}
		return null;	
	}
	
	/**
	 * This method gets the transportation personel.
	 * @param ID int value of the ID of the transportation personel.
	 * @return TransportationPersonel of the transportation personel.
	 */
	public TransportationPersonel getTransportationPersonel(int ID) {
		for (TransportationPersonel personel : personnel) {
			if(ID == personel.getID())
				return personel;
			else
				throw new NullPointerException("This branch has not the personel.");
		}
		return null;	
	}

	/**
	 * This method gets the branch's name.
	 * @return name string of the branch's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the branch's name.
	 * @param name string of the branch's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method gets the branch's address.
	 * @return address string of the branch's address.
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * This method sets the branch's address.
	 * @param address string of the branch's address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method gets the branch's ID.
	 * @return ID int value of the branch's ID.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * This method sets the branch's ID.
	 * @param ID int value of the branch's ID.
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
	
	/**
	 *This method returns string representation of Branch object.
	 *@return string of representation of Branch object
	 */
	@Override
	public String toString() {
		String str = "";
		if(employees.length != 0) {
			str += "----------------------------------------------\n";
			str += name + " branch's branch employees(name-surname):\n";
			for(int i=0; i<employees.length; i++) {
				str += employees[i].getName() + " " + employees[i].getSurname();
				if(i != employees.length-1)
					str += ",";
				str += " ";
			}
			str += "\n----------------------------------------------\n";
		}
		if(personnel.length != 0) {
			str += "------------------------------------------------------\n";
			str += name + " branch's transportation personnel(name-surname):\n";
			for(int i=0; i<personnel.length; i++) {
				str += personnel[i].getName() + " " + personnel[i].getSurname();
				if(i != personnel.length-1)
					str += ",";
				str += " ";
			}
			str += "\n------------------------------------------------------\n";
		}
		return str;
	}
}