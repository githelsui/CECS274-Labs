//Kearne Permalino 9639
//Githel Suico 7852
/**
 * 
 * @author Kearne Permalino
 * @author GIthel Suico
 */
public class Stack {
	
	/**
	 * Create an empty Stack
	 */
	public Stack() {
		stack = new List();
	}
	
	/**
	 * Make item the Top of the Stack
	 * @param item the item to be added
	 */
	public void push(String item) {
		stack.addToFront(item);
	}
	
	/**
	 * Remove the Top of the Stack
	 */
	public void pop() {
		stack.removeFront();
	}
	
	/**
	 * Returns the Top of the Stack, but does not remove it.
	 * @return item at the top of the Stack
	 */
	public String getTop() {
		return stack.getFront();
	}
	
	/**
	 * Returns true if Stack is empty, false otherwise
	 * @return true if Stack is empty, false otherwise
	 */
	public boolean isEmpty() {
		return stack.askCount() == 0;
	}
	
	private List stack;
}
