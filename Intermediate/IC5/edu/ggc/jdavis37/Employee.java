package edu.ggc.jdavis37;

/**class : Employee
 * @author Jason Davis jdavis37
 * @version 1.0
 * @written February 18, 2013
 * 
 * The Employee class implements Comparable to enable comparision
 * using the compareTo method defined below. compareTo is used
 * to compare Employee (or sub objects) by their salaries.
 * 
 * The purpose of Employee is to demonstrate the use of implementation
 * and inheritance.
 */
public class Employee implements Comparable<Employee>
{
	private String name;
	private double salary;

	/**constructor : Employee
	 * Employee assigns the name and salary properties of the Employee object
	 * at instantiation.
	 * @param employeeName the String value to be assigned to name
	 * @param employeePay the double value to be assigned to salary
	 */
	public Employee(String employeeName, double employeePay)
	{
		this.name = employeeName;
		this.salary = employeePay;
	}
	
	/**method : getSalary
	 * getSalary returns the double value stored in the salary property.
	 * @return the double value from the salary property of this object.
	 */
	public double getSalary()
	{
		return this.salary;
	}
	
	/**method : getName
	 * getName returns the string value of the name property
	 * @return the string value from the name property of this object
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**method : toString
	 * toString overrides the default toString method in order to display
	 * the property values stored in this object instead of the default
	 * hex signature of the object
	 * @return a String display the properties of this Employee object.
	 */
	@Override
	public String toString()
	{	
		String returnString = String.format("Employee: Name = %s\n", this.name);
		returnString += String.format("Employee: Salary = $%,.2f", this.salary);
		return returnString;
	}
	
	/**method : compareTo
	 * compareTo compares the salaries of this Employee object with the supplied 
	 * Employee object and returns an integer value determined by the comparison
	 * @param e is another instance of Employee to compare to.
	 * @return the integer value which results from the comparison of the supplied object
	 * 		   and this object
	 */
	public int compareTo(Employee e)
	{
		if(salary < e.getSalary())
		{
			return -1;
		}
		else if(salary > e.getSalary())
		{
			return 1;
		}
		return 0;
	}

}
