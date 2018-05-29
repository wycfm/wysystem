package cn.wycfm.blog.service.impl;

import java.util.List;
import java.util.Map;

import cn.wycfm.blog.dao.ContentDao;
import cn.wycfm.blog.dao.impl.ContentDaoImpl;
import cn.wycfm.blog.service.ContentService;

public class ContentServiceImpl implements ContentService{

	
	public List<Map<String, Object>> listContent() throws Exception {
		ContentDao contentDao = new ContentDaoImpl();
		return contentDao.listContent();
	}

}
