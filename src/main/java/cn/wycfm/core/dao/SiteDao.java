package cn.wycfm.core.dao;

import java.util.List;

import cn.wycfm.core.model.Site;

public interface SiteDao {

	List<Site> listSite() throws Exception;
	Site getSite(String domain) throws Exception;
	void saveSite(Site site) throws Exception;
}
