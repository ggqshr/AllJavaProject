package Factory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.Business;
import com.example.ggq.restaurant.com.Hotpot.entity.Combo;
import com.example.ggq.restaurant.com.Hotpot.entity.OrderQuene;

public class GetInf {
	public ArrayList<Business> getBusiness(ResultSet r, Business business,ArrayList<Business> businesses) throws SQLException
	{
		while(r.next())
		{
			business = new Business();
			business.setBusinessNumber(r.getString("businessNumber"));
			business.setCustomerNumber(r.getString("customerNumber"));
			business.setBusinessType(r.getString("businessType"));
			business.setFoodNumber(r.getString("foodNumber"));
			business.setComboNumber(r.getString("comboNumber"));
			business.setFoodSum(r.getInt("foodSum"));
			business.setBusinessMoney(r.getFloat("businessMoney"));
			business.setBusinessDate(r.getString("businessDate"));
			business.setBusinessScore(r.getInt("businessScore"));
			business.setComboName(r.getString("comboName"));
			business.setComboPhoto(r.getString("comboPhoto"));
			businesses.add(business);
		}
		return businesses;
	}
	public ArrayList<Combo> getCombo(ResultSet r, Combo b,ArrayList<Combo> bArrayList) throws SQLException
	{
		while(r.next())
		{
			b = new Combo();
			b.setComboNumber(r.getString("comboNumber"));
			b.setComboName(r.getString("comboName"));
			b.setComboPhoto(r.getString("comboPhoto"));
			b.setHotpotSoup(r.getString("hotpotSoup"));
			b.setNoodlesNum(r.getInt("noodlesNum"));
			b.setMeatNum(r.getInt("meatNum"));
			b.setVegetableNum(r.getInt("vegetableNum"));
			b.setSoupNum(r.getInt("soupNum"));
			b.setComboPrice(r.getFloat("comboPrice"));
			b.setComboScore(r.getFloat("comboScore"));
			bArrayList.add(b);
		}
		return bArrayList;
	}
	public ArrayList<OrderQuene> getOrderQuene(ResultSet r, OrderQuene q,ArrayList<OrderQuene> orderQuenes) throws SQLException
	{
		while(r.next())
		{
			q = new OrderQuene();
			q.setQueneNumber(r.getInt(1));
			q.setBusinessNumber(r.getString(2));
			q.setCustomerNumber(r.getString(3));
			q.setOrderStatu(r.getInt(4));
			q.setOrderDate(r.getString(5));
			q.setEndDate(r.getString(6));
			orderQuenes.add(q);
		}
		return orderQuenes;
	}
}
