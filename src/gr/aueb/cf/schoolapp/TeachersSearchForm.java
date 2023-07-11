package gr.aueb.cf.schoolapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TeachersSearchForm extends JFrame {

	private static final long seriaVersionUID = 123456;
	private String lastname = "";
	private JPanel contentPane;
	private JTextField txtLastname;
	private JButton insertBtn;
	private JPanel panel_1;
	private JPanel panel;
	private JButton closeBtn;

	
	public TeachersSearchForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				txtLastname.setText("");
			}
		});
		setFont(new Font("Dialog", Font.PLAIN, 15));
		setTitle("Εισαγωγή / Αναζήτηση Εκπαιδευτή");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TeachersSearchForm.class.getResource("/resources/MicrosoftTeams-image (31).png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 477);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(250, 240, 230));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		insertBtn = new JButton("Εισαγωγή");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getTeachersInsertForm().setVisible(true);
				Main.getTeachersSearchForm().setEnabled(false);
			}
		});
		insertBtn.setBounds(149, 242, 139, 39);
		contentPane.add(insertBtn);
		insertBtn.setBackground(new Color(245, 245, 220));
		insertBtn.setForeground(Color.BLUE);
		insertBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		panel_1 = new JPanel();
		panel_1.setBounds(81, 203, 286, 110);
		contentPane.add(panel_1);
		
		JLabel lblLastname = new JLabel("Επώνυμο");
		lblLastname.setBounds(168, 38, 96, 22);
		contentPane.add(lblLastname);
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblLastname.setForeground(new Color(160, 82, 45));
		
		txtLastname = new JTextField();
		txtLastname.setBounds(111, 71, 236, 39);
		contentPane.add(txtLastname);
		txtLastname.setColumns(10);
		
		JButton searchBtn = new JButton("Αναζήτηση");
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastname = txtLastname.getText();
				Main.getTeachersUpdateDeleteForm().setVisible(true);
				Main.getTeachersSearchForm().setEnabled(false);
			}
		});
		searchBtn.setBounds(149, 121, 139, 34);
		contentPane.add(searchBtn);
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchBtn.setForeground(new Color(0, 0, 255));
		
		panel = new JPanel();
		panel.setBounds(81, 11, 286, 168);
		contentPane.add(panel);
		
		closeBtn = new JButton("Close");
		closeBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		closeBtn.setForeground(new Color(0, 0, 255));
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getMenu().setEnabled(true);
				Main.getTeachersSearchForm().setVisible(false);
			}
		});
		closeBtn.setBounds(278, 347, 89, 39);
		contentPane.add(closeBtn);
	}

	public String getLastname() {
		return lastname;
	}
	
	
}
