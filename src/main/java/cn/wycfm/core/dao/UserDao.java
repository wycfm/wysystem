package cn.wycfm.core.dao;

import java.util.List;

import cn.wycfm.core.model.User;

public interface UserDao {

	User getUser(String userName, String password) ;
	List<User> listUser();
	void saveUser(User user);
}
