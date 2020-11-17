/**
 * @author Seyda Ozer
 *
 */
public class Package {
	/**
	 * This string is the name of sender.
	 */
	private String sender;
	
	/**
	 * This string is the name of receiver.
	 */
	private String receiver;
	
	/**
	 * This int value is the ID of the branch where the package is located.
	 */
	private int branchID;
	
	/**
	 * This string is the current status of the package.
	 */
	private String currentStatus;
	
	/**
	 * This string is the tracking number of the package.
	 */
	private int trackingNumber;
	
	/**
	 * Package five-parameter Constructor
	 * @param sender string of the sender's name.
	 * @param receiver string of the receiver's name.
	 * @param branchID int value of the branch's ID.
	 * @param currentStatus string of the current status.
	 * @param trackingNumber int value of the tracking number.
	 */
	public Package (String sender, String receiver, int branchID, String currentStatus, int trackingNumber) {
		this.sender = sender;
		this.receiver = receiver;
		this.branchID = branchID;
		this.currentStatus = "in branch " + currentStatus + " - " + branchID;
		this.trackingNumber = trackingNumber;
	}

	/**
	 * This method gets sender's name.
	 * @return sender string of the sender's name.
	 */
	public String getSender() {
		return sender;
	}

	/**
	 * This method sets sender's name.
	 * @param sender string of the sender's new name.
	 */
	public void setSender(String sender) {
		this.sender = sender;
	}

	/**
	 * This method gets receiver's name.
	 * @return receiver string of the receiver's name.
	 */
	public String getReceiver() {
		return receiver;
	}

	/**
	 *  This method sets receiver's name.
	 * @param receiver string of the receiver's new name.
	 */
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	/**
	 * This method gets the ID of the branch where the package is located.
	 * @return branchID int value of the branch's ID.
	 */
	public int getBranchID() {
		return branchID;
	}

	/**
	 * This method sets the ID of the branch where the package is located.
	 * @param branchID int value of the branch's ID.
	 */
	public void setBranchID(int branchID) {
		this.branchID = branchID;
	}

	/**
	 * This method gets the current status of the package.
	 * @return currentStatus string of the current status of the package.
	 */
	public String getCurrentStatus() {
		return currentStatus;
	}

	/**
	 * This method sets the current status of the package.
	 * @param currentStatus string of the current status of the package.
	 */
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}

	/**
	 * This method gets the package's tracking number.
	 * @return trackingNumber int value of the package's tracking number.
	 */
	public int getTrackingNumber() {
		return trackingNumber;
	}

	/**
	 * This method sets the the package's tracking number.
	 * @param trackingNumber int value of the package's tracking number.
	 */
	public void setTrackingNumber(int trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
}
