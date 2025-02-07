import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
public class sales extends JFrame  implements ActionListener,ItemListener
{
	private static final JList String = null;
	Container c;
	JPanel P1,P2;
	JLabel L1,L2,img,L3,L4,L5,L6,L7,L8,L9,L10,L11;
	JComboBox dp,dp1;
	JTextField t1,t2,t3,t4,t5,t6,t7,txtdate;
	JButton b1,b2,b3,b4,b5,btnNew;
	ImageIcon Limage,L1image;
	Color c1=new Color(128,0,128);
	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
	Font f1=new Font("Times New Roman",Font.BOLD,25);
	Font f2=new Font("Times New Roman",Font.BOLD,65);
	int cnt;
	int famt=0;
	String o,q;
	Dimension dmax;
	ResultSet rs;
	Connection con;
	Statement st;
	JComboBox lstproduct; 
	DefaultListModel pName = new DefaultListModel();
	static int srno=0;
			JTable table1;
	 JScrollPane JSP;
	 java.util.Date date=new java.util.Date();
	public sales ()
	{
		setSize (1800,1800);
		setVisible(true);
		setLayout(null);
		setFont(f1);
		setBackground(c2);
		P1=new JPanel();
		add(P1);
		P1.setBounds(30,10,1300,150);
		//P1.setBackground(Color.cyan);
		P1.setBackground(c1);
		P1.setLayout(null);
		Limage=new ImageIcon("E://java/jdk1.8/bin/go_green_Bicycle_system/Images/logo1.png");
		L1=new JLabel(Limage);
		L1.setBounds(0,0,200,150);
		P1.add(L1);

		L1image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/background4.jpeg");
		img=new JLabel(L1image);
		img.setBounds(1080,0,200,150);
		P1.add(img);

		L2=new JLabel("Issue Order Form");
		L2.setFont(f2);
		add(L2);
		L2.setBounds(390,10,850,140);
		L2.setForeground(Color.white);
		P1.add(L2);

		P2=new JPanel();
		add(P2);
		P2.setBounds(30,200,1300,800);
		P2.setBackground(c1);
		P2.setLayout(null);
		
		//
		btnNew=new JButton("New Order");
		btnNew.setFont(f1);
		btnNew.setBounds(50,10,200,30);
		P2.add(btnNew);
		
		txtdate=new JTextField();
		txtdate.setFont(f1);
		add(txtdate);
		txtdate.setText(date.toString());
		txtdate.setBounds(350,10,350,25);
		P2.add(txtdate);	
		
		
		
		

		L3=new JLabel("Customer Id");
		L3.setFont(f1);
		add(L3);
		L3.setBounds(50,50,300,30);
		L3.setForeground(Color.white);
		P2.add(L3);

		dp=new JComboBox();
		dp.setFont(f1);
		//customer name
		
				try
				{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connection driver loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		st=con.createStatement();
		q="Select * from tbl_customer";
		rs=st.executeQuery(q);
		while(rs.next())
		{
			dp.addItem(rs.getString(1));
		}
		con.close();


		}catch(Exception e) {}
		dp.setBounds(350,50,300,30);
		P2.add(dp);
	
		
		L4=new JLabel("Customer Name");
		L4.setFont(f1);
		add(L4);
		L4.setBounds(700,50,280,30);
		L4.setForeground(Color.white);
		P2.add(L4);
		
		t1=new JTextField();
		t1.setFont(f1);
		add(t1);
		t1.setBounds(1000,50,250,25);
		P2.add(t1);	

		L5=new JLabel("Select Type");
		L5.setFont(f1);
		add(L5);
		L5.setBounds(50,100,280,30);
		L5.setForeground(Color.white);
		P2.add(L5);

		dp1=new JComboBox();
		dp1.setFont(f1);
		
		 
		
		
		//product name
		
		try
		{
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Connection driver loaded");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
st=con.createStatement();
q="Select distinct(btype) from tbl_Bicycle";
rs=st.executeQuery(q);
while(rs.next())
{
	dp1.addItem(rs.getString(1));
}
con.close();


}catch(Exception e) {}
		dp1.setBounds(350,100,300,30);
		P2.add(dp1);
		
		
		
		L11=new JLabel("Order Id");
		L11.setFont(f1);
		add(L11);
		L11.setBounds(700,100,280,30);
				L11.setForeground(Color.white);
		P2.add(L11);

		t7=new JTextField();
		t7.setFont(f1);
		//add(t7);;
		t7.setBounds(1000,100,250,30);
		P2.add(t7);
		
		

		L6=new JLabel("Select Product");
		L6.setFont(f1);
		add(L6);
		L6.setBounds(50,150,300,30);
				L6.setForeground(Color.white);
		P2.add(L6);
		
		//t2=new JTextField();
		lstproduct=new JComboBox();
		//product type
		
			
		
		
		
	lstproduct.setBounds(350,150,300,30);
	P2.add(lstproduct);	
	
		
		L8=new JLabel("Avaliable Quantity");
		L8.setFont(f1);
		add(L8);
		L8.setBounds(50,200,300,30);
				L8.setForeground(Color.white);
		P2.add(L8);
		t4=new JTextField();
		t4.setFont(f1);
		add(t4);
		t4.setBounds(350,200,300,25);
		P2.add(t4);	
		L9=new JLabel("Enter Hours");
		L9.setFont(f1);
		add(L9);
		L9.setBounds(50,250,280,30);
				L9.setForeground(Color.white);
		P2.add(L9);
		t5=new JTextField();
		t5.setFont(f1);
		add(t5);
		t5.setBounds(350,250,300,25);
		P2.add(t5);	
		
		L7=new JLabel("Rate");
		L7.setFont(f1);
		add(L7);
		L7.setBounds(50,300,280,30);
				L7.setForeground(Color.white);
		P2.add(L7);
		t3=new JTextField();
		t3.setFont(f1);
		add(t3);
		t3.setBounds(350,300,300,25);
		P2.add(t3);	
		
		
		
		L10=new JLabel("Total");
		L10.setFont(f1);
		add(L10);
		L10.setBounds(50,350,280,30);
				L10.setForeground(Color.white);
		P2.add(L10);
		t6=new JTextField();
		t6.setFont(f1);
		//add(t6);
		t6.setBounds(350,350,300,25);
		P2.add(t6);	
		b1=new JButton("Add To Cart");
		b1.setFont(f1);
		//add(b1);
		b1.setBounds(50,400,200,30);
		//P2.add(b1);
		b2=new JButton("Issue Bicycle");
		b2.setFont(f1);
		//add(b2);
		b2.setBounds(270,400,200,30);
		P2.add(b2);
		b3=new JButton("Clear");
		b3.setFont(f1);
		//add(b3);
		b3.setBounds(490,400,200,30);
		P2.add(b3);
		b4=new JButton("Home");
		b4.setFont(f1);
		//add(b4);
		b4.setBounds(710,400,200,30);
		P2.add(b4);
		b5=new JButton("calculate");
		b5.setFont(f1);
		//add(b5);
		b5.setBounds(930,400,200,30);
		P2.add(b5);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		dp.addItemListener(this);
		dp1.addItemListener(this);
		lstproduct.addItemListener(this);
		btnNew.addActionListener(this);
		 dmax=Toolkit.getDefaultToolkit().getScreenSize();
		 //Dimension dmax=Toolkit.getDefaultToolkit().getScreenSize();
		 setMaximumSize(dmax);
		 setExtendedState(JFrame.MAXIMIZED_BOTH);


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
		 	String sql="select * from tbl_customer where cid="+Integer.parseInt(nq)+"";
		 			rs=st1.executeQuery(sql);
		 			while(rs.next())
		 			{
		 				t1.setText(rs.getString(2));	
		 			}
		 		
		 		 		}
		 		
		 		if(ae.getSource()==dp1)
		 		{
					System.out.println("in btype Driver Loaded");
					JOptionPane.showMessageDialog(null,"In event this","this",JOptionPane.INFORMATION_MESSAGE);
		 			lstproduct.removeAllItems();
		 			String nq=(String)ae.getItem();
			 		Statement st2=con.createStatement();
					final String[] cols={"Id","Name","Description","Quantity","Rate"};
    		    	final Object rows[][]=new Object[10][8];
    		    	//final String ss[][]=new String[10][8];
    		    	int i=0;
					try{
			String sql="select * from tbl_Bicycle where btype='"+nq+"'";
			 			ResultSet rs1=st2.executeQuery(sql);
			 			
			 			while(rs1.next())
			 			{
			 					
			 			
    		    	
    		     	
      		    	String s1=rs1.getString(1);
    		    	String pnm=rs1.getString(2);
			 				lstproduct.addItem(pnm);
    		    	String s3=rs1.getString(3);
    		    	String s4=rs1.getString(4);
    		    	String s5=rs1.getString(5);
    		    
    		    	rows[i][0]=(Object)s1;
    		    	rows[i][1]=(Object)pnm;
    		    	rows[i][2]=(Object)s3;
    		    	rows[i][3]=(Object)s4;
    		    	rows[i][4]=(Object)s5;
    		    i++;
    		    	
    		    	}
    		    	
    		    	table1=new JTable(rows,cols);
    		    JSP=new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  	  	 	    		    	
    		    	JSP.setBounds(700,150,700,200);
    		    	JSP.setBackground(Color.white);
    		    	JSP.setVisible(true);
    		    	P2.add(JSP);
			
 }catch(Exception e) 
    		       	  {
    		       		System.out.println("error"+e);  
    		       		  
    		       	  }
			 						
		 		}
		 		if(ae.getSource()==lstproduct)
		 		{
		 		String nq=(String)ae.getItem();
			 		
			 String sql="select * from tbl_Bicycle where Bicycle_id="+Integer.parseInt(nq)+"";
			 			ResultSet rs2=st.executeQuery(sql);
			 			while(rs2.next())
			 			{
			 				t4.setText(rs2.getString(6));	
							t3.setText(rs2.getString(7));
			 			}
			 		
			 				
		 		}
		 		
		 		//con.close();
		 		}
		 		catch(ClassNotFoundException e) {System.out.println("driver"+e);}
		 		catch(SQLException e) {System.out.println("query error"+e);}
	

		 	}


	public void actionPerformed(ActionEvent ae)
	{
		
		String cid,name,stype,oid="",sproduct,rate,aqty,eqty,total;
		ResultSet rs;
		Connection con;
		Statement st;
		int id,qty;
		String q;
		
		//add to cart
		/*if(ae.getSource()==b1)
		{
		
		try {
			srno++;
						name=(String)dp.getSelectedItem();
						cid=t1.getText();
						stype=(String)dp1.getSelectedItem();
						oid=t7.getText();
						sproduct=(String)lstproduct.getSelectedItem();
						rate=t3.getText();
						aqty=t4.getText();
						eqty=t5.getText();
						total=t6.getText();
						famt=famt+Integer.parseInt(total);
						qty=Integer.parseInt(aqty)-Integer.parseInt(eqty);
				Class.forName("com.mysql.cj.jdbc.Driver");
			    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
    			st=con.createStatement();
				q="insert into salesorder values('" +name+"',"+Integer.parseInt(cid)+",'"+stype+"',"+Integer.parseInt(oid)+",'"+sproduct+"','"+rate+"','"+aqty+"','"+eqty+"','"+total+"')";
		st.executeUpdate(q);
		q="insert into sales_temp values("+srno+",'"+sproduct+"','"+rate+"','"+eqty+"','"+total+"')";
		st.executeUpdate(q);
		q="update product set qty="+qty+" where pname='"+sproduct+"'";
		st.executeUpdate(q);
    			String sql="select * from Sales_temp";
    		    rs=st.executeQuery(sql);
    		    		final String[] cols={"Sr.No","Name","Quantity","Rate","Total"};
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
    		    
    		    	rows[i][0]=(Object)s1;
    		    	rows[i][1]=(Object)s2;
    		    	rows[i][2]=(Object)s3;
    		    	rows[i][3]=(Object)s4;
    		    	rows[i][4]=(Object)s5;
    		    i++;
    		    	
    		    	}
    		    	
    		    	table1=new JTable(rows,cols);
    		    JSP=new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  	  	 	    		    	
    		    	JSP.setBounds(700,150,700,200);
    		    	JSP.setBackground(Color.white);
    		    	JSP.setVisible(true);
    		    	P2.add(JSP);
					
    		        
    		       	  }catch(Exception e) 
    		       	  {
    		       		System.out.println("error"+e);  
    		       		  
    		       	  }
		  	

		
		}*/
		
		     //save button b2
		if(ae.getSource()==b2)
		{
			int nqty=Integer.parseInt(t4.getText());
			nqty=nqty-1;
			
						try
						{
							name=(String)dp.getSelectedItem();
						cid=t1.getText();
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connection driver loaded");   //+Integer.parseInt(id)+"
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		st=con.createStatement();
		String sql="insert into tbl_Issueorder values("+ Integer.parseInt(t7.getText())+","+ Integer.parseInt((String)lstproduct.getSelectedItem())+",'"+txtdate.getText()+"','9/19/2024','10 am','12 pm','Gear',"+Integer.parseInt(t3.getText())+","+Integer.parseInt(t6.getText())+",'"+ t1.getText()+"');";
			st.executeUpdate(sql);
			//bicycle quantity updated
			String sql1="update tbl_bicycle set quantity="+ nqty +" where bicycle_id="+Integer.parseInt((String)lstproduct.getSelectedItem())+"";
			st.executeUpdate(sql1);
		con.close();
		JOptionPane.showMessageDialog(null,"Bicycle issued thank you","Issue ..", JOptionPane.INFORMATION_MESSAGE);
		
						}catch(Exception e) {
							System.out.println("error"+e);
						}
		
		}
		//add new
		if(ae.getSource()==btnNew)
		{
			System.out.println("in btype Driver Loaded");
					//JOptionPane.showMessageDialog(null,"In event this","this",JOptionPane.INFORMATION_MESSAGE);
		 			lstproduct.removeAllItems();
					
					final String[] cols={"Id","Name","Description","Quantity","Rate"};
    		    	final Object rows[][]=new Object[10][8];
    		    	//final String ss[][]=new String[10][8];
    		    	int i=0;
					try{
						con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		 			String nq=(String)dp.getSelectedItem();
			 		Statement st2=con.createStatement();
			String sql="select * from tbl_Bicycle where btype='Gear'";
			 			ResultSet rs1=st2.executeQuery(sql);
			 			System.out.println("in btype Driver Loaded"+nq);
			 			while(rs1.next())
			 			{
			 					
			 			
    		    	
    		     	
      		    	String s1=rs1.getString(1);
    		    	String pnm=rs1.getString(2);
			 				lstproduct.addItem(s1);
    		    	String s3=rs1.getString(3);
    		    	String s4=rs1.getString(4);
    		    	String s5=rs1.getString(5);
    		    
    		    	rows[i][0]=(Object)s1;
    		    	rows[i][1]=(Object)pnm;
    		    	rows[i][2]=(Object)s3;
    		    	rows[i][3]=(Object)s4;
    		    	rows[i][4]=(Object)s5;
    		    i++;
    		    	
    		    	}
    		    	
    		    	table1=new JTable(rows,cols);
    		    JSP=new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  	  	 	    		    	
    		    	JSP.setBounds(700,150,700,200);
    		    	JSP.setBackground(Color.white);
    		    	JSP.setVisible(true);
    		    	P2.add(JSP);
			
 }catch(Exception e) 
    		       	  {
    		       		System.out.println("error"+e);  
    		       		  
    		       	  }
			int orderid=0;
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		
			st=con.createStatement();
			q="select max(issueid) from tbl_Issueorder";
			rs=st.executeQuery(q);
			while(rs.next())
			{
				orderid=Integer.parseInt(rs.getString(1));
			}
			
			orderid++;
			t7.setText(Integer.toString(orderid));
					//q="delete from  sales_temp";
		//st.executeUpdate(q);
			con.close();
			}catch(Exception e)
			{
				System.out.println("Error"+e);
			}
	//JOptionPane.showMessageDialog(null,"Save","Save",JOptionPane.INFORMATION_MESSAGE);
			
		}

		//clear button b3
		if(ae.getSource()==b3)
		{
			t1.setText("");
			//t2.setText("");
			t3.setText("");
			t4.setText("");
			t5.setText("");
			t6.setText("");
			t7.setText("");
			
		}

//calculate button b3
		if(ae.getSource()==b5)
		{
			int r1,q1,tt;
			q1=Integer.parseInt(t5.getText());
			r1=Integer.parseInt(t3.getText());
			tt=r1*q1;
			//String result=String.valueOf(tt);
			//t6.setText(String.valueOf(tt));
			t6.setText(Integer.toString(tt));
			
		}
		//Hide button b4
		if(ae.getSource()==b4)
		{
			hide();
		}
		
		
		
		
	}
public static void main(String args[])
{
sales ob=new sales();
}
}