import java.util.ArrayList;
import java.util.Stack;


public class RecMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		String[] words = { "madam", "apple", "x", "radar" };
		
		for(String word : words)
		{
			System.out.println(word + " is" + 
								(isPalindrome(word) ? "" : " not") + " a palindrome");
			
			System.out.println(word + " reversed is " + reverse(word));
			System.out.println(word + " char count is " + getCount(word));
			System.out.println(word + " upper cased is " + upperCase(word));
			System.out.println();
		}
		
		for(int n = 1; n <= 10; n += 3)
		{
			if(n == 4) mShowMoves = true;
			else       mShowMoves = false;
			
			mN = n;
			System.out.println(n + " rings required " + doTowersOfHanoi() + " moves");
		}
	}
	
	private static boolean isPalindrome(String word)
	{
		if(word.length() <= 1) 
		{
			return true;
		}
		else if(word.charAt(0) != word.charAt(word.length() - 1))
		{
			return false;
		}
		else return isPalindrome(word.substring(1, word.length() - 1));
	}
	
	private static String reverse(String word)
	{
		if(word.length() <= 1) 
			return word;
		else 
			return word.charAt(word.length() - 1) + reverse(word.substring(0,word.length() - 1));
	}

	private static int getCount(String word)
	{
		if(word.length() <= 1) return word.length();
		else return 1 + getCount(word.substring(1));
	}
	
	private static String upperCase(String word)
	{
		if(word.length() <= 1) return word.substring(0,1).toUpperCase();
		else return word.substring(0,1).toUpperCase() + upperCase(word.substring(1));
	}
	
	private static int doTowersOfHanoi()
	{
		mCount = 0;
		
		// Create the towers
		tower1 = new ArrayList<Integer>();
		tower2 = new ArrayList<Integer>();
		tower3 = new ArrayList<Integer>();
				
		// Load all the rings onto tower one, values are their radii
		for(int ii = mN; ii >= 1; --ii) tower1.add(0, ii);
	
		printTowers("Initial");
		solveTowers(mN, tower1, tower2, tower3);
		printTowers("Final");
		
		return mCount;
		
		
	}
	
	private static void solveTowers(int n, ArrayList<Integer> from, ArrayList<Integer> to, ArrayList<Integer> work)
	{
		if(n == 1) move(from, to);
		else
		{
			solveTowers(n-1, from, work, to);
			move(from, to);
			solveTowers(n-1, work, to, from);
		}
	}
	
	private static void move(ArrayList<Integer> from, ArrayList<Integer> to)
	{
		int ring = from.get(0);
		from.remove(0);
		to.add(0, ring);
		++mCount;
		
		if(mShowMoves) printTowers("After a move");
	}
	
	private static void printTowers(String title)
	{
		ArrayList<ArrayList<Integer>> towers = new ArrayList<ArrayList<Integer>>();
		towers.add(tower1);
		towers.add(tower2);
		towers.add(tower3);
		
		sopnl("\nTowers (Top to Bottom), n = " + mN + ": " + title);
		for(int ii = 0; ii < 3; ++ii)
		{
			ArrayList<Integer> tower = towers.get(ii);
			sop("Tower " + (ii + 1) + ": ");
			for(int jj = 0; jj < tower.size(); ++jj)
			{
				sop(tower.get(jj) + " ");
			}
			sopnl("");
		}
	}
	
	private static void sopnl(String s)
	{
		System.out.println(s);
	}
	
	private static void sop(String s)
	{
		System.out.print(s);
	}
	
	// For Towers
	private static int mCount = 0;
	private static int mN;
	private static boolean mShowMoves = false;
	private static ArrayList<Integer> tower1;
	private static ArrayList<Integer> tower2;
	private static ArrayList<Integer> tower3;
}
