package com.hpe.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	private static String jdbcDriver; //= "com.mysql.jdbc.Driver"; // ���ݿ���������
	private static String strCon ;//= "jdbc:mysql://localhost:3306/life_assistant?characterEncoding=utf8";
	private static String username ;//= "root";
	private static String password ;//= "123";
	private static DBUtil util = null;
	private static Connection conn = null;
	private PreparedStatement pstm = null;
	private ResultSet rs = null;
	static Properties properties = new Properties();

	 // 读取配置文件
	static InputStream inputStream = DBUtil.class.getResourceAsStream("/db.properties");
	
	//加载属性文件
	static{
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jdbcDriver = properties.getProperty("jdbc.Driver");
		strCon = properties.getProperty("jdbc.url");
		username = properties.getProperty("jdbc.username");
		password = properties.getProperty("jdbc.pwd");
	}
	
	public static DBUtil createInstance() throws ClassNotFoundException {
		if (util == null) {
			util = new DBUtil();
			util.initDB();
		}
		return util;
	}

	public void initDB() throws ClassNotFoundException {
		// 1����������
		Class.forName(jdbcDriver);
	}

	public void connectDB() throws SQLException {
		conn = DriverManager.getConnection(strCon, username, password);
	}

	public static void beginTran() throws SQLException {
		conn.setAutoCommit(false);
	}

	public static void rollBack() throws SQLException {
		conn.rollback();
	}

	public static void commitTran() throws SQLException {
		conn.commit();
	}

	public void closeConn() {
		System.out.println("close ......");
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	private void setPrepareStatementParams(String sql, Object[] params) throws SQLException {
		pstm = conn.prepareStatement(sql);
		if (params != null) {
			for (int i = 0; i < params.length; i++) {
				pstm.setObject(i + 1, params[i]);
			}
		}
	}

	public ResultSet executeQuery(String sql, Object[] params) throws SQLException { // ִ�в�ѯ���ݿ�ӿ�

		util.setPrepareStatementParams(sql, params); // ������
		rs = pstm.executeQuery(); // ִ�в�ѯ����
		return rs;
	}

	public int executeUpdate(String sql, Object[] params) throws SQLException // ִ���޷������ݵ����ݲ�ѯ������ֵ�Ǳ��ı���������ݿ�����
	{
		int result = -1;
		util.setPrepareStatementParams(sql, params); // ������
		pstm.executeUpdate(); // ִ�и���
		result = 1;
		return result;
	}

	public int executeInsert(String sql, Object[] params) throws SQLException {
		int result = -1;
		util.setPrepareStatementParams(sql, params);
		pstm.execute();
		result = 1;
		return result;
	}
}
