package cn.wycfm.crawler.model;

public class CrawlerItemModel {

	private String columnName;
	private String selectStr;
	
	public CrawlerItemModel() {}
	
	public CrawlerItemModel(String columnName, String selectStr) {
		this.columnName = columnName;
		this.selectStr = selectStr;
	}
	
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public String getSelectStr() {
		return selectStr;
	}
	public void setSelectStr(String selectStr) {
		this.selectStr = selectStr;
	}
	
	
	
}
