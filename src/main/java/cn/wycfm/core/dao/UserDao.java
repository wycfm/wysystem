package cn.wycfm.core.dao;

import java.sql.SQLException;
import java.util.List;

import cn.wycfm.core.model.User;

public interface UserDao {

	User getUser(String userName, String password) throws SQLException;
	List<User> listUser()  throws SQLException;;
	void saveUser(User user)  throws SQLException;;
}
