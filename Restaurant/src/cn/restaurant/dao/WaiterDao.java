package cn.restaurant.dao;

import cn.restaurant.entity.Waiter;

public interface WaiterDao {
//插入一个服务员
public void waiterInsert(Waiter waiter);
//修改服务员的信息
public void waiterUpdate(Waiter waiter);
//按照编号查询服务员
public Waiter waiterQueryAsNumber(String waiterNumber);
}
