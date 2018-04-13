package cn.bank.view;

import java.util.Scanner;

import cn.bank.dao.CustomerDao;
import cn.bank.entity.Administrator;
import cn.bank.entity.Customer;
import cn.bank.service.AdministratorService;
import cn.bank.service.CustomerService;
import cn.bank.service.impl.AdministratorServiceImpl;
import cn.bank.service.impl.CustomerServiceImpl;

public class Bank {

	private static Scanner sc = new Scanner(System.in);
	private static CustomerService custService = new CustomerServiceImpl();
	private static CustomerDao customerDao=new cn.bank.dao.impl.CustomerDaoImpl();
	private static AdministratorService administratorService=new AdministratorServiceImpl();
	private static Customer customer =null;

	public static void main(String[] args) {

		while (true) {
			System.out.println("\t\t----------------------------银行系统---------------------------");
			System.out.println("\t\t****************************1.管理员***************************");
			System.out.println("\t\t****************************2.顾    客****************************");
			System.out.println("\t\t****************************3.退    出****************************");
			System.out.println("\t\t--------------------------------------------------------------");
			int chose = 0;
			System.out.printf("\t\t请输入对应的数字，进入相应的界面：");
			try {
				chose = sc.nextInt();
			} catch (Exception e) {
				System.out.println("\t\t请输入1-3数字！");
				sc = new Scanner(System.in);
			}
			switch (chose) {
			case 1:
				adminLogin();
				break;
			case 2:
				custLogin();
				break;
			case 3:
				System.out.printf("\t\t谢谢您的使用，再见！");
				System.exit(0);
				break;
			default:
				System.out.printf("\t\t输入的数字无效,请重新选择!\n");
				break;
			}

		}

	}
	
	private static void addCust()
	{
		Customer customer=new Customer();
		System.out.printf("\t\t请输入顾客姓名：");
		String custNeme=sc.next();
		String format="^[a-zA-Z\u4e00-\u9fa5]{1,}$";
		
		if(!custNeme.matches(format))
		{
			System.out.println("\t\t输入的用户名格式不对，请重新输入！");
			return ;
		}
		else
		{
			format="^[1-9][0-9]{16}[0-9X]$";
		}
		
		System.out.printf("\t\t请输入顾客身份证号：");
		String custId=sc.next();
		if(!custId.matches(format))
		{
			System.out.println("\t\t输入的身份证号不对，请重新输入！");
			return ;
		}
		else
		{
			format="^[0-9]{6}$";
		}
		
		double Money=0;
		System.out.printf("\t\t请输入顾客开户金额：");
		try {
			Money=sc.nextDouble();
		} catch (Exception e) {
			System.out.println("\t\t请输入数字型的开户金额!");
			sc=new Scanner(System.in);
			return ;
		}
		
		System.out.printf("\t\t请输入初始密码：");
		String custPwd=sc.next();
		if(!custPwd.matches(format))
		{
			System.out.println("\t\t请输入6位数字组成的密码!");
			return;
		}
		
		
		customer.setCustIdCard(custId);
		customer.setCustName(custNeme);
		customer.setCustPwd(custPwd);
		customer.setCustMoney(Money);
		
		administratorService.adminAddCust(customer);
	}
	
	private static void custMoneySum()
	{
		double Money=0;
		Money=administratorService.custMoneySum();
		System.out.println("\t\t目前行内存款总额为："+Money);
	}
	
	private static void moneyIn(Customer customer)
	{
		double saveMoney=0;
		System.out.printf("\t\t请输入存款金额：");
		try {
			 saveMoney=sc.nextDouble();
		} catch (Exception e) {
			System.out.printf("\t\t请输入数字型的存款金额：");
			sc=new Scanner(System.in);
			return ;
		}
		String result=custService.moneyIn(customer.getCustNumber(), saveMoney);
		if(result.equals("存款成功"))
		{
			System.out.println("\t\t"+result);
			double Money=custService.custQueryBanlance(customer.getCustNumber());
			System.out.println("\t\t当前余额为"+Money);
			System.out.println("\n\n");
		}
		else
		{
			System.out.println("\t\t存款失败，请重试!");
		}
	}
	
	private static void moneyOut(Customer customer)
	{
		System.out.printf("\t\t请输入取款金额：");
		double moneyOut=0;
		try {
			moneyOut=sc.nextDouble();
		} catch (Exception e) {
			System.out.println("\t\t请输入数字型的取款金额：");
			sc=new Scanner(System.in);
			return ;
		}
		String result = custService.moneyOut(customer.getCustNumber(), moneyOut);
		if(result.equals("取款成功"))
		{
			double money=0;
			money=custService.custQueryBanlance(customer.getCustNumber());
			System.out.println("\t\t"+result+"  当前账户余额为："+money);
		}
		else
		{
			System.out.println("\t\t"+result);
		}
	}
	
	private static void queryBanlance(Customer customer)
	{
		double nowMoney=0;
		nowMoney=custService.custQueryBanlance(customer.getCustNumber());
		System.out.println("\t\t当前余额为："+nowMoney);
	}
	
	private static void tranMoney(Customer customer)
	{
		System.out.printf("\t\t请输入对方账号：");
		String custNumberIn=sc.next();
		String result=null;
		double money=0;
		Customer custIn=customerDao.custQuery(custNumberIn);
		double nowMoney=custService.custQueryBanlance(customer.getCustNumber());
		if(custIn!=null)
		{
			System.out.printf("\t\t请输入转账金额：");
			try {
				money=sc.nextDouble();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("\t\t请输入数字型的转账金额！");
				sc=new Scanner(System.in);
				return ;
			}
			result = custService.tranMoney(customer.getCustNumber(), custNumberIn, money);
			System.out.println("\t\t"+result+"    当前余额为："+nowMoney);
		}
		else
		{
			System.out.println("\t\t目标账户不存在，转账失败！");
		}
	}
	
	private static void changePwd(Customer customer)
	{
		System.out.printf("\t\t请输入旧密码：");
		String oldPwd=sc.next();
		String newPwd=null;
		String newPwdscend=null;
		if(customer.getCustPwd().equals(oldPwd))
		{
			System.out.printf("\t\t请输入新密码（为六位数字）：");
			newPwd=sc.next();
			String pattern = "^[0-9]{6}$";
			if(!newPwd.matches(pattern)){
				System.out.println("\t\t输入顾客密码格式不对,请重新输入！");
				return;
			}
			System.out.printf("\t\t请再次输入新密码：");
			newPwdscend=sc.next();
			if(newPwd.equals(newPwdscend))
			{
				custService.changePwd(customer.getCustNumber(), newPwdscend);
				System.out.println("\t\t修改密码成功！请重新登陆");
				custLogin();
			}
			else
			{
				System.out.println("\t\t两次输入的密码不一样！请重新输入！");
				return ;
			}
		}
		else
		{
			System.out.println("\t\t密码不正确！");
		}
	}
	
	private static void querycustBill(Customer customer)
	{
		System.out.printf("\t\t请输入要查询的月份 格式如“2016-11”");
		String queryDate=sc.next();
		int result=0;
		double moneyIn=custService.custqueryBillIn(customer.getCustNumber(), queryDate);
		double moneyOut=custService.custqueryBillOut(customer.getCustNumber(), queryDate);
		System.out.println("\n\n\t\t本月总支出为： "+moneyOut+"   本月总收入为： "+moneyIn);
		System.out.println("\t\t本月所有账单记录为：");
		System.out.println("\t\t账单流水号\t\t日期\t\t账单类型\t\t金额");
		result=custService.custqueryAllBill(customer.getCustNumber(), queryDate);
		if(result!=1)
		{
			System.out.println("\t\t本月无账单记录\n\n");
			return ;
		}
		System.out.println("\n\n");
	}
	
	private static void custLogin() {
		System.out.printf("\t\t请输入顾客卡号(19位数字):");
		String custNumber = sc.next();
		String pattern = "^[1-9][0-9]{18}$";
		if(!custNumber.matches(pattern)){
			System.out.printf("\t\t输入顾客卡号格式错误，请重新登录\n");
			return;
		}
		System.out.printf("\t\t请输入顾客密码:");
		String custPwd = sc.next();
		pattern = "^[0-9]{6}$";
		if(!custPwd.matches(pattern)){
			System.out.printf("\t\t输入顾客密码格式不对\n");
			return;
		}
		customer=custService.custLogin(custNumber, custPwd);
		if(customer==null){
			
			return;
		}else{
				enterCustMenu(customer) ;
				return ;
		}
		
		
	}
	private static void adminLogin() {
		int result=0;
		System.out.printf("\t\t请输入管理员账号:");
		String adminNumber = sc.next();
		String pattern = "^[0-9A-Za-z]{6,10}$";
		if(!adminNumber.matches(pattern)){
			System.out.println("\t\t输入管理员账号格式错误，请重新登录");
			return;
		}
		result=administratorService.adminLoginCheck(adminNumber);
		if(result!=1)
		{
			System.out.println("\t\t管理员账号不存在！");
			return ;
		}
		System.out.printf("\t\t请输入管理员密码:");
		String adminPwd = sc.next();
		pattern = "^[0-9]{6}$";
		if(!adminPwd.matches(pattern)){
			System.out.println("\t\t输入管理员密码格式不对");
			return;
		}
		Administrator administrator=administratorService.adminLogin(adminNumber, adminPwd);
		if(administrator==null)
		{
			return ;
		}
		else
		{
			enterAdminMenu();
			return ;
		}
	}
	private static void enterCustMenu(Customer customer) {
		while(true){
			System.out.println("\t\t----------------------------银行系统[顾客]----------------------------");
			System.out.println("\t\t**********************************************************************");
			System.out.println("\t\t     1.存款 2.取款 3.查询余额 4.转账 5.修改密码 6.查询月账单 7.退出");
			System.out.printf("\t\t请选择：");
			int chose = 0;
			try {
				chose = sc.nextInt();
			} catch (Exception e) {
				System.out.println("\t\t请输入1-7数字！");
				sc = new Scanner(System.in);
			}
			switch (chose) {
			case 1:
				moneyIn(customer);
				break;
			case 2:
				moneyOut(customer);
				break;
			case 3:
				queryBanlance(customer);
				break;
			case 4:
				tranMoney(customer);
				break;
			case 5:
				changePwd(customer);
				break;
			case 6:
				querycustBill(customer);
				break;
			case 7:
				//退出
			System.out.println("\t\t您已成功退出，谢谢您的使用~");
			return;
			default:
				System.out.println("\t\t输入的数字无效,请重新选择!");
				break;
			}
		}
	}
	private static void enterAdminMenu()
	{
		while(true)
		{
			System.out.println("\t\t----------------------------银行系统[管理员]----------------------------");
			System.out.println("\t\t***********************************************************************");
			System.out.println("\t\t                  1.添加顾客  2.计算储蓄总额 3.退出 ");
			System.out.printf("\t\t请选择");
			int chose = 0;
			try {
				chose = sc.nextInt();
			} catch (Exception e) {
				System.out.println("\t\t请输入1-7数字！");
				sc = new Scanner(System.in);
			}
			switch (chose) {
			case 1:
				addCust();
				break;
			case 2:
				custMoneySum();
				break;
			case 3:
				System.out.println("\t\t管理员您已退出，谢谢使用~");
				return;
			default:
				System.out.println("\t\t输入的数字无效,请重新选择!");
				break;
			}
		}
	}
}
