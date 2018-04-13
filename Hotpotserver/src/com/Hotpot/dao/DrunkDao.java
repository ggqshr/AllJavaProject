package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.Drunk;

public interface DrunkDao {
//插入一个饮料
	public void insertDrunk(Drunk drunk);
	//更新一个饮料
	public void updateDrunk(Drunk drunk);
	//按照编号查询一个饮料
	public Drunk queryDrunkAsNumber(String drunkNumber);
	//按照姓名查询一个饮料
	public Drunk queryDrunkAsName(String drunkName);
	//查询所有饮料
	public ArrayList<Drunk> queryAllDrunk();
}
