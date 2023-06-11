package drawing;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel {
    private List<Shape> shapes;

    public PnlDrawing() {
        shapes = new ArrayList<>();
    }

    public void addShape(Shape shape) {
        shapes.add(shape);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
 /*   @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400); // Set your desired size here
    }*/
}
