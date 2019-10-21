package cn.wycfm.crawler.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import cn.wycfm.core.model.ResultBean;
import cn.wycfm.crawler.model.AUrlModel;
import cn.wycfm.crawler.service.CrawlerService;

public class CrawlerServiceImpl implements CrawlerService{
	
	private static final Logger log = Logger.getLogger(CrawlerServiceImpl.class);

	public ResultBean<List<AUrlModel>> getAUrlModelList(String urls, String selectStr) {
		ResultBean<List<AUrlModel>> result = new ResultBean<List<AUrlModel>>();
		List<AUrlModel> list = new ArrayList<AUrlModel>();
		result.setCode("200");
		result.setStatus("success");
		try {
			if(urls !=null && selectStr!=null && !urls.equals("") && !selectStr.equals("")) {
				String[] urlArr = urls.split(",");
				for(String u : urlArr) {
					list.addAll(crawlerAUrlBySelect(u,selectStr));
				}
			}
		} catch (Exception e) {
			result.setCode("500");
			result.setStatus("error");
			result.setDescription(e.getMessage());
			log.error(e.getMessage());
		}
		result.setResult(list);
		return result;
	}

	/**
	 * 根据select  抓取页面目标 url
	 * @return
	 */
	public List<AUrlModel> crawlerAUrlBySelect(String url, String selectStr) throws Exception{
		List<AUrlModel> result = new ArrayList<AUrlModel>();
		
		//String crawlerHtml = CrawlerUtil.crawlerData(url);
		
		Document document;
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
		
		
		return result;
	}
}
