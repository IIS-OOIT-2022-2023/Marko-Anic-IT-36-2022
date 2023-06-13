package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Circle extends Shape {
	private Point center;
	private int radius;

	public Circle() {

	}

	public Circle(Point center, int radius) {
		this.center = center;
		setRadius(radius);
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}

	// povrsina kruga p
	public double area() {
		return radius * radius * Math.PI;
	}

	// obim kruga
	public double circumference() {
		return 2 * radius * Math.PI;
	}

	public String toString() {
		return "Center: " + center + " , radius = " + radius;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocna = (Circle) obj;
			if (this.center.equals(pomocna.center) && this.radius == pomocna.radius)
				return true;
			else
				return false;
		} else
			return false;
	}

	public boolean contains(int x, int y) {
		return center.distance(x, y) <= radius;
	}

	public boolean contains(Point p) {
		return center.distance(p.getX(), p.getY()) <= radius;
	}

	// get,set
	public Point getCenter() {
		return this.center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return this.radius;
	}

	public void setRadius(int radius) {
		if (radius < 0)
			throw new IllegalArgumentException("Radius cannot be less than 0!");
		this.radius = radius;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(getBgColor());
		g.fillOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
		// TODO Auto-generated method stub
		g.setColor(getEdgeColor());
		g.drawOval(center.getX() - radius, center.getY() - radius, 2 * radius, 2 * radius);
		if (selected) {
			g.setColor(Color.blue);
			g.drawRect(center.getX() - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() + radius - 2, center.getY() - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() + radius - 2, 4, 4);
			g.drawRect(center.getX() - 2, center.getY() - radius - 2, 4, 4);
		}
	}

	@Override
	public void moveTo(int x, int y) {
		this.center.moveTo(x, y);

	}

	@Override
	public void moveBy(int byX, int byY) {
		this.center.moveBy(byX, byY);

	}

	@Override
	public int compareTo(Object o) {
		if (o instanceof Circle)
			return (int) (this.area() - ((Circle) o).area());
		return 0;
	}

}
