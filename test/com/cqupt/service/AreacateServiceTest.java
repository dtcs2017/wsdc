package com.cqupt.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.domain.Admin;
import com.cqupt.domain.Areacate;
import com.cqupt.domain.User;

public class AreacateServiceTest {
	static ApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}

	@Test
	public void testSaveAreacate() throws Exception {
		AreacateService areacateService = (AreacateService) context.getBean("areacateService");
		Areacate areacate = new Areacate();
		areacate.setPid(1);
		areacate.setArea("北京朝阳区");
		Areacate a = areacateService.saveAreacate(areacate);
		Assert.assertNotNull(a.getAreacateid());
		
	}
	
	@Test
	public void testDelAreacate() throws Exception {
		AreacateService areacateService = (AreacateService) context.getBean("areacateService");
		int id = 2;
		areacateService.delAreacate(id);
		
		
	}
	
	@Test
	public void testUpdateAreacate() throws Exception {
		AreacateService areacateService = (AreacateService) context.getBean("areacateService");
		Areacate areacate = new Areacate();
		areacate.setPid(1);
		areacate.setArea("北京朝阳区2");
		Areacate a = areacateService.saveAreacate(areacate);
		a.setArea("北京朝阳区3");
		Areacate a2 = areacateService.updateAreacate(areacate);
		Assert.assertNotNull(a2.getAreacateid());
		
	}
	
	@Test
	public void testQuery(){
		AreacateService areacateService = (AreacateService) context.getBean("areacateService");
		Areacate areacate = new Areacate();
		areacate.setAreacateid(1);
		List<Areacate> list = areacateService.queryAreacate(areacate);
		Assert.assertEquals("四川省", list.get(0).getArea());
	}
	
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
