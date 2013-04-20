package edu.ggc.jdavis37;

import java.util.ArrayList;
import java.util.Random;


/**
 * class : ListGen
 * 
 * @author Jason Davis
 * @version 1.0
 * @course ITEC 2150 Spring 2013 written April 13, 2013
 * 
 *         This class contains static methods which return arrays or ArrayLists
 *         filled with random numbers from 1 to the size of the array or list.
 * 
 *         The purpose of this class is to make the creation of arrays or
 *         ArrayLists with random numbers easier.
 */

public class ListGen
{

	/**
	 * Method : getArrayList This method returns an ArrayList of Integers the
	 * size of the size parameter
	 * 
	 * @param size
	 *            The size of the ArrayList to be returned
	 * @return an ArrayList filled with random integers
	 */
	public static ArrayList<Integer> getArrayList(int size)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < size; i++)
		{
			list.add(1 + (int) (Math.random() * ((size - 1) + 1)));
		}
		return list;
	}

	/**
	 * Method : getArray This method returns an array of integers the size of
	 * the size parameter
	 * 
	 * @param size
	 *            The size of the array to be returned
	 * @return an array filled with random integers
	 */
	public static int[] getArray(int size)
	{
		int[] list = new int[size];
		for (int i = 0; i < list.length; i++)
		{
			list[i] = 1 + (int) (Math.random() * ((size - 1) + 1));
		}
		return list;
	}

	/**
	 * Method : arrayShuffle This method randomly shuffles the array passed in.
	 * 
	 * @param arr
	 *            An array of integers to be shuffled
	 * @return void
	 */
	static void arrayShuffle(int[] arr)
	{
		Random rnd = new Random();
		for (int i = arr.length - 1; i >= 0; i--)
		{
			int index = rnd.nextInt(i + 1);
			// Simple swap
			int a = arr[index];
			arr[index] = arr[i];
			arr[i] = a;
		}
	}
}
