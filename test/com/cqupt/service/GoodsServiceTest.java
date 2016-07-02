package com.cqupt.service;

import java.util.Date;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.domain.Goods;
import com.cqupt.domain.Goodscategory;
import com.cqupt.domain.Shop;
import com.cqupt.domain.User;

public class GoodsServiceTest {
	
	static ApplicationContext context = null;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}
	
	@Test
	public void testSave() throws Exception {
		GoodsService goodsService=(GoodsService)context.getBean("goodsService");
		Goods good = new Goods();
		good.setGoodscateid(1);
		good.setCreatetime(new Date());
		good.setSales(10);
		good.setGoodsname("aaa");
		good.setPhoto("test");
		Shop shop = new Shop();
		shop.setShopid(1);
		good.setShop(shop);
		good.setIntroduc("wxxxxxxxxxx");
		Goods u = goodsService.saveGoods(good);
		Assert.assertNotNull(u.getGoodsid());
	}
	
	@Test
	public void testDel(){
		GoodsService goodsService=(GoodsService)context.getBean("goodsService");
		goodsService.delGoods(7);
		Goods goods = new Goods();
		goods.setGoodsid(7);
		
		List<Goods> list = goodsService.queryGoods(goods);
		Assert.assertEquals(0, list.size());
	}
	
	@Test
	public void testUpdate(){
		GoodsService goodsService=(GoodsService)context.getBean("goodsService");
		Goods goods = goodsService.getGoods(6);
		goods.setGoodsname("aaacahnge");
		Goods g = goodsService.updateGoods(goods);
		Assert.assertEquals("aaacahnge", g.getGoodsname());
	}
	
	@Test
	public void testQuery(){
		GoodsService goodsService=(GoodsService)context.getBean("goodsService");
		Goods goods = new Goods();
		goods.setGoodsid(6);
		List<Goods> list = goodsService.queryGoods(goods);
		Assert.assertEquals(1, list.size());
	}
}
