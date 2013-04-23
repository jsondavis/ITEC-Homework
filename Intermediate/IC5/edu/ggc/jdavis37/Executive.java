package edu.ggc.jdavis37;

/**class : Executive
 * @author Jason Davis jdavis37
 * @version 1.0
 * @written February 18, 2013
 * 
 * The Executive class extends Employee adding a division
 * property.
 * 
 * The purpose of Executive is to add another Employee type
 * for comparison, as well as demonstrating inheritance.
 */
public class Executive extends Employee
{
	public String division = "";
	
	/**constructor : Executive
	 * Uses the constructor of the superclass Employee
	 * @param employeeName the name to be assigned to Executive
	 * @param employeePay the pay to be assigned to the Executive
	 */
	public Executive(String employeeName, double employeePay)
	{
		super(employeeName, employeePay);
	}
	
	/**constructor : Executive
	 * Overloaded constructor allows for the assignment of division
	 * at instantiation if desired.
	 * @param employeeName the name to be assigned to Executive
	 * @param employeePay the pay to be assigned to the Executive
	 * @param execDivision the division for this Executive
	 */
	public Executive(String employeeName, double employeePay, String execDivision)
	{
		super(employeeName, employeePay);
		this.division = execDivision;
	}
	
	/**method : setDivision
	 * setDivision can be used to set the division for the Executive if it needs to be
	 * reset or was not set at instantiation
	 * @param execDivision the division to be assigned to this Executive
	 */
	public void setDivision(String execDivision)
	{
		this.division = execDivision;
	}
	
	/**method : toString
	 * toString overwrites the basic toString method so that the values of the 
	 * Executive object are displayed rather than the hex(?) signature of the 
	 * object
	 */
	@Override
	public String toString()
	{
		String returnString = String.format("Executive: Name = %s\n", this.getName());
		returnString += String.format("Executive: Salary = $%,.2f", this.getSalary());
		if(!this.division.equals(""))
		{
			returnString += String.format("\nExecutive: Division = %s", this.division);
		}
		return returnString;
	}
}
