import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;


public class CustomerPayment extends JFrame  implements ActionListener,ItemListener
{
	Container c;
	JPanel P1,P2;
	JComboBox dp,dp1;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,img1,L8,L9,L10,imgupi;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3,b4,b5;
	ImageIcon Limage,L1image,L2image,upi;
	
	Color c1=new Color(128,0,128);
	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
	Font f1=new Font("Times New Roman",Font.BOLD,25);
	Font f2=new Font("Times New Roman",Font.BOLD,65);
	java.util.Date date=new java.util.Date();
	JTable table1;
	 JScrollPane JSP;

ResultSet rs;
	Connection con;
	Statement st;

	public CustomerPayment()
	{
		setSize (1800,1800);
		setVisible(true);
		setLayout(null);
		setFont(f1);
		setBackground(c2);
		
		
	
		P1=new JPanel();
		add(P1);
		P1.setBounds(30,0,1300,180);
		//P1.setBackground(Color.cyan);
		P1.setBackground(c1);
		P1.setLayout(null);
		Limage=new ImageIcon("E://java/jdk1.8/bin/go_green_Bicycle_system/Images/logo1.png");
		L1=new JLabel(Limage);
		L1.setBounds(0,0,200,180);
		P1.add(L1);

		L1image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/background4.jpeg");
		img=new JLabel(L1image);
		img.setBounds(1080,0,200,200);
		P1.add(img);

		L2=new JLabel("Customer Payment Form");
		L2.setFont(f2);
		add(L2);
		L2.setBounds(300,10,850,150);
		L2.setForeground(Color.white);
		P1.add(L2);
		
		
		
		P2=new JPanel();
		add(P2);
		P2.setBounds(30,200,1300,800);
		P2.setBackground(c1);
		P2.setLayout(null);

		L3=new JLabel("Select Issue  Id");
		L3.setFont(f1);
		add(L3);
		L3.setBounds(50,40,200,25);
		L3.setForeground(Color.white);
		P2.add(L3);
		
		//t1=new JTextField();
		//t1.setFont(f1);
		dp=new JComboBox();
		add(dp);
		dp.setBounds(300,40,150,25);
		
		
	//view sales  id
		

	     try
			{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Connection driver loaded");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
	st=con.createStatement();
	String q="select * from tbl_IssueOrder";
	rs=st.executeQuery(q);
	while(rs.next())
	{
		dp.addItem(rs.getString(1));
		
		
	}
	con.close();
	
			}catch(Exception e) {}
			P2.add(dp);
		
		L4=new JLabel("Customer Name");
		L4.setFont(f1);
		add(L4);
		L4.setBounds(500,40,200,25);
		L4.setForeground(Color.white);
		P2.add(L4);
		
		t2=new JTextField();
		t2.setFont(f1);
		add(t2);
		t2.setBounds(740,40,200,25);
		P2.add(t2);

		L5=new JLabel("Issue date and time");
		L5.setFont(f1);
		add(L5);
		L5.setBounds(50,90,200,25);
		L5.setForeground(Color.white);
		P2.add(L5);
		
		t3=new JTextField();
		t3.setFont(f1);
		add(t3);
		t3.setBounds(300,90,150,25);
		P2.add(t3);	


		L6=new JLabel("Date");
		L6.setFont(f1);
		add(L6);
		L6.setBounds(500,90,150,25);
		L6.setForeground(Color.white);
		P2.add(L6);

		t4=new JTextField();
		t4.setFont(f1);
		add(t4);
		t4.setText(date.toString());
		t4.setBounds(750,90,200,25);
		P2.add(t4);	
		
		
		L7=new JLabel("Amount");
		L7.setFont(f1);
		add(L7);
		L7.setBounds(50,140,200,25);
		L7.setForeground(Color.white);
		P2.add(L7);

		t5=new JTextField();
		t5.setFont(f1);
		add(t5);
		t5.setBounds(300,140,300,25);
		P2.add(t5);

	
		L8=new JLabel("Status");
		L8.setFont(f1);
		add(L8);
		L8.setBounds(50,190,200,25);
		L8.setForeground(Color.white);
		P2.add(L8);
		
		dp1=new JComboBox();
		dp1.setFont(f1);
		dp1.addItem("Cash");
		dp1.addItem("UPI");
		dp1.setBounds(300,190,300,30);
		P2.add(dp1);


		L9=new JLabel("Payment id");
		L9.setFont(f1);
		add(L9);
		L9.setBounds(50,240,250,25);
		L9.setForeground(Color.white);
		P2.add(L9);
		
		t6=new JTextField();
		t6.setFont(f1);
		add(t6);
		t6.setBounds(300,240,300,25);
		P2.add(t6);	

		L10=new JLabel("Description");
		L10.setFont(f1);
		add(L10);
		L10.setBounds(50,290,200,25);
		L10.setForeground(Color.white);
		P2.add(L10);
		
		t7=new JTextField();
		t7.setFont(f1);
		add(t7);
		t7.setBounds(300,290,300,100);
		P2.add(t7);	

		


		//L2image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/cust.png");
		//img1=new JLabel(L2image);
		//img1.setBounds(850,0,450,450);
		//P2.add(img1);

		b1=new JButton("Add");
		b1.setFont(f1);
		add(b1);
		b1.setBounds(50,420,140,30);
		P2.add(b1);

		b2=new JButton("Save");
		b2.setFont(f1);
		add(b2);
		b2.setBounds(220,420,140,30);
		P2.add(b2);

		b3=new JButton("Clear");
		b3.setFont(f1);
		add(b3);
		b3.setBounds(390,420,140,30);
		P2.add(b3);
	
		b4=new JButton("Home");
		b4.setFont(f1);
		add(b4);
		b4.setBounds(560,420,140,30);
		P2.add(b4);


		upi=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/UPI.png");
					imgupi=new JLabel(upi);
					imgupi.setBounds(700,140,200,200);
					imgupi.setVisible(false);
					P2.add(imgupi);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
				dp.addItemListener(this);
				dp1.addItemListener(this);


	}
	 public void itemStateChanged(ItemEvent ae)
		 	{
			 try
		 		{
				 Class.forName("com.mysql.cj.jdbc.Driver");	
	 			System.out.print("Connection done");
	 		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
	 			System.out.println("Driver Loaded");
	 			st=con.createStatement();
	 	
		 		if(ae.getSource()==dp)
		 		{
		 		String nq=(String)ae.getItem();
		 		
		 			Statement st1=con.createStatement();
		 	String sql="select * from tbl_IssueOrder where issueid="+Integer.parseInt(nq)+"";
		 			rs=st1.executeQuery(sql);
		 			while(rs.next())
		 			{
						t3.setText(rs.getString(3));	
						t5.setText(rs.getString(9));
		 				t2.setText(rs.getString(10));	
						
		 			}
					
					
					//Jable
					
				/*	repaint();
						Class.forName("com.mysql.cj.jdbc.Driver");
    		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
    			st=con.createStatement();
    			String sql1="select cname,bicycle_id,btype,issue_date,return_date,rate,total from tbl_IssueOrder where issueid="+Integer.parseInt(nq)+"";
    		    rs=st.executeQuery(sql1);
    		    	final String[] cols={"customer name","Bicycle Id","Bicycle Type","Issue Date and Time","No of hours","Rate","Total"};
    		    	final Object rows[][]=new Object[10][8];
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
  	  	 	    		    	
    		    	JSP.setBounds(700,140,500,250);
    		    	JSP.setBackground(Color.white);
    		    	JSP.setVisible(true);
    		    	P2.add(JSP);
    		        
				*/	
					
					
					
					
					
		 		
				}
				if(ae.getSource()==dp1)
		 		{
						String nq=(String)ae.getItem();
					if(nq.equals("UPI"))
					{
					imgupi.setVisible(true);
					}
					else
					{
						imgupi.setVisible(false);
					}
					
						

				//JSP.setBounds(700,140,500,250);
				
				}
				
				
				
				
				
				
				
				
				
				
				
				}catch(Exception e) 
						
					
						{
							System.out.println("error"+e);
						}
		
		
		 		
		 		}
			 				

	public void actionPerformed(ActionEvent ae)
	{
		String id="",cid,name,oid,date,amt,mode,description;
		ResultSet rs;
		Connection con;
		Statement st;
		int paymid;
		String q;
	//save button b2
		if(ae.getSource()==b2)
		{
			
				

			
			
						
						try
						{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connection driver loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		st=con.createStatement();
		q="insert into tbl_custpayment values("+Integer.parseInt(t6.getText())+"," + Integer.parseInt((String)dp.getSelectedItem()) +",'" + t2.getText() +"'," + Integer.parseInt(t5.getText()) +",'" + (String)dp1.getSelectedItem() +"','"+t7.getText()+"')";
		st.executeUpdate(q);
		//q="update tbl_custpayment set amount=10000";
		//st.executeUpdate(q);
		con.close();
		JOptionPane.showMessageDialog(null,"Values are saved..Thank you","Saved", JOptionPane.INFORMATION_MESSAGE);
		bill ob=new bill(t6.getText(),t2.getText(),t5.getText());
			ob.show();
		
		
						}catch(Exception e) 
						
					
						{
							System.out.println("error"+e);
						}
		
		}
		//add new
		if(ae.getSource()==b1)
		{
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		
			
			st=con.createStatement();
			q="select max(paymid) from custpayment";
			rs=st.executeQuery(q);
		

			while(rs.next())
			{
				id=rs.getString(1);
			}
			paymid=Integer.parseInt(id)+1;
			t6.setText(String.valueOf(paymid));
			con.close();
			}catch(Exception e)
			{
				System.out.println("Error"+e);
			}
				
			
		}
	//clear button b3
		if(ae.getSource()==b3)
		{
			t1.setText("");
			t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			
		}


		//Hide button b4
				if(ae.getSource()==b4)
				{
					hide();
				}
		
		
	}







public static void main(String args[])
{
CustomerPayment ob=new CustomerPayment();
}
}

