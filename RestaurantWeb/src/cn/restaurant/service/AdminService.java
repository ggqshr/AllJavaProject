package cn.restaurant.service;

import cn.restaurant.entity.Waiter;

public interface AdminService {
//管理员登陆
public boolean adminLogIn(String adminNumber,String adminPass);
//管理员增加员工
public boolean addWaiter(Waiter waiter);
}
