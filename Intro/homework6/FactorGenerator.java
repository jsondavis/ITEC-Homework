/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package homework6;

import java.util.ArrayList;

/**
 *
 * @author JDavis
 */
public class FactorGenerator {
    
    public int number;
    public int index = 0;
    public ArrayList factorlist = new ArrayList();
    public String[] factors;
    
    public FactorGenerator(int numberToFactor){
        this.number = numberToFactor;
        this.getFactors();
    }
    
    private void getFactors(){
        for(int i = 1; i <= this.number; i++){
            if(this.number % i == 0){
              this.factorlist.add(i);
            }
        }
        this.factors = this.factorlist.toString().replace("[","").replace("]","").split(",");
    }
    
    public int nextFactor(){
        String ret = factors[index];
        this.index++;
        return Integer.parseInt(ret.trim());
    }
    
    public boolean hasMoreFactors(){
        return index <= factors.length - 1;
    }
   /*     
    public static void main(String[] args){
    
        FactorGenerator fac = new FactorGenerator(15);
        while(fac.hasMoreFactors()){
            System.out.println(fac.nextFactor());
        }
        
    
        ArrayList lists = new ArrayList();
        for(int i = 1; i <= 15; i++){
            if(15 % i == 0){
                lists.add(i);
            }
        }
        String lists1[] = lists.toString().replace("[","").replace("]","").split(",");
        for(String f : lists1){
            System.out.println(f);
        }
       
    }
 */   
}
