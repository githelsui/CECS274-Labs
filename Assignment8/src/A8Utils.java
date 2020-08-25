//Kearne Permalino 9639
//Githel Suico 7852
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
/**
 * 
 * @author Kearne Permalino
 * @author Githel Suico
 */
public class A8Utils 
{
	boolean isFirst = true;
	int min = 0;
	// Print out 'n' *'s on the same line
	public void printStars(int n) {
		if (isFirst) {
			System.out.print(n + " stars: ");
			isFirst = false;
		}
		if (n == 0) {
			isFirst = true;
			System.out.println("");
		}
		else {
			System.out.print("*");
			printStars(n-1);
		} 
	}
	
	
	
	
	// Return the minimum of the array
	public int min(int[] numbers) {
		int min = 0;
		int index = 0;
		if (numbers.length == 1) min = numbers[0];
		if (numbers[index] < min) min = numbers[index];
		index = index + 1;
		
		return min;
	
		
	
	

//			for (int i = 0; i < numbers.length; i++) {
//				if (numbers[i] < min) 
//					min = numbers[i];
//			}
//		}
//		return min;
}
	
//	private static int findMin(int index) {
//		if (numbers[index])
//	}

	// Return Yes if pattern is found in target, No otherwise
	public String isIn(String pattern, String target) {
		if (target.length() < pattern.length()) return "No";
		if (target.substring(0,pattern.length()).equals(pattern)) return "Yes";
		target = target.substring(1,target.length());
		return isIn(pattern, target);
	}

	// Print all the permutations of word
	public void permutations(String word) {
		ArrayList<String> newArr = createArray(word);
		System.out.println("The " + countNumberOfPerms(word) + " permutations of " + word + " sorted are: ");
		perms(newArr, 0, word.length()-1);
		System.out.println();
	}
	
	// Return the number of permutations of word
	public int countNumberOfPerms(String word) {
		ArrayList<String> newArr = createArray(word);
		return permCount(newArr, 0, word.length()-1);
	}

	
	private void perms(ArrayList<String> word, int start, int end) {
		if(start == end) {
			System.out.print(convertToStr(word) + " ");
		}
		else {
			for(int i = start; i <= end; i++) {
				Collections.swap(word, start, i);
				perms(word, start + 1, end);
				Collections.swap(word, start, i);
			}
		}
	}
	
	private int permCount(ArrayList<String> word, int start, int end) {
		if(start == end) return 1;
		else {
			for(int i = start; i <= end; i++) {
				Collections.swap(word, start, i);
				perms(word, start + 1, end);
				Collections.swap(word, start, i);
			}
		}
		return permCount(word, start, end) + permCount(word, start, end);
	}
}


/*
{
   firstTerm = true;
   static String perm = "";
   static int no_of_perm = 0;

   // Print out 'n' *'s on the same line
   public void printStars(int n) {
       if(firstTerm) {
           System.out.print( n + " Stars: ");
           firstTerm = false;
       }
       if(n != 0) {
           System.out.print("*");
           printStars(n-1);
       } else {
           firstTerm = true;
           System.out.println("");
       }
   }
  
   // Return the minimum of the array
   public int min(int[] numbers) {
       int min = 0;
      
       if(numbers.length > 0)
           min = numbers[0];
          
       for(int i=1; i<numbers.length; i++) {
           if(numbers[i] < min)
               min = numbers[i];
       }
      
       return min;
   }
  
   // Return Yes if pattern is found in target, No otherwise
   public String isIn(String pattern, String target) {
       String is_in = "No";
      
       is_in = target.contains(pattern) ? "Yes" : "No";
      
       return is_in;
   }
  
   // Print all the permutations of word
   public void permutations(String word) {
       no_of_perm = 0;
       perm = "";
       perm = permutations("", word);
       System.out.println("The " + no_of_perm + " permutations of " + word + " sorted are:");
       System.out.print(perm);
   }
  
   private static String permutations(String prefix, String word) {
       int n = word.length();
      
       if (n == 0) {
           perm = perm + prefix + " ";
           no_of_perm ++;
       } else {
           for (int i = 0; i < n; i++)
               permutations(prefix + word.charAt(i), word.substring(0, i) + word.substring(i+1, n));
       }
       return perm;
   }

   // Return the number of permutations of word
   public void countNumberOfPerms(String word){
       perm = "";
       perm = permutations("", word);
       System.out.println("\nThe number of permutations of " + word + " is " + no_of_perm);
   }
   
}*/