package cn.wycfm.crawler.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.wycfm.crawler.model.AUrlModel;
import cn.wycfm.crawler.service.CrawlerService;

public class CrawlerServiceImpl implements CrawlerService{

	public List<AUrlModel> getAUrlModelList(String urls, String selectStr) {
		List<AUrlModel> result = new ArrayList<AUrlModel>();
		if(urls !=null && selectStr!=null && !urls.equals("") && !selectStr.equals("")) {
			String[] urlArr = urls.split(",");
			for(String u : urlArr) {
				result.addAll(crawlerAUrlBySelect(u,selectStr));
			}
			
		}
		return result;
	}

	/**
	 * 根据select  抓取页面目标 url
	 * @return
	 */
	public List<AUrlModel> crawlerAUrlBySelect(String url, String selectStr){
		List<AUrlModel> result = new ArrayList<AUrlModel>();
		
		//String crawlerHtml = CrawlerUtil.crawlerData(url);
		
		Document document;
		try {
			document = Jsoup.connect(url).get();
			Elements select = document.select(selectStr);
			Iterator<Element> iterator = select.iterator();
			while(iterator.hasNext()) {
				AUrlModel aUrl = new AUrlModel();
				Element next = iterator.next();
				String href = next.attr("href");
				String aText = next.text();
				aUrl.setAText(aText);
				aUrl.setHref(href);
				result.add(aUrl);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		return result;
	}
}
