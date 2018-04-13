package com.hpsx.po;

import java.sql.Timestamp;

public class Ranking {

	private int userId;
	private int integral;
	private Timestamp time;
	
	public Ranking(int userId, Timestamp time) {
		this.userId = userId;
		this.time = time;
	}

	public Ranking() {
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getIntegral() {
		return integral;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public Timestamp getTime() {
		return time;
	}

	public void setTime(Timestamp time) {
		this.time = time;
	}

	
	
}
