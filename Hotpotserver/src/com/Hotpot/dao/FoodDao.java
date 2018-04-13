package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.Food;

public interface FoodDao {
	//插入一种食物
	public void insertFood(Food food);
	//更新食物
	public void updateFood(Food f);
	//按照编号查询食物
	public Food queryFoodAsNumber(String foodNumber);
	//按照名字查询食物
	public Food queryFoodAsName(String foodName);
	//按照食物类型查看食物
	public ArrayList<Food> queryFoodAsType(String type);
	//按照食物编号删除食物
	public void deleteFoodAsNumber(String foodNumber);
	//显示所有食物
	public ArrayList<Food> listFood();
}
