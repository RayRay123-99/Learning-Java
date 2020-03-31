import java.util.Scanner;

class Person { 
	/*
	 * A class is a template for creating objects, it specifies what different
	 * objects in the program are (sth like a type of variable)
	 */
	
	/*
	 * Classes can contain: State of your object (age, name, address - how you are
	 * at the moment and we put data (instances) to represent this Subroutines
	 * (methods) - the actions these objects can carry out
	 */

	// We call data/state in a class instance variables (basically data you want to
	// attach to an object)
	String name;
	int age;

	// Creating a subroutine
	/* You can use the instances in the class in the subroutine  
	 *  You can put in as many codes as you want and an object can have multiple subroutines 
	 *  Note the subroutine name must start with a lower case letter
	 */
	void sayHello() {
		System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
	} // To run this method, you have to call this method in the main method
	
	// Subroutine that returns a value - getting subroutine to return a value 
	int calculateYearsToRetirement() {
		int yearsleft = 65 - age;
		return yearsleft;
	} 
	
	int getAge() {
		return age;
	}
	
	String getName() {
		return name;
	}

} // You can then create a 'Person' objects in your 'main' class below

class Robot {
	/* Sometimes you want to pass values into methods 
	 * For example, we want the robot to say out the user input 
	 */
	public void speak(String text) {
		System.out.println(text); // So the method will take in the user input (text) from the 'main' method and print it out 
	}	
	
	public void jump(int number) {
		System.out.println("Jumping: " + number);
	}
	
	// You can have multiple parameters
	public void move (String direction, int distance) {
		System.out.println("Moving: " + distance + "m, Direction: " + direction);
	}
}

public class Classes_Objects_Methods {

	public static void main(String[] args) /* Java program starts at main */ {
		// Here is where you type in commands and this is an example of a subroutine
		// This is the 'main' method (example of a method in Java)

		Person Person1 = new Person(); // Declaring variable of type person
		Person1.name = "Joe";
		Person1.age = 37;
		Person1.sayHello(); //Person1 will now carry out the method 
		
		int years = Person1.calculateYearsToRetirement(); // Return a value from a subroutine
		System.out.println("Years to retirement: " + years);
		
		// Returning values from subroutine 
		int age = Person1.getAge();
		String name = Person1.getName();
		System.out.println("Name is: " + name);
		System.out.println("Age is: " + age);
		
		Person Person2 = new Person();
		Person2.name = "Mary";
		Person2.age = 35;
		Person2.sayHello();

		System.out.printf("Name of Person1: %s\n", Person1.name);
		
		System.out.println("\n");
		
		
		
		//********************************
		/* This is passing the parameter into the method */
		Robot WALLE = new Robot();
		
		WALLE.speak("WALLLEEEE"); // The text will be passed into the method in Robot 
		WALLE.jump(7);
		WALLE.move("West", 5); // The order of the parameter type to be passed in must match as specified in the method 
		
		
		// User inputs also work
		Scanner userInput = new Scanner(System.in);
		System.out.println("Type in greeting for WALLE to say: ");
		String greeting = userInput.nextLine();
		WALLE.speak(greeting); // Name of the string doesn't matter when passed into the method 
		
		System.out.println("Type in direction for WALLE: ");
		String direction = userInput.nextLine();
		System.out.println("Type in distance for WALLE: ");
		int distance = userInput.nextInt();
		WALLE.move(direction, distance);	
	}
}
