package action;

import java.sql.SQLException;

import dao.dbdao;
import model.user;

public class action {

public static void add(user u) throws SQLException
{
	dbdao dbdao=new dbdao();
	dbdao.add(u);
	}

}
