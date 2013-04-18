package edu.ggc.jdavis37;


import java.util.Arrays;

public class BinarySearch
{
	public static int statcompare = 0;

	
	public static void resetStatic()
	{
		statcompare = 0;
	}
	
	
	
	public static int search(int[] list, int find)
	{
		int guess = 0;
		if(list.length > 1) 
		{
			guess = list[list.length / 2];
		}
			
		if(list.length < 1)
		{
			return -1;
		}
		else if(list.length == 1 && list[0] != find)
		{
			return -1;
		}
		else if(guess == find)
		{
			return 1;
		}
		else if(guess > find)
		{
			int[] test = Arrays.copyOfRange(list, 0, (list.length/2));
			int searchReturn = search(test, find);
			if(searchReturn >= 0)
			{
				return searchReturn + 1;
			}
			else
			{
				return searchReturn -1;
			}
		}
		else
		{
			int[] test = Arrays.copyOfRange(list, list.length/2 , list.length);
			int searchReturn = search(test, find);
			if(searchReturn >= 0)
			{
				return searchReturn + 1;
			}
			else
			{
				return searchReturn -1;
			}
		}
	}
	
}
