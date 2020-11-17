import java.util.ArrayList;
import java.util.List;

/**
 * @author Seyda Ozer
 *
 */
public class Company {
	/**
	 * his static array of Package is the package array.
	 */
	protected static List<Package> packages = new ArrayList<Package>();
	
	/**
	 * This static array of Branch is the branch array.
	 */
	protected static List<Branch> branches = new ArrayList<Branch>();
	
	/**
	 * This static array of Customer is the customer array.
	 */
	protected static List<Customer> customers = new ArrayList<Customer>();
	
	/**
	 * This Administrator is the administrator.
	 */
	private Administrator admin;
	
	/**
	 * Company no-parameter Constructor
	 */
	public Company() { }
	
	/**
	 * This method gets the admin.
	 * @return admin Administrator of the admin.
	 */
	public Administrator getAdmin() {
		return admin;
	}

	/**
	 * This method sets the admin.
	 * @param admin the Administrator object.
	 */
	public void setAdmin(Administrator admin) {
		this.admin = admin;
	}
	
	/**
	 * This method gets a branch.
	 * @param branch the Branch object to be get.
	 * @return Branch object.
	 * @throws Exception If this method cannot find the branch, it throws the exception.
	 */
	public Branch getBranch(Branch branch) throws Exception {
		if(branches.size() > 0 && branches.get(0).isInThere(branch))
			return branch;
		else
			throw new Exception("This company has not the branch.\n");
	}
	
	/**
	 *This method returns string representation of Company object.
	 *@return string of representation of Company object
	 */
	@Override
	public String toString() {
		String str = "";
		if(branches.size() > 0) {
			str += "--------------------------------------------------\n";
			str += "This Company's Branches:\n";
			str += "Branch name:        Branch address:     Branch ID:\n";
			for( Branch b : branches ) {
				str += b.getBranchName();
				for(int i=0; i < ( 20 - b.getBranchName().length() ); i++)
					str += " ";
				str += b.getAddress();
				for(int i=0; i < ( 20 - b.getAddress().length() ); i++)
					str += " ";
				str += b.getBranchID();
				for(int i=0; i < 20; i++)
					str += " ";
				str += "\n";
			}
			str += "--------------------------------------------------\n";
		}
		if(packages.size() > 0) {
			str += "---------------------------------------------------------------------------------\n";
			str += "This Company's Packages:\n";
			str += "Sender:             Receiver:           Current Status:          Tracking Number:\n";
			for(Package p : packages) {
				str += p.getSender();
				for(int i=0; i < ( 20 - p.getSender().length() ); i++)
					str += " ";
				str += p.getReceiver();
				for(int i=0; i < ( 20 - p.getReceiver().length() ); i++)
					str += " ";
				str += p.getCurrentStatus();
				for(int i=0; i < ( 25 - p.getCurrentStatus().length() ); i++)
					str += " ";
				str += p.getTrackingNumber();
				for(int i=0; i < 16; i++)
					str += " ";
				str += "\n";
			}
			str += "---------------------------------------------------------------------------------\n";
		}
		if(customers.size() > 0) {
			str += "-----------------------------------------------------------------------\n";
			str += "This Company's Customers:\n";
			str += "Name:               Surname:            Phone Number:       SSN:\n";
			for(Customer c : customers) {
				str += c.getName();
				for(int i=0; i < ( 20 - c.getName().length() ); i++)
					str += " ";
				str += c.getSurname();
				for(int i=0; i < ( 20 - c.getSurname().length() ); i++)
					str += " ";
				str += c.getPhoneNumber();
				for(int i=0; i < ( 20 - c.getPhoneNumber().length() ); i++)
					str += " ";
				str += c.getSsn();
				for(int i=0; i < ( 20 - c.getSsn().length() ); i++)
					str += " ";
				str += "\n";	
			}
			str += "-----------------------------------------------------------------------\n";
		}
		return str;
	}
}
