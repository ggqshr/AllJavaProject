package com.hpe.po;

public class memorandum {
	private int memorandum_id;
	private String memorandum_title;
	private String time;
	private String content;
	private int userId;

	public int getMemorandum_id() {
		return memorandum_id;
	}

	public String getMemorandum_title() {
		return memorandum_title;
	}

	public String getTime() {
		return time;
	}

	public String getContent() {
		return content;
	}

	public int getUserId() {
		return userId;
	}

	public void setMemorandum_id(int memorandum_id) {
		this.memorandum_id = memorandum_id;
	}

	public void setMemorandum_title(String memorandum_title) {
		this.memorandum_title = memorandum_title;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
