
/**
 * @author Seyda Ozer
 * AgeData Class
 */
public class AgeData implements Comparable<AgeData> {
	/**
	 * This int value is the age of the person.
	 */
	private int age;
	/**
	 * This int value is the number of people of the same age.
	 */
	private int numberOfPeople;
	
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
		int result = 0;
		if(o.age == age)
			result =  0;
		if(o.age < age)
			result = 1;
		if(o.age > age)
			result = -1;
		return result;
	}
}
