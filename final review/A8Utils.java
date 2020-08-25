import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class A8Utils
{
	private final boolean DEBUG = true;
	private String spaces = "";

	public A8Utils()
	{

	}

	public void printStars(int n)
	{
		System.out.print(n + " stars: ");
		printStarsRec(n);					// Call to recursive function
	}

	public int min(int[] numbers)
	{
		if(numbers.length == 1) return numbers[0];
		else
		{
			int m = min(Arrays.copyOfRange(numbers, 1, numbers.length));
			if(numbers[0] < m)
				return numbers[0];
			else return m;
		}
	}

	public boolean isIn(String pattern, String target)
	{
		int lenPattern = pattern.length();

		if(lenPattern > target.length()) return false;
		if(target.substring(0, lenPattern).equals(pattern)) return true;
		else return isIn(pattern, target.substring(1));
	}

	public void permutations(String word)
	{
		System.out.println("The " + factorial(word.length()) + " permutations of " + word + " sorted are:");
		ArrayList<String> answer = new ArrayList<String>();

		spaces = "";
		getPermsRec(word, "", answer);

		Collections.sort(answer);
		for(String s : answer)
		{
			System.out.print(s + " ");
		}
		System.out.println();
	}

	public void countNumberOfPerms(String word)
	{
		System.out.println("The number of permutations of " + word + " is " + factorial(word.length()));

	}

	private void getPermsRec(String str, String partial, ArrayList<String> answer)
	{
		if(DEBUG)
		{
			System.out.println(spaces + "getPermsRec(" + str + ", " + partial + ", size answer: " + answer.size());
			spaces += "   ";
		}

		if(str.length() == 0)
		{
			answer.add(partial);
			spaces = spaces.substring(3);
			return;
	    }

	    for(int i = 0; i < str.length(); i++)
	    {
	    	char ch = str.charAt(i);

	        // Remove ith character
	        String removed = str.substring(0, i) + str.substring(i + 1);
	        getPermsRec(removed, partial + ch, answer);
	    }
	}

	private void printStarsRec(int n)
	{
		if(n == 0) System.out.println();
		else
		{
			System.out.print("*");
			printStarsRec(n - 1);
		}
	}

	private int factorial(int n)
	{
		if(n <= 1) return 1;
		else return n * factorial(n-1);
	}
}
