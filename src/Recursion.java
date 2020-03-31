
public class Recursion {

	public static void main(String[] args) {
		int value1 = 4;
		calculate(value1);
		
		// Recursion can be used to do factorial calculations which is very useful in probability theory
		System.out.println(calculate(value1));
		
		/* For recursion, you need to identify one step (or a set of steps) that can solve the problem and continuously apply that same solution over and over 
		 * You can also use loops instead of recursion but recursion is much simpler and shorter 
		 * Think backwards when using recursion, think of the step that comes before the final solution 
		 */
	}

	private static int calculate(int number) {
		/* Recall that we use static because if you want to call a method of a class, static must be used
		 * If static isn't used, we will need to create a new object based on the 'Recursion' class 
		 */
		
		/* Note that the value (number) passed in will not cause any change in the value of value1 in main
		 * i.e. value1 is passed into this method as a local variable and it is stored in the stack part of memory 
		 * The stack stores all local variables and is used for remembering which method called which method so Java knows where to return after the method is called
		 * This is in contrast to the heap  where objects are allocated when you use the 'new' operator 
		 */
		
		/* Recursion is the method where we get the method to call itself 
		 * we need to provide the method a way to stop calling itself
		 */
		
		if (number == 1) {
			return 1;
		}
		else {
			return number * calculate(number-1);
		}
	}
}
