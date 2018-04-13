package cn.restaurant.dao;

import java.util.List;

import cn.restaurant.entity.Business;
import cn.restaurant.entity.Combo;
import cn.restaurant.entity.Food;
import cn.restaurant.entity.Waiter;

public interface BusinessDao {
//添加一条订单
public Object[] businessInsert(Business business);
//按照所有服务员相关订单
public List<Waiter> businessQueryAsWaiterNumber();
//按照周查询订单
public List<Food> businessQueryAsWeek(int week);
//查询每月的订单
public List<Food> businessQueryAsMonth(String month);
//查询每天的订单
public List<Food> businessQueryAsDay(String day);
//查询套餐的订单
public List<Combo> businessQueryAsCombo();
//查询某个服务员的订单
public Waiter businessQueryAsOneWaiterNumber(String waiterNumber);
//检查两个日期是否在一个周内
public int checkSameWeek(String dayOne,String dayTwo);
}
