package exceptionhandling;

public class Catching {

    /**
     * When throwing a checked exception you must declare it.
     *
     * @throws ArithmeticException
     */
	public void throwSomething() throws ArithmeticException{
		throw new ArithmeticException();
	}
	
	/**
	 * You can re-throw an exception.
	 * 
	 * @throws ArithmeticException
	 */
	public void catchSomething() throws ArithmeticException{
		try {
			throwSomething();
		}catch(ArithmeticException e){
			throw e;
		}
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Catching c = new Catching();
	
		c.catchSomething();
	}
}
