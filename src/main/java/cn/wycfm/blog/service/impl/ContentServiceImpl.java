package cn.wycfm.blog.service.impl;

import java.util.List;
import java.util.Map;

import cn.wycfm.blog.dao.ContentDao;
import cn.wycfm.blog.dao.impl.ContentDaoImpl;
import cn.wycfm.blog.model.Content;
import cn.wycfm.blog.service.ContentService;
import cn.wycfm.core.model.ResultBean;
import cn.wycfm.core.model.User;

public class ContentServiceImpl implements ContentService{

	
	public List<Map<String, Object>> listContent(User user, String title) throws Exception {
		ContentDao contentDao = new ContentDaoImpl();
		return contentDao.listContent(user.getUserId(), title);
	}

	public ResultBean<Integer> addContent(User user, Content content){
		ResultBean<Integer> result = new ResultBean<Integer>();
		ContentDao contentDao = new ContentDaoImpl();
		int contentId=0;
		try {
			if(content.getContentTag()!=null) {
				int tagId = contentDao.addContentTag(content.getContentTag());
				content.setTagId(tagId);
			}
			
			contentId = contentDao.addContent(content, user.getUserId());
			result.setResult(contentId);
			result.setCode("200");
			result.setDescription("success");
		} catch (Exception e) {
			result.setResult(0);
			result.setCode("500");
			result.setDescription("error");
			e.printStackTrace();
		}
		
		return result;
	}

}
