package com.hpsx.view;

import java.awt.Color;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.event.TreeWillExpandListener;

import com.hpsx.dao.impl.RankingDaoImpl;
import com.hpsx.dao.impl.UserDaoImpl;
import com.hpsx.po.Account;
import com.hpsx.po.Memorandum;
import com.hpsx.po.Ranking;
import com.hpsx.po.User;

public class UserUI {
	
	int count = 0;
	UserDaoImpl userDaoImpl = new UserDaoImpl();
	
	public void primary_menu(){
		System.out.println("-------------个人生活助手平台-------------");
		System.out.println("****************1.登录****************");
		System.out.println("****************2.注册****************");
		System.out.println("****************0.退出****************");
		System.out.println("--------------------------------------");
		System.out.print("请输入选择：");
		Scanner sc = new Scanner(System.in);
		int check = sc.nextInt();
		switch(check){
		case 1:
			Login();
			break;
		case 2:
			Register();
			break;
		case 0:
			System.out.println("谢谢使用！");
			System.exit(0);
		default:
			System.err.println("输入有误！");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			primary_menu();
			break;
		}
	}
	
	public void Login(){
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------个人生活助手平台-------------");
		System.out.println("*****************用户登录*****************");
		System.out.print("请输入用户名：");
		String uname = sc.nextLine();
		System.out.print("请输入密码：");
		String pwd = sc.nextLine();
		User user =new User(uname, pwd);
		user = userDaoImpl.login(user);
		if(user==null){
			while(count<2){
				System.err.println("用户名或密码错误！");
				count++;
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Login();
			}
			System.err.println("连续3次输入错误，请确认后登录！");
			count = 0;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			primary_menu();
		}else{
			System.out.println("登录成功！");
			count = 0;
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			second_menu(user);//登录成功界面
		}
	}
	
	public void Register(){
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------个人生活助手平台-------------");
		System.out.println("*****************用户注册*****************");
		System.out.print("请输入用户名：");
		String uname = sc.nextLine();
		System.out.print("请输入密码：");
		String upwd = sc.nextLine();
		System.out.print("请输入真实姓名：");
		String urealname = sc.nextLine();
		System.out.print("请输入电话号码：");
		String tel = sc.nextLine();
		System.out.print("请输入联系地址：");
		String address = sc.nextLine();
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		User user = new User(uname, upwd, urealname, tel, address, timestamp);
		if(userDaoImpl.isExists(user.getUserName())){
			System.err.println("用户名已经存在，请重新操作！");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			primary_menu();
		}else{
			if(userDaoImpl.register(user)!=0){
				System.out.println("恭喜您，注册成功!");
				Date date1 = new Date();
				long longTime1 = date1.getTime();
				Timestamp timestamp1 = new Timestamp(longTime1);
				userDaoImpl.updateTime(timestamp1, user);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				second_menu(user);
			}
		}
	}
	
	public void second_menu(User user){
		SimpleDateFormat dfDateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		System.out.println("-------------个人生活助手平台-------------");
		System.out.println("****************[欢迎您，用户-"+user.getUserName()+
				"上次登录时间："+dfDateFormat.format(user.getLogin_time().getTime())+"]****************");
		System.out.println("1.信息维护 2.修改密码 3.个人钱包 4.备忘录 5.娱乐天地 0.返回登录主菜单");
		System.out.println("-------------个人生活助手平台-------------");
		System.out.print("请选择业务：");
		Date date = new Date();
		long longTime = date.getTime();
		Timestamp timestamp = new Timestamp(longTime);
		userDaoImpl.updateTime(timestamp, user);
		Scanner sc = new Scanner(System.in);
		int check = sc.nextInt();
		switch(check){
		case 1:
			maintenance(user);
			break;
		case 2:
			alterPwd(user);
			break;
		case 3:
			new AccountUI().accountMenu(user);
			break;
		case 4:
			new MemorandumUI().memMenu(user);
			break;
		case 5:
			new RankUI().rankmenu(user);
			break;
		case 0:
			primary_menu();
			break;
		}
	}
	
	public void maintenance(User user){
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------个人生活助手平台-------------");
		System.out.println("*****************信息维护*****************");
		System.out.println(user.toString());
		System.out.print("请输入手机号：");
		String tel = sc.nextLine();
		System.out.print("请输入地址：");
		String addr = sc.nextLine();
		user.setAddress(addr);
		user.setTel(tel);
		if(userDaoImpl.updateUserInfo(user)==1){
			System.out.println("更新成功！");
			System.out.println(user.toString());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			second_menu(user);
		}else{
			System.err.println("更新失败！");
		}
	}
	public void alterPwd(User user){
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------个人生活助手平台-------------");
		System.out.println("*****************修改密码*****************");
		System.out.print("请输入原密码：");
		String pwd = sc.nextLine();
		if(pwd.equals(user.getUserPwd())){
			System.out.print("请输入新密码：");
			pwd = sc.nextLine();
			System.out.print("请再次输入密码：");
			String apwd = sc.nextLine();
			if(pwd.equals(apwd)){
				userDaoImpl.updatePassword(user.getUserId(), pwd);
				System.out.println("修改成功，请重新登录！");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				primary_menu();
			}else{
				System.err.println("两次输入的密码不一致！");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				alterPwd(user);
			}
		}else{
			System.err.println("您输入的原密码不正确！");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			alterPwd(user);
		}
	}
}
