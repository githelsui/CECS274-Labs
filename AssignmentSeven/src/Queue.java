//Kearne Permalino 9639
//Githel Suico 7852
/**
 * 
 * @author Kearne Permalino
 * @author GIthel Suico
 */
public class Queue {
	
	/**
	 * Create an empty queue
	 */
	public Queue() {
		queue = new List();
	}
	
	/**
	 * Make item the rear of the queue
	 * @param item the item to be added
	 */
	public void add(String item) {
		queue.addToRear(item);
	}
	
	/**
	 * Remove the Top of the queue
	 * @return front of the queue
	 */
	public String remove() {
		String front = queue.getFront();
		queue.removeFront();
		return front;
	}
	
	/**
	 * Returns true if queue is empty, false otherwise
	 * @return true if queue is empty, false otherwise
	 */
	public boolean isEmpty() {
		return queue.askCount() == 0;
	}
	
	/**
	 * print the content of the Queue
	 */
	public void dump(String title) {
		queue.print(title);
	}
	
	private List queue;
}
