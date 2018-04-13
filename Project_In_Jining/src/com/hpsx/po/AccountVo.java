package com.hpsx.po;

import java.sql.Timestamp;

public class AccountVo {
	
	private double money;
	private int in_accId;
	private int ex_accId;
	private Timestamp acc_time;
	private String type;
	
	public AccountVo() {
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIn_accId() {
		return in_accId;
	}

	public void setIn_accId(int in_accId) {
		this.in_accId = in_accId;
	}

	public int getEx_accId() {
		return ex_accId;
	}

	public void setEx_accId(int ex_accId) {
		this.ex_accId = ex_accId;
	}

	public Timestamp getAcc_time() {
		return acc_time;
	}

	public void setAcc_time(Timestamp acc_time) {
		this.acc_time = acc_time;
	}

	public double getmoney() {
		return money;
	}

	public void setmoney(double money) {
		this.money = money;
	}

	
}
