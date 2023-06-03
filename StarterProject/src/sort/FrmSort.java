package sort;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Point;
import geometry.Rectangle;
import stack.StackDialog;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;

public class FrmSort extends JFrame {

	private JPanel contentPane;
	private DefaultListModel<Circle> circleListModel;
	private JList<Circle> circleList;
	private StackDialog dialog;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmSort frame = new FrmSort();
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
	public FrmSort() {
		
		circleListModel = new DefaultListModel<>();
		circleList = new JList<>(circleListModel);
		setTitle("Marko Anić IT-36/2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		
		GridBagConstraints gbc_circleList = new GridBagConstraints();
		gbc_circleList.gridwidth = 2;
		gbc_circleList.insets = new Insets(15, 15, 15, 15);
		gbc_circleList.fill = GridBagConstraints.BOTH;
		gbc_circleList.gridx = 0;
		gbc_circleList.gridy = 0;
		contentPane.add(circleList, gbc_circleList);
		

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog = new StackDialog();
				dialog.setVisible(true);
				
				Circle circle = dialog.getCircle();
				if(circle!=null)
				circleListModel.addElement(circle);
				
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.anchor = GridBagConstraints.EAST;
		gbc_btnAdd.insets = new Insets(0, 0, 5, 10);
		gbc_btnAdd.gridx = 0;
		gbc_btnAdd.gridy = 1;
		contentPane.add(btnAdd, gbc_btnAdd);
		
		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				  if (!circleListModel.isEmpty()) {
					  
			            List<Circle> circles = new ArrayList<>();
			            for (int i = 0; i < circleListModel.size(); i++) {
			                circles.add(circleListModel.getElementAt(i));
			            }

			            Collections.sort(circles);

			            circleListModel.clear();
			            for (Circle circle : circles) {
			                circleListModel.addElement(circle);
			            }
			        } else {
			            JOptionPane.showMessageDialog(FrmSort.this, "The list is empty!", "Error!", JOptionPane.ERROR_MESSAGE);
			        }
			}
		});
		btnSort.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.insets = new Insets(0, 0, 5, 0);
		gbc_btnSort.anchor = GridBagConstraints.WEST;
		gbc_btnSort.gridx = 1;
		gbc_btnSort.gridy = 1;
		contentPane.add(btnSort, gbc_btnSort);

	}

}
