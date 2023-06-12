package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable {

	protected boolean selected; // protected sve u paketu
	private Color edgeColor;
	private Color bgColor;

	public abstract boolean contains(int x, int y);

	public abstract void draw(Graphics g);

	public Shape() {

	}

	public Shape(boolean selected) {
		this.selected = selected;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean newSelected) {
		selected = newSelected;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}

}
