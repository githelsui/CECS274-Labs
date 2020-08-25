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
	 * Create a empty List with no maximum size. 
	 */
	public List() {
		mFront = new Node("Dummy");
		mRear = new Node("Dummy");
		mCount = 0;
		mFront.mNext = mRear;
		mRear.mPrev = mFront;
	}
	
	/**
	 * Constructs a new List with the items in the input list.
	 * @param list the List to copy
	 */
	public List(List list) {
		mFront = new Node("Dummy");
		mRear = new Node("Dummy");
		
		Node original = list.mFront;
		Node copy = mFront;
		for(int i = 0; i < list.mCount; i++) {
			Node toBeCopied = new Node(original.mNext.mData);
			copy.mNext = toBeCopied;
			toBeCopied.mPrev = copy;
			original = original.mNext;
			copy = copy.mNext; 
		}
		copy.mNext = mRear;
		mRear.mPrev = copy;
		mCount = list.mCount;
	}
	
	/**
	 * Item becomes the new front element
	 * @param item the item to add
	 */
	public void addToFront(String item) {
		
		Node newFront = new Node(item);
		Node oldFront = mFront.mNext;
		mFront.mNext = newFront;
		newFront.mNext = oldFront;
		newFront.mPrev = mFront;
		oldFront.mPrev = newFront;
		mCount++;
	}
	
	/**
	 * Item becomes the new rear element
	 * @param item the item to add
	 */
	public void addToRear(String item) {
		Node newRear = new Node(item);
		Node oldRear = mRear.mPrev;
		mRear.mPrev = newRear;
		newRear.mNext = mRear;
		oldRear.mNext = newRear;
		newRear.mPrev = oldRear;
		mCount++;
	}
	
	/**
	 * If beforeItem is not in List, prints "Item Not Found" else add item in List before beforeItem
	 * @param beforeItem the item in the list to add item before
	 * @param item the item to add
	 */
	public void addBeforeItem(String beforeItem, String item) {
		Node before = find(beforeItem);
		if (before == null) {
			System.out.println("Item Not found");
			return;
		}
		Node newNode = new Node(item);
		newNode.mPrev = before.mPrev;
		newNode.mNext = before;
		newNode.mNext.mPrev = newNode;
		newNode.mPrev.mNext = newNode;
		mCount++;
	}
	
	/**
	 * Item becomes the element after afterItem
	 * @param afterItem the item in the list to add item before
	 * @param item the item to add
	 */
	public void addAfterItem(String afterItem, String item) {
		Node after = find(afterItem);
		if (after == null) {
			System.out.println("Item Not found");
			return;
		}
		Node newNode = new Node(item);
		newNode.mNext = after.mNext;
		after.mNext = newNode;
		newNode.mPrev = after;
		if (newNode.mNext != null) {
			newNode.mNext.mPrev = newNode;
		}
		mCount++;
	}
	
	/**
	 * Returns the item at the front of the List (List is not altered)
	 * @return the item at the front of the list
	 */
	public String getFront() {
		return mFront.mNext.mData;
	}
	
	/**
	 * Returns the item at the rear of the List (List is not altered)
	 * @return the item at the rear of the List
	 */
	public String getRear() {
		return mRear.mPrev.mData;
	}
	
	/**
	 * Returns true if item is in List, false otherwise
	 * @param item to check presence in List
	 * @return true if item is in List, false otherwise
	 */
	public boolean isPresent(String item) {
		Node temp = mFront;
		while (temp != null) {
			if (item.equals(temp.mData)) {
				return true;
			}
			temp = temp.mNext;
		}
		return false;
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
		if (mCount != 0) {
			Node temp = mFront.mNext.mNext;
			mFront.mNext = temp;
			temp.mPrev = mFront;
			mCount--;
		}
		else {
			System.out.println("List Empty");
		}
	}
	
	/**
	 * If the List is empty, prints "List Empty" If the List is not empty, removes the item at the rear of the List
	 */
	public void removeRear() {
		if (mCount != 0) {
			Node temp = mRear.mPrev.mPrev;
			mRear.mPrev = temp;
			temp.mNext = mRear;
			mCount--;
		}
		else {
			System.out.println("List Empty");
		}
	}
	
	/**
	 * If the List is empty, prints "List Empty" If item is not present in List, prints "Item not found" Otherwise, item is removed from the List
	 * @param item the item to remove
	 */
	public void removeItem(String item) {
		Node where = find(item);
		if (mCount == 0) {
			System.out.println("List Empty");
			return;
		}
		else if (where == null) {
			System.out.println("Item Not Found");
			return;
		}
		else {
			Node previous = where.mPrev;
			Node next = where.mNext;
			previous.mNext = next;
			next.mPrev = previous;
			mCount--;
		}
	}
	
	/**
	 * Print title on a line by itself Prints the list from front to rear with one space between each item
	 * @param title the description of the List
	 */
	public void print(String title) {
		System.out.println("\n" + title);
		Node last = mFront.mNext;
		while (last != mRear) {
			System.out.print(last.mData + " ");
			last = last.mNext;
		}
		System.out.println();
	}
	
	/**
	 * Print title on a line by itself Prints the Sorted List with 1 space between each item Does not alter the List
	 * @param title the description of the List
	 */
	public void printSorted(String title) {
		System.out.println("\n" + title);
		String[] temp = new String[mCount];
		Node current = mFront.mNext;
		
		for(int i = 0; i < mCount; i++) {
			temp[i] = current.mData;
			current = current.mNext;
		}
		
		Arrays.sort(temp);
		
		for(int i = 0; i < mCount; i++) {
			System.out.print(temp[i] + " ");
		}
		System.out.println();
	}
	
	private class Node {
		
		/**
		 * Constructs a new Node with the provided String element
		 * @param key the String element of the Node
		 */
		public Node(String key) {
			mPrev = mNext = null;
			mData = key;
		}
		
		private Node mPrev, mNext;
		private String mData;
	}
	
	private Node find(String key) {
		Node temp = mFront;
		Node found = null;
		while (temp != null) {
			if (key.equals(temp.mData)) {
				found = temp;
			}
			temp = temp.mNext;
		}
		return found;
	}
	
	private Node mFront, mRear;
	private int mCount;
}
