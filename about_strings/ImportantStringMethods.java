/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package about_strings;

/**
 *
 * @author Tonisha Whyte
 */
public class ImportantStringMethods {
    /**
     * Shows that equalsIgnoreCase() returns a boolean specifying whether two
     * strings are equal ignoring their case.
     * @param first a string to compare.
     * @param second a string to compare.
     */
    public static void tryEqualsIgnoreCase(String first, String second){
      System.out.println(first.equalsIgnoreCase(second));
      System.out.println("\n\n"); 
    }
    
    /**
     * Uses the replace() method of class String to replace characters in a 
     * String.  
     */
    public static void tryReplace(){
        String original = "entunxmx";
        System.out.println(original.replace('x', 'i'));
        System.out.println(original.replace("tunxmx", "nustella"));
        System.out.println("\n\n"); 
    }
    
    /**
     * Displays part of a string using substring(x) and substring(x,y).
     * 
     * @param myStr Original string that will have a part displayed.
     */
    public static void indexesUsedWithSubstring(String myStr){
        System.out.println("Given " + myStr + ":");
        System.out.println("substring(5) is " + myStr.substring(5));
        System.out.println("substring(3,7) is " + myStr.substring(3,7));
        System.out.println("\n\n");
        
    }
    
    /**
     * Shows important methods used on StringBuilders and StringBuffers.  
     * Remember Strings are immutable but StringBuffer and StringBuilder objects
     * will actually change when you use functions that alter them.
     * 
     * @param firstPart First part of string.
     * @param secondPart String to append to another string.
     */
    public static void changesWithStringBuffer(StringBuilder firstPart, 
            StringBuilder secondPart){
        System.out.println("Given two StringBuilders: <" + firstPart + "> <" + 
                secondPart + ">:");
        
        System.out.println("concat() for Strings -> append(): <" 
                + firstPart.append(secondPart));
        System.out.println("\n\n");
        
        StringBuilder indexedString = new StringBuilder("0123456789");
        System.out.println("Given StringBuilder " + ": " + indexedString);
        System.out.println("delete(6,9): " + indexedString.delete(6,9));
        System.out.println("\n\n");
        
        /* giving an ending index that goes past the end of the Stringbuilder
         * returns the rest of the StringBuilder
         * 
         */
        firstPart.delete(7,24);
        
        System.out.println("Given StringBuilder " + ": " + indexedString);
        System.out.println("insert(4,\"here\"): " + indexedString.insert(4,"here"));
        System.out.println("\n\n");
        
        System.out.println("Given StringBuilder " + ": " + indexedString);
        System.out.println("reverse(): " + indexedString.reverse());
        System.out.println("\n\n");

        boolean isAnInstance = false;
        Object o = indexedString;
        if (o instanceof String){
            isAnInstance = true;
        }
        System.out.println("Is indexedString and instance of string? " + 
                isAnInstance);
        o = indexedString.toString();
        if (o instanceof String){
            isAnInstance = true;
        }        
        System.out.println("Is indexedString.toString() an instance of string? "
                + isAnInstance);
        
        
    }
    
    public static void main (String[] args){
       tryEqualsIgnoreCase("palijon", "PaLiJoN"); 
       tryReplace();
       indexesUsedWithSubstring("0123456789");
       changesWithStringBuffer( new StringBuilder("Kuinka sanotaan ") , 
               new StringBuilder("kalat"));
    }
    
}
