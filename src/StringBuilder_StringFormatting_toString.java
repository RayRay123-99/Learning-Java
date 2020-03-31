import java.util.Scanner;

class Sth {
	public String toString() {
		StringBuilder identity = new StringBuilder();
		identity.append(id);
		identity.append(": ");
		identity.append(name);
		return identity.toString(); // Preferred compared to concatenation of string
		
		/* Alternative way:
		 * return String.format("%d: %s", id, name);
		 */
	} 
	// Without this, if you conduct a sysout using the name of the object, you instead get the object's hash code (a unique identifier for each object in Java)
	
	public String name;
	private int id;
	
	public Sth(int id, String name) {
		this.id = id;
		this.name = name;
	} // Constructor
}


public class StringBuilder_StringFormatting_toString {

	public static void main(String[] args) {
		String greeting = "";

		greeting += "I am Bob.";
		greeting += " ";
		greeting += "I am a builder.";
		System.out.println(greeting); 
		
		/* Strings are immutable in Java - you can't change them once they are created 
		 * So, in the above example, you are actually creating multiple new strings and simply reassigning these new strings to 'greeting'
		 * This is very inefficient as it uses a lot of memory
		 */
		
		// To mitigate this, we have a string builder which works like a Scanner 
		StringBuilder name = new StringBuilder();
		
		name.append("My name is Dora. ");
		name.append(" "); 
		name.append("THE EXPLORER"); // This modifies existing string builder which is much more efficient 
		/* Alternative way of doing the above: 
		 * name.append("text").append("text2").append("text3");
		 */
		
		System.out.println(name);
		System.out.println(name.toString()); // Also prints out 'name'

		System.out.println("\n");

		
		
		//********************************
		/* This is string formatting */
		System.out.println("Here is some text. And this is a tab: \t . And this is a new line: \n .SEE");
		// println will automatically print out a new line, without it the next sysout will print on the same line
		
		// printf allows you to embed special characters:
		Scanner input = new Scanner(System.in);
		System.out.println("Type in the cost: ");
		int input1 = input.nextInt();
		System.out.printf("Total cost is $%.2f and the object is %s \n", 1.07*input1, "Lego");
		// Gives more control than normal concatenation 
		
		// You can specify width to output 
		System.out.printf("Total cost is $%10d and the object is %s \n", 5, "Lego");
		// Left align
		System.out.printf("Total cost is $%-10d and the object is %s \n", 5, "Lego");
		// You can use it to align outputs:
		for (float i = 0; i < 12; i++) {
			System.out.printf("%5.1f: Number %.2f\n", i, i);
		}

		System.out.println("\n");

		
		
		//********************************
		/* This is the toString() method */
		/* toString method is useful in helping debug operations
		 * This gives a string representation of the object and it helps represent and identify the object 
		 */
		
		Sth obj = new Sth(001, "Batman"); // Each object class has inherited methods from the parent of the 'Sth' class
		Sth obj2 = new Sth(002, "Robin");
		System.out.println(obj);
		System.out.println(obj2);
	}

}
