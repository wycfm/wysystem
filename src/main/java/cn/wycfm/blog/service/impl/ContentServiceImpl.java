package cn.wycfm.blog.service.impl;

import java.util.List;
import java.util.Map;

import cn.wycfm.blog.dao.ContentDao;
import cn.wycfm.blog.dao.impl.ContentDaoImpl;
import cn.wycfm.blog.model.Content;
import cn.wycfm.blog.service.ContentService;
import cn.wycfm.core.model.ResultBean;

public class ContentServiceImpl implements ContentService{

	
	public List<Map<String, Object>> listContent() throws Exception {
		ContentDao contentDao = new ContentDaoImpl();
		return contentDao.listContent();
	}

	public ResultBean<Integer> addContent(Content content) throws Exception {
		ResultBean<Integer> result = new ResultBean<Integer>();
		
		return result;
	}

}
