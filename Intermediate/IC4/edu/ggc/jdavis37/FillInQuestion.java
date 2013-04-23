package edu.ggc.jdavis37;

/**Class : FillInQuestion
 * @author Jason Davis - jdavis37
 * @version 1.0
 * Course : ITEC 2150 Spring 2013
 * Written February, 11 2013
 * 
 * This class extends Question specifically adding methods
 * to retrieve the question and answer strings from a combined
 * string containing both.
 * 
 * Purpose: This Class assumes that the supplied parameter
 * questionText will be a string containing the question
 * with the answer held within bound by '_' characters.
 * Working from that assumption the static methods separate
 * the two and pass them to the super class(Question).
 */

public class FillInQuestion extends Question
{
	/**method : FillInQuestion Constructor
	 * This constructor uses the static getQuestion and getAnswer
	 * methods of FillInQuestion to separate the combined answer
	 * and question strings and assign them using the methods of the
	 * super class Question. 
	 * 
	 * @param questionText
	 */
	public FillInQuestion(String questionText)
	{
		super(getQuestion(questionText));
		super.setAnswer(getAnswer(questionText));
	}

	/**method : getQuestion
	 * This method takes the question string with the answer string
	 * within (bound by '_') and returns the question with the answer 
	 * replaced by '_'.
	 * 
	 * @param question
	 * @return the question String with the answer replaced by '_'
	 */
	public static String getQuestion(String question)
	{
		int startUnder , endUnder;
		startUnder = question.indexOf('_');
		endUnder = question.indexOf('_', startUnder + 1);
		String newQuestion = question.substring(0,startUnder);
		for(int i = 0; i < (endUnder - startUnder + 1); i++)
		{
			newQuestion += "_";
		}
		newQuestion += question.substring(endUnder);
		return newQuestion;
	}
	
	/**method : getAnswer
	 * This method removes and returns the answer from the 
	 * question string. Assuming the answer is bound front 
	 * and back by '_'.
	 * 
	 * @param question
	 * @return the answer removed from the question.
	 */
	public static String getAnswer(String question)
	{
		int startUnder = question.indexOf('_');
		int endUnder = question.indexOf('_', startUnder + 1);
		return question.substring(startUnder+1,endUnder);
	}
	
}