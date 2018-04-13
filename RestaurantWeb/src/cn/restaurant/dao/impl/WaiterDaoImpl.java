package cn.restaurant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

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
	public boolean waiterInsert(Waiter waiter) {
		// TODO Auto-generated method stub
		java.util.Date date=new java.util.Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyymmss");
		String waiterNumber=format.format(date);
		boolean result=false;
		String sql=" "
				+ " insert into waiter values(?,?,?,?,?)";
		Object[] params={waiterNumber,waiter.getWaiterName(),
				waiter.getWaiterPass(),waiter.getWaiterSex(),waiter.getWaiterPhone()};
		try {
			util.executeInsert(sql, params);
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean waiterUpdate(Waiter waiter) {
		// TODO Auto-generated method stub
		int result=0;
		boolean result1=false;
		String sql=" "
				+ " update waiter set waiterPass=?,waiterPhone=? where waiterNumber=?";
		Object[] params={waiter.getWaiterPass(),waiter.getWaiterPhone(),
				waiter.getWaiterNumber()};
		try {
			result=util.executeUpdate(sql, params);
			result1=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result1;
	}

	@Override
	public Waiter waiterQueryAsNumber(String waiterNumber) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Waiter waiter=null;
		String sql=" "
				+ " select * from waiter where waiterNumber=? or waiterName=? ";
		Object[] params={waiterNumber,waiterNumber};
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
	@Override
	public boolean waiterLogin(String waiterNumber, String waiterPass) {
		// TODO Auto-generated method stub
		boolean result=false;
		Waiter waiter=null;
		waiter=waiterQueryAsNumber(waiterNumber);
		if(waiter!=null)
		{
			if( waiter.getWaiterPass().equals(waiterPass))
			{
				result=true;
				return result;
			}
		}
		else
		{
			System.out.println("用户不存在");
			return result;
		}
		System.out.println("密码不正确");
		return result;
	}
	@Override
	public Waiter waiterQueryAsName(String waiterName) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Waiter waiter=null;
		String sql=" "
				+ " select * from waiter where waiterName=?";
		Object[] params={waiterName};
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
