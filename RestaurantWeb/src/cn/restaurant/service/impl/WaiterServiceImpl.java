package cn.restaurant.service.impl;

import cn.restaurant.dao.WaiterDao;
import cn.restaurant.dao.impl.WaiterDaoImpl;
import cn.restaurant.service.WaiterService;

public class WaiterServiceImpl implements WaiterService{
	WaiterDao waiterdao=new WaiterDaoImpl();
	@Override
	public boolean waiterLogin(String waiterNumber, String waiterPass) {
		// TODO Auto-generated method stub
		return waiterdao.waiterLogin(waiterNumber, waiterPass);
	}

}
