package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel {
    private List<Shape> shapes;
    private Map<Shape, Color> shapeColors;

    public PnlDrawing() {
        shapes = new ArrayList<>();
        shapeColors = new HashMap<>();
    }

    public void addShape(Shape shape, Color color) {
        shapes.add(shape);
        shapeColors.put(shape, color);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Iterator<Shape> it = shapes.iterator();
        while(it.hasNext())
        {
        	 Shape shape = it.next();
             Color color = shapeColors.get(shape);
             g.setColor(color);
             shape.draw(g);
        }
 
    }
}