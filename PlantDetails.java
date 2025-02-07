import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
public class PlantDetails extends JFrame implements ActionListener,KeyListener,ItemListener
{
	Container c;
	JPanel P1,P2;
	JComboBox dp,dp1;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,img1,L8,lblcollection,lblexpenxex,lblbalance,lblplantid;
	JTextField t1,t2,t3,t4,t5,txtcollection,txtexpenses,txtbalance,t6,txtplantid;
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
	double totalbalance=0,totalexpense=0,totalcollection=0;
	public PlantDetails()
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

		L2=new JLabel("Plant Entry Form");
		L2.setFont(f2);
	
		L2.setBounds(390,10,850,150);
		L2.setForeground(Color.white);
		P1.add(L2);

		P2=new JPanel();
		add(P2);
		P2.setBounds(30,200,1300,800);
		P2.setBackground(c1);
		P2.setLayout(null);

		
	
	
		
lblplantid=new JLabel("Plant Id");
		lblplantid.setFont(f1);
		
		lblplantid.setBounds(700,40,250,25);
		lblplantid.setForeground(Color.white);
		P2.add(lblplantid);

		txtplantid=new JTextField();
		txtplantid.setFont(f1);
		
		txtplantid.setBounds(1000,40,250,25);
		P2.add(txtplantid);	

lblcollection=new JLabel("Total Collection");
		lblcollection.setFont(f1);
		add(lblcollection);
		lblcollection.setBounds(700,90,250,25);
		lblcollection.setForeground(Color.white);
		P2.add(lblcollection);

		txtcollection=new JTextField();
		txtcollection.setFont(f1);
		add(txtcollection);
		txtcollection.setBounds(1000,90,250,25);
		P2.add(txtcollection);	

lblexpenxex=new JLabel("Total Expenses");
		lblexpenxex.setFont(f1);
		add(lblexpenxex);
		lblexpenxex.setBounds(700,132,250,25);
		lblexpenxex.setForeground(Color.white);
		P2.add(lblexpenxex);

		txtexpenses=new JTextField();
		txtexpenses.setFont(f1);
		add(txtexpenses);
		txtexpenses.setBounds(1000,132,250,25);
		P2.add(txtexpenses);	


lblbalance=new JLabel("Total Balance");
		lblbalance.setFont(f1);
		add(lblbalance);
		lblbalance.setBounds(700,178,250,25);
		lblbalance.setForeground(Color.white);
		P2.add(lblbalance);

		txtbalance=new JTextField();
		txtbalance.setFont(f1);
		add(txtbalance);
		txtbalance.setBounds(1000,178,250,25);
		P2.add(txtbalance);	

//calculation of totals

try
		 		{	
		 			Class.forName("com.mysql.cj.jdbc.Driver");	
		 			System.out.print("Connection done");
		 			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		 			System.out.println("Driver Loaded");
		 			st=con.createStatement();
		 			String sql="select sum(amount) from tbl_custpayment";
		 			rs=st.executeQuery(sql);
		 			while(rs.next())
		 			{
		 				txtcollection.setText(rs.getString(1));	
		 			}
		 			con.close();
					
					
					Class.forName("com.mysql.cj.jdbc.Driver");	
		 			System.out.print("Connection done");
		 			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		 			System.out.println("Driver Loaded");
		 			st=con.createStatement();
		 			String sql1="select sum(amount) from tbl_plant";
		 			rs=st.executeQuery(sql1);
		 			while(rs.next())
		 			{
		 				txtexpenses.setText(rs.getString(1));	
		 			}
		 			con.close();
					double amt=Double.parseDouble(txtcollection.getText())-Double.parseDouble(txtexpenses.getText());
					txtbalance.setText(String.valueOf(amt));
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		 		}
		 		catch(ClassNotFoundException e) {System.out.println("driver"+e);}
		 		catch(SQLException e) {System.out.println("query error"+e);}
		 		
		 	
















L3=new JLabel("Area");
		L3.setFont(f1);
		
			L3.setBounds(50,40,250,25);
			L3.setForeground(Color.white);
		P2.add(L3);
			
	t1=new JTextField();
	t1.setBounds(350,40,300,25);
	P2.add(t1);
L4=new JLabel("Co-ordinate");
		L4.setFont(f1);
	
		L4.setBounds(50,90,250,25);
		L4.setForeground(Color.white);
		P2.add(L4);
		t2=new JTextField();
		t2.setFont(f1);
		
t2.setBounds(350,90,300,25);
		P2.add(t2);	

		L5=new JLabel("No of plants");
		L5.setFont(f1);
		
				L5.setBounds(50,132,250,25);
				L5.setForeground(Color.white);
		P2.add(L5);

		t3=new JTextField();
		t3.setFont(f1);
		
		t3.setBounds(350,132,300,25);
		P2.add(t3);	

		L6=new JLabel("Type of plants");
		L6.setFont(f1);
	
		L6.setBounds(50,178,250,25);
		L6.setForeground(Color.white);
		P2.add(L6);

		dp1=new JComboBox();
		dp1.setFont(f1);
		dp1.addItem("Flower/Fruits");
		dp1.addItem("Non Flower");
		dp1.addItem("Ayurvedic plants");
		dp1.setBounds(350,178,300,25);
		P2.add(dp1);

		L7=new JLabel("Description");
		L7.setFont(f1);
		
		L7.setBounds(50,233,250,25);
		L7.setForeground(Color.white);
		P2.add(L7);

		t4=new JTextField();
		t4.setFont(f1);
	
		t4.setBounds(350,233,300,100);
		P2.add(t4);	

		L8=new JLabel("Amount");
		L8.setFont(f1);
		
		L8.setBounds(50,363,250,25);
		L8.setForeground(Color.white);
		P2.add(L8);

		t5=new JTextField();
		t5.setFont(f1);
	
		t5.setBounds(350,363,300,25);
		P2.add(t5);	

		L8=new JLabel("Expenses");
		L8.setFont(f1);
	
		L8.setBounds(50,405,250,25);
		L8.setForeground(Color.white);
		P2.add(L8);

		t6=new JTextField();
		t6.setFont(f1);

		t6.setBounds(350,405,300,25);
		P2.add(t6);	



		b1=new JButton("Add");
		b1.setFont(f1);
	
		b1.setBounds(50,460,140,30);
		P2.add(b1);

		b2=new JButton("Save");
		b2.setFont(f1);
		
		b2.setBounds(220,460,140,30);
		P2.add(b2);

		b3=new JButton("Clear");
		b3.setFont(f1);
		
		b3.setBounds(390,460,140,30);
		P2.add(b3);
	
		b4=new JButton("Home");
		b4.setFont(f1);
	
		b4.setBounds(560,460,140,30);
		P2.add(b4);


		b5=new JButton("Update");
		b5.setFont(f1);
		
		b5.setBounds(730,460,140,30);
		//P2.add(b5);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		t1.addKeyListener(this);
		t3.addKeyListener(this);
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
		 			String sql="select * from tbl_supplier where sid="+nq+"";
		 			rs=st.executeQuery(sql);
		 			while(rs.next())
		 			{
		 				t4.setText(rs.getString(2));	
		 			}
		 			con.close();
		 		}
		 		catch(ClassNotFoundException e) {System.out.println("driver"+e);}
		 		catch(SQLException e) {System.out.println("query error"+e);}
		 		}
		 	

		 	}

	public void keyPressed(KeyEvent e) {
		
	
 
		
		/*if(e.getSource()==t3)
		{
			char ch=e.getKeyChar();
			if(ch>=48 && ch<=57)
			{
				JOptionPane.showMessageDialog(null,"Numbers are not allowed","NewUser",JOptionPane.INFORMATION_MESSAGE);
				t2.setText("");
			}
		}*/
	}



	 
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	 
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	
	
	public void actionPerformed(ActionEvent ae)
	{
		String sid,pid="",name,type,description,qty,rate;
	
		int id;
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
		q="insert into tbl_plant values('"+t1.getText()+"','" + t2.getText() +"',"+Integer.parseInt(t3.getText())+",'"+(String)dp1.getSelectedItem()+"','"+t4.getText()+"',"+Integer.parseInt(t5.getText())+","+Integer.parseInt(t6.getText())+","+ Integer.parseInt(txtplantid.getText())+")";
		st.executeUpdate(q);
		con.close();
		JOptionPane.showMessageDialog(null,"Values are saved","Saved", JOptionPane.INFORMATION_MESSAGE);
		SupplierPayment sp=new SupplierPayment(txtplantid.getText(),t5.getText(),t6.getText());
		sp.show();
		
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
			q="select max(plant_id) from tbl_plant";
			rs=st.executeQuery(q);
		

			while(rs.next())
			{
				pid=rs.getString(1);
			}
			id=Integer.parseInt(pid)+1;
			txtplantid.setText(String.valueOf(id));
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
			
			
		}


		//Hide button b4
		if(ae.getSource()==b4)
		{
			hide();
		}
	}


public static void main(String args[])
{
PlantDetails ob=new PlantDetails();
}
}