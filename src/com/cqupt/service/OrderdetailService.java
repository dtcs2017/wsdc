package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Orderdetail;

public interface OrderdetailService {

	public Orderdetail saveOrderdetail(Orderdetail orderdetail);
	public void delOrderdetail(Orderdetail orderdetail);
	public Orderdetail updateOrderdetail(Orderdetail orderdetail);
	public List<Orderdetail> queryOrderdetail(Orderdetail orderdetail);
	public PageBean queryOrderdetailByPage(Orderdetail orderdetail,PageBean pageBean);
	public Orderdetail getOrderdetail(int id);
}
