package edu.ggc.jdavis37;

import java.util.ArrayList;
import java.util.Scanner;

/**class : EmployeeTester
 * 
 * @author Jason Davis jdavis37
 * @version 1.0
 * @written February 18, 2013
 * 
 * The EmployeeTester class creates 2 Employee , Manager , or Executive
 * objects and uses the compareTo method implemented in Employee to
 * compare the salaries of the 2 created objects.
 * 
 * The purpose of EmployeeTester is to display proper use of the 
 * concepts of polymorphism , inheritance, and implementation by
 * the Employee class and it's child classes.
 *
 */

public class EmployeeTester
{
	/**
	 *@keyboard is a Scanner object used throughout the EmployeeTester methods
	 *			for user input
	 */
	static Scanner keyboard = new Scanner(System.in);
	
	/**
	 *@employees is an ArrayList used to store the created Employee objects
	 *			-employees could easily have been an array as well. 
	 */
	static ArrayList<Employee> employees = new ArrayList<Employee>(); 
	
	/**method : getChoices
	 * getChoices adds 2 Employee objects to the employees ArrayList
	 * then compares the 2 entered Employees using the compareTo
	 * implemented in the Employee class. 
	 */
	public static void getChoices()
	{
		while(employees.size() < 2)
		{
			employees.add(getEmployee());
		}
		
		System.out.println(compare(employees.get(0), employees.get(1)));
	}
	
	/**method getEmployee
	 * getEmployee presents a display for selection of employee type.
	 * The integer entered is passed to the makeEmployee method 
	 * which returns an Employee which is also returned.
	 * @return the Employee created by makeEmployee
	 */
	public static Employee getEmployee()
	{
		System.out.println("To create a new employee type 1.");
		System.out.println("To create a new manager type 2.");
		System.out.println("To create a new executive type 3.");		
		Employee e = makeEmployee(Integer.parseInt(keyboard.nextLine()));
		System.out.println("\n\nAdded\n" + e + "\n\n");
		return e;
	}

	/**method : makeEmployee
	 * makeEmployee is a method of the EmployeeTester class which takes
	 * an int as a parameter and returns an employee of the type specified
	 * @param type the type defined in the display presented in getEmployee above
	 * @return an Employee object or a child of Employee (Manager or Executive)
	 */
	public static Employee makeEmployee(int type)
	{
		if(type == 2)
		{
			System.out.println("Please enter a name for the new Manager");
			String name = keyboard.nextLine();
			System.out.println("Please enter a salary for " + name + ".");
			double pay = Double.parseDouble(keyboard.nextLine());
			Manager m1 = new Manager(name , pay);
			System.out.println("If you would like to set a department please enter it now.");
			m1.setDepartment(keyboard.nextLine());
			return m1;
		}
		else if(type == 3)
		{
			System.out.println("Please enter a name for the new Executive");
			String name = keyboard.nextLine();
			System.out.println("Please enter a salary for " + name + ".");
			double pay = Double.parseDouble(keyboard.nextLine());
			Executive exec1 = new Executive(name , pay);
			System.out.println("If you would like to set a division please enter it now.");
			exec1.setDivision(keyboard.nextLine());
			return exec1;
		}
		else
		{
			System.out.println("Please enter a name for the new Employee");
			String name = keyboard.nextLine();
			System.out.println("Please enter a salary for " + name + ".");
			double pay = Double.parseDouble(keyboard.nextLine());
			Employee e1 = new Employee(name , pay);
			return e1;
		}
	}

	/**method : compare
	 * compare uses the Employee compareTo method to compare Employee objects.
	 * Thanks to polymorphism Executive and Manager objects can be compared as
	 * Employee objects.
	 * @param one the first Employee object or child of Employee
	 * @param two the second Employee object or child of Employee
	 * @return a string for display
	 */
	public static String compare(Employee one , Employee two)
	{
		String returnString = "";
		returnString += "Comparing:\n" + one + "\nand\n" + two;

		if(one.compareTo(two) == 1)
		{
			returnString += String.format("\n\n%s ($%,.2f) makes more than %s ($%,.2f).",one.getName() , one.getSalary(), two.getName(), two.getSalary());
		}
		else if(one.compareTo(two) == -1)
		{
			returnString += String.format("\n\n%s ($%,.2f) makes less than %s ($%,.2f).",one.getName(), one.getSalary() , two.getName() , two.getSalary());
		}
		else
		{
			returnString += String.format("\n\nOdd %s ($%,.2f) makes the same as %s ($%,.2f).",one.getName(), one.getSalary() , two.getName() , two.getSalary());
		}
		return returnString;
	}

	/**method : main
	 * the main method uses the getChoices method from above to create Employee objects and
	 * display the output. 
	 * @param args the command line arguments, if any are specified.
	 */
	public static void main(String[] args) {
		getChoices();
	}

}
