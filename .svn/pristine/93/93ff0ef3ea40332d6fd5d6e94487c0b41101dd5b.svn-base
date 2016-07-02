package com.cqupt.service;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.domain.Admin;
import com.cqupt.domain.User;

public class UserServiceTest {
	static ApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}

	@Test
	public void testSaveUser() throws Exception {
		UserService userService = (UserService) context.getBean("userService");
		User user = new User();
		user.setUsername("zhangsan");
		user.setPassword("test");
		user.setSex(0);
		user.setEmail("100930293@qq.com");
		user.setState(1);
		user.setCreatetime(new Date());
		User u = userService.saveUser(user);
		Assert.assertNotNull(u.getUserid());
	}
	
	@Test
	public void testDelUser() throws Exception {
		UserService userService = (UserService) context.getBean("userService");
		userService.delUser(5);
		
		
	}
	
	@Test
	public void testUpdateUser() throws Exception {
		UserService userService = (UserService) context.getBean("userService");
		User user = new User();
		user.setUsername("lisi");
		user.setPassword("test");
		user.setSex(0);
		user.setEmail("1009302www.com");
		user.setState(1);
		user.setCreatetime(new Date());
		User u = userService.saveUser(user);
		Assert.assertNotNull(u.getUserid());
		u.setUsername("tjy");
		User u2 = userService.updateUser(u);
		Assert.assertNotNull(u2.getUserid());
		
	}
	
	@Test
	public void testQuery(){
		UserService userService = (UserService) context.getBean("userService");
		User user = new User();
		user.setUserid(1);
		List<User> list = userService.queryUser(user);
		Assert.assertEquals(1, list.size());
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
