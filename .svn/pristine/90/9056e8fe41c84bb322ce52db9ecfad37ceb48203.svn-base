package com.cqupt.service;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.domain.Goodscategory;

public class GoodscategoryServiceTest {
	static ApplicationContext context = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}



	@Test
	public void testSave() {
		GoodscategoryService goodscategoryService= (GoodscategoryService) context.getBean("goodscategoryService");
		Goodscategory goodscategory = new Goodscategory();
		goodscategory.setPid(0);
		goodscategory.setCategory("test12-22");
		Goodscategory g = goodscategoryService.saveGoodsCategory(goodscategory);
		Assert.assertNotNull(g.getGoodscategoryid());
	}
	
	@Test
	public void testdel(){
		GoodscategoryService goodscategoryService= (GoodscategoryService) context.getBean("goodscategoryService");
		goodscategoryService.delGoodsCategory(4);
		Goodscategory goodscategory = new Goodscategory();
		goodscategory.setGoodscategoryid(4);
		List<Goodscategory> list = goodscategoryService.queryGoodsCategory(goodscategory);
		Assert.assertEquals(0, list.size());
	}
	
	@Test
	public void testUpdate(){
		GoodscategoryService goodscategoryService= (GoodscategoryService) context.getBean("goodscategoryService");
		Goodscategory goodscategory = new Goodscategory();
		goodscategory.setGoodscategoryid(3);
		goodscategory.setCategory("其它菜修改");
		Goodscategory goodscate = goodscategoryService.updateGoodsCategory(goodscategory);
		Assert.assertEquals("其它菜修改", goodscate.getCategory());
	}
	
	@Test
	public void testQuery(){
		GoodscategoryService goodscategoryService= (GoodscategoryService) context.getBean("goodscategoryService");
		Goodscategory goodscategory = new Goodscategory();
		goodscategory.setGoodscategoryid(3);
		List<Goodscategory> list = goodscategoryService.queryGoodsCategory(goodscategory);
		Assert.assertEquals(3, list.get(0).getGoodscategoryid().longValue());
	}

}
