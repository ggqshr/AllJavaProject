package com.Hotpot.dao;

import java.util.ArrayList;

import com.example.ggq.restaurant.com.Hotpot.entity.Combo;

public interface ComboDao {
	//�����ײ�
	public void insertCombo(Combo combo);
	//�����ײ� 
	public void updateCombo(Combo combo);
	//ɾ���ײ�
	public void deleteCombo(String comborNumber);
	//��ʾȫ���ײ�
	public ArrayList<Combo> listCombo();
	//�����ײͱ�Ų�ѯ�ײ�
	public Combo queryComboAsNumber(String comboNumber);
	//ģ����ѯ�ײ�
	public Combo queryComboAsInf(String inf);
}
