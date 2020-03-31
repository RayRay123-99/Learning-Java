import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;

class Test {
	public void run() throws IOException, ParseException {
		
	// Very rarely will you have a method that throws an exception unless if it's some sort of not implemented exception
	
	// throw new IOException();
			
	// Consider the case that you want to throw in another exception (if the exception above does not get thrown (i.e. carried out))
	// So, you add in another exception
			
	throw new ParseException("Error in Command List.", 2); // A Parse Exception is thrown in if you are parsing through some list
	/* Notice there is now a comma separated list of exceptions above but note you can only throw one exception at a time
	 * A particular method can throw in any number of exceptions 
	 */
	}
	
	public void input() throws IOException, FileNotFoundException {
		System.out.println("Something");
	}
}

public class MultipleExceptions {
	public void run() // throws IOException, ParseException 
	{
		Test test1 = new Test();
		
		// Let's say you want to handle the exception instead of throwing it out
		// One option is to use the try-catch block
		
		/*
			try {
				test1.run();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
				System.out.println("Couldn't parse out command file");
			} 
		 * You can have multiple catch blocks but only ONE try block
		 */
		
		// The other option is to use multi-catch:
		
		/* 
			try {
				test1.run();
			} catch (IOException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 */
		
		// Due to the concept of polymorphism, we can pass a child class where a parent class is expected 
		// So there is one more method:
		
		try {
			test1.run();
		} catch (Exception e) {
			// We changed it so that this catch block will catch any type of exception because the 'Exception' is a parent class - any kind of exception is considered a child class 
			e.printStackTrace();
		} 
		
		// There is a peculiarity about the exceptions - especially for child classes of exceptions:
		try {
			test1.input();
		} catch (FileNotFoundException e) {
			/* This FileNotFoundException has to be written first 
			 * This is because this exception is a child class of IOException, IOException would have caught this one and we won't know we had this particular error 
			 * A child exception has to be handled first before the parent is handled otherwise the parent will catch it due to polymorphism 
			 * In cases like this, a multi catch is not allowed 
			 */
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
