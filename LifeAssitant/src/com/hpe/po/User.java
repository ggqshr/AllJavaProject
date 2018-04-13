package com.hpe.po;

public class User {
	private int userId;
	private String userName;
	private String userPassword;
	private String realName;
	private String tel;
	private String address;
	private String login_time;

	public User()
	{
		
	}
	public User(int userId, String userName, String userPassword, String realName, String tel, String address,
			String login_time) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userPassword = userPassword;
		this.realName = realName;
		this.tel = tel;
		this.address = address;
		this.login_time = login_time;
	}

	public int getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public String getRealName() {
		return realName;
	}

	public String getTel() {
		return tel;
	}

	public String getAddress() {
		return address;
	}

	public String getLogin_time() {
		return login_time;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setLogin_time(String login_time) {
		this.login_time = login_time;
	}

}
