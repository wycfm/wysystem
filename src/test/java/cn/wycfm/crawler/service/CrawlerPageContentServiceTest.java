package cn.wycfm.crawler.service;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.junit.Test;

import cn.wycfm.crawler.model.CrawlerItemModel;

public class CrawlerPageContentServiceTest {

	@Test
	public void testCrawlerContent() {
		List<CrawlerItemModel> items = new ArrayList<CrawlerItemModel>();
		items.add(new CrawlerItemModel("title","a.titlelnk"));
		items.add(new CrawlerItemModel("desc","p.post_item_summary"));
		items.add(new CrawlerItemModel("author","a.lightblue"));
		CrawlerPageContentService cpcs = new CrawlerPageContentService("https://www.cnblogs.com/", "div.post_item", items);
		List<Map<String,String>> crawlerContent = cpcs.crawlerContent();
		for(Map<String,String> m : crawlerContent) {
			Set<Entry<String,String>> entrySet = m.entrySet();
			Iterator<Entry<String, String>> iterator = entrySet.iterator();
			while(iterator.hasNext()) {
				Entry<String, String> next = iterator.next();
				System.out.print(next.getKey()+":"+next.getValue()+"\t");
			}
			System.out.println();
		}
	}

}
