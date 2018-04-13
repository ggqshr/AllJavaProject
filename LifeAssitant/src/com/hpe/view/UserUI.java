package com.hpe.view;

import java.util.Scanner;

import com.hpe.dao.IUsers;
import com.hpe.dao.impl.UserDaoImpl;
import com.hpe.po.User;

/**
 * 个人生活助手用户管理主界面
 * 
 * @author ggq ·date：2018年1月16日
 */
public class UserUI {
	private Scanner scanner = new Scanner(System.in);
	private IUsers iUsers = new UserDaoImpl();

	public void login() {
		while(true)
		{
			System.out.println("-------------个人生活助手平台-------------");
			System.out.println("****************用户登录***************");
			System.out.print("请输入用户名");
			String username = scanner.next();
			System.out.print("请输入密码");
			String userpwd = scanner.next();
			User user = new User();
			user.setUserName(username);
			user.setUserPassword(userpwd);
			User user2 = iUsers.login(user);
			if(user2!=null)
			{
				System.out.println("登陆成功");
			}
			else
			{
				System.out.println("用户名密码错误");
			}
		}
	}
	public void register()
	{
		
	}
}
