package loops;

public class ForLoops {
		
	public static void main(String []args){
		int i, j;
		String [] buttons = {"blue", "green", "gold", "silver"};
		int [] numbers = {1, 2, 3, 4};
		
		// you can have multiple initializers and increments 
		for (i = 1, j = 2; i < 3; i++, j++) {
			System.out.println ("Gross" + j);
			
		};  // a semicolon can go after the curly braces of a for loop
		
		for (int x = 3, y = 0; ((((x < 10) && (y-- > 2)) | x == 3)); x++) {
			System.out.println ("This complicated expression is legal.");
		}
		
		// Extra parentheses are okay around the condition only
		for (int x = 3; (((((((x < 4))))))); ++x){
			System.out.println("It's ok to have extra parenthesis");
		}
		
		// for-each loop uses colon as separator
		for (String button: buttons){
			System.out.println (button);
		}
		
		// for-each statement has only two pieces (before the loop body)
		for (int y: numbers){
			System.out.println("y: " + y);
		}
	}	
	
}
