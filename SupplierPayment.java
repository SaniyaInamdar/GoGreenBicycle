import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;


public class SupplierPayment extends JFrame  implements ActionListener,ItemListener
{
	Container c;
	JPanel P1,P2;
	JComboBox dp,dp1,dp2;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,img1,L8,L9,L10,L11,L12,L13;
	JTextField t1,t2,t3,t4,t5,t6,t7,t8;
	JButton b1,b2,b3,b4,b5;
	ImageIcon Limage,L1image,L2image;
	double amount,expenses,total;
	Color c1=new Color(128,0,128);
	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
	Font f1=new Font("Times New Roman",Font.BOLD,25);
	Font f2=new Font("Times New Roman",Font.BOLD,65);
	ResultSet rs;
	Connection con;
	Statement st;
String q;
 java.util.Date date=new java.util.Date();
	public SupplierPayment(String plantid,String amount,String Expenses)
	{
		setSize (1800,1800);
		setVisible(true);
		setLayout(null);
		setFont(f1);
		setBackground(c2);
		
		total=Double.parseDouble(amount)+Double.parseDouble(Expenses);
	
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

		L2=new JLabel("Supplier Payment Form");
		L2.setFont(f2);
		
		L2.setBounds(300,10,850,150);
		L2.setForeground(Color.white);
		P1.add(L2);
		
		
		
		P2=new JPanel();
		add(P2);
		P2.setBounds(30,200,1300,800);
		P2.setBackground(c1);
		P2.setLayout(null);

		L3=new JLabel("Select Supplier  Id");
		L3.setFont(f1);
	
		L3.setBounds(50,40,220,25);
		L3.setForeground(Color.white);
		P2.add(L3);
		
		dp=new JComboBox();
		dp.setFont(f1);
		
		dp.setBounds(300,40,300,30);
		
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
	
		
		
		P2.add(dp);
		
		
		
		
		
		L13=new JLabel("Payment Id");
		L13.setFont(f1);
		
		L13.setBounds(650,40,200,25);
		L13.setForeground(Color.white);
		P2.add(L13);
		
		t8=new JTextField();
		t8.setFont(f1);
		t8.setBounds(900,40,150,25);
		P2.add(t8);
		
		
		
		
		
		
		
		
		
		L4=new JLabel("Plant Id");
		L4.setFont(f1);
		
		L4.setBounds(50,90,200,25);
		L4.setForeground(Color.white);
		P2.add(L4);
		
		t1=new JTextField();
		t1.setFont(f1);
		t1.setText(plantid);

		t1.setBounds(300,90,150,25);
		P2.add(t1);
		

		L5=new JLabel("Date");
		L5.setFont(f1);

		L5.setBounds(650,90,200,25);
		L5.setForeground(Color.white);
		P2.add(L5);
		
		t2=new JTextField();
		t2.setFont(f1);
		t2.setText(date.toString());
		t2.setBounds(900,90,150,25);
		P2.add(t2);	


		L6=new JLabel("Name");
		L6.setFont(f1);
	
		L6.setBounds(50,132,200,25);
		L6.setForeground(Color.white);
		P2.add(L6);

		t3=new JTextField();
		t3.setFont(f1);
	
		t3.setBounds(300,132,300,25);
		P2.add(t3);	
		
		
		L7=new JLabel("Total Amount");
		L7.setFont(f1);
		
		L7.setBounds(50,178,200,25);
				L7.setForeground(Color.white);
		P2.add(L7);

		t4=new JTextField();
		t4.setFont(f1);
		t4.setText(String.valueOf(total));
		t4.setBounds(300,178,300,25);
		P2.add(t4);

	
		L8=new JLabel("Status");
		L8.setFont(f1);
	
		L8.setBounds(50,228,200,25);
				L8.setForeground(Color.white);
		P2.add(L8);
		
		dp1=new JComboBox();
		dp1.setFont(f1);
		dp1.addItem("Paid");
		dp1.addItem("Unpaid");
		dp1.setBounds(300,228,300,30);
		P2.add(dp1);


		L9=new JLabel("Enter Cheque No");
		L9.setFont(f1);

		L9.setBounds(50,288,200,25);
				L9.setForeground(Color.white);
		P2.add(L9);
		
		t5=new JTextField();
		t5.setFont(f1);
	
		t5.setBounds(300,288,300,25);
		P2.add(t5);	

		L10=new JLabel("Bank Name");
		L10.setFont(f1);
		
		L10.setBounds(50,343,200,25);
				L10.setForeground(Color.white);
		P2.add(L10);
		
		t6=new JTextField();
		t6.setFont(f1);
	
		t6.setBounds(300,343,300,25);
		P2.add(t6);	

		L11=new JLabel("Branch");
		L11.setFont(f1);
	
		L11.setBounds(50,393,200,25);
				L11.setForeground(Color.white);
		P2.add(L11);

		t7=new JTextField();
		t7.setFont(f1);
		
		t7.setBounds(300,393,300,25);
		P2.add(t7);	
		
		L12=new JLabel("Payment Mode");
		L12.setFont(f1);
	
		L12.setBounds(50,443,200,25);
				L12.setForeground(Color.white);
		P2.add(L12);
		
		dp2=new JComboBox();
		dp2.setFont(f1);
		dp2.addItem("Cash");
		dp2.addItem("Cheque");
		dp2.addItem("UPI");
		dp2.setBounds(300,443,300,30);
		P2.add(dp2);


		L2image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/cust.png");
		img1=new JLabel(L2image);
		img1.setBounds(850,0,450,450);
		P2.add(img1);

		b1=new JButton("Add");
		b1.setFont(f1);

		b1.setBounds(650,132,100,25);
		P2.add(b1);

		b2=new JButton("Save");
		b2.setFont(f1);
	
		b2.setBounds(780,132,100,30);
		P2.add(b2);

		b3=new JButton("Clear");
		b3.setFont(f1);

		b3.setBounds(910,132,100,30);
		P2.add(b3);
	
		b4=new JButton("Home");
		b4.setFont(f1);
	
		b4.setBounds(1050,132,100,30);
		P2.add(b4);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
dp.addItemListener(this);

	}
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
					
					t3.setText(rs.getString(2));
					
					
					
				}
				con.close();
				
						}catch(Exception e) {   
						System.out.println("Connection driver loaded"); 
						}
					
			
		}
		
		
	
	public void actionPerformed(ActionEvent ae)
	{
		String id="",puid,sid,name,date,amt,status,chq,bname,branch,mode;
		ResultSet rs;
		Connection con;
		Statement st;
		String payid;
		String q;
	//save button b2
		if(ae.getSource()==b2)
		{
						id=t8.getText();
						puid=(String)dp.getSelectedItem();
						//sid=(String)t1.getText();
						name=t3.getText();
						//date=t2.getText();
						amt=t4.getText();
						status=(String)dp1.getSelectedItem();
						chq=t5.getText();
						bname=t6.getText();
						branch=t7.getText();
						mode=(String)dp2.getSelectedItem();
						try
						{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connection driver loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		st=con.createStatement();
		q="insert into tbl_suppayment values("+Integer.parseInt(id)+","+Integer.parseInt(t1.getText())+","+Integer.parseInt(puid)+",'" + name +"','"+amt+"','"+status+"',"+Integer.parseInt(chq)+",'"+branch+"','"+mode+"','"+t2.getText()+"')";
		st.executeUpdate(q);
		con.close();
		JOptionPane.showMessageDialog(null,"Values are saved","Saved", JOptionPane.INFORMATION_MESSAGE);
		
						}catch(Exception e) {
							
							
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
			q="select max(sup_payid) from tbl_suppayment";
			rs=st.executeQuery(q);
		

			while(rs.next())
			{
				id=rs.getString(1);
			}
			int suppayid=Integer.parseInt(id);
			suppayid++;
			t8.setText(String.valueOf(suppayid));
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
			t8.setText("");
		}

		
		//Hide button b4
		if(ae.getSource()==b4)
		{
			hide();
		}

	}




public static void main(String args[])
{
//SupplierPayment ob=new SupplierPayment("hello","5000","1000");
}
}
