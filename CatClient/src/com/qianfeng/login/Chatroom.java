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
	// 面板类
	private static JPanel contentPane;
	// 客户端Socket
	private static Socket clientSocket;
	// 对象输出流
	private static ObjectOutputStream oos;
	// 对象输入流
	private static ObjectInputStream ois;
	// 当前客户端用户名
	private static String name;
	// 聊天区域显示文字
	private JTextArea textArea;
	// 进度条
	private JProgressBar progressBar;
	// 文件传输提示
	private JLabel lblNewLabel;
	// 消息提示音乐文件
	private File file;
	// 提示音乐文件URL地址
	private URL cb;
	// 音乐片段对象
	private AudioClip aau;
	// 上线提示音乐文件
	private File file2;
	// 上线音乐文件URL地址
	private URL cb2;
	// 音乐片段对象
	private AudioClip aau2;
	// 在线用户列表
	private Vector onlines;
	// ListModel构造器
	private UUListModel listmodel;
	// 正在发送文件
	private static boolean isSendFile = false;
	// 正在接受文件
	private static boolean isReceiveFile = false;
	/**
	 * 列表组件
	 * */
	private JList list;
	// 本地读取该客户刚才选中的文件路径
	protected String filePath;

	/**
	 * 构造函数
	 * 
	 * @param u_name
	 *            用户名
	 * @param client
	 *            客户端socket
	 * */
	public Chatroom(String u_name, Socket client) {
		// TODO Auto-generated constructor stub
		// 赋值
		name = u_name;
		clientSocket = client;
		onlines = new Vector();
		// 刷新整个UI
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
		// 创建面板
		setTitle(name);
		// 可调整大小
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 100, 688, 510);
		contentPane = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(new ImageIcon("images\\聊天室1.jpg").getImage(), 0, 0,
						getWidth(), getHeight(), null);
			}

		};
		setContentPane(contentPane);
		contentPane.setLayout(null);
		// 聊天信息显示区域
		// JScrollPane滚动条
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 410, 300);
		getContentPane().add(scrollPane);

		// 多人聊天信息 文本控件
		textArea = new JTextArea();
		textArea.setEditable(false);
		// 激活自动换行功能
		textArea.setLineWrap(true);
		// 激活断行不断字功能
		textArea.setWrapStyleWord(true);
		textArea.setFont(new Font("sdf", Font.BOLD, 13));
		// 添加到滚动条中
		scrollPane.setViewportView(textArea);

		// 打字区域滚动条
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 347, 411, 97);
		getContentPane().add(scrollPane_1);
		//打字区域文本
		final JTextArea textArea_1 = new JTextArea();
		// 激活自动换行功能
		textArea_1.setLineWrap(true);
		// 激活断行不断字功能
		textArea_1.setWrapStyleWord(true);
		//添加打字区域到打字滚动条中
		scrollPane_1.setViewportView(textArea_1);

		// 关闭按钮
		final JButton btnNewButton = new JButton("关闭");
		btnNewButton.setBounds(214, 448, 60, 30);
		getContentPane().add(btnNewButton);

		// 发送按钮
		JButton btnNewButton_1 = new JButton("发送");
		btnNewButton_1.setBounds(313, 448, 60, 30);
		getRootPane().setDefaultButton(btnNewButton_1);
		getContentPane().add(btnNewButton_1);

		// 在线客户列表
		listmodel = new UUListModel(onlines);
		// 把ListModel对象放在Jlist构造中
		list = new JList(listmodel);
		// 设置列表自定义样式
		list.setCellRenderer(new CellRenderer());

		list.setOpaque(false);
		// 获取通过创建边框的的工厂类创建蚀刻式边框
		Border etch = BorderFactory.createEtchedBorder();
		// 向现有边框添加一个标题，指定了标题文本及其位置、字体和颜色。
		// 边框, 标题, 对齐(默认调整), 位置, 字体, 颜色
		list.setBorder(BorderFactory.createTitledBorder(etch, "<" + u_name
				+ ">" + "在线客户:", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("sdf", Font.BOLD, 20), Color.green));
		
		// 列表区域
		JScrollPane scrollPane_2 = new JScrollPane(list);
		scrollPane_2.setBounds(430, 10, 245, 375);
		scrollPane_2.setOpaque(false);
		scrollPane_2.getViewport().setOpaque(false);
		getContentPane().add(scrollPane_2);
		try {

			oos = new ObjectOutputStream(clientSocket.getOutputStream());
			// 记录上线客户的信息在userbean中，并发送给服务器
			UserBean bean = new UserBean();
			bean.setType(0);
			bean.setName(name);
			
			bean.setTimer(CatUtil.getTimer());
			oos.writeObject(bean);
			oos.flush();

			// 消息提示声音
			file = new File("sounds\\呃欧.wav");
			// 转换URL
			cb = file.toURL();
			// 通过URL得到声音片段对象
			aau = Applet.newAudioClip(cb);
			// 上线提示声音
			file2 = new File("sounds\\叮.wav");
			cb2 = file2.toURL();
			aau2 = Applet.newAudioClip(cb2);

			// 启动客户接收线程
			new ClientInputThread().start();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// 文件传输栏
		progressBar = new JProgressBar();
		progressBar.setBounds(430, 390, 245, 15);
		progressBar.setMinimum(1);
		progressBar.setMaximum(100);
		getContentPane().add(progressBar);

		// 文件传输提示
		lblNewLabel = new JLabel("\u6587\u4EF6\u4F20\u9001\u4FE1\u606F\u680F:");
		lblNewLabel.setFont(new Font("SimSun", Font.PLAIN, 12));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(430, 410, 245, 15);
		getContentPane().add(lblNewLabel);

		// 发送按钮
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String info = textArea_1.getText();
				List to = list.getSelectedValuesList();
				//如果没有选中聊天对象
				if (to.size() < 1) {
					JOptionPane.showMessageDialog(getContentPane(), "请选择聊天对象");
					return;
				}
				//如果选中的是自己
				if (to.toString().contains(name + "(我)")) {
					JOptionPane
							.showMessageDialog(getContentPane(), "不能向自己发送信息");
					return;
				}
				//如果发送消息为空
				if (info.equals("")) {
					JOptionPane.showMessageDialog(getContentPane(), "不能发送空信息");
					return;
				}
				//把数据封装到对象中  
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

				// 自己发的内容也要现实在自己的屏幕上面
				textArea.append(time + " 我对" + to + "说:\r\n" + info + "\r\n");
				//把对象发送到服务器中  由服务器根据状态判断做出相应操作
				sendMessage(clientBean);
				textArea_1.setText(null);
				textArea_1.requestFocus();
			}
		});
		// 离开
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				if (isSendFile || isReceiveFile) {
					JOptionPane.showMessageDialog(contentPane,
							"正在传输文件中，您不能离开...", "Error Message",
							JOptionPane.ERROR_MESSAGE);
				} else {
					int result = JOptionPane.showConfirmDialog(
							getContentPane(), "您确定要离开聊天室");
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
		// 列表监听
		list.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				// 根据列表中的索引递增顺序返回所有选定项的列表. 
				List to = list.getSelectedValuesList();
				// 双击
				if (e.getClickCount() == 2) {
					//如果选中的是自己
					if (to.toString().contains(name + "我")) {
						JOptionPane.showMessageDialog(getContentPane(),
								"不能像自己发送文件");
						return;
					}
					// 双击打开文件文件选择框
					JFileChooser chooser = new JFileChooser();
					chooser.setDialogTitle("选择文件框");// 标题哦..
					chooser.showDialog(getContentPane(), "选择");// 这是按钮的名字..
					// 判断是否选择了文件
					if (chooser.getSelectedFile() != null) {
						// 获取路径
						filePath = chooser.getSelectedFile().getPath();
						File file = new File(filePath);
						// 文件为空
						if (file.length() == 0) {
							JOptionPane.showMessageDialog(getContentPane(),
									filePath + "文件为空,不允许发送.");
							return;
						}
						// 发送给服务器 要发送文件 并告诉是谁给谁发的
						UserBean bean = new UserBean();
						bean.setType(2);// 请求发送文件
						bean.setSize(new Long(file.length()).intValue());
						bean.setName(name);
						bean.setFileName(file.getName()); // 记录文件的名称
						bean.setTimer(CatUtil.getTimer());
						bean.setInfo("请求发送文件");
						// 判断要发送给谁
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
	 * 客户接收线程
	 * */
	class ClientInputThread extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			 super.run();
			try {
				// 不停的从服务器接收信息
				while (true) {
					InputStream is = clientSocket.getInputStream();
					//封装对象输入流
					ois = new ObjectInputStream(is);
					//读取从服务器发过来的数据
					final UserBean bean = (UserBean) ois.readObject();
					System.out.println(bean.getType() + "type");
					//判断状态
					// 1私聊 0上下线更新 -1下线请求 2请求发送文件 3.确定接收文件4.拒收
					switch (bean.getType()) {
					case 0: {
						// 更新列表
						onlines.clear();
						HashSet<String> clients = bean.getClients();
						Iterator<String> it = clients.iterator();
						while (it.hasNext()) {
							String ele = it.next();
							if (name.equals(ele)) {
								onlines.add(ele + "(我)");
							} else {
								onlines.add(ele);
							}
						}
						//更新在线列表
						listmodel = new UUListModel(onlines);
						list.setModel(listmodel);
						//播放上线声音
						aau2.play();
						
						textArea.append(bean.getInfo() + "\r\n");
						textArea.selectAll();

						break;
					}
					case -1: {
						
						return;
					}
					
					case 1: {
						//发送消息
						String info = bean.getTimer() + "  " + bean.getName()
								+ " 对 " + bean.getClients() + "说:\r\n";
						if (info.contains(name)) {
							info = info.replace(name, "我");
						}
						aau.play();
						textArea.append(info + bean.getInfo() + "\r\n");
						textArea.selectAll();
						break;
					}
					case 2: {
						// 由于等待目标客户确认是否接收文件是个阻塞状态，所以这里用线程处理
						new Thread() {
							public void run() {
								// 显示是否接收文件对话框
								int result = JOptionPane.showConfirmDialog(
										getContentPane(), bean.getInfo());
								switch (result) {
								case 0: // 接收文件
								{
									JFileChooser chooser = new JFileChooser();
									chooser.setDialogTitle("保存文件框"); // 标题哦...
									// 默认文件名称还有放在当前目录下
									chooser.setSelectedFile(new File(bean
											.getFileName()));
									chooser.showDialog(getContentPane(), "保存"); // 这是按钮的名字..
									// 保存路径
									String saveFilePath = chooser
											.getSelectedFile().toString();
									// 创建客户UserBean
									UserBean clientBean = new UserBean();
									clientBean.setType(3);
									clientBean.setName(name); // 接收文件的客户名字
									clientBean.setTimer(CatUtil.getTimer());
									clientBean.setFileName(saveFilePath);
									clientBean.setInfo("确定接收文件");

									// 判断要发送给谁
									HashSet<String> set = new HashSet<String>();
									set.add(bean.getName());
									clientBean.setClients(set); // 文件来源
									clientBean.setTo(bean.getClients());// 给这些客户发送文件

									// 创建新的tcp socket 接收数据, 这是额外增加的功能, 大家请留意...
									try {
										ServerSocket ss = new ServerSocket(0); // 0可以获取空闲的端口号

										clientBean.setIp(clientSocket
												.getInetAddress()
												.getHostAddress());
										clientBean.setPort(ss.getLocalPort());
										sendMessage(clientBean); // 先通过服务器告诉发送方,
																	// 你可以直接发送文件到我这里了...

										isReceiveFile = true;
										// 等待文件来源的客户，输送文件....目标客户从网络上读取文件，并写在本地上
										Socket sk = ss.accept();
										textArea.append(CatUtil.getTimer()
												+ "  " + bean.getFileName()
												+ "文件保存中.\r\n");
										DataInputStream dis = new DataInputStream( // 从网络上读取文件
												new BufferedInputStream(
														sk.getInputStream()));
										DataOutputStream dos = new DataOutputStream( // 写在本地上
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
												lblNewLabel.setText("下载进度:"
														+ count + "/"
														+ bean.getSize()
														+ "  整体" + index + "%");
											} else {
												lblNewLabel
														.setText("下载进度:"+ count+ "/"+ bean.getSize()	+ "  整体:"
																+ new Double(new Double(count).doubleValue()/ new Double(
																						bean.getSize()).doubleValue()
																				* 100).intValue()+ "%");
												if (count == bean.getSize()) {
													progressBar.setValue(100);
												}
											}

										}

										// 给文件来源客户发条提示，文件保存完毕
										PrintWriter out = new PrintWriter(
												sk.getOutputStream(), true);
										out.println(CatUtil.getTimer() + " 发送给"
												+ name + "的文件["
												+ bean.getFileName() + "]"
												+ "文件保存完毕.\r\n");
										//刷新流
										out.flush();
										dos.flush();
										dos.close();
										//关闭流
										out.close();
										dis.close();
										//关闭Socket
										sk.close();
										ss.close();
										textArea.append(CatUtil.getTimer()
												+ "  " + bean.getFileName()
												+ "文件保存完毕.存放位置为:"
												+ saveFilePath + "\r\n");
										isReceiveFile = false;
									} catch (Exception e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}

								}

									break;

								default: {// 拒收
									UserBean clientBean = new UserBean();
									clientBean.setType(4);
									clientBean.setName(name); // 接收文件的客户名字
									clientBean.setTimer(CatUtil.getTimer());
									clientBean.setFileName(bean.getFileName());
									clientBean.setInfo(CatUtil.getTimer()
											+ "  " + name + "取消接收文件["
											+ bean.getFileName() + "]");

									// 判断要发送给谁
									HashSet<String> set = new HashSet<String>();
									set.add(bean.getName());
									clientBean.setClients(set); // 文件来源
									clientBean.setTo(bean.getClients());// 给这些客户发送文件

									sendMessage(clientBean);
									break;
								}

								}
							};
						}.start();
						break;
					}
					case 3: {
						// 目标客户愿意接收文件，源客户开始读取本地文件并发送到网络上
						textArea.append(bean.getTimer() + "  " + bean.getName()
								+ "确定接收文件" + ",文件传送中..\r\n");
						new Thread() {
							public void run() {

								try {
									isSendFile = true;
									// 创建要接收文件的客户套接字
									Socket s = new Socket(bean.getIp(),
											bean.getPort());
									DataInputStream dis = new DataInputStream(
											new FileInputStream(filePath)); // 本地读取该客户刚才选中的文件
									DataOutputStream dos = new DataOutputStream(
											new BufferedOutputStream(
													s.getOutputStream())); // 网络写出文件

									int size = dis.available();

									int count = 0; // 读取次数
									int num = size / 100;
									int index = 0;
									while (count < size) {

										int t = dis.read();
										dos.write(t);
										count++; // 每次只读取一个字节

										if (num > 0) {
											if (count % num == 0 && index < 100) {
												progressBar.setValue(++index);

											}
											lblNewLabel.setText("上传进度:" + count
													+ "/" + size + "  整体"
													+ index + "%");
										} else {
											lblNewLabel.setText("上传进度:"+ count+ "/"+ size+ "  整体:"+
										
									new Double(new Double(count).doubleValue()/ new Double(size).doubleValue()* 100).intValue()
															+ "%");
											if (count == size) {
												
												progressBar.setValue(100);
											}
										}
									}
									dos.flush();
									dis.close();
									// 读取目标客户的提示保存完毕的信息...
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

	/** 往服务器发送消息 */
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
 * 利用ListModel构造JList
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
 * 实现接口ListCellRenderer自定义JList的显示模式
 * */
class CellRenderer extends JLabel implements ListCellRenderer {
	public CellRenderer() {
		// TODO Auto-generated constructor stub
		// 是否透明
		setOpaque(true);
	}

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		// TODO Auto-generated method stub
		setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));// 加入宽度为5的空白边框

		if (value != null) {
			setText(value.toString());
			setIcon(new ImageIcon("images//1.jpg"));
		}
		if (isSelected) {
			setBackground(new Color(255, 255, 153));// 设置背景色
			setForeground(Color.black);
		} else {
			// 设置选取与取消选取的前景与背景颜色.
			setBackground(Color.white); // 设置背景色
			setForeground(Color.black);
		}
		setEnabled(list.isEnabled());
		setFont(new Font("sdf", Font.ROMAN_BASELINE, 13));
		setOpaque(true);
		return this;
	}
}
