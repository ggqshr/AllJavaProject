package com.Hotpot.util;

import java.util.Comparator;

import com.example.ggq.restaurant.com.Hotpot.entity.Business;


@SuppressWarnings("rawtypes")
public class ComparatorBusinessCombo implements Comparator{

	@Override
	public int  compare(Object o1, Object o2) {
		Business f1=(Business)o1;
		Business f2=(Business)o2;
		Integer  c1=f1.getBusinessScore();
		Integer  c2=f2.getBusinessScore();
		int  flag=c2.compareTo(c1);
		return flag;
	}

}
