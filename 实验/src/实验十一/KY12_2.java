package ʵ��ʮһ;
import java.math.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
class KY12_2
{
	private JTextField tx1;  //���������ı���
	private JTextField tx2;
	private JTextField tx3;
	private JPanel p;     //����һ�� ���
	private JComboBox cho;   //����һ������ѡ���б�
	void init()
{
		
		JFrame f=new JFrame("calculate");    //����һ������ ����Ϊ��calculate��
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //���ô���Ĺرշ�ʽ
		Label lab=new Label("����������");    //����һ����ǩ ����Ϊ ����������
		tx1=new JTextField("���",5);    //�����ı���ĳ���
		tx2=new JTextField("",5);
		tx3=new JTextField("",5);
		cho=new JComboBox();
		cho.addItem("+");
		cho.addItem("-");
		cho.addItem("*");
		cho.addItem("/");
		JButton b=new JButton("=");
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int a=Integer.parseInt(tx1.getText().trim());
				int b=Integer.parseInt(tx2.getText().trim());
				int sel=cho.getSelectedIndex();
				int c=0;
				switch(sel)
				{
					case 0: c=a+b;break;
					case 1: c=a-b;break;
					case 2: c=a*b;break;
					case 3: c=a/b;break;
				}
				String d=(new Integer(c)).toString();
				tx3.setText(d);
			}
		});
	   	p = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(tx1);
		p.add(cho);
		p.add(tx2);
		p.add(b);
		p.add(tx3);
		Container c=f.getContentPane();
		c.setLayout(new BorderLayout());
		c.add(lab,BorderLayout.NORTH);
		c.add(p,BorderLayout.CENTER);
		f.pack();
		f.setVisible(true);
	}		
	public static void main(String[] args)
	{
		KY12_2 cal=new KY12_2();
		cal.init();
	}
}

