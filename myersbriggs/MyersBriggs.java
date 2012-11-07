package myersbriggs;

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

        MyersBriggs example = new MyersBriggs("Snoopy" , "AABAABBABBAABBABBAABBABBAABBABBAABBBAABBAABAABBAABAABBAABAABBAAAAABBAA");
        System.out.println(example.getResult());
    }
}
