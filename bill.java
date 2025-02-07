import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.awt.print.*;

public class bill extends JFrame implements ActionListener
{
	Container c;
	ResultSet rs;
	Connection con;
	Statement st;
	JPanel P1,P2;
	String q;
		JTable table1;
	 JScrollPane JSP;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,lcustname,lcustid;
	JTextField t1,t2,t3,t4,t5,t6,txtname,txtcid;
	JButton b1,b2,b3,b4,b5;
	ImageIcon Limage,L1image,L2image;
	Color c1=new Color(128,0,128);
	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
	Font f1=new Font("Times New Roman",Font.BOLD,25);
	Font f2=new Font("Times New Roman",Font.BOLD,65);
	float amt,gst,finalamt;
	java.util.Date d=new java.util.Date();
	int billid=0;
	
	public bill (String cid,String cname,String total)
	{
		
		gst=Float.parseFloat(total)*0.05f;
		finalamt=Float.parseFloat(total)+gst;
		setSize (1800,1800);
		setVisible(true);
		setLayout(null);
		setFont(f1);
		setBackground(c2);
		P1=new JPanel();
		add(P1);
		P1.setBounds(50,15,1300,200);
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

		L2=new JLabel("Go Green Bicycle System");
		L2.setFont(f2);
		//add(L2);
		L2.setBounds(300,10,850,150);
		L2.setForeground(Color.white);
		P1.add(L2);

		P2=new JPanel();
		
		P2.setBounds(50,230,1300,800);
		P2.setBackground(c1);
		P2.setLayout(null);
		add(P2);
//customer name
		lcustname=new JLabel("Customer Name");
		lcustname.setFont(f1);
		lcustname.setForeground(Color.white);
		//add(L3);
		lcustname.setBounds(100,10,200,25);
		P2.add(lcustname);
		txtname=new JTextField();
		txtname.setFont(f1);
		//add(t1);
		txtname.setBounds(350,10,250,25);
		P2.add(txtname);	
		txtname.setText(cname);
		
		L3=new JLabel("Bill Id");
		L3.setFont(f1);
		L3.setForeground(Color.white);
		//add(L3);
		L3.setBounds(100,50,100,25);
		P2.add(L3);

		t1=new JTextField();
		t1.setFont(f1);
		//add(t1);
		t1.setBounds(350,50,250,25);
		P2.add(t1);	


//custid
		lcustid=new JLabel("Payment  Id");
		lcustid.setFont(f1);
		lcustid.setForeground(Color.white);
		//add(L4);
		lcustid.setBounds(630,10,200,25);
		P2.add(lcustid);

		txtcid=new JTextField();
		txtcid.setFont(f1);
		//add(t2);
		txtcid.setBounds(850,10,250,25);
		P2.add(txtcid);	

		txtcid.setText(cid);

		L4=new JLabel("Date");
		L4.setFont(f1);
		//add(L4);
		L4.setForeground(Color.white);
		L4.setBounds(630,50,120,25);
		P2.add(L4);

		t2=new JTextField(String.valueOf(d));
		t2.setFont(f1);
		//add(t2);
		t2.setBounds(850,50,250,25);
		P2.add(t2);	


		try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
    			st=con.createStatement();
    			String sql="select issueid,cname,amount,paymod,Description from tbl_custpayment where payid="+Integer.parseInt(cid)+"";
    		    rs=st.executeQuery(sql);
    		    	final String[] cols={"IssueId","Name","Amount","paymod","Description"};
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
  	  	 	    		    	
    		    	JSP.setBounds(100,90,700,100);
    		    	JSP.setBackground(Color.white);
    		    	JSP.setVisible(true);
    		    	P2.add(JSP);
			
 }catch(Exception e) 
    		       	  {
    		       		System.out.println("error"+e);  
    		       		  
    		       	  }
		L5=new JLabel("Total");
		L5.setFont(f1);
		//add(L5);
		L5.setForeground(Color.white);
		L5.setBounds(250,220,120,25);
		P2.add(L5);

		t4=new JTextField();
		t4.setFont(f1);
		t4.setText(total);
		//add(t4);
		t4.setBounds(410,220,300,25);
		P2.add(t4);	
		
		L6=new JLabel("GST");
		L6.setFont(f1);
		//add(L6);
		L6.setForeground(Color.white);
		L6.setBounds(250,280,120,25);
		P2.add(L6);

		t5=new JTextField(Float.toString(gst));
		t5.setFont(f1);
		//add(t5);
		t5.setBounds(410,280,300,25);
		P2.add(t5);	

		L7=new JLabel("Amount");
		L7.setFont(f1);
		//add(L7);
		L7.setForeground(Color.white);
		L7.setBounds(250,340,120,25);
		P2.add(L7);

		t6=new JTextField(Float.toString(finalamt));
		t6.setFont(f1);
		//add(t6);
		t6.setBounds(410,340,300,25);
		P2.add(t6);	

		
		b1=new JButton("Save");
		b1.setFont(f1);
		//add(b1);
		b1.setBounds(170,400,140,22);
		P2.add(b1);

		b2=new JButton("Print");
		b2.setFont(f1);
		//add(b2);
		b2.setBounds(370,400,140,22);
		P2.add(b2);

		b3=new JButton("Home");
		b3.setFont(f1);
		//add(b3);
		b3.setBounds(560,400,140,22);
		P2.add(b3);

		b4=new JButton("Home");
		b4.setFont(f1);
		//add(b4);
		b4.setBounds(248,400,140,22);
		//P2.add(b4);


		b5=new JButton("Update");
		b5.setFont(f1);
		//add(b5);
		b5.setBounds(445,400,140,22);
		//P2.add(b5);


//bill id auto generate
try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		
			st=con.createStatement();
			q="select max(billid) from tbl_bill";
			rs=st.executeQuery(q);
			while(rs.next())
			{
				billid=Integer.parseInt(rs.getString(1));
			}
			
			billid++;
			t1.setText(Integer.toString(billid));
			con.close();
			
			}catch(Exception e)
			{
				System.out.println("Error"+e);
			}


b2.addActionListener(this);
b1.addActionListener(this);
b3.addActionListener(this);

	}
	 public void actionPerformed(ActionEvent ae)
	{
	   String s; 
  	 
		
					  	
			try {
	if(ae.getSource()==b2)
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
		if(ae.getSource()==b2)
		{
					JOptionPane.showMessageDialog(null,"Values are saved..Thank you","Saved", JOptionPane.INFORMATION_MESSAGE);

		}
			}catch(Exception e)
			{
				System.out.println("Error"+e);
			}
		}

public static void main(String args[])
{
//bill ob=new bill("101","test","4500");
}
}