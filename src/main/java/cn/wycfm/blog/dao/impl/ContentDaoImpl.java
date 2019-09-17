package cn.wycfm.blog.dao.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import cn.wycfm.blog.dao.ContentDao;
import cn.wycfm.blog.model.Content;
import cn.wycfm.core.dao.BaseDao;
import cn.wycfm.core.jdbc.ResultSetExtractor;
import cn.wycfm.core.util.DBUtil;
import cn.wycfm.db.DBAccess;

public class ContentDaoImpl extends BaseDao implements ContentDao{

	public List<Map<String, Object>> listContent(Integer userId, String title) throws SQLException {
		List<Map<String, Object>> result = new ArrayList<Map<String,Object>>();
		Connection con = DBUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		StringBuilder sq = new StringBuilder();
		sq.append(" select c.user_id,c.tag_id,c.type_id,ce.title,ce.description,ce.release_date, u.nickname,ct.tag_name,ctype.type_name,ctype.type_url  ");
		sq.append(" from content c ");
		sq.append(" left join content_ext ce on ce.content_id=c.content_id ");
		sq.append(" left join user u on u.user_id=c.user_id");
		sq.append(" left join content_tag ct on ct.tag_id=c.tag_id");
		sq.append(" left join content_type ctype on ctype.type_id=c.type_id");
		sq.append(" where c.user_id=? ");
		ps = con.prepareStatement(sq.toString());
		rs = ps.executeQuery();
		//ps.executeUpdate(sql, 1);
		while(rs.next()) {
			Map<String, Object> m = new HashMap<String, Object>();
			m.put("userId", rs.getInt("user_id"));
			m.put("tagId", rs.getInt("tag_id"));
			m.put("typeId", rs.getInt("type_id"));
			m.put("title", rs.getString("title"));
			m.put("description", rs.getString("description"));
			m.put("releaseDate", rs.getString("release_date"));
			m.put("nickname", rs.getString("nickname"));
			m.put("tagName", rs.getString("tag_name"));
			m.put("typeName", rs.getString("type_name"));
			m.put("typeUrl", rs.getString("type_url"));
			result.add(m);
		}
		return result;
	}

	public int addContent(Content content, Integer userId) throws Exception {
		/*
		String contentTagSql = "insert into content_tag(tag_name) values(?)";
		Object[] args = new Object[] {content.getContentTag()};
		int[] argTypes = new int[] {Types.VARCHAR};
		int tagId = this.insertAndGetKey(contentTagSql, args, argTypes);
		*/
		
		String contentSql = "insert into content(user_id,tag_id,type_id,status) values(?,?,?,1)";
		Object[] args = new Object[] {userId, content.getTagId(), content.getTypeId()};
		int[] argTypes = new int[] {Types.INTEGER, Types.INTEGER, Types.INTEGER};
		int contentId = this.insertAndGetKey(contentSql, args, argTypes);
		
		String contentExtSql = "insert into content_ext(content_id,title,origin,origin_url,description,release_date,need_regenerate) values(?,?,?,?,?,?,?)";
		args = new Object[] {contentId, content.getTitle(), content.getOrigin(), 
				content.getOriginUrl(), content.getDescription(), content.getReleaseDate(), content.getNeedRegenerate()};
		argTypes = new int[] {Types.INTEGER, Types.VARCHAR, Types.VARCHAR, 
				Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP, Types.INTEGER};
		this.executeForUpdate(contentExtSql, args, argTypes);
		
		String contentTxtSql = "insert into content_txt(content_id,txt) values(?,?)";
		args = new Object[] {contentId, content.getTxt()};
		argTypes = new int[] {Types.INTEGER, Types.VARCHAR};
		this.executeForUpdate(contentTxtSql, args, argTypes);
		
		return contentId;
	}

	public int addContentTag(String tagName) throws Exception {
		
		String sql = " select tag_id from content_tag where tag_name=?";
		int id = (Integer) this.queryForObject(sql, new Object[] {tagName}, new int[] {Types.VARCHAR}, new ResultSetExtractor<Object>() {
			public Object extractData(ResultSet rs) throws SQLException {
				int tagId = 0;
				while(rs.next()) {
					tagId = rs.getInt(1);
				}
				return tagId;
			}
		});
		if(id>0) {
			return id;
		}else {
			String contentTagSql = "insert into content_tag(tag_name) values(?)";
			Object[] args = new Object[] {tagName};
			int[] argTypes = new int[] {Types.VARCHAR};
			int tagId = this.insertAndGetKey(contentTagSql, args, argTypes);
			return tagId;
		}
	}
	
	public List<Map<String,String>> queryContentList(){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSession();
			sqlSession.selectList("");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(sqlSession!=null)
				sqlSession.close();
		}
		return null;
	}
	
	public static void main(String[] args) {
		ContentDaoImpl c = new ContentDaoImpl();
		c.queryContentList();
	}

}
