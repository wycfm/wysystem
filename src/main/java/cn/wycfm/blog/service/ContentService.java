package cn.wycfm.blog.service;

import java.util.List;
import java.util.Map;

import cn.wycfm.blog.model.Content;
import cn.wycfm.core.model.ResultBean;
import cn.wycfm.core.model.User;

public interface ContentService {

	public List<Map<String, Object>> listContent(User user, String title) throws Exception;
	
	public ResultBean<Integer> addContent(User user, Content content);
}
