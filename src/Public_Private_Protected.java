import ocean.Plant;

public class Public_Private_Protected {
	public static void main(String[] args) {
		Plant plant1 = new Plant();
		
		/* If you have a instance/member variable declared as public, you can access it from anywhere 
		 * You can basically access the plant's name from anywhere 
		 * This is however bad practice because instance variables should be encapsulated (hidden) and should be accessed from methods so you can control them 
		 */
		
		System.out.println(plant1.name);
		System.out.println(plant1.ID);
		// You can access the public variables of the 'Plant' class from here 
		
		// Explanation for 'private' and 'protected' variables in 'Plant' class 
	}
}
