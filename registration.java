import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class registration extends JFrame implements ActionListener
{
	Container c;
	JPanel P1,P2;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,img1;
	JTextField t1,t2,t3,t4,t5;
	JButton b1,b2,b3,b4,b5,bshow;
	ImageIcon Limage,L1image,L2image;
	Color c1=new Color(128,0,128);
	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
	Font f1=new Font("Times New Roman",Font.BOLD,30);
	Font f2=new Font("Times New Roman",Font.BOLD,65);
		JTable table1;
		JScrollPane JSP;
	public registration ()
	{
		setSize (1800,1800);
		setVisible(true);
		setLayout(null);
		setFont(f1);
		setBackground(c2);
		P1=new JPanel();
		add(P1);
		P1.setBounds(50,0,1300,200);
		//P1.setBackground(Color.cyan);
		P1.setBackground(c1);
		P1.setLayout(null);
		Limage=new ImageIcon("E://java/jdk1.8/bin/go_green_Bicycle_system/Images/logo1.png");
		L1=new JLabel(Limage);
		L1.setBounds(0,0,200,180);
		P1.add(L1);

		L1image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/background4.jpeg");
		img=new JLabel(L1image);
		img.setBounds(1080,0,200,180);
		P1.add(img);

		L2=new JLabel("Enquiry Form");
		L2.setFont(f2);
		add(L2);
		L2.setBounds(390,10,850,150);
		L2.setForeground(Color.white);
		P1.add(L2);

		P2=new JPanel();
		add(P2);
		P2.setBounds(50,200,1300,800);
		P2.setBackground(c1);
		P2.setLayout(null);

		L3=new JLabel("ID");
		L3.setFont(f1);
		add(L3);
		L3.setBounds(50,70,100,25);
		L3.setForeground(Color.white);
		P2.add(L3);

		t1=new JTextField();
		t1.setFont(f1);
		
		t1.setBounds(350,70,250,25);
		P2.add(t1);		

		L4=new JLabel("Name");
		L4.setFont(f1);
		
		L4.setBounds(50,125,120,25);
		L4.setForeground(Color.white);
		P2.add(L4);

		t2=new JTextField();
		t2.setFont(f1);
	
		t2.setBounds(350,125,300,32);
		P2.add(t2);	

		L5=new JLabel("Description");
		L5.setFont(f1);

		L5.setBounds(50,185,150,27);
		L5.setForeground(Color.white);
		P2.add(L5);

		t3=new JTextField();
		t3.setFont(f1);
		
		t3.setBounds(350,180,300,50);
		P2.add(t3);	

		L6=new JLabel("Email");
		L6.setFont(f1);
		
		L6.setBounds(50,260,120,25);
		L6.setForeground(Color.white);
		P2.add(L6);

		t4=new JTextField();
		t4.setFont(f1);
		
		t4.setBounds(350,260,300,32);
		P2.add(t4);	
		
		L7=new JLabel("Contact");
		L7.setFont(f1);

		L7.setBounds(50,313,120,25);
		L7.setForeground(Color.white);
		P2.add(L7);

		t5=new JTextField();
		t5.setFont(f1);
	
		t5.setBounds(350,313,300,32);
				L5.setForeground(Color.white);
		P2.add(t5);	
		
		
bshow=new JButton("Show");
		bshow.setFont(f1);			
		bshow.setBounds(750,40,250,25);
		P2.add(bshow);
		bshow.addActionListener(this);
		b1=new JButton("Add");
		b1.setFont(f1);
		
b1.setBounds(50,400,140,30);

		P2.add(b1);

		b2=new JButton("Save");
		b2.setFont(f1);

		b2.setBounds(220,400,140,30);
		P2.add(b2);

		b3=new JButton("Clear");
		b3.setFont(f1);

		b3.setBounds(390,400,140,30);
		P2.add(b3);
	
		b4=new JButton("Home");
		b4.setFont(f1);
	
		b4.setBounds(560,400,140,30);
		P2.add(b4);


		b5=new JButton("Delete");
		b5.setFont(f1);
		//add(b5);
				b5.setBounds(730,400,140,30);
		//P2.add(b5);

		L2image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/fresh organic1.png");
		img1=new JLabel(L2image);
		img1.setBounds(750,50,450,450);
		P2.add(img1);
b1.addActionListener(this);
b2.addActionListener(this);
b3.addActionListener(this);
b4.addActionListener(this);

	}



public void actionPerformed(ActionEvent ae)
{
String id="",uname,uaddr,uemail,ucont;
ResultSet rs;
Connection con;
Statement st;
int eid;
String q;
//save button b2
	if(ae.getSource()==b2)
	{
			id=t1.getText();
				uname=t2.getText();
					uaddr=t3.getText();
					uemail=t4.getText();
					ucont=t5.getText();
					try
					{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Connection driver loaded");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
	st=con.createStatement();
	q="insert into tbl_enquiry values("+Integer.parseInt(id)+",'" + uname +"','"+uaddr+"','"+uemail+"','"+ucont+"')";
	st.executeUpdate(q);
	con.close();
	JOptionPane.showMessageDialog(null,"Values are saved","Saved", JOptionPane.INFORMATION_MESSAGE);
	
					}catch(Exception e) {	System.out.println("Connection driver loaded");
						
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
		q="select max(enqid) from tbl_enquiry";
		rs=st.executeQuery(q);
		while(rs.next())
		{
			id=rs.getString(1);
		}
		eid=Integer.parseInt(id)+1;
		t1.setText(String.valueOf(eid));
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
	if(ae.getSource()==b4)
	{
	hide();
	}
if(ae.getSource()==bshow)
		{
					  	
			try {
    		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
    			st=con.createStatement();
    			String sql="select * from tbl_Enquiry";
    		    rs=st.executeQuery(sql);
    		    	final String[] cols={"Id","Name","Address","Email","Mobile No"};
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
  	  	 	    		    	
    		    		    	
    		    	JSP.setBounds(750,90,550,300);
    		    	JSP.setBackground(Color.white);
    		    	JSP.setVisible(true);
    		    	P2.add(JSP);
    		        
    		       	  }catch(Exception e) 
    		       	  {
    		       		System.out.println("error"+e);  
    		       		  
    		       	  }
		  	

		}

}

public static void main(String args[])
{
registration ob=new registration();
}
}