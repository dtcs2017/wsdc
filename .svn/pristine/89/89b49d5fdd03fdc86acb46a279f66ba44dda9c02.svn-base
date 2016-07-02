package com.cqupt.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.domain.Orderdetail;

public class OrderdetailServiceTest {

	static ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}
	

	@Test
	public void testQueryOrderdetail() throws Exception{
		OrderdetailService orderdetailService=(OrderdetailService) context.getBean("orderdetailService");
		Orderdetail orderdetail=orderdetailService.getOrderdetail(1);
		
		List<Orderdetail> list=orderdetailService.queryOrderdetail(orderdetail);
        Assert.assertEquals(1, list.size());		
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
