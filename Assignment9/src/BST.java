//Kearne Permalino 9639
//Githel Suico 7852
/**
 * 
 * @author Kearne Permalino
 * @author Githel Suico
 */
public class BST {
	/**
	 * Create an empty BST
	 */
	public BST() {
		mRoot = null;
	}
	
	/**
	 * Insert data into BST
	 * @param key String to be added
	 */
	public void insert(String key) {	
		if (mRoot == null) mRoot = new Node(key);
		else mRoot.insert(key);
	}
	
	/**
	 * Returns true if key is in BST, false otherwise
	 * @param key to check present in BST
	 * @return true if key is in BST, false otherwise.
	 */
	public boolean isPresent(String key) {
		if (mRoot == null) return false;
		return mRoot.isPresent(mRoot, key);
	}
	
	/**
	 * Traverses through BST
	 * @param type the kind of traversal
	 */
	public void traverse(TraversalType type) {
		System.out.println("\n" + type + " tree traversal");
		if (mRoot == null) return;
		mRoot.traverse(type);
		System.out.println();
	}
	
	/**
	 * Returns number of elements in BST
	 * @return number of elements in BST
	 */
	public int getCount() {
		if (mRoot == null) return 0;
		return mRoot.getCount(mRoot);
	}
	
	/**
	 * Item is removed from BST
	 * @param key the item to remove
	 */
	public void remove(String key) {
		
	}
	
	private class Node {
		/**
		 * Constructs a new Node
		 * @param key the String element of the Node
		 */
		public Node(String key) {
			mLeft = mRight = null;
			mData = key;
		}
		
		
		private void preOrder() {
			visit();
			if (mLeft != null) mLeft.preOrder();
			if (mRight != null) mRight.preOrder();
		}
		
		
		private void inOrder() {
			if (mLeft != null) mLeft.inOrder();
			visit();
			if (mRight != null) mRight.inOrder();
		}
		

		private void postOrder() {
			if (mLeft != null) mLeft.postOrder();
			if (mRight != null) mRight.postOrder();
			visit();
		}
		
		
		private void traverse(TraversalType order) {
			if (order == BST.TraversalType.PREORDER) preOrder();
			if (order == BST.TraversalType.INORDER) inOrder();
			if (order == BST.TraversalType.POSTORDER) postOrder();	
		}
		
		private void visit() {
			System.out.print(mData + " ");
		}
		
		private void insert(String key) {
			if (key.compareTo(mData) < 0) {
				if (mLeft == null) {
					mLeft = new Node(key);
				}
				else mLeft.insert(key);
			}
			else {
				if (mRight == null) {
					mRight = new Node(key);
				}
				else mRight.insert(key);
			}
		}
		
		private int getCount(Node node) {
			int count = 1;
			if (node.mLeft != null) {
				count += node.getCount(node.mLeft);
			}
			if (node.mRight != null) {
				count += node.getCount(node.mRight);
			}
			return count;
		}
		
		private boolean isPresent(Node node, String key) {
			if (node == null) return false;
			else if (node.mData.equals(key)) return true;
			else if (node.mData.compareTo(key) < 0) {
				if (mLeft == null) {
					return false;
				}
				else {
					return mLeft.isPresent(mRight, key);
				}
			}
			else if (node.mData.compareTo(key) > 0) {
				if (mRight == null) {
					return false;
				}
				else {
					return mRight.isPresent(mLeft, key);
				}
			}
			return false;
		}
	
		
		private Node mLeft, mRight;
		private String mData;
	}
	private Node mRoot;
	public static enum TraversalType { PREORDER, INORDER, POSTORDER };
} 
