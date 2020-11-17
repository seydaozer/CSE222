import java.util.Comparator;

/**
 * @author Seyda Ozer
 * AgeData Class
 */
public class AgeData implements Comparator<AgeData> , Comparable<AgeData>{
	/**
	 * This int value is the age of the person.
	 */
	private int age;
	/**
	 * This int value is the number of people of the same age.
	 */
	private int numberOfPeople;
	
	public AgeData() {
		age = 0;
		numberOfPeople = 0;
	}
	
	/**
	 * AgeData Constructor
	 * @param age The age of the person
	 */
	public AgeData(int age) {
		this.age = age;
		numberOfPeople = 1;
	}
	
	/**
	 * This method sets the age
	 * @param age The new age
	 */
	public void setAge(int age) {
		this.age = age;
	}
	
	/**
	 * This method gets the age
	 * @return the age of the person
	 */
	public int getAge() {
		return age;
	}
	
	/**
	 * This method sets of the number of people
	 * @param counter The int value is the new value for the number of people.
	 */
	public void setNumberOfPeople(int counter) {
		numberOfPeople = counter;
	}
	
	/**
	 * This method gets the number of people.
	 * @return the number of people
	 */
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	
    /**
     * This method returns a string representation of the AgeData object.
     * @return a string representation of the AgeData object.
     */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(age + " - " + numberOfPeople);
		return sb.toString();
	}

	/**
	 * Compares this AgeData object with the specified AgeData object for order.
	 * Returns a negative integer, zero, or a positive integer as this object
	 * is less than, equal to, or greater than the specified object.
	 */
	@Override
	public int compareTo(AgeData o) {
		if(age < o.age)
			return -1;
		else if(age > o.age)
			return 1;
		return 0;
	}

	/**
	 * Compare two AgeData objects
	 * @param o1 The first object
	 * @param o2 The second object
	 * @return -1 if o1 smaller than o2; 0 if o1 is equals o2;
	 * 			and +1 if o1 greater than o2
	 */
	@Override
	public int compare(AgeData o1, AgeData o2) {
		if(o1.numberOfPeople < o2.numberOfPeople)
			return -1;
		else if(o1.numberOfPeople > o2.numberOfPeople)
			return 1;
		return 0;
	}
}
