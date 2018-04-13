package com.hpe.util;

import java.sql.SQLException;


public class BaseDao {
	public DBUtil dbUtil = null;
	
	public BaseDao(){
		try {
			dbUtil = DBUtil.createInstance();
			dbUtil.connectDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	protected void finalize() {
		//util.closeConn();
		try {
			super.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
