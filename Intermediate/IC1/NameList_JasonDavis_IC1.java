package com.ggc.jdavis37.IC;

import java.util.Scanner;

/**Class: NameList_JasonDavis_IC1
   * @author Jason Davis
   * @version 1.0
   * Course : ITEC 2150 Spring 2013
   * Written: January 14, 2013
   * 
   * NameList_JasonDavis_IC1 uses the getLength method to define the length of the list
   * 		  the getNames method to define each element of the list
   * 		  and displayNames to print each element to the console.
   * 
   * Purpose: The purpose of NameList_JasonDavis_IC1 is to create and display 
   * 		  a list of names based on user input.
   */

public class NameList_JasonDavis_IC1 {
	
	/**
	 * keyboard will be used in both getLength and getNames methods below
	 */
	
	private Scanner keyboard = new Scanner(System.in);
	
	/**
	 * names will be given a length from Scanner input in the getLength method below 
	 */
	
	private String[] names;
	
	/**Method: getLength
	  * Get and set the length of the name array with a user prompt.
	  * @return void 
	  */
	
	private void getLength()
	{
		System.out.println("How many names would you like to enter?");
		int listlength = keyboard.nextInt();
		names = new String [listlength];
	}
	
	/**Method: getNames
	  * Get and set each element of the name array with user prompt,
	  * using a for loop.
	  * @return void
	  */
	
	private void getNames()
	{
		for(int i = 0; i < names.length; i++)
		{
			System.out.println(String.format("Please enter name # %d:", i + 1));
			names[i] = keyboard.next();
		}
	}
	
	/**Method: displayNames
	  * Output each element of the names array to the console using a while loop.
	  * @return void
	  */
	
	private void displayNames()
	{
		int counter = 0;
		System.out.println("\nNames:");
		while(counter < names.length)
		{
			System.out.println(String.format("%d) %s", counter + 1 , names[counter]));
			counter++;
		}
	}
	
	/**Method: Main
	  * Creates one NameList_JasonDavis_IC1 object and calls each of the methods above on that
	  * instance. 
	  * @param args - command line arguments
	  */
	public static void main(String[] args) {
		
		//create a NameList_JasonDavis_IC1 object
		NameList_JasonDavis_IC1 nameList = new NameList_JasonDavis_IC1();
		
		//get the length of the new NameList_JasonDavis_IC1
		nameList.getLength();
		
		//get the names for the new NameList_JasonDavis_IC1
		nameList.getNames();
		
		//display each name in the NameList_JasonDavis_IC1
		nameList.displayNames();
		
	}

}
