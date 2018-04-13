package cn.restaurant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.restaurant.dao.FoodDao;
import cn.restaurant.entity.Food;
import cn.restaurant.util.BaseDao;

public class FoodDaoImpl extends BaseDao implements FoodDao{

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
	public boolean foodInsert(Food food) {
		boolean result=false;
		java.util.Date date=new java.util.Date();
		SimpleDateFormat format=new SimpleDateFormat("MMdHms");
		String businessNumber="f"+format.format(date);
		String sql=" "
				+ " insert into food values(?,?,?,?,?)";
		Object[] params={businessNumber,food.getFoodName(),
				food.getFoodType(),food.getFoodPrice(),food.getFoodBanlance()};
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
	public boolean foodUpdate(Food food) {
		boolean result=false;
		String sql=" "
				+ " update food set foodName=?,foodPrice=?,foodBanlance=? where foodNumber=?;";
		Object[] params={food.getFoodName(),food.getFoodPrice(),food.getFoodBanlance(),
				food.getFoodNumber()};
		try {
			util.executeUpdate(sql, params);
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Food foodQueryAsNumber(String foodNumber) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Food food=null;
		String sql=" "
				+ " select * from food where foodNumber=?";
		Object[] params={foodNumber};
		try {
			resultSet=util.executeQuery(sql, params);
			if(resultSet.next())
			{
				food=new Food();
				food.setFoodNumber(resultSet.getString(1));
				food.setFoodName(resultSet.getString(2));
				food.setFoodType(resultSet.getString(3));
				food.setFoodPrice(resultSet.getFloat(4));
				food.setFoodBanlance(resultSet.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return food;
	}

	@Override
	public Food foodQueryAsName(String foodName) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Food food=null;
		String sql=" "
				+ " select * from food where foodName=?";
		Object[] params={foodName};
		try {
			resultSet=util.executeQuery(sql, params);
			if(resultSet.next())
			{
				food=new Food();
				food.setFoodNumber(resultSet.getString(1));
				food.setFoodName(resultSet.getString(2));
				food.setFoodType(resultSet.getString(3));
				food.setFoodPrice(resultSet.getFloat(4));
				food.setFoodBanlance(resultSet.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return food;
	}
	@Override
	public List<Food> foodQueryAsType(String foodType) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		List<Food> foods=new ArrayList<>();
		Food food=null;
		String sql=" "
				+ " select * from "+foodType;
		Object[] params={};
		try {
			resultSet=util.executeQuery(sql, params);
			while(resultSet.next())
			{
				food=new Food();
				food.setFoodNumber(resultSet.getString(1));
				food.setFoodName(resultSet.getString(2));
				food.setFoodType(resultSet.getString(3));
				food.setFoodPrice(resultSet.getFloat(4));
				food.setFoodBanlance(resultSet.getInt(5));
				foods.add(food);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return foods;
	}
	@Override
	public Food foodCheckTyep(String foodName,String foodType) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Food food=null;
		String sql=" "
				+ " select * from "+foodType+" where foodName=?";
		Object[] params={foodName};
		try {
			resultSet=util.executeQuery(sql, params);
			if(resultSet.next())
			{
				food=new Food();
				food.setFoodNumber(resultSet.getString(1));
				food.setFoodName(resultSet.getString(2));
				food.setFoodType(resultSet.getString(3));
				food.setFoodPrice(resultSet.getFloat(4));
				food.setFoodBanlance(resultSet.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return food;
	}
	@Override
	public boolean foodDeleteAsNumber(String foodNumber) {
		boolean result=false;
		String sql=" "
				+ " delete from combo where comboNumber=?";
		Object[] params={foodNumber};
		try {
			util.executeInsert(sql, params);
			System.out.println("s1");
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
}
