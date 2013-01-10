/* 3.	Paycheck (30%)
 * Chapter 5. Problem 5.16 Page 214
 * Write a program that reads in the hourly wage of an employee. 
 * Then ask how many hours the employee worked in the past week. 
 * Be sure to accept fractional hours. Compute the pay. 
 * Any overtime work (over 40 hours per week) is paid at 150 
 * percent of the regular wage. Solve this problem by implementing 
 * a class Paycheck.
 * 
 */
package homework5;


import java.util.Scanner;



/**
 *
 * @author JDavis
 * 
 * Wages extends the abstract class Paycheck.
 * 
 */
public class Wages extends Paycheck{
    
   /*
    * the constructor of the Super class
    * performs the pay calculation
    */
    
    public Wages(double pay , int hours){
        super(pay,hours);
    }
    
    /*
     * Override the default toString method to return
     * the finished calculation.
     */
    
    @Override
    public String toString(){
        return String.format("Your paycheck will be $ %(,.2f dollars.", this.check);
    }
    
    public static void main(String[] args){
        
        try (Scanner in = new Scanner(System.in)) {
            
            System.out.println("Please enter hourly pay:");
            String paystr = in.next();
            double pay = Double.parseDouble(paystr);
            System.out.println("Please enter hours worked:");
            String hrsstr = in.next();
            int hours = Integer.parseInt(hrsstr);
            
            Wages check = new Wages(pay, hours);
            System.out.println(check);
        }
        
        
    }
}
