package exceptionhandling;

import javax.management.BadStringOperationException;

public class Propagate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Propagate p = new Propagate();
		try{
			//TODO get string from input
			//System.out.println(p.reverse(args[0]));
			System.out.println(p.reverse(""));
		}
		catch(BadStringOperationException e){
			System.out.println("Re-run program with a new string. ");
			
		}
		finally{
			System.out.println("Program ended.");
		}

	}

	public String reverse (String str) throws BadStringOperationException{
		String reversed= "";
		if (str != null && str.length() == 0){
			throw new BadStringOperationException("Cannnot reverse an empty string!");	
		}
		for (int i = str.length(); i > 0; --i){
			reversed += str.charAt(i-1);
		}
		return reversed;
	}
}
