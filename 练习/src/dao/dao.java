package dao;

import java.awt.print.Printable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import jdbc.jdbc;
import mod.user;

public class dao {
	static {String sql=" "
			+ " use lianxi;";
			 jdbc  j=new jdbc();
	 Connection con=j.getc();
	 PreparedStatement pt = null;
	try {
		pt = con.prepareStatement(sql);
		pt.execute();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
public void createdatabase() throws SQLException
{
	 jdbc  j=new jdbc();
	 Connection con=j.getc();
	String sql=" "
			+ "create database lianxi;";
	PreparedStatement pt=con.prepareStatement(sql);
	if (pt.execute())
	{
		sql=" "
				+ "use lianxi";
		pt=con.prepareStatement(sql);
		pt.execute();
	}		
}
public void createtable() throws SQLException
{
	jdbc j=new jdbc();
	Connection c=j.getc();
	String sql2=" "
			+ " create table table1 "
			+ "("
			+ " id char(10) key,"
			+ " name char(10) not null,"
			+ " sex char(10) "
			+ ");";
	PreparedStatement pt=c.prepareStatement(sql2);
	pt.execute();
}

public void addnew(user u) throws SQLException
{
    jdbc j=new jdbc();
    Connection con=j.getc();
    String sql=" "
    		+ " insert into table1 values(?,?,?)";
    PreparedStatement pt=con.prepareStatement(sql);
    pt.setString(1, u.getId());
    pt.setString(2, u.getName());
    pt.setString(3, u.getSex());
    pt.execute();
    
	}

public List<user> search() throws SQLException
{
	jdbc j=new jdbc();
	Connection c=j.getc();
	String sql= " "
			+ " select * from table1;";
	PreparedStatement pt=c.prepareStatement(sql);
	ResultSet r=pt.executeQuery();
	List<user> u=new ArrayList<>();
	user u1=null;
	while(r.next())
	{
		u1=new user();
		u1.setId(r.getString("id"));
		u1.setName(r.getString("name"));
		u1.setSex(r.getString("sex"));
//		System.out.println(u1);
		u.add(u1);
	}
	return u;
}
public void deletedata(String id) throws SQLException
{
	jdbc j=new jdbc();
	Connection c=j.getc();
	String sql=" "
			+ " delete from table1"
			+ " where id =?";
	PreparedStatement pt=c.prepareStatement(sql);
	pt.setString(1, id);
	pt.execute();
	}
}
