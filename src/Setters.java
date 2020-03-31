class frog {
	private String name;
	private int age;
	// private enforces encapsulation, now you can't access these variables directly 
	
	public void setName(String newName) {
		this.name = newName;
	} // This is the method of setting 
	
	/* 
	 * If you want the local variable in the setName to be 'name':
		public void setName(String name) {
			this.name = name;
		} 
	 * this.name refers to the instance variable (the one in line 2, not the local variable)
     * This is the pattern for setters, set methods 
     */
	
	public void setAge(int newAge) {
		this.age = newAge;
	}
	
	// You can have a method call another method within the same object 
	public void setInfo(String name, int age) {
		setName(name);
		setAge(age);
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
}

public class Setters {

	public static void main(String[] args) {
		frog frog1 = new frog();

		/* Now we want to hide the object's instances from outside the class 
		 * Normally, we access the variables directly, i.e. to use the class you need to know what are its internal variables 
		 * So, a set method allows us to set the data and now all we have to know are the methods the frog class has, 
		 * it's internal variables need not be known
		 * With this, you can avoid referring to the instance variables in a class outside frog 
		 */
		
		// So now, the set method is done this way:
		frog1.setName("Froggie");
		frog1.setAge(5);
		// This process is called encapsulation - you are hiding instance data from a class other than your object class 
	}

}
