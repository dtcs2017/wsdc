package com.cqupt.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Shopcategory;

public class ShopcategoryServiceTest {

	static ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}
	@Test
	public void testSaveShopcategory() throws Exception{
		ShopcategoryService shopcategoryService=(ShopcategoryService) context.getBean("shopcategoryService");
		Shopcategory shopcategory=new Shopcategory();
		shopcategory.setPid(0);
		shopcategory.setCategory("test");
		shopcategory.setDelFlag(true);
		Shopcategory shopcate=shopcategoryService.saveShopcategory(shopcategory);
		Assert.assertNotNull(shopcate.getShopcategoryid());
	}
	
	@Test
	public void testDelShopcategory() throws Exception{
		ShopcategoryService shopcategoryService=(ShopcategoryService) context.getBean("shopcategoryService");
		Shopcategory shopcategory=new Shopcategory();
		shopcategory.setPid(0);
		shopcategory.setCategory("test");
		shopcategory.setDelFlag(true);
		Shopcategory shopcate=shopcategoryService.saveShopcategory(shopcategory);
		shopcategoryService.delShopcategory(shopcate);
		
	}
	
	@Test
	public void testUpdateShopcategory() throws Exception{
		ShopcategoryService shopcategoryService=(ShopcategoryService) context.getBean("shopcategoryService");
		Shopcategory shopcategory=shopcategoryService.getShopcategory(1);
		shopcategory.setCategory("test223");
		Shopcategory s=shopcategoryService.updateShopcategory(shopcategory);
		Assert.assertEquals("test223", s.getCategory());
	} 
	
	@Test
	public void testQueryShopcategory() throws Exception{
		ShopcategoryService shopcategoryService=(ShopcategoryService) context.getBean("shopcategoryService");
		Shopcategory shopcategory=shopcategoryService.getShopcategory(1);
		
		List<Shopcategory> list=shopcategoryService.queryShopcategory(shopcategory);
		Assert.assertEquals(1, list.size());
		
	}
	@Test
	public void testQueryShopcategoryByPage() throws Exception{
		ShopcategoryService shopcategoryService=(ShopcategoryService) context.getBean("shopcategoryService");
		Shopcategory shopcategory=shopcategoryService.getShopcategory(1);
		PageBean pageBean1=new PageBean();
		pageBean1.setAllRows(7);
		pageBean1.setCurrentPage(1);
		
		Shopcategory shopcategory2 = new Shopcategory();
		List<Shopcategory> list = shopcategoryService.queryShopcategory(shopcategory2);
		
		pageBean1.setList(list);
		pageBean1.setTotalPage(2);
		PageBean pageBean2 = shopcategoryService.queryShopcategoryByPage(shopcategory, pageBean1);
		Assert.assertEquals(1, pageBean2.getAllRows().longValue());
	}
	
	/*public static void main(String[] args){
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
		
		ShopcategoryService shopcategoryService=(ShopcategoryService) context.getBean("shopcategoryService");
		Shopcategory shopcategory=shopcategoryService.getShopcategory(1);
		PageBean pageBean1=new PageBean();
		pageBean1.setAllRows(7);
		pageBean1.setCurrentPage(1);
		
		Shopcategory shopcategory2 = new Shopcategory();
		List<Shopcategory> list = shopcategoryService.queryShopcategory(shopcategory2);
		
		pageBean1.setList(list);
		pageBean1.setTotalPage(2);
		PageBean pageBean2 = shopcategoryService.queryShopcategoryByPage(shopcategory, pageBean1);
		System.out.println(pageBean2.getAllRows());
	}*/
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
