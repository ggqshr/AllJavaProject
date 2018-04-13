package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.Food;

public interface FoodDao {
	//����һ��ʳ��
	public void insertFood(Food food);
	//����ʳ��
	public void updateFood(Food f);
	//���ձ�Ų�ѯʳ��
	public Food queryFoodAsNumber(String foodNumber);
	//�������ֲ�ѯʳ��
	public Food queryFoodAsName(String foodName);
	//����ʳ�����Ͳ鿴ʳ��
	public ArrayList<Food> queryFoodAsType(String type);
	//����ʳ����ɾ��ʳ��
	public void deleteFoodAsNumber(String foodNumber);
	//��ʾ����ʳ��
	public ArrayList<Food> listFood();
}
