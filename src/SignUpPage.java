import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.*;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.jgoodies.forms.factories.DefaultComponentFactory;

public class SignUpPage extends JFrame implements ActionListener {

	private JFrame frame;
	private JLabel lblUsername = new JLabel("Username: ");
	private JTextField txtUsername = new JTextField(20);
	private JLabel lblPassword = new JLabel("Password: ");
	private JPasswordField pwdPassword = new JPasswordField(20);
	private JLabel lblConfirmPassword = new JLabel("Confirm Password: ");
	private JPasswordField pwdConfirmPassword = new JPasswordField(20);
	private JButton btnSignUp = new JButton("Sign Up");
	private JButton btnCancel = new JButton("Cancel");	
	private JLabel lblEmail = new JLabel("Email:");
	private JTextField txtEmail = new JTextField(20);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpPage window = new SignUpPage();
					//window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUpPage() {
		getContentPane().setBackground(new Color(230, 230, 250));
		//initialize();
		
		Connect();
		 // Set the title and layout of the frame
	      setTitle("Sign Up");
	      getContentPane().setLayout(null);
	      lblUsername.setBounds(393, 154, 78, 26);
	      lblUsername.setForeground(new Color(153, 50, 204));
	      lblUsername.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 15));
	      getContentPane().add(lblUsername);
	      txtUsername.setBounds(329, 178, 194, 31);
	      getContentPane().add(txtUsername);
	      lblPassword.setBounds(393, 215, 78, 18);
	      lblPassword.setForeground(new Color(153, 50, 204));
	      lblPassword.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 15));
	      getContentPane().add(lblPassword);
	      pwdPassword.setBounds(329, 232, 194, 31);
	      getContentPane().add(pwdPassword);
	      lblConfirmPassword.setBounds(360, 267, 125, 18);
	      lblConfirmPassword.setForeground(new Color(153, 50, 204));
	      lblConfirmPassword.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 15));
	      getContentPane().add(lblConfirmPassword);
	      pwdConfirmPassword.setBounds(329, 285, 194, 31);
	      getContentPane().add(pwdConfirmPassword);
	      btnSignUp.setBounds(22, 311, 90, 29);
	      getContentPane().add(btnSignUp);
	      btnSignUp.setForeground(new Color(138, 43, 226));
	      btnSignUp.setBackground(new Color(238, 130, 238));
	      btnCancel.setBounds(22, 380, 90, 29);
	      getContentPane().add(btnCancel);
	      btnCancel.setForeground(new Color(138, 43, 226));
	      btnCancel.setBackground(new Color(238, 130, 238));
	      
	      JLabel lblNewJgoodiesLabel = DefaultComponentFactory.getInstance().createLabel("Sign Up Here to Purple BookShop");
	      lblNewJgoodiesLabel.setBounds(317, 0, 278, 44);
	      lblNewJgoodiesLabel.setForeground(new Color(153, 50, 204));
	      lblNewJgoodiesLabel.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 18));
	      getContentPane().add(lblNewJgoodiesLabel);
	      lblEmail.setBounds(397, 99, 53, 18);
	      lblEmail.setForeground(new Color(153, 50, 204));
	      lblEmail.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 15));
	      
	      getContentPane().add(lblEmail);
	      txtEmail.setBounds(329, 123, 194, 31);
	      
	      getContentPane().add(txtEmail);
	      
	      Image img = new ImageIcon(this.getClass().getResource("/email.png")).getImage();
	      lblNewLabel.setIcon(new ImageIcon(img));
	      lblNewLabel.setBounds(276, 111, 47, 55);
	      getContentPane().add(lblNewLabel);
	      
	      Image img1 = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
	      lblNewLabel_1.setIcon(new ImageIcon(img1));
	      lblNewLabel_1.setBounds(276, 162, 47, 63);
	      getContentPane().add(lblNewLabel_1);
	      
	      Image img2 = new ImageIcon(this.getClass().getResource("/lockk.png")).getImage();
	      lblNewLabel_2.setIcon(new ImageIcon(img2));
	      lblNewLabel_2.setBounds(276, 219, 53, 55);
	      getContentPane().add(lblNewLabel_2);
	      
	      Image img3 = new ImageIcon(this.getClass().getResource("/confirmPass.png")).getImage();
	      lblNewLabel_3.setIcon(new ImageIcon(img3));
	      lblNewLabel_3.setBounds(276, 273, 47, 55);
	      getContentPane().add(lblNewLabel_3);
	      
	      Image img4 = new ImageIcon(this.getClass().getResource("/trylogo.PNG")).getImage();
	      lblNewLabel_4.setIcon(new ImageIcon(img4));
	      lblNewLabel_4.setBounds(0, 0, 595, 419);
	      getContentPane().add(lblNewLabel_4);
	      
	      
	      
	      
	     
		  
	      // Add action listeners to the buttons
	      btnSignUp.addActionListener(this);
	      btnCancel.addActionListener(this);
	      
	      // Set the size and location of the frame
	      setSize(609, 456);
	      setLocationRelativeTo(null);
	      
	      // Set the default close operation and make the frame visible
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setVisible(true);
	   }
	   
	   public void actionPerformed(ActionEvent event) {
	      // Get the source of the action
	      Object source = event.getSource();
	      
	      // If the user clicks the Sign Up button, check the input and attempt to sign up
	      if (source == btnSignUp) {
	         // Get the entered username and passwords
	    	 String email = txtEmail.getText();
	         String username = txtUsername.getText();
	         String password = new String(pwdPassword.getPassword());
	         String confirmPassword = new String(pwdConfirmPassword.getPassword());
	         try {
					pst = con.prepareStatement("insert into signup(email,username,password,confirmPassword)values(?,?,?,?)");
					pst.setString(1, email);
					pst.setString(2, username);
					pst.setString(3, password);
					pst.setString(4, confirmPassword);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
					//table_load();
					
					txtEmail.setText("");        
					txtUsername.setText("");
					pwdPassword.setText("");
					pwdConfirmPassword.setText("");
					   }
					 
					catch (SQLException e1)
					        {
					e1.printStackTrace();
					}
	         
	         
	         
	         
	         // Check if the input is valid and attempt to sign up
	         if (username.length() == 0 || password.length() == 0 || confirmPassword.length() == 0) {
	            JOptionPane.showMessageDialog(this, "Please enter a username and password.", "Error", JOptionPane.ERROR_MESSAGE);
	         } else if (!password.equals(confirmPassword)) {
	            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Error", JOptionPane.ERROR_MESSAGE);
	         } else {
	           
	        	 if (password.contains("1")) {
	        		 pwdPassword.setText(null);
	        		 pwdConfirmPassword.setText(null);
					 txtUsername.setText(null);
					 txtEmail.setText(null);
					 ClientPage info = new ClientPage();
					 info.main(null);
	            } else {
	               JOptionPane.showMessageDialog(this, "Username is already taken.", "Error", JOptionPane.ERROR_MESSAGE);
	            }
	         }
	      }
	      
	      // If the user clicks the Cancel button, close the Sign Up page
	      if (source == btnCancel) {
	         dispose();
	      }
	   }
	   
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private final JLabel lblNewLabel = new JLabel(" ");
	private final JLabel lblNewLabel_1 = new JLabel(" ");
	private final JLabel lblNewLabel_2 = new JLabel(" ");
	private final JLabel lblNewLabel_3 = new JLabel(" ");
	private final JLabel lblNewLabel_4 = new JLabel(" ");
	

	
	
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
}