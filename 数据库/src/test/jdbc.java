package test;


import java.sql.*;

public class jdbc {

   private static  String URL="jdbc:mysql://localhost/ggq?characterEncoding=utf8";
   private static String USER="root";
   private static String PASSWORD="123";
  static  Connection con = null;
   static {	   
	   try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		try {
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
   }
   public static Connection get()
   {
	   return con;
   }
/*	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection con=DriverManager.getConnection(URL, USER, PASSWORD);
	    Statement st= con.createStatement();
	    ResultSet t1= st.executeQuery("select id,name from t1");
	    while (t1.next())
	    {
	    	System.out.println(t1.getInt("id")+","+t1.getString("name"));
	    }
	}*/

}
