package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import BUS.AccountBUS;
import DTO.Account;
import java.awt.SystemColor;

public class LoginGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage("F:\\eclipse-workspace\\PROJECT3_21_12_23\\icon\\icons8-hotel-48.png"));
		setTitle("LOGIN 卐LOGIN 卐LOGIN 卐LOGIN 卐");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setBounds(100, 100, 498, 513);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 482, 474);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 51, 51));
		panel_1.setBounds(10, 22, 462, 432);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		lblNewLabel.setBounds(50, 86, 158, 57);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1.setBounds(50, 144, 113, 25);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBorder(new LineBorder(Color.BLACK, 2));
		textField.setForeground(Color.BLACK);
		textField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		textField.setBounds(50, 180, 388, 43);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(50, 234, 113, 25);
		panel_1.add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(SystemColor.desktop);
		passwordField.setEchoChar('@');
		passwordField.setBorder(new LineBorder(Color.BLACK,2));
		passwordField.setFont(new Font("Segoe UI", Font.BOLD, 20));
		passwordField.setBounds(50, 270, 388, 43);
		panel_1.add(passwordField);
		
		JLabel lblNewLabel_2 = new JLabel("CALIFORNIA HOTEL");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 35));
		lblNewLabel_2.setForeground(new Color(255, 255, 0));
		lblNewLabel_2.setBounds(74, 26, 402, 49);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Admin login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton.setBorder(new LineBorder(Color.BLACK, 2));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(Color.GREEN);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				
				Account account = new Account(username, password);
				if (new AccountBUS().isValidAdmin(account)) {
					new EmployeeGUI();
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Login Failed");
				}
			}
		});
		btnNewButton.setBounds(50, 342, 191, 43);
		panel_1.add(btnNewButton);
		
		JButton btnEmployeeLogin = new JButton("Employee login");
		btnEmployeeLogin.setBorder(new LineBorder(Color.BLACK, 2));
		btnEmployeeLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String password = passwordField.getText();
				
				Account account = new Account(username, password);
				if (new AccountBUS().isValidManager(account)) {
					new KhachHangGUI();
					setVisible(false);
				}else {
					JOptionPane.showMessageDialog(null, "Login Failed");
				}
			}
		});
		btnEmployeeLogin.setForeground(new Color(0, 0, 0));
		btnEmployeeLogin.setBackground(Color.GREEN);
		btnEmployeeLogin.setFont(new Font("Segoe UI", Font.BOLD, 20));
		btnEmployeeLogin.setBounds(251, 342, 187, 43);
		panel_1.add(btnEmployeeLogin);
		setVisible(true);
	}
}
