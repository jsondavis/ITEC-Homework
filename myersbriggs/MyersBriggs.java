package myersbriggs;

/**
 *
 * @author JDavis
 */
public class MyersBriggs {
    
    // @name     the name of the subject the results are for
    // @results  the 70 character result string
    public String name , results;

    public MyersBriggs (String name, String answerstring)throws Exception{
        this.name = name;
        HandleResults MB = new HandleResults(answerstring);
        results = MB.toString();
    }

    /*@return    the result string from HandleResults combined with the name */
    public String getResult(){
        return name + "\n" + results;
    }

    /**
     * @param args the command line arguments
     *  
     *  currently the code in the main method is in place for testing purposes
     */
    public static void main(String[] args)throws Exception {

        MyersBriggs example = new MyersBriggs("Snoopy" , "AABAABBABBAABBABBAABBABBAABBABBAABBBAABBAABAABBAABAABBAABAABBAAAAABBAA");
        System.out.println(example.getResult());
    }
}
