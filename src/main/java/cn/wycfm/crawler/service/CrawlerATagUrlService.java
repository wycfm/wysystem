package cn.wycfm.crawler.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.wycfm.crawler.model.AUrlModel;
import cn.wycfm.crawler.util.CrawlerUtil;
/**
 * 抓取 页面中的 目标   url
 * @author robert.wu
 *
 */
public class CrawlerATagUrlService {
	
	public final static String URL_ATTR = "href";

	public String url;
	/**
	 * start tag class
	 */
	private String grandParentElementClass;
	/**
	 * parent tag class
	 */
	private String parentElementClass;
	/**
	 * A parent tag 
	 */
	private String parentElementTag;
	/**
	 * target element A
	 */
	private String childElementTag;
	
	private String selectStr;
	
	private String urlAttr;
	
	public CrawlerATagUrlService(String url, String grandParentElementClass, String parentElementClass,
			String parentElementTag, String childElementTag) {
		super();
		this.url = url;
		this.grandParentElementClass = grandParentElementClass;
		this.parentElementClass = parentElementClass;
		this.parentElementTag = parentElementTag;
		this.childElementTag = childElementTag;
	}
	
	public CrawlerATagUrlService(String url, String grandParentElementClass, String parentElementClass,
			String parentElementTag, String childElementTag, String urlAttr) {
		super();
		this.url = url;
		this.grandParentElementClass = grandParentElementClass;
		this.parentElementClass = parentElementClass;
		this.parentElementTag = parentElementTag;
		this.childElementTag = childElementTag;
		this.urlAttr = urlAttr;
	}
	
	public CrawlerATagUrlService(String url, String selectStr, String urlAttr) {
		this.url = url;
		this.selectStr = selectStr;
		this.urlAttr = urlAttr;
	}
	
	public CrawlerATagUrlService(String url, String selectStr) {
		this.url = url;
		this.selectStr = selectStr;
	}
	
	
	public List<AUrlModel> crawlerAUrl(){
		List<AUrlModel> result = new ArrayList<AUrlModel>();
		
		String crawlerHtml = CrawlerUtil.crawlerData(url);
		Document document = Jsoup.parse(crawlerHtml);
		//grandParentElementClass 所抓取的开始标签class
		Elements gpec = document.getElementsByClass(grandParentElementClass);
		Element grandElement = gpec.get(0);
		
		Elements pec = grandElement.getElementsByClass(parentElementClass);
		
		Iterator<Element> pecIter = pec.iterator();
		while(pecIter.hasNext()) {
			Element next = pecIter.next();
			
			Elements parentTag = next.getElementsByTag(parentElementTag);
			Iterator<Element> parentTagIt = parentTag.iterator();
			while(parentTagIt.hasNext()) {
				Element nextP = parentTagIt.next();
				Elements childTag = nextP.getElementsByTag(childElementTag);
				Iterator<Element> childTagIt = childTag.iterator();
				while(childTagIt.hasNext()) {
					AUrlModel aUrl = new AUrlModel();
					Element AElement = childTagIt.next();
					String url = AElement.attr(urlAttr==null ? URL_ATTR : urlAttr);
					String aText = AElement.text();
					aUrl.setAText(aText);
					aUrl.setHref(url);
					result.add(aUrl);
				}
			}
		}
		
		return result;
	}
	
	/**
	 * 根据select  抓取页面目标 url
	 * @return
	 */
	public List<AUrlModel> crawlerAUrlBySelect(){
		List<AUrlModel> result = new ArrayList<AUrlModel>();
		
		String crawlerHtml = CrawlerUtil.crawlerData(url);
		Document document = Jsoup.parse(crawlerHtml);
		Elements select = document.select(selectStr);
		Iterator<Element> iterator = select.iterator();
		while(iterator.hasNext()) {
			AUrlModel aUrl = new AUrlModel();
			Element next = iterator.next();
			String url = next.attr(urlAttr==null ? URL_ATTR : urlAttr);
			String aText = next.text();
			aUrl.setAText(aText);
			aUrl.setHref(url);
			result.add(aUrl);
		}
		return result;
	}
	
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getGrandParentElementClass() {
		return grandParentElementClass;
	}
	public void setGrandParentElementClass(String grandParentElementClass) {
		this.grandParentElementClass = grandParentElementClass;
	}
	public String getParentElementClass() {
		return parentElementClass;
	}
	public void setParentElementClass(String parentElementClass) {
		this.parentElementClass = parentElementClass;
	}
	public String getParentElementTag() {
		return parentElementTag;
	}
	public void setParentElementTag(String parentElementTag) {
		this.parentElementTag = parentElementTag;
	}
	public String getChildElementTag() {
		return childElementTag;
	}
	public void setChildElementTag(String childElementTag) {
		this.childElementTag = childElementTag;
	}
	
	
	
	
}
