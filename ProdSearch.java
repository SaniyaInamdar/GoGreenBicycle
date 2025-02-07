
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
public class ProdSearch extends JFrame implements ActionListener,KeyListener,ItemListener
{
	Container c;
	JPanel P1,P2;
	JComboBox dp,dp1;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,img1,L8;
	JTextField t1,t2,t3,t4,t5,t6;
	JButton b1,b2,b3,b4,b5;
	ImageIcon Limage,L1image,L2image;
	Color c1=new Color(128,0,128);
	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
	Font f1=new Font("Times New Roman",Font.BOLD,25);
	Font f2=new Font("Times New Roman",Font.BOLD,65);
	int cnt;
	String o,q;
	Dimension dmax;
	ResultSet rs;
	Connection con;
	Statement st;
	public ProdSearch ()
	{
		setSize (1800,1800);
		setVisible(true);
		setLayout(null);
		setFont(f1);
		setBackground(c2);
		P1=new JPanel();
		add(P1);
		P1.setBounds(30,30,1300,150);
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

		L2=new JLabel("Bicycle Search Form");
		L2.setFont(f2);
		add(L2);
		L2.setBounds(390,10,850,150);
		L2.setForeground(Color.white);
		P1.add(L2);

		P2=new JPanel();
		add(P2);
		P2.setBounds(30,200,1300,800);
		P2.setBackground(c1);
		P2.setLayout(null);

		L3=new JLabel("Bicycle Id");
		L3.setFont(f1);
		add(L3);
		L3.setBounds(50,40,250,25);
		L3.setForeground(Color.white);
		P2.add(L3);

		dp=new JComboBox();
		
//Product name
		
		try
		{
Class.forName("com.mysql.cj.jdbc.Driver");
System.out.println("Connection driver loaded");
con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
st=con.createStatement();
q="Select * from tbl_Bicycle";
rs=st.executeQuery(q);
while(rs.next())
{
	dp.addItem(rs.getString(1));
}
con.close();


		}catch(Exception e) {}
		dp.setBounds(350,40,300,25);
		P2.add(dp);	
		
		L4=new JLabel("Company Name");
		L4.setFont(f1);
		add(L4);
		L4.setBounds(50,90,250,25);
		L4.setForeground(Color.white);
		P2.add(L4);

		t2=new JTextField();
		t2.setFont(f1);
		add(t2);
		t2.setBounds(350,90,300,25);
		P2.add(t2);	

		L5=new JLabel("Model");
		L5.setFont(f1);
		add(L5);
		L5.setBounds(50,132,250,25);
		L5.setForeground(Color.white);
		P2.add(L5);

		t3=new JTextField();
		t3.setFont(f1);
		add(t3);
		t3.setBounds(350,132,300,25);
		P2.add(t3);	

		L6=new JLabel("Type");
		L6.setFont(f1);
		add(L6);
		L6.setBounds(50,178,250,25);
		L6.setForeground(Color.white);
		P2.add(L6);
		
		t6=new JTextField();
		t6.setFont(f1);
		add(t6);
		t6.setBounds(350,178,300,25);
		P2.add(t6);

		//dp1=new JComboBox();
		//dp1.setFont(f1);
		//dp1.addItem("Vegetables");
		//dp1.addItem("Fruits");
		//dp1.addItem("Grocerry");
		//dp1.setBounds(460,178,300,25);
		//P2.add(dp1);

		L7=new JLabel("Description");
		L7.setFont(f1);
		add(L7);
		L7.setBounds(50,233,250,25);
		L7.setForeground(Color.white);
		P2.add(L7);

		t4=new JTextField();
		t4.setFont(f1);
		add(t4);
		t4.setBounds(350,233,300,100);
		P2.add(t4);	

		L8=new JLabel("Quantity");
		L8.setFont(f1);
		add(L8);
		L8.setBounds(50,363,250,25);
		L8.setForeground(Color.white);
		P2.add(L8);

		t5=new JTextField();
		t5.setFont(f1);
		add(t5);
		t5.setBounds(350,363,300,25);
		P2.add(t5);	

		L8=new JLabel("Rate(per hour)");
		L8.setFont(f1);
		add(L8);
		L8.setBounds(50,405,250,25);
		L8.setForeground(Color.white);
		P2.add(L8);

		t1=new JTextField();
		t1.setFont(f1);
		add(t1);
		t1.setBounds(350,405,300,25);
		P2.add(t1);	



		b1=new JButton("Add");
		b1.setFont(f1);
		//add(b1);
		b1.setBounds(50,460,140,30);
		//P2.add(b1);

		b2=new JButton("Save");
		b2.setFont(f1);
		//add(b2);
		b2.setBounds(220,460,140,30);
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

		b5.addActionListener(this);
		//b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		t1.addKeyListener(this);
		t3.addKeyListener(this);
		
		//add this item listener
				dp.addItemListener(this);
				
				
		 dmax=Toolkit.getDefaultToolkit().getScreenSize();
		 Dimension dmax=Toolkit.getDefaultToolkit().getScreenSize();
		 setMaximumSize(dmax);
		 setExtendedState(JFrame.MAXIMIZED_BOTH);


		 }
		 public void itemStateChanged(ItemEvent ae)
		 	{
		 		if(ae.getSource()==dp)
		 		{
		 		String nq=(String)ae.getItem();
		 		
		 		try
		 		{	
		 			Class.forName("com.mysql.cj.jdbc.Driver");	
		 			System.out.print("Connection done");
		 		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		 			System.out.println("Driver Loaded");
		 			st=con.createStatement();
		 			String sql="select * from tbl_Bicycle where bicycle_id="+Integer.parseInt(nq)+"";
		 			rs=st.executeQuery(sql);
		 			while(rs.next())
		 			{
		 				t2.setText(rs.getString(2));
		 				t3.setText(rs.getString(3));
		 				t6.setText(rs.getString(4));
		 				t4.setText(rs.getString(5));
		 				t5.setText(rs.getString(6));
		 				t1.setText(rs.getString(7));
		 
		 			}
		 			con.close();
		 		}
		 		catch(ClassNotFoundException e) {System.out.println("driver"+e);}
		 		catch(SQLException e) {System.out.println("query error"+e);}
		 		}
		 	

		 	}

	public void keyPressed(KeyEvent e) {
		
	
 
		if(e.getSource()==t1)
		{
			char ch=e.getKeyChar();
			if(ch>=65||ch==32)
			{
				JOptionPane.showMessageDialog(null,"Characters or space are not allowed","NewUser",JOptionPane.INFORMATION_MESSAGE);
				t4.setText("");
			   o="";
			   cnt=0;
		    }
		}
		if(e.getSource()==t3)
		{
			char ch=e.getKeyChar();
			if(ch>=48 && ch<=57)
			{
				JOptionPane.showMessageDialog(null,"Numbers are not allowed","NewUser",JOptionPane.INFORMATION_MESSAGE);
				t2.setText("");
			}
		}
	}








	
	
	public void actionPerformed(ActionEvent ae)
	{
		String sid,pid="",name,type,description,qty,rate;
	
		int id;
		String q;
	//save button b5
		if(ae.getSource()==b5)
		{
						sid=(String)dp.getSelectedItem();
						pid=t2.getText();
						name=t3.getText();
						type=t6.getText();
						description=t4.getText();
						qty=t5.getText();
						rate=t1.getText();
					  try
				{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connection driver loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		st=con.createStatement();
		q="update tbl_Bicycle set compname='" + pid +"', model='"+name+"',btype='"+type+"',descr='"+description+"',quantity='"+qty+"',rate='"+rate+"' where bicycle_id="+Integer.parseInt(sid)+"";
		st.executeUpdate(q);
		con.close();
		JOptionPane.showMessageDialog(null,"Values are updated","Updation", JOptionPane.INFORMATION_MESSAGE);
		
				}catch(Exception e) {
					System.out.println("Connection driver loaded"+e);							
					
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
ProdSearch ob=new ProdSearch();
}
 
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
 
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}
}
