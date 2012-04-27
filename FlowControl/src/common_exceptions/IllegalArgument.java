package common_exceptions;

import java.util.Scanner;

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
        illegalArgForBoxing();
        invalidCharSet();
	}

	/**
	 * Attempts to open a Scanner using a character set that doesn't exist.
	 */
	public static void invalidCharSet(){
		try{
			Scanner s = new Scanner(System.in, "UTF-9");
			s.close();
		}catch(IllegalArgumentException e){
			e.printStackTrace();
		}
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
			System.err.flush();
			System.err.println("\nNOTE: NumberFormatException extends IllegalArgumentException\n");
		}
	}
}
