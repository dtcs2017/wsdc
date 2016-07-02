package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.ShopcategoryDao;
import com.cqupt.domain.Shopcategory;

public class ShopcategoryServiceImpl implements ShopcategoryService {

	ShopcategoryDao shopcategoryDao;
	@Override
	public Shopcategory saveShopcategory(Shopcategory shopcategory) {
		// TODO Auto-generated method stub
		return shopcategoryDao.saveShopcategory(shopcategory);
	}

	@Override
	public void delShopcategory(int id) {
		// TODO Auto-generated method stub
        shopcategoryDao.delShopcategory(id);
	}

	@Override
	public Shopcategory updateShopcategory(Shopcategory shopcategory) {
		// TODO Auto-generated method stub
		return shopcategoryDao.updateShopcategory(shopcategory);
	}

	@Override
	public List<Shopcategory> queryShopcategory(Shopcategory shopcategory) {
		// TODO Auto-generated method stub
		return shopcategoryDao.queryShopcategory(shopcategory);
	}	

	@Override
	public PageBean queryShopcategoryByPage(Shopcategory shopcategory,
			PageBean pageBean) {
		// TODO Auto-generated method stub
		return shopcategoryDao.queryShopcategoryByPage(shopcategory, pageBean);
	}

	public void setShopcategoryDao(ShopcategoryDao shopcategoryDao) {
		this.shopcategoryDao = shopcategoryDao;
	}
    
	public Shopcategory getShopcategory(int id){
		return shopcategoryDao.getShopcategory(id);
	}
	
}
