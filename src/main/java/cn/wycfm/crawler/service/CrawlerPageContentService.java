package cn.wycfm.crawler.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.wycfm.crawler.model.CrawlerItemModel;
import cn.wycfm.crawler.util.CrawlerUtil;

public class CrawlerPageContentService {

	private String url;
	
	private String selectStr;
	
	private List<CrawlerItemModel> items;
	
	public CrawlerPageContentService(String url, String selectStr, List<CrawlerItemModel> items) {
		this.url = url;
		this.selectStr = selectStr;
		this.items = items;
	}
	
	public List<Map<String,String>> crawlerContent(){
		List<Map<String,String>> result = new ArrayList<Map<String,String>>();
		
		String crawlerHtml = CrawlerUtil.crawlerData(url);
		Document document = Jsoup.parse(crawlerHtml);
		Elements select = document.select(selectStr);
		Iterator<Element> iterator = select.iterator();
		while(iterator.hasNext()) {
			Element next = iterator.next();
			result.add(analyzeElement(next));
		}
		
		return result;
	}
	
	public Map<String,String> analyzeElement(Element element){
		Map<String,String> m = new HashMap<String,String>();
		if(items!=null && items.size()>0) {
			for(int i=0; i<items.size(); i++) {
				CrawlerItemModel item = items.get(i);
				Element selectFirst = element.selectFirst(item.getSelectStr());
				m.put(item.getColumnName(), selectFirst.text());
			}
		}
		return m;
	}
}
