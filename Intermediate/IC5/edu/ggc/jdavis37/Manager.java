package edu.ggc.jdavis37;

/**class : Manager
 * @author Jason Davis jdavis37
 * @version 1.0
 * @written February 18, 2013
 * 
 * The Manager class extends Employee adding a department
 * property.
 * 
 * The purpose of Manager is to add another Employee type
 * for comparison, as well as demonstrating inheritance.
 */
public class Manager extends Employee
{
	public String department = "";
	
	/**constructor : Manager
	 * Uses the constructor of the superclass Employee
	 * @param employeeName the name to be assigned to the Manager
	 * @param employeePay the pay to be assigned to the Manager
	 */
	public Manager(String employeeName, double employeePay)
	{
		super(employeeName, employeePay);
	}
	
	/**constructor : Manager
	 * Overloaded constructor allows for the assignment of department
	 * at instantiation if desired.
	 * @param employeeName the name to be assigned to Manager
	 * @param employeePay the pay to be assigned to the Manager
	 * @param managerDepartment the division for this Manager
	 */
	public Manager(String employeeName, double employeePay, String managerDepartment)
	{
		super(employeeName, employeePay);
		this.department = managerDepartment;
	}
	
	/**method : setDepartment
	 * setDepartment can be used to set the department for the Manager if it needs to be
	 * reset or was not set at instantiation
	 * @param managerDepartment the division to be assigned to this Manager
	 */
	public void setDepartment(String managerDepartment)
	{
		this.department = managerDepartment;
	}
	
	/**method : toString
	 * toString overwrites the basic toString method so that the values of the 
	 * Manager object are displayed rather than the hex(?) signature of the 
	 * object
	 */
	@Override
	public String toString()
	{
		String returnString = String.format("Manager: Name = %s\n", this.getName());
		returnString += String.format("Manager: Salary = $%,.2f", this.getSalary());
		if(!this.department.equals(""))
		{
			returnString += String.format("\nManager: Department = %s", this.department);
		}
		return returnString;
	}

}
