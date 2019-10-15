package cn.wycfm.crawler.service;

public class QinziBean {

	private String city;
	private String area;
	private String category;
	private String shopName;
	private String avgPrice;
	private String commentNum;
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getAvgPrice() {
		return avgPrice;
	}
	public void setAvgPrice(String avgPrice) {
		this.avgPrice = avgPrice;
	}
	public String getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(String commentNum) {
		this.commentNum = commentNum;
	}
	@Override
	public String toString() {
		return "QinziBean [city=" + city + ", area=" + area + ", category=" + category + ", shopName=" + shopName
				+ ", avgPrice=" + avgPrice + ", commentNum=" + commentNum + "]";
	}
	
	
	
}
