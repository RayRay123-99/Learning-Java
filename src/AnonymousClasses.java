class Plane {
	public void start() {
		System.out.println("Plane starting....");
	}
}

interface geEngine {
	public void engineStart();
	// Recall that interfaces don't have any code written
}

public class AnonymousClasses {

	public static void main(String[] args) {
		// Anonymous classes are basically a way of extending an existing class or implementing an interface
		
		Plane SIA = new Plane() {
			// The code below will over write the method in the object's class
			@Override
			public void start() {
				System.out.println("Plane shutting down....");
			}
		}; 
		/* The reason why this can be done is because when you create a new object of the class 'Plane' 
		 * The new object is actually a child class of the parent 'Plane' that just doesn't have a name
		 * That's why it's called an anonymous class
		 */
				
		SIA.start();
				
		/* This isn't possible: Engine engine1 = new Engine();
		 * This is because it is not possible to instantiate the type 'Engine'
		 * Instantiate means to create an object from class 'Engine'
		 * You can't instantiate a new object from interfaces as there's no code to actually put on the object 
		 */
				
		// But you can go about this using anonymous classes and GUIs are often implemented this way too:
		geEngine engine1 = new geEngine() {
			// Just implement the method from the interface here
			public void engineStart() {
				System.out.println("Engine starting....");
			}	
		};
				
		// You can then call the method of the anonymous class which actually implements the interface 
		engine1.engineStart();	
	}

}
