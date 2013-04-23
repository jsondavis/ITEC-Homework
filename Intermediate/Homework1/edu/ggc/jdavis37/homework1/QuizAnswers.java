/**package: edu.ggc.jdavis37.homework1
 * The edu.ggc.jdavis37.homework1 package contains all of the classes for the first homework assignment.
 */
package edu.ggc.jdavis37.homework1;

/**Class: QuizAnswers
 * @author Jason Davis - jdavis37@ggc.edu
 * @version 1.0
 * Course: ITEC 2150 Spring 2013
 * Assignment: Homework 1
 * Written: January 28, 2013
 * 
 * The QuizAnswers class is primarily a data construct for storing 
 * and returning strings
 * 
 * The purpose of the QuizAnswers class is to return the questions
 * and answers from the first quiz.
 *  
 */
public class QuizAnswers 
{
	/**
	 * @problems is a multidimensional array containing the 
	 * questions and answers to each question of the first quiz
	 */
	private String[][] problems = {
						{"1) What is an algorithm?", "Answer:\nAn algorithm is a set of directions to solve a problem."},
						{"2) When a Java program is compiled,what is the output?\n" + 
						 "How do you compile and execute a Java program from the command line?", "Answer:\nJava byte-code is output when a java program" +
						 " is compiled which is placed in class files.\n" +
						 "Calling \"java\" followed by the name of the program executes a java program from the command line."},
						{"3) What is a class?", "Answer:\nA class is a blueprint for an object. The class defines the properties and methods an object will have."},
						{"4) What is encapsulation?  Why is it used?", "Answer:\nEncapsulation is a means of limiting access to methods" + 
						 " or properties of an object using private or protected attributes.\nEncapsulation is used to help ensure that" +
						 " the objects or methods manipulating the objects data are only the objects you intend."},
						{"5) What is a constant?  How is one created?", "Answer:\nA constant is a property that is the same across all " +
						 "instances of a class. A constant is declared with the final keyword and is typically written in all caps."},
						{"6) What is a static method?  How is one created?", "Answer:\nA static method is a method that belongs to the " +
						 "class of an object and not to each instance of an object.  To create a static method the word static is used" +
						 " in the method declaration."},
						{"7) Name two decision constructs?  Give an example of each.", "Answer:\n1 If\nif(boolean)\n{\n// code to be run here\n}\n" +
						 "2 case or switch case\nswitch(test_variable)\n{\ncase 1: other variable assignment here;\nbreak;\netc...\ndefault: other variable assignment here;\nbreak;\n"},
						{"8) What are three looping constructs?  State whether they are pre or post test constructs.", 
						 "Answer:\n1 while\t- Pre test  the loop code is run after the test is performed.\n" +
						 "2 for\t- Pre test  the loop code is run after the test is performed.\n3 do-while\t- Post test the loop code is run before the test is performed."},
						{"9) What is an array?", "Answer:\nAn array is a group of primitives or objects which must have a predeclared size and type."},
						{"10) What is an array list?  What are the advantages and disadvantages of using an array list?", 
					     "Answer:\nAn array list is a group of objects which scales to fit the number of entries.\nThe automatic scaling " +
						 "is an advantage which incurs more overhead and also accessing the data in an array list is more complex than in an array."},
								};

	/**method: getProblems
	 * returns a string containing the question and answer associated
	 * with the index
	 * @param index is the problem number from quiz 1 to return
	 * @return the problems
	 */
	public String getProblems(int index) {
		return problems[index - 1][0] + "\n" + problems[index - 1][1];
	}

}
