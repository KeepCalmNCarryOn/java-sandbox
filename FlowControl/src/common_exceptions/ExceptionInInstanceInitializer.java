package common_exceptions;
/** 
 * Examples of a commonly seen exception -the ExceptionInInitializerError.
 * This error occurs when a mistake is made in an initializer.
 * @author Tonisha Whyte
 *
 */
public class ExceptionInInstanceInitializer {
	static ExceptionInInstanceInitializer loki = 
			new ExceptionInInstanceInitializer();
	
	/**
	 * Indicates when the initializer runs.  The print statement will never be
	 * displayed due to the exception.
	 */
	public ExceptionInInstanceInitializer(){
		System.out.println("Inside constructor after call to super");
	}
		
	/**
	 * Calls the constructor.
	 * Instance initializers are created outside of methods and run right after 
	 * the call to super() completes so they can not be caught.
	 * @param args
	 */
	public static void main(String[] args) {
		//new ExceptionInInstanceInitializer();
	}
	
	// This initializer accesses an object that is not yet available.
	{
		loki.toString();
	}

}