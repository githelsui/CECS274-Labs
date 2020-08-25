//Kearne Permalino 9639
//Githel Suico 7852

/**
 * 
 * @author Kearne Permalino
 * @author Githel Suico
 */
public class Circle {
	
	/**
	 * Create a Circle with center at (x,y) and given radius
	 * @param x x-coordinate of center
	 * @param y y-coordinate of center
	 * @param radius radius of circle
	 */
	public Circle(int x, int y, int radius)
	{
		this.center = new Point(x,y); 
		this.radius = radius; 
	}
	/**
	 * Create a Circle with the given center and radius
	 * @param center the circle's center
	 * @param radius the circle's radius
	 */
	public Circle(Point center, int radius)
	{
		this.center = new Point(center); 
		this.radius = radius; 
	}
	
	/**
	 * Create a new circle that is a copy of the given circle
	 * @param c the circle to duplicate
	 */
	public Circle(Circle c) 
	{
		this.center = new Point(c.getCenter());
		this.radius = c.getRadius();
	}
	/**
	 * Returns the center of the circle
	 * @return the circle's center
	 */
	public Point getCenter()
	{
		return this.center;
	}
	/**
	 * Returns the circle's radius
	 * @return the circle's radius
	 */
	public int getRadius()
	{
		return this.radius;
	}
	/**
	 * Move the circle by moving its center
	 * @param deltaX the X distance to move
	 * @param deltaY the Y distance to move
	 */
	public void move(int deltaX, int deltaY)
	{
		center.move(deltaX, deltaY);
	}
	/**
	 * Return the distance between the 2 circles' centers
	 * @param c2 the circle to get the distance to
	 * @return the distance between the 2 circles' centers
	 */
	public double getDistance(Circle c2)
	{
		return center.getDistance(c2.getCenter());
		
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if (!(obj instanceof Circle)) return false;
		Circle c2 = (Circle)obj;
		return center.equals(c2.getCenter()) && radius == c2.getRadius();
	}
	@Override
	public String toString()
	{
		return "Center: " + center.toString() + ", Radius: " + radius;
	}
	private int radius;   
	private Point center; 
}

