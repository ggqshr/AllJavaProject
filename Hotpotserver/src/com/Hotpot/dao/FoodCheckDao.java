package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.FoodCheck;

public interface FoodCheckDao {
		//����һ��ʳ�ﶩ��
		public void insertFoodCheck(FoodCheck foodCheck);
		//���ն����Ų�ѯ
		public ArrayList<FoodCheck> queryFoodCheckAsBusinessNumber(String businessNumber);
		//���տͻ���Ų�ѯ
		public ArrayList<FoodCheck> queryFoodCheckAsCustomerNumber(String customerNumber);
}
