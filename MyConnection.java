import java.sql.*;
public class MyConnection {
	Connection con;
	Statement st;

	void getConnect()
	{
						
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Connection driver loaded");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","root");
			st=con.createStatement();
			
		}catch(Exception e)
		{
			System.out.println("error"+e);
		}
	}

	

}
