package myersbriggs;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author JDavis
 *
 */
public class HandleResults {

    private Scanner results;
    private String[] answers = { "" , "" , "" , ""};
    private String[][] ansreturn = new String[4][2];
    private String answerstring , returnstring, type = "";

    public HandleResults(String answers){

        answerstring = answers.toUpperCase();
        setAnswers(answerstring);
        makeDimensions();

    }

    /* SetAnswers reads the incoming answer string as a parameter
     * and places all of the answers into their appropriate group.
     * @param str is the string of 70 answers either A or B
     * presented in 10 groups of 7
     * the answers count towards 4 different dimensions
     * and are grouped in the following order 1223344
     */
    private void setAnswers(String str) {

        //groups holds the 10 groups of 7 characters
        //before they are divided into the dimensions
        String[] groups = new String[10];

        Pattern pattern = Pattern.compile("([A|B]){7}");
        
        Matcher m = pattern.matcher(str);
        
        int index = 0;
        while(m.find()){
            groups[index] = m.group(0);
            index++;
        }

        //this for each loop places the part of each group
        //into it's corresponding dimension index 0 => dimension 1 
        //and so on

        for (String answergroup : groups) {
            answers[0] += answergroup.substring(0, 1);
            answers[1] += answergroup.substring(1, 3);
            answers[2] += answergroup.substring(3, 5);
            answers[3] += answergroup.substring(5, 7);
        }


    }

    /* makeDimensions uses the answer groups formed by setAnswers to
     * create a Dimension object for each answer group. The Dimension object is
     * then immediately used to begin forming what will be the Strings used in
     * the display output.  
     */
    private void makeDimensions() {
        
        for (int i = 0; i < answers.length; i++) {
            Dimension dim = new Dimension(answers[i].toCharArray());
            ansreturn[i][0] = String.format("%dA-%dB", dim.getA(), answers[i].length() - dim.getA());
            double percent = (double) (1 -((dim.getA() + 0.00)/ answers[i].length())) * 100;
            findType(i, percent);
            ansreturn[i][1] = String.format("%.0f", percent)+ "%";
            ansreturn[i][1] += (i<=2)? ",    ": "" ;
        }
    }

    /* findType adds the corresponding Dimension letter to the type field
     * @group     the group number being added , also the index for the types array
     * @percent   the percent of A characters in the group , if less than 50% are A that dimension is 
     */
    private void findType(int group, double percent) {
        String[][] types = {{"I", "E"}, {"S", "N"}, {"T", "F"}, {"J", "P"}};
        type += (percent < 50) ? types[group][0] : types[group][1];
    }

    private void makeReturnString() {
        String line1 = "", line2 = " [";
        for (String[] lines : ansreturn) {
            line1 += " " + lines[0] + " ";
            line2 += lines[1];
        }
        line1 += "\n";
        line2 += "] = ";
        returnstring = line1 + line2 + type;
    }

    @Override
    public String toString() {
        makeReturnString();
        return returnstring;
    }

}
