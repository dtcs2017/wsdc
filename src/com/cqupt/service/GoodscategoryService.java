/*
 *@Project: framework 
 *@Package: com.cqupt.service
 *@File: UserService.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Goodscategory;


public interface GoodscategoryService {
	/**
	 * @Description: 商品类别信息保存
	 * @param goodscategory
	 
	 */
	public Goodscategory saveGoodsCategory(Goodscategory goodscategory);

	/**
	 * @Description: 类别删除
	 * @param categoryid
	 *            类别ID
	 */
	public void delGoodsCategory(int goodscategoryid);

	/**
	 * @Description: 类别更新
	 * @param goodscategory
	 *            商品类别
	 */
	public Goodscategory updateGoodsCategory(Goodscategory goodscategory);
	
	
	public Goodscategory getGoodscategory(int id);

	  /**
     * 
    * @Description: 商品类别数据查询
    * @param  goodscategory 查詢條件
    * @return List<Goodscategory>    返回类型 
   
     */
	public List<Goodscategory> queryGoodsCategory(Goodscategory goodscategory);
	
	/**
	 * @Description: 分页查询商品类别信息
	 * @param goodscategory
	 *            查詢條件
	 * @param pageBean
	 *            pageBean
	 * @return List<Goodscategory> 返回类型
	 */
	public PageBean queryGoodsCategoryByPage(Goodscategory goodscategory, PageBean pageBean);
}
