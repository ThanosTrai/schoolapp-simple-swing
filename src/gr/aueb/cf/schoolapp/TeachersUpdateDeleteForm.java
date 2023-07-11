package gr.aueb.cf.schoolapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeachersUpdateDeleteForm extends JFrame {

	private static final long serialVersionUID = 123456;
	private JPanel contentPane;
	private JTextField idTxt;
	private JTextField firstnameTxt;
	private JTextField lastnameTxt;
	private JButton prevBtn;
	private JButton nextBtn;
	private JButton lastBtn;
	private JPanel panel;
	private JButton updateBtn;
	private JButton deleteBtn;
	private JButton closeBtn;
	private JSeparator separator;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public TeachersUpdateDeleteForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				String sql = "SELECT * FROM TEACHERS WHERE LASTNAME LIKE ?";
				Connection connection = Menu.getConnection();
				
				try {
					ps = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ps.setString(1, Main.getTeachersSearchForm().getLastname() + "%");
					rs = ps.executeQuery();
					
					if (rs.next()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					} else {
						JOptionPane.showMessageDialog(null, "No teachers found", "Teachers", JOptionPane.WARNING_MESSAGE);
						Main.getTeachersUpdateDeleteForm().setVisible(false);
						Main.getTeachersSearchForm().setEnabled(true);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel idLbl = new JLabel("ID");
		idLbl.setForeground(new Color(128, 0, 0));
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		idLbl.setBounds(87, 56, 17, 14);
		contentPane.add(idLbl);
		
		idTxt = new JTextField();
		idTxt.setBackground(new Color(255, 255, 153));
		idTxt.setEditable(false);
		idTxt.setBounds(128, 55, 33, 20);
		contentPane.add(idTxt);
		idTxt.setColumns(10);
		
		JLabel firstnameLbl = new JLabel("Όνομα");
		firstnameLbl.setForeground(new Color(128, 0, 0));
		firstnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstnameLbl.setBounds(56, 91, 48, 14);
		contentPane.add(firstnameLbl);
		
		firstnameTxt = new JTextField();
		firstnameTxt.setBounds(128, 90, 130, 20);
		contentPane.add(firstnameTxt);
		firstnameTxt.setColumns(10);
		
		JLabel lastnameLbl = new JLabel("Επώνυμο");
		lastnameLbl.setForeground(new Color(128, 0, 0));
		lastnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastnameLbl.setBounds(39, 134, 79, 14);
		contentPane.add(lastnameLbl);
		
		lastnameTxt = new JTextField();
		lastnameTxt.setColumns(10);
		lastnameTxt.setBounds(128, 133, 130, 20);
		contentPane.add(lastnameTxt);
		
		JButton firstBtn = new JButton("");
		firstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.first()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		firstBtn.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/MicrosoftTeams-image (32).png")));
		firstBtn.setBounds(56, 184, 48, 32);
		contentPane.add(firstBtn);
		
		prevBtn = new JButton("");
		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.previous()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					} else {
						rs.first();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		prevBtn.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/MicrosoftTeams-image (33).png")));
		prevBtn.setBounds(108, 184, 48, 32);
		contentPane.add(prevBtn);
		
		nextBtn = new JButton("");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.next()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					} else {
						rs.last();
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		nextBtn.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/MicrosoftTeams-image (34).png")));
		nextBtn.setBounds(172, 184, 48, 32);
		contentPane.add(nextBtn);
		
		lastBtn = new JButton("");
		lastBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (rs.last()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		lastBtn.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/MicrosoftTeams-image (35).png")));
		lastBtn.setBounds(223, 184, 48, 32);
		contentPane.add(lastBtn);
		
		panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(20, 30, 293, 144);
		contentPane.add(panel);
		
		updateBtn = new JButton("Ενημέρωση");
		updateBtn.setForeground(new Color(0, 0, 255));
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		updateBtn.setBounds(20, 241, 122, 40);
		contentPane.add(updateBtn);
		
		deleteBtn = new JButton("Διαγραφή");
		deleteBtn.setForeground(Color.BLUE);
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteBtn.setBounds(149, 241, 122, 40);
		contentPane.add(deleteBtn);
		
		closeBtn = new JButton("Κλείσιμο");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getTeachersSearchForm().setEnabled(true);
				Main.getTeachersUpdateDeleteForm().setVisible(false);
			}
		});
		closeBtn.setForeground(Color.BLUE);
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeBtn.setBounds(279, 241, 100, 40);
		contentPane.add(closeBtn);
		
		separator = new JSeparator();
		separator.setBounds(20, 228, 358, 2);
		contentPane.add(separator);
	}
}
