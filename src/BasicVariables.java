
public class BasicVariables {
	/** This is a Java comment **/
	
	public static void main(String[] args) {
		/** just type in 'main' and press ctrl+Space for eclipse to type public static void out for you **/
		
		int myNumber = 88;
		short test1 = 156;
		long test2 = 6700;
		
		double test3 = 7.3245;
		float test4 = 324.47f; /** Note the f at the back to show its a float **/
		
		char myChar = 'Y';
		boolean myBoolean = true;
		byte myByte = 127; /** Can only hold up to 127 **/
		
		String str = "someText";
		String str2 = " ";
		String str3 = "someText2";
		String combinedstr = str + str2 + str3; /** You can combine strings **/
		
		System.out.println("Hello World!"); 
		System.out.println(myNumber);
		
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		System.out.println(test4);
		
		System.out.println(myChar);
		System.out.println(myBoolean);
		System.out.println(myByte);
		
		System.out.println(str);
		System.out.println(combinedstr);
		
		/** See the different ways we can concatenate strings **/
		System.out.println("Hey" + " " + "study!");
		System.out.println("My integer is: " +myNumber); 
		
		/** Press control+space for eclipse to autocomplete for you (for instance, we just type sysout here) **/
	}
}
