package cn.restaurant.dao;

import java.util.List;

import cn.restaurant.entity.Food;

public interface FoodDao {
//插入一种食物
public boolean foodInsert(Food food);
//修改食物的名字，价格，剩余量
public boolean foodUpdate(Food food);
//按照编号查询食物
public Food foodQueryAsNumber(String foodNumber);
//按照名字查询食物
public Food foodQueryAsName(String foodName);
//按照食物类型查看食物
public List<Food> foodQueryAsType(String foodType);
//查询某种食物是否属于某类食物
public Food foodCheckTyep(String foodName,String foodType);
//删除食物按照食物编号
public boolean foodDeleteAsNumber(String foodNumber);
}
