package edu.ggc.jdavis37;

import java.util.Arrays;


/**
 * class : BinarySearch
 * 
 * @author Jason Davis
 * @version 1.0
 * @course ITEC 2150 Spring 2013 written April 15, 2013
 * 
 *         This class searches an array of integers for an integer using a
 *         binary search (divide and conquer) algorithm.
 * 
 *         The purpose of this class is to demonstrate the use of a binary
 *         search algorithm.
 */

public class BinarySearch
{

	/**
	 * Method : search This method searches the array parameter for the find
	 * parameter recursively and returns an integer value representing the
	 * number of comparisons performed.
	 * 
	 * @param list
	 *            a sorted array of integers to be searched
	 * @param find
	 *            an integer to search the list for
	 * @return the integer number of comparisons performed
	 */
	public int search(int[] list, int find)
	{
		int guess = 0;
		if (list.length <= 1)
		{
			return -1;
		}
		if (list.length > 1)
		{
			guess = list[list.length / 2];
		}

		if (guess == find)
		{
			return 1;
		}
		else if (find < guess)
		{
			BinarySearch b = new BinarySearch();
			int[] test = Arrays.copyOfRange(list, 0, list.length / 2 - 1);
			return b.search(test, find) + 1;
		}
		else if (find > guess)
		{
			BinarySearch b = new BinarySearch();
			int[] test = Arrays.copyOfRange(list, list.length / 2 + 1,
					list.length);
			return b.search(test, find) + 1;
		}

		return 0;
	}

}
