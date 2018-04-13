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
	
	// �������
	private JPanel contentPane;
	// �ʺ�
	private JTextField textField;
	// ����
	private JPasswordField passwordField;
	// �ظ�����
	private JPasswordField passwordField_1;
	// ��ʾ
	private JLabel lblNewLabel;

	public Resign() {
		// TODO Auto-generated constructor stub
		setTitle("ע�����\n");
		// ����Ĭ�Ϲرհ�ť
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
		//���ñ߿�
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//�ʺ�
		textField = new JTextField();
		textField.setBounds(150, 42, 104, 21);
		textField.setOpaque(false);
		contentPane.add(textField);
		textField.setColumns(10);
		//����
		passwordField = new JPasswordField();
		passwordField.setEchoChar('*');
		passwordField.setOpaque(false);
		passwordField.setBounds(190, 98, 104, 21);
		contentPane.add(passwordField);
		//��д����
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(192, 152, 104, 21);
		passwordField_1.setOpaque(false);
		contentPane.add(passwordField_1);

		// ע�ᰴť
		final JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon("images\\ע��1.jpg"));
		btnNewButton_1.setBounds(320, 198, 80, 40);
		getRootPane().setDefaultButton(btnNewButton_1);
		contentPane.add(btnNewButton_1);

		// ���ذ�ť
		final JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("images\\����.jpg"));
		btnNewButton.setBounds(230, 198, 80, 40);
		contentPane.add(btnNewButton);

		// ��ʾ��Ϣ
		lblNewLabel = new JLabel();
		lblNewLabel.setBounds(55, 218, 185, 20);
		lblNewLabel.setForeground(Color.red);
		contentPane.add(lblNewLabel);

		// ���ذ�ť����
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(false);
				// ���ص�½����
				Login frame = new Login();
				frame.setVisible(true);
				setVisible(false);
			}
		});

		// ע�ᰴť����
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				//����Properties����
				Properties userPro = new Properties();
				File file = new File("Users.properties");
				// ����ļ�û��
				if (!file.exists()) {
					try {
						// �½��ļ�
						file.createNewFile();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					// �����ļ�userPro������
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
				// �ж��û����Ƿ�����ͨ�û����Ѵ���
				if (u_name.length() != 0) {
					if (userPro.containsKey(u_name)) {
						lblNewLabel.setText("�û����Ѵ���!");
					} else {
						isPassword(userPro, file, u_name, u_pwd, u_pwd_ag);
					}
				} else {
					lblNewLabel.setText("�û�������Ϊ�գ�");
				}

			}
			//�ж������Ƿ���ȷ
			private void isPassword(Properties userPro, File file, String u_name,
					String u_pwd, String u_pwd_ag) {
				// �ж���������������Ƿ���ͬ
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
						// ���ص�½����
						Login frame = new Login();
						frame.setVisible(true);
						setVisible(false);
					} else {
						lblNewLabel.setText("����Ϊ�գ�");
					}

				} else {
					lblNewLabel.setText("���벻һ�£�");
				}
			}
		});
	}
}
