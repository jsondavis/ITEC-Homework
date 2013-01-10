package homework6;

import javax.swing.JOptionPane;

/**
 *
 * @author JDavis
 */
public class RootApproximator implements Approximator {
    
    private final int INITIALGUESS = 1;
    private int cycles = 0;
    public int root , EPSILON , newguess = 1;
    private boolean moreguesses = true;
    
    public RootApproximator(int a, int epsilon){
    
        this.root = a;
        this.EPSILON = epsilon;
    }
    
    @Override
    public boolean hasMoreGuesses(){
        if( cycles > 0 && (int) this.newguess - ((root/(this.newguess + 0.0)) + this.newguess) / 2.0 <= this.EPSILON){
            this.moreguesses = false;
        }
        return this.moreguesses; 
    }
    
    @Override
    public int nextGuess(){
        this.cycles++;
        this.newguess  = (this.cycles == 0)?  (int) ((root/(this.INITIALGUESS + 0.0)) + this.INITIALGUESS)/ 2 
                                            : (int) ((root/(this.newguess + 0.0)) + this.newguess)/ 2 ;
        return this.newguess;
    }
    
    public static void main(String[] args){
   
        int root = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Input the Number to find the root of: "));
        int epsilon = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Input the Epsilon value to use when finding the root value: "));
        RootApproximator approx = new RootApproximator(root , epsilon);
        String returnstring = "";
        int guess = 1;
        while(approx.hasMoreGuesses()){
            //System.out.println(approx.nextGuess());
            returnstring += String.format("Guess %d is -   %d\n", guess, approx.nextGuess());
            guess++;
        }
        JOptionPane.showMessageDialog(null, returnstring);
    }
}