
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;


public class EmployeeSalarySearch extends JFrame  implements ActionListener,KeyListener,ItemListener
{
	Container c;
	JPanel P1,P2;
	JComboBox dp,dp1,dp2;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,img1,L8,L9,L10,L11;
	JTextField t1,t2,t3,t4,t5,t6,txtyear,txtmonth;
	JButton b1,b2,b3,b4,b5;
	ImageIcon Limage,L1image;
	Color c1=new Color(128,0,128);
	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
	Font f1=new Font("Times New Roman",Font.BOLD,25);
	Font f2=new Font("Times New Roman",Font.BOLD,65);
	
	int cnt;
	String o;
	ResultSet rs;
	Connection con;
	Statement st;
	
	int cid;
	String q;

	public EmployeeSalarySearch()
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

		L2=new JLabel("Salary Searching Form");
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

		L3=new JLabel("Employee Id");
		L3.setFont(f1);
		add(L3);
		L3.setBounds(50,40,200,25);
		L3.setForeground(Color.white);
		P2.add(L3);
		
		
		t1=new JTextField();
		t1.setFont(f1);
		add(t1);
		t1.setBounds(300,40,150,25);
		P2.add(t1);
		

		L4=new JLabel("Date");
		L4.setFont(f1);
		add(L4);
		L4.setBounds(500,40,200,25);
		L4.setForeground(Color.white);
		P2.add(L4);
		
		
		t2=new JTextField();
		t2.setFont(f1);
		add(t2);
		t2.setBounds(680,40,150,25);
		P2.add(t2);
		


		L5=new JLabel("Select Reciept  Id");
		L5.setFont(f1);
		add(L5);
		L5.setBounds(50,90,200,25);
		L5.setForeground(Color.white);
		P2.add(L5);
		
		
		dp=new JComboBox();
		dp.setFont(f1);
		dp.setBounds(300,90,300,30);
		P2.add(dp);
	
		
		//view customer id
		

	     try
			{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Connection driver loaded");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
	st=con.createStatement();
	q="select * from tbl_salary";
	rs=st.executeQuery(q);
	while(rs.next())
	{
		dp.addItem(rs.getString(1));
		
		
	}
	con.close();
	
			}catch(Exception e) {}
	
		
		
	     
	     
	     
	     
	     
	
		
		
		L6=new JLabel("Name");
		L6.setFont(f1);
		add(L6);
		L6.setBounds(50,132,200,25);
				L6.setForeground(Color.white);
		P2.add(L6);

		t3=new JTextField();
		t3.setFont(f1);
		add(t3);
		t3.setBounds(300,132,300,25);
		P2.add(t3);	
		
		
		L7=new JLabel(" Month");
		L7.setFont(f1);
		add(L7);
		L7.setBounds(50,178,200,25);
				L7.setForeground(Color.white);
		P2.add(L7);

		/*dp1=new JComboBox();
		dp1.setFont(f1);
		dp1.addItem("January");
		dp1.addItem("February");
		dp1.addItem("March");
		dp1.addItem("April");
		dp1.addItem("May");
		dp1.addItem("June");
		dp1.addItem("July");
		dp1.addItem("August");
		dp1.addItem("Septmeber");
		dp1.addItem("November");
		dp1.addItem("December");
		*/
		txtmonth=new JTextField();
		txtmonth.setBounds(300,178,300,30);
		P2.add(txtmonth);
		

	
		L8=new JLabel(" Year  ");
		L8.setFont(f1);
		add(L8);
		L8.setBounds(50,228,200,25);
				L8.setForeground(Color.white);
		P2.add(L8);
		
		/*dp2=new JComboBox();
		dp2.setFont(f1);
		dp2.addItem("2021");
		dp2.addItem("2022");
		dp2.addItem("2023");
		*/
		txtyear=new JTextField();
		txtyear.setBounds(300,228,300,30);
		P2.add(txtyear);


		L9=new JLabel("Gross Amount");
		L9.setFont(f1);
		add(L9);
		L9.setBounds(50,288,200,25);
				L9.setForeground(Color.white);
		P2.add(L9);
		
		t4=new JTextField();
		t4.setFont(f1);
		add(t4);
		t4.setBounds(300,288,300,25);
		P2.add(t4);	

		L10=new JLabel("Deduction");
		L10.setFont(f1);
		add(L10);
		L10.setBounds(50,343,200,25);
				L10.setForeground(Color.white);
		P2.add(L10);
		
		t5=new JTextField();
		t5.setFont(f1);
		add(t5);
		t5.setBounds(300,343,300,25);
		P2.add(t5);	

		L11=new JLabel("Net Pay");
		L11.setFont(f1);
		add(L11);
		L11.setBounds(50,393,200,25);
				L11.setForeground(Color.white);
		P2.add(L11);

		t6=new JTextField();
		t6.setFont(f1);
		add(t6);
		t6.setBounds(300,393,300,25);
		P2.add(t6);	
		
		




		b1=new JButton("Add");
		b1.setFont(f1);
		//add(b1);
		b1.setBounds(50,450,140,30);
		//P2.add(b1);

		b2=new JButton("Save");
		b2.setFont(f1);
		//add(b2);
		b2.setBounds(220,450,140,30);
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
		//P2.add(b5);
		

		b1.addActionListener(this);
		b2.addActionListener(this);
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
			q="select * from tbl_salary where recid="+ Integer.parseInt(strid)+"";
			rs=st.executeQuery(q);
			while(rs.next())
			{
				
				
				t2.setText(rs.getString(2));
				t1.setText(rs.getString(3));
				t3.setText(rs.getString(4));
				txtmonth.setText(rs.getString(5));
				txtyear.setText(rs.getString(6));
				t4.setText(rs.getString(7));
				t5.setText(rs.getString(8));
				t6.setText(rs.getString(9));
				
			}
			con.close();
			
					}catch(Exception e) {}
				
		
	}
	
	
	
	

	public void actionPerformed(ActionEvent ae)
	{
		String id="",date,eid,name,smonth,syear,samt,deduction,netpay;
		ResultSet rs;
		Connection con;
		Statement st;
		int rid;
		String q;
	//save button b2
		if(ae.getSource()==b2)
		{
						id=t1.getText();
						date=t2.getText();
						eid=(String)dp.getSelectedItem();
						name=t3.getText();
						smonth=txtmonth.getText();
						syear=txtyear.getText();
						samt=t4.getText();
						deduction=t5.getText();
						netpay=t6.getText();
						try
						{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connection driver loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		st=con.createStatement();
		//q="insert into salary values("+Integer.parseInt(id)+",'" + date +"',"+Integer.parseInt(eid)+",'"+name+"','"+smonth+"','"+syear+"','"+samt+"','"+deduction+"','"+netpay+"')";
		//st.executeUpdate(q);
		con.close();
		JOptionPane.showMessageDialog(null,"Values are updated","Saved", JOptionPane.INFORMATION_MESSAGE);
		
						}catch(Exception e) {}
		
		}
		//add new
		if(ae.getSource()==b1)
		{
			try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		
			
			st=con.createStatement();
			q="select max(rid) from salary";
			rs=st.executeQuery(q);
		

			while(rs.next())
			{
				id=rs.getString(1);
			}
			rid=Integer.parseInt(id)+1;
			t1.setText(String.valueOf(rid));
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
		
			
		}
		//Hide button b4
		if(ae.getSource()==b4)
		{
			hide();
		}

	}







public static void main(String args[])
{
EmployeeSalarySearch ob=new EmployeeSalarySearch();
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

