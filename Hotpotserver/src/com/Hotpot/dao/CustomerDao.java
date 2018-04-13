package com.Hotpot.dao;

import com.example.ggq.restaurant.com.Hotpot.entity.Customer;

public interface CustomerDao {
	//插入一个用户
	public void insertCustomer(Customer customer);
	//更新一个用户
	public void updateCustomer(Customer customer);
	//按照账号查询用户
	public Customer queryCustomerAsNumber(String customerNumber);
	//按照姓名查询用户
	public Customer quertCustomerAsName(String customerName);
	public void updateCustomerPass(Customer customer);
}
