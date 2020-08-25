
public class AssignmentTwo 
{

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		Point p1 = new Point(0,0);
		Point p2 = new Point(p1);
		sop("\nPoints\n");
		doPoints(p1, p2);

		Circle c1 = new Circle(5, 5, 1);
	    Circle c2 = new Circle(p1, 5); //(5,5) r=5
	    Circle c3 = new Circle(c2); //same as c2
	    sop("\nCircles\n");
		doCircles(c1,c2,c3);
		
		Cylinder cyl1 = new Cylinder(c1, c2, 10);
		Cylinder cyl2 = new Cylinder(c3, 5);
		sop("\nCylinders\n");
		doCylinders(cyl1, cyl2);

	}

	private static void sop(String s)
	{
		System.out.println(s);
	}
	
	private static void doPoints(Point p1, Point p2)
	{
		doPoint(p1,p2);
	    
		sop("Move p2 by (5,5)");
	    p2.move(5, 5);
	    
	    doPoint(p1,p2);
	    
	}
	
	private static void doPoint(Point p1, Point p2)
	{
		sop("Point p1 is " + p1);
		sop("Point p2 is " + p2);
		
	    sop("p1 == p2? " + p1.equals(p2));
	    
	    sop("Distance between p1 & p2 is " + p1.getDistance(p2));
	    
	    sop("The Polar Coordinate of p1 is " + p1.getPolarCoordinates());
	    sop("The Polar Coordinate of p2 is " + p2.getPolarCoordinates());
	    
	    sop("X of p1 is " + p1.getX() + ", Y of p1 is " + p1.getY());
	    sop("X of p2 is " + p2.getX() + ", Y of p2 is " + p2.getY());
	}
	
	private static void doCircles(Circle c1, Circle c2, Circle c3)
	{
	    doCircle(c1,c2,c3);
	    
	    sop("Move c2 by (3,6)");
	    c2.move(3,6);
	    
	    doCircle(c1,c2,c3);
	}
	
	private static void doCircle(Circle c1, Circle c2, Circle c3)
	{
		sop("Circle c1 is " + c1);
	    sop("Circle c2 is " + c2);
	    sop("Circle c3 is " + c3);
	    
	    sop("c1 == c2? " + c1.equals(c2));
	    sop("c1 == c3? " + c1.equals(c3));
	    sop("c2 == c3? " + c2.equals(c3));

	    sop("c1 center is " + c1.getCenter());
	    sop("c2 radius is " + c2.getRadius());
	    
	    sop("Distance from c1 to c2 is " + c1.getDistance(c2));
	    sop("Distance from c1 to c3 is " + c1.getDistance(c3));
	    sop("Distance from c2 to c3 is " + c2.getDistance(c3));
	}
		
	
	private static void doCylinders(Cylinder cyl1, Cylinder cyl2)
	{
		doCylinder(cyl1, cyl2);
		
		sop("Move cyl1 by (-2, -3)");
		cyl1.move(-2, -3);
		
		doCylinder(cyl1, cyl2);

	}
	
	private static void doCylinder(Cylinder cyl1, Cylinder cyl2)
	{
		sop("Cylinder cyl1 is " + cyl1);
		sop("Cylinder cyl2 is " + cyl2);
		
		sop("cyl1 == ccyl? " + cyl1.equals(cyl1));
		sop("cyl1 == cyl2? " + cyl1.equals(cyl2));
	    
		sop("Top of cyl1 1 is " + cyl1.getTop());
		sop("Bottom of cyl1 is " + cyl1.getBottom());
		sop("Height of cyl1 is " + cyl1.getHeight());
		
		sop("Distance from cyl1 to cyl1 is " + cyl1.getDistance(cyl1));
		sop("Distance from cyl1 to cyl2 is " + cyl1.getDistance(cyl2));
		
	}
}