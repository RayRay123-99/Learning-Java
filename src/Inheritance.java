class Engine {	// Usually classes are defined on separate files in Java 
	private String name = "Type 001"; // This can't be accessed from the child class 
	protected String name2 = "Type 002"; // This can be accessed from the child class 
	
	public void start() {
		System.out.println("Machine starting");
	}
	public void stop() {
		System.out.println("Machine stopping");
	}
}

class Car extends Engine {
	/* Normally, we will define Car on a separate file
	 * In this case, Car is a child class of Engine - Car is derived from Engine / Car inherits from Machine
	 * So, Car is identical to the Machine class - it has all the methods the Engine class has
	 */
	
	public void wipe() {
		System.out.println("Wiping windshield"); // You can add subroutines/methods to the child class
	}
	
	/* The only class that can't do this is a String class */
	
	// You can override a method from the parent class in the child class:
	public void start() {
		System.out.println("Car starting");
	} // Just make sure the header remains the same in both classes 

	/* Another way to override method is to right click within the child class
	 * Press 'Source' then 'Override/Implement methods' 
	 */ 
	
	@Override // This checks if it's really an override of an existing method in the parent class
	public void stop() {
		// TODO Auto-generated method stub
		// super.stop(); we just change this to what we want
		System.out.println("Car stopping");
	}
	// Try not to override variables, just override methods 
	
	public void showInfo() {
		System.out.println("Car name: " + name2);
	}
}

public class Inheritance {

	public static void main(String[] args) {
		Engine eng1 = new Engine();
		
		Car car1 = new Car();
		
		car1.start();
		car1.stop();
		car1.wipe();
		car1.showInfo();
	}

}
