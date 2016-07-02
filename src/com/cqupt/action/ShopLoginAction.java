package com.cqupt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.cqupt.common.BaseAction;
import com.cqupt.common.GlobalConst;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Shop;
import com.cqupt.service.ShopService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @Description: 后台登录功能实现
 * @author lsx
 * @since 2015-12-25
 * @see com.cqupt.common.BaseAction
 * 
 */
@Namespace("/shoplogin")
@Results({ @Result(name = "shoplogin", location = "/pages/shopmanage/shoplogin.jsp"),
	       @Result(name = "shopindex", location="/pages/shopmanage/shopindex.jsp")
         })
public class ShopLoginAction extends BaseAction {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8322416580312004021L;
	static Logger logger = LogManager.getLogger(ShopLoginAction.class.getName());
	
	Shop shop = new Shop();
	
	ShopService shopService;

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}
	
	/*
	 * 商家登录名
	 */
	String shopname;
	/*
	 * 商家登录密码
	 */
	String shoppassword;
	
	
	public String getShopname() {
		return shopname;
	}

	public void setShopname(String shopname) {
		this.shopname = shopname;
	}

	public String getShoppassword() {
		return shoppassword;
	}

	public void setShoppassword(String shoppassword) {
		this.shoppassword = shoppassword;
	}

	@Action("shoplogin")
	public String shopLogin(){
		shop.setShoploginname(shopname);
		shop.setPassword(shoppassword);
		List<Shop> list = shopService.queryShop(shop);
		int shopid = list.get(0).getShopid();
		if(list.size() != 0){
			ActionContext.getContext().getSession().put("shopid", shopid);
			shop = shopService.getShop(shopid);
			return "shopindex";
		}
		return "shoplogin";
	}

}
