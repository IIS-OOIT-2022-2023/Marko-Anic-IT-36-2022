package gui;

import java.awt.EventQueue;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JButton;

public class FrmTest extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private DefaultListModel dlm = new DefaultListModel();
	private JLabel lblCrvena;
	private JLabel lblPlava;
	private JLabel lblZuta;
	private JTextField txtUnosBoje;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
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
	public FrmTest() {
		setTitle("Aplikacija 1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlCenter.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlCenter.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JToggleButton tglbtnCrvena = new JToggleButton("Crvena");
		tglbtnCrvena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblCrvena.setForeground(Color.red);
				lblPlava.setForeground(Color.black);
				lblZuta.setForeground(Color.black);
				dlm.addElement(lblCrvena.getText());
			}
		});
		buttonGroup.add(tglbtnCrvena);
		GridBagConstraints gbc_tglbtnCrvena = new GridBagConstraints();
		gbc_tglbtnCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvena.gridx = 0;
		gbc_tglbtnCrvena.gridy = 0;
		pnlCenter.add(tglbtnCrvena, gbc_tglbtnCrvena);
		
		lblCrvena = new JLabel("Crvena");
		GridBagConstraints gbc_lblCrvena = new GridBagConstraints();
		gbc_lblCrvena.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvena.gridx = 1;
		gbc_lblCrvena.gridy = 0;
		pnlCenter.add(lblCrvena, gbc_lblCrvena);
		
		JToggleButton tglbtnPlava = new JToggleButton("Plava");
		tglbtnPlava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblPlava.setForeground(Color.blue);
				lblCrvena.setForeground(Color.black);
				lblZuta.setForeground(Color.black);
				dlm.addElement(lblPlava.getText());
				
			}
		});
		
		txtUnosBoje = new JTextField();
		txtUnosBoje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					dlm.addElement(txtUnosBoje.getText());
					txtUnosBoje.setText(null);
				}
			}
		});
		GridBagConstraints gbc_txtUnosBoje = new GridBagConstraints();
		gbc_txtUnosBoje.insets = new Insets(0, 0, 5, 0);
		gbc_txtUnosBoje.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUnosBoje.gridx = 2;
		gbc_txtUnosBoje.gridy = 0;
		pnlCenter.add(txtUnosBoje, gbc_txtUnosBoje);
		txtUnosBoje.setColumns(10);
		
		buttonGroup.add(tglbtnPlava);
		GridBagConstraints gbc_tglbtnPlava = new GridBagConstraints();
		gbc_tglbtnPlava.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlava.gridx = 0;
		gbc_tglbtnPlava.gridy = 1;
		pnlCenter.add(tglbtnPlava, gbc_tglbtnPlava);
		
		lblPlava = new JLabel("Plava");
		GridBagConstraints gbc_lblPlava = new GridBagConstraints();
		gbc_lblPlava.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlava.gridx = 1;
		gbc_lblPlava.gridy = 1;
		pnlCenter.add(lblPlava, gbc_lblPlava);
		
		JToggleButton tglbtnZuta = new JToggleButton("Zuta");
		tglbtnZuta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblZuta.setForeground(Color.yellow);
				lblPlava.setForeground(Color.black);
				lblCrvena.setForeground(Color.black);
				dlm.addElement(lblZuta.getText());
			}
		});
		buttonGroup.add(tglbtnZuta);
		GridBagConstraints gbc_tglbtnZuta = new GridBagConstraints();
		gbc_tglbtnZuta.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnZuta.gridx = 0;
		gbc_tglbtnZuta.gridy = 2;
		pnlCenter.add(tglbtnZuta, gbc_tglbtnZuta);
		
		lblZuta = new JLabel("Zuta");
		GridBagConstraints gbc_lblZuta = new GridBagConstraints();
		gbc_lblZuta.insets = new Insets(0, 0, 5, 5);
		gbc_lblZuta.gridx = 1;
		gbc_lblZuta.gridy = 2;
		pnlCenter.add(lblZuta, gbc_lblZuta);
		
		JLabel lblDodajBoju = new JLabel("Dodaj boju:");
		GridBagConstraints gbc_lblDodajBoju = new GridBagConstraints();
		gbc_lblDodajBoju.anchor = GridBagConstraints.EAST;
		gbc_lblDodajBoju.insets = new Insets(0, 0, 0, 5);
		gbc_lblDodajBoju.gridx = 0;
		gbc_lblDodajBoju.gridy = 3;
		pnlCenter.add(lblDodajBoju, gbc_lblDodajBoju);

		JComboBox cmbDodajBoju = new JComboBox();
		cmbDodajBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlm.addElement(cmbDodajBoju.getSelectedItem().toString());
				switch (cmbDodajBoju.getSelectedItem().toString()) {
				case "Zelena":
					lblDodajBoju.setForeground(Color.GREEN);
					break;
				case "Narandzasta":
					lblDodajBoju.setForeground(Color.ORANGE);
					break;
				case "Ljubicasta":
					lblDodajBoju.setForeground(Color.MAGENTA);
					break;
				default:
					lblDodajBoju.setForeground(Color.BLACK);
					break;
				}
			}
		});
		cmbDodajBoju.setModel(new DefaultComboBoxModel(new String[] {"Zelena", "Narandzasta", "Ljubicasta"}));
		GridBagConstraints gbc_cmbDodajBoju = new GridBagConstraints();
		gbc_cmbDodajBoju.insets = new Insets(0, 0, 0, 5);
		gbc_cmbDodajBoju.fill = GridBagConstraints.HORIZONTAL;
		gbc_cmbDodajBoju.gridx = 1;
		gbc_cmbDodajBoju.gridy = 3;
		pnlCenter.add(cmbDodajBoju, gbc_cmbDodajBoju);
		
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		pnlCenter.add(scrollPane, gbc_scrollPane);
		
		JList lstBoje = new JList();
		scrollPane.setViewportView(lstBoje);
		lstBoje.setModel(dlm);
		
		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(128, 255, 128));
		contentPane.add(pnlNorth, BorderLayout.NORTH);
		
		JLabel lblNaslov = new JLabel("Zadatak 1");
		lblNaslov.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		pnlNorth.add(lblNaslov);
		
		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		
		JButton btnKlik = new JButton("Klikni me");
		btnKlik.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Antistres dugme :)","Poruka",JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		pnlSouth.add(btnKlik);
		
		JButton btnDodajBoju = new JButton("Dodaj boju:");
		btnDodajBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dijalog = new DlgTest();
				dijalog.setVisible(true);

				if(dijalog.isOk() == true) {
					dlm.addElement(dijalog.getTxtRed().getText() + " " + 
										dijalog.getTxtGreen().getText() + " " +
										dijalog.getTxtBlue().getText());

				}
			} 
		});
		pnlSouth.add(btnDodajBoju);

		JButton btnIzmeniBoju = new JButton("Izmeni boju");
		btnIzmeniBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dijalog = new DlgTest();
				try {
				String [] splits = dlm.getElementAt(lstBoje.getSelectedIndex()).toString().split(" ");
				dijalog.getTxtRed().setText(splits[0]);
				dijalog.getTxtGreen().setText(splits[1]);
				dijalog.getTxtBlue().setText(splits[2]);
				dijalog.setVisible(true);

				if(dijalog.isOk() == true) {
					dlm.removeElementAt(lstBoje.getSelectedIndex());
					dlm.addElement(dijalog.getTxtRed().getText() + " " + 
										dijalog.getTxtGreen().getText() + " " +
										dijalog.getTxtBlue().getText());

				}
				}
				catch (Exception exc) {
					JOptionPane.showMessageDialog(null, "Selektuj adekvatnu boju",

								"Upozorenje", JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		pnlSouth.add(btnIzmeniBoju);
	}

}
