
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
public class CustSearch extends JFrame  implements ActionListener,KeyListener,ItemListener
{
	Container c;
	JPanel P1,P2;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,img1,L8;
	JComboBox dp;
	JTextField t1,t2,t3,t4,t5,t6,t7;
	JButton b1,b2,b3,b4,b5,bshow;
	ImageIcon Limage,L1image,L2image;
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
	JTable table1;
	 JScrollPane JSP;
	int cid;
	String q;
	public CustSearch ()
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

		L2=new JLabel("Customer Seraching Form");
		L2.setFont(f2);
		
		L2.setBounds(280,10,850,150);
		L2.setForeground(Color.white);
		P1.add(L2);

		P2=new JPanel();
		add(P2);
		P2.setBounds(30,200,1300,800);
		P2.setBackground(c1);
		P2.setLayout(null);

		L3=new JLabel("Customer Id");
		L3.setFont(f1);
		
		L3.setBounds(50,40,250,25);
		L3.setForeground(Color.white);
		P2.add(L3);
		
		
		
		dp=new JComboBox();
		
		dp.setBounds(350,40,300,25);
		P2.add(dp);
		//view customer id
		

	     try
			{
	Class.forName("com.mysql.cj.jdbc.Driver");
	System.out.println("Connection driver loaded");
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
	st=con.createStatement();
	q="select * from tbl_customer";
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
		//t1.setBounds(460,40,300,25);
		//P2.add(t1);

		L4=new JLabel("Name");
		L4.setFont(f1);
		
		L4.setBounds(50,90,250,25);
		L4.setForeground(Color.white);
		P2.add(L4);

		t2=new JTextField();
		t2.setFont(f1);
		
		t2.setBounds(350,90,300,25);
		P2.add(t2);	

		L5=new JLabel("Adderss");
		L5.setFont(f1);
		
		L5.setBounds(50,132,250,25);
		L5.setForeground(Color.white);
		P2.add(L5);

		t3=new JTextField();
		t3.setFont(f1);
		
		t3.setBounds(350,132,300,25);
		P2.add(t3);	

		L6=new JLabel("City");
		L6.setFont(f1);
		
		L6.setBounds(50,178,250,25);
		L6.setForeground(Color.white);
		P2.add(L6);

		t4=new JTextField();
		t4.setFont(f1);
		
		t4.setBounds(350,178,300,25);
		P2.add(t4);

		L7=new JLabel("Pincode");
		L7.setFont(f1);
		add(L7);
		L7.setBounds(50,233,250,25);
		L7.setForeground(Color.white);
		P2.add(L7);

		t5=new JTextField();
		t5.setFont(f1);
		
		t5.setBounds(350,233,300,25);
		P2.add(t5);	

		L8=new JLabel("Email Id");
		L8.setFont(f1);
		
		L8.setBounds(50,288,250,25);
		L8.setForeground(Color.white);
		P2.add(L8);

		t6=new JTextField();
		t6.setFont(f1);
	
		t6.setBounds(350,288,300,25);
		P2.add(t6);	

		L8=new JLabel("Mobile No");
		L8.setFont(f1);
	
		L8.setBounds(50,343,250,25);
		L8.setForeground(Color.white);
		P2.add(L8);

		t7=new JTextField();
		t7.setFont(f1);

		t7.setBounds(350,343,300,25);
		P2.add(t7);	
		L2image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/cust.png");
		img1=new JLabel(L2image);
		img1.setBounds(850,0,450,450);
		P2.add(img1);
		
		
		
		bshow=new JButton("Show");
		bshow.setFont(f1);			
		bshow.setBounds(750,40,250,25);
		P2.add(bshow);
		bshow.addActionListener(this);
		b1=new JButton("Add");
		b1.setFont(f1);
		
		b1.setBounds(50,400,140,30);
		//P2.add(b1);
		
		b2=new JButton("Save");
		b2.setFont(f1);
		b2.setBounds(220,400,140,30);
		//P2.add(b2);
		
		b3=new JButton("Clear");
		b3.setFont(f1);
		
		b3.setBounds(50,450,140,30);
		P2.add(b3);
		b4=new JButton("Home");
		b4.setFont(f1);
		
		b4.setBounds(220,450,140,30);
		P2.add(b4);
		b5=new JButton("Update");
		b5.setFont(f1);
		add(b5);
	b5.setBounds(400,450,140,30);
		P2.add(b5);
		//b1.addActionListener(this);
		//b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		//add this item listener
		dp.addItemListener(this);
		
		
		
		
		t7.addKeyListener(this);
        t2.addKeyListener(this);
		Dimension dmax=Toolkit.getDefaultToolkit().getScreenSize();
		setMaximumSize(dmax);
		setExtendedState(JFrame.MAXIMIZED_BOTH);


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
			q="select * from tbl_customer where cid="+ Integer.parseInt(strid)+"";
			rs=st.executeQuery(q);
			while(rs.next())
			{
				
				t2.setText(rs.getString(2));
				t3.setText(rs.getString(3));
				t4.setText(rs.getString(4));
				t5.setText(rs.getString(5));
				t6.setText(rs.getString(6));
				t7.setText(rs.getString(7));
				
			}
			con.close();
			
					}catch(Exception e) {}
				
		
	}
	
	
	
	
	
	
	
	
	public void keyTyped(KeyEvent e){}
	public void keyPressed(KeyEvent e)
	{
		if(e.getSource()==t7)
		{
		 char ch=e.getKeyChar();			
			if(ch==8)
			{
				if(cnt>0)
				{
				cnt--;
				}
			}
		else	
		{
			if(cnt<=9)
			{
				cnt++;
				o=t4.getText()+""+e.getKeyChar();
			}	    
			else if(cnt>=10)
			{	      		
				 JOptionPane.showMessageDialog(null,"phone number not greater than 10","NewUser",JOptionPane.INFORMATION_MESSAGE);
				 t4.setText(o);
			}
		}
		}     
 
		if(e.getSource()==t7)
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
		if(e.getSource()==t2)
		{
			char ch=e.getKeyChar();
			if(ch>=48 && ch<=57)
			{
				JOptionPane.showMessageDialog(null,"Numbers are not allowed","NewUser",JOptionPane.INFORMATION_MESSAGE);
				t2.setText("");
			}
		}
	}
	public void keyReleased(KeyEvent e){}

	public void actionPerformed(ActionEvent ae)
	{
		String id="",name,addr,city,pincode,email,mno;
	
	//save button b2
		if(ae.getSource()==b5)
		{
						id=(String)dp.getSelectedItem();
						name=t2.getText();
						addr=t3.getText();
						city=t4.getText();
						pincode=t5.getText();
						email=t6.getText();
						mno=t7.getText();
						
						
						if(name.equals("")||addr.equals("")||city.equals("")||pincode.equals("")||email.equals("")||mno.equals(""))
						{
							JOptionPane.showMessageDialog(null,"Some Fields Are Empty","NewUser",JOptionPane.INFORMATION_MESSAGE);                                             
						}
						else
						{	
							int l=email.indexOf("@");
							int l1=email.indexOf(".");
							if(l==-1)
							{
								JOptionPane.showMessageDialog(null,"Email address should have '@' ","NewUser",JOptionPane.INFORMATION_MESSAGE);
								t5.setText("");
							}
							else if(l1==-1)
							{
								JOptionPane.showMessageDialog(null,"Email address should have '.' ","NewUser",JOptionPane.INFORMATION_MESSAGE);
								t5.setText("");
							}
									
	else
		{
		     try
				{
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Connection driver loaded");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
		st=con.createStatement();
		q="update tbl_customer set cname='" + name +"', addre='"+addr+"',gender='"+city+"',age='"+pincode+"',email='"+email+"',mno='"+mno+"' where cid="+Integer.parseInt(id)+"";
		st.executeUpdate(q);
		con.close();
		JOptionPane.showMessageDialog(null,"Values are updated","Updation", JOptionPane.INFORMATION_MESSAGE);
		
				}catch(Exception e) {
					System.out.println("Connection driver loaded"+e);							
					
				}
		}
		
		}
		}
		//add new
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
		//home button
		if(ae.getSource()==b4)
		{
			hide();
		}
				if(ae.getSource()==bshow)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
    		    con=DriverManager.getConnection("jdbc:mysql://localhost:3306/green_Bicycle_DB","root","root");
    			st=con.createStatement();
    			String sql="select * from tbl_customer";
    		    rs=st.executeQuery(sql);
    		    	final String[] cols={"Customer Id","Name","Address","Gender","Age","Email","Mobile no"};
    		    	final Object rows[][]=new Object[50][8];
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
CustSearch ob=new CustSearch();
}

}

