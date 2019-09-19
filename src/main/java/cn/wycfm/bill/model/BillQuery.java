package cn.wycfm.bill.model;

import java.util.List;

public class BillQuery {

	private String userIds;
	private String yearMonth;
	private String startDate;
	private String endDate;
	private List<Integer> quserIds;
	
	
	public String getUserIds() {
		return userIds;
	}
	public void setUserIds(String userIds) {
		this.userIds = userIds;
	}
	public String getYearMonth() {
		return yearMonth;
	}
	public void setYearMonth(String yearMonth) {
		this.yearMonth = yearMonth;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public List<Integer> getQuserIds() {
		return quserIds;
	}
	public void setQuserIds(List<Integer> quserIds) {
		this.quserIds = quserIds;
	}
	
	
	
	
	
	
}
