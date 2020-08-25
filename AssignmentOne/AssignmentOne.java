//Githel Lynn Suico, 7852
//Giovanni Quevedo, 1892

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
* @author Githel Lynn Suico 
* @author Giovanni Quevedo
*/

public class AssignmentOne 
{
	public static void main(String[] args) 
	{
		ArrayList<String> input = getInput(args[0]);
		
		printInput(input);
		printInputAndLengths(input);
		printReverseInput(input);
		printSortedInput(input);
		
		int[] theInts = generateRandomInts();
		
		printInts(theInts);
		printAverage(theInts);
		printStdDev(theInts);
		printSquareRoots(theInts);
		
	}
	
	/**
	* This method prints out to the standard output
	* @param input This parameter takes in the input to print out
	*/
	private static void printInput(ArrayList<String> input)
	{
		printInput("The Input File", input, false);
	}
	
	/**
	* This method prints out the standard output of the inputs and the inputs lengths
	* @param input This parameter takes in an input to be printed
	*/
	private static void printInputAndLengths(ArrayList<String> input)
	{
		printInput("The Input File and Lengths", input, true);
	}
	
	/**
	* This method prints a title, the input, and optionally the lengths of the input.
	* @param title This parameter takes the title
	* @param input This parameter takes the the input.
	* @param withLength If true, prints the length of input
	*/
	private static void printInput(String title, ArrayList<String> input, boolean withLengths)
	{
		System.out.println("\n" + title + "\n");
		for(String s : input)
		{
			System.out.print(s + " ");
			if(withLengths) System.out.print(s.length());
			System.out.println();
		}	
	}
	
	/**
	* This method prints out the input 
	* @param theInts This parameter takes in the input to be printed.
	*/
	private static void printInts(int[] theInts)
	{
		System.out.println("\nSome Random Integers\n");
		for(int ii = 0; ii < theInts.length; ++ii)
		{
			System.out.println(theInts[ii]);
		}
		
	}
	
	
	/**
	* This method prints the input in reverse order
	* @param input This parameter takes in an ArrayList of Strings
	*/
	private static void printReverseInput(ArrayList<String> input)
	{
		System.out.println("\nThe Input File Reversed\n");
		
		for(String s : input)
		{
			String reverse = "";
			int pos = s.length() - 1;
			while(pos >= 0) reverse += s.charAt(pos--);
			System.out.println(reverse);
		}
	}
	
	
	/**
	* This method prints out the input to be printed.
	* @param input This parameter takes in an input to be printed
	*/
	private static void printSortedInput(ArrayList<String> input)
	{
		ArrayList<String> sorted = new ArrayList<String>(input);
		Collections.sort(sorted);
		printInput("Sorted String Input", sorted, false);
		
	}
	
	/**
	* This method reads and loads the file 
	* @param fileName This parameter takes in a filename.
	* @return This method returns the input
	*/
	private static ArrayList<String> getInput(String fileName)
	{
	     try
	     {
	    	ArrayList<String> input = new ArrayList<String>();
	    	Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
	        
	        while(sc.hasNext()) input.add(sc.next());
	        sc.close();
	        
	        return input;
	        
	     }
	     catch(Exception exc)
	     {
	    	 System.out.println("Exception: " +exc.getMessage() + " opening input file " + fileName);
	    	 System.exit(0);
	     }
	     
		return null;
	}
	
	/**
	* This method generates random ints
	* @return This returns an array of random ints
	*/
	private static int[] generateRandomInts()
	{
		final int SIZE = 15;
		int[] output = new int[SIZE];
		Random gen = new Random();
		
		final int MAX = (int)(Math.pow(2, 20));
		
		for(int ii = 0; ii < SIZE; ++ii) output[ii] = gen.nextInt(MAX);
		
		return output;
	}
	
	/**
	* This method finds the sum of input
	* @param input This parameter takes in input to be added
	* @return This returns the sum.
	*/
	private static int getSum(int[] input)
	{
		int sum = 0;
		for(int ii = 0; ii < input.length; ++ii) sum += input[ii];
		
		return sum;
	}
	
	/**
	* This method finds the average of input
	* @param input This parameter takes in an array of ints
	* @return This returns the average.
	*/
	private static double getAverage(int[] input)
	{
		double size = input.length;
		
		if(size == 0) return 0.0;
		else
		{
			return getSum(input) / size;
		}
		
	}
	
	/**
	* This method finds the standard deviation.
	* @param input This parameter takes in an array of ints
	* @return This returns the standard deviation
	*/
	private static double getStdDev(int[] input)
	{
		double stdDev = 0.0;
		int n = input.length;
		
		if(n == 0) return 0.0;
		else
		{
			double ave = getAverage(input);
			
			for(int ii = 0; ii < n; ++ii)
			{
				stdDev += (input[ii] - ave) * (input[ii] - ave);
			}
			
			return Math.sqrt(stdDev / n);
		}
	}
	
	
	/**
	* This method prints out the average of input
	* @param input This parameter takes in an array of ints
	*/
	private static void printAverage(int[] input)
	{
		System.out.println("\nThe average of the " + input.length + " integers is " + getAverage(input));
	}
	
	/**
	* This method prints out the standard deviation of input
	* @param input This parameter takes in input
	*/
	private static void printStdDev(int[] input)
	{
		System.out.println("\nThe Standard Deviation of the " + input.length + " integers is " + getStdDev(input));
	}
	
	/**
	* This method prints out the square root.
	* @param input This parameter takes in an array of ints
	*/
	private static void printSquareRoots(int[] input)
	{
		System.out.println("\nn\tNewtonRaphson    \tMath.sqrt        \tDifference\n");
		
		for(int ii = 0; ii < input.length; ++ii)
		{
			double v1 = NewtonRaphsonSqrt(input[ii]);
			double v2 = Math.sqrt(input[ii]);
			
			System.out.println(input[ii] + "\t" + v1 + "\t" + v2 + "\t" + (v1 - v2));
		}
	}
	
	/**
	* This method generates the square root.
	* @param n This parameter takes in a double
	* @return This returns the answer
	*/
	private static double NewtonRaphsonSqrt(double n)
	{
		final int MAX_TRIES = 10000000;
		final double EPS = 0.0000001;
		
		double answer = n / 2.0;
		int tries = 0;
		
		while(Math.abs(answer * answer - n) > EPS && tries < MAX_TRIES)
		{
			answer = answer - ((answer * answer - n)/(2 * answer));
			++tries;
		}
		
		return answer;
	}
	
	
	
}
