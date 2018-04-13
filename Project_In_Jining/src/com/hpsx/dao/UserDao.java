package com.hpsx.dao;

import java.sql.Timestamp;

import com.hpsx.po.User;

public interface UserDao {
	/**
	 * 用户登录
	 * @param user 用户名和密码
	 * @return 用户信息
	 */
	public User login(User user);
	/**
	 * 用户注册
	 * @param user 用户信息
	 * @return 返回userId
	 */
	public Integer register(User user);
	/**
	 * 验证用户名是否存在
	 * @param userName 用户名
	 * @return true:成功 false：失败
	 */
	public boolean isExists(String userName);
	
	public int updateTime(Timestamp time,User user);
	/**
	 * 用户信息维护
	 * @param user 用户信息
	 * @return 1：成功 0：失败
	 */
	public int updateUserInfo(User user);
	/**
	 * 修改密码
	 * @param userId 用户Id
	 * @param pwd 密码
	 * @return 1：成功 0：失败 
	 */
	public int updatePassword(int userId,String pwd);
}
