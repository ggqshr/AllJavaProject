package cn.restaurant.util;

import java.util.Comparator;

import cn.restaurant.entity.Combo;
import cn.restaurant.entity.Food;

public class ComparatorCombo implements Comparator{

	@Override
	public int  compare(Object o1, Object o2) {
		Combo f1=(Combo)o1;
		Combo f2=(Combo)o2;
		Integer  c1=f1.getComboSum();
		Integer  c2=f2.getComboSum();
		int  flag=c2.compareTo(c1);
		return flag;
	}

}
