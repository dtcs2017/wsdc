package com.cqupt.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.cqupt.common.BaseAction;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Goodscategory;
import com.cqupt.domain.Shop;
import com.cqupt.domain.Shopcategory;
import com.cqupt.service.GoodscategoryService;
import com.cqupt.service.ShopService;
import com.cqupt.service.ShopcategoryService;
/**
 * @Description: 前台首页处理
 * @suthor: lsx
 * @since: 2015/12/25
 * @see com.cqupt.common.BaseAction
 */
@Namespace("/home")
@Results({ @Result(name="index", location= "/pages/index.jsp") })
public class IndexAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6461882966501671911L;
	
	/*
	 * 商家类别
	 */
	Shopcategory shopcategory = new Shopcategory();
	
	Goodscategory goodscategory = new Goodscategory();
	
	/*
	 * 商家类别业务处理
	 */
	ShopcategoryService shopcategoryService;
	
	GoodscategoryService goodscategoryService;
	
	/*
	 * 商家信息
	 */
	Shop shop = new Shop();
	
	/*
	 * 商家业务处理
	 */
	ShopService shopService;
	
	PageBean pageBean = new PageBean();

	
	public Shopcategory getShopcategory() {
		return shopcategory;
	}

	public void setShopcategory(Shopcategory shopcategory) {
		this.shopcategory = shopcategory;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public void setShopcategoryService(ShopcategoryService shopcategoryService) {
		this.shopcategoryService = shopcategoryService;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
	
	
	public Goodscategory getGoodscategory() {
		return goodscategory;
	}

	public void setGoodscategory(Goodscategory goodscategory) {
		this.goodscategory = goodscategory;
	}

	public void setGoodscategoryService(GoodscategoryService goodscategoryService) {
		this.goodscategoryService = goodscategoryService;
	}


	/*
	 * 商家类别列表
	 */
	List<Shopcategory> shopcategorylist;
	/*
	 * 商品列表
	 */
	List<Shop> shopinfo;
	
	
	List<Goodscategory> goodscategorylist;

	public List<Shopcategory> getShopcategorylist() {
		return shopcategorylist;
	}

	public void setShopcategorylist(List<Shopcategory> shopcategorylist) {
		this.shopcategorylist = shopcategorylist;
	}

	public List<Shop> getShopinfo() {
		return shopinfo;
	}

	public void setShopinfo(List<Shop> shopinfo) {
		this.shopinfo = shopinfo;
	}

	public List<Goodscategory> getGoodscategorylist() {
		return goodscategorylist;
	}

	public void setGoodscategorylist(List<Goodscategory> goodscategorylist) {
		this.goodscategorylist = goodscategorylist;
	}

	@Action("index")
	public String index(){
		goodscategorylist = goodscategoryService.queryGoodsCategory(goodscategory);
		Shop s = new Shop();
		s.setState(1);
		pageBean.setPageSize(20);
		pageBean = shopService.queryShopByPage(s, pageBean);
		shopinfo = shopService.queryShop(s);
		return "index";
	}

}
