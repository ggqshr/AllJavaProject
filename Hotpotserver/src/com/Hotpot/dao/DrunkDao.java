package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.Drunk;

public interface DrunkDao {
//����һ������
	public void insertDrunk(Drunk drunk);
	//����һ������
	public void updateDrunk(Drunk drunk);
	//���ձ�Ų�ѯһ������
	public Drunk queryDrunkAsNumber(String drunkNumber);
	//����������ѯһ������
	public Drunk queryDrunkAsName(String drunkName);
	//��ѯ��������
	public ArrayList<Drunk> queryAllDrunk();
}
