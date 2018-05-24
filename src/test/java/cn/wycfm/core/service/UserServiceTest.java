package cn.wycfm.core.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

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
	//@Test
	public void testSaveUser() {
		User user = new User("wuyan","111111","wy测试","虚幻的故事","12345644346","wy@wycfm.cn","0.0.0.0","0.0.0.0");
		
		userService.saveUser(user);
		User findUser = userService.getUser("wuyan", "111111");
		assertNotNull("getUser null",findUser);
		assertEquals(user.getUserName(), findUser.getUserName());
	}
	
	//@Test
	public void testGetUser() {
		User findUser = userService.getUser("wuyan", "111111");
		System.out.println(findUser);
		assertNotNull("getUser null",findUser);
		assertEquals("wuyan", findUser.getUserName());
	}
	@Test
	public void testListUser() {
		List<User> listUser = userService.listUser(10,1);
		for (User user : listUser) {
			System.out.println(user);
		}
		assertNotNull("list User null", listUser.get(0));
	}
}
