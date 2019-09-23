package cn.wycfm.bill.dao.impl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.wycfm.bill.dao.BillDao;
import cn.wycfm.bill.model.Bill;
import cn.wycfm.bill.model.BillQuery;
import cn.wycfm.core.dao.BaseDao;
import cn.wycfm.core.model.User;
import cn.wycfm.db.DBAccess;

public class BillDaoImpl extends BaseDao implements BillDao{

	private static Logger log = Logger.getLogger(BillDaoImpl.class);
	
	public Bill getBill(Integer billId) {
		return null;
	}

	/*@SuppressWarnings("unchecked")
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
		
	}*/

	/**
	 * 统计每个人的 总消费
	 */
	public List<Map<String, String>> listSumBillByUser(BillQuery q) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Map<String, String>> result = new ArrayList<Map<String, String>>();
		try {
			sqlSession = dbAccess.getSqlSession();
			result = sqlSession.selectList("Bill.listSumBillByUser",q);
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
		return result;
	}
	
	

	public void saveBill(Bill bill) throws SQLException {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.insert("Bill.saveBill", bill);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public void updateBill(Bill bill) throws SQLException{
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.update("Bill.updateBill", bill);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
		}
	}

	public void deleteBill(Bill bill, User user) throws SQLException{
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			bill.setUserId(user.getUserId());
			sqlSession = dbAccess.getSqlSession();
			sqlSession.update("Bill.deleteBill", bill);
			sqlSession.commit();
		} catch (IOException e) {
			e.printStackTrace();
			log.error(e.getMessage());
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
			e.printStackTrace();
			log.error(e.getMessage());
		}
		
	
		return list;
	}
	
}
