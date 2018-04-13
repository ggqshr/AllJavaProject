package cn.restaurant.util;

import java.util.Comparator;

import cn.restaurant.entity.Food;

public class ComparatorFood implements Comparator{

	@Override
	public int  compare(Object o1, Object o2) {
		Food f1=(Food)o1;
		Food f2=(Food)o2;
		Integer  c1=f1.getFoodBanlance();
		Integer  c2=f2.getFoodBanlance();
		int  flag=c2.compareTo(c1);
		return flag;
	}

}
