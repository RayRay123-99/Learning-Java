import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class Temp implements AutoCloseable {
	// The AutoCloseable interface just specifies that the class should have a close method that throws an exception (seen below in main class)
	
	@Override
	public void close() throws Exception {
		System.out.println("Closing!");
		// throw new Exception ("OH NO!");  Just adding a new Exception
	} // This method MUST be carried out in the main program and will always be carried out (regardless of whether there is an exception or not)
	  
}

public class TryWith {

	public static void main(String[] args) {
		// This is the simpler way of reading files compared to the previous method of using File Readers
		
		// The codes below show an example of try-with resources 
		try ( Temp testfile1 = new Temp()) {
		/* Within the try bracket, you are creating a new object and assigning it to a variable that (must) implements AutoCloseable 
		 * With this, the method close is automatically called, we don't have to worry about what will happen if an exception is thrown 
		 */
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		// Now, we show how this is done with text files 
		File testfile1 = new File ("Test.txt");
				
		// To read the file line by line:
		// Notice that the FileReader and BufferedReader are declared in one line
		try (BufferedReader readFile1 = new BufferedReader(new FileReader(testfile1))) {
			String line; // This reference will point to each line in the file 
			
			while( (line = readFile1.readLine()) != null) {
				System.out.println(line);
			}; // This reads the file line by line 
		} catch (FileNotFoundException e) {
			System.out.println("Can't find file: " + testfile1.toString());
		} catch (IOException e) {
			System.out.println("Unable to read file: " + testfile1.toString());
		} // This method reads the file and at the same time, it also closes the BufferedReader and file using the Try-With resources (with all the relevant error messages)
	}
}
