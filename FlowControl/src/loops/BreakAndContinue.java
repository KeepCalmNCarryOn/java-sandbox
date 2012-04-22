package loops;

import java.util.Random;

public class BreakAndContinue {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		int age = r.nextInt(22);
		
		System.out.println("Current age: " + age);

		outer:
        do{
        	
        	while (12 < age && age < 20){
        		System.out.print("I'm a teen! ");
        		if(age == 19){
        			System.out.print("\n");
        		}
        		// labeled continue starts execution at the matched label
        		continue outer;
        	}
        	System.out.println("Another year.");
        }while (age++ <= 21);
        	
	}

}
