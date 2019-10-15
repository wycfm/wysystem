package cn.wycfm.crawler.service;

import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.wycfm.crawler.util.CrawlerUtil;

public class DianPingListByCategoryCrawler {

	
	private String url;
	private String city;
	private String area;
	private String category;
	
	public DianPingListByCategoryCrawler(String city,String area,String category,String url) {
		
		this.url = url;
		this.city = city;
		this.area = area;
		this.category = category;
		String html = "";
		int page = 1;
		do {
			//System.out.println(url+"p"+page);
			html = CrawlerUtil.crawlerData(url+"p"+page);
			analyzeHTMLByString(html);
			page++;
		}while(hasNextPage(html));
	}
	
	
	public void analyzeHTMLByString(String html) {
		
		
		 Document document = Jsoup.parse(html);
	        //System.out.println(html);
	        //Elements proList = document.getElementsByClass("pro_list");
	        Elements pageList = document.getElementsByClass("shop-list");
	        Elements proList = pageList.get(0).getElementsByTag("ul");
	        Iterator<Element> iterator = proList.iterator();
	        while(iterator.hasNext()) {
	        	Element next = iterator.next();
	        	Elements lis = next.getElementsByTag("li");
	        	Iterator<Element> it2 = lis.iterator();
	        	while(it2.hasNext()) {
	        		Element liNext2 = it2.next();
	        		System.out.println(city+"\t"+area+"\t"+category+"\t"+liNext2.getElementsByClass("shopname").text()+"\t"+
	        		"人均:"+liNext2.getElementsByClass("price").text()+"\t"+liNext2.getElementsByClass("comment-count").text());
	        	}
	        	
	        }
	}
	
	public int maxPage(String html) {
		Document document = Jsoup.parse(html);
   
        Elements pageList = document.getElementsByClass("Pages");
        Elements proList = pageList.get(0).getElementsByClass("PageLink");
        Element element = proList.get(proList.size()-1);
        String max = element.text();
		return Integer.valueOf(max);
	} 
	
	public boolean hasNextPage(String html) {
		Document document = Jsoup.parse(html);
    
        Elements pageList = document.getElementsByClass("Pages");
        if(pageList.size()==0)
        	return false;
        Elements proList = pageList.get(0).getElementsByClass("NextPage");
        if(proList.size()>0)
        	return true;
        return false;
	}
}
