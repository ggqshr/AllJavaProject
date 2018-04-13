package com.hpsx.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;


public class DbUtil {
	
	public static Connection getc(){
		
		Connection con = null;
		try {
			InputStream in = DbUtil.class.getResourceAsStream("/db.properties");
			Properties  p = new Properties();
			p.load(in);
			String name = p.getProperty("driver");
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String pwd = p.getProperty("password");
				Class.forName(name);
				con = DriverManager.getConnection(url,
						user, pwd);
		} catch (SQLException | IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public static void DbClose(Connection con,PreparedStatement p,ResultSet r){
		
			try {
				if(r!=null){
				r.close();
				}
				if(p!=null){
					p.close();
				}
				if(con!=null){
					con.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
