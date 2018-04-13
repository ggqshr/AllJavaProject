package com.hpsx.po;

import java.util.Date;

public class Memorandum {
	
	private int mem_id;
	private String mem_title;
	private Date time;
	private String content;
	private int userId;
	public Memorandum() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Memorandum [mem_id=" + mem_id + ", mem_title=" + mem_title + ", time=" + time + ", content=" + content
				+ ", userId=" + userId + "]";
	}

	public int getMem_id() {
		return mem_id;
	}
	public void setMem_id(int mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_title() {
		return mem_title;
	}
	public void setMem_title(String mem_title) {
		this.mem_title = mem_title;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
}
