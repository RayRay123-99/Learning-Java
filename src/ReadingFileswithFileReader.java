import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class ReadingFileswithFileReader {

	public static void main(String[] args) {
		/* Using a File Reader is actually considered the old way of reading files so it is a bit clunky and messy due to the various nesting levels 
		 * When creating a file in java, always put it at SRC 
		 */ 
		
		File testfile1 = new File("Test.txt"); // This is the independent way of representing a file (see using scanner to read files to see the non-independent way)
		
		BufferedReader readFile1 = null; 
		/* The BufferedReader is declared outside because we need to close it after the operation and it can't be inside the try-catch block for this to work
		 * It must also be declared as null initially 
		 */ 
		
		// To read file (the try-catch is needed):
		try {
			FileReader readtestfile = new FileReader(testfile1);
			
			// If you want to read the file line by line, you need another class (which takes in a FileReader) in a process called buffering
			readFile1 = new BufferedReader(readtestfile);
			
			String line; // This reference will point to each line in the file 
			
			while( (line = readFile1.readLine()) != null) {
				System.out.println(line);
				
				// If you want to read a very large file, a stringBuilder is much more recommended compared to using string concatenation
				
			}; // This reads the file line by line and this also requires a catch block 
			
		} catch (FileNotFoundException e) {
			// Error for not being able to open file 
			System.out.println("File not found: " + testfile1.toString());

		} catch (IOException e) {
			// Error for an opened file that can't be read
			System.out.println("Unable to read file: " + testfile1.toString());
			
		} finally {
			/* The finally block will always be executed whether or not if an exception is thrown by the earlier codes 
			 * It will be run as long as the program runs successfully 
			 * That is why we put the close BufferReader code here 
			 */ 
			
			/* If you are reading a lot of files in java, you need to close your BufferedReader in order to ensure there are no memory leaks 
			 * Closing the BufferedReader automatically closes the FileReader as well 
			 */
			try {
				readFile1.close();
				/* However, if the catch block is carried out above, this will show a null pointer exception (because there is no file to read)
				 * So, we need an exception to handle cases like this too 
				 * This is done by adding another catch block
				 */
				
			} catch (IOException e) {
				System.out.println("Unable to close file: " + testfile1.toString());
			} catch (NullPointerException ex) {
				// File was probably never opened if this exception is thrown 
			}
		}
	}

}
