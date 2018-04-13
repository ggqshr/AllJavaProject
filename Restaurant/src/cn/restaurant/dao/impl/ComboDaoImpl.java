package cn.restaurant.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

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
	public void comboInsert(Combo combo) {
		String sql=" "
				+ " insert into combo values(?,?,?,?,?,?,?,?)";
		Object[] params={
				combo.getComboNumber(),combo.getComboName(),
				combo.getNoodlesNum(),combo.getMeatNum(),
				combo.getVegetableNum(),combo.getSoupNum(),
				combo.getComboPrice()
		};
		
		try {
			util.executeInsert(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void comboUpdata(Combo combo) {
		// TODO Auto-generated method stub
		int result=0;
		String sql=" "
				+ " update combo set comboName=?,noodlesNum=?,"
				+ " meatNum=?,vegetableNum=?,soupNum=?,"
				+ " comboPrice=?";
		Object[] params={combo.getComboName(),combo.getNoodlesNum(),
				combo.getMeatNum(),combo.getVegetableNum(),combo.getSoupNum(),
				combo.getComboPrice()};
		
		try {
			result=util.executeUpdate(sql, params);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultCheck(result);
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

}
