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
		// ������¼���new Runnable(���ü������ɼ�))��ӵ�awt���¼������̵߳���ȥ
		// awt���¼������̻߳ᰴ�ն��е�˳�����ε���ÿ����������¼�������
		// ʹ�ø÷�ʽ��ԭ���ǣ�awt�ǵ��߳�ģʽ�ģ�����awt�����ֻ����(�Ƽ���ʽ)�¼������߳��з��ʣ��Ӷ���֤���״̬�Ŀ�ȷ���ԡ�
		EventQueue.invokeLater(new Runnable() {
			// �������߳��޷���ʾ
			@Override
			public void run() {
				// TODO Auto-generated method stub
				Login login = new Login();
				login.setVisible(true);
			}
		});
	}

	/**
	 * �����߿�
	 */
	public Login() {
		// TODO Auto-generated constructor stub
		//��ӱ���
		setTitle("��¼ҳ��");
		//���õ���رհ�ť ֱ�ӹر�Ӧ�ó���
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���ô����С
		setBounds(350, 250, 450, 300);
		//ʵ���������
		contentPane = new JPanel() {
			//private static final long serialVersionUID = 1L;
			//��д�����������
			@Override
			public void paintComponent(Graphics g) {
				// TODO Auto-generated method stub
				super.paintComponent(g);

				// ���Ʊ���
				g.drawImage(new ImageIcon(
						"images\\��½����.jpg").getImage(), 0,
						0, getWidth(), getHeight(), null);
			}
		};
		//���ô�С����ӵ�������
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		//��ղ��ֹ�����, ֮��������������������������Ͻ�����������������Ͻǣ�0��0����x,yֵ��ȷ�������λ��
		contentPane.setLayout(null);
		
		//ʵ����������������
		textField = new JTextField();
		//���ô�С
		textField.setBounds(128, 153, 104, 21);
		//�����Ƿ�͸��
		textField.setOpaque(false);
		//�ѵ�ǰ�����ӵ������
		contentPane.add(textField);
		//�����ı��ֶ�����
		textField.setColumns(10);
		
		//ʵ����������������
		passwordField = new JPasswordField();
		//����ǰ��ɫ
		passwordField.setForeground(Color.BLACK);
		//������ʾ�ַ� �������ʱ����ʾ�ľ���*
		passwordField.setEchoChar('*');
		//�����Ƿ�͸��
		passwordField.setOpaque(false);
		//���ô�С��λ��
		passwordField.setBounds(128, 189, 104, 21);
		//��ӵ������
		contentPane.add(passwordField);
		
		//��¼��ť
		final JButton btnNewButton = new JButton();
		btnNewButton.setIcon(new ImageIcon("images\\��½.jpg"));
		btnNewButton.setBounds(246, 227, 50, 25);
		getRootPane().setDefaultButton(btnNewButton);
		contentPane.add(btnNewButton);
		
		//ע�ᰴť
		final JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setIcon(new ImageIcon("images\\ע��.jpg"));
		btnNewButton_1.setBounds(317, 227, 50, 25);
		contentPane.add(btnNewButton_1);

		// ��ʾ��Ϣ
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
				// ��ȡ�û�������ı�
				String u_name = textField.getText();
				if (file.length() != 0) {
					// ����ļ���������û�
					if (userPro.containsKey(u_name)) {
						// ��ȡ���������
						String u_pwd = new String(passwordField.getPassword());
						// ���������ȷ
						if (u_pwd.equals(userPro.getProperty(u_name))) {
							try {
								//����Socket
								Socket client = new Socket("Localhost", 8521);
								// ��ʾ�������
								btnNewButton.setEnabled(false);
								// ���ص���½����
								setVisible(false);
								//ʵ�����������
								Chatroom frame = new Chatroom(u_name, client);
								//���������ʾ
								frame.setVisible(true);

							} catch (UnknownHostException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							lblNewLabel.setText("���������������");
							textField.setText("");
							passwordField.setText("");
							textField.requestFocus();
						}
					} else {
						lblNewLabel.setText("�������ǳƲ����ڣ�");
						textField.setText("");
						passwordField.setText("");
						textField.requestFocus();
					}
				} else {
					lblNewLabel.setText("�������ǳƲ����ڣ�");
					textField.setText("");
					passwordField.setText("");
					textField.requestFocus();
				}
			}
		});

		// ע�ᰴť����
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1.setEnabled(false);
				Resign frame = new Resign();
				frame.setVisible(true);// ��ʾע�����
				setVisible(false);// ���ص���½����
			}
		});

	}
}
