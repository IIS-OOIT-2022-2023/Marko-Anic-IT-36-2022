package geometry;

public class Line {
	
	private Point startPoint;
	private Point endPoint;
	private boolean selected;
	
	//duzina linije
	public double lenght()
	{
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	//metode pristupa / get /set
	
	public Point getStartPoint()
	{
		return this.startPoint;
	}
	public void setStartPoint(Point startPoint)
	{
		this.startPoint = startPoint;
	}
	public Point getEndPoint()
	{
		return this.endPoint;
	}
	public void setEndPoint(Point endPoint)
	{
		this.endPoint = endPoint;
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
