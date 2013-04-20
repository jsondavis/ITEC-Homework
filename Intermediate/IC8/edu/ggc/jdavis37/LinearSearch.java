package edu.ggc.jdavis37;

import java.util.ArrayList;
import java.util.Collections;


/**
 * class : LinearSearch
 * 
 * @author Jason Davis
 * @version 1.0
 * @course ITEC 2150 Spring 2013 written April 15, 2013
 * 
 *         This class searches an array of integers for an integer using a
 *         linear search algorithm.
 * 
 *         The purpose of this class is to demonstrate the use of a linear
 *         search algorithm.
 */

public class LinearSearch
{

	/**
	 * compares is the integer representing the number of comparisons perfomed
	 */
	private int	compares	= 0;

	/**
	 * Method : LinearSearch This method searches the list parameter for the
	 * find parameter
	 * 
	 * @param list
	 *            ArrayList to search
	 * @param find
	 *            Integer value to search the ArrayList for
	 */
	public LinearSearch(ArrayList<Integer> list, int find)
	{
		Collections.shuffle(list);
		for (int i = 0; i < list.size(); i++)
		{
			compares++;
			if (list.get(i) == find)
			{
				break;
			}

			if (i == (list.size() - 1))
			{
				compares *= -1;
			}
		}
	}

	/**
	 * Method : LinearSearch This method searches the list parameter for the
	 * find parameter. Before searching the list is shuffled.
	 * 
	 * @param list
	 *            array of integers to search
	 * @param find
	 *            integer value to search the array for
	 */
	public LinearSearch(int[] list, int find)
	{
		ListGen.arrayShuffle(list);

		for (int i = 0; i < list.length; i++)
		{
			compares++;
			if (list[i] == find)
			{
				break;
			}
			if (i == list.length - 1)
			{
				compares *= -1;
			}
		}
	}

	/**
	 * Method : getComparison This method returns the number of comparisons
	 * performed.
	 * 
	 * @return the value of the compares property
	 */

	public int getComparison()
	{
		return this.compares;
	}
}
