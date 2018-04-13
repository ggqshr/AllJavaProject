package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {
		private static String URL="jdbc:mysql://localhost/student?characterEncoding=utf8";
		private  static String USER="root";
		private  static String PASSWORD="123";
	   static Connection con=null;
static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}
public static Connection get()
{
	return con;}
}
