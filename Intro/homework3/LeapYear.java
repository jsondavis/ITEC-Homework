/*
 * Chapter 5. Problem 5.12 Page 214
 * A year with 366 days is called a leap year. 
 * A year is a leap year if it is divisible by 4 (for example, 1980). 
 * However, since the introduction of the Gregorian calendar on October 15,1582,
 * a year is not a leap year if it is divisible by 100 (for example, 1900); 
 * however it is a leap year if it is divisible by 400 (for example, 2000). 
 * Write a program that asks the user for a year 
 * and computes whether that year is a leap year. 
 * 
 */
package homework3;

import javax.swing.JOptionPane;
/**
 *
 * @author JDavis
 */
public class LeapYear {
    
    private int year;
    private boolean isLeap;
    
    public LeapYear(){
        
        this.getYear();
        this.testYear();
        this.showTest();
    }
    
    private void testYear(){
    
        this.isLeap = ((this.year%400 == 0 || this.year%4 == 0) && (this.year%100 != 0))? true : false ;
    }
    
    public boolean isLeapYear(){
        
        return this.isLeap;
    }
    
    private void getYear(){
        
        String str = this.makePane();
        int num = Integer.parseInt(str);
        this.year = num;
    }
    
    private String makePane(){
        String str = JOptionPane.showInputDialog("Enter a year to check: (YYYY)");
        return str;
    }
    
    private void showTest(){
    
       /* if(isLeap){
            JOptionPane.showMessageDialog(null, "The year " + this.year 
                    + " is a Leap Year. \nA whole extra day this year!");
        }else{
            JOptionPane.showMessageDialog(null, "The year " + this.year 
                    + " is not a Leap Year. \nOnly 365 days this year."); 
        } */
        JOptionPane.showMessageDialog(null, this);
    }
    
    @Override
    public String toString(){
    
        if(isLeap){
            return "The year " + this.year 
                    + " is a Leap Year. \nA whole extra day this year!";
        }else{
            return "The year " + this.year 
                    + " is not a Leap Year. \nOnly 365 days this year."; 
        }
    }
    
}
