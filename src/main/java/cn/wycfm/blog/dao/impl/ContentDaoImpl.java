package cn.wycfm.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.wycfm.blog.dao.ContentDao;
import cn.wycfm.core.util.DBUtil;

public class ContentDaoImpl implements ContentDao{

	public List<Map<String, Object>> listContent() throws SQLException {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		Connection con = DBUtil.getConnection();
		PreparedStatement prepareStatement = null;
		ResultSet rs = null;
		String sql = " select id,name from test_table";
		prepareStatement = con.prepareStatement(sql);
		rs = prepareStatement.executeQuery();
		while(rs.next()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", rs.getInt(1));
			m.put("name", rs.getString(2));
			result.add(m);
		}
		return result;
	}

}
