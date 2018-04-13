package action;

import java.awt.print.Printable;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import dao.dao;
import mod.user;
public class action {
public static void main(String[] args) throws SQLException {
	user u=new user();
	dao dao=new dao();
	dao.deletedata("1");
	List<user> u1=dao.search();
	for (user user : u1) {
		System.out.println(user);
	}
}
}
