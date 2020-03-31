import java.util.Collection;

public class Arrays {

	public static void main(String[] args) {
		//********************************
		/** Basic number array **/
		int[] values; //This is an array
		values = new int[3]; //Making array hold 3 values
		
		values[0] = 1;
		values[1] = 5;
		values[2] = 10;
		
		System.out.println(values[1]); //prints out 5
		
		for (int i = 0; i < values.length; i++) {
			System.out.println(values[i]);
		} //iterating an array
		
		int[] numbers = {1,2,3,4};
		
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	
		System.out.println("\n");
		
		
		
		//********************************
		/** String array **/
		
		String[] words = {"Hello ", "You ", "Little!"};
		
		//Another way of iterating an array
		for (String word : words) {
			System.out.printf(word);
		} /** word is the string name and words is the array name
		so the name of the string output is 'word' **/
		
		//Remember in strings, each array is only pointing at the address of the first letter in the string (same as C)
		//So remember to initialize your array address
		String words2 = null;

		System.out.println("\n");
		
		
		
		//********************************
		/** Multi Dimensional Arrays **/
		int [][] grid = {
				{1, 2, 3, 4},
				{5, 6, 7},
				{8, 9, 10}
		}; //Each element of the 2D array is an array
		
		System.out.println(grid[2][0]); //Row number first before column number 
		
		//Iterating a Multi dimensional array
		for (int row = 0; row < grid.length; row++ ) {
			for (int column = 0; column < grid[row].length; column++) {
				System.out.print(grid[row][column] + "\t"); //Prints numbers out on the same line
			}
			System.out.println("\n"); //Prints out new line for every new row
		} //Iterate the rows for outer loop and the columns for inner loop
		
		//Create array and initializing it later
		String[][] texts = new String[2][]; //Need to set the sub arrays manually
		
		texts[0] = new String[3]; 
		texts[0][1] = "Hi There";
		System.out.println(texts[0][1]);
	}

}
