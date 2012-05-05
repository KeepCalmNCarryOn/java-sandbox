package common_exceptions;
/** 
 * Examples of a commonly seen error -the ExceptionInInitializerError.
 * This error occurs when a mistake is made in an initializer.
 * @author Tonisha Whyte
 *
 */
public class ExceptionInInstanceInitializer {
	{
		System.out.println("Inside instance initializer");
		char[] straws = new char[4];
		straws[-4] = 'c';
	}
	
	public ExceptionInInstanceInitializer(){
		System.out.println("Inside constructor after call to super");
	}
		
	/**
	 * Nothing!
	 * Instance initializers are created outside of methods and run right after 
	 * the call to super() completes.
	 * @param args
	 */
	public static void main(String[] args) {
		new ExceptionInInstanceInitializer();
	}

}
