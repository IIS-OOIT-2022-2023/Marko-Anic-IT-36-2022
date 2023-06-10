package drawing;

import java.awt.EventQueue;
import geometry.Point;
import geometry.Rectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Shape;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JToggleButton;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmDraw extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup2 = new ButtonGroup();
	private Circle circle;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JToggleButton tglbtnDot = new JToggleButton("Dott");
		tglbtnDot.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(tglbtnDot);
		GridBagConstraints gbc_tglbtnDot = new GridBagConstraints();
		gbc_tglbtnDot.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnDot.gridx = 4;
		gbc_tglbtnDot.gridy = 2;
		contentPane.add(tglbtnDot, gbc_tglbtnDot);
		
		JToggleButton tglbtnLine = new JToggleButton("Line");
		tglbtnLine.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(tglbtnLine);
		GridBagConstraints gbc_tglbtnLine = new GridBagConstraints();
		gbc_tglbtnLine.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLine.gridx = 5;
		gbc_tglbtnLine.gridy = 2;
		contentPane.add(tglbtnLine, gbc_tglbtnLine);
		
		JToggleButton tglbtnRectangle = new JToggleButton("Rectangle");
		tglbtnRectangle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(tglbtnRectangle);
		GridBagConstraints gbc_tglbtnRectangle = new GridBagConstraints();
		gbc_tglbtnRectangle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnRectangle.gridx = 6;
		gbc_tglbtnRectangle.gridy = 2;
		contentPane.add(tglbtnRectangle, gbc_tglbtnRectangle);
		
		JToggleButton tglbtnCircle = new JToggleButton("Circle");
		tglbtnCircle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(tglbtnCircle);
		GridBagConstraints gbc_tglbtnCircle = new GridBagConstraints();
		gbc_tglbtnCircle.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCircle.gridx = 7;
		gbc_tglbtnCircle.gridy = 2;
		contentPane.add(tglbtnCircle, gbc_tglbtnCircle);
		
		JToggleButton tglbtnDonnut = new JToggleButton("Donnut");
		tglbtnDonnut.setFont(new Font("Tahoma", Font.PLAIN, 16));
		buttonGroup.add(tglbtnDonnut);
		GridBagConstraints gbc_tglbtnDonnut = new GridBagConstraints();
		gbc_tglbtnDonnut.anchor = GridBagConstraints.WEST;
		gbc_tglbtnDonnut.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnDonnut.gridx = 8;
		gbc_tglbtnDonnut.gridy = 2;
		contentPane.add(tglbtnDonnut, gbc_tglbtnDonnut);
		
		JToggleButton tglbtnDraw = new JToggleButton("Draw");
		buttonGroup2.add(tglbtnDraw);
		tglbtnDraw.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_tglbtnDraw = new GridBagConstraints();
		gbc_tglbtnDraw.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnDraw.gridx = 1;
		gbc_tglbtnDraw.gridy = 4;
		contentPane.add(tglbtnDraw, gbc_tglbtnDraw);
		
		JToggleButton tglbtnSelect = new JToggleButton("Select");
		buttonGroup2.add(tglbtnSelect);
		tglbtnSelect.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_tglbtnSelect = new GridBagConstraints();
		gbc_tglbtnSelect.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnSelect.gridx = 1;
		gbc_tglbtnSelect.gridy = 5;
		contentPane.add(tglbtnSelect, gbc_tglbtnSelect);
		
		JToggleButton tglbtnModify = new JToggleButton("Modify");
		buttonGroup2.add(tglbtnModify);
		tglbtnModify.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_tglbtnModify = new GridBagConstraints();
		gbc_tglbtnModify.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnModify.gridx = 1;
		gbc_tglbtnModify.gridy = 6;
		contentPane.add(tglbtnModify, gbc_tglbtnModify);
		
		JPanel panel = new JPanel();
	/*			{
	            @Override
	            protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                Circle circle = new Circle (new Point(2,3),5);
	                circle.draw(g);
				}};*/
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglbtnDraw.isSelected() && tglbtnCircle.isSelected())
				{
					 int x = e.getX();
			         int y = e.getY();
			         circle = new Circle(new Point(x, y), 30);
			         Graphics g = panel.getGraphics();
			         circle.draw(g);
				}
				}
			
		});
		panel.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 9;
		gbc_panel.gridwidth = 6;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 4;
		contentPane.add(panel, gbc_panel);
		
		JToggleButton tglbtnDelete = new JToggleButton("Delete");
		buttonGroup2.add(tglbtnDelete);
		tglbtnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_tglbtnDelete = new GridBagConstraints();
		gbc_tglbtnDelete.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnDelete.gridx = 1;
		gbc_tglbtnDelete.gridy = 7;
		contentPane.add(tglbtnDelete, gbc_tglbtnDelete);
	}

}
