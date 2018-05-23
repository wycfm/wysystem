package cn.wycfm.core.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import cn.wycfm.core.jdbc.ParameterizedRowMapper;
import cn.wycfm.core.jdbc.PreparedStatementCallback;
import cn.wycfm.core.jdbc.PreparedStatementCreator;
import cn.wycfm.core.jdbc.ResultSetExtractor;
import cn.wycfm.core.jdbc.SimplePreparedStatementCreator;
import cn.wycfm.core.jdbc.SqlProvider;
import cn.wycfm.core.util.DBUtil;


public abstract class BaseDao {
	public static Logger logger = Logger.getLogger(BaseDao.class);
	
	public Object queryForObject(String sql, Object[] args, int[] argTypes, ResultSetExtractor<Object> rse) throws SQLException{
		PreparedStatementCreator psc = new SimplePreparedStatementCreator(sql, args, argTypes);
		return query(psc, rse);
	}
	
	public List queryForList(String sql, Object[] args, int[] argTypes, ParameterizedRowMapper<Object> prm) {
		
		
		return null;
	}
	
	public int executeForUpdate(String sql, Object[] args, int[] argTypes) throws SQLException{
		PreparedStatementCreator psc = new SimplePreparedStatementCreator(sql, args, argTypes);
		
		return update(psc);
	}
	
	
	public int update(PreparedStatementCreator psc) throws SQLException{
		
		return execute(psc, new PreparedStatementCallback<Integer>() {
			public Integer doInPreparedStatement(PreparedStatement ps) throws SQLException {
				int rows = ps.executeUpdate();
				return rows;
			}
		});
	}
	
	
	public <T> T query(PreparedStatementCreator psc, final ResultSetExtractor<T> rse) throws SQLException{
		
		return execute(psc, new PreparedStatementCallback<T>() {
			public T doInPreparedStatement(PreparedStatement ps) throws SQLException {
				ResultSet rs = null;
				try {
					rs = ps.executeQuery();
					return rse.extractData(rs);
				}
				finally {
					DBUtil.closeResultSet(rs);
				}
				
			}
		} );
	}
	
	public <T> T execute(PreparedStatementCreator psc, PreparedStatementCallback<T> action) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		if(logger.isDebugEnabled()) {
			String sql = getSql(psc);
			logger.debug("Executing prepared SQL statement" + (sql != null ? " [" + sql + "]" : ""));
		}
		try {
			con = DBUtil.getConnection();
			ps = psc.createPreparedStatement(con);
			T result = action.doInPreparedStatement(ps);
			return result;
		} catch (SQLException e) {
			String sql = getSql(psc);
			psc = null;
			DBUtil.closeStatement(ps);
			ps = null;
			DBUtil.releaseConnection(con);
			con = null;
			throw new SQLException("PreparedStatementCallback",sql,e);
		}
		finally {
			DBUtil.closeStatement(ps);
			DBUtil.releaseConnection(con);
		}
	}
	
	public String getSql(Object sqlProvider) {
		if(sqlProvider instanceof SqlProvider) {
			return ((SqlProvider) sqlProvider).getSql();
		}else {
			return null;
		}
	}
}
