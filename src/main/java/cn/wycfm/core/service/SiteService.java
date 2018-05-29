package cn.wycfm.core.service;

import java.util.List;

import cn.wycfm.core.model.Site;

public interface SiteService {

	Site getSite(Integer siteId);
	List<Site> listSite();
}
