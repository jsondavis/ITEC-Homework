package edu.ggc.jdavis37;
/**Class: QuickSort
* @author Rick Price
* @version 1.0
* Course : ITEC 2150 Fall 2012
* Written: November 2, 2012
*
*
* This class – Implementation of the Quick Sort algorithm
*
* Purpose: – Demonstrate quick sort
*/

public class QuickSorter
{
	private int [] sortArray;
	
	/** Method: QuickSort
	 * Constructor for QuickSort demonstration
	 * @param int[] the array to be sorted
	 */
	public QuickSorter(int[] inArray)
	{
		sortArray = inArray;
	}
	
	/** Method: sort
	 * Public interface for QuickSort
	 * @param int starting position, int ending position
	 * @return void
	 */
	public void sort(int from, int to)
	{
		//base case.  This is the exit case for the recursion.  When the low index is >/ to high index, simply return
		if (from >= to)
		{
			return;
		}
		int p = partition(from, to);
		sort (from, p);
		sort(p+1, to);
	}
	
	/** Method: partition
	 * Divides array into sub-areas to be sorted
	 * @param int starting position, int ending position
	 * @return void
	 */
	private int partition(int from, int to)
	{
		//assign the value contained in the position of the lowest reference to the pivot variable.  
		//this it the value we are comparing
		int pivot = sortArray[from];
		//subtract 1 from lowest index to allow following while to actually work on correct value and iterate through the array 
		int i = from - 1;
		//add 1 to high index for the following while
		int j = to + 1;
		while (i < j)
		{
			//change low index to traverse the array
			i++;
			//traverse the sorted area and record where it goes if pivot is less than a number already arranged
			while (sortArray[i] < pivot)
			{
				i++;
			}
			//change high index to traverse the array
			j--;
			//traverse the sorted area and record where it goes if pivot is greater than a number already arranged
			while (sortArray[j] > pivot)
			{
				j--;
			}
			if (i<j)
			{
				changeNum(i, j);
			}
		}
		return j;
	}
	
	/** Method: changeNum
	 * swaps numbers when needed
	 * @param int low value position, int high value position
	 * @return void
	 */
	private void changeNum(int i, int j)
	{
		int temp = sortArray[i];
		sortArray[i] = sortArray[j];
		sortArray[j] = temp;
	}

	public int[] getArray()
	{
		return this.sortArray;
	}
}
