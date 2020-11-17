
/**
 * @author Seyda Ozer
 * The class stores the informations of a software package.
 */
public class Software implements Comparable<Software> {
	// Data Fields
	/**
	 * This String is name of the software package.
	 */
	private String name;
	/**
	 * This is quantity of the software package.
	 */
	private int quantity;
	/**
	 * This is price of the software package.
	 */
	private double price;
	
	// Constructors
	/**
	 * two-parameter constructor
	 * @param name The name
	 * @param price The price
	 */
	public Software(String name, double price) {
		this(name, 1, price);
	}
	
	/**
	 * three-parameter constructor
	 * @param name The name
	 * @param quantity The quantity
	 * @param price The price
	 */
	public Software(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}
	
	// Methods
	/**
	 * This method gets the name
	 * @return name The name of the software package
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * This method sets the name
	 * @param name The new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * This method gets the quantity
	 * @return quantity The quantity of the software package
	 */
	public int getQuantity() {
		return quantity;
	}
	
	/**
	 * This method sets the quantity
	 * @param quantity The new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	/**
	 * This method gets the price
	 * @return price The price of the software package
	 */
	public double getPrice() {
		return price;
	}
	
	/**
	 * This method sets the price
	 * @param price The new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	/**
	 * Compares this Software object with the specified Software object for order.
	 * Returns a negative integer, zero, or a positive integer as this object
	 * is less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(Software o) {
		return name.compareTo(o.name);
	}
	
    /**
     * This method returns a string representation of the Software object.
     * @return a string representation of the Software object.
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(name + "\n");
		sb.append("Quantity: " + quantity + "\n");
		sb.append("Price   : " + price);
		return sb.toString();
	}
}
