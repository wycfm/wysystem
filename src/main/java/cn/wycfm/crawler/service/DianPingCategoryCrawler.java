package cn.wycfm.crawler.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.wycfm.crawler.util.CrawlerUtil;

public class DianPingCategoryCrawler {

	
	//private static String URL ="http://www.dianping.com/suzhou/baby";
	
	private String url;
	private String parentElementClass;
	private String parentElementTag;
	private String childElementTag;
	
	
	public DianPingCategoryCrawler(String url,String parentElementClass, String parentElementTag,String childElementTag) {
		this.url = url;
		this.parentElementClass = parentElementClass;
		this.parentElementTag = parentElementTag;
		this.childElementTag = childElementTag;
	}
	
	public Map<String,String> getCategoryUrl(){
		Map<String,String> m = new HashMap<String,String>();
		String crawlerHtml = CrawlerUtil.crawlerData(url);
		Document document = Jsoup.parse(crawlerHtml);
        String baseUrl = getIndexBase();
        
        Elements sc = document.getElementsByClass(parentElementClass);
		Iterator<Element> itSc = sc.iterator();
		while(itSc.hasNext()) {
			Element next = itSc.next();
			Elements childElements;
			if(parentElementTag!=null) {
				Elements elementsByTag = next.getElementsByTag(parentElementTag);
				Element element = elementsByTag.get(0);
				childElements = element.getElementsByTag(childElementTag);
			}else {
				childElements = next.getElementsByTag(childElementTag);
			}
			
			Iterator<Element> itTag = childElements.iterator();
			while(itTag.hasNext()) {
				Element nextTag = itTag.next();
				String categoryName = nextTag.text();
				String url = nextTag.attr("href");
				m.put(categoryName, baseUrl+url);
			}
			
		}
		return m;
	}
	
	public String getIndexBase() {
		int indexOf = url.indexOf(".com");
		return url.substring(0, indexOf+4);
	}
	
	public static void main(String[] args) {
		DianPingCategoryCrawler dc = new DianPingCategoryCrawler("http://www.dianping.com/suzhou/baby","secondaryCategory",null,"a");
		Map<String, String> categoryUrl = dc.getCategoryUrl();
		Set<Entry<String,String>> entrySet = categoryUrl.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			System.out.println(next.getKey()+":"+next.getValue());
			Map<String, String> areaM = new DianPingCategoryCrawler(next.getValue(),"t-district","ul","a").getCategoryUrl();
			Set<Entry<String,String>> areaSet = areaM.entrySet();
			Iterator<Entry<String, String>> areaIt = areaSet.iterator();
			while(areaIt.hasNext()) {
				Entry<String, String> areaE = areaIt.next();
				System.out.println(areaE.getKey()+":"+areaE.getValue());
				
			}
			
		}
		
	}
}
