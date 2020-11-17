import java.util.ArrayList;
import java.util.List;

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
	private int branchID;
	
	/**
	 * This array of the BranchEmployee includes branch employees.
	 */
	protected List<BranchEmployee> employees;
	
	/**
	 * This array of the TransportationPersonel includes transportation personnel.
	 */
	protected List<TransportationPersonel> personnel;
	
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
		this.branchID = ID;
		employees = new ArrayList<BranchEmployee>();
		personnel = new ArrayList<TransportationPersonel>();
	}
	
	
	/**
	 * This method checks whether the object is there.
	 * @param object the Branch object.
	 * @return returns true if the object is there.
	 */
	public boolean isInThere(Branch object) {
		int index = branches.indexOf(object);
		if(index != -1) 
			return true;
		else
			return false;
	}

	/**
	 * This method gets the branch employee.
	 * @param employee BranchEmployee object to be get.
	 * @return BranchEmployee of the branch employee.
	 * @throws Exception If this method cannot find the branch employee, it throws the exception.
	 */
	public BranchEmployee getBranchEmployee(BranchEmployee employee) throws Exception {
		if(employees.size() > 0 && employees.get(0).isInThere(employee))
			return employee;
		else
			throw new Exception("This branch has not the branch employee.");
	}
	
	/**
	 * This method gets the transportation personel.
	 * @param personel TransportationPersonel object to be get.
	 * @return TransportationPersonel of the transportation personel.
	 * @throws Exception If this method cannot find the transportation personel, it throws the exception.
	 */
	public TransportationPersonel getTransportationPersonel(TransportationPersonel personel) throws Exception {
		if(personnel.size() > 0 && personnel.get(0).isInThere(personel))
			return personel;
		else
			throw new Exception("This branch has not the transportation personel.");
	}
	
	/**
	 * This method gets the branch's name.
	 * @return name string of the branch's name.
	 */
	public String getBranchName() {
		return name;
	}

	/**
	 * This method sets the branch's name.
	 * @param name string of the branch's name.
	 */
	public void setBranchName(String name) {
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
	public int getBranchID() {
		return branchID;
	}

	/**
	 * This method sets the branch's ID.
	 * @param ID int value of the branch's ID.
	 */
	public void setBranchID(int ID) {
		this.branchID = ID;
	}
	
	/**
	 *This method returns string representation of Branch object.
	 *@return string of representation of Branch object
	 */
	@Override
	public String toString() {
		String str = "";
		if(employees.size() > 0) {
			str += "-------------------------------------------\n";
			str += "Branch Employees in " + name + " Branch:\n";
			str += "Name:               Surname:            ID:\n";
			for( BranchEmployee e : employees ) {
				str += e.getName();
				for(int i=0; i < ( 20 - e.getName().length() ); i++)
					str += " ";
				str += e.getSurname();
				for(int i=0; i < ( 20 - e.getSurname().length() ); i++)
					str += " ";
				str += e.getID();
				for(int i=0; i < 20; i++)
					str += " ";
				str += "\n";
			}
			str += "-------------------------------------------\n";
		}
		if(personnel.size() > 0) {
			str += "-------------------------------------------\n";
			str += "Transportation Personnel in " + name + " Branch:\n";
			str += "Name:               Surname:            ID:\n";
			for( TransportationPersonel p : personnel ) {
				str += p.getName();
				for(int i=0; i < ( 20 - p.getName().length() ); i++)
					str += " ";
				str += p.getSurname();
				for(int i=0; i < ( 20 - p.getSurname().length() ); i++)
					str += " ";
				str += p.getID();
				for(int i=0; i < 20; i++)
					str += " ";
				str += "\n";
			}
			str += "-------------------------------------------\n";
		}
		return str;
	}
}
