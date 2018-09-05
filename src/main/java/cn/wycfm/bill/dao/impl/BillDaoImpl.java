package cn.wycfm.bill.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import cn.wycfm.bill.dao.BillDao;
import cn.wycfm.bill.model.Bill;
import cn.wycfm.bill.model.BillQuery;
import cn.wycfm.core.dao.BaseDao;
import cn.wycfm.core.jdbc.ParameterizedRowMapper;
import cn.wycfm.core.model.User;

public class BillDaoImpl extends BaseDao implements BillDao{

	public Bill getBill(Integer billId) {
		return null;
	}

	public List<Bill> listBill(BillQuery bill) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select b.bill_id,b.bill_date,b.description,b.amount,b.user_id,b.input_time,b.year,b.month,b.year_month, ")
		.append(" u.username,u.mobile, u.nick_name ")
		.append(" from bill b ")
		.append(" inner join user u on u.user_id=b.user_id ")
		.append(" where b.year_month=? and user_id=? ");
		
		Object[] args = new Object[] {bill.getYearMonth(), bill.getUserId()};
		int[] argTypes = new int[] {Types.VARCHAR, Types.INTEGER};
		this.queryForList(sql.toString(), args, argTypes, new ParameterizedRowMapper<Object>() {
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				BillQuery bq = new BillQuery();
				
				return null;
			}
		});
		return null;
	}

	public List<Map<String, String>> listSumBill(String userIds, String yearMonth) {
		return null;
	}
	
	public void saveBill(Bill bill) throws SQLException {
		String sql = "insert into bill(bill_date,description,amount,user_id,input_time,year,month,year_month) values(?,?,?,?,?,?,?,?);";
		Object[] args = new Object[] {bill.getBillDate(), bill.getDescription(), bill.getAmount(),
				bill.getUserId(), bill.getInputTime(), bill.getUpdateTime(), bill.getYear(), bill.getMonth(), bill.getYearMonth()};
		int[] argTypes = new int[] {Types.VARCHAR, Types.VARCHAR , Types.DOUBLE,
				Types.INTEGER, Types.TIMESTAMP, Types.INTEGER, Types.INTEGER, Types.VARCHAR};
		this.executeForUpdate(sql, args, argTypes);
	}

	public void updateBill(Bill bill) {
		
	}

	public void deleteBill(Bill bill, User user) {
		
	}


}
