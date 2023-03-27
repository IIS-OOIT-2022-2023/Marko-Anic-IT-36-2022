package geometry;

public class Circle {
	private Point center;
	private int radius;
	private boolean selected;
	
	public Circle ()
	{
		
	}
	public Circle (Point center, int radius)
	{
		this.center = center;
		this.radius = radius;
	}
	public Circle (Point center, int radius, boolean selected)
	{
		this(center,radius);
		this.selected = selected;
	}
	// povrsina kruga p
	public double area()
	{
		return radius*radius*Math.PI;
	}
	//obim kruga
	public double circumference()
	{
		return 2 * radius*Math.PI;
	}
	
	public String toString()
	{
		return "Center: "  + center +" , radius = " + radius;
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Circle)
		{
			Circle pomocna  = (Circle) obj;
			if(this.center.equals(pomocna.center)  && this.radius == pomocna.radius)
				return true;
			else 
				return false;
		}
		else 
			return false;
	}
	public boolean contains (int x, int y)
	{
		return center.distance(x, y) <=radius;
	}
	
	public boolean contains( Point p)
	{
		return center.distance(p.getX(), p.getY()) <= radius;
	}
	// get,set
	public Point getCenter()
	{
		return this.center;
	}
	public void setCenter(Point center)
	{
		this.center = center;
	}
	public int getRadius()
	{
		return this.radius;
	}
	public void setRadius(int radius)
	{
		this.radius = radius;
	}
	public boolean isSelected()
	{
		return this.selected;
	}
	public void setSelected(boolean selected)
	{
		this.selected = selected;
	}
	
}
