import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseListener;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JavaCrud {

	private JFrame frame;
	private JTextField txtbname;
	private JTextField txtedition;
	private JTextField txtprice;
	private JTable table;
	private JTextField txtbid;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCrud window = new JavaCrud();
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
	public JavaCrud() {
		
		initialize();
		Connect();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JTextField txtquantity;
	private JTextField txtbname1;
	private JTable table_1;
	private JTextField txtDesc;
	private JTable table_2;
	 
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
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.setBounds(100, 100, 959, 647);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Purple BookShop");
		lblNewLabel.setForeground(new Color(153, 50, 204));
		lblNewLabel.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel.setBounds(335, 25, 227, 56);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(230, 230, 250));
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(34, 91, 400, 365);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(35, 27, 90, 18);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Edition");
		lblNewLabel_1_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_1.setBounds(35, 96, 90, 18);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_2.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_2.setBounds(35, 165, 90, 18);
		panel.add(lblNewLabel_1_2);
		
		txtbname = new JTextField();
		txtbname.setBounds(45, 55, 226, 31);
		panel.add(txtbname);
		txtbname.setColumns(10);
		
		txtedition = new JTextField();
		txtedition.setColumns(10);
		txtedition.setBounds(45, 124, 226, 31);
		panel.add(txtedition);
		
		txtprice = new JTextField();
		txtprice.setColumns(10);
		txtprice.setBounds(45, 193, 226, 31);
		panel.add(txtprice);
		
		txtquantity = new JTextField();
		txtquantity.setColumns(10);
		txtquantity.setBounds(45, 260, 226, 31);
		panel.add(txtquantity);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Quantity");
		lblNewLabel_1_2_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_2_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_2_1.setBounds(35, 234, 90, 18);
		panel.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Description");
		lblNewLabel_1_2_1_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_2_1_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_2_1_1.setBounds(35, 294, 90, 18);
		panel.add(lblNewLabel_1_2_1_1);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(45, 322, 226, 31);
		panel.add(txtDesc);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bname,edition,price,quantity, description;
				bname = txtbname.getText();
				edition = txtedition.getText();
				price = txtprice.getText();
				quantity = txtquantity.getText();
				description = txtDesc.getText();
				
				try {
				pst = con.prepareStatement("insert into book(name,edition,price,quantity, description)values(?,?,?,?,?)");
				pst.setString(1, bname);
				pst.setString(2, edition);
				pst.setString(3, price);
				pst.setString(4, quantity);
				pst.setString(5, description);
				pst.executeUpdate();
				JOptionPane.showMessageDialog(null, "Record Addedddd!!!!!");
				//table_load();
				          
				txtbname.setText("");
				txtedition.setText("");
				txtprice.setText("");
				txtquantity.setText("");
				txtDesc.setText("");
				txtbname.requestFocus();
				   }
				 
				catch (SQLException e1)
				        {
				e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(22, 466, 126, 30);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.setBounds(174, 466, 108, 30);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setBounds(308, 466, 126, 30);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(47, 506, 374, 65);
		frame.getContentPane().add(scrollPane_1);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(230, 230, 250));
		scrollPane_1.setViewportView(panel_1);
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_4 = new JLabel("Book ID");
		lblNewLabel_1_4.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_4.setBounds(66, 12, 65, 18);
		lblNewLabel_1_4.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 14));
		panel_1.add(lblNewLabel_1_4);
		
		txtbid = new JTextField();
		txtbid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {       
		            String id = txtbid.getText();
		                pst = con.prepareStatement("select name, edition , price, quantity, description from book where id = ?");
		                pst.setString(1, id);
		                ResultSet rs = pst.executeQuery();
		            if(rs.next()==true)
		            {
		                String name = rs.getString(1);
		                String edition = rs.getString(2);
		                String price = rs.getString(3);
		                String quantity = rs.getString(4);
		                String description = rs.getString(5);
		                
		                txtbname.setText(name);
		                txtedition.setText(edition);
		                txtprice.setText(price); 
		                txtquantity.setText(quantity);
		                txtDesc.setText(description);          
		           }  
		            else
		            {
		             txtbname.setText("");
		             txtedition.setText("");
		             txtprice.setText(""); 
		             txtquantity.setText("");
		             txtDesc.setText("");
		            }
		            
		        }
				catch (SQLException ex) { }
			}
			
		});
		
		txtbid.setColumns(10);
		txtbid.setBounds(141, 10, 173, 24);
		panel_1.add(txtbid);
		
		JLabel lblNewLabel_1_4_1 = new JLabel("Book NAME");
		lblNewLabel_1_4_1.setForeground(new Color(153, 50, 204));
		lblNewLabel_1_4_1.setFont(new Font("HP Simplified", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1_4_1.setBounds(33, 35, 98, 18);
		panel_1.add(lblNewLabel_1_4_1);
		
		txtbname1 = new JTextField();
		txtbname1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
			          
		            String name1 = txtbname1.getText();
		 
		                pst = con.prepareStatement("select name, edition , price, quantity, description from book where name = ?");
		                pst.setString(1, name1);
		                ResultSet rs = pst.executeQuery();
		 
		            if(rs.next()==true)
		            {
		                String name = rs.getString(1);
		                String edition = rs.getString(2);
		                String price = rs.getString(3);
		                String quantity = rs.getString(4);
		                String description = rs.getString(5);
		                
		                txtbname.setText(name);
		                txtedition.setText(edition);
		                txtprice.setText(price); 
		                txtquantity.setText(quantity);
		                txtDesc.setText(description);
		                
		            }  
		            else
		            {
		             txtbname.setText("");
		             txtedition.setText("");
		             txtprice.setText(""); 
		             txtquantity.setText("");
		             txtDesc.setText("");
		            }
		            
		        }
				catch (SQLException ex) { }
				
				
			}
		});
		
		txtbname1.setColumns(10);
		txtbname1.setBounds(141, 35, 173, 24);
		panel_1.add(txtbname1);
		
		table = new JTable();
		table.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		table.setBounds(497, 438, 314, -324);
		frame.getContentPane().add(table);
		
		table = new JTable();
		table.setBorder(new TitledBorder(null, "Books", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		table.setFillsViewportHeight(true);
		table.setBounds(798, 443, -300, -329);
		frame.getContentPane().add(table);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String bname,edition,price,bid,quantity, description;
				bname = txtbname.getText();
				edition = txtedition.getText();
				price = txtprice.getText();
				bid  = txtbid.getText();
				quantity = txtquantity.getText();
				description = txtDesc.getText();
				try {
					pst = con.prepareStatement("update book set name= ?,edition=?,price=?,quantity=?,description=? where id =?");
							pst.setString(1, bname);
				            pst.setString(2, edition);
				            pst.setString(3, price);
				            pst.setString(4, quantity);
				            pst.setString(5, bid);
				            pst.setString(6, description);
				            
				            pst.executeUpdate();
				            JOptionPane.showMessageDialog(null, "Record Update!!!!!");
				           
				          
				            txtbname.setText("");
				            txtedition.setText("");
				            txtprice.setText("");
				            txtquantity.setText("");
				            txtDesc.setText("");
				            txtbname.requestFocus();
				}
				 
				catch (SQLException e1) {
				e1.printStackTrace();}
				
				
			}
		});
		btnUpdate.setBounds(545, 299, 126, 30);
		frame.getContentPane().add(btnUpdate);
		
		//////////////////////////
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(473, 84, 462, 197);
		frame.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setBackground(new Color(230, 230, 250));
		scrollPane.setViewportView(table_1);
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked​(MouseEvent e) {
				DefaultTableModel tblModel = (DefaultTableModel)table_1.getModel();
				
				String tblName =tblModel.getValueAt(table_1.getSelectedRow(),0).toString();
				String tblID =tblModel.getValueAt(table_1.getSelectedRow(),1).toString();
				String tblEdition =tblModel.getValueAt(table_1.getSelectedRow(),2).toString();
				String tblQty =tblModel.getValueAt(table_1.getSelectedRow(),3).toString();
				String tblPrice =tblModel.getValueAt(table_1.getSelectedRow(),4).toString();
				
				
				txtbname.setText(tblName);
				txtbid.setText(tblName);
				txtedition.setText(tblName);
				txtprice.setText(tblName);
				txtquantity.setText(tblName);
				
			}
		});
		table_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_1.setFillsViewportHeight(true);
		table_1.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Edition", "Price", "Description"
			}
		));
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost/database1", "root","");
		            Statement st = con.createStatement();
		            String query = "select * from book";
		            ResultSet rs = st.executeQuery(query);
		            ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) table_1.getModel();
		            
		            
		            int cols = rsmd.getColumnCount();
		            String[] colName = new String[cols];
		            for(int i=0;i<cols;i++) {
		            	colName[i] = rsmd.getColumnName(i+1);
		        
		            }
		            model.setColumnIdentifiers(colName);
		            
		            String id, name, price, edition, quantity, description;
		            while(rs.next()) {
		            	id=rs.getString(1);
		            	name=rs.getString(2);
		            	price=rs.getString(3);
		            	edition=rs.getString(4);
		            	quantity=rs.getString(5);
		            	description=rs.getString(6);
		            	String[] row = {id, name, price, edition, quantity,description};
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
		btnNewButton_2.setActionCommand("JButton2");
		btnNewButton_2.setBounds(780, 299, 118, 30);
		frame.getContentPane().add(btnNewButton_2);
		Image img0 = new ImageIcon(this.getClass().getResource("/shine.jpg")).getImage();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(483, 355, 452, 197);
		frame.getContentPane().add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel tblModel_2 = (DefaultTableModel)table_2.getModel();
				
				String tblName =tblModel_2.getValueAt(table_2.getSelectedRow(),0).toString();
				String tblQty =tblModel_2.getValueAt(table_2.getSelectedRow(),1).toString();
				
				
				txtbname.setText(tblName);
				txtquantity.setText(tblName);
				
				
				
			}
		});
		scrollPane_2.setViewportView(table_2);
		table_2.setSurrendersFocusOnKeystroke(true);
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Book Name", "Quantity"
			}
		));
		table_2.getColumnModel().getColumn(0).setPreferredWidth(76);
		table_2.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table_2.setFillsViewportHeight(true);
		table_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		table_2.setBackground(new Color(230, 230, 250));
		
		JButton btnNewButton_2_1 = new JButton("See the Orders");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            con = DriverManager.getConnection("jdbc:mysql://localhost/database1", "root","");
		            Statement st = con.createStatement();
		            String query = "select * from clientPage";
		            ResultSet rs = st.executeQuery(query);
		            ResultSetMetaData rsmd = rs.getMetaData();
		            DefaultTableModel model = (DefaultTableModel) table_2.getModel();
		            
		            
		            int cols = rsmd.getColumnCount();
		            String[] colName = new String[cols];
		            for(int i=0;i<cols;i++) {
		            	colName[i] = rsmd.getColumnName(i+1);
		        
		            }
		            model.setColumnIdentifiers(colName);
		            
		            String name, quantity;
		            while(rs.next()) {
		            	
		            	name=rs.getString(1);
		            	quantity=rs.getString(2);
		            	String[] row = {name, quantity};
		            	model.addRow(row);  	
		            }
		            st.close();
		            con.close();
		            
		            
		            
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
			private void saveBookToDatabase(String name, String quantity) {
			    String sql ="INSERT INTO clientPage (name, quantity) VALUES (?,?)";
			    try (PreparedStatement pst = con.prepareStatement(sql)) {
			      pst.setString(1, name);
			      pst.setString(2, quantity);
			      pst.executeUpdate();
			    } catch (SQLException ex) {
			      System.out.println(ex.getMessage());
			    }
			  }
			
		});
		btnNewButton_2_1.setActionCommand("JButton2");
		btnNewButton_2_1.setBounds(668, 562, 143, 30);
		frame.getContentPane().add(btnNewButton_2_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		Image img3 = new ImageIcon(this.getClass().getResource("/shine.jpg")).getImage();
		lblNewLabel_2.setIcon(new ImageIcon(img3));
		lblNewLabel_2.setBounds(-236, 0, 1181, 610);
		frame.getContentPane().add(lblNewLabel_2);
	
		
		
		
		
		//Image img0 = new ImageIcon(this.getClass().getResource("/.png")).getImage();
		
		
		
		
	}
}
