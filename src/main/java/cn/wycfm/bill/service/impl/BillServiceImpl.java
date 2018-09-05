package cn.wycfm.bill.service.impl;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import cn.wycfm.bill.dao.BillDao;
import cn.wycfm.bill.dao.impl.BillDaoImpl;
import cn.wycfm.bill.model.Bill;
import cn.wycfm.bill.model.BillQuery;
import cn.wycfm.bill.service.BillService;
import cn.wycfm.core.model.User;

public class BillServiceImpl implements BillService{

	public Bill getBill(Integer billId) {
		return null;
	}

	public List<Bill> listBill(BillQuery bill, User user) {
		return null;
	}
	
	public List<Map<String, String>> listSumBill(String userIds, String yearMonth) {
		return null;
	}

	public void saveBill(Bill bill, User user) {
		BillDao billDao = new BillDaoImpl();
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		try {
			bill.setUserId(user.getUserId());
			bill.setInputTime(new Date(System.currentTimeMillis()));
			bill.setYear(calendar.get(Calendar.YEAR));
			bill.setMonth(calendar.get(Calendar.MONTH));
			bill.setYearMonth(sdf.format(new Date(System.currentTimeMillis())));
			billDao.saveBill(bill);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updateBill(Bill bill, User user) {
		
	}

	public void deleteBill(Bill bill, User user) {
		
	}


}
