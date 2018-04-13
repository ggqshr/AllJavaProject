package cn.restaurant.dao;

import cn.restaurant.entity.Combo;

public interface ComboDao {
//插入一种套餐
public void comboInsert(Combo combo);
//修改套餐，可以修改名字，内容，价格
public void comboUpdata(Combo combo);
//按照套餐编号查询套餐
public Combo comboQueryAsNumber(String comboNumber);
//按照套餐名字查询套餐
public Combo comboQueryAsName(String comboName);
}
