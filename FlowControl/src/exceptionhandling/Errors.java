package exceptionhandling;

public class Errors {

	/**
	 * You can throw an error without declaring it because
	 * it's not a checked exception.
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			throw new Error();
		}
		catch(Error myError){
			throw myError;
		}
	}

}
