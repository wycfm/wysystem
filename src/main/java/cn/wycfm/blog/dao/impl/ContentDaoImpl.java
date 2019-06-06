package cn.wycfm.blog.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.wycfm.blog.dao.ContentDao;
import cn.wycfm.blog.model.Content;
import cn.wycfm.core.dao.BaseDao;
import cn.wycfm.core.util.DBUtil;

public class ContentDaoImpl extends BaseDao implements ContentDao{

	public List<Map<String, Object>> listContent() throws SQLException {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = " select id,name from test_table";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		//ps.executeUpdate(sql, 1);
		while(rs.next()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("id", rs.getInt(1));
			m.put("name", rs.getString(2));
			result.add(m);
		}
		return result;
	}

	public int addContent(Content content, Integer userId) throws Exception {
		
		String contentTagSql = "insert into content_tag(tag_name) values(?)";
		Object[] args = new Object[] {content.getContentTag()};
		int[] argTypes = new int[] {Types.INTEGER};
		int tagId = this.insertAndGetKey(contentTagSql, args, argTypes);
		
		
		String contentSql = "insert into content(user_id,tag_id,type_id,status) values(?,?,?,1)";
		args = new Object[] {userId, tagId, content.getTypeId()};
		argTypes = new int[] {Types.INTEGER, Types.INTEGER, Types.INTEGER};
		int contentId = this.insertAndGetKey(contentSql, args, argTypes);
		
		String contentExtSql = "insert into content_ext(content_id,title,origin,origin_url,description,release_date,need_regenerate) values(?,?,?,?,?,?,?)";
		args = new Object[] {contentId, content.getTitle(), content.getOrigin(), 
				content.getOriginUrl(), content.getDescription(), content.getReleaseDate(), content.getNeedRegenerate()};
		argTypes = new int[] {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, 
				Types.VARCHAR, Types.VARCHAR, Types.DATE, Types.INTEGER};
		this.executeForUpdate(contentExtSql, args, argTypes);
		
		String contentTxtSql = "insert into content_txt(content_id,txt) values(?,?)";
		args = new Object[] {contentId, content.getTxt()};
		argTypes = new int[] {Types.INTEGER, Types.VARCHAR};
		this.executeForUpdate(contentTxtSql, args, argTypes);
		
		return contentId;
	}

}
