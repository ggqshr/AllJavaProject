package cn.restaurant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.restaurant.dao.FoodCheckDao;
import cn.restaurant.entity.FoodCheck;
import cn.restaurant.util.BaseDao;

public class FoodCheckDaoImpl extends BaseDao implements FoodCheckDao {

	@Override
	public void FoodCheckInsert(FoodCheck foodCheck) {
		java.util.Date date=new java.util.Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmmss");
		String sql=" "
				+ " insert into foodcheck(businessNumber,waiterNumber,foodNumber,foodNum,checkPrice,checkDate) values(?,?,?,?,?,?)";
		Object[] params={foodCheck.getBusinessNumber(),
				foodCheck.getWaiterNumber(),foodCheck.getFoodNum(),
				foodCheck.getFoodNum(),foodCheck.getCheckPrice(),
				date};
		try {
			util.executeInsert(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<FoodCheck> FoodCheckQueryAsBusinessNumber(String businessNumber) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		FoodCheck foodCheck=null;
		List<FoodCheck> foodChecks=new ArrayList<>();
		String sql=" "
				+ " select * from foodcheck where businessNumber=?";
		Object[] params={businessNumber};
		
		try {
			resultSet=util.executeQuery(sql, params);
			while(resultSet.next())
			{
				foodCheck=new FoodCheck();
				foodCheck.setCheckNumber(resultSet.getInt(1));
				foodCheck.setBusinessNumber(resultSet.getString(2));
				foodCheck.setWaiterNumber(resultSet.getString(3));
				foodCheck.setFoodNumber(resultSet.getString(4));
				foodCheck.setFoodNum(resultSet.getInt(5));
				foodCheck.setCheckPrice(resultSet.getFloat(6));
				foodCheck.setCheckDate(resultSet.getString(7));
				foodChecks.add(foodCheck);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foodChecks;
		
	}

}
