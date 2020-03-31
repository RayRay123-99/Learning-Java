import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadingFilesusingScanner {

	public static void main(String[] args) throws FileNotFoundException {
		String filename = "/Users/raymondhartono/Desktop/Learning Java/TESTJAVA.rtf"; // To get file path in Mac, right-click then press the option button and there will be an option
		
		// After this, your next step is to create  file object which will be the Java representation of this file 
		File textFile = new File(filename);
		
		// Then we can read the text inside the file (press all the errors raised by eclipse and use it's add-throw declaration recommendation)
		// With this, the main program will just stop if the file can't be found 
		Scanner insideFile = new Scanner(textFile);
		
		/* There are a variety of other methods in Scanner to (e.g. to read integers)
		 * 		int value = insideFile.nextInt();
		 * 		System.out.println("Read value: " + value);
		 */

		// Reading the file line by line:
		int count = 2;
		while(insideFile.hasNextLine()) {
			String line = insideFile.nextLine();
			System.out.println(count + ". Read Line: " + line);
			count++;
		}; // Will continue looping as long as there are still lines in the file 
		// Note that nextLine will read a new line as a line (so you should have an extra line counted) and the easiest way to resolve this is to put "insideFile.nextLine();" above the while loop
		
		insideFile.close(); // Always close the scanner 
		
		/* An alternative way of doing this instead of using the path of the file is to drag said file into eclipse (copy it) 
		 * Ensure the file in question should be in the root directory of the project because that's thw working directory for the Java program
		 * Everything is the same except this time in line 58, you can immediately write down the name of the file 
		 */
	}

}
