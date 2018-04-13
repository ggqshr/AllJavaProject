package cn.restaurant.dao;



import java.util.List;

import cn.restaurant.entity.Combo;

public interface ComboDao {
//插入一种套餐
public boolean comboInsert(Combo combo);
//修改套餐，可以修改名字，内容，价格
public boolean comboUpdata(Combo combo);
//按照套餐编号查询套餐
public Combo comboQueryAsNumber(String comboNumber);
//按照套餐名字查询套餐
public Combo comboQueryAsName(String comboName);
//模糊查询
public Combo comboQuery(String comboIfm);
//显示全部套餐
public List<Combo> comboQueryAll();
//删除套餐按照套餐编号
public boolean comboDeleteAsNumber(String comboNumber);
}
