package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.OrderQuene;

public interface OrderQueneDao {
	//获取当前队列所有元素
	public ArrayList<OrderQuene> listQuene();
	//获取当前队列未完成元素
	public ArrayList<OrderQuene> listUnfinished();
	//获取当前队列完成元素
	public ArrayList<OrderQuene> listFinished();
	//按照订单编号查询队列订单
	public OrderQuene queryQueneAsBusinessNumber(String businessNumber);
	//按照用户编号查询订单
	public ArrayList<OrderQuene> queryQueneAsCustNumber(String custNumber);
	//进队
	public void addQuene(OrderQuene quene);
	//更新状态
	public void updateQuene(int queneNumber);
}
