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

import com.cqupt.domain.Address;
import com.cqupt.domain.Order;
import com.cqupt.domain.User;

public class OrderServiceTest {
	
	static ApplicationContext context = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}

	@Test
	public void testSave() {
		OrderService orderService=(OrderService)context.getBean("orderService");
		Order order = new Order();
		order.setOrderno("test1222");
		User user = new User();
		user.setUserid(1);
		order.setUser(user);
		order.setUsertel("1111111111");
		Address addr = new Address();
		addr.setAddressid(1);
		order.setAddress(addr);
		order.setCreatetime(new Date());
		order.setOrdertime(new Date());
		
		Order o = orderService.saveOrder(order);
		Assert.assertNotNull(o.getOrderid());
	}
	
	@Test
	public void testUpdate(){
		OrderService orderService=(OrderService)context.getBean("orderService");
		Order order = orderService.getOrder(5);
		order.setOrderno("testchange");
		Order o = orderService.updateOrder(order);
		Assert.assertEquals("testchange", o.getOrderno());
	}
	
	@Test
	public void testDel(){
		OrderService orderService=(OrderService)context.getBean("orderService");
		orderService.delOrder(5);
		Order order = new Order();
		order.setOrderid(5);;
		List<Order> list = orderService.queryOrder(order);
		
		Assert.assertEquals(0, list.size());
	}
	
	@Test
	public void testQuery(){
		OrderService orderService=(OrderService)context.getBean("orderService");
		Order order = new Order();
		order.setOrderid(1);
		List<Order> list = orderService.queryOrder(order);
		Assert.assertEquals(1, list.size());
		
	}

}
