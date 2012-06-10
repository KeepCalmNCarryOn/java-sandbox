/*
 * 
 */
package exceptionhandling;

/**
 * This class demonstrates that the finally clause 
 * @author Tonisha Whyte
 */
public class FinallyAlwaysRuns {

    public static int finallyBeforeReturn(){
        try{
            return 0;
        }finally{
            System.out.println("Finally runs even when a return is in the try"
                    + " clause.");
        }
    }
    
    public static int returnInCatch(){
        int someNumber = 0;
        try{
            someNumber =  5/0;
        }catch(Exception e){
            return someNumber;
        }finally{
            System.out.println("Finally runs even when a return is in a catch "
                    + "clause that ran.");
        }
 
        return someNumber;
    }
    

    public static void main (String [] args){
        int someNumber = finallyBeforeReturn();
        someNumber = returnInCatch();
    }
}
