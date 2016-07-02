package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.ShopDao;
import com.cqupt.domain.Shop;

public class ShopServiceImpl implements ShopService {

	ShopDao shopDao;
	@Override
	public Shop saveShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopDao.saveShop(shop);
	}

	@Override
	public void delShop(int id) {
		// TODO Auto-generated method stub
        shopDao.delShop(id);
	}

	@Override
	public Shop updateShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopDao.updateShop(shop);
	}

	@Override
	public List<Shop> queryShop(Shop shop) {
		// TODO Auto-generated method stub
		return shopDao.queryShop(shop);
	}

	@Override
	public PageBean queryShopByPage(Shop shop, PageBean pageBean) {
		// TODO Auto-generated method stub
		return shopDao.queryShopByPage(shop, pageBean);
	}

	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	
	public Shop getShop(int id){
		return shopDao.getShop(id);
	}
	
	public Shop loadShop(int id){
		return shopDao.loadShop(id);
	}

}
