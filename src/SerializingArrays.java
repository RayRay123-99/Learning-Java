import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.*;

public class SerializingArrays {

	public static void main(String[] args) {
				
		// Using the same individual class but now we have an array of Individuals 
		Individual[] people = {new Individual(1, "John"), new Individual(2, "Hitman"), new Individual(3, "Wick")};
		/* In java, an array is considered as an object so we can serialize and de-serialize it as we would with an object
		 * This can be done as long as the objects within the array themselves are serializable (i.e. the classes in question must implement Serializable)
		 */
				
		/* Do note that this system also works for array lists (they're like linked lists):
		 * ArrayList<Individual> peopleList = new ArrayList<Individual>(Arrays.asList(people));
		 */
	
		// We use the try-with resources to do the writing which recall automatically calls the close method for FileOutputStream
		try(FileOutputStream fs = new FileOutputStream("Individual.bin")) {
					
			ObjectOutputStream os = new ObjectOutputStream(fs);
			/* This code can actually be put within the try bracket which would mean you don't need the os.close code anymore,
			 * just put a semi-colon at the end of the existing line and put the code in line 28
			 */ 
			
			os.writeObject(people);
			
			/* os.writeObject(peopleList);
			 * 
			 * You may want to serialize one object at a time from an array list
			 * The below code and method shows you how to serialize if you want to know the number of objects being serialized 
			 * 
			 * os.writeInt(peopleList.size()); // Tells you how many objects have been serialized 
			 * 
			 * for (Individual individual: peopleList){
			 * 	    os.writeObject(individual);
			 * }
			 * 
			 */
			
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

			Individual[] people2 = (Individual[]) os.readObject();
			
			// You need to iterate through the array to display the objects inside the array
			for (Individual individual:  people2) {
				System.out.println(individual);
			}
			
			/* @SuppressWarnings("unchecked")
			 * ArrayList<Individual> peopleList2 = (ArrayList<Individual>) os.readObject();
			 * 
			 * The line of code above will have a warning (that can be ignored) due to type erasure
			 * Type erasure means that when Java compiles, the information about the class in the diamond brackets are lost
			 * Write the suppress warning line above the code to suppress this warning 
			 * 
			 * for (Individual individual:  peopleList2) {
			 *		System.out.println(individual);
			 * }
			 * 
			 * 
			 * Reading one object at a time
			 * int num = os.readInt();
			 * 
			 * for (int i = 0; i < num; i++){
			 * 		Individual individual = (Individual) os.readObject();
			 * 		System.out.println(individual);
			 * }
			 * 
			 */
			
			os.close(); // Remember to close 

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
