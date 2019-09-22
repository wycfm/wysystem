package cn.wycfm.bill.service.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import cn.wycfm.bill.dao.BillDao;
import cn.wycfm.bill.dao.impl.BillDaoImpl;
import cn.wycfm.bill.model.Bill;
import cn.wycfm.bill.model.BillQuery;
import cn.wycfm.bill.service.BillService;
import cn.wycfm.core.model.ResultBean;
import cn.wycfm.core.model.User;

public class BillServiceImpl implements BillService{

	public Bill getBill(Integer billId) {
		return null;
	}

	
	
	public List<Map<String, String>> listSumBillByUser(BillQuery bill) {
		BillDao billDao = new BillDaoImpl();
		String userIds = bill.getUserIds();
		if("-1".equals(userIds)) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(5);
			list.add(10);
			list.add(11);
			bill.setUserIds("5,10,11");
			bill.setQuserIds(list);
		}
		List<Map<String, String>> result = billDao.listSumBillByUser(bill);
		return result;
	}

	public ResultBean<Integer> saveBill(Bill bill, User user) {
		BillDao billDao = new BillDaoImpl();
		Calendar calendar = Calendar.getInstance();
		ResultBean<Integer> result = new ResultBean<Integer>();
		try {
			bill.setUserId(user.getUserId());
			bill.setInputTime(new Timestamp(System.currentTimeMillis()));
			bill.setYear(calendar.get(Calendar.YEAR));
			bill.setMonth(calendar.get(Calendar.MONTH));
			billDao.saveBill(bill);
			
			result.setCode("200");
			result.setDescription("success");
		} catch (SQLException e) {
			result.setCode("500");
			result.setDescription("error");
			e.printStackTrace();
		}
		return result;
		
	}

	public void updateBill(Bill bill, User user) {
		
	}

	public ResultBean<Integer> deleteBill(Bill bill, User user) {
		BillDao billDao = new BillDaoImpl();
		ResultBean<Integer> result = new ResultBean<Integer>();
		try {
			billDao.deleteBill(bill, user);
			result.setCode("200");
			result.setDescription("success");
		} catch (SQLException e) {
			result.setCode("500");
			result.setDescription("error");
			e.printStackTrace();
		}
		return result;
	}

	public List<Bill> queryBillList(BillQuery bill) {
		BillDao billDao = new BillDaoImpl();

		String userIds = bill.getUserIds();
		if("-1".equals(userIds)) {
			List<Integer> list = new ArrayList<Integer>();
			list.add(5);
			list.add(10);
			list.add(11);
			bill.setUserIds("5,10,11");
			bill.setQuserIds(list);
		}
			
			
		List<Bill> listBill = billDao.queryBillList(bill);
		
	
		return listBill;
	}


}
