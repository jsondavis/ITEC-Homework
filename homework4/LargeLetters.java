/*
 * A large letter H can be produced like this:
     *     *
     *     *
      *****
     *     *
     *     *
  *Use the class
  * 
      public class LetterH
      {
                  public String stoString()
                  {
                              return “*     *\n*     *\n******\n*     *\n*     *\n”;
                  }
      }
 */
package homework4;

import homework4.letters.*;
/**
 *
 * @author JDavis
 * @github jason-s-davis
 * 
 */
public class LargeLetters {
    private String space = "  ";
    private String nl = "\n";
    private String msg = "";

        
    public static void main(String[] args){
    
        LargeLetters message = new LargeLetters();
        System.out.println(message);
        
    }

    public LargeLetters(){
    
        this.makemsg();

    }
    
    private void makemsg(){
    
        for(int i = 0; i<5; i++){
        this.msg += LetterH.toString(i) + space + LetterE.toString(i) + space 
                + LetterL.toString(i) + space + LetterL.toString(i) + space + LetterO.toString(i);
        this.msg += nl;
        }
    }
    
    
    @Override
    public String toString(){
        return this.msg;
    }
}
