package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.user;

import test.jdbc;

public class DBDAO {
  public void add(user u) throws SQLException
  {
	  jdbc j=new jdbc();
	  Connection con=j.get();
	  String sql=" " +
	  		"insert into t1" +
	  		"(name,creatdata,updata" +
	  		")" +
	  		"values(?,current_date(),current_date())" +
	  		";";
	  PreparedStatement pt=con.prepareStatement(sql);
	  pt.setString(1, u.getName());
	  pt.execute();
  }
  public List<user> search() throws SQLException
  {
	  jdbc j=new jdbc();
	  Connection con=j.get();
	  Statement st= con.createStatement();
	  ResultSet r1= st.executeQuery("select id,name from t1");
	  List<user> u=new ArrayList<user>();
	  user u1=null;
	  while (r1.next())
	  {
		  u1=new user ();
		  u1.setName(r1.getString("name"));
		  u1.setId(r1.getInt("id"));
		  u.add(u1);
	  }
	  return u;
	  
  }
  public List<user> search(int id) throws SQLException
  {
	  jdbc j=new jdbc();
	  Connection con=j.get();
	 String sql=" " +
	 		" select *from t1" +
	 		" where id=?";
	 PreparedStatement pt= con.prepareStatement(sql);
	 pt.setInt(1, id);
	 ResultSet r1=pt.executeQuery();
	 
	  List<user> u=new ArrayList<user>();
	  user u1=null;
	  while (r1.next())
	  {
		  u1=new user ();
		  u1.setName(r1.getString("name"));
		  u1.setId(r1.getInt("id"));
		  u.add(u1);
	  }
	  return u;
	  
  }
	public void dele (int id) throws SQLException
	{
		jdbc j=new jdbc();
		Connection con=j.get();
		String sql=" " +
				" delete from t1" +
				" where id=?";
		PreparedStatement pt=con.prepareStatement(sql);
		pt.setInt(1, id);
		pt.execute();
	}
	public user get (int id) throws SQLException
	{
		user u=null;
		jdbc j=new jdbc();
	Connection con=j.get();
	String sql=" " +
			" select * from t1" +
			" where id=?";
	PreparedStatement pt=con.prepareStatement(sql);
	pt.setInt(1, id);
	ResultSet  rt=pt.executeQuery();
	while (rt.next())
	{
		u=new user();
		u.setId(rt.getInt("id"));
		u.setName(rt.getString("name"));
		u.setCreatdataDate(rt.getDate("creatdata"));
		u.setUpdataDate(rt.getDate("updata"));
		
		
	}
		return u;
		
	}
	
}
