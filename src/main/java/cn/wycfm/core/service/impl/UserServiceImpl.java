package cn.wycfm.core.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wycfm.core.dao.UserDao;
import cn.wycfm.core.dao.impl.UserDaoImpl;
import cn.wycfm.core.model.User;
import cn.wycfm.core.service.UserService;

public class UserServiceImpl implements UserService{

	
	public User getUser(String userName, String password) {
		UserDao userDao = new UserDaoImpl();
		if(userName != null && password != null) {
			try {
				return userDao.getUser(userName, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public User getUser(Integer userId) {
		UserDao userDao = new UserDaoImpl();
		if(userId != null ) {
			try {
				return userDao.getUser(userId);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	public List<User> listUser(Integer size, Integer offSet) {
		UserDao userDao = new UserDaoImpl();
		if(size == null || offSet == null) {
			size = 10;
			offSet = 1;
		}
		try {
			return userDao.listUser(size, offSet);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return new ArrayList<User>();
	}

	public void saveUser(User user) {
		UserDao userDao = new UserDaoImpl();
		try {
			if(user != null) {
				userDao.saveUser(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUser(User user) {
		UserDao userDao = new UserDaoImpl();
		try {
			userDao.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
