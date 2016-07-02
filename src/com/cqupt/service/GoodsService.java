/*
 *@Project: framework 
 *@Package: com.cqupt.service
 *@File: GoodsService.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Goods;

/**
 * 
 * @Description: 商品信息业务处理类
 * @since 2015-12-11
 * @see
 */
public interface GoodsService {
	/**
	 * @Description: 商品信息保存
	 * @param goods
	 */
	public Goods saveGoods(Goods goods);

	/**
	 * @Description: 删除
	 */
	public void delGoods(int goodsId);

	/**
	 * @Description: 更新
	 */
	public Goods updateGoods(Goods goods);
	
	public Goods getGoods(int id);

	  /**
     * 
    * @Description: 数据查询
    * @param  goods 查詢條件
    * @return List<Goods>    返回类型 
   
     */
	public List<Goods> queryGoods(Goods goods);
	
	/**
	 * @Description: 分页查询信息
	 * @param goods
	 *            查詢條件
	 * @param pageBean
	 *            pageBean
	 * @return List<Goods> 返回类型
	 */
	public PageBean queryGoodsByPage(Goods goods, PageBean pageBean);
}
