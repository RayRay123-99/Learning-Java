abstract class Device {
	/* A common functionality that all the child classes should be added in the parent class 
	 * By setting up getters and setters for id, every child class now has the attribute id
	 * This is the conventional class hierarchy 
	 */ 
	
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	/* Abstract classes can have abstract methods as well 
	 * This means that abstract methods will be implemented by all the child classes but NOT the parent class itself
	 */
	
	public abstract void start(); // There is no need to write any code, similar to an interface 
	// Just add this method into all the child classes 
	
	// You can also add abstract methods to other methods within the parent class
	public void run() {
		start();
		System.out.println("System running");
	}
	// This is useful as it forces the child class to have certain methods that you want them to implement
}

class VideoTape extends Device {

	@Override
	public void start() {
		System.out.println("VideoTape ON");
	}
	
}

class Phone extends Device {

	@Override
	public void start() {
		System.out.println("Phone ON");
	}
	
}

public class AbstractClass {

	public static void main(String[] args) {
		/* Abstract classes can be used when you want to create a class hierarchy 
		 * The base class however can't do anything, it only acts as a base for the other classes 
		 */
		
		VideoTape tape1 = new VideoTape();
		tape1.setId(5);
		tape1.run();
		
		Phone iphone = new Phone();
		iphone.setId(2);
		iphone.run();
		
		/* Now what if the classes is such that the parent class is not used at all, only the child classes have methods
		 * The parent class only acts as a base to implement all the common functionalities that a child class will have
		 * So, you can prevent the user of the class hierarchy from instantiating the parent class by making it abstract
		 */
		
		// Device device1 = new Device();    this code can't be carried out and will produce an error since it's an abstract class
		
		/* The way abstract classes are used is very similar to how an interface is used as they both force users to implement methods 
		 * 
		 * However, the difference is if you create an abstract class, you're making a strong statement on what the child class fundamentally is
		 * An interface will apply to any kind of class (parent or child), but with an abstract class:
		 * If a child class is used, it is as good as saying the child class is the parent class (like iphone is a device, a videotape is a device)
		 * An abstract class defines the fundamental nature of the class and gives it a hierarchy (so please note when creating child-parent classes)
		 * 
		 * Another thing to bear in mind is that while a class can implement many interfaces, it only has one parent class 
		 * so there is only ONE abstract class in the entire hierarchy
		 * 
		 * It means that having an abstract class is saying more about the fundamental identity of the classes 
		 * Also, while you cannot have codes in an interface, in an abstract class, you can provide default functionality (like id)
		 * That's because a child class inherits the functionality of it's parent 
		 * 
		 * Whereas, in an interface, it is completely up to the implementing class what the implementation should be in the class
		 * An interface only defines the form of methods the class should have 
		 */
	}

}
