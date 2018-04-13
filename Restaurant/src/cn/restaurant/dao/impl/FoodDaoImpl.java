package cn.restaurant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
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
	public void foodInsert(Food food) {
		String sql=" "
				+ " insert into food values(?,?,?,?,?)";
		Object[] params={food.getFoodNumber(),food.getFoodName(),
				food.getFoodType(),food.getFoodPrice(),food.getFoodBanlance()};
		try {
			util.executeInsert(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void foodUpdate(Food food) {
		int result=0;
		String sql=" "
				+ " update food set foodName=?,foodPrice=?,foodBanlance=? where foodNumber=?;";
		Object[] params={food.getFoodName(),food.getFoodPrice(),food.getFoodBanlance(),
				food.getFoodNumber()};
		try {
			result=util.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultCheck(result);
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
}
