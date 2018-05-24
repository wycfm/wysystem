package cn.wycfm.core.service.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wycfm.core.dao.UserDao;
import cn.wycfm.core.dao.impl.UserDaoImpl;
import cn.wycfm.core.model.User;
import cn.wycfm.core.service.UserService;

public class UserServiceImpl implements UserService{

	private UserDao userDao;
	
	public User getUser(String userName, String password) {
		userDao = new UserDaoImpl();
		if(userName != null && password != null) {
			try {
				return userDao.getUser(userName, password);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public List<User> listUser(Integer size, Integer offSet) {
		userDao = new UserDaoImpl();
		if(size == null || offSet == null) {
			size = 10;
			offSet = 1;
		}
		try {
			return userDao.listUser(size, offSet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<User>();
	}

	public void saveUser(User user) {
		userDao = new UserDaoImpl();
		try {
			if(user != null) {
				userDao.saveUser(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


}
