package util;
import java.lang.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	public static Connection getConnection()throws Exception{
		Connection conn =null;
		try{
			Class.forName("com.mysql.jdbc.Driver");//这个地方的驱动类找不到，已经在build里面引用了mysql.jdbc这个数据包
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/lesson?" +
					"useUnicode=true&characterEncoding=utf8",
					"root","123");
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
		return conn;
	}

	public static void close(Connection conn) {
		if(conn !=null){
			try{
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		}
	}
	public static void main(String[] args) throws Exception{
		System.out.println(getConnection());
	}
}
