package cn.wycfm.bill.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.wycfm.bill.dao.BillDao;
import cn.wycfm.bill.model.Bill;
import cn.wycfm.bill.model.BillQuery;
import cn.wycfm.bill.model.BillResult;
import cn.wycfm.core.dao.BaseDao;
import cn.wycfm.core.jdbc.ParameterizedRowMapper;
import cn.wycfm.core.model.User;

public class BillDaoImpl extends BaseDao implements BillDao{

	public Bill getBill(Integer billId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<BillResult> listBill(BillQuery bill) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select b.bill_id,b.bill_date,b.description,b.amount,b.user_id,b.input_time,b.year,b.month,b.year_month, ")
		.append(" u.username,u.mobile, u.nick_name ")
		.append(" from bill_base b ")
		.append(" inner join user u on u.user_id=b.user_id ")
		.append(" where bill_date>=? and bill_date<=? and user_id in (?) ");
		
		Object[] args = new Object[] {bill.getStartDate(), bill.getEndDate(), bill.getUserIds()};
		int[] argTypes = new int[] {Types.DATE, Types.DATE, Types.VARCHAR};
		return this.queryForList(sql.toString(), args, argTypes, new ParameterizedRowMapper<Object>() {
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				BillResult bq = new BillResult();
				bq.setBillId(rs.getInt("bill_id"));
				bq.setBillDate(rs.getDate("bill_date"));
				bq.setDescription(rs.getString("description"));
				bq.setAmount(rs.getDouble("amount"));
				bq.setUserId(rs.getInt("user_id"));
				bq.setInputTime(rs.getDate("input_time"));
				bq.setYear(rs.getInt("year"));
				bq.setMonth(rs.getInt("month"));
				bq.setYearMonth(rs.getString("year_month"));
				bq.setUsername(rs.getString("username"));
				bq.setMobile(rs.getString("mobile"));
				bq.setNickName(rs.getString("nick_name"));
				
				return bq;
			}
		});
		
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> listSumBill(BillQuery q) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("select user_id sum(b.amount) as total,u.user_name,u.nick_name ")
		.append(" from bill_base b ")
		.append(" inner join user u on u.user_id=b.user_id ")
		.append(" where bill_date>=? and bill_date<=? and user_id in (?) group by b.user_id,u.user_name,u.nick_name  ");
		Object[] args = new Object[] {q.getStartDate(), q.getEndDate(), q.getUserIds()};
		int[] argTypes = new int[] {Types.DATE, Types.DATE, Types.VARCHAR};
		return this.queryForList(sql.toString(), args, argTypes, new ParameterizedRowMapper<Object>() {
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String, String> bq = new HashMap<String, String>();
				bq.put("user_id", rs.getString("user_id"));
				bq.put("total", rs.getString("total"));
				bq.put("user_name", rs.getString("user_name"));
				bq.put("nick_name", rs.getString("nick_name"));
				return bq;
			}
		});
	}
	
	public void saveBill(Bill bill) throws SQLException {
		String sql = "insert into bill_base(bill_date,description,amount,user_id,input_time,year,month,year_month) values(?,?,?,?,?,?,?,?);";
		Object[] args = new Object[] {bill.getBillDate(), bill.getDescription(), bill.getAmount(),
				bill.getUserId(), bill.getInputTime(), bill.getUpdateTime(), bill.getYear(), bill.getMonth(), bill.getYearMonth()};
		int[] argTypes = new int[] {Types.VARCHAR, Types.VARCHAR , Types.DOUBLE,
				Types.INTEGER, Types.TIMESTAMP, Types.INTEGER, Types.INTEGER, Types.VARCHAR};
		this.executeForUpdate(sql, args, argTypes);
	}

	public void updateBill(Bill bill) throws SQLException{
		String sql = "update bill_base set bill_date=?, description=?, amount=? where bill_id=? and user_id=?";
		Object[] args = new Object[] {bill.getBillDate(), bill.getDescription(), bill.getAmount(),
				bill.getBillId(), bill.getUserId() };
		int[] argTypes = new int[] {Types.VARCHAR, Types.VARCHAR , Types.DOUBLE,
				Types.INTEGER, Types.TIMESTAMP, Types.INTEGER, Types.INTEGER, Types.VARCHAR};
		this.executeForUpdate(sql, args, argTypes);
	}

	public void deleteBill(Bill bill, User user) throws SQLException{
		String sql = "delete from bill_base where user_id=? and bill_id=? ";
		Object[] args = new Object[]{user.getUserId(), bill.getBillId()};
		int[] argTypes = new int[] {Types.INTEGER, Types.INTEGER};
		
		this.executeForUpdate(sql, args, argTypes);
	}


}
