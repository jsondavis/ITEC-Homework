/*
 * 2.	Tax (30%)
 * Chapter 5. Problem 5.8 Page 213
 * The original U.S. income tax of 1913 was quite simple.
 * The tax was
 *      1 percent on the first $50,000.
 *      2 percent on the amount over $50,000 up to $75,000.
 *      3 percent on the amount over $75,000 up to $100,000.
 *      4 percent on the amount over $100,000 up to $250,000.
 *      5 percent on the amount over $250,000 up to $500,000.
 *      6 percent on the amount over $500,000.
 * There was no separate schedule for single or married taxpayers. 
 * Write a program that computes the income tax according to this schedule. 
 */
package homework5;

import java.util.Scanner;

/**
 *
 * @author JDavis
 */
public class IncomeTax {
    
    /**
     * income is input by the user 
     * taxdue is the amount of taxes due on the input income
     * brackets[] represents the income amounts used to determine the tax percentage
     * taxamounts[] is the amount owed for each value in brackets
     * 
     */
    private double income , taxdue;
    private final double[] brackets = { 50000.0 , 75000.0 , 100000.0, 250000.0, 500000.0 , Double.MAX_VALUE };
    private final double[] taxamounts = { 500.0 ,   // this is 50000 * 1%
                                          500.0 ,   // (75000 - 50000) * 2%
                                          750.0 ,   // (100000 - 75000) * 3%
                                          6000.0 ,  // (250000 - 100000) * 4%
                                          12500.0 };// (500000 - 250000) * 5%

    /*
     * Constructor sets income and runs the figureTax method
     * @param income is the income input by the user
     */
    public IncomeTax(double income){
        this.income = income;
        this.figureTax();
    }
    
    /*
     * figureTax method takes the input income and 
     * determines the taxes due on that income by using the brackets
     * and taxamounts arrays.
     * the iterator i is used to determine the tax percentage (i + 1)/100 
     * is the percentage of taxes due on the income amount over each tax bracket
     */
    private void figureTax(){
    
        double taxes = 0.0;
        double amount = income;
        int i = 0;
        while(amount > 0){
            
            if(income >= brackets[i]){
                taxes += taxamounts[i];
                amount -=(i == 0)? brackets[i] : brackets[i] - brackets[i-1];
            }else if(income < brackets[i]){
                taxes += (amount * ((i + 1) / 100.0));
                amount = 0;
            }
            
            i++;
        }
        this.taxdue = taxes;
    }
    
    /*
     * this toString method formats the data for output
     */
    
    @Override
    public String toString(){
        return String.format("You owe $ %(,.2f in taxes \n"
                            + "on an income of $ %(,.2f", this.taxdue, this.income);
    }
    
    /*
     * @param args
     * the main method uses an instance of the Scanner object
     * to read input from the console
     * 
     */
    
    public static void main(String[] args){

        try (Scanner in = new Scanner(System.in)) {
            
            System.out.println("Please enter yearly income:");
            String paystr = in.next();
            double income = Double.parseDouble(paystr);
            
            IncomeTax taxes = new IncomeTax(income);
            System.out.println(taxes);
        }


        }
    }    

