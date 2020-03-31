class Instrument{
	public void start() {
		System.out.println("Instrument started!");
	}
}

class Camera extends Instrument {
	public void start() {
		System.out.println("Camera ON");
	}
	
	public void takePhoto() {
		System.out.println("Snapping pictures");
	}
}

public class Casting_Upcasting_Downcasting {

	public static void main(String[] args) {
		// Different types of integers
		byte byteValue = 25; // Only -128 to 127
		short shortValue = 125; 
		int intValue = 888;
		long longValue = 10000;
		float floatValue = 8314.556f; // We need to put the f in the end because java takes the value as a double by default
		float floatValue2 = (float) 3.1456;
		double doubleValue = 35.5;
		
		// These integers have their own build in methods
		System.out.println(Byte.MAX_VALUE);
		
		// You can cast one type of numerical value to another type (store one kind of numerical value into another type)
		intValue = (int)longValue; // You write down the type you want to cast into in the bracket
		floatValue = (float) intValue;
		intValue = (int) floatValue; // Note this just gets rid of the decimal it does not round off
		System.out.println(floatValue);
		
		// Sometimes you don't need to do casting
		doubleValue = intValue;
		
		// Be careful to not stuff an over sized type into a type that doesn't have the memory to store it 
		byteValue = (byte)129; // Too big for a byte 
		System.out.println(byteValue); // It will print out 127 + 2 = -127 (looping around back to -128)
		
		// Note: You can't cast a string to an integer 

		System.out.println("\n");

		
		
		//********************************
		/* This is on upcasting and downcasting */
		Instrument instrument1 = new Instrument();
		Camera camera1 = new Camera();
		
		instrument1.start();
		camera1.start();
		camera1.takePhoto();
		
		// Upcasting
		// With this, you can change the variables that refer to the classes (Instrument and Camera) from one site to another and this is guaranteed by polymorphism 
		Instrument instrument2 = camera1; // This is upcasting
		
		/* What has been done is that you've taken a variable of type Camera that refers to a camera object and 
		 * you've made the variable of type Instrument refer to this camera object 
		 * It's upcasting because you've gone up the hierarchy from child class (Camera) to parent class (Instrument)
		 */
		
		instrument2.start(); // The output here depends on the object that instrument2 is referring to because objects are the one that store the methods
		// This will call the start method in camera because the actual object actually being referred to by instrument2 is the camera object 
		
		/* instrument2.takePhotos(); This will not work
		 * 
		 * This is because it is the actual variable that decides which methods can be called (and the variable is an Instrument type)
		 * So in summary: Type of variable (Instrument) determines what methods you can call, and
		 * the type of the object that variable refers to (Camera) determines which actual methods (implementations) will be called when you call that method 
		 */
		
		
		// Downcasting
		Instrument instrument3 = new Camera();
		// Now instrument3 is actually referring to a camera object 
		
		Camera camera2 = (Camera) instrument3; // Put in brackets the type you are casting into 
		camera2.start();
		camera2.takePhoto();
		
		// Downcasting is inherently unsafe
		// The method below shows a common mistake:
		
		/* Instrument instrument4 = new Instrument();
		 * Camera camera3 = (Camera) instrument4;
		 * camera3.start();
		 * camera3.takePhotos();
		 */
		
		/* The codes in line 93, 94 won't work and you will get a runtime error because the actual object here is an Instrument, and you can't just change objects like that 
		 * The codes won't work because the instrument object doesn't have the camera object methods 
		 * Also, you can't downcast between unrelated types - you can't change one object to another object
		 * All you can do is change the references which in turn depend on the underlying object 
		 */
	}

}
