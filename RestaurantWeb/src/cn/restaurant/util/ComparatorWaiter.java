package cn.restaurant.util;

import java.util.Comparator;

import cn.restaurant.entity.Combo;
import cn.restaurant.entity.Food;
import cn.restaurant.entity.Waiter;

public class ComparatorWaiter implements Comparator{

	@Override
	public int  compare(Object o1, Object o2) {
		Waiter f1=(Waiter)o1;
		Waiter f2=(Waiter)o2;
		Float  c1=f1.getWaiterMoney();
		Float  c2=f2.getWaiterMoney();
		int  flag=c2.compareTo(c1);
		return flag;
	}

}
