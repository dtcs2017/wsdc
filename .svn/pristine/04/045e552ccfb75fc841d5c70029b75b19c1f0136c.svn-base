package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.OrderDao;
import com.cqupt.domain.Order;
import com.cqupt.domain.User;

public class OrderServiceImpl implements OrderService{
	private OrderDao orderDao;

	public OrderDao getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(OrderDao orderDao) {
		this.orderDao = orderDao;
	}

	public Order saveOrder(Order order) {
		return orderDao.saveOrder(order);
	}

	public void delOrder(int id){
		orderDao.delOrder(id);
	}

	public Order updateOrder(Order order) {
		return orderDao.updateOrder(order);
	}
	
	public Order getOrder(int id){
		return orderDao.getOrder(id);
	}
	
	public List<Order> queryOrder(Order order){
		return orderDao.queryOrder(order);
	}

	public PageBean queryOrderByPage(Order order, PageBean pageBean){
		return orderDao.queryOrderByPage(order, pageBean);
	}

}
