package Receptionists;

import Main.Connector;
import Main.Hospital;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *
 * @author Deenadayal
 */
public class Appointer extends javax.swing.JFrame {

    Connection connection = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    DefaultTableModel defaultTableModel = new DefaultTableModel();

    public Appointer() {
        initComponents();
        connection=Connector.ConnectDb();
        AutoID();
        LoadDoctor();
        LoadPatient();
        
        LoadRoomno();
        ImageIcon ic = new ImageIcon(getClass().getResource("/Images/hospital.png"));
        this.setIconImage(ic.getImage());
        Object columns[] = {"Serial", "Joining Date", "Id", "Name", "Age", "Gender", "Blood Group", "Department", "Phone Number", "Email Address", "Status", "Address", "Room number", "Username"};
        defaultTableModel.setColumnIdentifiers(columns);
    }
    
    
    
    
    public void AutoID() {
    	try {
			Statement s=connection.createStatement();
			rs=s.executeQuery("select MAX(appNo) from appoint");
			rs.next();
			rs.getString("MAX(appNo)");
			
			if(rs.getString("MAX(appNo)")==null) {
				txtAppno.setText("APP001");
			}
			else
			{
				Long id=Long.parseLong(rs.getString("MAX(appNo)").substring(2,rs.getString("MAX(appNo)").length()));
				id++;
				txtAppno.setText("APP0"+String.format("%03d", id));
			}
		} catch (SQLException e) {
			
			//JOptionPane.showMessageDialog(this, e);
			//e.printStackTrace();
			Logger.getLogger(Appointer.class.getName()).log(Level.SEVERE,null,e);
		}
    	
    	
    	
    }


    public class Doctor{
    	String id;
    	String name;
    	String rno;
    
    public Doctor(String id,String name) {
    	this.id=id;
    	this.name=name;
    }
    
    public Doctor(String id,String name,String rno) {
    	this.id=id;
    	this.name=name;
    	this.rno=rno;
    }
    public String toString() {
    	return name;
    }

	public String Rno() {
		return rno;
	}

    }
    
    public void LoadDoctor() {
    	String sql="select * from doctor";
    	try {
			ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			//rs.getString(4);
			txtDocname.removeAll();
			while(rs.next()) {
				
				txtDocname.addItem(new Doctor(rs.getString(3),rs.getString(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }
   
    
 //
    
    
    public class Patient{
    	String id;
    	String name;
    	
    
    public Patient(String id,String name) {
    	this.id=id;
    	this.name=name;
    }
    
    
    public String toString() {
    	return name;
    }

	

    }
    
    public void LoadPatient() {
    	String sql="select * from patient";
    	try {
			ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			//rs.getString(4);
			txtPatname.removeAll();
			while(rs.next()) {
				
				txtPatname.addItem(new Patient(rs.getString(3),rs.getString(4)));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    
 //   
    
////
    
    String roomno;
    public void LoadRoomno() {
    	String sql="select * from doctor where name='"+roomno+"'";
    	try {
			ps=connection.prepareStatement(sql);
			rs=ps.executeQuery();
			
			//rs.getString(4);
			txtRoomno.removeAll();
			while(rs.next()) {
				
				
				txtRoomno.addItem(new Doctor(rs.getString(3),rs.getString(13),rs.getString(14)));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

    
    
    
 ////   
    
    
   
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        appNo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Choose Docotor !");

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));

        jLabel12.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Set Appointment");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/cross.png"))); // NOI18N
        jLabel18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel18MouseClicked(evt);
            }
        });

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/backs.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel18)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        appNo.setFont(new Font("Tahoma", Font.PLAIN, 18)); // NOI18N
        appNo.setForeground(new java.awt.Color(0, 153, 153));
        appNo.setText("Appointment No:");
        
        txtAppno = new JLabel();
        txtAppno.setText("xxx");
        txtAppno.setForeground(new Color(0, 153, 153));
        txtAppno.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        lblDoctorName = new JLabel();
        lblDoctorName.setText("Doctor Name:");
        lblDoctorName.setForeground(new Color(0, 153, 153));
        lblDoctorName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        lblPatientName = new JLabel();
        lblPatientName.setText("Patient Name:");
        lblPatientName.setForeground(new Color(0, 153, 153));
        lblPatientName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        lblRoomNo = new JLabel();
        lblRoomNo.setText("Room No:");
        lblRoomNo.setForeground(new Color(0, 153, 153));
        lblRoomNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        lblDate = new JLabel();
        lblDate.setText("Date:");
        lblDate.setForeground(new Color(0, 153, 153));
        lblDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        txtDocname = new JComboBox();
        txtDocname.addItemListener(new ItemListener() {
        	public void itemStateChanged(ItemEvent e) {
        		if(e.getStateChange()==ItemEvent.SELECTED) {
        			System.out.println("coming inn...");
        			roomno=txtDocname.getSelectedItem().toString();
        			System.out.println(roomno);
        			txtRoomno.removeAll();
        			LoadDoctor();
        			LoadRoomno();
        		}
        	}
        });
        
        
        txtPatname = new JComboBox();
        
        txtRoomno = new JComboBox();
        
        JDateChooser txtDate = new JDateChooser();
        
        JButton btnNewButton = new JButton("CREATE");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		
        	}
        });
        
        JButton btnCancel = new JButton("CANCEL");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, 1314, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(32)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(appNo, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblDoctorName, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblPatientName, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblRoomNo, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 163, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(50)
        					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)))
        			.addGap(35)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtPatname, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtAppno, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtDocname, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
        				.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        					.addComponent(txtDate, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(txtRoomno, Alignment.LEADING, 0, 141, Short.MAX_VALUE)))
        			.addContainerGap(879, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(35)
        			.addComponent(jPanel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(51)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(appNo)
        				.addComponent(txtAppno, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
        			.addGap(14)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblDoctorName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtDocname, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addGap(22)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblPatientName, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtPatname, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addGap(24)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblRoomNo, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtRoomno, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(lblDate, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtDate, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE))
        			.addGap(61)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
        			.addGap(244))
        );
        getContentPane().setLayout(layout);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel18MouseClicked
        Hospital hospital = new Hospital();
        hospital.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel18MouseClicked

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        ReceptionistActivity rActivity = new ReceptionistActivity();
        rActivity.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel19MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Appointer().setVisible(true);
        });
    }
    private javax.swing.JLabel appNo;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JPanel jPanel5;
    private JLabel txtAppno;
    private JLabel lblDoctorName;
    private JLabel lblPatientName;
    private JLabel lblRoomNo;
    private JLabel lblDate;
    private JComboBox txtDocname;
    private JComboBox txtPatname;
    private JComboBox txtRoomno;
    
}
