package ocean;
// This will be used in Public_Private_Protected

public class Plant {
	public String name; 
	
	// Public instance variables should be made constant 
	public final static int ID = 1;
	// Recall all uppercase means the variable is a constant and the 'final' keyword also ensures this
	// This can be accessed from anywhere but it CANNOT be changed (since it's static) and this is a more acceptable practice 
	
	// Usually when you have an instance member variable or class variable (the variables up there), it is usually declared private
	private String type;
	// You can access 'type' within this class 
	
	// But if you want to access a private instance in the subclass/child of this class/ anywhere within the same package, we use 'protected'
	protected String size;
	
	// Lastly you can choose to have no instance modifiers at all and this basically allows it to be accessed within the package 
	int height;
	// Package-level visibility and this stands even if plant has child class/subclass in ANOTHER package 
	
	// Do note public, private, protected and no modifier variables can all be accessed and changed within the same class
	
	public Plant() {
		this.name = "Venus Flytrap";
		this.type = "Greenery";
		this.size = "Large";
		this.height = 5;	
	} // This is a constructor 
}
