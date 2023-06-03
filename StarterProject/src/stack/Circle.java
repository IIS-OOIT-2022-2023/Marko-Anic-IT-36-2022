package stack;

public class Circle {
	private int x;
	private int y;
	private int radius;
	
	public Circle()
	{
		
	}
	public Circle (int x, int y, int radius)
	{
		this.x = x;
		this.y = y;
		this.radius= radius;
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
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		if(this.radius >0) 
			this.radius = radius;
		else
			System.out.println("Radius ne moze biti manji od nule!");
	}
	
	
	@Override
	public String toString() {
		return "x=" + this.x + ", y = " + this.y +", radius=" + this.radius;
	}
}
