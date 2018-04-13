package com.qianfeng.login;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Resign extends JFrame {
	
	// 界面面板
	private JPanel contentPane;
	// 帐号
	private JTextField textField;
	// 密码
	private JPasswordField passwordField;
	// 重复密码
	private JPasswordField passwordField_1;
	// 提示
	private JLabel lblNewLabel;

	public Resign() {
		// TODO Auto-generated constructor stub
		setTitle("注册界面\n");
		// 设置默认关闭按钮
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(350, 250, 450, 300);
		
		contentPane = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(new ImageIcon(
						"images\\\u6CE8\u518C\u754C\u9762.jpg").getImage(), 0,
						0, getWidth(), getHeight(), null);
			}
		};
		//设置边框
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//帐号
		textField = new JTextField();
		textField.setBounds(150, 42, 104, 21);
		textField.setOpaque(false);
		contentPane.add(textField);
		textField.setColumns(10);
		//密码
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setOpaque(false);
		passwordField.setBounds(190, 98, 104, 21);
		contentPane.add(passwordField);
		//重写密码
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(192, 152, 104, 21);
		passwordField_1.setOpaque(false);
		contentPane.add(passwordField_1);

		// 注册按钮
		final JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon("images\\注册1.jpg"));
		btnNewButton_1.setBounds(320, 198, 80, 40);
		getRootPane().setDefaultButton(btnNewButton_1);
		contentPane.add(btnNewButton_1);

		// 返回按钮
		final JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("images\\返回.jpg"));
		btnNewButton.setBounds(230, 198, 80, 40);
		contentPane.add(btnNewButton);

		// 提示信息
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(55, 218, 185, 20);
		lblNewLabel.setForeground(Color.red);
		contentPane.add(lblNewLabel);

		// 返回按钮监听
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(false);
				// 返回登陆界面
				Login frame = new Login();
				frame.setVisible(true);
				setVisible(false);
			}
		});

		// 注册按钮监听
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//创建Properties对象
				Properties userPro = new Properties();
				File file = new File("Users.properties");
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

				String u_name = textField.getText();
				String u_pwd = new String(passwordField.getPassword());
				String u_pwd_ag = new String(passwordField_1.getPassword());
				// 判断用户名是否在普通用户中已存在
				if (u_name.length() != 0) {
					if (userPro.containsKey(u_name)) {
						lblNewLabel.setText("用户名已存在!");
					} else {
						isPassword(userPro, file, u_name, u_pwd, u_pwd_ag);
					}
				} else {
					lblNewLabel.setText("用户名不能为空！");
				}

			}
			//判断密码是否正确
			private void isPassword(Properties userPro, File file, String u_name,
					String u_pwd, String u_pwd_ag) {
				// 判断两次输入的密码是否相同
				if (u_pwd.equals(u_pwd_ag)) {
					if (u_pwd.length() != 0) {
						userPro.setProperty(u_name, u_pwd_ag);
						try {
							userPro.store(new FileOutputStream(file),
									"Copyright (c) Boxcode Studio");
							
						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}
						btnNewButton_1.setEnabled(false);
						// 返回登陆界面
						Login frame = new Login();
						frame.setVisible(true);
						setVisible(false);
					} else {
						lblNewLabel.setText("密码为空！");
					}

				} else {
					lblNewLabel.setText("密码不一致！");
				}
			}
		});
	}
}
