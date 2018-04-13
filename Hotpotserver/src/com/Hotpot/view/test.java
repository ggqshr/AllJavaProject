package com.Hotpot.view;

import java.util.ArrayList;

import com.Hotpot.dao.DrunkDao;
import com.Hotpot.dao.OrderQueneDao;
import com.Hotpot.dao.impl.DrunkDaoImpl;
import com.Hotpot.dao.impl.OrderQueneDaoImpl;
import com.example.ggq.restaurant.com.Hotpot.entity.Drunk;
import com.example.ggq.restaurant.com.Hotpot.entity.OrderQuene;

public class test {
public static void main(String[] args) {
//	OrderQueneDao dao = new OrderQueneDaoImpl();
//	OrderQuene quene = new OrderQuene();
//	ArrayList<OrderQuene> quene = new ArrayList<>();
//	quene.setBusinessNumber("!!!");
//	quene.setCustomerNumber("@@");
//	dao.updateQuene(1);
//	quene = dao.queryQueneAsBusinessNumber("!!!");
//	System.out.println(quene.getEndDate());
//	for (OrderQuene orderQuene : quene) {
//		System.out.println(orderQuene.getOrderDate());
//	}
	DrunkDao dao = new DrunkDaoImpl();
	ArrayList<Drunk> d = dao.queryAllDrunk();
	System.out.println(d.size());
}
}
