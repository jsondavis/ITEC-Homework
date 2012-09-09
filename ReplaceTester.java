package homework2;

/**
 *
 * @author JDavis
 * Chapter 2. Problem 2.12 Page 76
 * Write a program ReplaceTester that encodes a string 
 * by replacing all letters “I” with “!” and all letters “s” with “$”. 
 * Use the replace method. Demonstrate that you can correctly encode the string “Mississippi”. 
 * Print both the actual and expected result.
 * 
 */
public class ReplaceTester {
    public String teststring = "Mississippi";
    public String returnstring;
    
   public ReplaceTester(){
    String ret;
    ret = teststring.replace('i','!');
    ret = ret.replace('s', '$');
    this.returnstring = "ReplaceTester takes " + this.teststring + " as input \n";
    this.returnstring += "and should return M!$$!$$!pp! \n";
    this.returnstring += ret + "  is the actual result.";
   } 
}
