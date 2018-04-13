package com.qianfeng.bean;

import java.net.Socket;

/**
 * 客户端信息
 */
public class ClientBean {
	private String name;
	private Socket socket;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Socket getSocket() {
		return socket;
	}

	public void setSocket(Socket socket) {
		this.socket = socket;
	}

	@Override
	public String toString() {
		return "ClientBean [name=" + name + ", socket=" + socket + "]";
	}

}
