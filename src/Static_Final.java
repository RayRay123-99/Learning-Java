class Thing {
	public final static int KEYCODE = 001; // final is Java's version of constant 
	public String name; // These are instance variables, i.e. every object created from this class will get its own copy of this
	public static String description; // These are known as class variables because they are associated with the class
	
	// Statics can be used to count the number of objects that you have created and assign a unique ID for each object 
	public static int count = 0;
	public int id = 0;
	
	public Thing() {
		count++; // This belongs to the class and is shared within all objects 
		id = count;
	} // Constructor will run everytime an object of class Thing is created, recall a Constructor is run everytime a new object is created 
	
	
	public void sayName() {
		System.out.println(name);
		System.out.println(description + " " + name + ". Object ID: " + id);
	} // Instance variables can access static data because you already have class data when you create the object 
	
	public static void sayDescription() {
		System.out.println(description);
	} /* Static methods can access static data because they both belong to the class (not the object) 
	   * but it can't output instance variables (like name in this case) because it exists even before you create the objects 
	   */	
}

public class Static_Final {

	public static void main(String[] args) {
		Thing thing1 = new Thing();
		Thing thing2 = new Thing();
		
		thing1.name = "Bob";
		thing2.name = "Joe";
		
		Thing.description = "I am a thing";
		
		thing1.sayName(); // This is how we normally call a subroutine 
		thing2.sayName();
		Thing.sayDescription(); // This is how we call a subroutine that is a class variable 
	
		// An example of the use of static in java (with the Math.class in built in Java):
		System.out.println(Math.PI); // Constant values are written in uppercase in Java
		// The PI here is a static variable, it can't be reassigned another value 
		
		System.out.println("Keycode for the object: " + Thing.KEYCODE); // Prints out the constant value assigned to the class 
		System.out.println("Number of objects created: " + Thing.count); // Prints out the static variable count attached to the object 
	}

}
