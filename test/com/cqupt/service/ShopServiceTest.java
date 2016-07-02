package com.cqupt.service;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Goods;
import com.cqupt.domain.Shop;
import com.cqupt.domain.Shopcategory;
import com.cqupt.domain.Shopreplay;

public class ShopServiceTest {

	static ApplicationContext context = null;

	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}
	
	@Test
	public void testSaveShop() throws Exception{
		ShopService shopService=(ShopService) context.getBean("shopService");
		Shop shop=new Shop();
		
		Shopcategory shopcate=new Shopcategory();
		shopcate.setShopcategoryid(1);
		
		Set<Goods> goods=new HashSet<Goods>();
		Goods g=new Goods();
		g.setGoodsid(1);
		goods.add(g);
		
		Set<Shopreplay> shopre=new HashSet<Shopreplay>();
		Shopreplay shopreplay=new Shopreplay();
		shopreplay.setShopreplayid(1);
		
		shop.setCreatetime(new Date());
		shop.setDelFlag(true);
		shop.setIntroduc("introduction");
		shop.setPassword("123");
		shop.setRank(0);
		shop.setTel("123");
		shop.setPhoto("ddd");
		shop.setShopaddress("address");
		shop.setShoploginname("shoploginname");
		shop.setShopname("shopname");
		
		shop.setShopcategory(shopcate);
		shop.setGoodses(goods);
		shop.setShopreplays(shopre);
		
		Shop s=shopService.saveShop(shop);
		Assert.assertNotNull(s.getShopid());
	}
	
	@Test
	public void testDelShop() throws Exception{
		ShopService shopService=(ShopService) context.getBean("shopService");
		Shop shop=new Shop();
		
		Shopcategory shopcate=new Shopcategory();
		shopcate.setShopcategoryid(1);
		
		Set<Goods> goods=new HashSet<Goods>();
		Goods g=new Goods();
		g.setGoodsid(1);
		goods.add(g);
		
		Set<Shopreplay> shopre=new HashSet<Shopreplay>();
		Shopreplay shopreplay=new Shopreplay();
		shopreplay.setShopreplayid(1);
		
		shop.setCreatetime(new Date());
		shop.setDelFlag(true);
		shop.setIntroduc("introduction");
		shop.setPassword("123");
		shop.setRank(0);
		shop.setTel("123");
		shop.setPhoto("ddd");
		shop.setShopaddress("address");
		shop.setShoploginname("shoploginname");
		shop.setShopname("shopname");
		
		shop.setShopcategory(shopcate);
		shop.setGoodses(goods);
		shop.setShopreplays(shopre);
		
		Shop s=shopService.saveShop(shop);
		shopService.delShop(s);
	}
	
	@Test
	public void testUpdateShop() throws Exception{
		ShopService shopService=(ShopService) context.getBean("shopService");
		Shop shop=shopService.getShop(1);
	
		shop.setShoploginname("shoploginname3");
		shop.setShopaddress("address3");
		Shop s=shopService.updateShop(shop);
		Assert.assertEquals("shoploginname3",s.getShoploginname());
		Assert.assertEquals("address3",s.getShopaddress());

	}
	@Test
	public void testQueryShop() throws Exception{
		ShopService shopService=(ShopService) context.getBean("shopService");
		//Shop shop=shopService.getShop(4);
		
		List<Shop> list=shopService.queryShop(null);
		Assert.assertEquals(17, list.size());
	} 
	
	@Test
	public void testQueryShopByPage() throws Exception{
		ShopService shopService=(ShopService) context.getBean("shopService");
		Shop shop=shopService.getShop(1);
		PageBean pageBean1=new PageBean();
		
		Shop shop2 = new Shop();
		List<Shop> list = shopService.queryShop(null);
		
		pageBean1.setList(list);
		pageBean1.setTotalPage(2);
		pageBean1.setAllRows(list.size());
		pageBean1.setCurrentPage(1);
		
		PageBean pageBean2 = shopService.queryShopByPage(shop, pageBean1);
		Assert.assertEquals(1, pageBean2.getAllRows().longValue());
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
