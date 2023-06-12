package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import geometry.Rectangle;
import geometry.Shape;

public class PnlDrawing extends JPanel {
    private List<Shape> shapes;
    private Shape lastShape;

    public PnlDrawing() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape, Color edgeColor) {
        shapes.add(shape);
        shape.setEdgeColor(edgeColor);
        repaint();
    }
    public void addShape(Shape shape, Color edgeColor, Color bgColor) {
    	shapes.add(shape);
        shape.setEdgeColor(edgeColor);
        shape.setBgColor(bgColor);
        
        repaint();
    }
    public void selectShape(int x, int y) {
        Iterator<Shape> it = shapes.iterator();
        lastShape = null;
        
        while (it.hasNext()) {
            Shape shape = it.next();
            
            if (shape.contains(x, y)) {
                lastShape = shape;
            }
           
            shape.setSelected(false);
        }
        
        if (lastShape != null) {
            lastShape.setSelected(true);
            
        }
        
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Iterator<Shape> it = shapes.iterator();
        while(it.hasNext())
        {
        	 Shape shape = it.next();
           
             shape.draw(g);
        }
 
    }

	public Shape getLastShape() {
		return lastShape;
	}

	public void setLastShape(Shape lastShape) {
		this.lastShape = lastShape;
	}

	public void removeShape(Shape shape) {
		// TODO Auto-generated method stub
		shapes.remove(shape);
		lastShape=null;
	}

}