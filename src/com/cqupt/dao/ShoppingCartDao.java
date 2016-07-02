package com.cqupt.dao;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Shoppingcart;

public interface ShoppingCartDao{
	public Shoppingcart saveShoppingCart(Shoppingcart shoppingCart);
	
	public void delShoppingCart(int id);
	
	public Shoppingcart getShoppingCart(int id);
	
	public Shoppingcart updateShoppingCart(Shoppingcart shoppingCart);

	public List<Shoppingcart> queryShoppingCart(Shoppingcart shoppingCart);
	
	public PageBean findPageByQuery(Shoppingcart shoppingCart, PageBean pageBean);

}