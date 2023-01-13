import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JLayeredPane;
import java.awt.CardLayout;
import java.awt.Color;

import java.util.HashMap;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;


public class Window {
	private JFrame frame;
	private String Admin_Code = "azsxdcfvgbhnjm"; //encryption of admin code.

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					Window window = new Window();
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
	public Window() {
		initialize();
//		Connect();
		table_load();
//		layeredPane layeredPane = new layeredPane();
	}
	

	Connection con;
	PreparedStatement pstm;
	PreparedStatement recom_stm;
	PreparedStatement recom_now;
	
	
	Statement stmt;
	String pst;
	String rec;
	String user_database;
	ResultSet rs;

	ResultSet rss;
	
	ResultSet resc;
	
	ResultSet result_now;
	JTable table = new JTable();
	JTable table_people = new JTable();
	JTable table_tot = new JTable();
	
	String Username_signup;
	String Password_signup;
	
	String Username_login;
	String Password_login;
	
	String Admin_signup;
	
	String textFieldValue;
	String jobs;
//	ResultSet rs;
	private JTextField textField_1_username_su;
	private JTextField textField_3_pass_su;
	private JTextField textField_4_admin_su;
	
	private JTextField BrandtxtField;
	private JTextField ModeltxtField;
	private JTextField username_log;
	private JTextField FueltxtField;
	private JTextField PricetxtField;
	private HashMap<Object, Object> hm = new HashMap<>();
	private JTextField txtReccomendationForYou;
	
	int c_ID = 0;
	int car_ID = 0;
	int t_ID = 0;
	
	String tempor;
	
	private JTextField passwordField;
	private JTextField passwordField_1;
	
	public void Connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/TestData","root","");
		}
		catch (ClassNotFoundException ex) {
			
		}
		catch (SQLException ex) {
			
		}
	}
	
	public void table_load() {
		try
		{	
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive","root","");
		
			pst = ("Select * from car");
			rec = ("Select Model_Year,Model,Vehicle_CLass,Engine_Size_L,Cylinders,Transmission,Fuel_Consumption_City_L_100_KM,CO2_Rating,Price FROM my2022_fuel_consumption_ratings WHERE Price < 49000");
			user_database = ("Select custID,Username,CarPreference,Job from customer");
			
			pstm = con.prepareStatement(pst);
			stmt = con.createStatement();
			recom_stm = con.prepareStatement(rec);
			recom_now = con.prepareStatement(user_database);
			
			resc = recom_stm.executeQuery(rec);
			rs = stmt.executeQuery(pst);
			rss = pstm.executeQuery(pst);
			result_now =recom_now.executeQuery(user_database);
//			 while (rs.next()) {
//		         hm.put(rs.getInt("Price"));
//			 }
//			 System.out.println(hm);
			
			System.out.print(rs);
			
			
			table.setModel(DbUtils.resultSetToTableModel(rss));
			table_people.setModel(DbUtils.resultSetToTableModel(resc));
			table_tot.setModel(DbUtils.resultSetToTableModel(result_now));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 1133, 750);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(10, 10, 1062, 663);
		frame.getContentPane().add(layeredPane);
		layeredPane.setLayout(new CardLayout(0, 0));
		
		final JPanel LogIn = new JPanel();
		layeredPane.add(LogIn, "name_2204709660598400");
		LogIn.setLayout(null);
		
		final JPanel Profile = new JPanel();
		layeredPane.add(Profile, "name_13452570935800");
		Profile.setLayout(null);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setHorizontalAlignment(SwingConstants.CENTER);
		lblProfile.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblProfile.setBounds(375, 22, 292, 170);
		Profile.add(lblProfile);
		
		JLabel lblNewLabel_1_doi = new JLabel("Username :");
		lblNewLabel_1_doi.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_doi.setBounds(31, 333, 170, 43);
		Profile.add(lblNewLabel_1_doi);
		
		final JLabel lblNewLabel_1_1_doi = new JLabel("a");
		lblNewLabel_1_1_doi.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_1_doi.setBounds(243, 333, 170, 43);
		Profile.add(lblNewLabel_1_1_doi);
		
		///////////////////////////////////////////////////////////////////
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@///////////////////////////////////////////////////////////////////
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		final JPanel SignUp = new JPanel();
		layeredPane.add(SignUp, "name_2204709669107000");
		JButton btnNewButton_1DIO = new JButton("Log In");
		btnNewButton_1DIO.setBackground(Color.LIGHT_GRAY);
		btnNewButton_1DIO.setFont(new Font("Tahoma", Font.PLAIN, 27));
		
		final JPanel panel = new JPanel();
		layeredPane.add(panel, "name_1837848829924800");
		panel.setLayout(null);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordField.setBounds(362, 394, 232, 81);
		LogIn.add(passwordField);
		
		SignUp.setLayout(null);
		
		final JPanel MainUser = new JPanel();
		layeredPane.add(MainUser, "name_13452566314300");
		MainUser.setLayout(null);
		
		final JLabel lblNewLabel_1_2 = new JLabel("Password  :");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_2.setBounds(243, 425, 170, 43);
		Profile.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1_1_doi = new JLabel("Password :");
		lblNewLabel_1_1_1_doi.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_1_1_doi.setBounds(34, 425, 170, 43);
		Profile.add(lblNewLabel_1_1_1_doi);
		
		btnNewButton_1DIO.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
//				String varName = (String)comboBox.getSelectedItem();
//				String value = comboBox.getSelectedItem().toString();
//				System.out.print(value);
				
				Username_login = username_log.getText();
				Password_login = passwordField.getText();
				
				System.out.println(Username_signup+ Password_signup+Admin_signup);
				
				
				String for_cid = "SELECT Pin from customer where Username = '" + Username_login +"'";
				String for_cidd = "SELECT Job from customer where Username = '" + Username_login +"'";
//				ResultSet result;
				String checking = "a";
				
				try {
					ResultSet result;
					ResultSet results;
					
					Statement stmt = con.prepareStatement(for_cid);
					Statement stmts = con.prepareStatement(for_cidd);
					
					result = stmt.executeQuery(for_cid);
					results = stmts.executeQuery(for_cidd);
					if (result.next()) {
					    checking = result.getString(1);
					    
					}
					if (checking.equals(Password_login)) {
						if (results.next()) {
						    jobs = results.getString(1);
						    
						    if (jobs.equals("Admin")) {
						    	layeredPane.removeAll(); 
								layeredPane.add(panel);
								layeredPane.repaint();
								layeredPane.revalidate();
						    }else {
						    	layeredPane.removeAll(); 
								layeredPane.add(MainUser);
								layeredPane.repaint();
								layeredPane.revalidate();
						    }
						    
						}
					}
	
					System.out.print(checking);
					
				}catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				if (checking.equals(Password_login)) {
					
				}
			}
		});
		btnNewButton_1DIO.setBounds(665, 199, 216, 112);
		LogIn.add(btnNewButton_1DIO);
		
		JButton btnSignUp_1 = new JButton("Sign Up");
		btnSignUp_1.setBackground(Color.LIGHT_GRAY);
		btnSignUp_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		btnSignUp_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(SignUp);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnSignUp_1.setBounds(667, 381, 216, 112);
		LogIn.add(btnSignUp_1);
		
		final JPanel User_Reccomendation = new JPanel();
		layeredPane.add(User_Reccomendation, "name_1858884586652100");
		User_Reccomendation.setLayout(null);
		
		JLabel lblNewLabel_1DIO = new JLabel("Username");
		lblNewLabel_1DIO.setBounds(178, 234, 216, 37);
		lblNewLabel_1DIO.setFont(new Font("Tahoma", Font.PLAIN, 36));
		LogIn.add(lblNewLabel_1DIO);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setBounds(183, 401, 169, 54);
		lblPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 36));
		LogIn.add(lblPassword_1);
		
		username_log = new JTextField();
		username_log.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username_log.setBounds(362, 217, 232, 71);
		username_log.setColumns(10);
		LogIn.add(username_log);
		
		final JPanel Admin_Mod_1 = new JPanel();
		Admin_Mod_1.setLayout(null);
		Admin_Mod_1.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		layeredPane.add(Admin_Mod_1, "name_1837842991765700");
		
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Username");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(279, 93, 81, 22);
		SignUp.add(lblNewLabel_1_1);
		
		textField_1_username_su = new JTextField(); //username signup
		textField_1_username_su.setColumns(10);
		textField_1_username_su.setBounds(207, 126, 240, 94);
		SignUp.add(textField_1_username_su);
	
		
		JLabel lblPassword_1_1 = new JLabel("Password");
		lblPassword_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword_1_1.setBounds(284, 261, 76, 22);
		SignUp.add(lblPassword_1_1);
		
//		textField_3_pass_su = new JTextField(); //Password signup
//		textField_3_pass_su.setColumns(10);
//		textField_3_pass_su.setBounds(233, 263, 220, 70);
//		SignUp.add(textField_3_pass_su);
//		
//		JLabel lblPassword_1_1_1 = new JLabel("Admin Code");
//		lblPassword_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
//		lblPassword_1_1_1.setBounds(579, 126, 139, 22);
//		SignUp.add(lblPassword_1_1_1);
		
		textField_4_admin_su = new JTextField();
		textField_4_admin_su.setColumns(10);
		textField_4_admin_su.setBounds(579, 126, 240, 94);
		SignUp.add(textField_4_admin_su);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Car Preference");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(635, 261, 162, 22);
		SignUp.add(lblNewLabel_1_1_1);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setForeground(Color.DARK_GRAY);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 28));
		comboBox.setBounds(579, 294, 240, 104);
		comboBox.addItem("Practical Car");
		comboBox.addItem("Performance Car");
		SignUp.add(comboBox);
		
		JButton btnNewButtonDIO = new JButton("Create");
		btnNewButtonDIO.setFont(new Font("Tahoma", Font.PLAIN, 34));
		btnNewButtonDIO.setBounds(404, 440, 265, 135);
		btnNewButtonDIO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String varName = (String)comboBox.getSelectedItem();
				String value = comboBox.getSelectedItem().toString();
				System.out.print(value);
				
				Username_signup = textField_1_username_su.getText();
				Password_signup = textField_3_pass_su.getText();
				Admin_signup = textField_4_admin_su.getText();
				
				System.out.println(Username_signup+ Password_signup+Admin_signup);
				String for_cid = "SELECT MAX(custID)FROM customer";
//				ResultSet result;
				try {
					ResultSet result;
					Statement stmt = con.prepareStatement(for_cid);
					result = stmt.executeQuery(for_cid);
					if (result.next()) {
					    c_ID = result.getInt(1);
					}
					System.out.println(c_ID);
//					Insert INTO car Values (1,'acura','a',300,'bbb',1);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
//				System.out.print(result);
				try {
					Statement statement = con.createStatement();
//					System.out.print("INSERT INTO customer " + "VALUES (" + c_ID + "'"+Username_signup+"'" + ","+ "'"+Password_signup+"'" +","+ "'"+value+"'" + ","+ "'Admin'"+")");
					
					if(Admin_signup.equals("dewagua")) {
						c_ID ++;
						statement.executeUpdate("INSERT INTO customer " + "VALUES (" + c_ID +","+ "'"+Username_signup+"'" + ","+ "'"+Password_signup+"'" +","+ "'"+value+"'" + ","+ "'Admin'"+")");
						layeredPane.removeAll(); 
						layeredPane.add(panel);
						layeredPane.repaint();
						layeredPane.revalidate();
					}else {
						if(Username_signup.equals("")) {
							
						}else {
							layeredPane.removeAll(); 
							layeredPane.add(MainUser);
							layeredPane.repaint();
							layeredPane.revalidate();
//							String Username_signup;
//							String Password_signup;
//							
							Username_login = Username_signup;
							Password_login = Password_signup;
							c_ID ++;
							statement.executeUpdate("INSERT INTO customer " + "VALUES (" + c_ID +","+ "'"+Username_signup+"'" + ","+ "'"+Password_signup+"'" +","+ "'"+value+"'" + "," + "'Customer'"+")");
						}
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block 
					e1.printStackTrace();
				}
				
			}
		});
		
		SignUp.add(btnNewButtonDIO);
		
		textField_3_pass_su = new JPasswordField();
		textField_3_pass_su.setBounds(207, 294, 240, 104);
		SignUp.add(textField_3_pass_su);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Admin_Code");
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_2.setBounds(658, 93, 100, 22);
		SignUp.add(lblNewLabel_1_1_2);
///////////////////////////////////////////////////////////////////
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@///////////////////////////////////////////////////////////////////
//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Model");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_5_1.setBounds(24, 203, 77, 24);
		Admin_Mod_1.add(lblNewLabel_1_5_1);
		
		JLabel lblNewLabel_1_1_3_1 = new JLabel("Brand");
		lblNewLabel_1_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_3_1.setBounds(24, 103, 112, 24);
		Admin_Mod_1.add(lblNewLabel_1_1_3_1);
		
		BrandtxtField = new JTextField();
		BrandtxtField.setColumns(10);
		BrandtxtField.setBounds(194, 91, 178, 53);
		Admin_Mod_1.add(BrandtxtField);
		
		ModeltxtField = new JTextField();
		ModeltxtField.setColumns(10);
		ModeltxtField.setBounds(192, 191, 180, 53);
		Admin_Mod_1.add(ModeltxtField);
		
		FueltxtField = new JTextField();
		FueltxtField.setColumns(10);
		FueltxtField.setBounds(192, 400, 180, 53);
		Admin_Mod_1.add(FueltxtField);
		
		JLabel lblNewLabel_1_4_1_1 = new JLabel("Fuel");
		lblNewLabel_1_4_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_4_1_1.setBounds(25, 412, 134, 24);
		Admin_Mod_1.add(lblNewLabel_1_4_1_1);
		
		PricetxtField = new JTextField();
		PricetxtField.setColumns(10);
		PricetxtField.setBounds(192, 297, 180, 53);
		Admin_Mod_1.add(PricetxtField);
		
		JLabel lblNewLabel_1_1_2_1_1 = new JLabel("Price");
		lblNewLabel_1_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_2_1_1.setBounds(24, 309, 148, 24);
		Admin_Mod_1.add(lblNewLabel_1_1_2_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Admin Mod");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(456, 0, 102, 44);
		Admin_Mod_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Car Modifier");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(Admin_Mod_1);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnNewButton.setBounds(208, 340, 612, 257);
		panel.add(btnNewButton);
		
		final JPanel User_Data = new JPanel();
		layeredPane.add(User_Data, "name_1840243717249900");
		User_Data.setLayout(null);
		
		JButton btnUserDatabase = new JButton("User Database");
		btnUserDatabase.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnUserDatabase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(User_Data);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnUserDatabase.setBounds(208, 50, 612, 251);
		panel.add(btnUserDatabase);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(LogIn);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			
			
		});
		btnNewButton_1.setBounds(10, 11, 121, 49);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Back");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(User_Data);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_1_1_1.setBounds(12, 27, 89, 23);
		Admin_Mod_1.add(btnNewButton_1_1_1);
		
		final JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(422, 69, 630, 473);
		Admin_Mod_1.add(scrollPane_1);
		scrollPane_1.setViewportView(table);
//		scrollPane_1.setModel(DbUtils.resultSetToTableModel(rs));
//		scrollPane_1.add(2);
		
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String brand = BrandtxtField.getText();
				String model = ModeltxtField.getText();
				String fuel = FueltxtField.getText();
				int price = Integer.parseInt(PricetxtField.getText());
				
				String for_cid = "SELECT MAX(cID)FROM car";
				String for_tid = "SELECT MAX(tID)FROM car";
//				ResultSet result;
				try {

					ResultSet result;
					ResultSet resulttran;
					
					Statement stmt = con.prepareStatement(for_cid);
					Statement stmtt = con.prepareStatement(for_tid);
					
					result = stmt.executeQuery(for_cid);
					resulttran = stmtt.executeQuery(for_tid);
					if (result.next()) {
					    car_ID = result.getInt(1);
					    
					}
					if (resulttran.next()) {
						t_ID = resulttran.getInt(1);
					    
					}
					System.out.println(car_ID);
					System.out.println(t_ID);
					
				} catch (SQLException e2) {
					e2.printStackTrace();
				}
			
				try {
					Statement statement = con.createStatement();
//					System.out.print("INSERT INTO customer " + "VALUES (" + c_ID + "'"+Username_signup+"'" + ","+ "'"+Password_signup+"'" +","+ "'"+value+"'" + ","+ "'Admin'"+")");
//						con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive","root","");
						car_ID ++;
						t_ID ++;
						
						pst = ("Select * from car");
					
						pstm = con.prepareStatement(pst);
						
						statement.executeUpdate("INSERT INTO car " + "VALUES (" + car_ID +","+ "'"+brand+"'" + ","+ "'"+model+"'" +","+price+","+ "'"+fuel+"'" + ","+ t_ID+")");
						
						rss = pstm.executeQuery(pst);
						table.setModel(DbUtils.resultSetToTableModel(rss));
						scrollPane_1.setViewportView(table);
						
						
			
				} catch (SQLException e1) {
					// TODO Auto-generated catch block 
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(422, 553, 197, 82);
		Admin_Mod_1.add(btnNewButton_2);
		
		JButton btnNewButton_1_2 = new JButton("DELETE");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				int row = scrollPane_1.getMinSelectionIndex();
				String for_cid = "SELECT MAX(cID)FROM car";
//				ResultSet result;
				try {

					ResultSet result;
					
					Statement stmt = con.prepareStatement(for_cid);

					result = stmt.executeQuery(for_cid);

					if (result.next()) {
					    car_ID = result.getInt(1);
					    
					}
				}catch (SQLException e2) {
					e2.printStackTrace();
				}
				try {
					String delete = "DELETE FROM car WHERE cID = " + car_ID;
					
					car_ID --;
					t_ID --;
					
					con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive","root","");
					
					pst = ("Select * from car");
				
					pstm = con.prepareStatement(pst);
					
					Statement stmt = con.createStatement();
					String SQL = delete;
					stmt.executeUpdate(SQL);
					
					rss = pstm.executeQuery(pst);
					table.setModel(DbUtils.resultSetToTableModel(rss));
					scrollPane_1.setViewportView(table);


				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_2.setBounds(855, 553, 197, 82);
		Admin_Mod_1.add(btnNewButton_1_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(68, 63, 923, 452);
		User_Data.add(scrollPane);
		
		scrollPane.setViewportView(table_tot);
		
		JButton Back_lol = new JButton("Back");
		Back_lol.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(panel);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		Back_lol.setBounds(10, 11, 89, 23);
		User_Data.add(Back_lol);
		
		final JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 111, 1042, 510);
		User_Reccomendation.add(scrollPane_2);
		scrollPane_2.setViewportView(table_people);
		
		txtReccomendationForYou = new JTextField();
		txtReccomendationForYou.setFont(new Font("Tahoma", Font.PLAIN, 30));
		txtReccomendationForYou.setText("Reccomendation For You");
		txtReccomendationForYou.setBounds(348, 32, 341, 53);
		User_Reccomendation.add(txtReccomendationForYou);
		txtReccomendationForYou.setColumns(10);
		
		JButton btnNewButton_5 = new JButton("Back");
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(MainUser);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnNewButton_5.setBounds(10, 11, 143, 41);
		User_Reccomendation.add(btnNewButton_5);
		
		//////////////////////////////////////////////////
		
		final JPanel Shop = new JPanel();
		layeredPane.add(Shop, "name_13452576098400");
		Shop.setLayout(null);
		
		final JPanel History = new JPanel();
		layeredPane.add(History, "name_13640975769800");
		History.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome !!!");
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 99));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(206, 32, 631, 237);
		MainUser.add(lblNewLabel);
		
		JButton btnNewButton_pelir = new JButton("Profile");
		btnNewButton_pelir.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnNewButton_pelir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_1_1_doi.setText(Username_login);
				lblNewLabel_1_2.setText(Password_login);
				layeredPane.removeAll(); 
				layeredPane.add(Profile);
				layeredPane.repaint();
				layeredPane.revalidate();
				
			}
		});
		btnNewButton_pelir.setBounds(180, 280, 276, 117);
		MainUser.add(btnNewButton_pelir);
		
		JButton btnShop = new JButton("Shop");
		btnShop.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(Shop);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnShop.setBounds(184, 442, 272, 117);
		MainUser.add(btnShop);
		
		JButton btnHistory = new JButton("History");
		btnHistory.setFont(new Font("Tahoma", Font.PLAIN, 32));
		btnHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(History);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnHistory.setBounds(586, 280, 276, 115);
		MainUser.add(btnHistory);
		
		JButton Reccomender = new JButton("Reccomendation");
		Reccomender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(User_Reccomendation);
				layeredPane.repaint();
				layeredPane.revalidate();
				
				String for_cidd = "SELECT CarPreference from customer where Username = '" + Username_login +"'";
//				ResultSet result;
				String checking = "a";
				
				try {
					ResultSet results;
					
					Statement stmts = con.prepareStatement(for_cidd);
					
					results = stmts.executeQuery(for_cidd);
					if (results.next()) {
					    checking = results.getString(1);
					    
					}
			
					System.out.println(checking);
					if (checking.equals("Practical Car")) {
						rec = ("Select Brand,Model,Price,Fuel FROM car WHERE Price <= 40000");
					}else {
						rec = ("Select Brand,Model,Price,Fuel FROM car WHERE Price > 40000");
					}
					recom_stm = con.prepareStatement(rec);
					resc = recom_stm.executeQuery(rec);

					table_people.setModel(DbUtils.resultSetToTableModel(resc));
					scrollPane_2.setViewportView(table_people);

				}
				catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		Reccomender.setFont(new Font("Tahoma", Font.PLAIN, 32));
		Reccomender.setBounds(586, 442, 276, 117);
		MainUser.add(Reccomender);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(LogIn);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
			
		});
		btnNewButton_3.setBounds(10, 16, 114, 45);
		MainUser.add(btnNewButton_3);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Preference");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_2_1.setBounds(535, 339, 170, 43);
		Profile.add(lblNewLabel_1_2_1);
		
		final JComboBox comboBox_dio = new JComboBox();
		comboBox_dio.setFont(new Font("Tahoma", Font.PLAIN, 26));
		comboBox_dio.setModel(new DefaultComboBoxModel(new String[] {"Practical", "Performance"}));
		comboBox_dio.setToolTipText("");
		comboBox_dio.setBounds(742, 325, 162, 65);
		Profile.add(comboBox_dio);
		
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(MainUser);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnBack.setBounds(10, 10, 100, 43);
		Profile.add(btnBack);
		
		final JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 50));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Updated","Successfully Added", 1);
				String varName = (String)comboBox_dio.getSelectedItem();
				String value = comboBox_dio.getSelectedItem().toString();
				
				String delete = "UPDATE customer SET CarPreference = " + "'"+value+" Car'" + "WHERE Username = " + "'"+Username_login+"'";
				System.out.print(delete);
				
				try {
					Statement stmt = con.createStatement();
					String SQL = delete;
					stmt.executeUpdate(SQL);
					
					rss = pstm.executeQuery(pst);
					table.setModel(DbUtils.resultSetToTableModel(rss));
					scrollPane_1.setViewportView(table);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	
				
			}
		});
		btnSave.setBounds(34, 527, 259, 108);
		Profile.add(btnSave);
		
		JLabel lblShop = new JLabel("Shop");
		lblShop.setHorizontalAlignment(SwingConstants.CENTER);
		lblShop.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblShop.setBounds(441, -15, 292, 133);
		Shop.add(lblShop);
		
		JLabel lblNewLabel_1_3 = new JLabel("Brand");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3.setBounds(207, 133, 170, 43);
		Shop.add(lblNewLabel_1_3);
		
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(207, 186, 187, 65);
		Shop.add(comboBox_1);
		
		final JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(432, 186, 176, 65);
		Shop.add(comboBox_1_1);
		
//		String varName1 = (String)comboBox_1.getSelectedItem();
//	    String value1 = comboBox_1.getSelectedItem().toString();
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {				
					con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive","root","");
					
					pst = ("Select * from car");
					rec = ("Select Model_Year,Model,Vehicle_CLass,Engine_Size_L,Cylinders,Transmission,Fuel_Consumption_City_L_100_KM,CO2_Rating,Price FROM my2022_fuel_consumption_ratings WHERE Price < 49000");
					user_database = ("Select custID,Username,CarPreference,Job from customer");
					
					Statement stm = con.createStatement();
					
					ResultSet result = stm.executeQuery("select Brand from car");
					
					 while (result.next()) {
				         String name = result.getString("Brand");
				         comboBox_1.addItem(name);
				  
					 }
					 
					 String varName1 = (String)comboBox_1.getSelectedItem();
					 String value1 = comboBox_1.getSelectedItem().toString();
					 
					 ResultSet results = stm.executeQuery("select Model from car where Brand = " +"'"+value1+"'");
					 comboBox_1_1.removeAllItems();
					 while (results.next()) {
						 varName1 = (String)comboBox_1.getSelectedItem();
						 value1 = comboBox_1.getSelectedItem().toString();
//						 comboBox_1_1.removeAll();
				         String Model = results.getString("Model");
				         comboBox_1_1.addItem(Model);
					 }
					 
					 String varName12 = (String)comboBox_1_1.getSelectedItem();
					 String value12 = comboBox_1_1.getSelectedItem().toString();
					 
//					 System.out.println(hm);
				}catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			}});
			
		try {				
			con = DriverManager.getConnection("jdbc:mysql://localhost/Automotive","root","");
			
			pst = ("Select * from car");
			rec = ("Select Model_Year,Model,Vehicle_CLass,Engine_Size_L,Cylinders,Transmission,Fuel_Consumption_City_L_100_KM,CO2_Rating,Price FROM my2022_fuel_consumption_ratings WHERE Price < 49000");
			user_database = ("Select custID,Username,CarPreference,Job from customer");
			
			Statement stm = con.createStatement();
			
			ResultSet result = stm.executeQuery("select Brand from car");
			
			 while (result.next()) {
		         String name = result.getString("Brand");
		         comboBox_1.addItem(name);
		  
			 }
			 
			 String varName1 = (String)comboBox_1.getSelectedItem();
			 String value1 = comboBox_1.getSelectedItem().toString();
			 
			 ResultSet results = stm.executeQuery("select Model from car where Brand = " +"'"+value1+"'");
			 while (results.next()) {
				 varName1 = (String)comboBox_1.getSelectedItem();
				 value1 = comboBox_1.getSelectedItem().toString();
		         String Model = results.getString("Model");
		         comboBox_1_1.addItem(Model);
			 }
			 con.close();
//			 System.out.println(hm);
		}catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Model");
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_3_1.setBounds(432, 133, 170, 43);
		Shop.add(lblNewLabel_1_3_1);
		
		JLabel lblNewLabel_1_3_2 = new JLabel("Fuel Type :");
		lblNewLabel_1_3_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_3_2.setBounds(207, 300, 170, 43);
		Shop.add(lblNewLabel_1_3_2);
		
		JLabel lblNewLabel_1_3_2_1 = new JLabel("fuel type");
		lblNewLabel_1_3_2_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_3_2_1.setBounds(407, 300, 170, 43);
		Shop.add(lblNewLabel_1_3_2_1);
		
		JLabel lblNewLabel_1_3_2_2 = new JLabel("Price :");
		lblNewLabel_1_3_2_2.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_3_2_2.setBounds(207, 368, 170, 43);
		Shop.add(lblNewLabel_1_3_2_2);
		
		JLabel lblNewLabel_1_3_2_1_1 = new JLabel("price");
		lblNewLabel_1_3_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblNewLabel_1_3_2_1_1.setBounds(347, 368, 170, 43);
		Shop.add(lblNewLabel_1_3_2_1_1);
		
		JButton btnNewButton_1_pelir = new JButton("Buy");
		btnNewButton_1_pelir.setFont(new Font("Tahoma", Font.PLAIN, 60));
		btnNewButton_1_pelir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Success Transaction","Buy", 1);
				 String varName1 = (String)comboBox_1.getSelectedItem();
				 String value1 = comboBox_1.getSelectedItem().toString();
				
				 
				 String varName12 = (String)comboBox_1_1.getSelectedItem();
				 String value12 = comboBox_1_1.getSelectedItem().toString();
				 
				
				String delete = ("DELETE FROM car WHERE Brand =" + "'" + value1+"'"+" AND Model =" + "'"+value12+"'");
				 
				Statement stmt;
				try {
					stmt = con.createStatement();
					String SQL = delete;
					stmt.executeUpdate(SQL);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_pelir.setBounds(744, 512, 275, 121);
		Shop.add(btnNewButton_1_pelir);
		
		JButton btnBack_1 = new JButton("back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(MainUser);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnBack_1.setBounds(10, 10, 69, 26);
		Shop.add(btnBack_1);
		
		
		
		JLabel lblHistory = new JLabel("History");
		lblHistory.setHorizontalAlignment(SwingConstants.CENTER);
		lblHistory.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblHistory.setBounds(194, -28, 292, 133);
		History.add(lblHistory);
		
		JScrollPane scrollPane_pelir = new JScrollPane();
		scrollPane_pelir.setBounds(115, 86, 507, 325);
		History.add(scrollPane_pelir);
		
		JButton btnBack_2 = new JButton("back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				layeredPane.removeAll(); 
				layeredPane.add(MainUser);
				layeredPane.repaint();
				layeredPane.revalidate();
			}
		});
		btnBack_2.setBounds(10, 10, 69, 26);
		History.add(btnBack_2);
		
		////////////////////////////////////////////////
	}
}
