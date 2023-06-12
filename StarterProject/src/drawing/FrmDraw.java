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

public class FrmDraw extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JButton btnModify;
	private JButton btnDelete;
	private Point point;
	private Line line;
	private Point startPoint;
	private Rectangle rectangle;
	private Circle circle;
	private Donut donut;
	private Color edgeColor;
	private Color bgColor;
	private PnlDrawing pnl;
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
		pnl = new PnlDrawing();
		edgeColor = Color.black;
		btnModify = new JButton("Modify");
		btnDelete = new JButton("Delete");
		btnModify.setEnabled(false);
		btnDelete.setEnabled(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		flowLayout.setHgap(54);
		contentPane.add(panel, BorderLayout.NORTH);
		
		JToggleButton tglbtnPoint = new JToggleButton("Point");
		tglbtnPoint.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(tglbtnPoint);
		panel.add(tglbtnPoint);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(tglbtnLine);
		panel.add(tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(tglbtnRectangle);
		panel.add(tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(tglbtnCircle);
		panel.add(tglbtnCircle);
		
		JToggleButton tglbtnDonut = new JToggleButton("Donut");
		tglbtnDonut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(tglbtnDonut);
		panel.add(tglbtnDonut);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{115, 0};
		gbl_panel_1.rowHeights = new int[] {0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0}; 
		panel_1.setLayout(gbl_panel_1);
		
		JToggleButton tglbtnDraw = new JToggleButton("Draw");
		tglbtnDraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnDraw.isSelected()) {
				tglbtnPoint.setEnabled(true);
				tglbtnLine.setEnabled(true);
				tglbtnRectangle.setEnabled(true);
				tglbtnCircle.setEnabled(true);
				tglbtnDonut.setEnabled(true);
				btnModify.setEnabled(false);
				btnDelete.setEnabled(false);
				}
			}
		});

		tglbtnDraw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(tglbtnDraw);
		GridBagConstraints gbc_tglbtnDraw = new GridBagConstraints();
		gbc_tglbtnDraw.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDraw.gridx = 0;
		gbc_tglbtnDraw.gridy = 0;
		panel_1.add(tglbtnDraw, gbc_tglbtnDraw);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonGroup.clearSelection();
				tglbtnPoint.setEnabled(false);
				tglbtnLine.setEnabled(false);
				tglbtnRectangle.setEnabled(false);
				tglbtnCircle.setEnabled(false);
				tglbtnDonut.setEnabled(false);
				btnModify.setEnabled(true);
				btnDelete.setEnabled(true);
			}
		});
		tglbtnSelect.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(tglbtnSelect);
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 1;
		panel_1.add(tglbtnSelect, gbc_tglbtnSelect);
		
		
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Shape shape = pnl.getLastShape();
				if(shape!=null)
				{
					if(shape instanceof Donut)
					{
						Donut donutShape = (Donut) shape;
			            DlgDonut dialog = new DlgDonut();
			            dialog.getTxtX().setText(String.valueOf(donutShape.getCenter().getX()));
			            dialog.getTxtY().setText(String.valueOf(donutShape.getCenter().getY()));
			            dialog.getTxtRadius().setText(String.valueOf(donutShape.getRadius()));
			            dialog.getTxtInnerRadius().setText(String.valueOf(donutShape.getInnerRadius()));

			            dialog.setEdgeColor(donutShape.getEdgeColor());
			            dialog.setBgColor(donutShape.getBgColor());
			            dialog.setVisible(true);
			            if(dialog.isOk())
			            {
							int x = Integer.parseInt(dialog.getTxtX().getText());
							int y= Integer.parseInt(dialog.getTxtY().getText());
							int radius = Integer.parseInt(dialog.getTxtRadius().getText());
							int innerRadius = Integer.parseInt(dialog.getTxtInnerRadius().getText());
							donutShape.setCenter(new Point(x,y));
							try {
								donutShape.setRadius(radius);
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							try {
								donutShape.setInnerRadius(innerRadius);
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							donutShape.setEdgeColor(dialog.getEdgeColor());
							donutShape.setBgColor(dialog.getBgColor());
							pnl.repaint();
			            }
					}
					else
						if(shape instanceof Circle)
						{
							 Circle circleShape = (Circle) shape;
					            DlgCircle dialog = new DlgCircle();
					            dialog.getTxtX().setText(String.valueOf(circleShape.getCenter().getX()));
					            dialog.getTxtY().setText(String.valueOf(circleShape.getCenter().getY()));
					            dialog.getTxtRadius().setText(String.valueOf(circleShape.getRadius()));
					            dialog.setEdgeColor(circleShape.getEdgeColor());
					            dialog.setBgColor(circleShape.getBgColor());
					            dialog.setVisible(true);
					            if(dialog.isOk())
					            {
									int x = Integer.parseInt(dialog.getTxtX().getText());
									int y= Integer.parseInt(dialog.getTxtY().getText());
									int radius = Integer.parseInt(dialog.getTxtRadius().getText());
									circleShape.setCenter(new Point(x,y));
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
					
					
					if(shape instanceof Point)
					{
					      Point pointShape = (Point) shape;
				            DlgPoint dialog = new DlgPoint();
				            dialog.getTxtX().setText(String.valueOf(pointShape.getX()));
				            dialog.getTxtY().setText(String.valueOf(pointShape.getY()));
				            dialog.setColor(pointShape.getEdgeColor());
				            dialog.setVisible(true);
				            if (dialog.isOk()) {
				            	pointShape.setX(Integer.parseInt(dialog.getTxtX().getText()));
				                pointShape.setY(Integer.parseInt(dialog.getTxtY().getText()));
				                pointShape.setEdgeColor(dialog.getColor());
				                pnl.repaint();
				            }
					}
					if(shape instanceof Line)
					{
						 Line lineShape = (Line)shape;
				            DlgLine dialog = new DlgLine();
				            dialog.getTxtX().setText(String.valueOf(lineShape.getStartPoint().getX()));
				            dialog.getTxtY().setText(String.valueOf(lineShape.getStartPoint().getY()));
				            dialog.getTxtX2().setText(String.valueOf(lineShape.getEndPoint().getX()));
				            dialog.getTxtY2().setText(String.valueOf(lineShape.getEndPoint().getY()));
				            dialog.setColor(lineShape.getEdgeColor());
				            
				            dialog.setVisible(true);
				            if (dialog.isOk()) {
				            	int x = Integer.parseInt(dialog.getTxtX().getText());
								int y= Integer.parseInt(dialog.getTxtY().getText());
								int xSec = Integer.parseInt(dialog.getTxtX2().getText());
								int ySec = Integer.parseInt(dialog.getTxtY2().getText());
				            	lineShape.setStartPoint(new Point(x,y));
				            	lineShape.setEndPoint(new Point(xSec,ySec));
				                lineShape.setEdgeColor(dialog.getColor());
				                pnl.repaint();
				            }
					}
					if(shape instanceof Rectangle)
					{
						Rectangle recShape = (Rectangle) shape;
						DlgRectangle dialog = new DlgRectangle();
						dialog.getTxtX().setText(String.valueOf(recShape.getUpperLeftPoint().getX()));
						dialog.getTxtY().setText(String.valueOf(recShape.getUpperLeftPoint().getY()));
						dialog.getTxtWidth().setText(String.valueOf(recShape.getWidth()));
						dialog.getTxtHeight().setText(String.valueOf(recShape.getHeight()));
						dialog.setBgColor(recShape.getBgColor());
						dialog.setEdgeColor(recShape.getEdgeColor());
						dialog.setVisible(true);
						if(dialog.isOk())
						{
							int x = Integer.parseInt(dialog.getTxtX().getText());
							int y= Integer.parseInt(dialog.getTxtY().getText());
							int width = Integer.parseInt(dialog.getTxtWidth().getText());
							int height = Integer.parseInt(dialog.getTxtHeight().getText());
							
							recShape.setUpperLeftPoint(new Point(x,y));
							recShape.setWidth(width);
							recShape.setHeight(height);
							recShape.setEdgeColor(dialog.getEdgeColor());
							recShape.setBgColor(dialog.getBgColor());
							pnl.repaint();
						}
					}
					
					
					
				}
				
			}
		});
		btnModify.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(btnModify);
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.insets = new Insets(0, 0, 5, 0);
		gbc_btnModify.gridx = 0;
		gbc_btnModify.gridy = 2;
		panel_1.add(btnModify, gbc_btnModify);
		
	
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(btnDelete);
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.gridx = 0;
		gbc_btnDelete.gridy = 3;
		panel_1.add(btnDelete, gbc_btnDelete);
		tglbtnPoint.setEnabled(false);
		tglbtnLine.setEnabled(false);
		tglbtnRectangle.setEnabled(false);
		tglbtnCircle.setEnabled(false);
		tglbtnDonut.setEnabled(false);
		
		pnl.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				if(tglbtnDraw.isSelected())
				{
	
					if(tglbtnPoint.isSelected())
					{
						DlgPoint dialog = new DlgPoint();
						dialog.getTxtX().setText(String.valueOf(x));
						dialog.getTxtY().setText(String.valueOf(y));
						dialog.setVisible(true);
						if(dialog.isOk())
						{
								point = dialog.getPoint();
								edgeColor = dialog.getColor();
								pnl.addShape(point,edgeColor);
								
						}
					}
					
					if(tglbtnLine.isSelected())
					{
						 if (startPoint == null) {
							
			                  startPoint = new Point(x, y);
			                } 
						 else {
							 DlgLine dialog = new DlgLine();
							 dialog.getTxtX().setText(String.valueOf(startPoint.getX()));
							 dialog.getTxtY().setText(String.valueOf(startPoint.getY()));
							 dialog.getTxtX2().setText(String.valueOf(x));
							 dialog.getTxtY2().setText(String.valueOf(y));
							 dialog.setVisible(true);
							 if(dialog.isOk()) 
							 { 
							line = dialog.getLine();
							edgeColor=dialog.getColor();
			                 pnl.addShape(line,edgeColor);
							 }
							 startPoint = null;
			                }
					}
					
					if(tglbtnRectangle.isSelected())
					{
						DlgRectangle dialog = new DlgRectangle();
						dialog.getTxtX().setText(String.valueOf(x));
						dialog.getTxtY().setText(String.valueOf(y));
						dialog.setVisible(true);
						
						if(dialog.isOk())
						{
						rectangle = dialog.getRectangle();
						edgeColor = dialog.getEdgeColor();
						bgColor = dialog.getBgColor();
						pnl.addShape(rectangle,edgeColor,bgColor);
						}
					}
					if(tglbtnCircle.isSelected())
					{
						DlgCircle dialog = new DlgCircle();
						dialog.getTxtX().setText(String.valueOf(x));
						dialog.getTxtY().setText(String.valueOf(y));
						dialog.setVisible(true);
						
						if(dialog.isOk())
						{
							circle = dialog.getCircle();
							edgeColor = dialog.getEdgeColor();
							bgColor = dialog.getBgColor();
							pnl.addShape(circle,edgeColor,bgColor);
						}
					}
					if(tglbtnDonut.isSelected())
					{
						DlgDonut dialog = new DlgDonut();
						 dialog.getTxtX().setText(String.valueOf(x));
						 dialog.getTxtY().setText(String.valueOf(y));
						 dialog.setVisible(true);
						 
						 if(dialog.isOk())
						 {
							 donut = dialog.getDonut();
							 edgeColor = dialog.getEdgeColor();
							 bgColor = dialog.getBgColor();
							 pnl.addShape(donut,edgeColor,bgColor);
						 }
					}
					
				}
				
				if(tglbtnSelect.isSelected())
				{
					pnl.selectShape(x, y);
				}
			}
		});
		pnl.setBackground(new Color(255,255,255));
		contentPane.add(pnl, BorderLayout.CENTER);
	}

}
