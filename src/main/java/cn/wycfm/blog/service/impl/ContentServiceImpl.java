package cn.wycfm.blog.service.impl;

import java.util.List;
import java.util.Map;

import cn.wycfm.blog.dao.ContentDao;
import cn.wycfm.blog.dao.impl.ContentDaoImpl;
import cn.wycfm.blog.service.ContentService;

public class ContentServiceImpl implements ContentService{

	private ContentDao contentDao = null;
	
	public List<Map<String, Object>> listContent() throws Exception {
		contentDao = new ContentDaoImpl();
		return contentDao.listContent();
	}

}
