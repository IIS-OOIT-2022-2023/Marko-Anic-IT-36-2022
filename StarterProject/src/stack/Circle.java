package stack;

import javax.swing.JOptionPane;

public class Circle {
	private int x;
	private int y;
	private double radius;
	
	public Circle()
	{
		
	}
	public Circle (int x, int y, double radius)
	{
		this.x = x;
		this.y = y;
		setRadius(radius);
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		if(radius >0) {
			this.radius = radius;
			}
		else
		{
		radius=0;	
	}
}
	
	
	@Override
	public String toString() {
		return "x=" + this.x + ", y = " + this.y +", radius=" + this.radius;
	}
}
