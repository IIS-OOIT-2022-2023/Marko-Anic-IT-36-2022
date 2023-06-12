package sort;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.DefaultListCellRenderer;
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
		circleList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		//display of objects changed to show area
		circleList.setCellRenderer(new DefaultListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

				if (value instanceof Circle) {
					Circle circle = (Circle) value;
					String text = circle.toString() + ", area: " + circle.area();
					setText(text);
				}

				return this;
			}
		});

		setTitle("Marko Anić IT-36/2022");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPane.rowHeights = new int[] { 0, 0, 0 };
		gbl_contentPane.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
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

				if (dialog.isOk()) {
					//taking circle from dialog and adding to DefaultListModel
					Circle circle = dialog.getCircle();
					circleListModel.addElement(circle);
				}
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
					
					//converting DefaultListModel to ArrayList
					List<Circle> circles = new ArrayList<>();
					for (int i = 0; i < circleListModel.size(); i++) {
						circles.add(circleListModel.getElementAt(i));
					}
					//compareTo method for sorting
					Collections.sort(circles);
					
					//clearing DefaultListModel for adding new sorted elements
					circleListModel.clear();
					for (Circle circle : circles) {
						circleListModel.addElement(circle);
					}

				} else {
					JOptionPane.showMessageDialog(FrmSort.this, "The list is empty!", "Error!",
							JOptionPane.ERROR_MESSAGE);
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
