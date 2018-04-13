package com.qianfeng.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


import com.qianfeng.bean.ClientBean;
import com.qianfeng.bean.UserBean;

public class MyServer {
	private static ServerSocket ss;
	/**
	 * 在线人数列表
	 * */
	public static HashMap<String, ClientBean> onlines;
	static {
		try {
			//创建服务器设置端口
			ss = new ServerSocket(8521);
			//实例化在线列表集合
			onlines = new HashMap<String, ClientBean>();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class MyClientThread extends Thread {
		private Socket client;
		/**
		 * 从客户端获取的对象
		 * */
		private UserBean bean;
		//对象输入流
		private ObjectInputStream ois;
		//对象输出流
		private ObjectOutputStream oos;
		/**
		 * 构造
		 * @param client 客户端socket
		 * */
		public MyClientThread(Socket client) {
			// TODO Auto-generated constructor stub
			this.client = client;
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
			
			try {
				// 不停的从客户端接收信息
				while (true) {
					// 读取从客户端接收到的catbean信息
					ois = new ObjectInputStream(client.getInputStream());
					//从客户端的输入刘中读取对象
					bean=(UserBean) ois.readObject();
					System.out.println("bean="+bean.toString());
					// 分析catbean中，type是那样一种类型
					switch (bean.getType()) {
					// 上下线更新
					case 0: // 上线
						// 记录上线客户的用户名和端口在clientbean中<在线客户端列表类>
						ClientBean cbean=new ClientBean();
						//设置用户名
						cbean.setName(bean.getName());
						//登录用户的socket
						cbean.setSocket(client);
						
						// 添加在线用户
						onlines.put(bean.getName(), cbean);
						// 新创建服务器的userbean，并发送给客户端
						UserBean user=new UserBean();
						//设置消息类型
						user.setType(0);
						//设置通知信息
						user.setInfo(bean.getTimer()+"  "+bean.getName()+"上线了");
						//通知所有用户有人上线
						HashSet<String> set = new HashSet<String>();
						// 存如客户昵称
						set.addAll(onlines.keySet());
						user.setClients(set);
						//发送在线的所有用户
						sendAll(user);
						
						break;
					case -1://下线
						//封装一个下线的用户
						UserBean serverBean=new UserBean();
						serverBean.setType(-1);
						oos=new ObjectOutputStream(client.getOutputStream());
						//将一个对象Obj写入输出流送往目的地
						oos.writeObject(serverBean);
						oos.flush();
						//移除在线列表中下线的用户
						onlines.remove(bean.getName());
						
						//向剩下的在线用户发送有人离开的通知
						UserBean serverBean2=new UserBean();	
						serverBean2.setInfo(bean.getTimer() + "  "
								+ bean.getName() + " " + " 下线了");
						serverBean2.setType(0);
						
						HashSet<String> set1 = new HashSet<String>();
						set1.addAll(onlines.keySet());
						serverBean2.setClients(set1);
						
						sendAll(serverBean2);
						//一定要return  不然无法跳出循环退出循环
						return;
					case 1://聊天
						UserBean serverBean3=new UserBean();
						serverBean3.setName(bean.getName());
						serverBean3.setClients(bean.getClients());
						serverBean3.setType(1);
						serverBean3.setInfo(bean.getInfo());
						serverBean3.setTimer(bean.getTimer());
						//像选中的客户端发送信息
						sendMessage(serverBean3);
						break;
					case 2:// 得到接受文件的请求  通知要发送的用户 发送一个状态  2
						// 创建服务器的Userbean，并发送给客户端
					
						UserBean serverBean4=new UserBean();
						String info = bean.getTimer() + "  " + bean.getName()
								+ "向你传送文件,是否需要接受";
						serverBean4.setType(2);
						serverBean4.setClients(bean.getClients()); // 这是发送的目的地
						serverBean4.setFileName(bean.getFileName()); // 文件名称
						serverBean4.setSize(bean.getSize()); // 文件大小
						serverBean4.setInfo(info);
						serverBean4.setName(bean.getName()); // 来源
						serverBean4.setTimer(bean.getTimer());
						// 向选中的客户发送数据
						sendMessage(serverBean4);
						break;
					case 3:// 确定接收文件
						UserBean serverBean5=new UserBean();
						serverBean5.setType(3);
						serverBean5.setClients(bean.getClients()); // 文件来源
						serverBean5.setTo(bean.getTo()); // 文件目的地
						serverBean5.setFileName(bean.getFileName()); // 文件名称
						serverBean5.setIp(bean.getIp());
						serverBean5.setPort(bean.getPort());
						serverBean5.setName(bean.getName()); // 接收的客户名称
						serverBean5.setTimer(bean.getTimer());
						// 通知文件来源的客户，对方确定接收文件
						sendMessage(serverBean5);
						break;
					case 4:
						UserBean serverBean6 = new UserBean();

						serverBean6.setType(4);
						serverBean6.setClients(bean.getClients()); // 文件来源
						serverBean6.setTo(bean.getTo()); // 文件目的地
						serverBean6.setFileName(bean.getFileName());
						serverBean6.setInfo(bean.getInfo());
						serverBean6.setName(bean.getName());// 接收的客户名称
						serverBean6.setTimer(bean.getTimer());
						sendMessage(serverBean6);
						break;
					default:
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				close();
			}

		}
		
		/**
		 * 关闭流和客户端的方法 
		 * */
		private void close() {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (ois != null) {
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (client != null) {
				try {
					client.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	/**
	 * 向所有的用户发送数据
	 * 
	 * */
	public void sendAll(UserBean serverBean){
		//获取所有在线用户
		Collection<ClientBean> clients = onlines.values();
		//创建迭代其
		Iterator<ClientBean> it = clients.iterator();
		//对象输出流
		ObjectOutputStream oos;
		//遍历用户列表
		while (it.hasNext()) {
			//获取socket
			Socket c=it.next().getSocket();
			try {
				//封装成对象输出流
				oos=new ObjectOutputStream(c.getOutputStream());
				//输出到serverBean 给每个用户发送上线者的信息通知
				oos.writeObject(serverBean);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 像选中用户发送数据
	 * */
	private void sendMessage(UserBean serverBean){
		// 首先取得所有的values
		Set<String> cbs = onlines.keySet();
		Iterator<String> it = cbs.iterator();
		// 选中客户
		HashSet<String> clients = serverBean.getClients();
		while (it.hasNext()) {
			// 在线客户
			String client=it.next();
			// 选中的客户中若是在线的，就发送serverbean
			if(clients.contains(client)){
				Socket c=onlines.get(client).getSocket();
				ObjectOutputStream oos;
				try {
					//把选中的客户对象通过输出路流发送过去
					oos = new ObjectOutputStream(c.getOutputStream());
					oos.writeObject(serverBean);
					oos.flush();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
	}
	
	//开启线程和对接Socket的函数
	public void start() {
		try {
			while (true) {
				//ServerSocket返回的是一个Socket，这个Socket是客户端的。自此ServerSocket和Socket可以开始交流，达成了通讯
				Socket client = ss.accept();
				//开始线程
				new MyClientThread(client).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//程序入口
	public static void main(String[] args) {
		//执行当前类start函数
		new MyServer().start();
	}
}
