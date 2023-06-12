package drawing;

import geometry.Circle;
import geometry.Point;

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

public class DlgCircle extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
    private Circle circle;
    private Color edgeColor;
    private Color bgColor;
    private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCircle dialog = new DlgCircle();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
public DlgCircle() {
		edgeColor = Color.black;
		bgColor = Color.white;
		isOk=false;
		setTitle("Add circle");
		setModal(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] {60, 0, 40, 40};
		gbl_contentPanel.rowHeights = new int[] {30, 0, 30, 0, 30, 0, 30, 30, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("X:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 2;
			contentPanel.add(lblX, gbc_lblX);
		}
		{
			txtX = new JTextField();
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.gridwidth = 2;
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtX.gridx = 1;
			gbc_txtX.gridy = 2;
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
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 6;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.gridwidth = 2;
			gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 1;
			gbc_txtRadius.gridy = 6;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JButton btnEdgeColor = new JButton("Edge color");
			btnEdgeColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					edgeColor = JColorChooser.showDialog(DlgCircle.this, "Choose a Color", Color.BLACK);
					btnEdgeColor.setForeground(edgeColor);
				}
			});
			GridBagConstraints gbc_btnEdgeColor = new GridBagConstraints();
			gbc_btnEdgeColor.anchor = GridBagConstraints.WEST;
			gbc_btnEdgeColor.insets = new Insets(5, 0, 5, 5);
			gbc_btnEdgeColor.gridx = 1;
			gbc_btnEdgeColor.gridy = 7;
			contentPanel.add(btnEdgeColor, gbc_btnEdgeColor);
		}
		{
			JButton btnBgColor = new JButton("Background color");
			btnBgColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					bgColor = JColorChooser.showDialog(DlgCircle.this, "Choose a Color", Color.white);
					btnBgColor.setForeground(bgColor);
				}
			});
			GridBagConstraints gbc_btnBgColor = new GridBagConstraints();
			gbc_btnBgColor.anchor = GridBagConstraints.EAST;
			gbc_btnBgColor.insets = new Insets(5, 0, 5, 0);
			gbc_btnBgColor.gridx = 2;
			gbc_btnBgColor.gridy = 7;
			contentPanel.add(btnBgColor, gbc_btnBgColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnOk = new JButton("Ok");
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (validateInput()) {
		                    int x = Integer.parseInt(txtX.getText());
		                    int y = Integer.parseInt(txtY.getText());
		                    int radius = Integer.parseInt(txtRadius.getText());
		                   // JOptionPane.showMessageDialog(null,radius);
		                    if(radius >0)
		                    {
		                    	circle = new Circle(new Point(x,y), radius);
		                    	isOk=true;
		                    	dispose();
		                    }
		                    else
		                    	JOptionPane.showMessageDialog(DlgCircle.this,"The radius cannot be less than 0.","Greška",JOptionPane.ERROR_MESSAGE);
		                } 
						else {
		                    JOptionPane.showMessageDialog(DlgCircle.this,
		                            "Please fill in all fields with correct values.",
		                            "Error!",
		                            JOptionPane.ERROR_MESSAGE);
		                }
		            }	
				});
				btnOk.setActionCommand("OK");
				buttonPane.add(btnOk);
				getRootPane().setDefaultButton(btnOk);
			}
			{
			 JButton btnCancel = new JButton("Cancel");
				btnCancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				btnCancel.setActionCommand("Cancel");
				buttonPane.add(btnCancel);
			}
		}
	}


	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}
	 public Circle getCircle() {
	        return circle;
	    }
	public boolean isOk()
	{
		return this.isOk;
	}
	public void setOk(boolean isOk)
	{
		this.isOk = isOk;
	}
	private boolean validateInput() {
        String xText = txtX.getText();
        String yText = txtY.getText();
        String radiusText = txtRadius.getText();
        
        return !xText.isEmpty() && !yText.isEmpty() && !radiusText.isEmpty()
                && isNumeric(xText) && isNumeric(yText) && isNumeric(radiusText);
    }
	  private boolean isNumeric(String str) {
	        return str.matches("-?\\d+(\\.\\d+)?");
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
