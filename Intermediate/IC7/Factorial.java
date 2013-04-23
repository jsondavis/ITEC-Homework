package edu.ggc.jdavis37;

public class Factorial
{
	
	public static int findFactorial(int n) 
	{
		if(n == 1)
		{
			return n;
		}
		return findFactorial(n - 1) * n;
	}

	public static int factorialLoop(int n)
	{
		int total = n;
		for(int i = n - 1; i > 0; i--)
		{
			total = i * total; 			
		}
		
		return total;
	}
	
	public static String factorialTest(int n)
	{
		return "Recursive Factorial (" + n + "): " + Factorial.findFactorial(n) + "   &  Loop Factorial (" + n + "): " + factorialLoop(n);
	}
	
	
	public static void main(String[] args) {

		System.out.println(factorialTest(2));
		System.out.println(factorialTest(3));
		System.out.println(factorialTest(4));
		System.out.println(factorialTest(5));
		System.out.println(factorialTest(16));
		System.out.println(factorialTest(50));
		System.out.println();
		System.out.println("Also the factorial of 50 is ~ 3.01 * 10^64," 
				+ " which is a number significantly larger than Java's maximum integer value of " + Integer.MAX_VALUE);
	}

}
