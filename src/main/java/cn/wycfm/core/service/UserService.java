package cn.wycfm.core.service;

import java.util.List;

import cn.wycfm.core.model.User;

public interface UserService {

	User getUser(String userName, String password);
	User getUser(Integer userId);
	List<User> listUser(Integer size, Integer offSet);
	void saveUser(User user);
	void updateUser(User user);
	
}
