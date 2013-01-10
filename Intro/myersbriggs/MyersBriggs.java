package myersbriggs;

import javax.swing.JOptionPane;

/**
 *
 * @author JDavis
 */
public class MyersBriggs {
    
    public String name , results;

    public MyersBriggs (String name, String answerstring)throws Exception{
        this.name = name;
        HandleResults MB = new HandleResults(answerstring);
        results = MB.toString();
    }
    
    public String getResult(){
        return name + "\n" + results;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {

        String name = JOptionPane.showInputDialog(null, "Whose answers are being calculated? : ");
        
        String answerString = JOptionPane.showInputDialog(null, "Please input the answer String: \n (should be 70 A's or B's)");
        
        while(!answerString.matches("[A-B]{70}")){
            answerString = JOptionPane.showInputDialog(null, "Please input the answer String: \n (should be 70 A's or B's)");
        }
        // test string
        //  "AABAABBABBAABBABBAABBABBAABBABBAABBBAABBAABAABBAABAABBAABAABBAAAAABBAA"
        
        MyersBriggs example = new MyersBriggs(name , answerString);
        JOptionPane.showMessageDialog(null,example.getResult());
    }
}
