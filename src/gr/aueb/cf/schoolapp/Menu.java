package gr.aueb.cf.schoolapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

	private static final long serialVersionUID = 123456;
	private JPanel contentPane;
	private static Connection connection;

	public Menu() {
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				String username = "schooldbuser";
				String password = System.getenv("SCHOOL_DB_USER");
				String url = "jdbc:mysql://localhost:3306/schooldb?serverTimezone=UTC";
				
				try {
					
					//Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection(url, username, password);
					System.out.println("Connection established");
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/resources/MicrosoftTeams-image (31).png")));
		setForeground(new Color(240, 255, 255));
		setTitle("Μενού Διαχείρισης Σχολικού Συστήματος");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 482, 300);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 245, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton teachersBtn = new JButton("");
		teachersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getTeachersSearchForm().setVisible(true);
				Main.getMenu().setEnabled(false);
			}
		});
		teachersBtn.setBounds(21, 95, 48, 45);
		contentPane.add(teachersBtn);
		
		JButton studentsBtn = new JButton("");
		studentsBtn.setBounds(21, 162, 48, 45);
		contentPane.add(studentsBtn);
		
		JLabel lblEduQuality1 = new JLabel("Ποιότητα στην Εκπαίδευση");
		lblEduQuality1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEduQuality1.setForeground(new Color(0, 128, 128));
		lblEduQuality1.setBounds(48, 23, 358, 36);
		contentPane.add(lblEduQuality1);
		
		JLabel lblTeachers = new JLabel("Εκπαιδευτές");
		lblTeachers.setForeground(new Color(128, 0, 0));
		lblTeachers.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTeachers.setBounds(85, 111, 114, 19);
		contentPane.add(lblTeachers);
		
		JLabel lblStudents = new JLabel("Εκπαιδευόμενοι");
		lblStudents.setForeground(new Color(128, 0, 0));
		lblStudents.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudents.setBounds(85, 175, 132, 28);
		contentPane.add(lblStudents);
		
		JLabel lblEduQuality2 = new JLabel("Ποιότητα στην Εκπαίδευση");
		lblEduQuality2.setForeground(new Color(0, 0, 0));
		lblEduQuality2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEduQuality2.setBounds(49, 26, 358, 36);
		contentPane.add(lblEduQuality2);
	}
		
		public static Connection getConnection() {
			return connection;
	
	}
}
