package common_exceptions;

/**
 * The ArrayIndexOutOfBounds exception is a commonly seen runtime exception.
 * @author Tonisha
 *
 */
public class ArrayIndexOutOfBounds {

	/**
	 * Causes an exception by using the array length as an array index.
	 */
	public static void tooHigh() throws ArrayIndexOutOfBoundsException{
		try{
			char[] alphabet = new char[26];
			alphabet[alphabet.length] = '0';
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("\nYOU TRIED TO use the array length as an index.");
		}
	}
	/**
	 * Causes an exception by using a negative array index.
	 */
	public static void tooLow(){
		try{
			char[] alphabet = new char[26];
			alphabet[-1] = '0';
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("\nYOU TRIED TO use a negative index.");
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		tooHigh();
		tooLow();

	}

}
