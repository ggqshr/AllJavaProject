package com.hpsx.dao;

import com.hpsx.po.Account;
import com.hpsx.po.AccountLog;
import com.hpsx.po.AccountVo;

public interface AccountDao {

	/**
	 * 查看余额
	 * @param userId 用户ID
	 * @return 个人账户信息
	 */
	public Account viewAccount(int userId);
	/**
	 * 存钱
	 * @param accountVo 存钱信息
	 * @return 成功或者失败
	 */
	public boolean saveAccount(AccountVo accountVo);
	/**
	 * 验证是否存在该账户
	 * @param accountId 账户ID
	 * @return 存在或不存在
	 */
	public boolean isExistAccount(int accountId);
	/**
	 * 转账
	 * @param accountVo 转账信息
	 * @return 成功或者失败
	 */
	public boolean transferAccount(AccountVo accountVo);
	/**
	 * 当月收入查询
	 * @param accountLog 查询条件
	 * @return 统计金额
	 */
	public double queryIncome(AccountLog accountLog);
	/**
	 * 当月支出查询
	 * @param accountLog 查询条件
	 * @return 统计金额
	 */
	public double queryExpenditure(AccountLog accountLog);
}
