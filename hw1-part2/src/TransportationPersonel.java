/**
 * @author Seyda Ozer
 *
 */
public class TransportationPersonel extends Branch implements User{
	/**
	 * This string is the name of the transportation personel.
	 */
	private String name;
	
	/**
	 * This string is the surname of the transportation personel.
	 */
	private String surname;
	
	/**
	 * This int value is the ID of the transportation personel.
	 */
	private int ID;
	
	/**
	 * TransportationPersonel six-parameter Constructor
	 * @param BranchName string of the branch's name.
	 * @param address string of the branch's address.
	 * @param branchID int value of the branch's ID.
	 * @param name string of the transportation personel's name.
	 * @param surname string of the transportation personel's surname.
	 * @param ID int value of the transportation personel's ID.
	 */
	public TransportationPersonel(String BranchName, String address, int branchID, String name, String surname, int ID) {
		super(BranchName, address, branchID);
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
		TransportationPersonel personel = (TransportationPersonel) object;
		for(Branch b : branches) {
			if( personel.getBranchID() == b.getBranchID() ) {
				int index = b.personnel.indexOf(personel);
				if(index != -1) 
					return true;
				else
					return false;
			}
		}
		return false;
	}

	/**
	 * When package is delivered, the transportation personnel makes the update the current status of the package.
	 * @param trackingNumber int value of the tracking number of the package.
	 */
	public void isDelivered(int trackingNumber) {
		for(Package p : packages) {
			if(p.getTrackingNumber() == trackingNumber) {
				p.setCurrentStatus("is delivered");
				break;
			}
		}
	}
	
	/**
	 * This method gets the transportation personel's name.
	 * @return name string of the transportation personel's name.
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * This method sets the transportation personel's name.
	 * @param name string of the transportation personel's name.
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * This method gets the transportation personel's surname.
	 * @return surname string of the transportation personel's surame.
	 */
	@Override
	public String getSurname() {
		return surname;
	}

	/**
	 * This method sets the transportation personel's surname.
	 * @param surname string of the transportation personel's surame.
	 */
	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	/**
	 * This method gets the transportation personel's ID.
	 * @return ID int value of the transportation personel's ID.
	 */
	public int getID() {
		return ID;
	}

	/**
	 * This method sets the transportation personel's ID.
	 * @param ID int value of the transportation personel's ID.
	 */
	public void setID(int ID) {
		this.ID = ID;
	}
}
