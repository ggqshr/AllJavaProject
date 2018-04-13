package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.FoodCheck;

public interface FoodCheckDao {
		//插入一条食物订单
		public void insertFoodCheck(FoodCheck foodCheck);
		//按照订单号查询
		public ArrayList<FoodCheck> queryFoodCheckAsBusinessNumber(String businessNumber);
		//按照客户编号查询
		public ArrayList<FoodCheck> queryFoodCheckAsCustomerNumber(String customerNumber);
}
