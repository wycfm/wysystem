package cn.wycfm.core.dao.impl;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.wycfm.core.dao.BaseDao;
import cn.wycfm.core.dao.UserDao;
import cn.wycfm.core.jdbc.ParameterizedRowMapper;
import cn.wycfm.core.jdbc.ResultSetExtractor;
import cn.wycfm.core.model.User;
import cn.wycfm.db.DBAccess;

public class UserDaoImpl extends BaseDao implements UserDao {

	public User getUser(String userName, String password) throws SQLException{
		String sql = "select user_id,username,nickname,signature,mobile,email from user where username=? and password=md5(?)";
		Object[] args = new Object[] {userName, password};
		int[] argTypes = new int[] {Types.VARCHAR, Types.VARCHAR};
		return (User) this.queryForObject(sql, args, argTypes, new ResultSetExtractor<Object>() {
			public Object extractData(ResultSet rs) throws SQLException {
				
				User user = new User();
				while(rs.next()) {
					user.setUserId(rs.getInt("user_id"));
					user.setUserName(rs.getString("username"));
					user.setNickName(rs.getString("nickname"));
					user.setSignature(rs.getString("signature"));
					user.setMobile(rs.getString("mobile"));
					user.setEmail(rs.getString("email"));
				}
				return user;
			}
		});
	}

	public User getUser(Integer userId) throws SQLException {
		
		String sql = "select user_id,username,nickname,signature,mobile,email from user where user_id=?";
		Object[] args = new Object[] {userId};
		int[] argTypes = new int[] {Types.INTEGER};
		return (User) this.queryForObject(sql, args, argTypes, new ResultSetExtractor<Object>() {
			public Object extractData(ResultSet rs) throws SQLException {
				
				User user = new User();
				while(rs.next()) {
					user.setUserId(rs.getInt("user_id"));
					user.setUserName(rs.getString("username"));
					user.setNickName(rs.getString("nickname"));
					user.setSignature(rs.getString("signature"));
					user.setMobile(rs.getString("mobile"));
					user.setEmail(rs.getString("email"));
				}
				return user;
			}
		});
	}
	@SuppressWarnings("unchecked")
	public List<User> listUser(Integer size, Integer offSet) throws SQLException{
		String sql = "select user_id,username,nickname,signature,mobile,email from user limit ? offset ?";
		Object[] args = new Object[] {size, (offSet-1)*size};
		int[] argTypes = new int[] {Types.INTEGER, Types.INTEGER};
		
		return this.queryForList(sql, args, argTypes, new ParameterizedRowMapper<Object>() {
			
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setUserId(rs.getInt("user_id"));
				user.setUserName(rs.getString("username"));
				user.setNickName(rs.getString("nickname"));
				user.setSignature(rs.getString("signature"));
				user.setMobile(rs.getString("mobile"));
				user.setEmail(rs.getString("email"));
				return user;
			}
		});
	}

	public void saveUser(User user) throws SQLException {
		
		StringBuilder sql = new StringBuilder("insert into user(username,password,nickname,signature,mobile,email, ");
		sql.append("register_time,register_ip,is_admin,is_disabled,last_login_time,last_login_ip)")
		.append("values(?,md5(?),?,?,?,?,")
		.append("now(),?,0,0,now(),?)");
		
		Object[] args = new Object[] {user.getUserName(), user.getPassword(), user.getNickName(), 
				user.getSignature(), user.getMobile(), user.getEmail(),
				user.getRegisterIp(), user.getLastLoginIp()};
		int[] argTypes = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
				Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, 
				Types.VARCHAR, Types.VARCHAR};
		this.executeForUpdate(sql.toString(), args, argTypes);
	}

	public void updateUser(User user) throws SQLException {
		
		String sql = new String("update user set update_time=now(),mobile=?,email=?,signature=? where user_id=? ");
		
		Integer userId = user.getUserId();
		String mobile = user.getMobile();
		String email = user.getEmail();
		String signature = user.getSignature();
		Object[] args = new Object[] {mobile, email, signature, userId};
		int[] argTypes = new int[] {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
		this.executeForUpdate(sql, args, argTypes);
	}
	
	public User getUserForLogin(User user) {
		DBAccess dbAccess = new DBAccess();
		User userResult = null;
		SqlSession sqlSession = null;
		
		try {
			sqlSession = dbAccess.getSqlSession();
			userResult = sqlSession.selectOne("User.getUserForLogin", user);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return userResult;
	}

}
