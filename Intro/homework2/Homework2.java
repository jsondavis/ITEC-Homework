/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework2;

/**
 *
 * @author JDavis
 */
public class Homework2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(prob2());
        System.out.println();
        System.out.println(prob3());
    }
    
    public static String prob2(){
    LotteryPrinter ret = new LotteryPrinter();
    return ret.lottonumbers;
    }
    
    public static String prob3(){
    ReplaceTester ret = new ReplaceTester();
    return ret.returnstring;
    }
    
}
