/*
 *Chapter 4. Problem 4.15 Page 168
 * Write a program that reads two times in military format (0900, 1730)
 * and prints the number of hours and minutes between the two times. 
 * Here is a sample run. User input is in bold.
 *      Please enter the first time: 0900
 *      Please enter the second time: 1730
 * Extra credit if you can deal with the case 
 * where the first time is later than the second. 
 */
package homework4;

import javax.swing.JOptionPane;

/**
 *
 * @author JDavis
 * @github jason-s-davis
 * 
 */
public class MilitaryTime {
    /**
     * starttime and endtime are the times read from the input
     * after is a boolean used to determine whether the starttime is
     * actually after the endtime.
     */
    private String returntime;
    private int starthrs, startmins , endhrs, endmins ;
    private boolean after;
    private int count = 1;
    
    /* Main Method to create and use the MilitaryTime object */
    public static void main(String[] args){
    
        MilitaryTime timecheck = new MilitaryTime();
    
    }
        
    /* Class Constructor */
    public MilitaryTime(){
    
        this.getTime();
        this.calcTime();
        JOptionPane.showMessageDialog(null, this);
    }
    
    private String readTime(){
    
        String str = ""; // = JOptionPane.showInputDialog(String.format("Enter time # %d : ex 0000",count));
        while(str.length()<4 ||str.length()>4){
           str = JOptionPane.showInputDialog(String.format("Enter time # %d : ex 0000",count));
        }
        count++;
        return str;
    }
    
    private void getTime(){
    
        String time1 = this.readTime();
        String time2 = this.readTime();
        this.starthrs = Integer.parseInt(time1.substring(0,2));
        this.startmins = Integer.parseInt(time1.substring(2));
        this.endhrs = Integer.parseInt(time2.substring(0,2));
        this.endmins = Integer.parseInt(time2.substring(2));
        this.after = starthrs > endhrs;
    }
    
    private void calcTime(){
        

        int hrs = Math.abs(endhrs - starthrs);
        int mins = Math.abs(endmins - startmins);
        String ret ="";
        if(hrs == 0){
          ret += String.format("%d minutes", mins);
        }else{
          ret += String.format("%d hours and %d minutes",hrs,mins);
        }
        
        if(after){
        this.returntime = String.format("The first time you entered was after the second!\n"
                + "It will be %s from %d:%d to %d:%d", ret, endhrs, endmins, starthrs,startmins);
        }else{
        this.returntime = String.format("It is %s from %d:%d to %d:%d", ret,starthrs, startmins, endhrs, endmins);        
        }
    }
    
    @Override
    public String toString(){
        return this.returntime;
    }
}
