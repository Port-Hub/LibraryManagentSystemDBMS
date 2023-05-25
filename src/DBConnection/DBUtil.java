package DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

	public DBUtil() {}
		public static Connection getConnection() {
			Connection con =null;
					try
			{
						Class.forName("com.mysql.jdbc.Driver");  
			   			 con=DriverManager.getConnection(  
			   			"jdbc:mysql://localhost:3306/db1","root","Adriel-2004");
			}
					catch(Exception e)
					{
						System.out.println(e);
					}
					return con;
		}


	}


