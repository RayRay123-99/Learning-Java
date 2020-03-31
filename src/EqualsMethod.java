class Human {
	private int id;
	private String name;
	
	// Create constructor
	public Human(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override // Generate toString()
	public String toString() {
		return "Human [id=" + id + ", name=" + name + "]";
	}

	/* Hashcodes are just like unique IDs that each object has (unique for each object created)
	 * Only used if you add your object to a hash (see video on Collections)
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	/* The code below compares two objects to see if they are the same 
	 * Right-click, go to source and click generate hashcodes and equals 
	 * Tick the fields that both objects must have to be considered as being equal
	 */  
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Human other = (Human) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}

public class EqualsMethod {

	public static void main(String[] args) {
		Human human1 = new Human(5, "Bob");
		Human human2 = new Human(5, "Bob");
		
		// Now we want to find out if person1 and person2 are equal or not
		System.out.println(human1 == human2); // Returns false
		// This works best for primitive types (like integers)
		
		/* What '==' does is that it tells you whether 2 references to objects are pointing at the same object or not
		 * But, we usually want to compare objects semantically (in this case, even if human1 and human2 have the exact same id and name, == will still show false)
		 * That's because while 2 objects may be semantically the same (i.e. possess all the same characteristics, they have different memory locations)
		 */
		
		// Hence, we have another method to compare between objects by generating an equals method in the class (above)
		System.out.println(human1.equals(human2)); // Returns true 
		
		Double num1 = 7.2;
		Double num2 = 7.2;
		System.out.println(num1.equals(num2));
		
		String text1 = "HELLO";
		String text2 = "HELLOfsdaa".substring(0, 5);
		System.out.println(text1 == text2);  // This is not correct since it returns false even though text2 is "HELLO"
		
		// For strings and integers, Java optimizes and points the two references (text1 and text2) at the exact same object so using == on strings and integers may work sometimes 
		
		System.out.println(text1.equals(text2));
		
		/* So, use dots equals method to compare values, since == only compares if the reference is pointing at the same object 
		 * The main message is that we shouldn't use == to compare non primitive numbers
		 * Only use == to check if 2 references point at the same object
		 */ 
		
		System.out.println(new Object()); // Will generate a hashcode 
	}

}
