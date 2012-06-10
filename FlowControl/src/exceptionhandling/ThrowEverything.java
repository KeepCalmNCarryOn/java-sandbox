/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptionhandling;

/**
 * Demonstrate that anything that implements Throwable can be thrown (not just
 * Exceptions) using the throw keyword.
 * 
 * @author Tonisha Whyte
 */
public class ThrowEverything {
    public class MyThrowable extends Throwable{
        public MyThrowable(){
            super("This is the throwable I made up!");
        }
    }
    public static void throwAnException(){
        try{
            throw new IllegalArgumentException();
        }catch(IllegalArgumentException iae){
            System.out.println("All Exceptions can be thrown");
            System.out.println("\n\n");
        }
    }
    public static void throwAnError(){
        try{
            throw new AssertionError();
        }catch (AssertionError ae){
            System.out.println("All Errors can be thrown");
            System.out.println("\n\n");
        }
    }
    public static void throwARuntimeException(){
        try{
            throw new NumberFormatException();
        }catch (NumberFormatException nfe){
            System.out.println("All RuntimeExceptions can be thrown");
            System.out.println("\n\n");
        }
    }
    public static void throwAThrowable(){
        try{
           MyThrowable mt = new ThrowEverything().new MyThrowable();
           throw mt;
        }catch(MyThrowable t){
            System.out.println("Any subclass of Throwable can be thrown using"
                    + " the throws keyword");
            System.out.println(t.getMessage());
            System.out.println("\n\n");
        }
    }
    public static void main (String [] args){
      throwAThrowable();
      throwARuntimeException();
      throwAnError();
      throwAnException();
    }
}
