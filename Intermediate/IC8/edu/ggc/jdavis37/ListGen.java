package edu.ggc.jdavis37;

import java.util.ArrayList;
import java.util.Random;

public class ListGen
{
	public static ArrayList<Integer> getArrayList(int size)
	{
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0; i < size; i++)
		{
			list.add(1 + (int)(Math.random() * ((size - 1) + 1)));
		}
		return list;
	}
	
	public static int[] getArray(int size)
	{
		int[] list = new int[size];
		for(int i = 0; i < list.length; i++)
		{
			list[i] = 1 + (int)(Math.random() * ((size - 1) + 1));
		}
		return list;
	}
	
	public static int[] ArrayListToArray(ArrayList<Integer> list)
	{
		int [] intlist = new int[list.size()];
		for(int i = 0; i < intlist.length; i++)
		{
			intlist[i] = list.get(i);
		}
		return intlist;
	}
	
	
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
