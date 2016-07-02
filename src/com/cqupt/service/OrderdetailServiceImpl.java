package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.OrderdetailDao;
import com.cqupt.domain.Orderdetail;

public class OrderdetailServiceImpl implements OrderdetailService {

	OrderdetailDao orderdetailDao;
	@Override
	public Orderdetail saveOrderdetail(Orderdetail orderdetail) {
		// TODO Auto-generated method stub
		return orderdetailDao.saveOrderdetail(orderdetail);
	}

	@Override
	public void delOrderdetail(Orderdetail orderdetail) {
		// TODO Auto-generated method stub
        orderdetailDao.delOrderdetail(orderdetail);
	}

	@Override
	public Orderdetail updateOrderdetail(Orderdetail orderdetail) {
		// TODO Auto-generated method stub
		return orderdetailDao.updateOrderdetail(orderdetail);
	}

	@Override
	public List<Orderdetail> queryOrderdetail(Orderdetail orderdetail) {
		// TODO Auto-generated method stub
		return orderdetailDao.queryOrderdetail(orderdetail);
	}

	@Override
	public PageBean queryOrderdetailByPage(Orderdetail orderdetail,
			PageBean pageBean) {
		// TODO Auto-generated method stub
		return orderdetailDao.queryOrderdetailByPage(orderdetail, pageBean);
	}

	@Override
	public Orderdetail getOrderdetail(int id) {
		// TODO Auto-generated method stub
		return orderdetailDao.getOrderdetail(id);
	}

	public void setOrderdetailDao(OrderdetailDao orderdetailDao) {
		this.orderdetailDao = orderdetailDao;
	}
	

}
