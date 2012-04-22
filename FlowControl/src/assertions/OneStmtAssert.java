package assertions;

public class OneStmtAssert {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		boolean isolated = true;
		int friends = 0;
		
		assert(isolated); 
		assert(friends > 0);  // error thrown because of false statement
	}

}
