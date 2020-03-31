import java.util.Scanner;

enum Animal {
	CAT("TOM"), DOG("SPIKE"), HAMSTER("THOMAS");
	
	/* CAT, DOG, HAMSTER are treated as objects of the type Animal known as enum constants they are NOT strings 
	 * Their immediate ancestor is java lang enum so all the classes in the Java.lang package is automatically available in the program
	 */
	
	private String name; // Enum types can have instance variables 
	
	
	// You can give a enum tyoe their own constructor and methods as well
	Animal(String name) {
		/* Parameters are supplied through the bracket
		 * Now each of the 3 objects must be instantiated with a name 
		 * The parameters declared in the constructor can be supplied above (see line 4)
		 */
		
		this.name = name;
		
	} // Will have package level validity


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	// We can even have a toString method for enum
	public String toString() {
		return "This animal is called " + name;
	}
	
	// However, usually for programmatic purposes, we want the actual enum value as a string 
}

public class EnumTypesUsage {
	
	//public static final int DOG = 0;
	//public static final int CAT = 1;
	//public static final int HAMSTER = 2;
	
	// Constants no longer needed as an enum has been created 
	
	public static void main(String[] args) {
		// Usually in programming, you'll have some kind of variable that can only take on certain specific values
		
		// Scanner userinput = new Scanner(System.in);
		// System.out.println("Type in your input: ");
		// int animal = userinput.nextInt();
		
		/* This however produces a certain problem, you are unable to restrict the value of animal to 0-2 (which produces an output)
		 * Another problem is that it isn't clear what the int animal should be set to unless if you have information from lines 5-7 (i.e. you need to know the constants exist)
		 * This is a common case usage where you have a variable that represents different members of a fixed set of values 
		 */

		/* So, what enum (enumerated) does is that it is a special type that can be set to only represent certain members of a fixed set 
		 * The enum type represents some fixed set (fixed values that are not in any particular kind of order)
		 * The syntax for creating an enum is similar to how an interface or class is created (similar steps to create it too, only the keyword is different)
		 * Enums are usually defined in a separate file (like how classes and interfaces are) but for this tutorial, we will define it here
		 * Enums are not commonly seen but it should be used as it ensures type safety (input can only be from a fixed set)
		 */
		
		Animal animal = Animal.CAT;
		
		switch(animal ) {
		case CAT:
			System.out.println("MEOW");
			break;
		case DOG:
			System.out.println("BARK");
			break;
		case HAMSTER:
			System.out.println("SCREAM");
			break;
		default:
			break;
		}
		
		// Now we look at advanced uses of enum:
		
		/* We use public final static usually because final makes a constant in Java and static makes it belong to a class which saves memory
		 * But even so, we should use enum more frequently 
		 */
		
		System.out.println(Animal.DOG); // Will return the toString version
		System.out.println("Enum name as a string: " + Animal.DOG.name()); // Converts object from enum constant into a String, overriding of toString()
		/* Useful especially if you want to save an enum constant into say a database
		 * You would want to define any non set of possible strings in your database for efficiency
		 */ 
		
		System.out.println("\n");
		
		System.out.println(Animal.DOG.getClass()); // We see that DOG is actually of class Animal
		
		System.out.println(Animal.DOG instanceof Animal); // Checks if object is instance of a particular class
		System.out.println(Animal.DOG instanceof Enum); // True because objects of child classes are instances of parent classes 
		
		System.out.println(Animal.HAMSTER.getName());
		
		Animal animal2 = Animal.valueOf("CAT");
		System.out.println(animal2); // Will output the toString value 
	}

}
