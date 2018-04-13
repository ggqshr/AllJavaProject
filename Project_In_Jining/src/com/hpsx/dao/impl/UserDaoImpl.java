package com.hpsx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import com.hpsx.dao.UserDao;
import com.hpsx.po.User;
import com.hpsx.util.DbUtil;

public class UserDaoImpl implements UserDao{
	
	PreparedStatement p;
	String sql;
	ResultSet rs;
	int rs1;
	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		User u = null;
		//获取数据库连接
		sql = "select * from users where userName=? and userPassword=?";
		try {
			p = con.prepareStatement(sql);
			p.setString(1, user.getUserName());
			p.setString(2, user.getUserPwd());
			rs = p.executeQuery();
			while(rs.next()){
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setUserPwd(rs.getString(3));
				u.setRealName(rs.getString(4));
				u.setTel(rs.getString(5));
				u.setAddress(rs.getString(6));
				u.setLogin_time(rs.getTimestamp(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, rs);
		}
		return u;
	}

	@Override
	public Integer register(User user) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		int userId=0;
		sql = "insert into users(userName,userPassword,realName,tel,address,login_time) values(?,?,?,?,?,?)";
		try {
			p = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			p.setString(1, user.getUserName());
			p.setString(2, user.getUserPwd());
			p.setString(3, user.getRealName());
			p.setString(4, user.getTel());
			p.setString(5, user.getAddress());
			p.setTimestamp(6, user.getLogin_time());
			p.executeUpdate();
			rs = p.getGeneratedKeys();
			if(rs.next()){
				userId = rs.getInt(1);
			}else{
				System.out.println(false);
			}
//			System.err.println(rs1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, null);
		}
		return userId;
	}

	@Override
	public boolean isExists(String userName) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "select * from users where userName=?";
		try {
			p = con.prepareStatement(sql);
			p.setString(1, userName);
			rs = p.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, rs);
		}
		return false;
	}

	@Override
	public int updateTime(Timestamp time, User user) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "update users set login_time=? where userName=?";
		try {
			p = con.prepareStatement(sql);
			p.setTimestamp(1, time);
			p.setString(2, user.getUserName());
			rs1 = p.executeUpdate();
			if(rs1!=0){
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, null);
		}
		return 0;
	}

	@Override
	public int updateUserInfo(User user) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "update users set tel=? and address=? where userId=?";
		try {
			p = con.prepareStatement(sql);
			p.setString(1, user.getTel());
			p.setString(2, user.getAddress());
			p.setInt(3, user.getUserId());
			rs1 = p.executeUpdate();
			if(rs1!=0){
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, null);
		}
		return 0;
	}

	@Override
	public int updatePassword(int userId, String pwd) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "update users set userPassword=? where userId=?";
		try {
			p = con.prepareStatement(sql);
			p.setString(1, pwd);
			p.setInt(2, userId);
			rs1 = p.executeUpdate();
			if(rs1!=0){
				return 1;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, null);
		}
		return 0;
	}

	
}
