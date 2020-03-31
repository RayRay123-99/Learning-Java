import java.util.Scanner;

public class Loops_Switchs_UserInput {
	public static void main(String[] args) {
		/** while loop **/
		boolean condition = 4 < 5; // running this returns true and use this to control the loop **/
		/** the operators in java is the same as in C **/
		
		int value = 0;
		
		while (value < 5)
		{
			System.out.println("Heyyy");
			value = value+1; /** looping parameter **/
		} /** similar to C style **/
		
		System.out.println("\n");
		
		//********************************
		/** for loop **/
		int i;
		
		for (i = 0; i < 5; i++) 
		{
			System.out.println("The value of i is: " + i);
			System.out.printf("The value of i is: %d\n", i);
			// Notice the printf and this does not print out a newline by default **/
		} /** similar to C style **/
		
		System.out.println("\n");
	
		/** if-else **/
		i = 7;
		if (i == 5) {
			System.out.println("Yes i is 5!");
		}
		else if (i < 5){
			System.out.println("Nope D:");
		}
		else {
			System.out.println("Nah :P");
		} // The use of loops is similar to C, placements of if-else inside while and similar concepts remains the same **/	
		
		int loop = 0;
		
		while (true) 
		{
			System.out.println("The loop counter is: " + loop);
			
			if (loop == 5) {
				break;
			}
			else {
				System.out.println("Running");
			}
			loop++;
		}
		
		System.out.println("\n");
		
		
		
		//********************************
		/** Putting in user input **/
		//Create a scanner object
		Scanner myInput = new Scanner(System.in) ; /** You need to import scanner first, press the error and press ctrl+shift **/
		
		//Get user input
		System.out.println("Enter a line of text: ");
		String input_line = myInput.nextLine();
		/** Notice the what is placed for nextLine and its syntax **/
		
		//Print out user input 
		System.out.println("You entered: " + input_line);
		
		//Int type input (you can use float and others too)
		System.out.println("Enter an integer: ");
		int value2 = myInput.nextInt();
		/** The only thing that changes is nextInt
		 If you want a double input for example, you use nextDouble **/
		
		System.out.println("You entered: " + value2);
		
		//Error handling (if user types something other than allowed input type)
		System.out.println("Type in an integer: ");
		
		while (!myInput.hasNextInt()) 
		{
			System.out.println("Integers only!!");
			myInput.nextLine();
			System.out.println("Type in an integer: ");
		}
		
		int num = myInput.nextInt();
		System.out.println("Thank you! (" + num + ")");
		/** This method however sends error handling messages twice **/
		
		System.out.println("\n");
		
		
		
		//********************************
		/** do-while loop **/
		Scanner newInput = new Scanner(System.in);
		
		int int_input = 0; //You need to initialize variable outside the do-while loop
		
		do {
			System.out.println("Enter a number :");
			int_input = newInput.nextInt();
		} 
		while (int_input != 5);
		
		System.out.println("Got 5 finally!");
	
		
		
		//********************************
		/** switch statements **/
		Scanner switch_input = new Scanner(System.in); 
		
		System.out.println("Please type in a command :");
		String switch_text = switch_input.nextLine(); //Can be integers too
		
		switch(switch_text) {
		case "start":
			System.out.println("Machine started");
			break;
		case "stop":
			System.out.println("Machine stopped");
			break;
		default:
			System.out.println("Command not recognised");	
			break;
		}	
	}
}
