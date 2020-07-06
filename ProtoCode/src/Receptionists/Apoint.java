package Receptionists;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import javax.swing.UIManager;

public class Apoint extends JFrame {

	private JPanel contentPane;
	private javax.swing.JPanel jPanel7;
	private JPanel panel;
	private JTable table;
	private JLabel appNo;
	
	Connection connection = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    private JTable table_1;
    
    
	public Apoint() {
		initComponents();
	//	AutoID();
	}
    
	
	 public void AutoID() {
	    	try {
				Statement s=connection.createStatement();
				Logger.getLogger(getName());
				rs=s.executeQuery("select MAX(appNo) from appoint");
				rs.next();
				rs.getString("MAX(appNo)");
				
				if(rs.getString("MAX(appNo)")==null) {
					appNo.setText("APP001");
				}
				else
				{
					Long id=Long.parseLong(rs.getString("MAX(appNo)").substring(2,rs.getString("MAX(appNo)").length()));
					id++;
					appNo.setText("APP0"+String.format("%0%d", id));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	
	    	
	    }
	
	
	
    @SuppressWarnings("unused")
	private void initComponents() {
    	setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Welcome To Appointment");
        //setResizable(false);
        setSize(new java.awt.Dimension(800, 480));
        setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 434, 553);
		panel_1.setBackground(new Color(0, 153, 153));
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(null, "Scheduling Appointment", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(Color.PINK);
		
		JLabel label = new JLabel("Appointment No");
		label.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label.setBounds(29, 46, 136, 25);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("Doctor Name");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_1.setBounds(29, 106, 111, 25);
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("Patient Name");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_2.setBounds(29, 169, 111, 25);
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("Room No");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_3.setBounds(29, 226, 111, 25);
		panel_2.add(label_3);
		
		JLabel label_4 = new JLabel("Appointment Date");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_4.setBounds(29, 288, 149, 25);
		panel_2.add(label_4);
		
		JLabel label_5 = new JLabel("APPnoLabel");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		label_5.setBounds(224, 46, 122, 25);
		panel_2.add(label_5);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(224, 109, 122, 25);
		panel_2.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(224, 174, 122, 25);
		panel_2.add(comboBox_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(224, 226, 50, 25);
		panel_2.add(spinner);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(224, 283, 122, 25);
		panel_2.add(dateChooser);
		
		JButton button = new JButton("Schedule");
		button.setBounds(37, 358, 128, 47);
		panel_2.add(button);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setBounds(189, 358, 128, 47);
		panel_2.add(button_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		
		table_1 = new JTable();
		table_1.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		table_1.setBounds(10, 438, 788, -423);
		panel_3.add(table_1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 1260, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(29)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 386, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGap(0, 553, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(93)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);

    }
	 
    
    
    
    

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(() -> {
            new Apoint().setVisible(true);
        });	}

	/**
	 * Create the frame.
	 */


}
