package myersbriggs;

/**
 *
 * @author JDavis
 * 
 * Dimension is used to store the Dimension being worked on by
 * the HandleResults class and return a count of the A characters in that 
 * group of answers. 
 */
public class Dimension {
    
    private char[] answers;
    private int acount ;
    
    public Dimension(char[] ans){
        answers = ans;
        CountA();
    }
    
    private void CountA(){
        for(int i = 0; i < answers.length; i++){
            acount +=(answers[i] == 'A')? 1 : 0;
        }    
    }
    
    public int getA(){
        return acount;
    }
    
}
