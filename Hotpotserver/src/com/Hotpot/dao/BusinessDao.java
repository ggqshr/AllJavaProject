package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.Business;
import com.example.ggq.restaurant.com.Hotpot.entity.Combo;

public interface BusinessDao {
	//插入订单
	public Object[] insertBusiness(Business business);
	//查询某个客户的订单
	public ArrayList<Business> QueryBusinessAsCustNumber(String custNumber);
	//查询某一天的订单
	public ArrayList<Business> QueryBusinessAsDay(String date);
	//查询某一个月的订单信息
	public void queryBusinessAsMonth(String date);
	//查询评分较高的套餐
	public ArrayList<Combo> queryComboScore();
	//更新评分
	public boolean updateScore(String businessNumber,int score);
}
