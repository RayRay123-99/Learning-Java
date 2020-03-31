import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CreatingWritingTextFiles {

	public static void main(String[] args) {
        File testfile2 = new File ("Test.txt"); // A file path can be placed inside the bracket alternatively 
		
		// Notice of using BufferedReader and FileReader we use BufferedWriter and FileWriter
		try (BufferedWriter writeFile1 = new BufferedWriter(new FileWriter(testfile2))) {
			writeFile1.write("This is line 1");
			writeFile1.newLine();
			writeFile1.write("This is line 2");
			writeFile1.newLine();
			writeFile1.write("This is line 3");
			
			/* This would have updated the original text file (removes all the old contents unfortunately)
			 * Any new file will be placed in the root project folder 
			 * You can however specify a file path 
			 */ 
			
			
		} catch (IOException e) {
			System.out.println("Unable to read file: " + testfile2.toString());
		}
		
		// This is only for writing into text files (not binary files)
	}

}
