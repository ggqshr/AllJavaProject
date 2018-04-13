package db;
import java.sql.*;
public class jdbc {

static String URL="jdbc:mysql://localhost/ggq1?characterEncoding=utf8";
static String USER="root";
static String PASSWORD="123";
	static Connection con=null;
	static {
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
	public static Connection get()
	{
		return con;
	}

}
