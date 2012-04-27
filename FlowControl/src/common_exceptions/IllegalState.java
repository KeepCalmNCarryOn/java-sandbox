package common_exceptions;

import java.util.Scanner;

/**
 * Examples of IllegalStateException.  
 * 
 * These exceptions are thrown when the state of the environment doesn't match 
 * the operation being attempted.  
 * @author Tonisha
 *
 */
public class IllegalState {

	/**
	 * Calls methods that throw IllegalStateExceptions.
	 * @param args
	 */
	public static void main(String[] args) {
			writeToClosedStream();
	}
	/**
	 * Attempt to parse a string using a closed Scanner.
	 */
	public static void writeToClosedStream(){
		try{
			Scanner in = new Scanner(System.in);
			System.out.println("Enter something: ");
			if (in.hasNextLine()){
				String myStr = in.nextLine();
				if(myStr.contains("something")){
					System.out.println("You entered something!");
				}
				else{
					System.out.println("You didn't enter \"something\". Haha...");
				}
			}
			in.close();
			in.nextLine();
		}catch (IllegalStateException e){
			e.printStackTrace();
		}
	}

}
