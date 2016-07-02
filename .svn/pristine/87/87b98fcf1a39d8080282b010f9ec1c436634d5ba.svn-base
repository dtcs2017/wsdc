package com.cqupt.service;

import java.util.List;

import com.cqupt.dao.ShoppingCartDao;
import com.cqupt.domain.Shoppingcart;
import com.cqupt.domain.User;

public class ShoppingCartServiceImpl implements ShoppingCartService {
	
	private ShoppingCartDao shoppingCartDao;
	
	public ShoppingCartDao getShoppingCartDao() {
		return shoppingCartDao;
	}

	public void setShoppingCartDao(ShoppingCartDao shoppingCartDao) {
		this.shoppingCartDao = shoppingCartDao;
	}

	public Shoppingcart saveShoppingcart(Shoppingcart shoppingCart){
		return shoppingCartDao.saveShoppingCart(shoppingCart);
	}

	public void delShoppingcart(int id){
		shoppingCartDao.delShoppingCart(id);
	}
	
	public Shoppingcart getShoppingCart(int id){
		return shoppingCartDao.getShoppingCart(id);
	}

	public Shoppingcart updateShoppingcart(Shoppingcart shoppingCart){
		return shoppingCartDao.updateShoppingCart(shoppingCart);
	}

	public List<Shoppingcart> queryShoppingcart(Shoppingcart shoppingCart){
		return shoppingCartDao.queryShoppingCart(shoppingCart);
	}

}
