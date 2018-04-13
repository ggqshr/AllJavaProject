package com.hpsx.view;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.hpsx.dao.impl.MemorandumDaoImpl;
import com.hpsx.po.Memorandum;
import com.hpsx.po.User;

public class MemorandumUI {

	MemorandumDaoImpl memorandumDaoImpl = new MemorandumDaoImpl();
	
	public void memMenu(User user){
		Scanner sc = new Scanner(System.in);
		System.out.println("-------------我的备忘录-------------");
		System.out.println("*****************[欢迎您，用户-"+user.getUserName()+"]*****************");
		System.out.println("1.查看备忘录 2.添加备忘录 3.修改备忘录 4.删除备忘录 0.返回主菜单");
		System.out.println("*************个人备忘录*************");
		System.out.print("请选择业务：");
		int check = sc.nextInt();
		switch(check){
		case 1:
			showAllMem(user);
			memMenu(user);
			break;
		case 2:
			addMem(user);
			break;
		case 3:
			updateMem(user);
			break;
		case 4:
			deleteMem(user);
			break;
		case 0:
			new UserUI().second_menu(user);;
			break;
		default:
			break;
		}
	}
	
	public void showAllMem(User user){
		List<Memorandum> mList =memorandumDaoImpl.getAllMemorandum(user.getUserId());
		if(mList.size()==0){
			System.out.println("备忘录为空！");
		}else{
			System.out.println("-------------我的备忘录-------------");
			System.out.println("*************查看备忘录*************");
			for (Memorandum m : mList) {
				System.out.println("1.编号："+m.getMem_id()+"\t \t 2.标题："+m.getMem_title()+"\t \t 3.时间："+m.getTime().toString().substring(0,10)+"\t \t 4.内容："+m.getContent());
			}
		}
	}
	
	public void addMem(User user){
		Scanner sc = new Scanner(System.in);
		Memorandum m = new Memorandum();
		System.out.println("-------------我的备忘录-------------");
		System.out.println("*************添加备忘录*************");
		System.out.println("请输入标题：");
		m.setMem_title(sc.nextLine());
		System.out.println("请输入内容：");
		m.setContent(sc.nextLine());
		Date date = new Date();
		m.setTime(date);
		m.setUserId(user.getUserId());
		if(memorandumDaoImpl.addMemorandum(m)==0){
			System.err.println("添加失败！");
		}else{
			System.out.println("你的备忘录添加成功，请注意查看！");
			showAllMem(user);
			memMenu(user);
		}
	}
	
	public void updateMem(User user){
		Scanner sc = new Scanner(System.in);
		showAllMem(user);
		System.out.println("请输入要修改的备忘录编号：");
		int id = sc.nextInt();
		Memorandum m = memorandumDaoImpl.getMemorandum(id,user.getUserId());
		if(m==null){
			System.out.println("备忘录不存在，请重新输入！");
			memMenu(user);
		}else{
			System.out.println(m.toString());
			System.out.println("请输入标题：");
			m.setMem_title(sc.next());
			System.out.println("请输入内容：");
			m.setContent(sc.next());
			m.setTime(new Date());
			if(memorandumDaoImpl.updateMemorandum(m)==0){
				System.err.println("修改失败！");
				updateMem(user);
			}else{
				System.out.println("你的备忘录修改成功，请注意查看！");
				showAllMem(user);
				memMenu(user);
			}
		}
	}
	
	public void deleteMem(User user){
		Scanner sc = new Scanner(System.in);
		showAllMem(user);
		System.out.println("请输入要删除的备忘录编号：");
		String id_str=sc.nextLine();
		Pattern p = Pattern.compile("[0-9]*");
		Matcher matcher = p.matcher(id_str);
		if(!matcher.matches()){
			System.err.println("输入有误，请重新输入！");
			deleteMem(user);
		}
		int id = Integer.valueOf(id_str);
		Memorandum m = memorandumDaoImpl.getMemorandum(id,user.getUserId());
		if(m==null){
			System.out.println("备忘录不存在，请重新输入！");
			memMenu(user);
		}else{
			System.out.println(m.toString());
			System.out.println("确定删除吗？y/n");
			String c = sc.next();
			if(c.equals("y")){
				if(memorandumDaoImpl.deleteMemorandum(id)==1){
					System.out.println("删除成功！");
					showAllMem(user);
					memMenu(user);
				}else{
					System.err.println("删除失败！");
				}
			}else{
				memMenu(user);
			}
		}
	}
}
