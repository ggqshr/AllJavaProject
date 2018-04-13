package com.hpsx.view;

import java.security.interfaces.RSAKey;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hpsx.dao.impl.AccountDaoImpl;
import com.hpsx.po.Account;
import com.hpsx.po.AccountLog;
import com.hpsx.po.AccountVo;
import com.hpsx.po.User;

public class AccountUI {
	
	AccountDaoImpl accountDaoImpl = new AccountDaoImpl();
	UserUI userUI = new UserUI();
	
	public void accountMenu(User user){
		Account acc = accountDaoImpl.viewAccount(user.getUserId());
		
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------个人钱包-------------");
		System.out.println("1.查看余额 2.存钱 3.转账 4.统计查询 0.返回主菜单");
		System.out.print("请输入业务：");
		int check = sc.nextInt();
		switch(check){
		case 1:
			viewAccount(acc);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accountMenu(user);
			break;
		case 2:
			saveMoney(acc, user);
			break;
		case 3:
			transfermoney(acc, user);
			break;
		case 4:
			statistic(acc, user);
			break;
		case 0:
			userUI.second_menu(user);
			break;
		default:
			System.err.println("输入有误，请重新输入！");
			accountMenu(user);
			break;
		}
	}
	
	public void viewAccount(Account acc){
		System.out.println("您的账户:"+acc.getAccountId()+"余额为："+acc.getAccount_money());
	}
	
	public void saveMoney(Account acc,User user){
		System.out.println("-------------个人钱包-------------");
		System.out.println("*****************存钱*****************");
		Scanner sc = new Scanner(System.in);
		AccountVo aco = new AccountVo();
		aco.setIn_accId(acc.getAccountId());
		aco.setEx_accId(acc.getAccountId());
		aco.setType("存入");
		Date date = new Date();
		Timestamp acc_time = new Timestamp(date.getTime());
		aco.setAcc_time(acc_time);
		System.out.print("请输入存款金额：");
		String money_str = sc.nextLine();
		Pattern p = Pattern.compile("[0-9]*");
		Matcher m = p.matcher(money_str);
		if(m.matches()){
			double money = Double.valueOf(money_str);
			aco.setmoney(money);
			if(accountDaoImpl.saveAccount(aco)){
				System.out.println("您的账户成功存入："+money+"元");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				accountMenu(user);
			}else{
				System.err.println("存钱失败！");
			}
		}else{
			System.err.println("输入的金额不合法！");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			saveMoney(acc,user);
		}
	}
	
	public void transfermoney(Account acc,User user){
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------个人钱包-------------");
		System.out.println("*****************转账*****************");
		System.out.println(acc.toString());
		AccountVo aco = new AccountVo();
		aco.setEx_accId(acc.getAccountId());
		System.out.print("请输入对方账户：");
		aco.setIn_accId(sc.nextInt());
		if(accountDaoImpl.isExistAccount(aco.getIn_accId())){
			System.out.print("请输入转账金额：");
			String money_str = sc.next();
			Pattern p = Pattern.compile("[0-9]*");
			Matcher m = p.matcher(money_str);
			if(m.matches()){
				aco.setmoney(Double.valueOf(money_str));
				if(aco.getmoney()>acc.getAccount_money()){
					System.err.println("您的账户余额不足，请及时充值！");
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					transfermoney(acc, user);
				}else{
					aco.setType("转出");
					Date date = new Date();
					Timestamp acc_time = new Timestamp(date.getTime());
					aco.setAcc_time(acc_time);
					if(accountDaoImpl.transferAccount(aco)){
						System.out.println("您的账户成功转出："+aco.getmoney()+"元");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						accountMenu(user);
					}else{
						System.err.println("转账失败！");
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						transfermoney(acc, user);
					}
				}
			}else{
				System.err.println("输入的金额不合法！");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				accountMenu(user);
			}
		}else{
			System.err.println("非常抱歉，账户不存在，请核对后再输入");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accountMenu(user);
		}
	}
	
	public void statistic(Account acc,User user){
		AccountLog accl = new AccountLog();
		accl.setAccountId(acc.getAccountId());
		accl.setType("转出");
		SimpleDateFormat df = new SimpleDateFormat("YYYY-MM");
		Date date = new Date();
		String d = df.format(date);
		accl.setLog_time(d);
		double income = accountDaoImpl.queryIncome(accl);
		double expenditure = accountDaoImpl.queryExpenditure(accl);
		System.out.println("当月收入统计："+income+"元");
		System.out.println("当月支出统计："+expenditure+"元");
		accountMenu(user);
	}
}
