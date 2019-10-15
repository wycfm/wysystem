package cn.wycfm.crawler.model;

public class AUrlModel {

	
	private String href;
	private String aText;
	
	public AUrlModel() {}
	
	public AUrlModel(String href, String aText) {
		this.href = href;
		this.aText = aText;
	}
	
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}
	public String getAText() {
		return aText;
	}
	public void setAText(String aText) {
		this.aText = aText;
	}
	
	
}
