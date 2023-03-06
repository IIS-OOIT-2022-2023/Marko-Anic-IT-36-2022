package geometry;

public class Point {
	
	private int x;
	private int y;
	private boolean selected;
	
	public double distance(int x2,int y2)
	{
		int dx=x2-x;
		int dy=y2-y;
		double d = Math.sqrt(dx*dx+dy*dy);
		return d;
	}
	
	public int getX()
	{
		return x;
	}
	public void setX(int newX)
	{
		x = newX;	
	}
	public int getY()
	{
		return y;
	}
	public void setY(int newY)
	{
		y = newY;	
	}
	public boolean isSelected()
	{
		return selected;
	}
	public void setSelected(boolean newSelected)
	{
	selected = newSelected;	
	}
	
}
