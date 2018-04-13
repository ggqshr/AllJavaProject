package com.hpe.po;

public class ranking {
	private int rankingId;
	private int userId;
	private int integral;
	private String time;

	public int getRankingId() {
		return rankingId;
	}

	public int getUserId() {
		return userId;
	}

	public int getIntegral() {
		return integral;
	}

	public String getTime() {
		return time;
	}

	public void setRankingId(int rankingId) {
		this.rankingId = rankingId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setIntegral(int integral) {
		this.integral = integral;
	}

	public void setTime(String time) {
		this.time = time;
	}

}
