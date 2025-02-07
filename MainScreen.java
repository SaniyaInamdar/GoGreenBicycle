import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class MainScreen extends JFrame implements ActionListener {
	JMenuBar mb;
	JMenu menq,minventory,msales,msuppay,msearch,mreport,mmaster;
	JMenuItem mastcust,mastemp,mastprod,mastsup,maddenq,maddprod,maddstock,maddcust,maddcustpay,maddsupp,maddsales,maddsupppay,maddempsearch,maddempsalsearch,prodsearch,maddcustsearch,maddsuppsearch,mcustrpt,memprpt,msuprpt,msalrpt,mprodrpt,mregirpt,msalordrpt;

	ImageIcon Limage,L1image,L2image;
	JLabel L1,L2,L3,L4,L5,L6,L7,img,img1,L8,L9;
	JPanel P1,P2;
	Color c1=new Color(128,0,128);

	Color c2=new Color(128,128,128);
	Color c3=new Color(0,128,64);
		Font f1=new Font("Times New Roman",Font.BOLD,25);
	Font f2=new Font("Times New Roman",Font.BOLD,65);

	public MainScreen()
	{
		
		 Dimension dmax=Toolkit.getDefaultToolkit().getScreenSize();
			setMaximumSize(dmax);
			setExtendedState(JFrame.MAXIMIZED_BOTH);
			setSize(1400,800);
		      setLayout(null);
		      setVisible(true);
				setBackground(c1);
		   //image
		   P1=new JPanel();
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
		   
		   add(P1);
		   
		   L2=new JLabel("Welcome to our System");
		L2.setFont(f2);
		//add(L2);
		L2.setBounds(250,10,850,150);
		L2.setForeground(Color.white);
		P1.add(L2);
		   
		   //second panel
		   P2=new JPanel();
		add(P2);
		P2.setBounds(30,200,1300,800);
		P2.setBackground(c1);
		P2.setLayout(null);
		   
		   
		   L2image=new ImageIcon("E://java/jdk1.8/bin//go_green_Bicycle_system/Images/back4.jpg");
		img1=new JLabel(L2image);
		img1.setBounds(50,0,1200,800);
		P2.add(img1);
		   
		  
		   
		   
		   mb = new JMenuBar();
		  
		   //Master Menu
		   mmaster=new JMenu("Master");
		   mastprod=new JMenuItem("New Bicycle");
		   mastcust=new JMenuItem("New Customer");
		   mastsup=new JMenuItem("New Supplier");
		   mastemp=new JMenuItem("New Employee");
		   mmaster.add(mastcust);
		   mmaster.add(mastsup);mmaster.add(mastprod);mmaster.add(mastemp);
		   
			mb.add(mmaster);
		   
		   
		 //Enquiry Menu
		   menq=new JMenu("Enquiry Module");
		   maddenq=new JMenuItem("Add Enquiry");
		   menq.add(maddenq);
		  
		   //Inventory Menu
		   minventory=new JMenu("Plantation");
		   maddprod=new JMenuItem("Add New Plant");
		   minventory.add(maddprod);
		   
		   maddsupp=new JMenuItem("Add New Supplier");
		   //minventory.add(maddsupp);
		   
		   maddstock=new JMenuItem("Update Stock");
		   minventory.add(maddstock);
		   
		   
		   
		 //Sales Modules Menu
			msales=new JMenu("Issue Module");
			maddcust=new JMenuItem("Add Customer");
			//msales.add(maddcust);
		   
			maddsales=new JMenuItem("Genrate Issue Order");
			msales.add(maddsales);
		   
			maddcustpay=new JMenuItem("Return");
			msales.add(maddcustpay);
		   
		//tbl_supplier Payments Menu
			msuppay=new JMenu("Supplier Payments Module");
			maddsupppay=new JMenuItem("Supplier Payments");
			//msuppay.add(maddsupppay);
		   
			//Search Menu
			msearch=new JMenu("Searching Module");
			maddempsearch=new JMenuItem("Employee Search");
			msearch.add(maddempsearch);
		   
			maddempsalsearch=new JMenuItem("Employee Salary Search");
			//msearch.add(maddempsalsearch);
		   
			maddcustsearch=new JMenuItem("Customer Search");
			msearch.add(maddcustsearch);
		   
			maddsuppsearch=new JMenuItem("Supplier Search");
			msearch.add(maddsuppsearch);
			
			
			prodsearch=new JMenuItem("Bicycle Search");
			msearch.add(prodsearch);
			
			
			
			
			
			
			
			
			
		   
		   
		   //Report
		   mreport=new JMenu("Report");
		   mcustrpt=new JMenuItem("Customer");
		   mreport.add(mcustrpt);
		   
		   
		   memprpt=new JMenuItem("Employee");
		   mreport.add(memprpt);
		   
		   msuprpt=new JMenuItem("Supplier");
		   mreport.add(msuprpt);
		   
		   
		   msalrpt=new JMenuItem("Salary");
		  // mreport.add(msalrpt);
		   
		   mprodrpt=new JMenuItem("Bicycle");
		   mreport.add(mprodrpt);
		   
		   mregirpt=new JMenuItem("Enquiry");
		   mreport.add(mregirpt);
		   
		   msalordrpt=new JMenuItem("Issue Order");
		   mreport.add(msalordrpt);
		   
		   
		   
		   
		   
		   
		   
		   
		   mb.add(menq);
		  mb.add(minventory);
		  mb.add(msales);
		  //mb.add(msuppay);
		  mb.add(msearch);
		   mb.add(mreport);
		  
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   maddenq.addActionListener(this);
		   maddprod.addActionListener(this);
		   maddstock.addActionListener(this);
		  // maddsupp.addActionListener(this);
		  // maddcust.addActionListener(this);
		   maddsales.addActionListener(this);
		   maddsupppay.addActionListener(this);
		   maddempsearch.addActionListener(this);
		   //maddempsalsearch.addActionListener(this);
		   maddcustsearch.addActionListener(this);
		   maddsuppsearch.addActionListener(this);
		   prodsearch.addActionListener(this);
		   mastcust.addActionListener(this);
		   mastemp.addActionListener(this);
		   mastprod.addActionListener(this);
		   mastsup.addActionListener(this);
		   
		   
		   
		   maddcustpay.addActionListener(this);
		 	mcustrpt.addActionListener(this);
		   memprpt.addActionListener(this);
		   msuprpt.addActionListener(this);
		   //msalrpt.addActionListener(this);
		   mprodrpt.addActionListener(this);
		   mregirpt.addActionListener(this);
		   msalordrpt.addActionListener(this);
		  
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   setJMenuBar(mb);

		
	}
	
	//@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent ae)
	{
		
		
		

		if(ae.getSource()==maddenq)
		{
			registration ob1=new  registration();
			///hide();
		}
		
		if(ae.getSource()==mastprod)
		{
			BicycleProduct ob1=new  BicycleProduct();
			//hide();
		}
		if(ae.getSource()==mastemp)
		{
			employee1 ob1=new  employee1();
			//hide();
		}
		
		
		if(ae.getSource()==maddstock)
		{
			stock ob1=new  stock();
			//hide();
		}
		
		if(ae.getSource()==mastsup)
		{
			supplier ob1=new  supplier();
			//hide();
		}
		
		

		if(ae.getSource()==mastcust)
		{
			customer ob1=new  customer();
			//hide();
		}
		
		
		if(ae.getSource()==maddsales)
		{
			sales ob1=new  sales();
			//hide();
		}
		

		if(ae.getSource()==maddcustpay)
		{
			CustomerPayment ob1=new CustomerPayment();
			//hide();
		}
		
		
		if(ae.getSource()==maddsupppay)
		{
			//SupplierPayment ob1=new SupplierPayment();
		}
		
		
		if(ae.getSource()==maddempsearch)
		{
			EmployeeSearch ob1=new EmployeeSearch();
		}
		
		
		
		
		if(ae.getSource()==maddcustsearch)
		{
			CustSearch ob1=new CustSearch();
		}

		
		if(ae.getSource()==maddsuppsearch)
		{
			SupplierSearch ob1=new SupplierSearch();
		}
		
		if(ae.getSource()==prodsearch)
		{
			ProdSearch ob1=new ProdSearch();
		}
		if(ae.getSource()==maddprod)
		{
			PlantDetails ob1=new PlantDetails();
		}
		
		
		
		
		
		
		
		
		
		
		//reports
		
		
		
		
		
		if(ae.getSource()==mcustrpt)
		{
			CustomerReport ob1=new  CustomerReport();
			//hide();
		}
		
		if(ae.getSource()==memprpt)
		{
			EmployeeReport ob1=new  EmployeeReport();
			//hide();
		}
		
		if(ae.getSource()==msuprpt)
		{
			SupplierReport ob1=new SupplierReport();
			//hide();
		}
		
		
		if(ae.getSource()==mprodrpt)
		{
			ProductReport ob1=new ProductReport();
			//hide();
		}
		
		if(ae.getSource()==mregirpt)
		{
			RegistrationReport ob1=new RegistrationReport();
			//hide();
		}
		
		if(ae.getSource()==msalordrpt)
		{
			SalesorderReport ob1=new SalesorderReport();
			//hide();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		MainScreen ob =new MainScreen();

	}

}
