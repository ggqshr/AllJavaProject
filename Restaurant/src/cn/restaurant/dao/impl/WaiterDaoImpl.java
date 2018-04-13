package cn.restaurant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import cn.restaurant.dao.WaiterDao;
import cn.restaurant.entity.Waiter;
import cn.restaurant.util.BaseDao;

public class WaiterDaoImpl extends BaseDao implements WaiterDao{

	public void ResultCheck(int x)
	{
		if(x==-1)
		{
			System.out.println(" Faied");
		}
		else
		{
			System.out.println(" Success");
		}
	}
	@Override
	public void waiterInsert(Waiter waiter) {
		// TODO Auto-generated method stub
		String sql=" "
				+ " insert into waiter values(?,?,?,?,?)";
		Object[] params={waiter.getWaiterNumber(),waiter.getWaiterName(),
				waiter.getWaiterPass(),waiter.getWaiterSex(),waiter.getWaiterPhone()};
		try {
			util.executeInsert(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void waiterUpdate(Waiter waiter) {
		// TODO Auto-generated method stub
		int result=0;
		String sql=" "
				+ " update waiter set waiterPass=?,waiterPhone=? where waiterNumber=?";
		Object[] params={waiter.getWaiterPass(),waiter.getWaiterPhone(),
				waiter.getWaiterNumber()};
		try {
			result=util.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultCheck(result);
	}

	@Override
	public Waiter waiterQueryAsNumber(String waiterNumber) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Waiter waiter=null;
		String sql=" "
				+ " select * from waiter where waiterNumber=?";
		Object[] params={waiterNumber};
		try {
			resultSet=util.executeQuery(sql, params);
			if(resultSet.next())
			{
				waiter=new Waiter();
				waiter.setWaiterNumber(resultSet.getString(1));
				waiter.setWaiterName(resultSet.getString(2));
				waiter.setWaiterPass(resultSet.getString(3));
				waiter.setWaiterSex(resultSet.getString(4));
				waiter.setWaiterPhone(resultSet.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return waiter;
	}

}
