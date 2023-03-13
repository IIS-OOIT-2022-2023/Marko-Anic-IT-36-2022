package geometry;

public class Circle {
	private Point center;
	private int radius;
	private boolean selected;
	
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
