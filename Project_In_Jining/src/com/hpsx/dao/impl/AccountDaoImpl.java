package com.hpsx.dao.impl;

import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hpsx.dao.AccountDao;
import com.hpsx.po.Account;
import com.hpsx.po.AccountLog;
import com.hpsx.po.AccountVo;
import com.hpsx.util.DbUtil;

public class AccountDaoImpl implements AccountDao{

	String sql;
	PreparedStatement p;
	ResultSet rs;
	int rs1;
	@Override
	public Account viewAccount(int userId) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		Account acc = null;
		sql = "select * from account where userId=?";
		try {
			p = con.prepareStatement(sql);
			p.setInt(1, userId);
			rs = p.executeQuery();
			while(rs.next()){
				acc = new Account();
				acc.setAccountId(rs.getInt(1));
				acc.setAccount_money(rs.getDouble(2));
				acc.setUserId(rs.getInt(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, rs);
		}
		return acc;
	}

	@Override
	public boolean saveAccount(AccountVo aco) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "update account set account_money=account_money+? where accountId=?";
		try {
			con.setAutoCommit(false);
			p = con.prepareStatement(sql);
			p.setDouble(1, aco.getmoney());
			p.setInt(2, aco.getIn_accId());
			int r = p.executeUpdate();
			sql = "insert into account_log(accountId,transfer_account,type,log_time,money) values(?,?,?,?,?)";
			p = con.prepareStatement(sql);
			p.setInt(1, aco.getEx_accId());
			p.setInt(2, aco.getIn_accId());
			p.setString(3, aco.getType());
			p.setTimestamp(4, aco.getAcc_time());
			p.setDouble(5, aco.getmoney());
			int r1 = p.executeUpdate();
			con.commit();
			if(r!=0 && r1!=0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, null);
		}
		return false;
	}

	@Override
	public boolean isExistAccount(int accountId) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "select * from account where accountId=?";
		try {
			p = con.prepareStatement(sql);
			p.setInt(1, accountId);
			rs = p.executeQuery();
			if(rs.next()){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, rs);
		}
		return false;
	}

	@Override
	public boolean transferAccount(AccountVo aco) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		sql = "update account set account_money=account_money-? where accountId=?";
		try {
			con.setAutoCommit(false);
			p = con.prepareStatement(sql);
			p.setDouble(1, aco.getmoney());
			p.setInt(2, aco.getEx_accId());
			int r=p.executeUpdate();
			sql=sql.replace('-', '+');
			p = con.prepareStatement(sql);
			p.setDouble(1, aco.getmoney());
			p.setInt(2, aco.getIn_accId());
			int r1=p.executeUpdate();
			sql = "insert into account_log(accountId,transfer_account,type,log_time,money) values(?,?,?,?,?)";
			p = con.prepareStatement(sql);
			p.setInt(1, aco.getEx_accId());
			p.setInt(2, aco.getIn_accId());
			p.setString(3, aco.getType());
			p.setTimestamp(4, aco.getAcc_time());
			p.setDouble(5, aco.getmoney());
			int r2 = p.executeUpdate();
			con.commit();
			if(r!=0 && r1!=0 && r2!=0){
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e);
			try {
				con.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, null);
		}
		return false;
	}

	@Override
	public double queryIncome(AccountLog accl) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		double count=0;
		sql = "select sum(money) from account_log where transfer_account=? and log_time like ?";
		try {
			p = con.prepareStatement(sql);
			p.setInt(1, accl.getAccountId());
			p.setString(2, accl.getLog_time()+"%");
			rs = p.executeQuery();
			if(rs.next()){
				count = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, rs);
		}
		return count;
	}

	@Override
	public double queryExpenditure(AccountLog accl) {
		// TODO Auto-generated method stub
		Connection con = DbUtil.getc();
		double count = 0;
		sql = "select sum(money) from account_log where accountId=? and type=? and log_time like ? ";
		try {
			p = con.prepareStatement(sql);
			p.setInt(1, accl.getAccountId());	
			p.setString(2, accl.getType());
			p.setString(3, accl.getLog_time()+"%");
			rs = p.executeQuery();
			if(rs.next()){
				count = rs.getDouble(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DbUtil.DbClose(con, p, rs);
		}
		
		return count;
	}

}
