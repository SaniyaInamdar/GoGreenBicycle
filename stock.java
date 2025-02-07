import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class stock extends JFrame implements ActionListener,ItemListener
{
	Container c;
	JPanel P1,P2;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,img1;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3;
	ImageIcon Limage,L1image,L2image;
	Color c1=new Color(128,0,128);
	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
	Font f1=new Font("Times New Roman",Font.BOLD,25);
	Font f2=new Font("Times New Roman",Font.BOLD,65);
	ResultSet rs;
	Connection con;
	Statement st;
	JTable table1;
	 JScrollPane JSP;
	String q;
JComboBox dp,dp1,lstproduct;
	public stock()
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

		L2=new JLabel("Stock Form");
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

		L3=new JLabel("Company name");
		L3.setFont(f1);
		//add(L3);
		L3.setBounds(50,40,250,25);
		L3.setForeground(Color.white);
		P2.add(L3);
		
			dp1=new JComboBox();
		dp1.setFont(f1);
	
		//product type
		
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
	dp1.addItem(rs.getString(1));
}
con.close();


}catch(Exception e) {}
		dp1.setBounds(350,40,300,25);	
		P2.add(dp1);

		//t1=new JTextField();
		//t1.setFont(f1);
		//add(t1);
		////t1.setBounds(460,40,300,25);
		//P2.add(t1);

		L4=new JLabel("Select company  Name");
		L4.setFont(f1);
		//add(L4);
			L4.setBounds(50,90,250,25);
			L4.setForeground(Color.white);
		P2.add(L4);

		/*lstproduct=new JComboBox();
		//t2.setFont(f1);
		//add(t2);
		lstproduct.setBounds(460,90,300,25);
		P2.add(lstproduct);	*/
t2=new JTextField();
	t2.setBounds(350,90,300,25);
P2.add(t2);
		L5=new JLabel("Price");
		L5.setFont(f1);
		//add(L5);
		L5.setBounds(50,132,250,25);
		L5.setForeground(Color.white);
		P2.add(L5);

		t3=new JTextField();
		t3.setFont(f1);
		//add(t3);
t3.setBounds(350,132,300,25);
		P2.add(t3);	

		L6=new JLabel("Quantity Avaliable");
		L6.setFont(f1);
		//add(L6);
		L6.setBounds(50,178,250,25);
		L6.setForeground(Color.white);
		P2.add(L6);

		t4=new JTextField();
		t4.setFont(f1);
		//add(t4);
		t4.setBounds(350,178,300,25);
		P2.add(t4);

		L7=new JLabel("New Quantity");
		L7.setFont(f1);
		//add(L7);
L7.setBounds(50,233,250,25);
L7.setForeground(Color.white);
		P2.add(L7);

		t5=new JTextField();
		t5.setFont(f1);
		//add(t5);
		t5.setBounds(350,233,300,25);

		P2.add(t5);	

		



		//L2image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/cust.png");
		//img1=new JLabel(L2image);
		//img1.setBounds(850,0,450,450);
		//P2.add(img1);

		b1=new JButton("Update");
		b1.setFont(f1);
		//add(b1);
		b1.setBounds(50,400,140,30);
		P2.add(b1);

		b2=new JButton("Clear");
		b2.setFont(f1);
		//add(b2);
		b2.setBounds(220,400,140,30);
		P2.add(b2);

		b3=new JButton("Home");
		b3.setFont(f1);
		//add(b3);
		b3.setBounds(390,400,140,30);
		P2.add(b3);
	
	

		dp1.addItemListener(this);
		//lstproduct.addItemListener(this);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
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
	 	
		 		
		 		if(ae.getSource()==dp1)
		 		{
					repaint();
		 			
		 			String nq=(String)ae.getItem();
			 		Statement st2=con.createStatement();
					final String[] cols={"Product Id","Name","Quantity","Rate"};
					final Object rows[][]=new Object[10][8];
    		    	//final String ss[][]=new String[10][8];
    		    	int i=0;
					try{
			String sql="select * from tbl_Bicycle where bicycle_id="+Integer.parseInt(nq)+"";
			 			ResultSet rs1=st2.executeQuery(sql);
			 			//JOptionPane.showMessageDialog(null,"this","this",JOptionPane.INFORMATION_MESSAGE);
			 			while(rs1.next())
			 			{
			 					
			 			
    		    	
    		     	
      		    	String s1=rs1.getString(1);
    		    	String pnm=rs1.getString(2);
			 				 		    	String s3=rs1.getString(6);
    		    	String s4=rs1.getString(7);
    		    	//String s5=rs1.getString(7);
    		    
    		    	rows[i][0]=(Object)s1;
    		    	rows[i][1]=(Object)pnm;
    		    	rows[i][2]=(Object)s3;
    		    	rows[i][3]=(Object)s4;
    		    	//rows[i][4]=(Object)s5;
    		    i++;
					t2.setText(pnm);
    		    	t4.setText(s3);	
							t3.setText(s4);
    		    	}
    		    	
    		    	table1=new JTable(rows,cols);
    		    JSP=new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  	  	 	    		    	
    		    	JSP.setBounds(800,50,500,200);
    		    	JSP.setBackground(Color.white);
    		    	JSP.setVisible(true);
    		    	P2.add(JSP);
							
			
 }catch(Exception e) 
    		       	  {
    		       		System.out.println("error"+e);  
    		       		  
    		       	  }
			 						
		 		}
		 		
		 		
		 		//con.close();
		 		}
		 		catch(ClassNotFoundException e) {System.out.println("driver"+e);}
		 		catch(SQLException e) {System.out.println("query error"+e);}
	

		 	}




public void actionPerformed(ActionEvent ae)
{
	if(ae.getSource()==b1)
	{
		String sql;
		int nqty=Integer.parseInt(t4.getText())+Integer.parseInt(t5.getText());
		try
		 		{
				 Class.forName("com.mysql.cj.jdbc.Driver");	
	 			System.out.print("Connection done");
	 		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
	 			System.out.println("Driver Loaded");
	 			st=con.createStatement();
				sql="update tbl_Bicycle set quantity="+ nqty +",rate="+ Integer.parseInt(t3.getText()) +" where Bicycle_id=" + Integer.parseInt((String)dp1.getSelectedItem()) + "";
				st.executeUpdate(sql);
				JOptionPane.showMessageDialog(null,"Stock updated","Stock",JOptionPane.INFORMATION_MESSAGE);
				con.close();
				//String nq=(String)ae.getItem();
			 		Statement st2=con.createStatement();
					final String[] cols={"Product Id","Type","Name","Quantity","Rate"};
    		    	final Object rows[][]=new Object[10][8];
    		    	//final String ss[][]=new String[10][8];
    		    	int i=0;
					
			 sql="select * from tbl_Bicycle";
			 			ResultSet rs1=st2.executeQuery(sql);
			 			//JOptionPane.showMessageDialog(null,"this","this",JOptionPane.INFORMATION_MESSAGE);
			 			while(rs1.next())
			 			{
			 					
			 			
    		    	
    		     	
      		    	String s1=rs1.getString(1);
    		    	String pnm=rs1.getString(2);
			 				//lstproduct.addItem(pnm);
    		    	String s3=rs1.getString(3);
    		    	String s4=rs1.getString(5);
    		    	String s5=rs1.getString(6);
    		    
    		    	rows[i][0]=(Object)s1;
    		    	rows[i][1]=(Object)pnm;
    		    	rows[i][2]=(Object)s3;
    		    	rows[i][3]=(Object)s4;
    		    	rows[i][4]=(Object)s5;
    		    i++;
    		    	
    		    	}
    		    	
    		    	table1=new JTable(rows,cols);
    		    JSP=new JScrollPane(table1,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
  	  	 	    		    	
    		    	JSP.setBounds(800,50,500,200);
    		    	JSP.setBackground(Color.white);
    		    	JSP.setVisible(true);
    		    	P2.add(JSP);
			
				}
				catch(ClassNotFoundException e) {System.out.println("driver"+e);}
		 		catch(SQLException e) {System.out.println("query error"+e);}
	
	}
	if(ae.getSource()==b2)
		{
			t3.setText("");
			t4.setText("");
			t5.setText("");
			
		}
		if(ae.getSource()==b3)
		{
	hide();
		}
}

public static void main(String args[])
{
stock ob=new stock();
}
}
