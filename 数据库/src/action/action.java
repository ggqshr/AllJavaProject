package action;

import java.sql.SQLException;
import java.util.List;

import javax.swing.text.GapContent;

import model.user;
import DAO.DBDAO;


public class action {
 
public static void main(String[] args) throws SQLException {
	DBDAO d=new DBDAO();
	List<user> list= d.search();
	for (user user : list) {
		System.out.println(list.toString());
	}
}}
  

