import ocean.Fish; // We need to write this if we want to use classes from another package
import ocean.Seaweed;

// To import all the classes from one package, you can simply do this:
import ocean.*;
// Or simply type Command+Shift+O

class Tool implements Info { 
	/* This class is now using the interface Info and this means you now have to implement ALL the methods shown in the interface
	 * Note that an interface can have as many methods and a class can have more than one interface 
	 * So this is much better than having only one parent class
	 */
	
	private int id;

	public void start() {
		System.out.println("Machine starting");
	}

	// Press 'Type unimplemented methods' to get this typed out automatically
	@Override
	public void showInfo() {
		System.out.println("Tool ID is " + id);
	}
}

class Man implements Info{
	String name;
	
	// You can generate constructors by right-clicking, going to source and pressing 'generate constructors using fields'
	public Man(String name) {
		// super(); Get rid of this
		this.name = name;
	}
	
	public void greet() {
		System.out.println("Hello my name is " + name);
	}

	@Override
	public void showInfo() {
		System.out.println("This is the greeting implemented using an interface: " + name);
	}
	
	
}

public class Packages_Interfaces {
	public static void main(String[] args) {
		/* Packages allow us to organize our code and find files we need quickly
		 * They stop you from having conflicts between class names 
		 */
		
		Fish fish1 = new Fish();
		Seaweed seaweed1 = new Seaweed();
		
		/* Packages are hierarchical in Java, you can have packages within packages 
		 * For example, you can type in ocean.plant and it will be inside the ocean package
		 * ocean.plant is a sub-package (plant is the sub-package specifically)
		 * You can also drag classes from one package to another class
		 */
		
		// There is a convention you can follow when naming packages in Java - e.g. you could reverse the name of your website

		System.out.println("\n");

		
		
		//********************************
		/* This is on interfaces */
		Tool mach1 = new Tool();
		mach1.start();
		
		Man man1 = new Man("Bob"); // Recall this is how we define a constructor
		man1.greet();
		
		/* Now Man and Machine are completely different objects who don't have the same parent of whatsover
		 * But now, suppose you want both of the classes to have the same method, this can be done using interfaces
		 */
		
		/* To create interfaces, right click on the file just as you would create a new class 
		 * You can then use interface names where you would have used a class name except when you use 'new'
		 */
		Info info1 = man1; // This will however only access methods in that interface in the Tool class
		info1.showInfo();
		
		outputInfo(man1); // You can pass any object into the method created using the interface 
		
		/* Interfaces can also be used to group objects together 
		 * You can even use it to design a program, where you use the interface to define how the objects will interact with one another 
		 * The create objects and implement the interfaces 
		 */
		
		/* The usefulness of interfaces is that with interfaces, you only have to create an object and worry about it's type at that instance, after that, 
		 * you only have to worry about the methods (that you have defined in the interface) that that object has
		 * You access the object through the interface methods instead 
		 */
	}
	
	/* You can create a method using the interface - where the method takes in the parameter of type interface (Info in this case)
	 * With this you can pass different objects into the method 
	 */
	
	private static void outputInfo(Info info) {
		// In here, you can access any method that is defined in the Info interface 
		info.showInfo();
	}
}
