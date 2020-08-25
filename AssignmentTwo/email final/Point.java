//Githel Lynn Suico, 7852
//Kearne Permalino, 9639
/**
 * 
 * @author Kearne Permalino
 * @author Githel 
 * Point - Two dimensional points
 *
 */
public class Point 
{
	/**
	 * Construct a Point at the indicated coordinates
	 * @param x the X coordinate
	 * @param y the Y coordinate
	 */
	public Point(int x, int y)
	{
		mX = x;
		mY = y;
	}
	
	/**
	 * Construct a Point located at the coordinates as the given Point
	 * @param p the Point whose location is to be duplicated
	 */
	public Point(Point p)
	{
		mX = p.getX();
		mY = p.getY();
	}
		
	/**
	 * Move a point as indicated
	 * @param deltaX distance to move in X direction
	 * @param deltaY distance to move in Y direction
	 */
	public void move(int deltaX, int deltaY)
	{
		mX += deltaX;
		mY += deltaY;
	}
	
	/**
	 * Compute the Euclidean distance between 2 points
	 * @param p2 the point to compute the distance from the given point
	 * @return the distance
	 */
	public double getDistance(Point p2)
	{
		int xdiff = (mX - p2.getX());
		int ydiff = (mY - p2.getY())
		;
		return Math.sqrt((xdiff * xdiff) + (ydiff * ydiff));
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(!(obj instanceof Point)) return false;
		
		Point p2 = (Point)obj;
		return mX == p2.getX() && mY == p2.getY();
	}
	
	@Override
	public String toString()
	{
		return "(" + mX + "," + mY + ")";
	}
	
	/**
	 * Returns the Point's X coordinate
	 * @return the Point's X coordinate
	 */
	public int getX()
	{
		return mX;
	}
	
	/**
	 * Returns the Point's Y coordinate
	 * @return the Point's Y coordinate
	 */
	public int getY()
	{
		return mY;
	}
	
	/**
	 * Returns the Polar Coordinate representation of the Point
	 * @return (rho, theta) polar coordinates of Point
	 */
	public String getPolarCoordinates()
	{
		return "(" + getR() + "," + getTheta() + ")";
	}
	
/**
 * Returns the Radius
 * @return radius
 */
	private double getR()
	{
		Point origin = new Point(0,0);
		return getDistance(origin);
	}
	

	/*
	 * Returns the theta
	 * @return returns theta
	 */
	private double getTheta()
	{
		final double RADTODEG = 360.0 / (2 * Math.PI);
		double radians = Math.atan2(getY(), getX());
		
		return radians * RADTODEG; 
	}
	
	private int mX;
	private int mY;
}
