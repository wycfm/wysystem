package cn.wycfm.core.dao;

import java.sql.Connection;
import java.util.List;

public abstract class BaseDao {
	
	public Object queryForObject(String sql, Object[] args, int[] argTypes) {
		Connection connection = null;
	
		
		return null;
	}
	
	public List queryForList() {
		
		
		return null;
	}
	
	public int executeForUpdate() {
		
		
		return 0;
	}
}
