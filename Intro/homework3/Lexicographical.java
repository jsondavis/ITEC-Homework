/*
 * Chapter 5. Problem 4.6 Page 212 
 * Write a program that reads in three strings and prints them in lexicographically sorted order:
 * Please enter three strings:
 * Tom
 * Dick
 * Harry
 * The inputs in sorted order are:
 * Dick
 * Harry
 * Tom
 * 
 */
package homework3;

import javax.swing.JOptionPane;

/**
 *
 * @author JDavis
 */
public class Lexicographical {
    
    private String str1 , str2 , str3;
    private String[] inOrder;
    private String[] defaults;
   

    
    public Lexicographical(){
        
        this.defaults = new String[3];
        defaults[0] = "Tom";
        defaults[1] = "Dick";
        defaults[2] = "Harry";
        this.getStrings();
        this.inOrder = new String[3];
    }
    
    private String pickFirst(String str1, String str2){
        
       String first = (str1.compareTo(str2) >=0)? str2 : str1;
       return first;
    }
    
    public void sortStrings(){
        
        this.inOrder[0] = this.pickFirst(str3, this.pickFirst(this.str1, this.str2));
        if(this.inOrder[0].equals(this.str1)){
            this.inOrder[1] = this.pickFirst(this.str2, this.str3);
            this.inOrder[2] = (this.str2.equals(this.inOrder[1]))? this.str3 : this.str2;
        }else if(this.inOrder[0].equals(this.str2)){
            this.inOrder[1] = this.pickFirst(this.str1, this.str3);
            this.inOrder[2] = (this.str1.equals(this.inOrder[1]))? this.str3 : this.str1;
        }else{
            this.inOrder[1] = this.pickFirst(this.str1, this.str2);
            this.inOrder[2] = (this.str1.equals(this.inOrder[1]))? this.str2 : this.str1;
        }
    }
  
    private String makePane(int strcount){
        
        String str = JOptionPane.showInputDialog("Enter a Name number "+ strcount 
                + " to sort \nOr leave blank for " + defaults[strcount]);
        str = (str.equals(""))? defaults[strcount] : str;
        return str;
    }
    private void getStrings(){
        
        this.str1 = this.makePane(0);
        this.str2 = this.makePane(1);
        this.str3 = this.makePane(2);
    }
    
    @Override
    public String toString(){
        String str;
        str = String.format("The strings after sorting are: \n%s \n%s \n%s \n", this.inOrder[0] , this.inOrder[1], this.inOrder[2] );
        return str;
    }
 
    public void print(Object obj){
        
        JOptionPane.showMessageDialog(null, obj);
    }
}
