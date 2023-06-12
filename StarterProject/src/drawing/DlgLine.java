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

public class DlgLine extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtX2;
	private JTextField txtY2;
	private boolean isOk;
	private Line line;
	private Color color;
	private JButton btnColor;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLine dialog = new DlgLine();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLine() {
		isOk =false;
		color= Color.black;
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {60, 40, 40};
		gbl_contentPanel.rowHeights = new int[] {30, 0, 30, 0, 30, 0, 0, 30, 30, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
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
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 1;
			gbc_txtY.gridy = 4;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblX2 = new JLabel("X2:");
			GridBagConstraints gbc_lblX2 = new GridBagConstraints();
			gbc_lblX2.anchor = GridBagConstraints.EAST;
			gbc_lblX2.insets = new Insets(0, 0, 5, 5);
			gbc_lblX2.gridx = 0;
			gbc_lblX2.gridy = 5;
			contentPanel.add(lblX2, gbc_lblX2);
		}
		{
			txtX2 = new JTextField();
			GridBagConstraints gbc_txtX2 = new GridBagConstraints();
			gbc_txtX2.insets = new Insets(0, 0, 5, 0);
			gbc_txtX2.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX2.gridx = 1;
			gbc_txtX2.gridy = 5;
			contentPanel.add(txtX2, gbc_txtX2);
			txtX2.setColumns(10);
		}
		{
			JLabel lblY2 = new JLabel("Y2:");
			GridBagConstraints gbc_lblY2 = new GridBagConstraints();
			gbc_lblY2.anchor = GridBagConstraints.EAST;
			gbc_lblY2.insets = new Insets(0, 0, 5, 5);
			gbc_lblY2.gridx = 0;
			gbc_lblY2.gridy = 6;
			contentPanel.add(lblY2, gbc_lblY2);
		}
		{
			txtY2 = new JTextField();
			GridBagConstraints gbc_txtY2 = new GridBagConstraints();
			gbc_txtY2.insets = new Insets(0, 0, 5, 0);
			gbc_txtY2.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY2.gridx = 1;
			gbc_txtY2.gridy = 6;
			contentPanel.add(txtY2, gbc_txtY2);
			txtY2.setColumns(10);
		}
		{
			btnColor = new JButton("Choose color");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					color = JColorChooser.showDialog(DlgLine.this, "Choose a Color", Color.BLACK);
					btnColor.setForeground(color);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.insets = new Insets(15, 0, 5, 0);
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 7;
			contentPanel.add(btnColor, gbc_btnColor);
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
						int xSec = Integer.parseInt(txtX2.getText());
						int ySec = Integer.parseInt(txtY2.getText());
						if(x >= 0 && y >= 0 && xSec >= 0 && ySec >= 0)
						{
						line = new Line(new Point(x,y),new Point(xSec,ySec));
						isOk=true;
						dispose();
						}
						else
							JOptionPane.showMessageDialog(DlgLine.this,
		                            "Coordinates can not be less than 0!",
		                            "Error!",
		                            JOptionPane.ERROR_MESSAGE);
						
						}
						else
							JOptionPane.showMessageDialog(DlgLine.this,
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

	public JTextField getTxtX() {
		return txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public JTextField getTxtX2() {
		return txtX2;
	}

	public JTextField getTxtY2() {
		return txtY2;
	}
	public Line getLine()
	{
		return this.line;
	}
	public boolean isOk()
	{
		return this.isOk;
	}
	public Color getColor()
	{
		return this.color;
	}
	public void setColor(Color color)
	{
		this.color = color;
		btnColor.setForeground(color);
	}
	private boolean validateInput() {
        String xText = txtX.getText();
        String yText = txtY.getText();
        String x2Text = txtX2.getText();
        String y2Text = txtY2.getText();
        
        return !xText.isEmpty() && !yText.isEmpty() && !x2Text.isEmpty() && !y2Text.isEmpty() 
        		&& isNumeric(xText) && isNumeric(yText) && isNumeric(x2Text) && isNumeric(y2Text); 
    }
	  private boolean isNumeric(String str) {
	        return str.matches("-?\\d+(\\.\\d+)?");
	    }

	public void setLine(Line line) {
		this.line = line;
	}
}
