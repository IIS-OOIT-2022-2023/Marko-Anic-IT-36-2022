package stack;

import geometry.Circle;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmMain extends JFrame {

	private JPanel contentPane;
	private JList<Circle> circleList;
	private DefaultListModel<Circle> circleListModel;
	private StackDialog dialog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMain frame = new FrmMain();
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
	public FrmMain() {
		circleListModel = new DefaultListModel<>();
		circleList = new JList<>(circleListModel);
		circleList.setFont(new Font("Tahoma", Font.PLAIN, 14));
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
					Circle circle = dialog.getCircle();
					circleListModel.add(0, circle);
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

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog = new StackDialog();
				dialog.setTitle("Delete circle");
				if (!circleListModel.isEmpty()) {

					Circle circle = circleListModel.get(0);
					dialog.getTxtX().setText(String.valueOf(circle.getCenter().getX()));
					dialog.getTxtY().setText(String.valueOf(circle.getCenter().getY()));
					dialog.getTxtRadius().setText(String.valueOf(circle.getRadius()));

					dialog.setVisible(true);

					if (dialog.isOk()) {
						circleListModel.remove(0);
					}
				} else {
					JOptionPane.showMessageDialog(FrmMain.this, "The list is empty!", "Error!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnDelete = new GridBagConstraints();
		gbc_btnDelete.insets = new Insets(0, 0, 5, 0);
		gbc_btnDelete.anchor = GridBagConstraints.WEST;
		gbc_btnDelete.gridx = 1;
		gbc_btnDelete.gridy = 1;
		contentPane.add(btnDelete, gbc_btnDelete);

	}

}
