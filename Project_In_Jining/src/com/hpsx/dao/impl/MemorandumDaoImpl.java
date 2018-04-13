package com.hpsx.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hpsx.dao.MemorandumDao;
import com.hpsx.po.Memorandum;
import com.hpsx.util.DbUtil;

public class MemorandumDaoImpl implements MemorandumDao{

	String sql;
	ResultSet rs;
	PreparedStatement p;
	int rs1;
	
	@Override
	public List getAllMemorandum(int userId) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		List<Memorandum> mList = new ArrayList<>();
		sql = "select * from memorandum where userId=?";
		try {
			p = con.prepareStatement(sql);
			p.setInt(1, userId);
			rs = p.executeQuery();
			while(rs.next()){
				Memorandum m = new Memorandum();
				m.setMem_id(rs.getInt(1));
				m.setMem_title(rs.getString(2));
				m.setTime(rs.getTimestamp(3));
				m.setContent(rs.getString(4));
				m.setUserId(rs.getInt(5));
				mList.add(m);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, rs);
		}
		
		return mList;
	}

	@Override
	public int addMemorandum(Memorandum m) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "insert into memorandum(memorandum_title,time,content,userId) values(?,?,?,?)";
		try {
			p = con.prepareStatement(sql);
			p.setString(1, m.getMem_title());
			p.setObject(2, m.getTime());
			p.setString(3, m.getContent());
			p.setInt(4, m.getUserId());
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
	public int updateMemorandum(Memorandum m) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "update memorandum set memorandum_title=? , time=? , content=? where memorandum_id=? and userId=?";
		try {
			p = con.prepareStatement(sql);
			p.setString(1, m.getMem_title());
			p.setObject(2, m.getTime());
			p.setString(3, m.getContent());
			p.setInt(4, m.getMem_id());
			p.setInt(5, m.getUserId());
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
	public Memorandum getMemorandum(int m_id,int userId) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		Memorandum m = null;
		sql = "select * from memorandum where memorandum_id=? and userId=?";
		try {
			p = con.prepareStatement(sql);
			p.setInt(1, m_id);
			p.setInt(2, userId);
			rs = p.executeQuery();
			while(rs.next()){
				m = new Memorandum();
				m.setMem_id(rs.getInt(1));
				m.setMem_title(rs.getString(2));
				m.setTime(rs.getDate(3));
				m.setContent(rs.getString(4));
				m.setUserId(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, rs);
		}
		return m;
	}

	@Override
	public int deleteMemorandum(int m_id) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "delete from memorandum where memorandum_id=?";
		try {
			p = con.prepareStatement(sql);
			p.setInt(1, m_id);
			rs1 = p.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, null);
		}
		return rs1;
	}

}
