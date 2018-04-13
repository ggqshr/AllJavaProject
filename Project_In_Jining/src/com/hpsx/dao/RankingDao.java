package com.hpsx.dao;

import java.util.List;

import com.hpsx.po.Ranking;
import com.hpsx.po.RankingVo;

public interface RankingDao {

	/**
	 * 添加记录
	 * @param r
	 * @return 成功：1 失败：0
	 */
	int addRank(Ranking r);
	/**
	 * 查询游戏排名
	 * @return
	 */
	List<RankingVo> getAllRanking();
	
}
