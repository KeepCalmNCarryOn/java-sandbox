package common_exceptions;
/**
 * Examples of AssertionErrors.
 * 
 * Assertion errors are thrown when a statement's boolean test returns false. 
 * Note: assertions are turned off by default.
 * @author Tonisha Whyte
 *
 */
public class Assertion {

	/**
	 * Calls methods that throw AssertionErrors.
	 * @param args
	 */
	public static void main(String[] args) {
		assertFalse();
		throwAssertionError();
	}
	
	/**
	 * Asserts false.
	 */
     public static void assertFalse(){
    	 try{
    		 assert(false);
    	 }catch(AssertionError e){
    		 e.printStackTrace();
    	 }
    		 
     } 
     
     /**
      * Creates and throws a new AssertionError.
      */
     public static void throwAssertionError(){
    	 try{
    		 throw new AssertionError();
    	 }catch(AssertionError e){
    		 //it's not common practice to catch an assertion error
    		 e.printStackTrace();
    	 }
     }
}
