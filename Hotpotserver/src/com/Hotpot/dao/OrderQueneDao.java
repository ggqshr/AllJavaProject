package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.OrderQuene;

public interface OrderQueneDao {
	//��ȡ��ǰ��������Ԫ��
	public ArrayList<OrderQuene> listQuene();
	//��ȡ��ǰ����δ���Ԫ��
	public ArrayList<OrderQuene> listUnfinished();
	//��ȡ��ǰ�������Ԫ��
	public ArrayList<OrderQuene> listFinished();
	//���ն�����Ų�ѯ���ж���
	public OrderQuene queryQueneAsBusinessNumber(String businessNumber);
	//�����û���Ų�ѯ����
	public ArrayList<OrderQuene> queryQueneAsCustNumber(String custNumber);
	//����
	public void addQuene(OrderQuene quene);
	//����״̬
	public void updateQuene(int queneNumber);
}
