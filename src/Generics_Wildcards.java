import java.util.ArrayList;
import java.util.HashMap;

class Appliance {

	@Override // Generated using right-click -> Source -> Generate toString
	public String toString() {
		return "I am an Appliance";
	} // Recall  A toString method exists so we can use it to continuously check that the entire program is working alright 
	
	public void start() {
		System.out.println("Appliance Starting");
	}
}

class Microwave extends Appliance {
	@Override // Generated using right-click -> Source -> Generate toString
	public String toString() {
		return "I am a Microwave";
	}
	
	public void heat() {
		System.out.println("Reheating food");
	}
}

public class Generics_Wildcards {
	public static void main(String[] args) {
		/* A generic class is a class that can work with other objects 
		 * You specify what type of object it can work with when you instantiate the class 
		 */
		
		ArrayList list1 = new ArrayList(); // Basically manages an array internally so we don't have to worry about the size of the array
		// Now you have an object that can store other objects 
		
		list1.add("apple");
		list1.add("banana");
		list1.add("orange");
		
		// To get an item from the list:
		String fruit = (String) list1.get(0); // The bracket contains the index where the object is located and you need to downcast the object returned first
		System.out.println(fruit);
		
		/* The idea behind generics is that if you have a class that works with some particular type (or 2/3) of object
		 * You can use generics to add type parameters to specify what kind of object you want that class to work with 
		 */
		
		ArrayList<String> stringList = new ArrayList<>(); // In generics, we specify the kind of object/data to work with in the diamond brackets
		// We can even put classes that we created ourselves, it doesn't have to be standard java data types 
		// The diamond brackets can be left empty in the right side especially useful if you have nested type parameters 
		
		stringList.add("Cat");
		stringList.add("Doggy");
		stringList.add("Elephant");
		
		String animal = stringList.get(0); // There is no longer any need to downcast 
		// Methods will now return objects of the appropriate type 
		
		
		System.out.println(animal);
		
		// You can have parameterized classes with more than one type of argument 
		HashMap<Integer, String> mapList = new HashMap<Integer, String>();

		System.out.println("\n");
		
		ArrayList<String> list2 = new ArrayList<>();
		// We will now pass in list2 as a parameter into a method 
		list2.add("ONE");
		list2.add("TWO");
		list2.add("THREE");
		
		showArrayList(list2);
		// So if you want to pass in an ArrayList as a parameter into a method, just remember the type of parameter includes the type of parameter in the diamond bracket
		
		
		System.out.println("\n");
		
		ArrayList<Appliance> list3 = new ArrayList<>();
		
		list3.add(new Appliance());
		list3.add(new Appliance());
		
		showArrayList2(list3);

		
		System.out.println("\n");
		
		// Now what if you want to pass in a list of Microwaves (the child class of the parent class 'Appliance')
		/* Before you start, you need to recognise that an array list of a child class (or any other parameterized class)
		 * is NOT a subclass of the same parameterized class with the parent type of class  
		 * Basically ArrayList<Microwaves> is NOT a subclass of ArrayList<Appliance> so you can't pass an ArrayList of Microwaves into the ArrayList of Appliances method
		 */
		
		// To go about this, we use a wildcard in the method (see below)
		ArrayList<Microwave> list4 = new ArrayList<>();
		
		list4.add(new Microwave());
		list4.add(new Microwave());
		
		showArrayList3(list4);
		showArrayList4(list4);
	}
	
		public static void showArrayList(ArrayList<String> list) {
			for (String value: list) {
				System.out.println(value);
			}
		} // Must be static so we can call the method even without an object of class 'Generics_Wildcards'
		
		
		public static void showArrayList2(ArrayList<Appliance> list) {
			for (Appliance value: list) {
				System.out.println(value);
			}
		} 
		
		
		public static void showArrayList3(ArrayList<?> list) {
			for (Object value: list) {
				System.out.println(value);
			}
		} 
		/* This method takes in an ArrayList of unknown type, any ArrayList can now be passed in 
		 * The disadvantage now is that you can only treat the items in the list as being type Object as its the ultimate parent of all classes in Java
		 * So you can't pass in any Appliance or Microwave type specific methods 
		 * The only way to go about this disadvantage is through the use of downcasting 
		 */
		
		
		public static void showArrayList4(ArrayList<? extends Appliance> list) {
			/* The extends Appliance part in the wildcard is an example of setting an upper bound for this wildcard
			 * The method will now only work on Appliance class and any of this class' child 
			 * Applies to any parent-child classes and parameterized classes 
			 */
			
			/* Alternatively, a lower bound can be set:
			 * public static void showArrayList3(ArrayList<? super Microwave> list) 
			 * This means that the ArrayList must be a list of Microwave or any superclass of Microwave
			 * Though this is much more troublesome since the superclasses may not have methods specific to this class 
			 */
			
			for (Appliance value: list) {
				System.out.println(value);
				value.start(); 
				// You can't however put in methods specific to the child class 
			} 
			// Will work for both Microwave and Appliance classes since child class will have inherited methods from the parent class 
		} 
}
