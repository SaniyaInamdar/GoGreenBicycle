
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class SupplierSearch extends JFrame implements ActionListener,KeyListener,ItemListener
{
	Container c;
	JPanel P1,P2;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,img1;
	JTextField t1,t2,t3,t4,t5;
	JComboBox dp;
	JButton b1,b2,b3,b4,b5;
	ImageIcon Limage,L1image,L2image;
	Color c1=new Color(128,0,128);
	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
	Font f1=new Font("Times New Roman",Font.BOLD,30);
	Font f2=new Font("Times New Roman",Font.BOLD,65);
	int cnt;
	String o;
	ResultSet rs;
	Connection con;
	Statement st;
	
	int cid;
	String q;
	public SupplierSearch ()
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
		Limage=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/logo1.png");
		L1=new JLabel(Limage);
		L1.setBounds(0,0,200,180);
		P1.add(L1);

		L1image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/background4.jpeg");
		img=new JLabel(L1image);
		img.setBounds(1080,0,200,200);
		P1.add(img);

		L2=new JLabel("Supplier Searching Form");
		L2.setFont(f2);
		add(L2);
		L2.setBounds(280,10,850,150);
		L2.setForeground(Color.white);
		P1.add(L2);

		P2=new JPanel();
		add(P2);
		P2.setBounds(30,200,1300,800);
		P2.setBackground(c1);
		P2.setLayout(null);

		L3=new JLabel("ID");
		L3.setFont(f1);
		add(L3);
		L3.setBounds(50,70,100,25);
				L3.setForeground(Color.white);

		P2.add(L3);

		

		dp=new JComboBox();
		
		dp.setBounds(350,70,250,30);
		P2.add(dp);
		
		
		//view tbl_supplier id
		

	     try
			{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Connection driver loaded");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
	st=con.createStatement();
	q="select * from tbl_supplier";
	rs=st.executeQuery(q);
	while(rs.next())
	{
		dp.addItem(rs.getString(1));
		
		
	}
	con.close();
	
			}catch(Exception e) {}
	
		
		
		
		//t1=new JTextField();
		//t1.setFont(f1);
		//add(t1);
		//t1.setBounds(350,70,250,25);
		//P2.add(t1);		

		L4=new JLabel("Name");
		L4.setFont(f1);
		add(L4);
		L4.setBounds(50,125,120,25);
				L4.setForeground(Color.white);
		P2.add(L4);

		t2=new JTextField();
		t2.setFont(f1);
		add(t2);
		t2.setBounds(350,125,300,32);
		P2.add(t2);	

		L5=new JLabel("Address");
		L5.setFont(f1);
		add(L5);
		L5.setBounds(50,185,120,25);
				L5.setForeground(Color.white);
		P2.add(L5);

		t3=new JTextField();
		t3.setFont(f1);
		add(t3);
		t3.setBounds(350,180,300,50);
		P2.add(t3);	

		L6=new JLabel("Email");
		L6.setFont(f1);
		add(L6);
		L6.setBounds(50,260,120,25);
				L6.setForeground(Color.white);
		P2.add(L6);

		t4=new JTextField();
		t4.setFont(f1);
		add(t4);
		t4.setBounds(350,260,300,32);
		P2.add(t4);	
		
		L7=new JLabel("Contact");
		L7.setFont(f1);
		add(L7);
		L7.setBounds(50,313,120,25);
				L7.setForeground(Color.white);
		P2.add(L7);

		t5=new JTextField();
		t5.setFont(f1);
		add(t5);
		t5.setBounds(350,313,300,32);
		P2.add(t5);	

		b1=new JButton("Add");
		b1.setFont(f1);
		//add(b1);
		b1.setBounds(100,385,140,32);
		//P2.add(b1);

		b2=new JButton("Save");
		b2.setFont(f1);
		//add(b2);
		b2.setBounds(300,385,140,32);
		//P2.add(b2);

		b3=new JButton("Clear");
		b3.setFont(f1);
		add(b3);
		b3.setBounds(50,450,140,30);
		P2.add(b3);
	
		b4=new JButton("Home");
		b4.setFont(f1);
		add(b4);
			b4.setBounds(220,450,140,30);
		P2.add(b4);


		b5=new JButton("Update");
		b5.setFont(f1);
		add(b5);
		b5.setBounds(400,450,140,30);
		P2.add(b5);

		L2image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/vehical.png");
		img1=new JLabel(L2image);
		img1.setBounds(720,50,650,600);
		P2.add(img1);

		b5.addActionListener(this);
		
		b3.addActionListener(this);
		b4.addActionListener(this);
		//add this item listener
				dp.addItemListener(this);
		
	}

	
	
	
	//add this for combo box 

		public void itemStateChanged(ItemEvent ie) {
			String strid=(String)ie.getItem();
			   try
						{
				Class.forName("com.mysql.cj.jdbc.Driver");
				System.out.println("Connection driver loaded");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
				st=con.createStatement();
				q="select * from tbl_supplier where sid="+ Integer.parseInt(strid)+"";
				rs=st.executeQuery(q);
				while(rs.next())
				{
					
					t2.setText(rs.getString(2));
					t3.setText(rs.getString(3));
					t4.setText(rs.getString(4));
					t5.setText(rs.getString(5));
					
					
				}
				con.close();
				
						}catch(Exception e) {   
						System.out.println("Connection driver loaded"); 
						}
					
			
		}
		
		
	
	
	
	


public void actionPerformed(ActionEvent ae)
{
	String id="",sname,saddr,email,ucont;
	ResultSet rs;
	Connection con;
	Statement st;
	int sid;
	String q;
//update button b5
	if(ae.getSource()==b5)
	{
					id=(String)dp.getSelectedItem();
					sname=t2.getText();
					saddr=t3.getText();
					email=t4.getText();
					ucont=t5.getText();
					try
					{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Connection driver loaded");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
	st=con.createStatement();
	q="update tbl_supplier set sname='"+ sname +"',addre='"+ saddr +"',email='"+ email +"',contact='"+ ucont +"' where sid="+ Integer.parseInt(id)+"";
	st.executeUpdate(q);
	con.close();
	JOptionPane.showMessageDialog(null,"Values are updated","updated", JOptionPane.INFORMATION_MESSAGE);
	
					}catch(Exception e) { 
					System.out.println("Connection driver loaded"+e);
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
		q="select max(sid) from tbl_supplier";
		rs=st.executeQuery(q);
	

		while(rs.next())
		{
			id=rs.getString(1);
		}
		sid=Integer.parseInt(id)+1;
		t1.setText(String.valueOf(sid));
		con.close();
		}catch(Exception e)
		{
			System.out.println("Error"+e);
		}
			
		
	}
//clear button b3
	if(ae.getSource()==b3)
	{
		
		t2.setText("");
		t3.setText("");
		t4.setText("");
		t5.setText("");
	}


	//Hide button b4
	if(ae.getSource()==b4)
	{
		hide();
	}
}





public static void main(String args[])
{
SupplierSearch ob=new SupplierSearch();
}




 
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}




 
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}




 
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}