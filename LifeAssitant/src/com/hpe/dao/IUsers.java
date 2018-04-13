package com.hpe.dao;

import com.hpe.po.User;

public interface IUsers {
	// 插入用户
	public void insertIntoUsers(User user);

	// 更新
	public void UpdateUserInf(User user);

	// 登陆
	User login(User user);

	// 注册
	Integer register(User user);

	// 检查是否存在
	Boolean isExists(String userName);
	

}
