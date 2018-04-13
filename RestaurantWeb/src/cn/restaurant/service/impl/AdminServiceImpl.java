package cn.restaurant.service.impl;

import cn.restaurant.dao.WaiterDao;
import cn.restaurant.dao.impl.WaiterDaoImpl;
import cn.restaurant.entity.Waiter;
import cn.restaurant.service.AdminService;
import cn.restaurant.util.BaseDao;

public class AdminServiceImpl extends BaseDao implements AdminService {

	WaiterDao waiterDao=new WaiterDaoImpl();
	@Override
	public boolean adminLogIn(String adminNumber, String adminPass) {
		// TODO Auto-generated method stub
		boolean result=false;
		if(adminNumber.equals("1408080109"))
		{
			if(adminPass.equals("109"))
			{
				result=true;
			}
		}
		return result;
	}

	@Override
	public boolean addWaiter(Waiter waiter) {
		// TODO Auto-generated method stub
		
		return waiterDao.waiterInsert(waiter);
	}

}
