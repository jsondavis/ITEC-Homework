/*
*Chapter 4. Problem 4.15 Page 168
* Write a program that reads two times in military format (0900, 1730)
* and prints the number of hours and minutes between the two times.
* Here is a sample run. User input is in bold.
* Please enter the first time: 0900
* Please enter the second time: 1730
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
* start... and end... are the times read from the input
* after is a boolean used to determine whether the starttime is
* actually after the endtime.
* count is used for display purposes.
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

    /**
     * @return a string read from user input which is greater than 3 and less than 5
     * this still fails if text is entered
     */
    private String readTime(){

        String str = ""; 
        while(str.length()<4 ||str.length()>4){
           str = JOptionPane.showInputDialog(String.format("Enter military time # %d : ex 0545",count));
        }
        count++;
        return str;
    }

    /**
     * uses the readtime method to get and parse the strings and assign them
     * to the objects time variables also determines if which time is earlier
     */

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

        // find the difference in the 2 times
        int end = endhrs* 60 + endmins;
        int start = starthrs* 60 + startmins;
        int mins = Math.abs(end - start)%60 ;
        int hrs =  Math.abs(end - start)/60;

        // format everything for presentation
        // should most definetly be a different method
        String displaymins = (mins<10)? "0"+ mins : "" + mins ;
        String ret ="";
        if(hrs == 0){
          ret += String.format("%s minutes", displaymins);
        }else{
          ret += String.format("%d hours and %s minutes",hrs,displaymins);
        }
        String stmins = (startmins < 10)? "0"+startmins: ""+startmins ;
        String enmins = (endmins < 10)? "0"+endmins: ""+endmins ;
        if(after){
        this.returntime = String.format("The first time you entered was after the second!\n"
                + "It will be %s from %d%s to %d%s", ret, endhrs, enmins, starthrs,stmins);
        }else{
        this.returntime = String.format("It is %s from %d%s to %d%s", ret,starthrs, stmins, endhrs, enmins);
        }
    }

    @Override
    public String toString(){
        return this.returntime;
    }
}