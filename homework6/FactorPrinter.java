package homework6;

import javax.swing.JOptionPane;
/**
 *
 * @author JDavis
 */
public class FactorPrinter {

    private FactorGenerator factors;
    public int number;
    
    public FactorPrinter(){
    
        int num = getNumber();
        factors = new FactorGenerator(num);
        printNumber();
    }
    
    private int getNumber(){
        
        int num = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Input the number to get factors for."));
        return num;
    }
    
    private void printNumber(){
        String ret = "";
        while(factors.hasMoreFactors()){
            ret += String.format(" %d \n",factors.nextFactor());
        }
        JOptionPane.showMessageDialog(null, ret);
    }
    
    public static void main(String[] args){
    
        FactorPrinter factors = new FactorPrinter();
        
    }

    
}
