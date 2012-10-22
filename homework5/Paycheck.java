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

/**
 *
 * @author JDavis
 * 
 * 
 */
public abstract class Paycheck {
    private int hours;
    private double payrate;
    protected double check;
    
    /*
     * @param pay - pay rate in dollars
     * @param hours - hours worked
     */
    
    public Paycheck(double pay , int hours){
 
      this.payrate = pay;
      this.hours = hours;
      this.figurePay();
    }
   
    /*
     * figurePay determines the amount to be paid for each hour of work
     * depending on whether or not that hour is an overtime hour or not
     * and sets check to the final value
     */
    
    private void figurePay(){
      
        double figurepay = 0;
        for(int i = 1; i <= this.hours; i++){
           if(i <= 40){
               figurepay += payrate;
           }else if(i > 40){
               figurepay += payrate * 1.5;
           }
        }        
        this.check = figurepay;
    }
}
