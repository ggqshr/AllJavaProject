package com.qianfeng.login;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import com.qianfeng.bean.UserBean;
import com.qianfeng.utils.CatUtil;

public class Chatroom extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5919436252486013798L;
	// �����
	private static JPanel contentPane;
	// �ͻ���Socket
	private static Socket clientSocket;
	// ���������
	private static ObjectOutputStream oos;
	// ����������
	private static ObjectInputStream ois;
	// ��ǰ�ͻ����û���
	private static String name;
	// ����������ʾ����
	private JTextArea textArea;
	// ������
	private JProgressBar progressBar;
	// �ļ�������ʾ
	private JLabel lblNewLabel;
	// ��Ϣ��ʾ�����ļ�
	private File file;
	// ��ʾ�����ļ�URL��ַ
	private URL cb;
	// ����Ƭ�ζ���
	private AudioClip aau;
	// ������ʾ�����ļ�
	private File file2;
	// ���������ļ�URL��ַ
	private URL cb2;
	// ����Ƭ�ζ���
	private AudioClip aau2;
	// �����û��б�
	private Vector onlines;
	// ListModel������
	private UUListModel listmodel;
	// ���ڷ����ļ�
	private static boolean isSendFile = false;
	// ���ڽ����ļ�
	private static boolean isReceiveFile = false;
	/**
	 * �б����
	 * */
	private JList list;
	// ���ض�ȡ�ÿͻ��ղ�ѡ�е��ļ�·��
	protected String filePath;

	/**
	 * ���캯��
	 * 
	 * @param u_name
	 *            �û���
	 * @param client
	 *            �ͻ���socket
	 * */
	public Chatroom(String u_name, Socket client) {
		// TODO Auto-generated constructor stub
		// ��ֵ
		name = u_name;
		clientSocket = client;
		onlines = new Vector();
		// ˢ������UI
		SwingUtilities.updateComponentTreeUI(this);
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �������
		setTitle(name);
		// �ɵ�����С
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 688, 510);
		contentPane = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(new ImageIcon("images\\������1.jpg").getImage(), 0, 0,
						getWidth(), getHeight(), null);
			}

		};
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// ������Ϣ��ʾ����
		// JScrollPane������
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 410, 300);
		getContentPane().add(scrollPane);

		// ����������Ϣ �ı��ؼ�
		textArea = new JTextArea();
		textArea.setEditable(false);
		// �����Զ����й���
		textArea.setLineWrap(true);
		// ������в����ֹ���
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("sdf", Font.BOLD, 13));
		// ��ӵ���������
		scrollPane.setViewportView(textArea);

		// �������������
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 347, 411, 97);
		getContentPane().add(scrollPane_1);
		//���������ı�
		final JTextArea textArea_1 = new JTextArea();
		// �����Զ����й���
		textArea_1.setLineWrap(true);
		// ������в����ֹ���
		textArea_1.setWrapStyleWord(true);
		//��Ӵ������򵽴��ֹ�������
		scrollPane_1.setViewportView(textArea_1);

		// �رհ�ť
		final JButton btnNewButton = new JButton("�ر�");
		btnNewButton.setBounds(214, 448, 60, 30);
		getContentPane().add(btnNewButton);

		// ���Ͱ�ť
		JButton btnNewButton_1 = new JButton("����");
		btnNewButton_1.setBounds(313, 448, 60, 30);
		getRootPane().setDefaultButton(btnNewButton_1);
		getContentPane().add(btnNewButton_1);

		// ���߿ͻ��б�
		listmodel = new UUListModel(onlines);
		// ��ListModel�������Jlist������
		list = new JList(listmodel);
		// �����б��Զ�����ʽ
		list.setCellRenderer(new CellRenderer());

		list.setOpaque(false);
		// ��ȡͨ�������߿�ĵĹ����ഴ��ʴ��ʽ�߿�
		Border etch = BorderFactory.createEtchedBorder();
		// �����б߿����һ�����⣬ָ���˱����ı�����λ�á��������ɫ��
		// �߿�, ����, ����(Ĭ�ϵ���), λ��, ����, ��ɫ
		list.setBorder(BorderFactory.createTitledBorder(etch, "<" + u_name
				+ ">" + "���߿ͻ�:", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("sdf", Font.BOLD, 20), Color.green));
		
		// �б�����
		JScrollPane scrollPane_2 = new JScrollPane(list);
		scrollPane_2.setBounds(430, 10, 245, 375);
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setOpaque(false);
		getContentPane().add(scrollPane_2);
		try {

			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			// ��¼���߿ͻ�����Ϣ��userbean�У������͸�������
			UserBean bean = new UserBean();
			bean.setType(0);
			bean.setName(name);
			
			bean.setTimer(CatUtil.getTimer());
			oos.writeObject(bean);
			oos.flush();

			// ��Ϣ��ʾ����
			file = new File("sounds\\��ŷ.wav");
			// ת��URL
			cb = file.toURL();
			// ͨ��URL�õ�����Ƭ�ζ���
			aau = Applet.newAudioClip(cb);
			// ������ʾ����
			file2 = new File("sounds\\��.wav");
			cb2 = file2.toURL();
			aau2 = Applet.newAudioClip(cb2);

			// �����ͻ������߳�
			new ClientInputThread().start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// �ļ�������
		progressBar = new JProgressBar();
		progressBar.setBounds(430, 390, 245, 15);
		progressBar.setMinimum(1);
		progressBar.setMaximum(100);
		getContentPane().add(progressBar);

		// �ļ�������ʾ
		lblNewLabel = new JLabel("\u6587\u4EF6\u4F20\u9001\u4FE1\u606F\u680F:");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(430, 410, 245, 15);
		getContentPane().add(lblNewLabel);

		// ���Ͱ�ť
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = textArea_1.getText();
				List to = list.getSelectedValuesList();
				//���û��ѡ���������
				if (to.size() < 1) {
					JOptionPane.showMessageDialog(getContentPane(), "��ѡ���������");
					return;
				}
				//���ѡ�е����Լ�
				if (to.toString().contains(name + "(��)")) {
					JOptionPane
							.showMessageDialog(getContentPane(), "�������Լ�������Ϣ");
					return;
				}
				//���������ϢΪ��
				if (info.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "���ܷ��Ϳ���Ϣ");
					return;
				}
				//�����ݷ�װ��������  
				UserBean clientBean = new UserBean(); 
				clientBean.setType(1);
				clientBean.setName(name);
				String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date());
				clientBean.setTimer(time);
				clientBean.setInfo(info);
				HashSet set = new HashSet();
				set.addAll(to);
				clientBean.setClients(set);

				// �Լ���������ҲҪ��ʵ���Լ�����Ļ����
				textArea.append(time + " �Ҷ�" + to + "˵:\r\n" + info + "\r\n");
				//�Ѷ����͵���������  �ɷ���������״̬�ж�������Ӧ����
				sendMessage(clientBean);
				textArea_1.setText(null);
				textArea_1.requestFocus();
			}
		});
		// �뿪
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				if (isSendFile || isReceiveFile) {
					JOptionPane.showMessageDialog(contentPane,
							"���ڴ����ļ��У��������뿪...", "Error Message",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(
							getContentPane(), "��ȷ��Ҫ�뿪������");
					if (result == 0) {
						UserBean clientBean = new UserBean();
						clientBean.setType(-1);
						clientBean.setName(name);
						clientBean.setTimer(new SimpleDateFormat(
								"yyyy-MM-dd HH:mm:ss").format(new Date()));
						sendMessage(clientBean);
					}
				}
			}
		});
		// �б����
		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				// �����б��е���������˳�򷵻�����ѡ������б�. 
				List to = list.getSelectedValuesList();
				// ˫��
				if (e.getClickCount() == 2) {
					//���ѡ�е����Լ�
					if (to.toString().contains(name + "��")) {
						JOptionPane.showMessageDialog(getContentPane(),
								"�������Լ������ļ�");
						return;
					}
					// ˫�����ļ��ļ�ѡ���
					JFileChooser chooser = new JFileChooser();
					chooser.setDialogTitle("ѡ���ļ���");// ����Ŷ..
					chooser.showDialog(getContentPane(), "ѡ��");// ���ǰ�ť������..
					// �ж��Ƿ�ѡ�����ļ�
					if (chooser.getSelectedFile() != null) {
						// ��ȡ·��
						filePath = chooser.getSelectedFile().getPath();
						File file = new File(filePath);
						// �ļ�Ϊ��
						if (file.length() == 0) {
							JOptionPane.showMessageDialog(getContentPane(),
									filePath + "�ļ�Ϊ��,��������.");
							return;
						}
						// ���͸������� Ҫ�����ļ� ��������˭��˭����
						UserBean bean = new UserBean();
						bean.setType(2);// �������ļ�
						bean.setSize(new Long(file.length()).intValue());
						bean.setName(name);
						bean.setFileName(file.getName()); // ��¼�ļ�������
						bean.setTimer(CatUtil.getTimer());
						bean.setInfo("�������ļ�");
						// �ж�Ҫ���͸�˭
						HashSet<String> set = new HashSet<String>();
						set.addAll(list.getSelectedValuesList());
						bean.setClients(set);
						sendMessage(bean);
					}

				}
			}
		});
	}
	
	/**
	 * �ͻ������߳�
	 * */
	class ClientInputThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 super.run();
			try {
				// ��ͣ�Ĵӷ�����������Ϣ
				while (true) {
					InputStream is = clientSocket.getInputStream();
					//��װ����������
					ois = new ObjectInputStream(is);
					//��ȡ�ӷ�����������������
					final UserBean bean = (UserBean) ois.readObject();
					System.out.println(bean.getType() + "type");
					//�ж�״̬
					// 1˽�� 0�����߸��� -1�������� 2�������ļ� 3.ȷ�������ļ�4.����
					switch (bean.getType()) {
					case 0: {
						// �����б�
						onlines.clear();
						HashSet<String> clients = bean.getClients();
						Iterator<String> it = clients.iterator();
						while (it.hasNext()) {
							String ele = it.next();
							if (name.equals(ele)) {
								onlines.add(ele + "(��)");
							} else {
								onlines.add(ele);
							}
						}
						//���������б�
						listmodel = new UUListModel(onlines);
						list.setModel(listmodel);
						//������������
						aau2.play();
						
						textArea.append(bean.getInfo() + "\r\n");
						textArea.selectAll();

						break;
					}
					case -1: {
						
						return;
					}
					
					case 1: {
						//������Ϣ
						String info = bean.getTimer() + "  " + bean.getName()
								+ " �� " + bean.getClients() + "˵:\r\n";
						if (info.contains(name)) {
							info = info.replace(name, "��");
						}
						aau.play();
						textArea.append(info + bean.getInfo() + "\r\n");
						textArea.selectAll();
						break;
					}
					case 2: {
						// ���ڵȴ�Ŀ��ͻ�ȷ���Ƿ�����ļ��Ǹ�����״̬�������������̴߳���
						new Thread() {
							public void run() {
								// ��ʾ�Ƿ�����ļ��Ի���
								int result = JOptionPane.showConfirmDialog(
										getContentPane(), bean.getInfo());
								switch (result) {
								case 0: // �����ļ�
								{
									JFileChooser chooser = new JFileChooser();
									chooser.setDialogTitle("�����ļ���"); // ����Ŷ...
									// Ĭ���ļ����ƻ��з��ڵ�ǰĿ¼��
									chooser.setSelectedFile(new File(bean
											.getFileName()));
									chooser.showDialog(getContentPane(), "����"); // ���ǰ�ť������..
									// ����·��
									String saveFilePath = chooser
											.getSelectedFile().toString();
									// �����ͻ�UserBean
									UserBean clientBean = new UserBean();
									clientBean.setType(3);
									clientBean.setName(name); // �����ļ��Ŀͻ�����
									clientBean.setTimer(CatUtil.getTimer());
									clientBean.setFileName(saveFilePath);
									clientBean.setInfo("ȷ�������ļ�");

									// �ж�Ҫ���͸�˭
									HashSet<String> set = new HashSet<String>();
									set.add(bean.getName());
									clientBean.setClients(set); // �ļ���Դ
									clientBean.setTo(bean.getClients());// ����Щ�ͻ������ļ�

									// �����µ�tcp socket ��������, ���Ƕ������ӵĹ���, ���������...
									try {
										ServerSocket ss = new ServerSocket(0); // 0���Ի�ȡ���еĶ˿ں�

										clientBean.setIp(clientSocket
												.getInetAddress()
												.getHostAddress());
										clientBean.setPort(ss.getLocalPort());
										sendMessage(clientBean); // ��ͨ�����������߷��ͷ�,
																	// �����ֱ�ӷ����ļ�����������...

										isReceiveFile = true;
										// �ȴ��ļ���Դ�Ŀͻ��������ļ�....Ŀ��ͻ��������϶�ȡ�ļ�����д�ڱ�����
										Socket sk = ss.accept();
										textArea.append(CatUtil.getTimer()
												+ "  " + bean.getFileName()
												+ "�ļ�������.\r\n");
										DataInputStream dis = new DataInputStream( // �������϶�ȡ�ļ�
												new BufferedInputStream(
														sk.getInputStream()));
										DataOutputStream dos = new DataOutputStream( // д�ڱ�����
												new BufferedOutputStream(
														new FileOutputStream(
																saveFilePath)));

										int count = 0;
										int num = bean.getSize() / 100;
										int index = 0;
										while (count < bean.getSize()) {
											int t = dis.read();
											dos.write(t);
											count++;

										if (num > 0) {
											if (count % num == 0&& index < 100) {
												progressBar
															.setValue(++index);
												}
												lblNewLabel.setText("���ؽ���:"
														+ count + "/"
														+ bean.getSize()
														+ "  ����" + index + "%");
											} else {
												lblNewLabel
														.setText("���ؽ���:"+ count+ "/"+ bean.getSize()	+ "  ����:"
																+ new Double(new Double(count).doubleValue()/ new Double(
																						bean.getSize()).doubleValue()
																				* 100).intValue()+ "%");
												if (count == bean.getSize()) {
													progressBar.setValue(100);
												}
											}

										}

										// ���ļ���Դ�ͻ�������ʾ���ļ��������
										PrintWriter out = new PrintWriter(
												sk.getOutputStream(), true);
										out.println(CatUtil.getTimer() + " ���͸�"
												+ name + "���ļ�["
												+ bean.getFileName() + "]"
												+ "�ļ��������.\r\n");
										//ˢ����
										out.flush();
										dos.flush();
										dos.close();
										//�ر���
										out.close();
										dis.close();
										//�ر�Socket
										sk.close();
										ss.close();
										textArea.append(CatUtil.getTimer()
												+ "  " + bean.getFileName()
												+ "�ļ��������.���λ��Ϊ:"
												+ saveFilePath + "\r\n");
										isReceiveFile = false;
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}

									break;

								default: {// ����
									UserBean clientBean = new UserBean();
									clientBean.setType(4);
									clientBean.setName(name); // �����ļ��Ŀͻ�����
									clientBean.setTimer(CatUtil.getTimer());
									clientBean.setFileName(bean.getFileName());
									clientBean.setInfo(CatUtil.getTimer()
											+ "  " + name + "ȡ�������ļ�["
											+ bean.getFileName() + "]");

									// �ж�Ҫ���͸�˭
									HashSet<String> set = new HashSet<String>();
									set.add(bean.getName());
									clientBean.setClients(set); // �ļ���Դ
									clientBean.setTo(bean.getClients());// ����Щ�ͻ������ļ�

									sendMessage(clientBean);
									break;
								}

								}
							};
						}.start();
						break;
					}
					case 3: {
						// Ŀ��ͻ�Ը������ļ���Դ�ͻ���ʼ��ȡ�����ļ������͵�������
						textArea.append(bean.getTimer() + "  " + bean.getName()
								+ "ȷ�������ļ�" + ",�ļ�������..\r\n");
						new Thread() {
							public void run() {

								try {
									isSendFile = true;
									// ����Ҫ�����ļ��Ŀͻ��׽���
									Socket s = new Socket(bean.getIp(),
											bean.getPort());
									DataInputStream dis = new DataInputStream(
											new FileInputStream(filePath)); // ���ض�ȡ�ÿͻ��ղ�ѡ�е��ļ�
									DataOutputStream dos = new DataOutputStream(
											new BufferedOutputStream(
													s.getOutputStream())); // ����д���ļ�

									int size = dis.available();

									int count = 0; // ��ȡ����
									int num = size / 100;
									int index = 0;
									while (count < size) {

										int t = dis.read();
										dos.write(t);
										count++; // ÿ��ֻ��ȡһ���ֽ�

										if (num > 0) {
											if (count % num == 0 && index < 100) {
												progressBar.setValue(++index);

											}
											lblNewLabel.setText("�ϴ�����:" + count
													+ "/" + size + "  ����"
													+ index + "%");
										} else {
											lblNewLabel.setText("�ϴ�����:"+ count+ "/"+ size+ "  ����:"+
										
									new Double(new Double(count).doubleValue()/ new Double(size).doubleValue()* 100).intValue()
															+ "%");
											if (count == size) {
												
												progressBar.setValue(100);
											}
										}
									}
									dos.flush();
									dis.close();
									// ��ȡĿ��ͻ�����ʾ������ϵ���Ϣ...
									BufferedReader br = new BufferedReader(
											new InputStreamReader(
													s.getInputStream()));
									textArea.append(br.readLine() + "\r\n");
									isSendFile = false;
									br.close();
									s.close();
								} catch (Exception ex) {
									ex.printStackTrace();
								}

							};
						}.start();

						break;
					}
					case 4: {
						textArea.append(bean.getInfo() + "\r\n");
						break;
					}
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
			} finally {

				if (clientSocket != null) {
					try {
						clientSocket.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				System.exit(0);

			}
		}
	}

	/** ��������������Ϣ */
	private void sendMessage(UserBean clientBean) {
		try {
			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			oos.writeObject(clientBean);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

/**
 * ����ListModel����JList
 * */
class UUListModel extends AbstractListModel {

	private Vector vs;

	public UUListModel(Vector vs) {
		this.vs = vs;
	}

	@Override
	public Object getElementAt(int index) {
		// TODO Auto-generated method stub
		return vs.get(index);
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return vs.size();
	}

}

/**
 * ʵ�ֽӿ�ListCellRenderer�Զ���JList����ʾģʽ
 * */
class CellRenderer extends JLabel implements ListCellRenderer {
	public CellRenderer() {
		// TODO Auto-generated constructor stub
		// �Ƿ�͸��
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));// ������Ϊ5�Ŀհױ߿�

		if (value != null) {
			setText(value.toString());
			setIcon(new ImageIcon("images//1.jpg"));
		}
		if (isSelected) {
			setBackground(new Color(255, 255, 153));// ���ñ���ɫ
			setForeground(Color.black);
		} else {
			// ����ѡȡ��ȡ��ѡȡ��ǰ���뱳����ɫ.
			setBackground(Color.white); // ���ñ���ɫ
			setForeground(Color.black);
		}
		setEnabled(list.isEnabled());
		setFont(new Font("sdf", Font.ROMAN_BASELINE, 13));
		setOpaque(true);
		return this;
	}
}
