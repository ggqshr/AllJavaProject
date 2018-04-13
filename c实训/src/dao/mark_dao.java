package dao;
import java.sql.*;
import jdbc.jdbc;
import mod.mark;
import mod.user;
public class mark_dao {
	public void add(mark u) throws SQLException{
		Connection con=jdbc.get();
		String sql=" " +
				"insert into mark(id,name,math,english,physic,linemath,language_c,language_ch,java)" +
				" values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement pt=con.prepareStatement(sql);
		pt.setInt(1, u.getId());
		pt.setString(2, u.getName());
		pt.setInt(3, u.getMath());
		pt.setInt(4, u.getEnglish());
		pt.setInt(5, u.getLinemath());
		pt.setInt(6, u.getLanguage_c());
		pt.setInt(7, u.getLanguage_ch());
		pt.setInt(8, u.getJava());
		pt.setInt(9, u.getPhysic());
		pt.execute();}
	public void updata(mark m) throws SQLException{
		Connection con=jdbc.get();
		String sql=" " +
				" update mark set math=?,english=?,physic=?,linemath=?,language_c=?,language_ch=?,java=?" +
				" where id=?";
		PreparedStatement  pt=con.prepareStatement(sql);
		pt.setInt(1,m.getMath());pt.setInt(2, m.getEnglish());
		pt.setInt(3, m.getPhysic());pt.setInt(4, m.getLinemath());
		pt.setInt(5, m.getLanguage_c());pt.setInt(6, m.getLanguage_ch());
		pt.setInt(7, m.getJava());pt.setInt(8, m.getId());
		pt.execute();}
	public void dele(int id) throws SQLException{
		Connection con=jdbc.get();
		String sql=" " +
				" delete from mark " +
				"where id =?;";
		PreparedStatement pt=con.prepareStatement(sql);
		pt.setInt(1, id);
		pt.execute();}
	public mark search(int i) throws SQLException{
		mark user=new mark();
		Connection con=jdbc.get();
		String sql=" " +
				" select *from mark" +
				" where id =?";
		PreparedStatement pt=con.prepareStatement(sql);
		pt.setInt(1, i);
		ResultSet r=pt.executeQuery();
		while (r.next()){
			user.setId(r.getInt("id"));
			user.setName(r.getString("name"));
			user.setMath(r.getInt("math"));
			user.setEnglish(r.getInt("english"));
			user.setLinemath(r.getInt("linemath"));
			user.setLanguage_c(r.getInt("language_c"));
			user.setLanguage_ch(r.getInt("language_ch"));
			user.setJava(r.getInt("java"));
			user.setPhysic(r.getInt("physic"));}return user;}}




