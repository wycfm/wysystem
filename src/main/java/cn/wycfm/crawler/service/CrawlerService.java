package cn.wycfm.crawler.service;

import java.util.List;

import cn.wycfm.crawler.model.AUrlModel;

public interface CrawlerService {
	
	List<AUrlModel> getAUrlModelList(String url, String select);

}
