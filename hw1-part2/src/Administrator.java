/**
 * @author Seyda Ozer
 *
 */
public class Administrator extends Company implements User {
	/**
	 * This string is the name of the administrator.
	 */
	private String name;
	
	/**
	 * This string is the surname of the administrator.
	 */
	private String surname;
	
	/**
	 * Administrator two-parameter Constructor
	 * @param name string of the administrator's name.
	 * @param surname string of the administrator's surname.
	 */
	public Administrator(String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	/**
	 * This method adds the new branch to company's array of branches.
	 * @param newBranch Branch of the branch to be added.
	 */
	public void addBranch(Branch newBranch) {
		if(branches.size() > 0 && branches.get(0).isInThere(newBranch)) {
			System.out.println(newBranch.getBranchName() + " branch is not added.\n");
			return;
		}

		branches.add(newBranch);
		System.out.println(newBranch.getBranchName() + " branch is added.\n");
	}
	
	/**
	 * This method removes the branch from the company's array of branches.
	 * @param removed Branch of the branch to be removed.
	 */
	public void removeBranch(Branch removed) {
		int index = branches.indexOf(removed);
		if( index != -1) {
			branches.remove(index);
			System.out.println(removed.getBranchName() + " branch is removed.\n");
		}
		else 
			System.out.println(removed.getBranchName() + " branch is not removed because this branch is not found!\n");	
	}
	
	/**
	 * This method adds the new branch employee to company's array of employees.
	 * @param newEmployee BranchEmployee of the branch employee to be added.
	 * @param branchID int value of the ID of the branch where the branch employee will be added.
	 */
	public void addBranchEmployee(BranchEmployee newEmployee, int branchID) {
		boolean flag = false;
		for( Branch b : branches ) {
			if(b.getBranchID() == branchID) {
				flag = true;
				if( b.employees.size() > 0 && b.employees.get(0).isInThere(newEmployee) ) {
					System.out.println(newEmployee.getName() + " branch employee is not added to branch employees in " + b.getBranchName() + " branch.\n");
					return;
				}
				b.employees.add(newEmployee);
				int index = b.employees.indexOf(newEmployee);
				b.employees.get(index).setBranchID(b.getBranchID());
				b.employees.get(index).setBranchName(b.getBranchName());
				b.employees.get(index).setAddress(b.getAddress());
				System.out.println(newEmployee.getName() + " " + newEmployee.getSurname() + " is added to branch employees in " + b.getBranchName() + " branch.\n");
			}
		}
		if(flag == false)
			System.out.println("The branch with " + branchID + " ID is not found in the company.\n");
	}

	/**
	 * This method removes the branch employee from the company's array of employees.
	 * @param removed BranchEmployee of the branch employee to be removed.
	 * @param branchID int value of the ID of the branch where the branch employee will be removed.
	 */
	public void removeBranchEmployee(BranchEmployee removed,  int branchID) {
		for( Branch b : branches ) {
			if(b.getBranchID() == branchID) {
				int index = b.employees.indexOf(removed);
				if( index != -1 ) {
					b.employees.remove(index);
					System.out.println(removed.getName() + " " + removed.getSurname() + " is removed from branch employees in " + b.getBranchName() + " branch.\n");
				}
				else 
					System.out.println(removed.getName() + " " + removed.getSurname() + " is not removed from branch employees in " + b.getBranchName() + " branch because this is not found.\n");			
			}
		}
	}
	
	/**
	 * This method adds the new transportation personel to company's array of personnel.
	 * @param newPersonel TransportationPersonel of the transportation personel to be added.
	 * @param branchID int value of the ID of the branch where the transportation personel will be added.
	 */
	public void addTransportationPersonel(TransportationPersonel newPersonel, int branchID) {
		boolean flag = false;
		for( Branch b : branches ) {
			if(b.getBranchID() == branchID) {
				flag = true;
				if(b.personnel.size() > 0 && b.personnel.get(0).isInThere(newPersonel) ) {
					System.out.println(newPersonel.getName() + " " + newPersonel.getSurname() + " is not added to transportation personnel in " + b.getBranchName() + " branch.\n");
					return;	
				}
				b.personnel.add(newPersonel);
				int index = b.personnel.indexOf(newPersonel);
				b.personnel.get(index).setBranchID(b.getBranchID());
				b.personnel.get(index).setBranchName(b.getBranchName());
				b.personnel.get(index).setAddress(b.getAddress());
				System.out.println(newPersonel.getName() + " " + newPersonel.getSurname() + " is added to transportation personnel in " + b.getBranchName() + " branch.\n");
			}
		}
		if(flag == false)
			System.out.println("The branch with " + branchID + " ID is not found in the company.\n");
	}
	
	/**
	 * This method removes the transportation personel from the company's array of personnel.
	 * @param removed TransportationPersonel of the transportation personel to be removed.
	 * @param branchID int value of the ID of the branch where the transportation personel will be removed.
	 */
	public void removeTransportationPersonel(TransportationPersonel removed, int branchID) {
		for( Branch b : branches ) {
			if(b.getBranchID() == branchID) {
				int index = b.personnel.indexOf(removed);
				if( index != -1 ) {
					b.personnel.remove(index);
					System.out.println(removed.getName() + " " + removed.getSurname() + " is removed from transportation personnel in " + b.getBranchName() + " branch.\n");
				}
				else 
					System.out.println(removed.getName() + " " + removed.getSurname() + " is not removed from transportation personnel in " + b.getBranchName() + " branch because this is not found.\n");			
			}
		}
	}
	
	/**
	 * This method gets the administrator's name.
	 * @return name string of the administrator's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * This method sets the administrator's name.
	 * @param name string of the administrator's name.
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method gets the administrator's surname.
	 * @return surname string of the administrator's surname.
	 */
	@Override
	public String getSurname() {
		return surname;
	}

	/**
	 * This method sets the administrator's surname.
	 * @param surname string of the administrator's surname.
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
