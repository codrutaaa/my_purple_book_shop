import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;
import javax.mail.*;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.LayoutManager;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.TextField;
import javax.swing.border.BevelBorder;
import java.awt.Panel;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.SystemColor;
import java.awt.Dimension;
import java.awt.Scrollbar;

public class ClientPage extends JFrame {
    String iTax, iSubtotal, iTotal;
    double [] itemcost = new double [60];
	private JPanel contentPane;
	private JTextField jtxtTax;
	private JTextField jtxtSubtotal;
	private JTextField jtxtTotal;
	private JTextField jtxtDisplay;
	private JTextField jtxtChange;
	private JFrame frame;
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientPage frame = new ClientPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	

	
	public ClientPage() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {	
				
				textField_11.setEnabled(false);
				textField_12.setEnabled(false);
				textField_13.setEnabled(false);
				textField_14.setEnabled(false);
				textField_15.setEnabled(false);
				textField_16.setEnabled(false);
				textField_17.setEnabled(false);
				textField_18.setEnabled(false);
				textField_19.setEnabled(false);
				textField_20.setEnabled(false);
				
				
				
			}
		});
		initialize();
		Connect();
	}
	
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	
	private JTable TABLE;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField chckbxNewCheckBox_1;
	private JTextField chckbxNewCheckBox_2;
	private JTextField chckbxNewCheckBox_3;
	private JTextField chckbxNewCheckBox_4;
	private JTextField chckbxNewCheckBox;
	private JTextField chckbxNewCheckBox_3_1;
	private JTextField chckbxNewCheckBox_3_2;
	private JTextField chckbxNewCheckBox_3_3;
	private JTextField chckbxNewCheckBox_3_4;
	private JTextField chckbxNewCheckBox_3_5;
	private JTextField chckbxNewCheckBox_3_6;
	private JTextField chckbxNewCheckBox_1_1;
	private JTextField chckbxNewCheckBox_2_1;
	private JTextField chckbxNewCheckBox_3_7;
	private JTextField chckbxNewCheckBox_3_1_1;
	private JTextField chckbxNewCheckBox_3_2_1;
	private JTextField chckbxNewCheckBox_3_3_1;
	private JTextField chckbxNewCheckBox_3_4_1;
	private JTextField chckbxNewCheckBox_3_5_1;
	private JTextField chckbxNewCheckBox_3_6_1;
	private JTextField textField;

	 
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
	

	//---------------------------------------------------------Functii (beta)-------------------------------------------------------------------
//	
//	public void ItemCost() {
//		//the calculation of the price
//		double sum=0;
//		double tax=3.9;
//		for(int i=0;i<TABLE.getRowCount();i++) {
//			sum=sum + Double.parseDouble(TABLE.getValueAt(i, 3).toString());
//		}
//		
//		jtxtSubtotal.setText(Double.toString(sum));
//		double cTotal = Double.parseDouble(jtxtSubtotal.getText());
//		
//		double cTax = (cTotal * tax)/100;
//		String iTaxTotal = String.format("lei %.2f", cTax);
//		jtxtTax.setText(iTaxTotal);
//		
//		String iSubtotal = String.format("lei %.2f", cTotal);
//		jtxtSubtotal.setText(iSubtotal);
//		
//		String iTotal = String.format("lei %.2f", cTotal + cTax);
//		jtxtTotal.setText(iTotal);
//			
//	}
//	
//	//the function for the change
//	public void Change() {
//		//the calculation of the price
//		double sum=0;
//		double tax=3.9;
//		double cash=Double.parseDouble(jtxtDisplay.getText());
//		
//		for(int i=0;i<TABLE.getRowCount();i++) {
//			sum=sum + Double.parseDouble(TABLE.getValueAt(i, 3).toString());
//		}
//		
//		double cTax = (tax*sum)/100;
//		double cChange = (cash - (sum + cTax));
//		String ChangeGiven = String.format("lei %.2f", cChange);
//		jtxtChange.setText(ChangeGiven);
//	
//	
//	
//	}
//	
	
	//------------------------------------------------------------------------------------------------------------------------------------------------------------
	

	
	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1310, 627);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 255, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnNewButton_2_1 = new JButton("View");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost/database1", "root","");
		            Statement st = con.createStatement();
		            String query = "select * from book";
		            ResultSet rs = st.executeQuery(query);
		            ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) TABLE.getModel();
		            
		            
		            int cols = rsmd.getColumnCount();
		            String[] colName = new String[cols];
		            for(int i=0;i<cols;i++) {
		            	colName[i] = rsmd.getColumnName(i+1);
		        
		            }
		            model.setColumnIdentifiers(colName);
		            
		            String id, name, price, edition, quantity,description;
		            while(rs.next()) {
		            	id=rs.getString(1);
		            	name=rs.getString(2);
		            	price=rs.getString(3);
		            	edition=rs.getString(4);
		            	quantity=rs.getString(5);
		            	description=rs.getString(6);
		            	String[] row = {id, name, price, edition, quantity, description};
		            	model.addRow(row);  	
		            }
		            st.close();
		            con.close();
		            
		            
		            
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
			}
		});
		btnNewButton_2_1.setBackground(new Color(225, 168, 247));
		btnNewButton_2_1.setActionCommand("JButton2");
		btnNewButton_2_1.setBounds(154, 433, 118, 30);
		contentPane.add(btnNewButton_2_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(415, 433, 281, 101);
		contentPane.add(panel);
		panel.setLayout(null);
		
		TextField jtxtTax = new TextField();
		jtxtTax.setText("0");
		jtxtTax.setBounds(124, 10, 136, 21);
		panel.add(jtxtTax);
		
		JLabel lblNewLabel = new JLabel("TAX");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(39, 10, 60, 21);
		panel.add(lblNewLabel);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTotal.setBounds(39, 70, 60, 21);
		panel.add(lblTotal);
		
		TextField jtxtTotal = new TextField();
		jtxtTotal.setText("0");
		jtxtTotal.setBounds(124, 70, 136, 21);
		panel.add(jtxtTotal);
		
		JLabel lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSubtotal.setBounds(39, 41, 60, 21);
		panel.add(lblSubtotal);
		
		TextField jtxtSubtotal = new TextField();
		jtxtSubtotal.setText("0");
		jtxtSubtotal.setBounds(124, 43, 136, 21);
		panel.add(jtxtSubtotal);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setLayout(null);
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(767, 433, 299, 101);
		contentPane.add(panel_2);
		
		JLabel lblPayMethod = new JLabel("Pay Method");
		lblPayMethod.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPayMethod.setBounds(26, 10, 87, 21);
		panel_2.add(lblPayMethod);
		
		JComboBox jcboPayment = new JComboBox();
		jcboPayment.setModel(new DefaultComboBoxModel(new String[] {"", "Cash", "Card to Delivery"}));
		jcboPayment.setFont(new Font("Tahoma", Font.BOLD, 19));
		jcboPayment.setBounds(107, 12, 182, 21);
		panel_2.add(jcboPayment);
		
		JButton jbtnPrint = new JButton("Total");
		jbtnPrint.setBounds(10, 41, 85, 21);
		panel_2.add(jbtnPrint);
		
		JButton jbtnExit = new JButton("Exit");
		jbtnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame=new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame, "Confirm to exit","Point of Sale", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
				
			}
		});
		jbtnExit.setBounds(204, 43, 85, 21);
		panel_2.add(jbtnExit);
		///////////////////////////////////
		//////////from here I need to continue the email sender
		
		JButton jbtnPay = new JButton("Pay");
		jbtnPay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				try {
//					pst = con.prepareStatement("select email,  from login order by id desc limit 1");
//					rs = pst.executeQuery();
//					String recipient = "recipient@example.com";
//					String subject = "Payment Confirmation";
//					String body = "Your payment has been successfully processed.";
//					EmailSender.sendEmail(recipient, subject, body);
//				
//				
//					
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				
			
				

				
				frame=new JFrame("Pay");
				if(JOptionPane.showConfirmDialog(frame, "Confirm your payment","Point of Sale", JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}	
			}
		});
		jbtnPay.setBounds(107, 70, 85, 21);
		panel_2.add(jbtnPay);
		jbtnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				itemcost[0]=Double.parseDouble(textField_11.getText())*125.50;
				itemcost[1]=Double.parseDouble(textField_12.getText())*25.50;
				itemcost[2]=Double.parseDouble(textField_13.getText())*15.50;
				itemcost[3]=Double.parseDouble(textField_14.getText())*100.50;
				itemcost[4]=Double.parseDouble(textField_15.getText())*45.20;
				itemcost[5]=Double.parseDouble(textField_16.getText())*76.50;
				itemcost[6]=Double.parseDouble(textField_17.getText())*15.30;
				itemcost[7]=Double.parseDouble(textField_18.getText())*12.50;
				itemcost[8]=Double.parseDouble(textField_19.getText())*1.50;
				itemcost[9]=Double.parseDouble(textField_20.getText())*111.20;				
				
				itemcost[54]=itemcost[0]+itemcost[1]+itemcost[2]+itemcost[3]+itemcost[4]+itemcost[5]+itemcost[6]+itemcost[7]+itemcost[8]+itemcost[9];
				iTax=String.format("Lei %.2f", itemcost[54]/100);
				iSubtotal=String.format("Lei %.2f", itemcost[54]);
				iTotal=String.format("Lei %.2f", itemcost[54]+(itemcost[54]/100));
				
				jtxtTax.setText(iTax);
				jtxtTotal.setText(iTotal);
				jtxtSubtotal.setText(iSubtotal);
				
			}
		});
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 53, 394, 355);
		contentPane.add(scrollPane);
		
		TABLE = new JTable();
		TABLE.setBorder(null);
		TABLE.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"id", "name", "edition", "price", "quantity", "description"
			}
		));
		TABLE.getColumnModel().getColumn(0).setPreferredWidth(31);
		TABLE.getColumnModel().getColumn(1).setPreferredWidth(128);
		TABLE.getColumnModel().getColumn(2).setPreferredWidth(43);
		TABLE.getColumnModel().getColumn(3).setPreferredWidth(38);
		TABLE.getColumnModel().getColumn(4).setPreferredWidth(52);
		TABLE.getColumnModel().getColumn(5).setPreferredWidth(161);
		TABLE.setBackground(new Color(230, 230, 250));
		TABLE.setFillsViewportHeight(true);
		scrollPane.setViewportView(TABLE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(230, 230, 250));
		panel_1.setBounds(1005, 53, 257, 359);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3_1_2_1 = new JPanel();
		panel_3_1_2_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_3_1_2_1.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_3_1_2_1.setBackground(new Color(225, 168, 247));
		panel_3_1_2_1.setBounds(10, 8, 105, 341);
		panel_1.add(panel_3_1_2_1);
		
		JCheckBox chckbx_1 = new JCheckBox("Carte de bucate");
		chckbx_1.setBounds(0, 5, 99, 21);
		chckbx_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx_1.isSelected()) {
					textField_11.setEnabled(true);
					textField_11.setText("");
					textField_11.requestFocus();
				}else {
					textField_11.setEnabled(false);
					textField_11.setText("0");	
				}
				
			}
		});
		panel_3_1_2_1.setLayout(null);
		chckbx_1.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx_1.setEnabled(false);
		panel_3_1_2_1.add(chckbx_1);
		
		JCheckBox chckbx_2 = new JCheckBox("One of us Lying");
		chckbx_2.setBounds(2, 31, 95, 21);
		chckbx_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx_2.isSelected()) {
					textField_12.setEnabled(true);
					textField_12.setText("");
					textField_12.requestFocus();
				}else {
					textField_12.setEnabled(false);
					textField_12.setText("0");	
				}
				
			}
		});
		chckbx_2.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx_2.setEnabled(false);
		panel_3_1_2_1.add(chckbx_2);
		
		JCheckBox chckbx_3 = new JCheckBox("What if?");
		chckbx_3.setBounds(17, 57, 63, 21);
		chckbx_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//textField_13
				if(chckbx_3.isSelected()) {
					textField_13.setEnabled(true);
					textField_13.setText("");
					textField_13.requestFocus();
				}else {
					textField_13.setEnabled(false);
					textField_13.setText("0");	
				}
			}
		});
		chckbx_3.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx_3.setEnabled(false);
		panel_3_1_2_1.add(chckbx_3);
		
		JCheckBox chckbx_4 = new JCheckBox("No one");
		chckbx_4.setBounds(20, 83, 57, 21);
		chckbx_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx_4.isSelected()) {
					textField_14.setEnabled(true);
					textField_14.setText("");
					textField_14.requestFocus();
				}else {
					textField_14.setEnabled(false);
					textField_14.setText("0");	
				}
			}
		});
		chckbx_4.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx_4.setEnabled(false);
		panel_3_1_2_1.add(chckbx_4);
		
		JCheckBox chckbx_5 = new JCheckBox("I can't hear you");
		chckbx_5.setBounds(1, 109, 97, 21);
		chckbx_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx_5.isSelected()) {
					textField_15.setEnabled(true);
					textField_15.setText("");
					textField_15.requestFocus();
				}else {
					textField_15.setEnabled(false);
					textField_15.setText("0");	
				}
			}
		});
		chckbx_5.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx_5.setEnabled(false);
		panel_3_1_2_1.add(chckbx_5);
		
		JCheckBox chckbx_6 = new JCheckBox("Bring to us");
		chckbx_6.setBounds(2, 132, 75, 21);
		chckbx_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx_6.isSelected()) {
					textField_16.setEnabled(true);
					textField_16.setText("");
					textField_16.requestFocus();
				}else {
					textField_16.setEnabled(false);
					textField_16.setText("0");	
				}
			}
		});
		chckbx_6.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx_6.setEnabled(false);
		panel_3_1_2_1.add(chckbx_6);
		
		JCheckBox chckbx_7 = new JCheckBox("TOP 100 FINDS");
		chckbx_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx_7.isSelected()) {
					textField_17.setEnabled(true);
					textField_17.setText("");
					textField_17.requestFocus();
				}else {
					textField_17.setEnabled(false);
					textField_17.setText("0");	
				}
			}
		});
		chckbx_7.setBounds(2, 161, 95, 21);
		chckbx_7.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx_7.setEnabled(false);
		panel_3_1_2_1.add(chckbx_7);
		
		JCheckBox chckbx_8 = new JCheckBox("What about us?");
		chckbx_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx_8.isSelected()) {
					textField_18.setEnabled(true);
					textField_18.setText("");
					textField_18.requestFocus();
				}else {
					textField_18.setEnabled(false);
					textField_18.setText("0");
				}
			}
		});
		chckbx_8.setBounds(1, 187, 97, 21);
		chckbx_8.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx_8.setEnabled(false);
		panel_3_1_2_1.add(chckbx_8);
		
		JCheckBox chckbx_9 = new JCheckBox("Look at you");
		chckbx_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx_9.isSelected()) {
					textField_19.setEnabled(true);
					textField_19.setText("");
					textField_19.requestFocus();
				}else {
					textField_19.setEnabled(false);
					textField_19.setText("0");
				}
			}
		});
		chckbx_9.setBounds(10, 213, 77, 21);
		chckbx_9.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx_9.setEnabled(false);
		panel_3_1_2_1.add(chckbx_9);
		
		JCheckBox chckbx_10 = new JCheckBox("How to think positive");
		chckbx_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(chckbx_10.isSelected()) {
					textField_20.setEnabled(true);
					textField_20.setText("");
					textField_20.requestFocus();
				}else {
					textField_20.setEnabled(false);
					textField_20.setText("0");
				}
			}
		});
		chckbx_10.setBounds(-10, 239, 119, 21);
		chckbx_10.setHorizontalAlignment(SwingConstants.LEFT);
		chckbx_10.setEnabled(false);
		panel_3_1_2_1.add(chckbx_10);
		
		JPanel panel_3_1_1_1 = new JPanel();
		panel_3_1_1_1.setBackground(new Color(225, 168, 247));
		panel_3_1_1_1.setBounds(125, 8, 121, 341);
		panel_1.add(panel_3_1_1_1);
		panel_3_1_1_1.setLayout(null);
		
		textField_11 = new JTextField();
		textField_11.setBounds(12, 5, 96, 19);
		textField_11.setHorizontalAlignment(SwingConstants.CENTER);
		textField_11.setText("0");
		textField_11.setColumns(10);
		panel_3_1_1_1.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setBounds(12, 29, 96, 19);
		textField_12.setHorizontalAlignment(SwingConstants.CENTER);
		textField_12.setText("0");
		textField_12.setColumns(10);
		panel_3_1_1_1.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setBounds(12, 53, 96, 19);
		textField_13.setHorizontalAlignment(SwingConstants.CENTER);
		textField_13.setText("0");
		textField_13.setColumns(10);
		panel_3_1_1_1.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setBounds(12, 77, 96, 19);
		textField_14.setHorizontalAlignment(SwingConstants.CENTER);
		textField_14.setText("0");
		textField_14.setColumns(10);
		panel_3_1_1_1.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setBounds(12, 101, 96, 19);
		textField_15.setHorizontalAlignment(SwingConstants.CENTER);
		textField_15.setText("0");
		textField_15.setColumns(10);
		panel_3_1_1_1.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setBounds(12, 125, 96, 19);
		textField_16.setHorizontalAlignment(SwingConstants.CENTER);
		textField_16.setText("0");
		textField_16.setColumns(10);
		panel_3_1_1_1.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setBounds(12, 154, 96, 19);
		textField_17.setHorizontalAlignment(SwingConstants.CENTER);
		textField_17.setText("0");
		textField_17.setColumns(10);
		panel_3_1_1_1.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setBounds(12, 183, 96, 19);
		textField_18.setHorizontalAlignment(SwingConstants.CENTER);
		textField_18.setText("0");
		textField_18.setColumns(10);
		panel_3_1_1_1.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setBounds(12, 212, 96, 19);
		textField_19.setHorizontalAlignment(SwingConstants.CENTER);
		textField_19.setText("0");
		textField_19.setColumns(10);
		panel_3_1_1_1.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setBounds(12, 241, 96, 19);
		textField_20.setHorizontalAlignment(SwingConstants.CENTER);
		textField_20.setText("0");
		textField_20.setColumns(10);
		panel_3_1_1_1.add(textField_20);
		
		JLabel lblNewLabel_1 = new JLabel("See our stock");
		lblNewLabel_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(173, 25, 112, 18);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Add in your cart");
		lblNewLabel_1_1_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_1_1.setBounds(1021, 25, 241, 18);
		contentPane.add(lblNewLabel_1_1_1);
		
		//JScrollPane scrollBar= new JScrollPane(panel_4, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(468, 53, 509, 353);
		contentPane.add(panel_4);
		panel_4.setBorder(null);
		panel_4.setBackground(new Color(230, 230, 250));
		
		JButton btnNewButton_5 = new JButton("Bring to us");
		btnNewButton_5.setBounds(181, 270, 105, 42);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_6.setEnabled(true);
				if (e.getSource() == btnNewButton_5) {
				      saveBookToDatabase("Bring to us","5");
				    }
			}
			
			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2,quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
			
		});
		panel_4.setLayout(null);
		panel_4.setLayout(null);
		panel_4.add(btnNewButton_5);
		
		JButton btnNewButton_7 = new JButton("One of us is Lying");
		btnNewButton_7.setBounds(10, 182, 115, 42);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_2.setEnabled(true);
				if (e.getSource() == btnNewButton_7) {
				      saveBookToDatabase("One of us is Lying", "2");
				    }
				
			}
			

			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
			
			
		});
		panel_4.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("What if?");
		btnNewButton_8.setBounds(27, 270, 115, 42);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_3.setEnabled(true);
				if (e.getSource() == btnNewButton_8) {
				      saveBookToDatabase("What if?","1");
				    }
				
				
			}
			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
			
		});
		panel_4.add(btnNewButton_8);
		
		JButton btnNewButton_5_1 = new JButton("I can't hear you");
		btnNewButton_5_1.setBounds(135, 182, 105, 42);
		btnNewButton_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_5.setEnabled(true);
				if (e.getSource() == btnNewButton_5_1) {
				      saveBookToDatabase("I can't hear you", "1");
				    }
				
				
				
			}
			
			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
		});
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 0, 0);
		panel_4.add(scrollPane_1);
		panel_4.add(btnNewButton_5_1);
		
		JButton btnNewButton_5_2 = new JButton("No one");
		btnNewButton_5_2.setBounds(135, 102, 105, 42);
		btnNewButton_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_4.setEnabled(true);
				if (e.getSource() == btnNewButton_5_2) {
				      saveBookToDatabase("No one","1");
				    }
				
				
				
			}
			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
			
			
		});
		panel_4.add(btnNewButton_5_2);
		
		JButton btnNewButton_5_3 = new JButton("Look at you");
		btnNewButton_5_3.setBounds(337, 270, 105, 42);
		btnNewButton_5_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_9.setEnabled(true);
				if (e.getSource() == btnNewButton_5_3) {
				      saveBookToDatabase("Look at you","5");
				    }
			}
			
			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
		});
		panel_4.add(btnNewButton_5_3);
		
		JButton btnNewButton_5_4 = new JButton("What about us?");
		btnNewButton_5_4.setBounds(250, 182, 105, 42);
		btnNewButton_5_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_8.setEnabled(true);
				if (e.getSource() == btnNewButton_5_4) {
				      saveBookToDatabase("What about us?", "1");
				    }
			}
			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
		});
		panel_4.add(btnNewButton_5_4);
		
		JButton btnNewButton_5_5 = new JButton("TOP 100 FINDS");
		btnNewButton_5_5.setBounds(250, 102, 105, 42);
		btnNewButton_5_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_7.setEnabled(true);
				if (e.getSource() == btnNewButton_5_5) {
				      saveBookToDatabase("TOP 100 FINDS","1");
				    }
			}
			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
		});
		panel_4.add(btnNewButton_5_5);
		
		JButton btnNewButton_5_5_1 = new JButton("How to think positive");
		btnNewButton_5_5_1.setBounds(365, 102, 107, 42);
		btnNewButton_5_5_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_10.setEnabled(true);
				if (e.getSource() == btnNewButton_5_5_1) {
				      saveBookToDatabase("How to think positive","2");
				    }
			}
			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
		});
		panel_4.add(btnNewButton_5_5_1);
		
		JButton btnNewButton_5_5_2 = new JButton("Learn C/C++");
		btnNewButton_5_5_2.setBounds(365, 182, 107, 42);
		btnNewButton_5_5_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_7.setEnabled(true);
				if (e.getSource() == btnNewButton_5_5_2) {
				      saveBookToDatabase("Learn C/C++","1");
				    }
			}
			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
		});
		panel_4.add(btnNewButton_5_5_2);
		
		
		
		JButton btnNewButton_6 = new JButton("Carte de bucate");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				chckbx_1.setEnabled(true);
				
				if (e.getSource() == btnNewButton_6) {
				      saveBookToDatabase("Carte de bucate", "1");
				    }
			}
			
			private void saveBookToDatabase(String name, String quantity) {
			    String sql = "INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
			
			
		});
		btnNewButton_6.setBounds(10, 102, 115, 42);
		panel_4.add(btnNewButton_6);
		
	
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Click to add your favourite in the cart");
		lblNewLabel_1_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_1.setBounds(135, 24, 241, 18);
		panel_4.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 14));
		
		Scrollbar scrollbar = new Scrollbar();
		scrollbar.setBounds(478, 76, 21, 221);
		panel_4.add(scrollbar);
		
		JLabel lblNewLabel_3 = new JLabel(" ");
		Image img3 = new ImageIcon(this.getClass().getResource("/r4.jpg")).getImage();
		lblNewLabel_3.setIcon(new ImageIcon(img3));
		lblNewLabel_3.setBounds(-276, -13, 1657, 686);
		contentPane.add(lblNewLabel_3);
		


		
		
	}
}
