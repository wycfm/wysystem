package cn.wycfm.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import cn.wycfm.core.model.User;
import cn.wycfm.core.service.impl.UserServiceImpl;


public class UserServiceTest{

	private UserService userService;
	
	@Before
	public void init() {
		userService = new UserServiceImpl();
	}
	@Test
	public void saveUser() {
		User user = new User("wuyan","111111","wy测试","虚幻的故事","12345644346","wy@wycfm.cn","0.0.0.0","0.0.0.0");
		
		userService.saveUser(user);
		User findUser = userService.getUser("wuyan", "111111");
		assertNotNull("getUser null",findUser);
		assertEquals(user.getUserName(), findUser.getUserName());
	}
	
	@Test
	public void getUser() {
		User findUser = userService.getUser("wuyan", "111111");
		assertNotNull("getUser null",findUser);
		assertEquals("wuyan", findUser.getUserName());
	}
}
