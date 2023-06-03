package sort;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import stack.FrmMain;
import stack.StackDialog;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;

public class FrmSort extends JFrame {

	private JPanel contentPane;

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
		
		JList circleList = new JList();
		GridBagConstraints gbc_circleList = new GridBagConstraints();
		gbc_circleList.gridwidth = 2;
		gbc_circleList.insets = new Insets(15, 15, 15, 15);
		gbc_circleList.fill = GridBagConstraints.BOTH;
		gbc_circleList.gridx = 0;
		gbc_circleList.gridy = 0;
		contentPane.add(circleList, gbc_circleList);
		

		JButton btnDodaj = new JButton("Dodaj");
		btnDodaj.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnDodaj = new GridBagConstraints();
		gbc_btnDodaj.anchor = GridBagConstraints.EAST;
		gbc_btnDodaj.insets = new Insets(0, 0, 5, 10);
		gbc_btnDodaj.gridx = 0;
		gbc_btnDodaj.gridy = 1;
		contentPane.add(btnDodaj, gbc_btnDodaj);
		
		JButton btnObrisi = new JButton("Sortiraj");
		btnObrisi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.insets = new Insets(0, 0, 5, 0);
		gbc_btnSort.anchor = GridBagConstraints.WEST;
		gbc_btnSort.gridx = 1;
		gbc_btnSort.gridy = 1;
		contentPane.add(btnObrisi, gbc_btnSort);

	}

}