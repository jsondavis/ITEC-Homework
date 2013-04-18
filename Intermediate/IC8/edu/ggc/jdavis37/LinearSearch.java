package edu.ggc.jdavis37;

import java.util.ArrayList;
import java.util.Collections;

public class LinearSearch
{
	private int compares = 0;
	
	public LinearSearch(ArrayList<Integer> list, int find)
	{
		Collections.shuffle(list);
		for(int i = 0; i < list.size(); i++)
		{
			compares++;
			if(list.get(i) == find)
			{		
				break;
			}
			
			if(i == (list.size()-1))
			{
				compares *= -1;
			}
		}
	}
	
	public LinearSearch(int[] list, int find)
	{
		ListGen.arrayShuffle(list);
		
		for(int i = 0; i < list.length; i++)
		{
			compares++;
			if(list[i] == find)
			{
				break;
			}
			if(i == list.length-1)
			{
				compares *= -1;
			}
		}
	}
	
	public int getComparison()
	{
		return this.compares;
	}
}
