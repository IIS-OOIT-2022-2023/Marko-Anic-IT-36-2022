package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

public class DlgRectangle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtWidth;
	private JTextField txtHeight;
	private Rectangle rectangle;
	private boolean isOk= false;
	private Color edgeColor;
	private Color bgColor;
	private JButton btnBgColor;
	private JButton btnEdgeColor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgRectangle dialog = new DlgRectangle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgRectangle() {
		edgeColor = Color.black;
		bgColor = Color.white;
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {60, 0, 40, 40};
		gbl_contentPanel.rowHeights = new int[] {30, 0, 30, 0, 30, 0, 0, 30, 30, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 3;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.gridwidth = 2;
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 1;
			gbc_txtX.gridy = 3;
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Y:");
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 4;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.gridwidth = 2;
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 1;
			gbc_txtY.gridy = 4;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblWidth = new JLabel("Width:");
			GridBagConstraints gbc_lblWidth = new GridBagConstraints();
			gbc_lblWidth.anchor = GridBagConstraints.EAST;
			gbc_lblWidth.insets = new Insets(0, 0, 5, 5);
			gbc_lblWidth.gridx = 0;
			gbc_lblWidth.gridy = 5;
			contentPanel.add(lblWidth, gbc_lblWidth);
		}
		{
			txtWidth = new JTextField();
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.gridwidth = 2;
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 1;
			gbc_txtWidth.gridy = 5;
			contentPanel.add(txtWidth, gbc_txtWidth);
			txtWidth.setColumns(10);
		}
		{
			JLabel lblHeight = new JLabel("Height:");
			GridBagConstraints gbc_lblHeight = new GridBagConstraints();
			gbc_lblHeight.anchor = GridBagConstraints.EAST;
			gbc_lblHeight.insets = new Insets(0, 0, 5, 5);
			gbc_lblHeight.gridx = 0;
			gbc_lblHeight.gridy = 6;
			contentPanel.add(lblHeight, gbc_lblHeight);
		}
		{
			txtHeight = new JTextField();
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.gridwidth = 2;
			gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 1;
			gbc_txtHeight.gridy = 6;
			contentPanel.add(txtHeight, gbc_txtHeight);
			txtHeight.setColumns(10);
		}
		{
			btnEdgeColor = new JButton("Edge color");
			btnEdgeColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					edgeColor = JColorChooser.showDialog(DlgRectangle.this, "Choose a Color", Color.BLACK);
					btnEdgeColor.setForeground(edgeColor);
				}
			});
			GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
			gbc_btnEdgeColor.insets = new Insets(0, 0, 5, 5);
			gbc_btnEdgeColor.gridx = 1;
			gbc_btnEdgeColor.gridy = 7;
			contentPanel.add(btnEdgeColor, gbc_btnEdgeColor);
		}
		{
			btnBgColor = new JButton("Background color");
			btnBgColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bgColor = JColorChooser.showDialog(DlgRectangle.this, "Choose a Color", Color.white);
					btnBgColor.setForeground(bgColor);
				}
			});
			GridBagConstraints gbc_btnBgColor = new GridBagConstraints();
			gbc_btnBgColor.anchor = GridBagConstraints.EAST;
			gbc_btnBgColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnBgColor.gridx = 2;
			gbc_btnBgColor.gridy = 7;
			contentPanel.add(btnBgColor, gbc_btnBgColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(validateInput())
						{
						int x = Integer.parseInt(txtX.getText());
						int y= Integer.parseInt(txtY.getText());
						int width = Integer.parseInt(txtWidth.getText());
						int height = Integer.parseInt(txtHeight.getText());
						if(x>= 0 && y>= 0 && width>=1 && height >=1) {
						rectangle = new Rectangle(new Point(x,y), width,height);
						isOk=true;
						dispose();
						}
						else
								JOptionPane.showMessageDialog(DlgRectangle.this,
			                            "Coordinates,width and height can not be less than 0!",
			                            "Error!",
			                            JOptionPane.ERROR_MESSAGE);
						}
						else
								JOptionPane.showMessageDialog(DlgRectangle.this,
			                            "Please fill in all fields with correct values.",
			                            "Error!",
			                            JOptionPane.ERROR_MESSAGE);
						}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOk =false;
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	private boolean validateInput() {
        String xText = txtX.getText();
        String yText = txtY.getText();
        String widthText = txtWidth.getText();
        String heightText = txtHeight.getText();
   
        return !xText.isEmpty() && !yText.isEmpty() && !widthText.isEmpty() && !heightText.isEmpty() 
        		&& isNumeric(xText) && isNumeric(yText) && isNumeric(widthText) && isNumeric(heightText); 
    }
	  private boolean isNumeric(String str) {
	        return str.matches("-?\\d+(\\.\\d+)?");
	    }
	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public JTextField getTxtWidth() {
		return txtWidth;
	}

	public JTextField getTxtHeight() {
		return txtHeight;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public Color getEdgeColor() {
		return edgeColor;
	}

	public void setEdgeColor(Color edgeColor) {
		this.edgeColor = edgeColor;
		btnEdgeColor.setForeground(edgeColor);
	}

	public Color getBgColor() {
		return bgColor;
	}

	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
		btnBgColor.setForeground(bgColor);
	}
	
}
