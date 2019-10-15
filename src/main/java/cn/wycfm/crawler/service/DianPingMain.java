package cn.wycfm.crawler.service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.wycfm.crawler.model.AUrlModel;

import java.util.Map.Entry;

public class DianPingMain {

	public static void main(String[] args) {
	/*	
		DianPingCategoryCrawler dc = new DianPingCategoryCrawler("http://www.dianping.com/suzhou/baby","secondaryCategory",null,"a");
		Map<String, String> categoryUrl = dc.getCategoryUrl();
		Set<Entry<String,String>> entrySet = categoryUrl.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			//System.out.println(next.getKey()+":"+next.getValue());
			Map<String, String> areaM = new DianPingCategoryCrawler(next.getValue(),"t-district","ul","a").getCategoryUrl();
			Set<Entry<String,String>> areaSet = areaM.entrySet();
			Iterator<Entry<String, String>> areaIt = areaSet.iterator();
			while(areaIt.hasNext()) {
				Entry<String, String> areaE = areaIt.next();
				//System.out.println(areaE.getKey()+":"+areaE.getValue());
				new DianPingListByCategoryCrawler("苏州",areaE.getKey(),next.getKey(),areaE.getValue());
				
			}
			
		}*/
		
		/*DianPingCategoryCrawler dc = new DianPingCategoryCrawler("http://www.dianping.com/shanghai/baby","secondaryCategory",null,"a");
		Map<String, String> categoryUrl = dc.getCategoryUrl();
		Set<Entry<String,String>> entrySet = categoryUrl.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			//System.out.println(next.getKey()+":"+next.getValue());
			Map<String, String> areaM = new DianPingCategoryCrawler(next.getValue(),"t-district","ul","a").getCategoryUrl();
			Set<Entry<String,String>> areaSet = areaM.entrySet();
			Iterator<Entry<String, String>> areaIt = areaSet.iterator();
			while(areaIt.hasNext()) {
				Entry<String, String> areaE = areaIt.next();
				//System.out.println(areaE.getKey()+":"+areaE.getValue());
				new DianPingListByCategoryCrawler("上海",areaE.getKey(),next.getKey(),areaE.getValue());
				
			}
			
		}*/
		
		CrawlerATagUrlService cas = new CrawlerATagUrlService("https://www.cnblogs.com/","div.post_item_body a.titlelnk");
		List<AUrlModel> crawlerAUrlBySelect = cas.crawlerAUrlBySelect();
		for(AUrlModel a : crawlerAUrlBySelect) {
			System.out.println(a.getAText()+":"+a.getHref());
		}
	}
}
