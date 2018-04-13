package com.hpsx.po;

import java.util.Date;
import java.sql.Timestamp;

public class AccountLog {

	private int log_id;
	private int accountId;
	private int transfer_account;
	private String type;
	private String log_time;
	private double money;
	
	public AccountLog() {
		// TODO Auto-generated constructor stub
	}
	public int getLog_id() {
		return log_id;
	}
	public void setLog_id(int log_id) {
		this.log_id = log_id;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public int getTransfer_account() {
		return transfer_account;
	}
	public void setTransfer_account(int transfer_account) {
		this.transfer_account = transfer_account;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLog_time() {
		return log_time;
	}
	public void setLog_time(String log_time) {
		this.log_time = log_time;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	
}
