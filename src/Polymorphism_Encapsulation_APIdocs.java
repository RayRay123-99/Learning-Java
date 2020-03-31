/// Note new classes should be put in another class 
class Plant {
	private String name; // Instance variables should be private 
	public static final int ID = 1; // This can't be changed anymore from outside the class 
	
	public void grow(){
		System.out.println("Plant growing!");
	}

	/* Encapsulation refers to the bundling of data with the methods that operate on that data, 
	 * or the restricting of direct access to some of an object's components
	 * The idea of encapsulation is that you encapsulate the inner workings of that class within the class (stop people outside the class to see the class' workings)
	 * If we want to allow people to set/get to the instance variable, we use getters and setters
	 */
	
	// We can get eclipse to create the getter/setter for you (right-click -> source)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	// With this, we can change the instance variable name and as long as the methods don't change, the inner workings of the class remains the same 
	
	// Method used by the class itself
	public String getData() {
		String data = "Forecast height: " + calculateGrowthForecast();
		return data;
	}
	
	private int calculateGrowthForecast() {
		return 5;
	} // This is not intended to be used outside the class
	
	/* You should always attempt to make everything private/protected if it needs to be accessible from the child class 
	 * Only make public the things you want the end user to be able to use or set (usually constants or variables that don't change very often)
	 * This is to reduce cross languages within the program (prevent another class from entering your current class)
	 * This also allows you to hide implementation details within your class and only show the public API programming device 
	 */
	
	// API documentation can be found in Google, it tells us the characteristics and examples of how to use the various Java methods and data types 
}

class Tree extends Plant{

	// Recall you can override/implement methods (right click -> Source)
	@Override
	public void grow() {
		System.out.println("Tree growing!");
	}
	
	public void shedleaves() {
		System.out.println("Leaves shedding");
	}
}

public class Polymorphism_Encapsulation_APIdocs {

	public static void main(String[] args) {
		Plant plant1 = new Plant();
		Tree tree1 = new Tree();	
		
		/* Polymorphism means that if you have a child class of some parent class,
		 * you can use the child class where you would normally use the parent class 
		 * So, wherever a parent class is present, you can use the child class of that parent 
		 */
		
		Plant plant2 = tree1;
		/* Because tree is a subclass of plant, we can use it whenever you have a 'plant' class so the above code is allowed
	     * The object plant2 is pointing at is now tree1 (it's not a plant object)
	     * This is because when you run the method what actually matter is not the variable (plant2) but the object (tree1)
	     */
		
		plant2.grow();
		tree1.shedleaves();
		/* plant2.shedleaves(); This code does not work 
		 * This is because when you are calling a method, what matters is the type of variable (type of reference, in this case plant2) 
		 * The variable type decides what kinds of methods you can call
		 * When you actually run the method, you are going to the object which will run the relevant code
		 */
		
		doGrow(plant1);
		doGrow(tree1); // This will run because of polymorphism 
	}
	
	public static void doGrow(Plant plant) {
		plant.grow();
	}
}
