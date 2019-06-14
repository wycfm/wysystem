package cn.wycfm.blog.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.wycfm.blog.model.Content;

public interface ContentDao {
	
	public List<Map<String, Object>> listContent(Integer userId, String title) throws SQLException;
	
	public int addContent(Content content, Integer userId) throws Exception;
	
	public int addContentTag(String tagName) throws Exception;
}
