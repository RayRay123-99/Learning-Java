import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class HumanBeing implements Serializable {

	private static final long serialVersionUID = 1L;
	
	
	private transient int id; // See the usage of the transient keyword here 
	/* By doing this, all the read and write serializations will just take id as null (id is not serialized)
	 * This is possible in Java because such fields in Java are initialized to a default value (null)
	 */
	
	private String name;
	private static int count = 1; // Default value of zero 
	// Static values are usually not serialized as the field belongs to the class, there is no need top save it to every object
	
	public HumanBeing() {
		System.out.println("Default Constructor");
	}
	
	public HumanBeing(int id, String name) {
		this.id = id;
		this.name = name;
		System.out.println("Two-argument Constructor");
	}
	/* A constructor is not serialized and hence it is not de-serialized 
	 * De-serializing does not run any constructor at all 
	 * The fields created by the constructor are just going to be restored to what they were when you originally serialized the object during de-serialization
	 */
	
	/* Getters and setters for the static field (static method for static field)
	 * These static methods are associated with the class not any individual objects and so is the static field
	 */
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		HumanBeing.count = count;
	}

	@Override
	public String toString() {
		return "HumanBeing [id=" + id + ", name=" + name + "]" + ". Count is: " + count;
	}
	
	
}

public class TransientKeyword {
	
	public static void main(String[] args) {
		/* The transient keyword is used when you are serializing objects 
		 * What you don't want to do is to serialize more fields than you have to because it's inefficient and some fields (e.g. threads) can't be serialized 
		 * The transient keyword prevents fields from being serialized
		 */
		
		System.out.println("Writing objects");

		// We use the try-with resources to do the writing which recall automatically calls the close method for FileOutputStream
		try(ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("HumanBeing.bin"))) {
			
			HumanBeing man1 = new HumanBeing(3, "Perry"); // Runs the two argument constructor (the new keyword basically always invokes a constructor)
			man1.setCount(22);
			os.writeObject(man1);
			
		} catch (FileNotFoundException e) {
			// If we can't find the file
			System.out.println("Can't find file");
			e.printStackTrace();
		} catch (IOException e) {
			// If we can't read the file
			System.out.println("Can't read file");
			e.printStackTrace();
		}
		
		System.out.println("\n");
		
		
		
		// This part is on reading the file 
		System.out.println("Reading objects");
		
		try(ObjectInputStream os = new ObjectInputStream(new FileInputStream("HumanBeing.bin"))){
			
			HumanBeing man2 = (HumanBeing) os.readObject();
			System.out.println(man2);

		} catch (FileNotFoundException e) {
			// If we can't find the file
			System.out.println("Can't find file");
			e.printStackTrace();
		} catch (IOException e) {
			// If we can't read the file
			System.out.println("Can't read file");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
