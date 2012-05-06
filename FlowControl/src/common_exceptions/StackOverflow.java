package common_exceptions;
/**
 * Examples of commonly seen exception -StackOverFlowError.
 * Typically occurs when a method recurses to deeply which results in no 
 * more space on the stack.
 * @author Tonisha Whyte
 *
 */
public class StackOverflow {

	
	/**
	 * Calls a method that recurses until the stack has no more space.
	 * @param args
	 */
	public static void main(String[] args) {
		myRecursiveMethod();
	}
	
	public static void myRecursiveMethod(){
		myRecursiveMethod();
	}

}
