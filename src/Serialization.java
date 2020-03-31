import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Individual implements Serializable {

	private static final long serialVersionUID = 1L; // Added to make a warning go away (see the warning at line 9)
	/* The ID is used to de-serialize objects or data that you have serialized into file
	 * The ID ensures that the class that you are de-serializing with matches the class you serialized with and vice versa 
	 * So, if the class has changed a lot, you should change the serialVersionUID to signify the class is different to stop people from reading your new class thinking it's the same old class 
	 */
	
	private int id; 
	private String name;
	
	// To make it possible to serialize an object, it must implement the serializable interface 
	
	public Individual(int id, String name) {
		this.id = id;
		this.name = name;
	}


	@Override
	public String toString() {
		return "Individual [id=" + id + ", name=" + name + "]";
	}
	
}

public class Serialization {

	public static void main(String[] args) {
		/* In serialization, you take an object and turn it into some kind of binary form (binary data)
		 * If you de-serialize, it means you are taking binary data and converting it back into an object 
		 */
		
		/* Note you are allowed to have more than one main method in a Java program 
		 * You might have your normal entry point in the program and you could have test main method to test stuff as well 
		 */
		
		// This part is on writing the class above into the file
		System.out.println("Writing objects");
		Individual man1 = new Individual(1, "Thomas");
		Individual man2 = new Individual(2, "Teddy");
		
		System.out.println(man1);
		System.out.println(man2);
		
		// We use the try-with resources to do the writing which recall automatically calls the close method for FileOutputStream
		try(FileOutputStream fs = new FileOutputStream("Individual.bin")) {
			/* What this does is basically it streams (sends data sequentially) to a file 
			 * We need to supply the an argument in the bracket which is the name of the file to stream to (either a name or a file path)
			 */
			
			ObjectOutputStream os = new ObjectOutputStream(fs);
			/* We need to pass to the constructor of the Object the file output stream object that we are gonna use to allow this object(os) to stream data to our file
			 * You are taking some output stream and using that to write into the file 
			 */
			
			// There are different methods to write all kinds of stuff and data and you can serialize all kinds of data you want, just do it sequentially
			os.writeObject(man1);
			os.writeObject(man2);
			// This will serialize the objects into the files and at the same time overwrite the original contents of the file 
			
			os.close(); // You need to close the object
			
		} catch (FileNotFoundException e) {
			// If we can't find the file
			System.out.println("Can't find file");
		} catch (IOException e) {
			// If we can't read the file
			System.out.println("Can't read file");
		}
		
		System.out.println("\n");
		
		
		
		// This part is on reading the file 
		System.out.println("Reading objects");
		
		try(FileInputStream fi = new FileInputStream("Individual.bin")){
			
			ObjectInputStream os = new ObjectInputStream(fi);
			
			Individual man3 = (Individual) os.readObject(); // Casting is required 
			Individual man4 = (Individual) os.readObject();
			// You can read your object from a different program and that means readObject can read a class that doesn't even exist in the program you are working on 
			
			os.close(); // Remember to close 
			
			// Objects are returned in the same order that they are written in 
			System.out.println(man3);
			System.out.println(man4);
			
		} catch (FileNotFoundException e) {
			// If we can't find the file
			System.out.println("Can't find file");
		} catch (IOException e) {
			// If we can't read the file
			System.out.println("Can't read file");
		} catch (ClassNotFoundException e) {
			// if you don't have the class defined in your program 
			System.out.println("Can't find class");
		}
		
		
	}

}
