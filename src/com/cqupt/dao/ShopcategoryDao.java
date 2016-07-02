package com.cqupt.dao;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Shopcategory;

public interface ShopcategoryDao {

	public Shopcategory saveShopcategory(Shopcategory shopcategory);
	public void delShopcategory(int id);
	public Shopcategory updateShopcategory(Shopcategory shopcategory);
	public List<Shopcategory> queryShopcategory(Shopcategory shopcategory);
	public PageBean queryShopcategoryByPage(Shopcategory shopcategory, PageBean pageBean);
	public Shopcategory getShopcategory(int id);
}
