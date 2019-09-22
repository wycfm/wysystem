package cn.wycfm.bill.service;

import java.util.List;
import java.util.Map;

import cn.wycfm.bill.model.Bill;
import cn.wycfm.bill.model.BillQuery;
import cn.wycfm.bill.model.BillResult;
import cn.wycfm.core.model.ResultBean;
import cn.wycfm.core.model.User;

public interface BillService {

	Bill getBill(Integer billId);
	//List<BillResult> listBill(BillQuery bill, User user);
	List<Map<String,String>> listSumBillByUser(BillQuery bill);
	ResultBean<Integer> saveBill(Bill bill, User user);
	void updateBill(Bill bill, User user);
	ResultBean<Integer> deleteBill(Bill bill, User user);
	
	public List<Bill> queryBillList(BillQuery bill);
}
