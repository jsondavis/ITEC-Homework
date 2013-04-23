/**
 * 
 */
package edu.ggc.jdavis37.homework1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**Class: AccountList
 * @author Jason Davis - jdavis37@ggc.edu
 * @version 1.0
 * Course: ITEC 2150 Spring 2013
 * Assignment: Homework 1
 * Written: January 10, 2013
 * 
 * The AccountList class contains all of the methods for the creation 
 * of a Account List.
 * TODO finish comments
 * TODO use if -done
 * TODO use while 
 * TODO use for -done
 * TODO use do..while
 * TODO use sentinel constant -done?
 * TODO use each primitive ( boolean- , char- , int- , double- , float- , short- , byte- , long- )
 * TODO quiz 1 answers
 * 
 */
public class AccountList 
{
	/**
	 * @accounts = ArrayList containing all account objects created
	 * @rand = an instance of the Random class for use in the get(x) methods below
	 * TODO move this declaration to where it is used
	 */
	private ArrayList<Account> accounts = new ArrayList<Account>();
	private static Random rand = new Random();
	
	private Account holmes = new Account(AccountList.getAccountNumber(),"Sherlock Holmes", "Mr.", 2, 120);
	private Account watson = new Account(AccountList.getAccountNumber(),"George Watson", "Dr.", 65, 543);

	/**method: AccountList
	 * instantiates the AccountList class
	 * adds some default account values 
	 */
	public AccountList()
	{
		System.out.println("Starting the program.\n\n2 Examples of the Account class.\nStored in an ArrayList.\n");
		accounts.add(holmes);
		accounts.add(watson);
		int count = 0;
		while(count < accounts.size())
		{
			System.out.println("Account number - " + accounts.get(count).getAccountNumber());
			System.out.println("Account owner -  " + accounts.get(count).getAccountName());
			System.out.println("Account balance - " + accounts.get(count).getAccountAmount() + "\n\n");
			count++;
		}
		
		AccountList.demoMethod();
	}
	
	/**method getAccountNumber
	 * returns a long account number for use 
	 * in the creation of an Account object
	 * @return accountNumber as a long
	 */
	public static long getAccountNumber()
	{		
		long accountNumber = AccountList.rand.nextLong();
		return Math.abs(accountNumber);
	}
	
	/**method: getAShort
	 * returns a random short number
	 * @return a random number of type short
	 */
	
	public static short getAShort()
	{
		short someShort = (short) AccountList.rand.nextLong();
		return someShort;
	}
	
	/**method: flipCoin
	 * returns a random boolean like a coin flip
	 * @return a boolean value either true or false
	 */
	
	public static boolean getBoolean()
	{
		return AccountList.rand.nextBoolean();
	}
	
	/**method: getAnInt
	 * returns a random integer
	 * @return a random integer number
	 */
	
	public static int getAnInt()
	{
		int anInt = AccountList.rand.nextInt();
		return Math.abs(anInt);
	}
	
	/**method: chooseAMethod
	 * @param choice the integer entered by the user in the below demoMethod method
	 * prints the method associated with the entered integer
	 * @return returns the string associated with the selected method
	 */
	
	public static String chooseAMethod(int choice)
	{
		String returnstring;
		
		Account acct = new Account(AccountList.getAccountNumber(), "test", "the", 155, 34);
		QuizAnswers quiz = new QuizAnswers();
		
		
		switch (choice)
		{
			case 1: returnstring = "" + AccountList.getAnInt();
					break;
			case 2: returnstring = "" + AccountList.getAShort();
					break;
			case 3: returnstring = "" + AccountList.getAccountNumber();
					break;
			case 4: returnstring = "" + acct.getBytes();
					break;
			case 5: returnstring = "" + ((float) AccountList.getAShort() / (AccountList.getAShort() + 1.0));
					break;
			case 6: returnstring = "" + acct.getAccountAmount();
					break;
			case 7: returnstring = String.format("%c is a char value.", 'c');
					break;
			case 8: returnstring = String.format("%b is a boolean value.", AccountList.getBoolean());
					break;
			case 9: int quizChoice = 0;
					do{
						System.out.println("\n\nPlease choose a problem (#1-10) to view the question and answer associated:\nor anything else to return to the other choices.");
						quizChoice = keyboard.nextInt();
						if(quizChoice < 11 && quizChoice > 0)
						{
							System.out.println("\n" + quiz.getProblems(quizChoice));
						}
					}while(quizChoice > 0 && quizChoice < 11);
					returnstring = "\n";
					break;
			default : returnstring = "no method selected";
					break;
		}
		
		return returnstring;
	}
	
	/** 
	 * SENTINEL_VALUE is the constant used to exit the demo method(below) / program
	 */
	public static final int SENTINEL_VALUE = -1;

	/**
	 * methodList is a string for the display of AccountList's too many methods
	 */
	public static final String methodList = "1) Get an random Integer\n2) Get a random Short\n3) Get a random Long\n" +
											"4) Get a printed Array of Bytes\n5) Get a random float\n" + 
											"6) Get a double (as a dollar amount)\n7) Get a char (appended to a string)\n" +
											"8) Get a random boolean\n";
	
	/**
	 * keyboard is an instance of the Scanner class for getting keyboard input from the user 
	 */
	public static Scanner keyboard = new Scanner(System.in);
	
	/**method: demoMethod
	 * displays user interface and waits for entry
	 * if the entered value is equal to SENTINEL_VALUE the program exits 
	 */
	
	public static void demoMethod()
	{
		int returnval = 0;
		
		do
		{
			
			System.out.println(AccountList.methodList);
			System.out.println("Please Select a method to view the result of:");
			returnval = keyboard.nextInt();
			System.out.println(AccountList.chooseAMethod(returnval) + "\n");
			
		}while(returnval != AccountList.SENTINEL_VALUE);
		
	}
}
