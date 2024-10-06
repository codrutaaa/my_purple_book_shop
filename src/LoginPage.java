import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Label;
import java.awt.Toolkit;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.plaf.metal.MetalLookAndFeel;


public class LoginPage {

	private JFrame frame;
	private JTextField txtEmail;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JLabel background;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPage window = new LoginPage();
					
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginPage() {
		initialize();
		Connect();
	}
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;

	 
	public void Connect()
	    {
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection("jdbc:mysql://localhost/database1", "root","");
	        }
	        catch (ClassNotFoundException ex)
	        {
	          ex.printStackTrace();
	        }
	        catch (SQLException ex)
	        {
	            ex.printStackTrace();
	        }
	 
	    }
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(138, 43, 226));
		frame.getContentPane().setBackground(new Color(230, 230, 250));
		frame.setBounds(100, 100, 623, 440);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//adding de background
		
//		panel = new JPanel();
//		panel.setLayout(null);
//		
//		background = new JLabel(new ImageIcon("C:/Users/Codruta Alexandra/OneDrive/OneDrive - e-uvt.ro/Desktop/Background for App/library.jpg"));
//		background.setBounds(0, 0, 800, 600);
//		frame.add(background);
//
//		frame.setContentPane(panel);

		
		
		
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(73, 143, 73, 18);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_1.setBounds(73, 215, 73, 26);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		txtUsername = new JTextField();
		txtUsername.setHorizontalAlignment(SwingConstants.CENTER);
		txtUsername.setForeground(new Color(138, 43, 226));
		txtUsername.setColumns(10);
		txtUsername.setBounds(149, 170, 226, 31);
		frame.getContentPane().add(txtUsername);
		
		txtPassword = new JTextField();
		txtPassword.setHorizontalAlignment(SwingConstants.CENTER);
		txtPassword.setForeground(new Color(138, 43, 226));
		txtPassword.setColumns(10);
		txtPassword.setBounds(149, 251, 226, 31);
		frame.getContentPane().add(txtPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setForeground(new Color(138, 43, 226));
		btnLogin.setBackground(new Color(238, 130, 238));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String email = txtEmail.getText();
				String password = txtPassword.getText();
				String username = txtUsername.getText();
				
				
				if (password.contains("159") && email.contains("@purplebookshop.com")) {
					
					txtPassword.setText(null);
					txtUsername.setText(null);
					txtEmail.setText(null);
					
					JavaCrud info = new JavaCrud(); //adding the conn with the other main
					info.main(null);
					
					try {
						pst = con.prepareStatement("insert into login(email,username,password)values(?,?,?)");
						pst.setString(1, email);
						pst.setString(2, username);
						pst.setString(3, password);
						pst.executeUpdate();
						//JOptionPane.showMessageDialog(null, "Useeer Addedddd!!!!!");
					     }
						 
						catch (SQLException e1)
						        {
						e1.printStackTrace();
						}
					
				}else {
					
//					JOptionPane.showMessageDialog(null, "INVALID LOGIN DETAILS", "Login Error", JOptionPane.ERROR_MESSAGE);
//					txtPassword.setText(null);
//					txtUsername.setText(null);
					txtEmail.setText(null);
					txtPassword.setText(null);
					txtUsername.setText(null);
					
					ClientPage inf = new ClientPage(); //adding the con with the second jframe
					inf.main(null);
					
					try {
						pst = con.prepareStatement("insert into login(email,username,password)values(?,?,?)");
						pst.setString(1, email);
						pst.setString(2, username);
						pst.setString(3, password);
						pst.executeUpdate();
						//JOptionPane.showMessageDialog(null, "Useeer Addedddd!!!!!");
						         
						   }
						 
						catch (SQLException e1)
						        {
						e1.printStackTrace();
						}	
				}
				
			}
		});
		
		btnLogin.setBounds(56, 360, 90, 31);
		frame.getContentPane().add(btnLogin);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 309, 627, 2);
		frame.getContentPane().add(separator);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setForeground(new Color(138, 43, 226));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame=new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm to exit","Point of Sale", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
			}
		});
		btnExit.setBackground(new Color(238, 130, 238));
		btnExit.setBounds(480, 360, 90, 31);
		frame.getContentPane().add(btnExit);
		
		JLabel lblNewLabel_1_2 = new JLabel("For admin user log in with your employee credentials!");
		lblNewLabel_1_2.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_1_2.setBounds(98, 332, 410, 18);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Log In to Purple BookShop");
		lblNewLabel_1_2_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_2_1.setBackground(new Color(138, 43, 226));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1_2_1.setBounds(56, 10, 410, 41);
		frame.getContentPane().add(lblNewLabel_1_2_1);
		
		JButton btnSignup = new JButton("Sign Up");
		btnSignup.setForeground(new Color(138, 43, 226));
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtUsername.setText(null);
				txtPassword.setText(null);	
				SignUpPage inf = new SignUpPage(); //adding the con with the second jframe
				inf.main(null);
			}
		});
		
		btnSignup.setBackground(new Color(238, 130, 238));
		btnSignup.setBounds(263, 360, 90, 31);
		frame.getContentPane().add(btnSignup);
		Image img = new ImageIcon(this.getClass().getResource("/crt.png")).getImage();
		
		JLabel lblNewLabel_1_3 = new JLabel("Email");
		lblNewLabel_1_3.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_3.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1_3.setBounds(83, 61, 45, 18);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		txtEmail = new JTextField();
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setForeground(new Color(138, 43, 226));
		txtEmail.setColumns(10);
		txtEmail.setBounds(149, 87, 226, 31);
		frame.getContentPane().add(txtEmail);
		
		JLabel lblNewLabel_2 = new JLabel(" ");
		Image img1 = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img1));
		lblNewLabel_2.setBounds(83, 165, 45, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		//Image img2 = new ImageIcon(this.getClass().getResource("/lock.png")).getImage();
		
		JLabel lblNewLabel_4 = new JLabel(" ");
		Image img3 = new ImageIcon(this.getClass().getResource("/email.png")).getImage();
		lblNewLabel_4.setIcon(new ImageIcon(img3));
		lblNewLabel_4.setBounds(83, 89, 45, 26);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		Image img0 = new ImageIcon(this.getClass().getResource("/lockk.png")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img0));
		lblNewLabel_3.setBounds(83, 241, 53, 50);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_5 = new JLabel(" ");
		Image img4 = new ImageIcon(this.getClass().getResource("/b3.png")).getImage();
		lblNewLabel_5.setIcon(new ImageIcon(img4));
		lblNewLabel_5.setBounds(0, -9, 609, 412);
		frame.getContentPane().add(lblNewLabel_5);
		
		//Image img4 = new ImageIcon(this.getClass().getResource("/lock.png")).getImage();
		
	}
}
