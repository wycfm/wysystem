package cn.wycfm.core.jdbc;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.sql.Types;

public class SimplePreparedStatementCreator implements PreparedStatementCreator, SqlProvider{

	private String sql;
	
	private Object[] args;
	
	private int[] argTypes;
	
	
	public SimplePreparedStatementCreator() {}
	
	public SimplePreparedStatementCreator(String sql, Object[] args, int[] argTypes) {
		this.sql = sql;
		this.args = args;
		this.argTypes = argTypes;
	}
	
	public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(sql);
		setParameter(ps);
		return ps;
	}
	
	public void setParameter(PreparedStatement ps) throws SQLException{
		if(args == null || args.length == 0) 
			return;
		int argsLength = args.length;
		if(argTypes == null || argTypes.length == 0) {
			for(int i = 0; i < argsLength; i++) {
				int index = i+1;
				String arg = args[i]+"";
				ps.setString(index, arg);
			}
			return;
		}
		for(int i = 0; i < argsLength; i++) {
			int index = i+1;
			Object o = args[i];
			String arg=(o==null)?"":(o+"");	
			switch(argTypes[i]) {
			case Types.INTEGER : 
				if(o == null) {
					ps.setNull(index, Types.INTEGER);
				}else {
					ps.setInt(index, Integer.parseInt(arg));
				}
				break;
			case Types.SMALLINT : 
				if(o == null) {
					ps.setNull(index, Types.SMALLINT);
				}else {
					ps.setInt(index, Short.parseShort(arg));
				}
				break;
			case Types.DOUBLE : 
				if(o == null) {
					ps.setNull(index, Types.SMALLINT);
				}else {
					ps.setDouble(index, Double.parseDouble(arg));
				}
				break;
			case Types.VARCHAR : 
				ps.setString(index, o==null?null:arg);
				break;
			case Types.TIMESTAMP : 
				ps.setTimestamp(index, (Timestamp)o);
				break;
			case Types.NUMERIC : 
				ps.setBigDecimal(index, o==null?null:new BigDecimal(arg));
				break;
			default : 
				ps.setString(index, arg);
				break;
			}
		}
	}

	public String getSql() {
		return this.sql;
	}
}
