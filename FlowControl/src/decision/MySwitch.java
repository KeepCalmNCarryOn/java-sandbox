package decision;

/**
 * Valid switch statements.  Switch statements can switch on anything that
 * can be implicitly cast to an int. 
 * @author Tonisha
 *
 */
public class MySwitch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		char myChar = 't'; 
		final byte myByte = 0;
		final short myShort = 1;
		final int myInt = 2;
		
		switch (myChar){
		case 't': 
		case 'o':
		case 'n':
		case 'i':
		case 's':
		case 'h':
		case 'a':  
			System.out.println ("Part of my name");
			break;
		default:
			System.out.println ("Not part of my name");	
		}
		
		switch(myByte){
		default: 
			System.out.println("Switch on byte");
		}
		
		switch(myShort){
		default: 
			System.out.println("Switch on short");
		}		
		
		switch(myInt){
		default: 
			System.out.println("Switch on int");
		}	
	}

}
