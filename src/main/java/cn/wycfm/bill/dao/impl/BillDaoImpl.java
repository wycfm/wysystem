package cn.wycfm.bill.dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.wycfm.bill.dao.BillDao;
import cn.wycfm.bill.model.Bill;
import cn.wycfm.bill.model.BillQuery;
import cn.wycfm.bill.model.BillResult;
import cn.wycfm.core.dao.BaseDao;
import cn.wycfm.core.jdbc.ParameterizedRowMapper;
import cn.wycfm.core.model.User;
import cn.wycfm.db.DBAccess;

public class BillDaoImpl extends BaseDao implements BillDao{

	public Bill getBill(Integer billId) {
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<BillResult> listBill(BillQuery bill) throws SQLException {
		StringBuilder sql = new StringBuilder();
		sql.append("select b.bill_id,date_format(b.bill_date,'%Y-%m-%d') as bill_date,b.description,b.amount,b.user_id,b.input_time,b.year,b.month, ")
		.append(" u.username,u.mobile, u.nickname ")
		.append(" from bill_base b ")
		.append(" inner join user u on u.user_id=b.user_id ")
		.append(" where b.bill_date>=? and b.bill_date<=? and b.user_id in (").append(bill.getUserIds()).append(") and b.status=1 order by b.bill_id desc");
		
		Object[] args = new Object[] {bill.getStartDate(), bill.getEndDate()};
		int[] argTypes = new int[] {Types.DATE, Types.DATE};
		return this.queryForList(sql.toString(), args, argTypes, new ParameterizedRowMapper<Object>() {
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				BillResult bq = new BillResult();
				bq.setBillId(rs.getInt("bill_id"));
				bq.setBillDate(rs.getString("bill_date"));
				bq.setDescription(rs.getString("description"));
				bq.setAmount(rs.getDouble("amount"));
				bq.setUserId(rs.getInt("user_id"));
				bq.setInputTime(rs.getDate("input_time"));
				bq.setYear(rs.getInt("year"));
				bq.setMonth(rs.getInt("month"));
				bq.setUsername(rs.getString("username"));
				bq.setMobile(rs.getString("mobile"));
				bq.setNickName(rs.getString("nickname"));
				
				return bq;
			}
		});
		
	}

	@SuppressWarnings("unchecked")
	public List<Map<String, String>> listSumBill(BillQuery q) throws SQLException{
		StringBuilder sql = new StringBuilder();
		sql.append("select b.user_id ,sum(b.amount) as total,u.nickname ")
		.append(" from bill_base b ")
		.append(" inner join user u on u.user_id=b.user_id ")
		.append(" where b.bill_date>=? and b.bill_date<=? and b.user_id in (").append(q.getUserIds()).append(") and b.status=1 group by b.user_id,u.nickname  ");
		Object[] args = new Object[] {q.getStartDate(), q.getEndDate()};
		int[] argTypes = new int[] {Types.DATE, Types.DATE};
		return this.queryForList(sql.toString(), args, argTypes, new ParameterizedRowMapper<Object>() {
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Map<String, String> bq = new HashMap<String, String>();
				bq.put("userId", rs.getString("user_id"));
				bq.put("total", rs.getString("total"));
				bq.put("nickName", rs.getString("nickname"));
				return bq;
			}
		});
	}
	
	/*public void saveBill(Bill bill) throws SQLException {
		String sql = "insert into bill_base(bill_date,description,amount,user_id,input_time,year,month) values(?,?,?,?,?,?,?);";
		Object[] args = new Object[] {bill.getBillDate(), bill.getDescription(), bill.getAmount(),
				bill.getUserId(), bill.getInputTime(), bill.getYear(), bill.getMonth()};
		int[] argTypes = new int[] {Types.VARCHAR, Types.VARCHAR , Types.DOUBLE,
				Types.INTEGER, Types.TIMESTAMP, Types.INTEGER, Types.INTEGER};
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
		String sql = "update bill_base set status=0 where user_id=? and bill_id=? ";
		Object[] args = new Object[]{user.getUserId(), bill.getBillId()};
		int[] argTypes = new int[] {Types.INTEGER, Types.INTEGER};
		
		this.executeForUpdate(sql, args, argTypes);
	}*/

	public void saveBill(Bill bill) throws SQLException {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.insert("Bill.saveBill", bill);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void updateBill(Bill bill) throws SQLException{
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.update("Bill.updateBill", bill);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void deleteBill(Bill bill, User user) throws SQLException{
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			bill.setUserId(user.getUserId());
			sqlSession = dbAccess.getSqlSession();
			sqlSession.update("Bill.deleteBill", bill);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Bill> queryBillList(BillQuery bill) {
		//得到 sqlSession
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Bill> list = new ArrayList<Bill>();
		try {
			sqlSession = dbAccess.getSqlSession();
			list = sqlSession.selectList("Bill.queryBillList", bill);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		return list;
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(5);
		BillQuery bq = new BillQuery();
		bq.setQuserIds(list);
		BillDaoImpl b = new BillDaoImpl();
		List<Bill> queryBillList = b.queryBillList(bq);
		for(Bill bill: queryBillList) {
			System.out.println(bill.description);
			System.out.println(bill.getUser());
		}
	}

}
