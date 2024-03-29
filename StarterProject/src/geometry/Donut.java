package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;

	public Donut() {
		super();
	}

	@Override
	public String toString() {
		// Center:(x,y), radius = 55, innerradius =44
		return super.toString() + ", innerRadius = " + this.innerRadius;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			if (getCenter().equals(pomocna.getCenter()) && this.getRadius() == pomocna.getRadius()
					&& this.innerRadius == pomocna.innerRadius)
				return true;
			else
				return false;
		} else
			return false;

	}

	@Override
	public boolean contains(int x, int y) {
		// TODO Auto-generated method stub
		return super.contains(x, y) && getCenter().distance(x, y) >= innerRadius;
	}

	@Override
	public boolean contains(Point p) {
		// TODO Auto-generated method stub
		return super.contains(p) && getCenter().distance(p.getX(), p.getY()) >= innerRadius;
	}

	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		setInnerRadius(innerRadius);
		
		
	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		super(center, radius, selected);
		setInnerRadius(innerRadius);
		
	}

	@Override
	public double area() {
		return super.area() - innerRadius * innerRadius * Math.PI;
	}

	@Override
	public double circumference() {

		return super.circumference() + 2 * innerRadius * Math.PI;
	}

	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		if (innerRadius < 0)
			throw new IllegalArgumentException("Inner radius can not be negative!");
		if(innerRadius >= super.getRadius())
			throw new IllegalArgumentException("Inner radius cannot be bigger than radius!");
		this.innerRadius = innerRadius;

	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		super.draw(g); // spoljasnji krug

		g.setColor(Color.white);
		g.fillOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, 2 * innerRadius,
				2 * innerRadius);

		g.setColor(getEdgeColor());
		g.drawOval(getCenter().getX() - innerRadius, getCenter().getY() - innerRadius, 2 * innerRadius,
				2 * innerRadius);

		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - 2 - innerRadius, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - 2 + innerRadius, 4, 4);
		}
	}

	public int compareTo(Object o) {
		if (o instanceof Donut)
			return (int) (this.area() - ((Donut) o).area());
		return 0;
	}
}
