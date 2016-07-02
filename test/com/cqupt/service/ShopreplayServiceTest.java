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
import com.cqupt.domain.Shop;
import com.cqupt.domain.Shopreplay;
import com.cqupt.domain.User;
import com.cqupt.domain.Usercomment;

public class ShopreplayServiceTest {
	static ApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}

	@Test
	public void testSaveShopreplay() throws Exception {
		ShopreplayService shopreplayService = (ShopreplayService) context.getBean("shopreplayService");
		Shopreplay shopreplay = new Shopreplay();
		shopreplay.setContent("哈哈哈哈2");
		shopreplay.setCreatetime(new Date());
		
		User user = new User();
		user.setUserid(1);
		shopreplay.setUser(user);
		Shop shop = new Shop();
		shop.setShopid(1);
		shopreplay.setShop(shop);
		shopreplay.setState(0);
	
		Shopreplay a = shopreplayService.saveShopreply(shopreplay);
		Assert.assertNotNull(a.getContent());
		
	}
	
	@Test
	public void testDelShopreplay() throws Exception {
		ShopreplayService shopreplayService = (ShopreplayService) context.getBean("shopreplayService");
		int id = 5;
		shopreplayService.delShopreply(id);
		
		
	}
	
	@Test
	public void testUpdateShopreplay() throws Exception {
		ShopreplayService shopreplayService = (ShopreplayService) context.getBean("shopreplayService");
		Shopreplay shopreplay = new Shopreplay();
		shopreplay.setContent("哈哈哈哈");
		shopreplay.setCreatetime(new Date());
		
		User user = new User();
		user.setUserid(1);
		shopreplay.setUser(user);
		Shop shop = new Shop();
		shop.setShopid(1);
		shopreplay.setShop(shop);
		shopreplay.setState(0);
	
		Shopreplay a = shopreplayService.saveShopreply(shopreplay);
		Assert.assertNotNull(a.getContent());
		a.setContent("美女请留步");
		Shopreplay a2 = shopreplayService.updateShopreply(a);
		Assert.assertNotNull(a2.getContent());
		
	}
	
	@Test
	public void testQuery(){
		ShopreplayService shopreplayService = (ShopreplayService) context.getBean("shopreplayService");
		Shopreplay shopreplay = new Shopreplay();
		shopreplay.setShopreplayid(1);
		List<Shopreplay> list = shopreplayService.queryShopreply(shopreplay);
		Assert.assertEquals(1, list.size());
	}
	
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
