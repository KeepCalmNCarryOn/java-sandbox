package exceptionhandling;

import java.util.HashSet;
import java.util.Set;

public class MyException {
	Set<String> grossFoods;
	
	public MyException () {
		grossFoods = new HashSet<String>();
		grossFoods.add("okra");
		grossFoods.add("parsley");
		grossFoods.add("licorice"); 
    }
	private class BadFoodException extends Exception{
		/**
		 * WHY do I need this?  I just put it here to get rid of a warning.
		 */
		private static final long serialVersionUID = 1L;

		BadFoodException() {
		}

	}
	
	public void checkFood(String food) throws BadFoodException{
		if (grossFoods.contains(food)){
			throw new BadFoodException();			
		}
		else {
			System.out.println("I like this food!");
		}	
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MyException me = new MyException();
		
		try{
			for(String i: args){
				me.checkFood(i);
			}			
		}catch(BadFoodException e){
			e.printStackTrace();
		}

	}

}
