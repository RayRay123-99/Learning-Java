class Machine {
	/* A constructor doesn't return any type of variable (even void) and it must have the same name as the class
	 * It will run automatically the moment the object is created 
	 * Constructors are often used to initialize the instance variables for the object
	 */
	
	private String name;
	private int code;
	
	public Machine() {
		System.out.println("Constructor running");
		name = "EVE"; // E.g. we can give a default name for all the objects of this class created 
	}
	
	// Constructors can take in parameters
	public Machine(String name) {
		System.out.println("Second constructor running");
		this.name = name;
	}
	
	public Machine(String name, int code) {
		System.out.println("Third constructor running");
		this.name = name;
		this.code = code;
		System.out.println("Machine name is: " + name + " with code " + code);
	}
	
	// You can call constructors within another constructor too
	// Just use 'this' and put in the correct parameters based on the constructor you want, for example:
	/*
		public Machine(String name, int code) {
			this(); // This will run the first constructor
			this("Auto"); // This will run the second constructor
			this.name = name;
			this.code = code;
			System.out.println("Machine name is: " + name + " with code " + code);
		}
	 */
}

public class Constructors {

	public static void main(String[] args) {
		
		Machine machine1 = new Machine();
		// You don't even have to name the object
		new Machine();
		new Machine("EVE", 001);
		
		Machine machine2 = new Machine("MO"); // This will run the second constructor based on the variable we type in 
		new Machine("MO", 002); // Java will assume it's machine 2, java selects the correct constructor based on the parameter list
		// This last line will run the third constructor only (which already has constructor 1 and 2 included inside)
	}

}
