package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jdbc.jdbc;
import mod.user;
public class dao {
public void add(user u) throws SQLException{
	Connection con=jdbc.get();
	String sql=" " +
			"insert into ifm(id,name,classes,school,sex,phone,email,password,creatdata,updatatime)" +
			" values(?,?,?,?,?,?,?,?,current_date,current_date)";
	PreparedStatement pt=con.prepareStatement(sql);
	pt.setInt(1, u.getId());pt.setString(2, u.getName());
	pt.setString(3, u.getClasses());pt.setString(4, u.getSchool());
	pt.setString(5, u.getSex());pt.setInt(6, u.getPhone());
	pt.setString(7, u.getEmail());pt.setInt(8, u.getPassword());
	pt.execute();}
public void updata(user u) throws SQLException{
	Connection con=jdbc.get();
	String sql=" " +
			" update ifm set name=?,classes=?,school=?,sex=?,phone=?,email=?,password=?" +
			" where id=?";
	PreparedStatement pt=con.prepareStatement(sql);
	pt.setString(1,u.getName());pt.setString(2, u.getClasses());
	pt.setString(3, u.getSchool());pt.setString(4, u.getSex());
	pt.setInt(5, u.getPhone());pt.setString(6, u.getEmail());
	pt.setInt(7, u.getPassword());pt.setInt(8, u.getId());
	pt.execute();}
public void dele(int id) throws SQLException{
	Connection con=jdbc.get();
	String sql=" " +
			" delete from ifm " +"where id =?;";
	PreparedStatement pt=con.prepareStatement(sql);
	pt.setInt(1, id);pt.execute();}
public user search(int i) throws SQLException{
	user user=new user();
	Connection con=jdbc.get();
	String sql=" " +
			" select *from ifm" +
			" where id =?";
	PreparedStatement pt=con.prepareStatement(sql);
	pt.setInt(1, i);
	ResultSet r=pt.executeQuery();
	while (r.next()){
		user.setId(r.getInt("id"));
		user.setName(r.getString("name"));
		user.setClasses(r.getString("classes"));
		user.setSchool(r.getString("school"));
		user.setSex(r.getString("sex"));
		user.setPhone(r.getInt("phone"));
		user.setEmail(r.getString("email"));
		user.setPassword(r.getInt("password"));}return user;}
public user search(String name) throws SQLException{
	user user=new user();
	Connection con=jdbc.get();
	String sql=" " +" select *from ifm" +" where name =?";
	PreparedStatement pt=con.prepareStatement(sql);
	pt.setString(1, name);	ResultSet r=pt.executeQuery();
	while (r.next()){
		user.setId(r.getInt("id"));
		user.setName(r.getString("name"));
		user.setClasses(r.getString("classes"));
		user.setSchool(r.getString("school"));
		user.setSex(r.getString("sex"));
		user.setPhone(r.getInt("phone"));
		user.setEmail(r.getString("email"));
		user.setPassword(r.getInt("password"));}return user;}}

