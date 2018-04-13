package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {

	private static  String URL="jdbc:mysql://localhost/ggq?characterEncoding=utf8";
	   private static String USER="root";
	   private static String PASSWORD="123";
	   static Connection con=null;
	   static{
		   try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   try {
			con=DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		   
	   }
	   public static Connection getc()
	   {
		   return con;
	   }
	   
}
