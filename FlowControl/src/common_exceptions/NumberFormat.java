package common_exceptions;

/**
 * Examples of a commonly seen exception -NumberFormatException.
 * The NumberFormatException occurs when a method that converts a String to a
 * number encounters a String that can not be converted to a number.
 * @author Tonisha Whyte
 *
 */
public class NumberFormat {

	/**
	 * Calls methods that throw NumberFormatExceptions.
	 * @param args
	 */
	public static void main(String[] args) {
		cannotParse();
		noNumValueOf();
		badWrap();
	}
	
	/**
	 * Passes a string that cannot be converted to a number to a 
	 * parseXxx(String) wrapper conversion method.
	 */
	public static void cannotParse(){
		try{
			float num = Float.parseFloat("pi");
		}catch(NumberFormatException e){
			e.printStackTrace();
		}
	}
	/**
	 * Passes a string that cannot be converted to a number to a 
	 * wrapper class constructor.
	 */
	public static void badWrap(){
		try{
			Double dbl = new Double("10.9^9");
			System.out.println("Double is: " + dbl);
		}catch (NumberFormatException e){
			e.printStackTrace();
		}
	}
	/**
	 * Passes a string that cannot be converted to a number to a 
	 * valueOf(String) wrapper conversion method.
	 */
	public static void noNumValueOf(){
		try{
			Short.valueOf("forty two");
		}catch (NumberFormatException e){
			e.printStackTrace();
		}
	}
}

	