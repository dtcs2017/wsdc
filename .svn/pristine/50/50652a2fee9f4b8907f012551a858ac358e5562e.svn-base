/*
 *@Project: framework 
 *@Package: com.cqupt.service
 *@File: OrderService.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Order;

/**
 * 
 * @Description: 商品信息业务处理类
 * @since 2015-12-11
 * @see
 */
public interface OrderService {
	/**
	 * @Description: 商品信息保存
	 * @param Order
	 */
	public Order saveOrder(Order order);

	/**
	 * @Description: 删除
	 */
	public void delOrder(int id);

	/**
	 * @Description: 更新
	 */
	public Order updateOrder(Order order);
	
	/**
	 * @Description: 根据id获取实体
	 */
	public Order getOrder(int id);

	  /**
     * 
    * @Description: 数据查询
    * @param  Order 查詢條件
    * @return List<Order>    返回类型 
   
     */
	public List<Order> queryOrder(Order order);
	
	/**
	 * @Description: 分页查询信息
	 * @param Order
	 *            查詢條件
	 * @param pageBean
	 *            pageBean
	 * @return List<Order> 返回类型
	 */
	public PageBean queryOrderByPage(Order order, PageBean pageBean);
}
