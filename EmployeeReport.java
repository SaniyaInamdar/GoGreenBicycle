


import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.print.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class EmployeeReport extends JFrame implements ActionListener,ItemListener{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color c1=new Color(251,251,251);
     JLabel l1,l2,l3,l4,l5,l6;
     JButton b1,b2,b3,b4;
     JTextField t1,t3;
	 JPasswordField t2;
     ImageIcon img2,img1;
     JPanel p1,p2;
       ResultSet rs;
       ButtonGroup bg;
     Font f1=new Font("Algerian",Font.BOLD,20);
     Font f2=new Font("Book Antiqua",Font.BOLD,20); 
     Font f3=new Font("Lucida console",Font.BOLD,25);
     Statement st1,st;
	 String ss,s9;
	 boolean r;
	 Connection con;
	 JTable table1;
	 JScrollPane JSP;
	 java.util.Date date=new java.util.Date();
	 Container c=getContentPane();
	  JRadioButton rb1,rb2;
     @SuppressWarnings("deprecation")
	public EmployeeReport()
     { 
    	 
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        img2=new ImageIcon("E://java/jdk1.8/bin//vehicle_rent_system/images/img1.jpg");
          setSize(1300,700);
         setLayout(null);
         setVisible(true);
         show();
         c=getContentPane();
         c.setBackground(c1);
        // p3=new JPanel();
        // p3.setBounds(800,50,500,450);
        //p3.setLayout(null);
        // l5=new JLabel(img2);
        // l5.setBounds(0,0,500,400);
        // p3.add(l5);
        // add(p3);

         p1=new JPanel();
         p1.setLayout(new FlowLayout());
         p1.setBounds(50,50,700,50);
         p1.setBackground(Color.black);
  
         l1=new JLabel("Go Green Bicycle System");
         l1.setForeground(Color.white);
         l1.setFont(f1);
         l1.setBounds(10,5,500,30);
         p1.add(l1);
         add(p1);
    
         p2=new JPanel();
         p2.setLayout(null);
         p2.setBounds(50,150,700,450);
         p2.setBackground(c1);
		
         l6=new JLabel("Employee Report");
         l6.setFont(f3);
         l6.setBounds(100,30,400,30);
       	 p2.add(l6);
       	  
       	  l2=new JLabel(date.toString());
       	  l2.setBounds(50,100,300,30);
       	  p2.add(l2);
       	  
       	  b3=new JButton("Home");
       	  b4=new JButton("Print");
     	  p2.add(b3);
     	  p2.add(b4);
       	  b3.setBounds(230,100,100,30);
       	  b4.setBounds(350,100,100,30);
     	   p2.add(b3);
     	  p2.add(b4);
 	  
       	  
       	b1=new JButton("Show Details");
        b1.setBounds(500,100,150,30);
        b2=new JButton("Home");
        b2.setBounds(250,170,120,30);
        p2.add(b1); 
       // p2.add(b2);
		b1.addActionListener(this);
		b4.addActionListener(this);
		b3.addActionListener(this);
      	
        add(p2);
        //add(l5);
        //create border
        Border blackline = BorderFactory.createLineBorder(Color.black);
        p1.setBorder(blackline);
        p2.setBorder(blackline);
    //    p3.setBorder(blackline);
   }
     public void itemStateChanged(ItemEvent ie) 
     { 
    	
     }
   public void actionPerformed(ActionEvent ae)
	{
	   String s; 
  	 
		if(ae.getSource()==b1)
		{
					  	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
    		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
    			st=con.createStatement();
    			String sql="select * from tbl_Employee";
    		    rs=st.executeQuery(sql);
    		    	final String[] cols={"Employee Id","Name","Address","City","Pincode","Email","Mobile no"};
    		    	final Object rows[][]=new Object[50][8];
    		    	//final String ss[][]=new String[10][8];
    		    	int i=0;
    		     	while(rs.next())
    		    	{
      		    	String s1=rs.getString(1);
    		    	String s2=rs.getString(2);
    		    	String s3=rs.getString(3);
    		    	String s4=rs.getString(4);
    		    	String s5=rs.getString(5);
    		    	String s6=rs.getString(6);
    		    	String s7=rs.getString(7);
    		    	rows[i][0]=(Object)s1;
    		    	rows[i][1]=(Object)s2;
    		    	rows[i][2]=(Object)s3;
    		    	rows[i][3]=(Object)s4;
    		    	rows[i][4]=(Object)s5;
    		    	rows[i][5]=(Object)s6;
    		    	rows[i][6]=(Object)s7;
    		    	i++;
    		    	}
    		    	
    		    	table1=new JTable(rows,cols);
    		    JSP=new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  	  	 	    		    	
    		    	JSP.setBounds(20,150,670,250);
    		    	JSP.setBackground(Color.white);
    		    	JSP.setVisible(true);
    		    	p2.add(JSP);
    		        
    		       	  }catch(Exception e) 
    		       	  {
    		       		System.out.println("error"+e);  
    		       		  
    		       	  }
		  	

		}
		if(ae.getSource()==b2)
		{
			System.exit(0);
		}
		if(ae.getSource()==b4)
		{
			PrinterJob pj = PrinterJob.getPrinterJob();
			if (pj.printDialog()) {
		        try {pj.print();}
		        catch (PrinterException exc) {
		            System.out.println(exc);
		         }
		    }
		}
		if(ae.getSource()==b3)
		{
			hide();
		}
	}

  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new EmployeeReport();

	}

}

