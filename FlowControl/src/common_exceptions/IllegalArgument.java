package common_exceptions;
/**
 * Examples of IllegalArgumentException.  
 * 
 * Thrown when a method receives an argument 
 * formatted differently than the method expects.
 * @author Tonisha
 *
 */
public class IllegalArgument {
	public static void main(String args[]){
		int odd = 11;
        new IllegalArgument().evenNumber(odd);
        System.err.println("\n");
        illegalArgForBoxing();
	}

	/**
	 * Accepts and even number.
	 * @param number
	 */
	public void evenNumber(int number){
		try{
			if (number % 2 != 0){
				throw new IllegalArgumentException("Received odd number " + number);
				
			}
		}catch (IllegalArgumentException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Sends an argument to Integer's valueOf() that can not be converted to an
	 * integer.
	 */
	public static void illegalArgForBoxing(){		
		try{
			String three = "three";
			int theNumberThree = Integer.valueOf(three);
			System.out.println(theNumberThree + " blind mice");
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
	}
}
