package common_exceptions;

/**
 * Examples of NullPointerException.  
 * 
 * Thrown when attempting to access an object whose reference has a null value.  
 * @author Tonisha
 *
 */
public class NullPointer {
	Object myObject;
	
	/**
	 * Calls methods that throw NullPointerExceptions.
	 * @param args
	 */
	public static void main(String[] args) {
		NullPointer np = new NullPointer();
		np.accessBeforeInst();
	}
	
	/** 
	 * Attempt to access an object instance variable that has not yet been
	 * instantiated. 
	 */
	public void accessBeforeInst(){
		try{
			myObject.toString();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}

}
