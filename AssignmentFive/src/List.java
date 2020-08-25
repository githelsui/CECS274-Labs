import java.util.ArrayList;
import java.util.Arrays;
//Kearne Permalino 9639
//Githel Suico 7852

/**
 * 
 * @author Kearne Permalino
 * @author Githel Suico
 */

public class List {
	
	/**
	 * Create an empty List with a maximum of size elements.
	 * @param size the number of elements for the list
	 */
	public List(int size) {
		mList = new ArrayList<String>(size);
		mCount = 0;   
		mSize = size;
	}
	
	/**
	 * Create a new List that is a copy of the list input.
	 * @param list the List to copy
	 */
	public List(List list) {
		mCount = list.mCount;
		mList = new ArrayList<String>(list.mSize);
		if(list.mCount != 0) {
			for(int i = 0; i < list.mCount; i++) {
				mList.add(new String(list.mList.get(i)));
			}
		}
	}
	
	/**
	 * Item becomes the new front element
	 * @param item the item to add
	 */
	public void addToFront(String item) {
		if(mSize != mCount) {
			mList.add(0, item);
			mCount++;	
		}
		else {
			System.out.println("List Full");
		}
	}
	
	/**
	 * Item becomes the new rear element
	 * @param item the item to add
	 */
	public void addToRear(String item) {
		if(mSize != mCount) {
			mList.add(item);
			mCount++;
		}
		else {
			System.out.println("List Full");
		}
	}
	
	/**
	 * If beforeItem is not in List, prints "Item Not Found" else add item in List before beforeItem
	 * @param beforeItem the item in the list to add item before
	 * @param item the item to add
	 */
	public void addBeforeItem(String beforeItem, String item) {
		if(isPresent(beforeItem)) {
			if(mCount != mSize) {
				int beforeItemIndex = findIndex(beforeItem);
				mList.add(beforeItemIndex, item);
				mCount++;
			}
			else {
				System.out.println("List Full");
			}
		}
		else {
			System.out.println("Item not Found");
		}
	}
	
	/**
	 * Item becomes the element after afterItem
	 * @param afterItem the item in the list to add item before
	 * @param item the item to add
	 */
	public void addAfterItem(String afterItem, String item) {
		if(isPresent(afterItem)) {
			if(mCount != mSize) {
				int afterItemIndex = findIndex(afterItem);
				mList.add(afterItemIndex+1, item);
				mCount++;
			}
			else {
				System.out.println("List Full");
			}
		}
		else {
			System.out.println("Item not Found");
		}
	}
	
	/**
	 * Returns the item at the front of the List (List is not altered)
	 * @return the item at the front of the list
	 */
	public String getFront() {
		return mList.get(0);
	}
	
	/**
	 * Returns the item at the rear of the List (List is not altered)
	 * @return the item at the rear of the List
	 */
	public String getRear() {
		return mList.get(mCount-1);
	}
	
	/**
	 * Returns true if item is in List, false otherwise
	 * @param item to check presence in List
	 * @return true if item is in List, false otherwise
	 */
	public boolean isPresent(String item) {
		return mList.contains(item);
	}
	
	/**
	 * Returns the number of items in the List
	 * @return the number of items in the List
	 */
	public int askCount() {
		return mCount;
	}
	
	/**
	 * If the List is empty, prints "List Empty" If the List is not empty, removes the item at the front of the List
	 */
	public void removeFront() {
		if (mCount == 0) System.out.println("List Empty");
		else {
			mList.remove(0);
			mCount--;
		}
	}
	
	/**
	 * If the List is empty, prints "List Empty" If the List is not empty, removes the item at the rear of the List
	 */
	public void removeRear() {
		if (mCount == 0) System.out.println("List Empty");
		else {
			mList.remove(mCount-1);
			mCount--;
		}
	}
	
	/**
	 * If the List is empty, prints "List Empty" If item is not present in List, prints "Item not found" Otherwise, item is removed from the List
	 * @param item the item to remove
	 */
	public void removeItem(String item) {
		if (mCount == 0) System.out.println("List Empty");
		else {
			int indexToRemove = findIndex(item);
			
			if(indexToRemove == -1) {
				System.out.println("Item not found");
			}
			else {
				mList.remove(indexToRemove);
				mCount--;
			}
		}
	}
	
	/**
	 * Print title on a line by itself Prints the list from front to rear with one space between each item
	 * @param title the description of the List
	 */
	public void print(String title) {
		System.out.println(title);
		for (String s : mList) {
			if(s != null)
				System.out.print(s + " ");
		}
		System.out.println();
	}
	
	/**
	 * Print title on a line by itself Prints the Sorted List with 1 space between each item Does not alter the List
	 * @param title the description of the List
	 */
	public void printSorted(String title) {
		String[] sortedList = new String[mCount];
		//Can we use the sort method from Arrays class -> Arrays.sort(list);
		
		for (int i = 0; i < mCount; i++) {
				sortedList[i] = new String(mList.get(i));
				//System.out.println("index: " + i + "  size: " + mCount);
		}
		
		Arrays.sort(sortedList);
		
		System.out.println(title);
		for (String s : sortedList) {
			if(s != null)
				System.out.print(s + " ");
		}
	}
	
	private int findIndex(String item) {
		for (int i = 0; i < mCount; i++) {
			if (mList.get(i).equals(item)) return i; 
		}
		return -1;	
	}
	
	private ArrayList<String> mList;
	private int mSize;
	private int mCount;

}
