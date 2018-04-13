package cn.restaurant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.restaurant.dao.BusinessDao;
import cn.restaurant.entity.Business;
import cn.restaurant.entity.Combo;
import cn.restaurant.entity.Food;
import cn.restaurant.entity.Waiter;
import cn.restaurant.util.BaseDao;

public class BusinessDaoImpl extends BaseDao implements BusinessDao{

	java.util.Date date=null;
	SimpleDateFormat format=null;
	String businessNumber=null;
	@Override
	public Object[] businessInsert(Business business) {
		// TODO Auto-generated method stub
		date=new java.util.Date();
		format=new SimpleDateFormat("yyyyMMddHHmmss");
		businessNumber=format.format(date);
		business.setBusinessNumber(businessNumber);
		String sql=" "
				+ " insert into business values(?,?,?,?,?,?,?,?)";
		Object[] params={
				businessNumber,business.getWaiterNumber(),
				business.getBusinessType(),business.getFoodNumber(),
				business.getComboNumber(),business.getFoodSum(),
				business.getBusinessMoney(),date
		};
		Object[] rObjects={business.getBusinessNumber(),business.getWaiterNumber(),date};
		try {
			util.executeInsert(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rObjects;
	}

	@Override
	public Waiter businessQueryAsOneWaiterNumber(String waiterNumber) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Waiter waiter=null;
		String sql=" "
				+ " select waiter.waiterNumber,waiterName,sum(businessMoney) "
				+ " from business,waiter  "
				+ " where waiter.waiterNumber=business.waiterNumber"
				+ " and business.waiterNumber=?"
				+ " GROUP BY waiter.waiterNumber;";
		Object[] params={waiterNumber};
		try {
			resultSet=util.executeQuery(sql, params);
			while(resultSet.next())
			{
				waiter=new Waiter();
				waiter.setWaiterNumber(resultSet.getString(1));
				waiter.setWaiterName(resultSet.getString(2));
				waiter.setWaiterMoney(resultSet.getFloat(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return waiter;
	}

	@Override
	public List<Waiter> businessQueryAsWaiterNumber() {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		List<Waiter> waiters=new ArrayList<>();
		Waiter waiter=null;
		String sql=" "
				+ " select waiter.waiterNumber,waiterName,sum(businessMoney) "
				+ " from business,waiter  "
				+ " where waiter.waiterNumber=business.waiterNumber"
				+ " GROUP BY waiter.waiterNumber;";
		Object[] params={};
		try {
			resultSet=util.executeQuery(sql, params);
			while(resultSet.next())
			{
				waiter=new Waiter();
				waiter.setWaiterNumber(resultSet.getString(1));
				waiter.setWaiterName(resultSet.getString(2));
				waiter.setWaiterMoney(resultSet.getFloat(3));
				waiters.add(waiter);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return waiters;
	}

	@Override
	public List<Food> businessQueryAsWeek(String week) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		List<Food> foods=new ArrayList<>();
		Food food=null;
		String sql=" "
				+ " select foodName,sum(foodSum),sum(businessMoney)"
				+ " from food,business where week(businessDate)=week(?)"
				+ " and food.foodNumber=business.foodNumber"
				+ " group by foodName; ";
		Object[] params={
				week
		};
		try {
			resultSet=util.executeQuery(sql, params);
			while(resultSet.next())
			{
				food=new Food();
				food.setFoodName(resultSet.getString(1));
				food.setFoodBanlance(resultSet.getInt(2));
				food.setFoodPrice(resultSet.getFloat(3));
				foods.add(food);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}

	@Override
	public int checkSameWeek(String dayOne, String dayTwo) {
		// TODO Auto-generated method stub
		int result=0;
		ResultSet rSet1=null;
		String sql=" "
				+ " select week(?),week(?);";
		Object[] params={dayOne,dayTwo};
		try {
			rSet1=util.executeQuery(sql, params);
			if(rSet1.next())
			{
				if(rSet1.getString(1).equals(rSet1.getString(2)))
				{
					result=Integer.valueOf(rSet1.getString(1));
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	
	@Override
	public List<Food> businessQueryAsMonth(String month) {
		// TODO Auto-generated method stub
		List<Food> foods=new ArrayList<>();
		ResultSet resultSet=null;
		Food food=null;
		String sql=" select foodName,sum(foodSum),sum(businessMoney) "
				+ " from food,business where left(businessDate,7)=? "
				+ " and food.foodNumber=business.foodNumber"
				+ " group by foodName;";
		Object[] params={
				month
		};
		try {
			resultSet=util.executeQuery(sql, params);
			while(resultSet.next())
			{
				food=new Food();
				food.setFoodName(resultSet.getString(1));
				food.setFoodBanlance(resultSet.getInt(2));
				food.setFoodPrice(resultSet.getFloat(3));
				foods.add(food);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}

	@Override
	public List<Food> businessQueryAsDay(String day) {
		// TODO Auto-generated method stub
		List<Food> foods=new ArrayList<>();
		ResultSet resultSet=null;
		Food food=null;
		String sql=" select foodName,sum(foodSum),sum(businessMoney) "
				+ " from food,business where left(businessDate,10)=? "
				+ " and food.foodNumber=business.foodNumber"
				+ " group by foodName;";
		Object[] params={
				day
		};
		try {
			resultSet=util.executeQuery(sql, params);
			while(resultSet.next())
			{
				food=new Food();
				food.setFoodName(resultSet.getString(1));
				food.setFoodBanlance(resultSet.getInt(2));
				food.setFoodPrice(resultSet.getFloat(3));
				foods.add(food);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}

	@Override
	public List<Combo> businessQueryAsCombo() {
		// TODO Auto-generated method stub
		List<Combo> combos=new ArrayList<>();
		Combo combo=null;
		ResultSet resultSet=null;
		String sql=" select comboName,sum(foodSum),sum(businessMoney) "
				+ " from business,combo"
				+ " where business.comboNumber=combo.comboNumber"
				+ " group by comboName;";
		Object[] params={};
		try {
			resultSet=util.executeQuery(sql, params);
			while(resultSet.next())
			{
				combo=new Combo();
				combo.setComboName(resultSet.getString(1));
				combo.setComboSum(resultSet.getInt(2));
				combo.setComboPrice(resultSet.getFloat(3));
				combos.add(combo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return combos;
	}

}
