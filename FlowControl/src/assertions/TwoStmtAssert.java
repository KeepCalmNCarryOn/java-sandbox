package assertions;
/**
 * NOTE:  Assertions are turned off by default.  
 * Use commands -ea, -da, -dsa to enable /disable assertions.
 */
public class TwoStmtAssert {

	public static void main(String args[]){
		boolean sunny = true;
		boolean interesting = false;
		
		assert(!sunny): "San Diego is sunny: " + sunny;
		assert(!interesting): "San Diego is interesting: " + interesting;
	}
}