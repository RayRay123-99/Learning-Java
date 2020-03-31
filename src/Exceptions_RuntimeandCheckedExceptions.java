import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Exceptions_RuntimeandCheckedExceptions {

	public static void main(String[] args) throws FileNotFoundException {
		
		// One part of exception is it's error handling mechanism, it only happens if an error condition arises 
		
		File testFile = new File("/Users/raymondhartono/Desktop/Learning Java/TESTJAVA.rtf");
		// To read the file:
		FileReader testFR = new FileReader(testFile);
		// After pressing the recommended solution by Eclipse for the code above, an exception is added
		
		/* The error message you get when an exception is triggered is called stack trace
		 * The type of error and it's specific error is written in the first line of the stack trace 
		 * The line at which the error occurs is written at the last line of the stack trace 
		 * For this kind of exception, the whole code is thrown out of main() or the method to the method in the upper hierarchy 
		 */
		
		// Here we see another example of an exception - the try-catch block
		File testFile2 = new File("test.txt");
		// To read the file:
		try {
			FileReader testFR2 = new FileReader(testFile2);
			System.out.println("Continuing"); // This line doesn't run if there is an exception 
		} catch (FileNotFoundException e) {
			// Exception is declared in the catch bracket 
			// The code to be executed if the exception is thrown is written here 
			
			System.out.println("File not found: " + testFile2.toString()); // Name of file 
			e.printStackTrace();
			
			// The error generated is similar to the one above 
		}
		
		/* The example to be shown here is that an exception in a separate method will have to be addressed in the main method too 
		 * (either by a try-catch or a throw declaration
		 */
		
		try {
			openFile(); 
			System.out.println("Continuing");
		} catch (FileNotFoundException e) {
			System.out.println("Cannot carry out method"); // Name of file 
			e.printStackTrace();
		}

		System.out.println("\n");

		
		
		//********************************
		/* This is on Runtime vs Checked Exceptions */
		
		/* There are 2 types of exceptions
		 * Checked exceptions are the kind you are forced to handle (all the examples shown so far)
		 * Runtime exceptions are those you don't have to handle 
		 */
		
		// Example of runtime exception:
		int value = 7;
		value = value/0; // This compiles but it will throw an exception during runtime
		
		String text = null;
		System.out.println(text.length()); // Runtime (specifically reference) error because all you have a is a reference, no object 
		
		// Array out of bounds exception:
		String[] texts = {"1", "2", "3"};
		System.out.println(texts[3]); // There is nothing in index 3 
		
		/* Runtime errors are very serious fundamental errors in your program so a program can't recover from a runtime exception
		 * So once you encounter a runtime error, you need to find the problem and fix it 
		 * You can of course still use a try-catch block to catch runtime exceptions
		 */
		
		try {
			System.out.println(texts[3]);
		} catch (RuntimeException e) {
			// You can either catch all Runtime exceptions or a specific one depending on what you put inside the catch bracket
			System.out.println(e.toString());
		}
	}
	
	/* Because we are using the 'Exceptions_RuntimeandCheckedExceptions' class and we don't have a 'new' of this class
	 * we have to declare any methods using this class must be static 
	 */
	
	public static void openFile() throws FileNotFoundException {
		File testFile3 = new File("/Users/raymondhartono/Desktop/Learning Java/TESTJAVA.rtf");
		// To read the file:
		FileReader testFR3 = new FileReader(testFile3);
	}

}
