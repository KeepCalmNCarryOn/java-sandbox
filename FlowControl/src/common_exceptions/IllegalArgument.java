package common_exceptions;
/**
 * Example of IllegalArgument exception.  
 * 
 * Thrown when a method receives an argument 
 * formatted differently than the method expects.
 * @author Tonisha
 *
 */
public class IllegalArgument {
	public static void main(String args[]){
		int odd = 3;
		try{
			new IllegalArgument().evenNumber(odd);
		}catch (IllegalArgumentException e){
			e.printStackTrace();
		}
	}

	public void evenNumber(int number) throws IllegalArgumentException{
		if (number % 2 != 0){
			throw new IllegalArgumentException();
		}
	}
}
