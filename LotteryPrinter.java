package homework2;
import java.util.Random;

/**
 *
 * @author JDavis
 * Chapter 2. Problem 2.11. Page 76 
 * Write a program LotteryPrinter that picks a combination in a lottery. 
 * In this lottery, players can choose 6 numbers (possibly repeated) 
 * between 1 and 49. Your program should print out a sentence such as 
 * “Play this combination – it’ll make you rich!”, 
 * followed by a lottery combination. 
 */
public class LotteryPrinter {
   public String lottonumbers;
    
    public LotteryPrinter(){
        String ret;
        ret = "The following number combo will* make you rich \n"; 
        ret += String.format("%d , %d , %d , ", pickNumber(),pickNumber(),pickNumber());
        ret += String.format("%d , %d , %d \n", pickNumber(),pickNumber(),pickNumber());
        ret += "*Results not gauranteed";
        this.lottonumbers = ret;
    }
    
    
    public static int pickNumber(){
        Random lottonum;
        lottonum = new Random();
        int num = lottonum.nextInt(48) + 1;
    return num;
    }
}
