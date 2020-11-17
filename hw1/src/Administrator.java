/**
 * @author Seyda Ozer
 *
 */
public class Administrator extends Company {
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
		if( branches.length == 0) {
			branches = new Branch[1];
			branches[0] = newBranch;
		}
		else {
			for(int i=0; i<branches.length; i++) {
				if(newBranch.getID() == branches[i].getID()) {
					System.out.println(newBranch.getName() + " branch is not added. Because it is already added.\n");
					return;
				}
			}
			Branch [] temp = new Branch[branches.length];
			for(int i=0; i<branches.length; i++) 
				temp[i] = branches[i];
			
			branches = new Branch[branches.length+1];
			int i;
			for(i=0; i<temp.length; i++) 
				branches[i] = temp[i];
			
			branches[i] = newBranch;
		}
		System.out.println(newBranch.getName() + " branch is added.\n");
	}
	
	/**
	 * This method removes the branch from the company's array of branches.
	 * @param removed Branch of the branch to be removed.
	 */
	public void removeBranch(Branch removed) {
		if( branches.length == 0) {
			return;
		}
		else {
			boolean isIn = false;
			int index;
			for(index=0; index<branches.length; index++) {
				if(branches[index] == removed) {
					isIn = true;
					break;
				}
			}
			if(isIn == true) {
				for(int i=index; i<branches.length-1; i++) 
					branches[i] = branches[i+1];
				
				Branch [] temp = new Branch[branches.length-1];
				for(int i=0; i<temp.length; i++) 
					temp[i] = branches[i];
				
				branches = new Branch[branches.length-1];
				for(int i=0; i<branches.length; i++) 
					branches[i] = temp[i];
				System.out.println(removed.getName() + " branch is removed.\n");
			}
			else 
				System.out.println(removed.getName() + " branch is not removed because this branch is not found!\n");
		}
	}
	
	/**
	 * This method adds the new branch employee to company's array of employees.
	 * @param newEmployee BranchEmployee of the branch employee to be added.
	 * @param branchID int value of the ID of the branch where the branch employee will be added.
	 */
	public void addBranchEmployee(BranchEmployee newEmployee, int branchID) {
		for( Branch b : branches) {
			if(b.getID() == branchID) {
				if( b.employees.length == 0) {
					b.employees = new BranchEmployee[1];
					b.employees[0] = newEmployee;
				}
				else {
					for(int i=0; i<b.employees.length; i++) {
						if(newEmployee.getID() == b.employees[i].getID()) {
							System.out.println(newEmployee.getName() + " " + newEmployee.getSurname() + " is not added to branch employees. Because it is already added.\n");
							return;
						}
					}
					BranchEmployee [] temp = new BranchEmployee[b.employees.length];
					for(int i=0; i<b.employees.length; i++) 
						temp[i] = b.employees[i];
					
					b.employees = new BranchEmployee[b.employees.length+1];
					int i;
					for(i=0; i<temp.length; i++) 
						b.employees[i] = temp[i];
					
					b.employees[i] = newEmployee;
				}
				String branch = "";
				for(int i=0; i<branches.length; i++) {
					if(branchID == branches[i].getID())
						branch += branches[i].getName();
				}
				System.out.println(newEmployee.getName() + " " + newEmployee.getSurname() + " is added to branch employees in " + branch + " branch.\n");
			}
		}
	}
	
	/**
	 * This method removes the branch employee from the company's array of employees.
	 * @param removed BranchEmployee of the branch employee to be removed.
	 * @param branchID int value of the ID of the branch where the branch employee will be removed.
	 */
	public void removeBranchEmployee(BranchEmployee removed,  int branchID) {
		for( Branch b : branches) {
			if(b.getID() == branchID) {
				if( b.employees.length == 0)
					return;
				
				else {
					boolean isIn = false;
					int index;
					for(index=0; index<b.employees.length; index++) {
						if(b.employees[index] == removed) {
							isIn = true;
							break;
						}
					}
					if(isIn == true) {
						for(int i=index; i<b.employees.length-1; i++)
							b.employees[i] = b.employees[i+1];
						
						BranchEmployee [] temp = new BranchEmployee[b.employees.length-1];
						for(int i=0; i<temp.length; i++)
							temp[i] = b.employees[i];
						
						b.employees = new BranchEmployee[b.employees.length-1];
						for(int i=0; i<b.employees.length; i++)
							b.employees[i] = temp[i];
						System.out.println(removed.getName() + " " + removed.getSurname() + " is removed from branch employees.\n");
					}
					else 
						System.out.println(removed.getName() + " " + removed.getSurname() + " is not removed from branch employees because this is not found.\n");
				}
			}
		}
	}
	
	/**
	 * This method adds the new transportation personel to company's array of personnel.
	 * @param newPersonel TransportationPersonel of the transportation personel to be added.
	 * @param branchID int value of the ID of the branch where the transportation personel will be added.
	 */
	public void addTransportationPersonel(TransportationPersonel newPersonel, int branchID) {
		for( Branch b : branches) {
			if(b.getID() == branchID) {
				if( b.personnel.length == 0) {
					b.personnel = new TransportationPersonel[1];
					b.personnel[0] = newPersonel;
				}
				else {
					for(int i=0; i<b.personnel.length; i++) {
						if(newPersonel.getID() == b.personnel[i].getID()) {
							System.out.println(newPersonel.getName() + " " + newPersonel.getSurname() + " is not added to transportation personnel. Because it is already added.\n");
							return;
						}
					}
					TransportationPersonel [] temp = new TransportationPersonel[b.personnel.length];
					for(int i=0; i<b.personnel.length; i++)
						temp[i] = b.personnel[i];
					
					b.personnel = new TransportationPersonel[b.personnel.length+1];
					int i;
					for(i=0; i<temp.length; i++)
						b.personnel[i] = temp[i];
					
					b.personnel[i] = newPersonel;
				}
				String branch = "";
				for(int i=0; i<branches.length; i++) {
					if(branchID == branches[i].getID())
						branch += branches[i].getName();
				}
				System.out.println(newPersonel.getName() + " " + newPersonel.getSurname() + " is added to transportation personnel in " + branch + " branch.\n");
			}
		}
	}
	
	/**
	 * This method removes the transportation personel from the company's array of personnel.
	 * @param removed TransportationPersonel of the transportation personel to be removed.
	 * @param branchID int value of the ID of the branch where the transportation personel will be removed.
	 */
	public void removeTransportationPersonel(TransportationPersonel removed, int branchID) {
		for( Branch b : branches) {
			if(b.getID() == branchID) {
				if( b.personnel.length == 0)
					return;
				
				else {
					boolean isIn = false;
					int index;
					for(index=0; index<b.personnel.length; index++) {
						if(b.personnel[index] == removed) {
							isIn = true;
							break;
						}
					}
					if(isIn == true) {
						for(int i=index; i<b.personnel.length-1; i++)
							b.personnel[i] = b.personnel[i+1];
						
						TransportationPersonel [] temp = new TransportationPersonel[b.personnel.length-1];
						for(int i=0; i<temp.length; i++)
							temp[i] = b.personnel[i];
						
						b.personnel = new TransportationPersonel[b.personnel.length-1];
						for(int i=0; i<b.personnel.length; i++)
							b.personnel[i] = temp[i];
						System.out.println(removed.getName() + " " + removed.getSurname() + " is removed from transportation personnel.\n");
					}
					else
						System.out.println(removed.getName() + " " + removed.getSurname() + " is not removed from transportation personnel because this is not found.\n");
				}
				
			}
		}
	}
	
	/**
	 * This method gets the administrator's name.
	 * @return name string of the administrator's name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * This method sets the administrator's name.
	 * @param name string of the administrator's name.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method gets the administrator's surname.
	 * @return surname string of the administrator's surname.
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * This method sets the administrator's surname.
	 * @param surname string of the administrator's surname.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
}
