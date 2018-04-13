package com.hpsx.dao;

import java.util.List;

import com.hpsx.po.Memorandum;

public interface MemorandumDao {

	/**
	 * 查询个人所有备忘录
	 * @param userId 用户编号
	 * @return 个人备忘录信息
	 */
	public List getAllMemorandum(int userId);
	/**
	 * 添加个人备忘录
	 * @param memorandum 备忘录信息
	 * @return 添加成功：1 添加失败：0
	 */
	public int addMemorandum(Memorandum m);
	/**
	 * 修改备忘录
	 * @param memorandum 备忘录信息
	 * @return 添加成功：1 添加失败：0
	 */
	public int updateMemorandum(Memorandum m);
	/**
	 * 根据备忘录编号查询备忘录
	 * @param memorandum_id 备忘录编号
	 * @return 备忘录信息
	 */
	public Memorandum getMemorandum(int m_id,int userId);
	/**
	 * 删除备忘录
	 * @param memorandum_id 备忘录信息
	 * @return 添加成功：1 添加失败：0
	 */
	public int deleteMemorandum(int m_id);
}
