package cn.restaurant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import cn.restaurant.dao.ComboDao;
import cn.restaurant.entity.Combo;
import cn.restaurant.util.BaseDao;

public class ComboDaoImpl extends BaseDao implements ComboDao{
	public void ResultCheck(int x)
	{
		if(x==-1)
		{
			System.out.println(" Faied");
		}
		else
		{
			System.out.println(" Success");
		}
	}
	@Override
	public boolean comboInsert(Combo combo) {
		boolean result=false;
		java.util.Date date=new java.util.Date();
		SimpleDateFormat format=new SimpleDateFormat("MMdHms");
		String businessNumber="c"+format.format(date);
		String sql=" "
				+ " insert into combo values(?,?,?,?,?,?,?)";
		Object[] params={
				businessNumber,combo.getComboName(),
				combo.getNoodlesNum(),combo.getMeatNum(),
				combo.getVegetableNum(),combo.getSoupNum(),
				combo.getComboPrice()
		};
		
		try {
			util.executeInsert(sql, params);
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public boolean comboUpdata(Combo combo) {
		// TODO Auto-generated method stub
		boolean result=false;
		String sql=" "
				+ " update combo set comboName=?,noodlesNum=?,"
				+ " meatNum=?,vegetableNum=?,soupNum=?,"
				+ " comboPrice=?"
				+ " where comboNumber=?";
		Object[] params={combo.getComboName(),combo.getNoodlesNum(),
				combo.getMeatNum(),combo.getVegetableNum(),combo.getSoupNum(),
				combo.getComboPrice(),combo.getComboNumber()};
		
		try {
			util.executeUpdate(sql, params);
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Combo comboQueryAsNumber(String comboNumber) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Combo combo=null;
		String sql=" "
				+ " select * from combo where comboNumber=?";
		Object[] params={comboNumber};
		
		try {
			resultSet=util.executeQuery(sql, params);
			if(resultSet.next())
			{
				combo=new Combo();
				combo.setComboNumber(resultSet.getString(1));
				combo.setComboName(resultSet.getString(2));
				combo.setNoodlesNum(resultSet.getInt(3));
				combo.setMeatNum(resultSet.getInt(4));
				combo.setVegetableNum(resultSet.getInt(5));
				combo.setSoupNum(resultSet.getInt(6));
				combo.setComboPrice(resultSet.getFloat(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return combo;
		
	}

	@Override
	public Combo comboQueryAsName(String comboName) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Combo combo=null;
		String sql=" "
				+ " select * from combo where comboName=?";
		Object[] params={comboName};
		
		try {
			resultSet=util.executeQuery(sql, params);
			if(resultSet.next())
			{
				combo=new Combo();
				combo.setComboNumber(resultSet.getString(1));
				combo.setComboName(resultSet.getString(2));
				combo.setNoodlesNum(resultSet.getInt(3));
				combo.setMeatNum(resultSet.getInt(4));
				combo.setVegetableNum(resultSet.getInt(5));
				combo.setSoupNum(resultSet.getInt(6));
				combo.setComboPrice(resultSet.getFloat(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return combo;
	}
	@Override
	public Combo comboQuery(String comboIfm) {
		// TODO Auto-generated method stub
		ResultSet resultSet=null;
		Combo combo=null;
		String sql=" "
				+ " select * from combo where comboName=? or comboNumber=?";
		Object[] params={comboIfm,comboIfm};
		
		try {
			resultSet=util.executeQuery(sql, params);
			if(resultSet.next())
			{
				combo=new Combo();
				combo.setComboNumber(resultSet.getString(1));
				combo.setComboName(resultSet.getString(2));
				combo.setNoodlesNum(resultSet.getInt(3));
				combo.setMeatNum(resultSet.getInt(4));
				combo.setVegetableNum(resultSet.getInt(5));
				combo.setSoupNum(resultSet.getInt(6));
				combo.setComboPrice(resultSet.getFloat(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return combo;
	}
	@Override
	public List<Combo> comboQueryAll() {
		// TODO Auto-generated method stub
		List<Combo> combos=new ArrayList<>();
		ResultSet resultSet=null;
		Combo combo=null;
		String sql=" select * from combo ";
		Object[] params={};
		try {
			resultSet=util.executeQuery(sql, params);
			while(resultSet.next())
			{
				combo=new Combo();
				combo.setComboNumber(resultSet.getString(1));
				combo.setComboName(resultSet.getString(2));
				combo.setNoodlesNum(resultSet.getInt(3));
				combo.setMeatNum(resultSet.getInt(4));
				combo.setVegetableNum(resultSet.getInt(5));
				combo.setSoupNum(resultSet.getInt(6));
				combo.setComboPrice(resultSet.getFloat(7));
				combos.add(combo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return combos;
	}
	@Override
	public boolean comboDeleteAsNumber(String comboNumber) {
		// TODO Auto-generated method stub
		boolean result=false;
		String sql=" "
				+ " delete from combo where comboNumber=?";
		Object[] params={
				comboNumber
		};
		
		try {
			util.executeInsert(sql, params);
			result=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
