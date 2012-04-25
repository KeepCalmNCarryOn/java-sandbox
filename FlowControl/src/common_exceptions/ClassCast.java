package common_exceptions;
/**
 * Examples of ClassCastExceptions which are commonly seen run time exceptions.
 * @author Tonisha
 *
 */
public class ClassCast {
	static class Cat{
		protected void meow(){
			System.out.println("Meow!!");
		}
	}
	static class Lion extends Cat{}
	static class Salmon{}
		
	/**
	 * Makes a cast between objects that are not part of the same 
	 * class hierarchy.
	 */
	public static void differentHierarchy(){
		Cat snuggles;
		Salmon alaskan = new Salmon();
		Object dinner = alaskan;
		
		try{
		snuggles = (Cat)dinner;
		snuggles.meow();
		}catch(ClassCastException e){
			e.printStackTrace();
		}
		// compiler will catch this
		// snuggles = alaskan;
	}
	
	/**
	 * Makes a cast to an object that fails the IS-A test.
	 */
	public static void failsIsA(){
		Cat abyssinian = new Cat();
		try{
		Lion simba = (Lion)abyssinian;
		simba.meow();
		}catch(ClassCastException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Drives method that throw ClassCastException.
	 * @param args
	 */
	public static void main(String[] args) {
		differentHierarchy();
		System.out.println();
		failsIsA();
	}
}
