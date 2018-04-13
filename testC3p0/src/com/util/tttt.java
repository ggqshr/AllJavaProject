package com.util;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.List;

import javax.activation.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;

public class tttt {

	@Test
	public void test() {
		List<User> users = null;
		QueryRunner qr = new QueryRunner(new ComboPooledDataSource("mySource"));
		String sql = "select * from users ";
		Object[] para = {
				8
		};
		try {
			users = qr.query(sql,new BeanListHandler<>(User.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (Object object : users) {
			System.out.println(object.toString());
		}
	}

}
