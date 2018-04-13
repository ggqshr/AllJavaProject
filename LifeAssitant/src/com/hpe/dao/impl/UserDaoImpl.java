package com.hpe.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.hpe.dao.IUsers;
import com.hpe.po.User;
import com.hpe.util.BaseDao;

public class UserDaoImpl extends BaseDao implements IUsers {

	java.util.Date date=null;
	SimpleDateFormat format=null;
	@Override
	public void insertIntoUsers(User user) {
		// TODO Auto-generated method stub
		String sql = "insert into users(userName,userPassword,realName,tel,address,login_time) values(?,?,?,?,?,?)";
		date=new java.util.Date();
		Object[] para = {
				user.getRealName(),user.getUserPassword(),
				user.getRealName(),user.getTel(),user.getAddress(),
				date
		};
		try {
			dbUtil.executeInsert(sql, para);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void UpdateUserInf(User user) {
		// TODO Auto-generated method stub
		String sql = "update users set userPassword=? ,tel=?,address=? "
				+  " where userId = ?";
		Object[] paras = {
				user.getUserPassword(),
				user.getTel(),user.getAddress(),user.getUserId()
		};
		try {
			dbUtil.executeUpdate(sql, paras);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public User login(User user) {
		// TODO Auto-generated method stub
		ResultSet rs ;
		User u  = null;
		String sql = "select * from users where userName = ? and userPassword = ?";
		Object[] params = {
				user.getUserName(),user.getUserPassword()
		};
		try {
			rs = dbUtil.executeQuery(sql, params);
			while(rs.next())
			{
				u = new User();
				u.setUserId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setUserPassword(rs.getString(3));
				u.setRealName(rs.getString(4));
				u.setTel(rs.getString(5));
				u.setAddress(rs.getString(6));
				u.setLogin_time(rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public Integer register(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean isExists(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

}
