package com.hpsx.po;

public class Account {
	private int accountId;
	private double account_money;
	private int userId;
	
	
	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", account_money=" + account_money + ", userId=" + userId + "]";
	}
	public Account() {
		// TODO Auto-generated constructor stub
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAccount_money() {
		return account_money;
	}
	public void setAccount_money(double account_money) {
		this.account_money = account_money;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
