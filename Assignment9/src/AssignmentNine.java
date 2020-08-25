import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class AssignmentNine 
{

	public static void main(String[] args) throws FileNotFoundException 
	{	
		Scanner input = new Scanner(new File(args[0]));
		BST tree = new BST();
		ArrayList<String> keys = new ArrayList<String>();
		
		boolean doRemoves = true;
		if(args.length < 2) doRemoves = false;
		
		produceOutput("Before Insertions: ", tree, "");
		
		while(input.hasNextLine())
		{
			String word = input.nextLine();
			tree.insert(word);
			keys.add(word);
		}
		input.close();
	
		produceOutput("After Insertions: ", tree, keys.get(3));
		
	
		if(doRemoves)
		{
			for(String key : keys)
			{
				tree.remove(key);
				produceOutput("After removing " + key + ": ", tree, key);
			}
		}
	}
	
	private static void produceOutput(String title, BST tree, String remember)
	{
		System.out.print("\n" + title);
		System.out.print("Number of keys in tree: " + tree.getCount());
		System.out.print("; Is 'cat' in tree? " + (tree.isPresent("cat") ? "Yes" : "No"));
		System.out.println("; Is " + remember + " in tree? " + (tree.isPresent(remember) ? "Yes" : "No"));

		tree.traverse(BST.TraversalType.PREORDER);
		tree.traverse(BST.TraversalType.INORDER);
		tree.traverse(BST.TraversalType.POSTORDER);
	}

}
