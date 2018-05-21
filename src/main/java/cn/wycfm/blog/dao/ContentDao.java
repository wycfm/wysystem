package cn.wycfm.blog.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ContentDao {
	
	public List<Map<String, Object>> listContent() throws SQLException;
}
