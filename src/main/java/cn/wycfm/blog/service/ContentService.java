package cn.wycfm.blog.service;

import java.util.List;
import java.util.Map;

import cn.wycfm.blog.model.Content;
import cn.wycfm.core.model.ResultBean;

public interface ContentService {

	public List<Map<String, Object>> listContent() throws Exception;
	
	public ResultBean<Integer> addContent(Content content) throws Exception;
}
