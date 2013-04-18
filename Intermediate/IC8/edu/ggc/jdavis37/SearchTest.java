package edu.ggc.jdavis37;


/**class : SearchTest
 * @author Jason Davis
 * @version 1.0
 * @course ITEC 2150 Spring 2013
 * written April 15, 2013
 *
 * This class uses the LinearSearch, BinarySearch, QuickSorter
 * and ListGen classes to compare a linear search algorithm
 * with a binary search algorithm.
 *
 * The purpose of this class is to demonstrate the use of 
 * linear and binary search algorithms.
 */

public class SearchTest
{
    /**
     * find is an integer value to find in the array 
     * size is the integer value representing the size 
     *      of the array to be created
     * sorted determines the type of search to be performed
     *      true = binary , false = linear
     */

    private int find = 0;
    private int size;
    private boolean sorted;
  

    /**Method : getData
     * This method will gather user input for the find size and sorted properties above. 
     * @return void
     */

    public void getData()
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("How large of a list would you like to search?");
        String input = scan.nextLine();
        size = Integer.parseInt(input);

        while(find < 1 || find > size)
        {
            System.out.println(String.format("\nPick a number between 1 and %d to search for?", size));
            String input2 = scan.nextLine();
            find = Integer.parseInt(input2);
        }

        System.out.println("\nWould you like to search a sorted or unsorted list?\n1)Sorted\n2)Unsorted\nEnter any other number to exit.");
        String input3 = scan.nextLine();
        int sortval = Integer.parseInt(input3);
        if(sortval != 1 || sortval != 2)
        {
            System.exit(0);
        }
        sorted = sortval == 1;
    }

    /**Method : isSorted
     * This method returns the boolean value sorted.
     * @return sorted : boolean
     */
    public boolean isSorted()
    {
        return this.sorted;
    }

    /**Method : getFind
     * This method returns the value of the find proterty.
     * @return find : integer value
     */
    public int getFind()
    {
        return this.find;
    }
    
    /**Method : getSize
     * This method returns the value of the size proterty.
     * @return size : integer value
     */
    public int getSize()
    {
        return this.size;
    }

    
    /**Method : linTest
     * This static method returns a String which details the results
     * of a linear search of the array parameter for the integer parameter.
     * @params testarray : an array of integers to be searched through
     *          findThis : an integer to search for in testarray
     * @return a string detailing the result of the search.
     */

	public static String linTest(int[] testarray, int findThis)
	{
		LinearSearch lin = new LinearSearch(testarray, findThis);
		int linCompares = lin.getComparison();
		String out = "";
		
		if(linCompares > 0)
		{
			out = String.format("It took %d linear comparisons to find %d.", linCompares , findThis);
		}
		else
		{
			out = String.format("%d was not found in the list of numbers after %d linear comparisons.", findThis, -1 * linCompares);
		}
	    return out;	
	}
	
    /**Method : binTest
     * This static method returns a String which details the results
     * of a binary search of the array parameter for the integer parameter.
     * Before the search can be performed the array must be sorted this is
     * done using a quick sort.
     * @params testarray : an array of integers to be searched through
     *         findThis : an integer to search for in testarray
     * @return a string detailing the result of the search
     */
	public static String binTest(int[] testarray, int findThis)
	{
		
		
		QuickSorter q = new QuickSorter(testarray);
		q.sort(0, testarray.length-1);
		int binCompares = BinarySearch.search(testarray, findThis);
		String out = "";
	
		if(binCompares > 0)
		{
			out = String.format("It took %d binary comparisons to find %d.", binCompares , findThis);
		}
		else
		{
			out = String.format("%d was not found in the list of numbers after %d binary comparisons.", findThis, -1 * binCompares);
		}
		BinarySearch.resetStatic();
	    return out;
    }

	/**Method : main
     * This method creates an instance of the SearchTest class in order 
     * to get the size of the array to be created and the integer to find
     * in that array as well as the algorithm to use when searching. 
     * These are then used by the static methods to determine if the number
     * is in the array and how many comparisons were made before it was 
     * or was not found.
	 * @param args : string array of command line arguments not used here
     * @return void
	 */
	public static void main(String[] args) {
		
       SearchTest s = new SearchTest();
       s.getData();
       
       int findInt = s.getFind();
       int listSize = s.getSize();
        
       int[] newArr = ListGen.getArray(listSize);
        
       String output = "";

       if(s.isSorted())
       {
            output = SearchTest.binTest(newArr, find);
       }
       else
       {
            output = SearchTest.linTest(newArr, find);
	   }

       System.out.out.println(output);
	}

}
