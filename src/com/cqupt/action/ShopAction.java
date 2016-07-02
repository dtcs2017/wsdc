package com.cqupt.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.cqupt.common.BaseAction;
import com.cqupt.domain.Shop;
import com.cqupt.service.ShopService;

/*
 * @author lsx
 */

@Namespace("/shop")
@Results({ @Result(name = "success", location = "/pages/admin/Success.jsp"),
	       @Result(name="goodslist", location = "/pages/goods.jsp")
        })
public class ShopAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5157885691933192849L;
	
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
	
	@Action("getgoodslistbyshopid")
	public String getgoodslistbyshopid(){
		int id = shop.getShopid();
		return "goodslist";
	}
	
	

}
