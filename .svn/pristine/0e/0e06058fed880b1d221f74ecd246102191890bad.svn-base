package com.cqupt.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqupt.common.BaseDao;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Order;

public class OrderDaoImpl extends BaseDao<Order> implements OrderDao{

	@Override
	public Order saveOrder(Order order) {
		// 保存订单信息
		order.setCreatetime(new Date());
		return save(order);
	}

	@Override
	public void delOrder(int id) {
		// 删除订单
		delete(Order.class, id);
	}


	@Override
	public Order updateOrder(Order order) {
		// 更新订单
		return update(order);

	}
	
	public Order getOrder(int id){
		//根据id获取order实体
		return get(Order.class, id);
	}


	@Override
	public List<Order> queryOrder(Order order) {
		// 订单查询
		StringBuffer sb = new StringBuffer("FROM Order o WHERE 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(order != null){
			if(order.getOrderno() != null && order.getOrderno().trim().length()>0){
				sb.append(" AND o.orderno=:orderno ");
				params.put("orderno", order.getOrderno());
			}
			
			if(order.getUser()!=null){
				sb.append(" AND o.user=:user ");
				params.put("user", order.getUser());
			}
			
			if(order.getOrderid() != null){
				sb.append(" AND o.orderid=:orderid ");
				params.put("orderid", order.getOrderid());
			}
			
		}
		List<Order> list = findByNamedParam(sb.toString(), params);
		return list;
	}

	@Override
	public PageBean queryOrderByPage(Order order, PageBean pageBean) {
		//订单分页查询
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer("FROM Order WHERE 1=1 ");
		
		if(order != null){
			if (order.getOrderno() != null) {
				sb.append(" AND orderno=:orderno ");
				params.put("orderno", order.getOrderno());
			}
			if(order.getUser()!= null){
				sb.append(" AND user=:user ");
				params.put("user", order.getUser());
			}
		}
		
		return findPageByQuery(sb.toString(), params, pageBean);
	}
}

