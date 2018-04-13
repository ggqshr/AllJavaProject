package com.hpe.view;

import java.util.Scanner;

public class MainUI {
	public static Scanner scanner = new Scanner(System.in);
	public static UserUI userUI = new UserUI();

	public static void main(String[] args) {
		while (true) {
			System.out.println("-------------个人生活助手平台-------------");
			System.out.println("****************1.登录****************");
			System.out.println("****************2.注册****************");
			System.out.println("****************0.退出****************");
			System.out.println("-------------------------------------");
			System.out.println("请选择");
			String select = scanner.next();
			switch (select) {
			case "1":
				// 登陆
				userUI.login();
				break;
			case "2":
				// 注册
				userUI.register();
				break;
			case "0":
				System.exit(0);
				break;
			default:
				System.out.println("您输入有误，请重新选择");
				break;
		}
		}
	}
}
