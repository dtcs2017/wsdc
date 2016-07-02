package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.GoodscategoryDao;
import com.cqupt.domain.Goodscategory;

public class GoodscategoryServiceImpl implements GoodscategoryService {
	
	GoodscategoryDao goodscategoryDao;
	

	public GoodscategoryDao getGoodscategoryDao() {
		return goodscategoryDao;
	}

	public void setGoodscategoryDao(GoodscategoryDao goodscategoryDao) {
		this.goodscategoryDao = goodscategoryDao;
	}

	/**
	 * @Description: 商品类别信息保存
	 * @param goodscategory
	 
	 */
	public Goodscategory saveGoodsCategory(Goodscategory goodscategory){
		return goodscategoryDao.saveGoods(goodscategory);
	}

	/**
	 * @Description: 类别删除
	 * @param categoryid
	 *            类别ID
	 */
	public void delGoodsCategory(int goodscategoryid){
		goodscategoryDao.delGoodscategory(goodscategoryid);
	}

	/**
	 * @Description: 类别更新
	 * @param goodscategory
	 *            商品类别
	 */
	public Goodscategory updateGoodsCategory(Goodscategory goodscategory){
		return goodscategoryDao.updategoodscategory(goodscategory);
	}
	
	public Goodscategory getGoodscategory(int id){
		return goodscategoryDao.getGoodscategory(id);
	}

	  /**
     * 
    * @Description: 商品类别数据查询
    * @param  goodscategory 查詢條件
    * @return List<Goodscategory>    返回类型 
   
     */
	public List<Goodscategory> queryGoodsCategory(Goodscategory goodscategory){
		return goodscategoryDao.queryGoods(goodscategory);
	}
	
	/**
	 * @Description: 分页查询商品类别信息
	 * @param goodscategory
	 *            查詢條件
	 * @param pageBean
	 *            pageBean
	 * @return List<Goodscategory> 返回类型
	 */
	public PageBean queryGoodsCategoryByPage(Goodscategory goodscategory, PageBean pageBean){
		return goodscategoryDao.queryGoodsByPage(goodscategory, pageBean);
	}
}
