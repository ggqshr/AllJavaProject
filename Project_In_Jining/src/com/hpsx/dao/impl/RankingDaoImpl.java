package com.hpsx.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hpsx.dao.RankingDao;
import com.hpsx.po.Ranking;
import com.hpsx.po.RankingVo;
import com.hpsx.util.DbUtil;

public class RankingDaoImpl implements RankingDao{

	PreparedStatement p;
	String sql;
	ResultSet rs;
	int rs1;
	@Override
	public int addRank(Ranking r) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "insert into ranking(userId,integral,time) values(?,?,now())";
		try {
			p = con.prepareStatement(sql);
			p.setInt(1, r.getUserId());
			p.setInt(2, r.getIntegral());
			rs1 = p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, null);
		}
		return rs1;
	}

	@Override
	public List<RankingVo> getAllRanking() {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		List<RankingVo> rList = new ArrayList<>();
		sql = "select users.userName,ranking.integral,ranking.time "
				+ "from ranking,users where users.userId = ranking.userId "
				+ "order by ranking.integral desc";
		try {
			p = con.prepareStatement(sql);
			rs = p.executeQuery();
			while(rs.next()){
				RankingVo rvo = new RankingVo();
				rvo.setUserName(rs.getString(1));
				rvo.setIntegral(rs.getInt(2));
				rvo.setTime(rs.getTimestamp(3));
				rList.add(rvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, rs);
		}
		
		return rList;
	}


}
