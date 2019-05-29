package cn.wycfm.bill.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.wycfm.bill.model.Bill;
import cn.wycfm.bill.model.BillQuery;
import cn.wycfm.bill.model.BillResult;
import cn.wycfm.core.model.User;

public interface BillDao {

	Bill getBill(Integer billId) throws SQLException;
	List<BillResult> listBill(BillQuery bill) throws SQLException;
	List<Map<String,String>> listSumBill(BillQuery q) throws SQLException;
	void saveBill(Bill bill) throws SQLException;
	void updateBill(Bill bill) throws SQLException;
	void deleteBill(Bill bill, User user) throws SQLException;
}
