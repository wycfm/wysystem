package cn.wycfm.core.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import cn.wycfm.core.dao.BaseDao;
import cn.wycfm.core.dao.UserDao;
import cn.wycfm.core.jdbc.ResultSetExtractor;
import cn.wycfm.core.model.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	public User getUser(String userName, String password) throws SQLException{
		String sql = "select user_id,username,nick_name,signature,mobile,email from user where username=? and password=md5(?)";
		Object[] args = new Object[] {userName, password};
		int[] argTypes = new int[] {Types.VARCHAR, Types.VARCHAR};
		return (User) this.queryForObject(sql, args, argTypes, new ResultSetExtractor<Object>() {
			public Object extractData(ResultSet rs) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("username"));
				user.setNickName(rs.getString("nick_name"));
				user.setSignature(rs.getString("signature"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		});
	}

	public List<User> listUser() {
		return null;
	}

	public void saveUser(User user) throws SQLException {
		
		StringBuilder sql = new StringBuilder("insert into user(username,password,nick_name,signature,mobile,email, ");
		sql.append("register_time,register_ip,is_admin,is_disabled,last_login_time,last_login_ip)")
		.append("values(?,?,?,?,?,?,")
		.append("now(),?,0,0,now(),?)");
		
		Object[] args = new Object[] {user.getUserName(), user.getPassword(), user.getNickName(), 
				user.getSignature(), user.getMobile(), user.getEmail(),
				user.getRegisterIp(), user.getLastLoginIp()};
		int[] argTypes = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
				Types.VARCHAR, Types.VARCHAR};
		this.executeForUpdate(sql.toString(), args, argTypes);
	}

}
