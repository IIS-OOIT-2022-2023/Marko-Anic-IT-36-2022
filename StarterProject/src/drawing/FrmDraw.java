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
import java.awt.Font;

public class FrmDraw extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private Point point;
	private Line line;
	private Point startPoint;
	private Rectangle rectangle;
	private Circle circle;
	private Donut donut;
	private Color edgeColor;
	private Color bgColor;
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
		edgeColor = Color.black;
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
		tglbtnDraw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(tglbtnDraw);
		GridBagConstraints gbc_tglbtnDraw = new GridBagConstraints();
		gbc_tglbtnDraw.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDraw.gridx = 0;
		gbc_tglbtnDraw.gridy = 0;
		panel_1.add(tglbtnDraw, gbc_tglbtnDraw);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		tglbtnSelect.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(tglbtnSelect);
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelect.gridx = 0;
		gbc_tglbtnSelect.gridy = 1;
		panel_1.add(tglbtnSelect, gbc_tglbtnSelect);
		
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		tglbtnModify.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(tglbtnModify);
		GridBagConstraints gbc_tglbtnModify = new GridBagConstraints();
		gbc_tglbtnModify.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnModify.gridx = 0;
		gbc_tglbtnModify.gridy = 2;
		panel_1.add(tglbtnModify, gbc_tglbtnModify);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		tglbtnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup_1.add(tglbtnDelete);
		GridBagConstraints gbc_tglbtnDelete = new GridBagConstraints();
		gbc_tglbtnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDelete.gridx = 0;
		gbc_tglbtnDelete.gridy = 3;
		panel_1.add(tglbtnDelete, gbc_tglbtnDelete);
		
		PnlDrawing pnl = new PnlDrawing();
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
					
				}
			}
		});
		pnl.setBackground(new Color(255,255,255));
		contentPane.add(pnl, BorderLayout.CENTER);
	}

}
