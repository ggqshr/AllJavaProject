package com.hpe.po;

public class Account {
	private int accountId;
	private double account_money;
	private int userId;

	public int getAccountId() {
		return accountId;
	}

	public double getAccount_money() {
		return account_money;
	}

	public int getUserId() {
		return userId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public void setAccount_money(double account_money) {
		this.account_money = account_money;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
