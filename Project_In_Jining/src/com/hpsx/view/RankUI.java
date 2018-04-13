package com.hpsx.view;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.hpsx.dao.impl.RankingDaoImpl;
import com.hpsx.po.Ranking;
import com.hpsx.po.RankingVo;
import com.hpsx.po.User;

public class RankUI {
	
	RankingDaoImpl rDaoImpl = new RankingDaoImpl();
	int count=0;
	public void rankmenu(User user){
		
		Scanner sc = new Scanner(System.in);
		System.out.println("----------------娱乐天地----------------");
		System.out.println("*****************[欢迎您，用户-"+user.getUserName()+"]*****************");
		System.out.println("1.猜拳游戏 2.游戏排行榜 0.返回主菜单");
		System.out.println("******************娱乐天地******************");
		System.out.println("请选择业务");
		int check = sc.nextInt();
		switch(check){
		case 1:
			game(user);
			break;
		case 2:
			showMark(user);
			break;
		case 0:
			new UserUI().second_menu(user);
			break;
		default:
			System.err.println("输入有误！请重新输入！");
			rankmenu(user);
			break;
		}
	}
	
	public void game(User user){
		System.out.println("-------------娱乐天地-------------");
		System.out.println("*************猜拳游戏*************");
		Ranking r = new Ranking();
		r.setIntegral(0);
		r.setUserId(user.getUserId());
		start_game(user,r);
	}
	
	public void start_game(User user,Ranking r){
		Scanner sc = new Scanner(System.in);
		System.out.println("请出券：1、剪刀 2、石头 3、布");
		int c = sc.nextInt();
		if(c!=1 && c!=2 &&c!=3){
			System.out.println("输入错误！请重新输入！出拳规则：1、剪刀 2、石头 3、布");
			start_game(user,r);
		}
		String[] check = new String[]{"剪刀","石头","布"};
		int comp = 1+(int) (Math.random()*3);
		System.out.println(user.getUserName()+"出："+check[c-1]);
		System.out.println("电脑出："+check[comp-1]);
		switch(c-comp){
		case 0:
			System.out.println("和局");
			start_game(user,r);
			break;
		case 1:
			System.out.println("你赢了！电脑输了！");
			r.setIntegral(r.getIntegral()+1);
			System.out.println("目前共计"+r.getIntegral()+"分");
			start_game(user,r);
			break;
		case 2:
			System.out.println("你输了！电脑赢了！");
			System.out.println("游戏结束，共计"+r.getIntegral()+"分");
			if(rDaoImpl.addRank(r)==0){
				System.err.println("记录添加错误！");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			rankmenu(user);
			break;
		case -1:
			System.out.println("你输了！电脑赢了！");
			System.out.println("游戏结束，共计"+r.getIntegral()+"分");
			if(rDaoImpl.addRank(r)==0){
				System.err.println("记录添加错误！");
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rankmenu(user);
			break;
		case -2:
			System.out.println("你赢了！电脑输了！");
			r.setIntegral(r.getIntegral()+1);
			System.out.println("目前共计"+r.getIntegral()+"分");
			start_game(user,r);
			break;
		}
	}
	
	public void showMark(User user){
		List<RankingVo> rlist = rDaoImpl.getAllRanking();
		System.out.println("-------------娱乐天地-------------");
		System.out.println("************游戏排行榜*************");
		System.out.println("排名\t 姓名\t 积分\t\t 时间\t");
		int count=1;
		for (RankingVo rvo : rlist) {
			System.out.println((count++)+"\t"+rvo.getUserName()+"\t"+rvo.getIntegral()+"\t"+rvo.getTime());
		}
		rankmenu(user);
	}
}
