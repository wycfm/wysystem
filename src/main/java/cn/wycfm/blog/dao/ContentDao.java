package cn.wycfm.blog.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.wycfm.blog.model.Content;

public interface ContentDao {
	
	public List<Map<String, Object>> listContent() throws SQLException;
	
	public int addContent(Content content, Integer userId) throws Exception;
}
