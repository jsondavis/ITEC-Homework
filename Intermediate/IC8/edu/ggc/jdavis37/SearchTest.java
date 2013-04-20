package edu.ggc.jdavis37;

import java.util.Scanner;


/**
 * class : SearchTest
 * 
 * @author Jason Davis
 * @version 1.0
 * @course ITEC 2150 Spring 2013 written April 15, 2013
 * 
 *         This class uses the LinearSearch, BinarySearch, QuickSorter and
 *         ListGen classes to compare a linear search algorithm with a binary
 *         search algorithm.
 * 
 *         The purpose of this class is to demonstrate the use of linear and
 *         binary search algorithms. On a side note this assignment also served
 *         to illustrate to me that I need to exercise more caution when using
 *         the rm -rf command.
 * 
 */

public class SearchTest
{

	/**
	 * find is an integer value to find in the array size is the integer value
	 * representing the size of the array to be created sorted determines the
	 * type of search to be performed true = binary , false = linear
	 */

	private int		find	= 0;
	private int		size;
	private boolean	sorted;

	/**
	 * Method : getData This method will gather user input for the find size and
	 * sorted properties above.
	 * 
	 * @return void
	 */

	public void getData()
	{
		Scanner scan = new Scanner(System.in);

		System.out.println("How large of a list would you like to search?");
		String input = scan.nextLine();
		size = Integer.parseInt(input);

		while (find < 1 || find > size)
		{
			System.out.println(String.format(
					"\nPick a number between 1 and %d to search for?", size));
			String input2 = scan.nextLine();
			find = Integer.parseInt(input2);
		}

		System.out
				.println("\nWould you like to search a sorted or unsorted list?\n1)Sorted\n2)Unsorted\nEnter any other number to exit.");
		String input3 = scan.nextLine();
		int sortval = Integer.parseInt(input3);
		if (sortval < 1 || sortval > 2)
		{
			System.exit(0);
		}
		sorted = sortval == 1;
	}

	/**
	 * Method : isSorted This method returns the boolean value sorted.
	 * 
	 * @return sorted : boolean
	 */
	public boolean isSorted()
	{
		return this.sorted;
	}

	/**
	 * Method : getFind This method returns the value of the find property.
	 * 
	 * @return find : integer value
	 */
	public int getFind()
	{
		return this.find;
	}

	/**
	 * Method : clearFind This method resets the value of the integer find to
	 * zero.
	 * 
	 * @return void
	 */
	public void clearFind()
	{
		this.find = 0;
	}

	/**
	 * Method : getSize This method returns the value of the size property.
	 * 
	 * @return size : integer value
	 */
	public int getSize()
	{
		return this.size;
	}

	/**
	 * Method : linTest This static method returns a String which details the
	 * results of a linear search of the array parameter for the integer
	 * parameter.
	 * 
	 * @param testarray
	 *            an array of integers to be searched through findThis : an
	 *            integer to search for in testarray
	 * @return a string detailing the result of the search.
	 */

	public static String linTest(int[] testarray, int findThis)
	{
		LinearSearch lin = new LinearSearch(testarray, findThis);
		int linCompares = lin.getComparison();
		String out = "";

		String arrayPrint = "";

		for (int i = 0; i < testarray.length; i++)
		{
			arrayPrint += String.format("%d ,", testarray[i]);
			arrayPrint += (i > 1 && i % 7 == 0) ? "\n" : "";
		}

		if (linCompares > 0)
		{
			out = String
					.format("%s\nIt took %d linear comparisons to find %d in the list above.",
							arrayPrint, linCompares, findThis);
		}
		else
		{
			out = String
					.format("%s\n%d was not found in the list above after %d linear comparisons.",
							arrayPrint, findThis, -1 * linCompares);
		}
		return out;
	}

	/**
	 * Method : binTest This static method returns a String which details the
	 * results of a binary search of the array parameter for the integer
	 * parameter. Before the search can be performed the array must be sorted
	 * this is done using a quick sort.
	 * 
	 * @param testarray
	 *            an array of integers to be searched through findThis : an
	 *            integer to search for in testarray
	 * @return a string detailing the result of the search
	 */
	public static String binTest(int[] testarray, int findThis)
	{

		QuickSorter q = new QuickSorter(testarray);
		q.sort(0, testarray.length - 1);
		BinarySearch b = new BinarySearch();
		int binCompares = b.search(testarray, findThis);

		String arrayPrint = "";

		for (int i = 0; i < testarray.length; i++)
		{
			arrayPrint += String.format("%d ,", testarray[i]);
			arrayPrint += (i % 7 == 0) ? "\n" : "";
		}

		arrayPrint = arrayPrint.substring(0, arrayPrint.length() - 1);

		String out = "";

		if (binCompares > 0)
		{
			out = String
					.format("%s\nIt took %d binary comparisons to find %d in the list above.",
							arrayPrint, binCompares, findThis);
		}
		else
		{
			out = String
					.format("%s\n%d was not found in the list above after %d binary comparisons.",
							arrayPrint, findThis, -1 * binCompares);
		}

		return out;
	}

	/**
	 * Method : main This method creates an instance of the SearchTest class in
	 * order to get the size of the array to be created and the integer to find
	 * in that array as well as the algorithm to use when searching. These are
	 * then used by the static methods to determine if the number is in the
	 * array and how many comparisons were made before it was or was not found.
	 * 
	 * @param args
	 *            string array of command line arguments not used here
	 * @return void
	 */
	public static void main(String[] args)
	{
		SearchTest s = new SearchTest();

		while (true)
		{
			s.getData();

			int findInt = s.getFind();
			int listSize = s.getSize();

			int[] newArr = ListGen.getArray(listSize);

			String output = "";

			if (s.isSorted())
			{
				output = SearchTest.binTest(newArr, findInt);
			}
			else
			{
				output = SearchTest.linTest(newArr, findInt);
			}

			System.out.println(output + "\n\n");
			s.clearFind();
		}
	}

}
