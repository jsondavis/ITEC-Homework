package edu.ggc.jdavis37.homework1;

/**Class: Account
 * @author Jason Davis - jdavis37@ggc.edu
 * @version 1.0
 * Course: ITEC 2150 Spring 2013
 * Assignment: Homework 1
 * Written: January 10, 2013
 */

public class Account 
{
	private String accountName = "", accountTitle = "";
	private Long accountNumber;	
	
	/**method: Account - constructor
	 * sets the values of name and title
	 * @param name - name for contact object
	 * @param accountNum - long value representation of an account number
	 */
	
	public Account(Long accountNum, String name)
	{
		this.accountNumber = accountNum;
		this.accountName = name;
	}
	
	/**Account *Overloaded to accept 
	 * @param title - Mr. / Mrs. / etc.
	 * @param name -  name of account holder for account object
	 * @param accountNum - long value representation of an account number
	 */
	
	public Account(Long accountNum, String name, String title)
	{
		this.accountNumber = accountNum;
		this.accountName = name;
		this.accountTitle = title;
	}
	
	private int accountDollars = 0;

	/**Account *Overloaded to accept 
	 * @param title - Mr. / Mrs. / etc.
	 * @param name -  name of account holder for account object
	 * @param dollars - integer value for whole dollars for account
	 * @param accountNum - long value representation of an account number
	 */
	
	public Account(Long accountNum, String name, String title, int dollars)
	{
		this.accountNumber = accountNum;
		this.accountName = name;
		this.accountTitle = title;
		this.accountDollars = dollars;
	}

	private int accountChange = 0;
	
	/**Account *Overloaded to accept 
	 * @param title - Mr. / Mrs. / etc.
	 * @param name -  name of account holder for account object
	 * @param dollars - integer value for whole dollars for account
	 * @param change - integer value for the partial dollars value 1/100
	 * @param accountNum - long value representation of an account number
	 */
	
	public Account(Long accountNum, String name, String title, int dollars, int change)
	{
		this.accountNumber = accountNum;
		this.accountName = name;
		this.accountTitle = title;
		this.accountDollars = dollars;
		this.accountChange = change;
	}	

	/**method: getAccountName
	 * @return the formatted string containing 
	 * the title followed by the account's name
	 */
	public String getAccountName()
	{
		return String.format("%s %s", this.accountTitle, this.accountName);
	}
	
	/**method: getAccountAmount
	 * @return a formatted string for display of
	 * the dollar amount in the account
	 */
	public String getAccountAmount()
	{
		return String.format("$%.2f", (double) (this.accountDollars + (this.accountChange/100.0)));
	}
	
	/**method: getAccountNumber
	 * @return the account number associated with the instance as a long
	 */
	public Long getAccountNumber()
	{
		return this.accountNumber;
	}
	
	private byte[] bytearray = {(byte) 1, (byte) 2, (byte) 3};
	
	/**method: getBytes
	 * @return a string containing the byte values from bytearray
	 */
	public String getBytes()
	{
		String returnString = "";
		for(int i = 0; i < bytearray.length; i++)
		{
			returnString += bytearray[i];
		}
		return returnString;
	}
	
}