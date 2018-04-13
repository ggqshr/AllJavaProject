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
	 * ���������б�
	 * */
	public static HashMap<String, ClientBean> onlines;
	static {
		try {
			//�������������ö˿�
			ss = new ServerSocket(8521);
			//ʵ���������б���
			onlines = new HashMap<String, ClientBean>();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class MyClientThread extends Thread {
		private Socket client;
		/**
		 * �ӿͻ��˻�ȡ�Ķ���
		 * */
		private UserBean bean;
		//����������
		private ObjectInputStream ois;
		//���������
		private ObjectOutputStream oos;
		/**
		 * ����
		 * @param client �ͻ���socket
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
				// ��ͣ�Ĵӿͻ��˽�����Ϣ
				while (true) {
					// ��ȡ�ӿͻ��˽��յ���catbean��Ϣ
					ois = new ObjectInputStream(client.getInputStream());
					//�ӿͻ��˵��������ж�ȡ����
					bean=(UserBean) ois.readObject();
					System.out.println("bean="+bean.toString());
					// ����catbean�У�type������һ������
					switch (bean.getType()) {
					// �����߸���
					case 0: // ����
						// ��¼���߿ͻ����û����Ͷ˿���clientbean��<���߿ͻ����б���>
						ClientBean cbean=new ClientBean();
						//�����û���
						cbean.setName(bean.getName());
						//��¼�û���socket
						cbean.setSocket(client);
						
						// ��������û�
						onlines.put(bean.getName(), cbean);
						// �´�����������userbean�������͸��ͻ���
						UserBean user=new UserBean();
						//������Ϣ����
						user.setType(0);
						//����֪ͨ��Ϣ
						user.setInfo(bean.getTimer()+"  "+bean.getName()+"������");
						//֪ͨ�����û���������
						HashSet<String> set = new HashSet<String>();
						// ����ͻ��ǳ�
						set.addAll(onlines.keySet());
						user.setClients(set);
						//�������ߵ������û�
						sendAll(user);
						
						break;
					case -1://����
						//��װһ�����ߵ��û�
						UserBean serverBean=new UserBean();
						serverBean.setType(-1);
						oos=new ObjectOutputStream(client.getOutputStream());
						//��һ������Objд�����������Ŀ�ĵ�
						oos.writeObject(serverBean);
						oos.flush();
						//�Ƴ������б������ߵ��û�
						onlines.remove(bean.getName());
						
						//��ʣ�µ������û����������뿪��֪ͨ
						UserBean serverBean2=new UserBean();	
						serverBean2.setInfo(bean.getTimer() + "  "
								+ bean.getName() + " " + " ������");
						serverBean2.setType(0);
						
						HashSet<String> set1 = new HashSet<String>();
						set1.addAll(onlines.keySet());
						serverBean2.setClients(set1);
						
						sendAll(serverBean2);
						//һ��Ҫreturn  ��Ȼ�޷�����ѭ���˳�ѭ��
						return;
					case 1://����
						UserBean serverBean3=new UserBean();
						serverBean3.setName(bean.getName());
						serverBean3.setClients(bean.getClients());
						serverBean3.setType(1);
						serverBean3.setInfo(bean.getInfo());
						serverBean3.setTimer(bean.getTimer());
						//��ѡ�еĿͻ��˷�����Ϣ
						sendMessage(serverBean3);
						break;
					case 2:// �õ������ļ�������  ֪ͨҪ���͵��û� ����һ��״̬  2
						// ������������Userbean�������͸��ͻ���
					
						UserBean serverBean4=new UserBean();
						String info = bean.getTimer() + "  " + bean.getName()
								+ "���㴫���ļ�,�Ƿ���Ҫ����";
						serverBean4.setType(2);
						serverBean4.setClients(bean.getClients()); // ���Ƿ��͵�Ŀ�ĵ�
						serverBean4.setFileName(bean.getFileName()); // �ļ�����
						serverBean4.setSize(bean.getSize()); // �ļ���С
						serverBean4.setInfo(info);
						serverBean4.setName(bean.getName()); // ��Դ
						serverBean4.setTimer(bean.getTimer());
						// ��ѡ�еĿͻ���������
						sendMessage(serverBean4);
						break;
					case 3:// ȷ�������ļ�
						UserBean serverBean5=new UserBean();
						serverBean5.setType(3);
						serverBean5.setClients(bean.getClients()); // �ļ���Դ
						serverBean5.setTo(bean.getTo()); // �ļ�Ŀ�ĵ�
						serverBean5.setFileName(bean.getFileName()); // �ļ�����
						serverBean5.setIp(bean.getIp());
						serverBean5.setPort(bean.getPort());
						serverBean5.setName(bean.getName()); // ���յĿͻ�����
						serverBean5.setTimer(bean.getTimer());
						// ֪ͨ�ļ���Դ�Ŀͻ����Է�ȷ�������ļ�
						sendMessage(serverBean5);
						break;
					case 4:
						UserBean serverBean6 = new UserBean();

						serverBean6.setType(4);
						serverBean6.setClients(bean.getClients()); // �ļ���Դ
						serverBean6.setTo(bean.getTo()); // �ļ�Ŀ�ĵ�
						serverBean6.setFileName(bean.getFileName());
						serverBean6.setInfo(bean.getInfo());
						serverBean6.setName(bean.getName());// ���յĿͻ�����
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
		 * �ر����Ϳͻ��˵ķ��� 
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
	 * �����е��û���������
	 * 
	 * */
	public void sendAll(UserBean serverBean){
		//��ȡ���������û�
		Collection<ClientBean> clients = onlines.values();
		//����������
		Iterator<ClientBean> it = clients.iterator();
		//���������
		ObjectOutputStream oos;
		//�����û��б�
		while (it.hasNext()) {
			//��ȡsocket
			Socket c=it.next().getSocket();
			try {
				//��װ�ɶ��������
				oos=new ObjectOutputStream(c.getOutputStream());
				//�����serverBean ��ÿ���û����������ߵ���Ϣ֪ͨ
				oos.writeObject(serverBean);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * ��ѡ���û���������
	 * */
	private void sendMessage(UserBean serverBean){
		// ����ȡ�����е�values
		Set<String> cbs = onlines.keySet();
		Iterator<String> it = cbs.iterator();
		// ѡ�пͻ�
		HashSet<String> clients = serverBean.getClients();
		while (it.hasNext()) {
			// ���߿ͻ�
			String client=it.next();
			// ѡ�еĿͻ����������ߵģ��ͷ���serverbean
			if(clients.contains(client)){
				Socket c=onlines.get(client).getSocket();
				ObjectOutputStream oos;
				try {
					//��ѡ�еĿͻ�����ͨ�����·�����͹�ȥ
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
	
	//�����̺߳ͶԽ�Socket�ĺ���
	public void start() {
		try {
			while (true) {
				//ServerSocket���ص���һ��Socket�����Socket�ǿͻ��˵ġ��Դ�ServerSocket��Socket���Կ�ʼ�����������ͨѶ
				Socket client = ss.accept();
				//��ʼ�߳�
				new MyClientThread(client).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�������
	public static void main(String[] args) {
		//ִ�е�ǰ��start����
		new MyServer().start();
	}
}
