package cn.wycfm.crawler.service;

import java.util.List;

import cn.wycfm.core.model.ResultBean;
import cn.wycfm.crawler.model.AUrlModel;

public interface CrawlerService {
	
	public ResultBean<List<AUrlModel>> getAUrlModelList(String url, String select);

}
