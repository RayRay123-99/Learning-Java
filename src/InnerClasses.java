
class Droid {
	private int id;

	// Create constructor to set the field id with the id that is passed in main method by the user 
	public Droid(int id) {
		this.id = id;
	}
	
	public void start() {
		System.out.println("Droid starting" + id);
		
		// You can use inner classes in your methods
		Brain brain = new Brain();
		brain.think();
		
		final String name = "ROGER"; // Has to be final to be used by the inner class 
		// This follows the same rules as anonymous classes where local data can only be accessed of it's final 
		
		/* You can even declare classes within your methods 
		 * Useful if you need an instance of a class to pass to another method 
		 * This class cannot be accessed outside of this method (and you can't make it private/public)
		 */
		class Temp {
			public void intro() {
				System.out.println("ID is: " + id);
				System.out.println("Name: " + name);
			}	
			// This will have access to any instance variables within the outer class and within the method enclosing it 
		}
		
		Temp temp1 = new Temp();
		temp1.intro();
	}
	
	// This is the first kind of inner class - a nested inner class 
	public class Brain {
		// This class will have access to the instance data of the outer class (i.e. the id)
		
		public void think() {
			System.out.println("Robot " + id + " is thinking");
		}
		
		/* You can use inner classes to implement an iterator that iterates through the data of the enclosing class
		 * You can use the inner class outside the outer class, as shown in the example here (see start() method in this class)
		 * But usually, you will have a method that will create an instance of your inner class and return it 
		 * This will be seen if you implement iterables 
		 */
	}
	
	// This is the second kind of inner class - static inner classes 
	public static class Battery {
		// Now because the class is static, we CANNOT refer to the instance data of the outer class (unless if the instance data is static too)
		public void charge() {
			System.out.println("Battery charging");
		}
		// Hence, static classes are usually just used to group classes together 
	}
	
	/* Non-static inner classes are used when you want to group some functionality together and you need the class to have access to the instance variables of the enclosing (outer) class
	 * Static inner classes are used when you want a normal class that isn't associated with instances of the enclosing (outer) class but you still want to group the classes together 
	 */
}

public class InnerClasses {

	public static void main(String[] args) {
		// We use the class 'Droid' to illustrate inner classes  
		Droid droid1 = new Droid(1);
		droid1.start();
				
		/* Recall in Java that we can create classes anywhere within the program, the only rule is that you can only have one public top level class in each class and it should match name of file
		 * So, the first kind of inner class is a nested class
		 * Inner classes are used to logically group bits of outer classes together 
		 */
				
		// You can use the inner classes themselves if the inner class methods and the inner class itself are declared as public
		Droid.Brain brain1 = droid1.new Brain(); // Not commonly used
		brain1.think();
				
		/* You can see from the above example that just because you've created an object of the outer class, it does not mean an object of the inner class is automatically created
		 * This instantiation of the inner class is usually done within the class itself or within some method 
		 * Or you can do it outside the class like the example above 
		 */
				
		// How to use a static inner class:
		Droid.Battery battery1 = new Droid.Battery();
		battery1.charge();
	}

}
