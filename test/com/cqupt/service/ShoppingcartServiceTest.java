package com.cqupt.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.domain.Goods;
import com.cqupt.domain.Shoppingcart;
import com.cqupt.domain.User;

public class ShoppingcartServiceTest {

	static ApplicationContext context = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}

	@Test
	public void testSave() {
		ShoppingCartService shoppingCartService=(ShoppingCartService)context.getBean("shoppingCartService");
		Goods goods = new Goods();
		goods.setGoodsid(1);
		User user = new User();
		user.setUserid(1);
		Shoppingcart shoppingcart = new Shoppingcart();
		shoppingcart.setGoods(goods);
		shoppingcart.setUser(user);
		shoppingcart.setGoodsnum(7);
		shoppingcart.setCreatetime(new Date());
		Shoppingcart s = shoppingCartService.saveShoppingcart(shoppingcart);
		Assert.assertNotNull(s.getShoppingcartid());
	}
	
	@Test
	public void testUpdate(){
		ShoppingCartService shoppingCartService=(ShoppingCartService)context.getBean("shoppingCartService");
		Shoppingcart shoppingcart = shoppingCartService.getShoppingCart(5);
		shoppingcart.setGoodsnum(12);
		Shoppingcart s = shoppingCartService.updateShoppingcart(shoppingcart);
		
		Assert.assertEquals(12, s.getGoodsnum());
		
	}
	
	@Test
	public void testDel(){
		ShoppingCartService shoppingCartService=(ShoppingCartService)context.getBean("shoppingCartService");
		shoppingCartService.delShoppingcart(5);
		Shoppingcart s = shoppingCartService.getShoppingCart(5);
		
		Assert.assertNull(s);
	}
	
	@Test
	public void testQuery(){
		ShoppingCartService shoppingCartService=(ShoppingCartService)context.getBean("shoppingCartService");
		Shoppingcart shoppingcart = new Shoppingcart();
		shoppingcart.setShoppingcartid(4);
		List<Shoppingcart> list = shoppingCartService.queryShoppingcart(shoppingcart);
		Assert.assertEquals(1, list.size());
	}

}
