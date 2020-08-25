//Githel Lynn Suico, 7852
//Kearne Permalino, 9639
/**
 * 
 * @author Githel Lynn Suico
 * @author Kearne Permalino
 *
 */
public class Cylinder {
	
	/**
	 * Construct a Cylinder with indicated top, bottom, and height
	 * @param top This parameter is for the top Circle
	 * @param bottom This parameter is for the bottom Circle
	 * @param height This parameter is for the height of the Cylinder
	 */
	public Cylinder(Circle top, Circle bottom, int height) {
		myTop = new Circle(top);
		myBottom = new Circle(bottom);
		myHeight = height;
	}
	
	/**
	 * Construct a Cylinder with indicated bottom, and height
	 * @param bottom This parameter is for the bottom Circle
	 * @param height This parameter is for the height of the Cylinder
	 */
	public Cylinder(Circle bottom, int height) {
		myTop = new Circle(bottom);
		myBottom = new Circle(bottom);
		myHeight = height;
	}
	
	/**
	 * Returns top Circle
	 * @return the top Circle
	 */
	public Circle getTop() {
		return myTop;
	}
	
	/**
	 * Returns the bottom Circle
	 * @return the bottom Circle
	 */
	public Circle getBottom() {
		return myBottom;
	}
	
	/**
	 * Returns the Cylinder's height
	 * @return height of the Cylinder
	 */
	public int getHeight() {
		return myHeight;
	}
	
	
	/**
	 * Moves the cylinder by moving its top and bottom by the indicated distances
	 * @param deltaX the distance to move in the X direction
	 * @param deltaY the distance to move in the X direction
	 */
	public void move(int deltaX, int deltaY) {
		myBottom.move(deltaX, deltaY);
		myTop.move(deltaX, deltaY);
	}
	
	/**
	 * Returns the distance between the 2 cylinders' tops
	 * @param cyl the cylinder to return to the distance to
	 * @return the distance between the 2 cylinders' tops
	 */
	public double getDistance(Cylinder cyl) {
		return myTop.getDistance(cyl.getTop());
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Cylinder)) return false;
		if(  myBottom == ((Cylinder)obj).getBottom() &&
			 myTop == ((Cylinder)obj).getTop() &&
			 myHeight == ((Cylinder)obj).getHeight()){
			 return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public String toString(){
		return "Top: " + myTop.toString() + ", Bottom: " + myBottom.toString() + ", Height: " + Integer.toString(myHeight);
	}
	
	private Circle myTop;
	private Circle myBottom;
	private int myHeight;
	
}
