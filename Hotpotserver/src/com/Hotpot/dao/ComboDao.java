package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.Combo;

public interface ComboDao {
	//增加套餐
	public void insertCombo(Combo combo);
	//更新套餐 
	public void updateCombo(Combo combo);
	//删除套餐
	public void deleteCombo(String comborNumber);
	//显示全部套餐
	public ArrayList<Combo> listCombo();
	//按照套餐标号查询套餐
	public Combo queryComboAsNumber(String comboNumber);
	//模糊查询套餐
	public Combo queryComboAsInf(String inf);
}
