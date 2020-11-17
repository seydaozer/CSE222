/**
 * @author Seyda Ozer
 *
 */
public class Customer extends Company {
	/**
	 * This string is the name of the customer.
	 */
	private String name;
	
	/**
	 * This string is the surname of the customer.
	 */
	private String surname;
	
	/**
	 * This string is the address of the customer.
	 */
	private String address;
	
	/**
	 * This string is the phone number of the customer.
	 */
	private String phoneNumber;
	
	/**
	 * This string is the social security number of the customer.
	 */
	private String ssn;
	
	/**
	 * Customer five-parameter Constructor
	 * @param name string of the customer's name.
	 * @param surname string of the customer's surname.
	 * @param address string of the customer's address.
	 * @param phoneNumber string of the customer's phone number.
	 * @param ssn string of the customer's social security number.
	 */
	public Customer(String name, String surname, String address, String phoneNumber, String ssn) {
		super();
		this.name = name;
		this.surname = surname;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
	}
	
	/**
	 * This method shows the information about the package with tracking number to customer.
	 * @param trackingNumber int value of the package's tracking number.
	 */
	public void cargoTracking(int trackingNumber) {
		boolean isIn = false;
		for(Package p : packages) {
			if(p.getTrackingNumber() == trackingNumber) {
				System.out.println("---------------------------------------------------------");
				System.out.println("Informations about the package with " + trackingNumber + " tracking number:");
				System.out.println("Sender: " + p.getSender());
				System.out.println("Receiver: " + p.getReceiver());
				System.out.println("Current Status: " + p.getCurrentStatus());
				System.out.println("---------------------------------------------------------");
				isIn = true;
				break;
			}
		}
		if(isIn == false)	System.out.println("This package with " + trackingNumber + " tracking number is not found!");
	}
	
	/**
	 * This method gets the customer's name.
	 * @return name string of the customer's name.
	 */
	public String getName() {
		return name;
	}
	/**
	 * This method sets the customer's name.
	 * @param name string of the customer's name.
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * This method gets the customer's surname.
	 * @return surname string of the customer's surname.
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * This method sets the customer's surname.
	 * @param surname string of the customer's surname.
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * This method gets the customer's address.
	 * @return address string of the customer's address.
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * This method sets the customer's address.
	 * @param address string of the customer's address.
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * This method gets the customer's phone number.
	 * @return phoneNumber string of the customer's phone number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * This method sets the customer's phone number.
	 * @param phoneNumber string of the customer's phone number.
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * This method gets the customer's social security number.
	 * @return ssn string of the customer's social security number.
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * This method sets the customer's social security number.
	 * @param ssn string of the customer's social security number.
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
}
