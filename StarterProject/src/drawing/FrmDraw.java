package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;
import stack.StackDialog;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class FrmDraw extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup btnGroupShapes = new ButtonGroup();
	private final ButtonGroup btnGroupOptions = new ButtonGroup();
	private Point point;
	private Line line;
	private Point startPoint;
	private Rectangle rectangle;
	private Circle circle;
	private Donut donut;
	private Color edgeColor;
	private Color bgColor;
	private PnlDrawing pnl;
	private Shape shape;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDraw frame = new FrmDraw();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDraw() {
		setTitle("Marko Anić IT-36/2022");
		pnl = new PnlDrawing();
		pnl.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		//default colors
		edgeColor = Color.black;
		bgColor = Color.white;		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlShapes = new JPanel();
		FlowLayout fl_pnlShapes = (FlowLayout) pnlShapes.getLayout();
		fl_pnlShapes.setAlignment(FlowLayout.RIGHT);
		fl_pnlShapes.setHgap(54);
		contentPane.add(pnlShapes, BorderLayout.NORTH);

		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGroupShapes.add(tglbtnPoint);
		pnlShapes.add(tglbtnPoint);

		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGroupShapes.add(tglbtnLine);
		pnlShapes.add(tglbtnLine);

		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGroupShapes.add(tglbtnRectangle);
		pnlShapes.add(tglbtnRectangle);

		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGroupShapes.add(tglbtnCircle);
		pnlShapes.add(tglbtnCircle);

		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGroupShapes.add(tglbtnDonut);
		pnlShapes.add(tglbtnDonut);

		JPanel pnlOptions = new JPanel();
		contentPane.add(pnlOptions, BorderLayout.WEST);
		GridBagLayout gbl_pnlOptions = new GridBagLayout();
		gbl_pnlOptions.columnWidths = new int[] { 115, 0 };
		gbl_pnlOptions.rowHeights = new int[] { 0, 0, 0 };
		gbl_pnlOptions.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_pnlOptions.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		pnlOptions.setLayout(gbl_pnlOptions);

		JToggleButton tglbtnDraw = new JToggleButton("Draw");
		tglbtnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//enabling shapes when we want to draw
				tglbtnPoint.setEnabled(true);
				tglbtnLine.setEnabled(true);
				tglbtnRectangle.setEnabled(true);
				tglbtnCircle.setEnabled(true);
				tglbtnDonut.setEnabled(true);
				shape = pnl.getLastShape();
				// If there is a selected shape, that shape will be deselected when we want to draw 
				// if shape isn't null, that means that we have a selected shape in panel
				if (shape != null) { 
					shape.setSelected(false);
				}
				pnl.setLastShape(null);; // Reseting
				pnl.repaint(); 
				
			}

		});

		tglbtnDraw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGroupOptions.add(tglbtnDraw);
		GridBagConstraints gbc_tglbtnDraw = new GridBagConstraints();
		gbc_tglbtnDraw.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDraw.gridx = 0;
		gbc_tglbtnDraw.gridy = 0;
		pnlOptions.add(tglbtnDraw, gbc_tglbtnDraw);

		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//there is no need for Shape buttons in selecting mode
				btnGroupShapes.clearSelection();
				tglbtnPoint.setEnabled(false);
				tglbtnLine.setEnabled(false);
				tglbtnRectangle.setEnabled(false);
				tglbtnCircle.setEnabled(false);
				tglbtnDonut.setEnabled(false);
			}
		});
		tglbtnSelect.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGroupOptions.add(tglbtnSelect);
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 1;
		pnlOptions.add(tglbtnSelect, gbc_tglbtnSelect);

		JButton btnModify = new JButton("Modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Getting selected shape
				shape = pnl.getLastShape();
				// Checking if shape is selected
				if (shape != null) {
					// If that shape is Donut
					if (shape instanceof Donut) {
						Donut donutShape = (Donut) shape;
						DlgDonut dialog = new DlgDonut();
						// Setting values for dialog
						dialog.setTitle("Modify donut");
						dialog.getTxtX().setText(String.valueOf(donutShape.getCenter().getX()));
						dialog.getTxtY().setText(String.valueOf(donutShape.getCenter().getY()));
						dialog.getTxtRadius().setText(String.valueOf(donutShape.getRadius()));
						dialog.getTxtInnerRadius().setText(String.valueOf(donutShape.getInnerRadius()));
						dialog.setEdgeColor(donutShape.getEdgeColor());
						dialog.setBgColor(donutShape.getBgColor());
						dialog.setVisible(true);
						if (dialog.isOk()) {
							// Getting values from textfields
							int x = Integer.parseInt(dialog.getTxtX().getText());
							int y = Integer.parseInt(dialog.getTxtY().getText());
							int radius = Integer.parseInt(dialog.getTxtRadius().getText());
							int innerRadius = Integer.parseInt(dialog.getTxtInnerRadius().getText());
							// Changing original center
							donutShape.moveTo(x, y);
							// Changing original radius
						
							donutShape.setRadius(radius);
							
							// Changing original inner radius
							
							donutShape.setInnerRadius(innerRadius);

							// Getting colors from dialog
							donutShape.setEdgeColor(dialog.getEdgeColor());
							donutShape.setBgColor(dialog.getBgColor());

							pnl.repaint();
						}
					}
					// Donut and circle have same instance, so we must first check Donut
					else if (shape instanceof Circle) {
						Circle circleShape = (Circle) shape;
						DlgCircle dialog = new DlgCircle();
						dialog.setTitle("Modify circle");
						dialog.getTxtX().setText(String.valueOf(circleShape.getCenter().getX()));
						dialog.getTxtY().setText(String.valueOf(circleShape.getCenter().getY()));
						dialog.getTxtRadius().setText(String.valueOf(circleShape.getRadius()));
						dialog.setEdgeColor(circleShape.getEdgeColor());
						dialog.setBgColor(circleShape.getBgColor());
						dialog.setVisible(true);
						if (dialog.isOk()) {
							int x = Integer.parseInt(dialog.getTxtX().getText());
							int y = Integer.parseInt(dialog.getTxtY().getText());
							int radius = Integer.parseInt(dialog.getTxtRadius().getText());
							circleShape.moveTo(x, y);
							try {
								circleShape.setRadius(radius);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							circleShape.setEdgeColor(dialog.getEdgeColor());
							circleShape.setBgColor(dialog.getBgColor());
							pnl.repaint();
						}
					}

					if (shape instanceof Point) {
						Point pointShape = (Point) shape;
						DlgPoint dialog = new DlgPoint();
						dialog.setTitle("Modify point");
						dialog.getTxtX().setText(String.valueOf(pointShape.getX()));
						dialog.getTxtY().setText(String.valueOf(pointShape.getY()));
						dialog.setColor(pointShape.getEdgeColor());
						dialog.setVisible(true);
						if (dialog.isOk()) {
							int x = Integer.parseInt(dialog.getTxtX().getText());
							int y =	Integer.parseInt(dialog.getTxtY().getText());
							pointShape.moveTo(x, y);
							pointShape.setEdgeColor(dialog.getColor());
							pnl.repaint();
						}
					}
					if (shape instanceof Line) {
						Line lineShape = (Line) shape;
						DlgLine dialog = new DlgLine();
						dialog.setTitle("Modify line");
						dialog.getTxtX().setText(String.valueOf(lineShape.getStartPoint().getX()));
						dialog.getTxtY().setText(String.valueOf(lineShape.getStartPoint().getY()));
						dialog.getTxtX2().setText(String.valueOf(lineShape.getEndPoint().getX()));
						dialog.getTxtY2().setText(String.valueOf(lineShape.getEndPoint().getY()));
						dialog.setColor(lineShape.getEdgeColor());

						dialog.setVisible(true);
						if (dialog.isOk()) {
							int x = Integer.parseInt(dialog.getTxtX().getText());
							int y = Integer.parseInt(dialog.getTxtY().getText());
							int xSec = Integer.parseInt(dialog.getTxtX2().getText());
							int ySec = Integer.parseInt(dialog.getTxtY2().getText());
							lineShape.getStartPoint().moveTo(x, y);
							lineShape.getEndPoint().moveTo(xSec, ySec);
							lineShape.setEdgeColor(dialog.getColor());
							pnl.repaint();
						}
					}
					if (shape instanceof Rectangle) {
						Rectangle recShape = (Rectangle) shape;
						DlgRectangle dialog = new DlgRectangle();
						dialog.setTitle("Modify rectangle");
						dialog.getTxtX().setText(String.valueOf(recShape.getUpperLeftPoint().getX()));
						dialog.getTxtY().setText(String.valueOf(recShape.getUpperLeftPoint().getY()));
						dialog.getTxtWidth().setText(String.valueOf(recShape.getWidth()));
						dialog.getTxtHeight().setText(String.valueOf(recShape.getHeight()));
						dialog.setBgColor(recShape.getBgColor());
						dialog.setEdgeColor(recShape.getEdgeColor());
						dialog.setVisible(true);
						if (dialog.isOk()) {
							int x = Integer.parseInt(dialog.getTxtX().getText());
							int y = Integer.parseInt(dialog.getTxtY().getText());
							int width = Integer.parseInt(dialog.getTxtWidth().getText());
							int height = Integer.parseInt(dialog.getTxtHeight().getText());

							recShape.getUpperLeftPoint().moveTo(x, y);
							recShape.setWidth(width);
							recShape.setHeight(height);
							recShape.setEdgeColor(dialog.getEdgeColor());
							recShape.setBgColor(dialog.getBgColor());
							pnl.repaint();
						}
					}
					

				} else
					JOptionPane.showMessageDialog(FrmDraw.this, "Select shape to modify!", "Information",
							JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGroupOptions.add(btnModify);
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 5, 0);
		gbc_btnModify.gridx = 0;
		gbc_btnModify.gridy = 2;
		pnlOptions.add(btnModify, gbc_btnModify);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Getting selected shape
				shape = pnl.getLastShape();
				if (shape != null) {
					int choice = JOptionPane.showConfirmDialog(FrmDraw.this,
							"Are you sure you want to delete the selected shape?", "Confirmation",
							JOptionPane.YES_NO_OPTION);

					if (choice == JOptionPane.YES_OPTION) {
						pnl.removeShape(shape);
						pnl.repaint();
					}
				} else
					JOptionPane.showMessageDialog(FrmDraw.this, "Select shape to delete!", "Information",
							JOptionPane.INFORMATION_MESSAGE);

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGroupOptions.add(btnDelete);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 3;
		pnlOptions.add(btnDelete, gbc_btnDelete);
		tglbtnPoint.setEnabled(false);
		tglbtnLine.setEnabled(false);
		tglbtnRectangle.setEnabled(false);
		tglbtnCircle.setEnabled(false);
		tglbtnDonut.setEnabled(false);
		
		// Opening dialogs and setting values for shapes
		pnl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//coordinates of click
				int x = e.getX();
				int y = e.getY();
				
				if (tglbtnDraw.isSelected()) {
						
					if (tglbtnPoint.isSelected()) {
						DlgPoint dialog = new DlgPoint();
						dialog.getTxtX().setText(String.valueOf(x));
						dialog.getTxtY().setText(String.valueOf(y));
						dialog.setVisible(true);
						if (dialog.isOk()) {
							point = dialog.getPoint();
							edgeColor = dialog.getColor();
							pnl.addShape(point, edgeColor);

						}
					}

					if (tglbtnLine.isSelected()) {
						if (startPoint == null) {

							startPoint = new Point(x, y);
						} else {
							DlgLine dialog = new DlgLine();
							dialog.getTxtX().setText(String.valueOf(startPoint.getX()));
							dialog.getTxtY().setText(String.valueOf(startPoint.getY()));
							dialog.getTxtX2().setText(String.valueOf(x));
							dialog.getTxtY2().setText(String.valueOf(y));
							dialog.setVisible(true);
							if (dialog.isOk()) {
								line = dialog.getLine();
								edgeColor = dialog.getColor();
								pnl.addShape(line, edgeColor);
							}
							startPoint = null;
						}
					}

					if (tglbtnRectangle.isSelected()) {
						DlgRectangle dialog = new DlgRectangle();
						dialog.getTxtX().setText(String.valueOf(x));
						dialog.getTxtY().setText(String.valueOf(y));
						dialog.setVisible(true);

						if (dialog.isOk()) {
							rectangle = dialog.getRectangle();
							edgeColor = dialog.getEdgeColor();
							bgColor = dialog.getBgColor();
							pnl.addShape(rectangle, edgeColor, bgColor);
						}
					}
					if (tglbtnCircle.isSelected()) {
						DlgCircle dialog = new DlgCircle();
						dialog.getTxtX().setText(String.valueOf(x));
						dialog.getTxtY().setText(String.valueOf(y));
						dialog.setVisible(true);

						if (dialog.isOk()) {
							circle = dialog.getCircle();
							edgeColor = dialog.getEdgeColor();
							bgColor = dialog.getBgColor();
							pnl.addShape(circle, edgeColor, bgColor);
						}
					}
					if (tglbtnDonut.isSelected()) {
						DlgDonut dialog = new DlgDonut();
						dialog.getTxtX().setText(String.valueOf(x));
						dialog.getTxtY().setText(String.valueOf(y));
						dialog.setVisible(true);

						if (dialog.isOk()) {
							donut = dialog.getDonut();
							edgeColor = dialog.getEdgeColor();
							bgColor = dialog.getBgColor();
							pnl.addShape(donut, edgeColor, bgColor);
						}
					}
					
					if(!tglbtnPoint.isSelected() && !tglbtnLine.isSelected() && !tglbtnRectangle.isSelected()
							&& !tglbtnCircle.isSelected() && !tglbtnDonut.isSelected() && x>=0 && y>=0 )
							
					{
						JOptionPane.showMessageDialog(FrmDraw.this, "Please select shape that you want to draw!","Information",JOptionPane.INFORMATION_MESSAGE);
					}
					
				}

				if (tglbtnSelect.isSelected()) {
					pnl.selectShape(x, y);
				}
			}
		});
		pnl.setBackground(new Color(255, 255, 255));
		contentPane.add(pnl, BorderLayout.CENTER);
	}

}
