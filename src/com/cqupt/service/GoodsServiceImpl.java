/*
 *@Project: framework 
 *@Package: com.cqupt.service
 *@File: GoodsServiceImpl.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.GoodsDao;
import com.cqupt.domain.Goods;

public class GoodsServiceImpl implements GoodsService {
	GoodsDao goodsDao;

	
	@Override
	public Goods saveGoods(Goods goods) {
		// 保存商品
		return goodsDao.saveGoods(goods);
	}

	/**
	 * Description:
	 * 
	 * @param goodsId
	 * @see com.cqupt.service.GoodsService#delGoods(java.lang.String)
	 */
	@Override
	public void delGoods(int goodsId) {
		// 删除商品
		goodsDao.delGoods(goodsId);
	}

	/**
	 * Description:
	 * 
	 * @param goods
	 * @see com.cqupt.service.GoodsService#updateGoods(com.cqupt.domain.Goods)
	 */
	@Override
	public Goods updateGoods(Goods goods) {
		// TODO Auto-generated method stub
		return goodsDao.updateGoods(goods);
	}
	
	public Goods getGoods(int id){
		return goodsDao.getGoods(id);
	}

	/**
	 * Description:
	 * 
	 * @param goodsId
	 * @return
	 * @see com.cqupt.service.GoodsService#queryGoods(java.lang.String)
	 */
	@Override
	public List<Goods> queryGoods(Goods goods) {

		return goodsDao.queryGoods(goods);
	}

	/**
	 * @return the goodsDao
	 */
	public GoodsDao getGoodsDao() {
		return goodsDao;
	}

	/**
	 * @param goodsDao
	 *            the goodsDao to set
	 */
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}

	/**
	 * Description:
	 * 
	 * @param goods
	 * @param startIndex
	 * @return
	 * @see com.cqupt.service.GoodsService#queryGoodsByPage(com.cqupt.domain.Goods,
	 *      PageBean)
	 */
	@Override
	public PageBean queryGoodsByPage(Goods goods, PageBean pageBean) {
		// TODO Auto-generated method stub
		return goodsDao.queryGoodsByPage(goods, pageBean);
	}

}
