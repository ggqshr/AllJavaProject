package com.qianfeng.login;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.qianfeng.bean.ClientBean;

public class Login extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	public static HashMap<String, ClientBean> onlines;

	public static void main(String[] args) {
		// 把这个事件（new Runnable(设置计算器可见))添加到awt的事件处理线程当中去
		// awt的事件处理线程会按照队列的顺序依次调用每个待处理的事件来运行
		// 使用该方式的原因是：awt是单线程模式的，所有awt的组件只能在(推荐方式)事件处理线程中访问，从而保证组件状态的可确定性。
		EventQueue.invokeLater(new Runnable() {
			// 不开启线程无法显示
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Login login = new Login();
				login.setVisible(true);
			}
		});
	}

	/**
	 * 创建边框
	 */
	public Login() {
		// TODO Auto-generated constructor stub
		//添加标题
		setTitle("登录页面");
		//设置点击关闭按钮 直接关闭应用程序
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗体大小
		setBounds(350, 250, 450, 300);
		//实例化面板类
		contentPane = new JPanel() {
			//private static final long serialVersionUID = 1L;
			//重写绘制组件函数
			@Override
			public void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);

				// 绘制背景
				g.drawImage(new ImageIcon(
						"images\\登陆界面.jpg").getImage(), 0,
						0, getWidth(), getHeight(), null);
			}
		};
		//设置大小并添加到窗口中
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//清空布局管理器, 之后添加组件，常常是设置组件左上角坐标相对于容器左上角（0，0）的x,y值来确定组件的位置
		contentPane.setLayout(null);
		
		//实例化输入框组件对象
		textField = new JTextField();
		//设置大小
		textField.setBounds(128, 153, 104, 21);
		//设置是否透明
		textField.setOpaque(false);
		//把当前组件添加到面板中
		contentPane.add(textField);
		//设置文本字段列数
		textField.setColumns(10);
		
		//实例化输入框组件对象
		passwordField = new JPasswordField();
		//设置前景色
		passwordField.setForeground(Color.BLACK);
		//设置提示字符 输密码的时候显示的就是*
		passwordField.setEchoChar('*');
		//设置是否透明
		passwordField.setOpaque(false);
		//设置大小和位置
		passwordField.setBounds(128, 189, 104, 21);
		//添加到面板中
		contentPane.add(passwordField);
		
		//登录按钮
		final JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("images\\登陆.jpg"));
		btnNewButton.setBounds(246, 227, 50, 25);
		getRootPane().setDefaultButton(btnNewButton);
		contentPane.add(btnNewButton);
		
		//注册按钮
		final JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon("images\\注册.jpg"));
		btnNewButton_1.setBounds(317, 227, 50, 25);
		contentPane.add(btnNewButton_1);

		// 提示信息
		final JLabel lblNewLabel = new JLabel();
		lblNewLabel.setBounds(60, 220, 151, 21);
		lblNewLabel.setForeground(Color.red);
		getContentPane().add(lblNewLabel);

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Properties userPro = new Properties();
				File file = new File("Users.Properties");
				// 如果文件没有
				if (!file.exists()) {
					try {
						// 新建文件
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					// 加载文件userPro对象中
					userPro.load(new FileInputStream(file));
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 获取用户输入框文本
				String u_name = textField.getText();
				if (file.length() != 0) {
					// 如果文件中有这个用户
					if (userPro.containsKey(u_name)) {
						// 获取输入框密码
						String u_pwd = new String(passwordField.getPassword());
						// 如果密码正确
						if (u_pwd.equals(userPro.getProperty(u_name))) {
							try {
								//创建Socket
								Socket client = new Socket("Localhost", 8521);
								// 显示聊天界面
								btnNewButton.setEnabled(false);
								// 隐藏掉登陆界面
								setVisible(false);
								//实例化聊天界面
								Chatroom frame = new Chatroom(u_name, client);
								//聊天界面显示
								frame.setVisible(true);

							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							lblNewLabel.setText("您输入的密码有误！");
							textField.setText("");
							passwordField.setText("");
							textField.requestFocus();
						}
					} else {
						lblNewLabel.setText("您输入昵称不存在！");
						textField.setText("");
						passwordField.setText("");
						textField.requestFocus();
					}
				} else {
					lblNewLabel.setText("您输入昵称不存在！");
					textField.setText("");
					passwordField.setText("");
					textField.requestFocus();
				}
			}
		});

		// 注册按钮监听
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setEnabled(false);
				Resign frame = new Resign();
				frame.setVisible(true);// 显示注册界面
				setVisible(false);// 隐藏掉登陆界面
			}
		});

	}
}
