class Hamster {
	private String name;

	// Remember to always generate constructors, setters, getters and toStrings for any classes you create
	public Hamster(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Hamster [name= " + name + "]";
	}
	
	
	
}

public class PassingByValue {

	public static void main(String[] args) {
		// There is NO passing by reference in Java, you can only do passing b y value
		
		PassingByValue methodToUse = new PassingByValue();
		/* By doing this, you can use the variable methodToUse in the main method to call non static methods of the class PassingByValue
		 * Variables should always start with a lowercase letter while classes should start with an uppercase 
		 */
		
		// Passing primitive types by value
		int number = 7; // The name of the variables and the method arguments are NOT connected at all 
		methodToUse.show(number);
		/* What we are doing here is that we are copying data from one variable to another (number to value in the method show())
		 * The scope of a variable (the region  you can use it) is usually within one curly parentheses 
		 * This entire process is called Passing By Value 
		 */
		
		System.out.println(number);
		System.out.println(); // Empty line
		
		
		// Passing non-primitive types by value
		Hamster no1 = new Hamster("Teddy");
		/* At this point here, Java actually does not allocate enough memory to store the instantiated object (unlike the case with primitive types)
		 * So, Java is actually storing the address of the object, so variable 'no1' is actually storing an address 
		 */
		System.out.println(no1);
		
		methodToUse.show(no1); // Java automatically knows which version of show to invoke 
		// At this code, Java is actually copying the value of the ADDRESS 
		
		System.out.println(no1);
		
		/* Passing by value is different from passing by reference which in effect means that the variable in the main method and the argument in the methods are the SAME
		 * The value passed into the method and the value changed in the method are the same (changing variables in the method will cause a change in the value in the main method)
		 */
	}
	
	public void show(int value) {
		// The variable 'value' is merely a copy of whatever argument is passed in  
		System.out.println("Value is: " + value);
		
		value = value + 1;
		System.out.println("New Value is: " + value); // You will see that this doesn't change the original value at all 
		// This is because value and number in the main method have different scopes, they don't affect each other (this is a characteristic of passing by value)
	}
	
	public void show(Hamster hamster) {
		/* This has the same name as the first method, this is called method overloading
		 * You can have methods of the same name as long as they have a different argument list 
		 * Classes are non-primitive types 
		 */
		
		System.out.println("Hamster name is: " + hamster);
		
		hamster.setName("Thomas"); // This however WILL change the class' name
		// This is because at this point, this actually still referring to the object and we are actually changing the object
		
		hamster = new Hamster("Betty"); // This however does not change the actual Person object in the main method
		/* At this point, you are actually putting a NEW address of the new object into the argument 'hamster'
		 * So, you lose the previous address that actually references to the original object, so the original object won't be affected 
		 * This is still passing by value because we are simply copying the value 
		 */
		
		
		System.out.println("Hamster name is: " + hamster); // So this displays the new object 
	}
}
