package gr.aueb.cf.schoolapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TeachersInsertForm extends JFrame {

	private static final long serialVersionUID = 123456;
	private JPanel contentPane;
	private JTextField firstnameTxt;
	private JTextField lastnameTxt;

	
	
	public TeachersInsertForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				firstnameTxt.setText("");
				lastnameTxt.setText("");
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(TeachersInsertForm.class.getResource("/resources/MicrosoftTeams-image (31).png")));
		setTitle("Εισαγωγή Εκπαιδευτή");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel firstnameLbl = new JLabel("Όνομα");
		firstnameLbl.setForeground(new Color(128, 0, 0));
		firstnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstnameLbl.setBounds(50, 45, 48, 33);
		contentPane.add(firstnameLbl);
		
		firstnameTxt = new JTextField();
		firstnameTxt.setBounds(124, 53, 142, 20);
		contentPane.add(firstnameTxt);
		firstnameTxt.setColumns(10);
		
		JLabel lastnameLbl_1 = new JLabel("Επώνυμο");
		lastnameLbl_1.setForeground(new Color(128, 0, 0));
		lastnameLbl_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastnameLbl_1.setBounds(50, 89, 64, 33);
		contentPane.add(lastnameLbl_1);
		
		lastnameTxt = new JTextField();
		lastnameTxt.setColumns(10);
		lastnameTxt.setBounds(124, 97, 142, 20);
		contentPane.add(lastnameTxt);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(25, 11, 329, 167);
		contentPane.add(panel);
		
		JButton insertBtn = new JButton("Εισαγωγή");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO TEACHERS (FIRSTNAME, LASTNAME) VALUES (?, ?)";
				
				try {
					String firstname = firstnameTxt.getText().trim();
					String lastname = lastnameTxt.getText().trim();
					
					if (firstname.equals("") || lastname.equals("")) {
						JOptionPane.showMessageDialog(null, "Empty firstname / lastname", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					Connection connection = Menu.getConnection();
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setString(1, firstname);
					ps.setString(2, lastname);
					
					int n = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, n + " rows affected", "Insert", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		insertBtn.setForeground(new Color(0, 0, 255));
		insertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertBtn.setBounds(122, 203, 111, 33);
		contentPane.add(insertBtn);
		
		JButton closeBtn = new JButton("Κλείσιμο");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getTeachersSearchForm().setEnabled(true);
				Main.getTeachersInsertForm().setVisible(false);
			}
		});
		closeBtn.setForeground(Color.BLUE);
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeBtn.setBounds(243, 203, 111, 33);
		contentPane.add(closeBtn);
	}
}
