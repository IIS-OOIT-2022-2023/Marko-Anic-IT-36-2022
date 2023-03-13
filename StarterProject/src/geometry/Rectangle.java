package geometry;

public class Rectangle {
	private Point upperLeftPoint;
	private int width;
	private int height;
	private boolean selected;
	//P pravugaonika
	public int area()
	{
		return width*height;
	}
	//O pravugaonika
	public int circumference()
	{
		return 2*(width+height);
	}
	//metode get set
	public Point getUpperLeftPoint()
	{
		return this.upperLeftPoint;
	}
	public void setUpperLeftPoint(Point upperLeftPoint)
	{
		this.upperLeftPoint = upperLeftPoint;
	}
	public int getWidth()
	{
		return this.width;
	}
	public void setWidth(int width)
	{
		this.width = width;
	}
	public int getHeight()
	{
		return this.height;
	}
	public void setHeight(int height)
	{
		this.height = height;
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
