package com.cqupt.dao;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Goodscategory;

public interface GoodscategoryDao {
	public Goodscategory saveGoods(Goodscategory goodscategory);
	
	public void delGoodscategory(int goodscategoryid);
	
	public Goodscategory updategoodscategory(Goodscategory goods);
	
	public Goodscategory getGoodscategory(int id);

	public List<Goodscategory> queryGoods(Goodscategory goodscategory);

	public PageBean queryGoodsByPage(Goodscategory goodscategory, PageBean pageBean);
}
