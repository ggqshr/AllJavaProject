package com.util;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
public class User {
	private int userId;
	private String userName;
	private String userPwd;
	private String realName;
	private String tel;
	private String address;
	private Timestamp login_time;
	
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", userPwd=" + userPwd + ", realName=" + realName
				+ ", tel=" + tel + ", address=" + address + "]";
	}
	public User(){
		
	}
	public User(String userName,String userPwd){
		this.userName = userName;
		this.userPwd = userPwd;
	}
	public User(String userName, String userPwd, String realName, String tel, String address,
			Timestamp login_time) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.realName = realName;
		this.tel = tel;
		this.address = address;
		this.login_time = login_time;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getLogin_time() {
		return login_time;
	}
	public void setLogin_time(Timestamp date) {
		this.login_time = date;
	}
	
}
