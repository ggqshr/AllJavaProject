package com.util;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class ssss {

	@Test
	public void test() {
		QueryRunner qRunner = new QueryRunner(JdbcUtils.getDataSource());
		String sql = "select * from users ";
		List<User> users = null;
		try {
			users = qRunner.query(sql, new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (User user : users) {
			System.out.println(user.toString());
		}
	}

}
