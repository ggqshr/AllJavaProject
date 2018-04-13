package cn.restaurant.dao;

import cn.restaurant.entity.Waiter;

public interface WaiterDao {
//插入一个服务员
public boolean waiterInsert(Waiter waiter);
//修改服务员的信息
public boolean waiterUpdate(Waiter waiter);
//按照编号查询服务员
public Waiter waiterQueryAsNumber(String waiterNumber);
//按照姓名查询服务员
public Waiter waiterQueryAsName(String waiterName);
//服务员登陆
public boolean waiterLogin(String waiterNumber,String waiterPass);
}
