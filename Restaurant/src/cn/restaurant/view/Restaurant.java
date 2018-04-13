package cn.restaurant.view;

import java.util.Iterator;
import java.util.List;

import cn.restaurant.dao.impl.BusinessDaoImpl;
import cn.restaurant.dao.impl.FoodDaoImpl;
import cn.restaurant.entity.Food;
import cn.restaurant.entity.Waiter;

public class Restaurant {
public static void main(String[] args) {
	BusinessDaoImpl businessDaoImpl=new BusinessDaoImpl();
	FoodDaoImpl foodDaoImpl=new FoodDaoImpl();
	List<Food> foods=null;
	foods=foodDaoImpl.foodQueryAsType("vegetable");
	for (Food food : foods) {
		System.out.println(food.toString());
	}
}
}
