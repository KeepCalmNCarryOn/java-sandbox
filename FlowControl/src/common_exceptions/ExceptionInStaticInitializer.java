package common_exceptions;
/** 
 * Examples of the ExceptionInInitializerError in a static initializer.
 * @author Tonisha Whyte
 *
 */
public class ExceptionInStaticInitializer {

	static{ 
		Object o;
		Integer i = new Integer(4);
		o = i;
		Boolean b;
		b = (Boolean)o;
		b.booleanValue();}
	
	/**
	 * Nothing!
	 * Static initializers are created outside of methods and run by the class
	 * loader.  You can not catch an ExceptionInInitializerError.
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
