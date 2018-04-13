package cn.restaurant.dao;

import java.util.List;

import cn.restaurant.entity.FoodCheck;

public interface FoodCheckDao {
//插入一条食物订单
public void FoodCheckInsert(FoodCheck foodCheck);
//按照订单号查询
public List<FoodCheck> FoodCheckQueryAsBusinessNumber(String businessNumber);
}
