import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
public class login extends JFrame implements ActionListener
{
	Container c;
	JPanel P1,P2;
	JLabel L1,L2,L3,L4,L5,img,L6;
	JTextField t1;
	 JPasswordField t2;
	JButton b1,b2,b3;
	ImageIcon Limage,L1image;
	Color c1=new Color(128,0,128);
	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
	Font f1=new Font("Times New Roman",Font.BOLD,30);
	Font f2=new Font("Times New Roman",Font.BOLD,65);
int cnt=0;
	public login ()
	{
		setSize (1800,1800);
		setVisible(true);
		setLayout(null);
		setFont(f1);

		P1=new JPanel();
		add(P1);
		P1.setBounds(50,50,1300,200);
		//P1.setBackground(Color.white);
		P1.setBackground(c1);
		P1.setLayout(null);
		Limage=new ImageIcon("E://java/jdk1.8/bin/go_green_Bicycle_system/Images/logo1.png");
		L1=new JLabel(Limage);
		L1.setBounds(0,0,200,180);
		//L1.setForeground(Color.white);
		P1.add(L1);

		L1image=new ImageIcon("E://java/jdk1.8/bin/go_green_Bicycle_system/Images/leaf.png");
		img=new JLabel(L1image);
		img.setBounds(1080,0,200,200);
		P1.add(img);

		L2=new JLabel("Go Green Bicycle System");
		L2.setFont(f2);
		
		L2.setBounds(400,10,800,150);
		L2.setForeground(Color.white);
		P1.add(L2);

		P2=new JPanel();
		
		P2.setBounds(50,280,1300,500);
		P2.setBackground(c1);
		P2.setLayout(null);

		L3=new JLabel("Login Form");
		L3.setFont(f1);
		
		L3.setBounds(600,50,200,30);
		L3.setForeground(Color.white);
		P2.add(L3);
	
		L4=new JLabel("User Name");
		L4.setFont(f1);

		L4.setBounds(400,100,300,30);
		L4.setForeground(Color.white);
		P2.add(L4);
	
		t1=new JTextField();
		t1.setFont(f1);

		t1.setBounds(750,100,200,30);
		P2.add(t1);

		L5=new JLabel("Password");
		L5.setFont(f1);
	
		L5.setBounds(400,200,300,30);
		L5.setForeground(Color.white);
		P2.add(L5);
	
		t2=new JPasswordField();
		t2.setFont(f1);
	
		t2.setBounds(750,200,200,30);
		P2.add(t2);

		b1=new JButton("OK");
		b1.setFont(f1);

		b1.setBounds(450,270,150,35);
		P2.add(b1);


		b2=new JButton("Exit");
		b2.setFont(f1);
	
		b2.setBounds(650,270,200,35);
		P2.add(b2);
		
		b3=new JButton("Fogot Password");
		b3.setFont(f1);
	
		b3.setBounds(550,320,300,30);
		b3.setForeground(Color.white);
		b3.setBackground(c1);
		P2.add(b3);
		add(P2);
		
		
b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
	}


 public void actionPerformed(ActionEvent ae)
	{
		String pass="admin";
		String Uname="admin";
		boolean t;
		
		if(ae.getSource()==b1)
		{
			cnt++;
			if(cnt<4)
			{
			String u=t1.getText();
			String p=t2.getText();
			if(pass.equals(p) && Uname.equals(u)==true)
			{
				
				JOptionPane.showMessageDialog(null,"Successful   Login","login sucessful",JOptionPane.INFORMATION_MESSAGE);
				new MainScreen();
				//hide();
			}
			else 
			{
				JOptionPane.showMessageDialog(null,"Username or Password is incorrect. try again!!!","login unsucessful",JOptionPane.INFORMATION_MESSAGE);
				t1.setText("");
				t2.setText("");
			}
			}else 
			{
				JOptionPane.showMessageDialog(null,"3 attempts are over ....System shut down!!!","Invalid user",JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			
			}
		
		}
		if(ae.getSource()==b2)
		{
			System.exit(0);
		}
		if(ae.getSource()==b3)
		{
			
		JOptionPane.showMessageDialog(null,"Please contact adminitrator .On valid Emial id You can reset password","login unsucessful",JOptionPane.INFORMATION_MESSAGE);
	
		}
	}





public static void main(String args[])
{
login ob=new login();
}
}