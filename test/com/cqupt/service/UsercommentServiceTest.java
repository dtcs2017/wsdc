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
import com.cqupt.domain.Areacate;
import com.cqupt.domain.Goods;
import com.cqupt.domain.User;
import com.cqupt.domain.Usercomment;

public class UsercommentServiceTest {
	static ApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}

	@Test
	public void testSaveUsercomment() throws Exception {
		UsercommentService usercommentService = (UsercommentService) context.getBean("usercommentService");
		Usercomment usecomment = new Usercomment();
		usecomment.setContent("陶白白是猪");
		User user = new User();
		user.setUserid(1);
		usecomment.setUser(user);
		Goods goods = new Goods();
		goods.setGoodsid(1);
		usecomment.setGoods(goods);
		usecomment.setCreatetime(new Date());
		usecomment.setState(0);
		Usercomment a = usercommentService.saveUsercomment(usecomment);
		Assert.assertNotNull(a.getContent());
		
	}
	
	@Test
	public void testDelUsercomment() throws Exception {
		UsercommentService usercommentService = (UsercommentService) context.getBean("usercommentService");
		int id = 5;
		usercommentService.delUsercomment(id);
		
		
	}
	
	@Test
	public void testUpdateUsercomment() throws Exception {
		UsercommentService usercommentService = (UsercommentService) context.getBean("usercommentService");
		Usercomment usecomment = new Usercomment();
		usecomment.setContent("陶白白是猪2");
		User user = new User();
		user.setUserid(1);
		usecomment.setUser(user);
		Goods goods = new Goods();
		goods.setGoodsid(1);
		usecomment.setGoods(goods);
		usecomment.setCreatetime(new Date());
		usecomment.setState(0);
		Usercomment a = usercommentService.saveUsercomment(usecomment);
		a.setContent("陶白白是猪3");
		Usercomment a2 = usercommentService.updateUsercomment(a);
		Assert.assertNotNull(a2.getContent());
		
	}
	
	@Test
	public void testQuery(){
		UsercommentService usercommentService = (UsercommentService) context.getBean("usercommentService");
		Usercomment usercomment = new Usercomment();
		usercomment.setUsercommentid(1);
		List<Usercomment> list = usercommentService.queryUsercomment(usercomment);
		Assert.assertEquals(1, list.size());
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
