package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.jdbc;

import model.user;

public class dbdao {

public void add(user u) throws SQLException
{
	Connection con=jdbc.get();
	String sql=" " +
			" insert into t1 " +
			"(name,password)" +
			" values(?,?)" +
			";";
	PreparedStatement pt=con.prepareStatement(sql);
	pt.setString(1, u.getUsername());
	pt.setString(2, u.getPassword());
	pt.execute();
	
	}
public int search(user u) throws SQLException
{
	Connection con=jdbc.get();
	String sql=" " +
			" select name from t1 " +
			"where name=?;";
	PreparedStatement pt=	con.prepareStatement(sql);
	pt.setString(1, u.getUsername());
	ResultSet r=pt.executeQuery();
	user u1=new user();
	u1.setPassword(r.getString("password"));
	if(u1.getPassword().equals(u.getPassword()))
	return 1;
	else 
		return 0;
	}
public int search(String name) throws SQLException
{
	Connection con=jdbc.get();
	String sql=" " +
			" select * from t1" +
			" where name=?;";
	PreparedStatement  pt=con.prepareStatement(sql);
	pt.setString(1, name);
	ResultSet rt=pt.executeQuery();
	if(rt.next())
		return 1;
	else 
		return 0;
}
}


