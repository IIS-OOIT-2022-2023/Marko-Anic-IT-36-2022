package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int width;
	private int height;

	
	public Rectangle() {
		
	}
	
	public Rectangle(Point upperLeftPoint, int width, int height) {
		
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}
	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
		this.selected = selected;
	}

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
	
	
	public String toString()
	{
		return "Upper left point:" + upperLeftPoint + ", width= " + width + ", height = " + height;
	}
	
	public boolean equals(Object obj)
	{
		if(obj instanceof Rectangle)
		{
			Rectangle pomocna  = (Rectangle) obj;
			if(this.upperLeftPoint.equals(pomocna.upperLeftPoint)  && this.width == pomocna.width && this.height == pomocna.height)
				return true;
			else 
				return false;
		}
		else 
			return false;
	}
	
	public boolean contains (int x, int y)
	{
		return (x >= upperLeftPoint.getX() && x <= upperLeftPoint.getX() + width 
				&& y >= upperLeftPoint.getY() && y<= upperLeftPoint.getY() + height) ;
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

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.black);
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);
		if(selected)
		{
			g.setColor(Color.blue);
		g.drawRect(upperLeftPoint.getX()-2,upperLeftPoint.getY()-2, 4,4);
		g.drawRect(upperLeftPoint.getX() + width-2,upperLeftPoint.getY()-2, 4,4);
		g.drawRect(upperLeftPoint.getX()-2,upperLeftPoint.getY() + height-2, 4,4);
		g.drawRect(upperLeftPoint.getX()-2 + width,upperLeftPoint.getY()-2 + height, 4,4);
		}
		}

}
