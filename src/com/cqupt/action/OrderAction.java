/*
 *@Project: framework 
 *@Package: com.cqupt.action 
 *@File: OrderAction.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.cqupt.common.BaseAction;
import com.cqupt.common.GlobalConst;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Address;
import com.cqupt.domain.Goods;
import com.cqupt.domain.Order;
import com.cqupt.domain.Orderdetail;
import com.cqupt.domain.Shoppingcart;
import com.cqupt.domain.User;
import com.cqupt.service.AddressService;
import com.cqupt.service.GoodsService;
import com.cqupt.service.OrderService;
import com.cqupt.service.OrderdetailService;
import com.cqupt.service.ShoppingCartService;
import com.cqupt.service.UserService;
import com.opensymphony.xwork2.ActionContext;


/**
 * 
 * @Description: 订单实现
 * @author lsx
 * @since 2015-12-11
 * @see com.cqupt.common.BaseAction
 * 
 */
@Namespace("/order")
@Results({ @Result(name = "success", location = "/pages/order/Success.jsp"),
		   @Result(name = "OrderList", location = "/pages/order/orderList.jsp"),
		   @Result(name = "error", location = "/pages/order/Error.jsp"),
		   @Result(name = "orderinfo", location = "/pages/orderinfo.jsp"),
		   @Result(name = "orderdetail", location = "/pages/orderdetail.jsp")
		   })
public class OrderAction extends BaseAction {
	
	
	private static final long serialVersionUID = 8875611107968417379L;
	
	Double totalprice;
	Double sendprice;
	int[] goodsnumarr;
	int[] goodsidarr;
	String orderno;
	Order order = new Order();
	
	Orderdetail orderdetail = new Orderdetail();
	
	User user = new User();
	
	Goods goods = new Goods();
	
	Address addr = new Address();
	
	Shoppingcart shoppingCart;
	
	List<Shoppingcart> shoppingcartlist;
	
	List<Orderdetail> orderdetaillist;
	
	OrderService orderService;
	
	OrderdetailService orderdetailService;
	
	GoodsService goodsService;
	
	UserService userService;
	
	AddressService addressService;
	
	ShoppingCartService shoppingCartService;
	/**
	 * 系统日志输出类
	 */
	static Logger logger = LogManager.getLogger(OrderAction.class.getName());
	
    /**
     * 分页
     */
	PageBean pageBean = new PageBean();
	

	/**
	 * 
	 * @Description: 订单分頁顯示
	 * @param 参数说明
	 * @return String 返回类型
	 * @throws 异常说明
	 */
	@Action("queryOrderByPage")
	public String queryOrderByPage() throws Exception {
       
       pageBean = orderService.queryOrderByPage(order, pageBean);
		return "orderList";

	}

	public int[] getGoodsnumarr() {
		return goodsnumarr;
	}

	public void setGoodsnumarr(int[] goodsnumarr) {
		this.goodsnumarr = goodsnumarr;
	}

	public int[] getGoodsidarr() {
		return goodsidarr;
	}

	public void setGoodsidarr(int[] goodsidarr) {
		this.goodsidarr = goodsidarr;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Double getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Double totalprice) {
		this.totalprice = totalprice;
	}

	public Double getSendprice() {
		return sendprice;
	}

	public void setSendprice(Double sendprice) {
		this.sendprice = sendprice;
	}

	public List<Shoppingcart> getShoppingcartlist() {
		return shoppingcartlist;
	}

	public Shoppingcart getShoppingCart() {
		return shoppingCart;
	}

	public void setShoppingCart(Shoppingcart shoppingCart) {
		this.shoppingCart = shoppingCart;
	}

	public void setShoppingcartlist(List<Shoppingcart> shoppingcartlist) {
		this.shoppingcartlist = shoppingcartlist;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	

	public Orderdetail getOrderdetail() {
		return orderdetail;
	}

	public void setOrderdetail(Orderdetail orderdetail) {
		this.orderdetail = orderdetail;
	}

	public void setOrderdetailService(OrderdetailService orderdetailService) {
		this.orderdetailService = orderdetailService;
	}
	
	

	/**
	 * @return the Order
	 */
	public Order getOrder() {
		return order;
	}

	/**
	 * @param Order
	 *            the Order to set
	 */
	public void setOrder(Order order) {
		this.order = order;
	}

	/**
	 * @param OrderService
	 *            the OrderService to set
	 */
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setShoppingCartService(ShoppingCartService shoppingCartService) {
		this.shoppingCartService = shoppingCartService;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}
	
	public String getOrderno() {
		return orderno;
	}

	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}

	public List<Orderdetail> getOrderdetaillist() {
		return orderdetaillist;
	}

	public void setOrderdetaillist(List<Orderdetail> orderdetaillist) {
		this.orderdetaillist = orderdetaillist;
	}

	@Action("shoppingcartbatchsave")
	public void shoppingcartbatchsave(){
		int userid = (Integer) ActionContext.getContext().getSession().get("userid");
		for(int i=0; i<goodsidarr.length; i++){
			goods = goodsService.getGoods(goodsidarr[i]);
			user = userService.getUser(userid);
			
			Shoppingcart s = new Shoppingcart();
			s.setUser(user);
			s.setGoods(goods);
			List<Shoppingcart> list = shoppingCartService.queryShoppingcart(s);
		    Shoppingcart s2 = new Shoppingcart();
			s2 = shoppingCartService.getShoppingCart(list.get(0).getShoppingcartid());
			s2.setGoods(goods);
			s2.setUser(user);
			s2.setCreatetime(new Date());
			s2.setGoodsnum(goodsnumarr[i]);
			shoppingCartService.updateShoppingcart(s2);
		   }
	}
	
	@Action("orderinfo")
	public String orderinfo(){
		int userid = (Integer) ActionContext.getContext().getSession().get("userid");
		shoppingcartlist = shoppingCartService.queryShoppingcart(shoppingCart);
		double amount = 0.0;
		for(Shoppingcart s3 : shoppingcartlist){
			amount += s3.getGoods().getPrice();
		}
		totalprice = amount;
		User u = new User();
		u.setUserid(userid);
		addr.setUser(u);
		List<Address> addrlist = addressService.queryAddress(addr);
		addr = addrlist.get(0);
		return "orderinfo";
	}
	
	@Action("saveorder")
	public void saveorder(){
		int userid = (Integer) ActionContext.getContext().getSession().get("userid");
		shoppingcartlist = shoppingCartService.queryShoppingcart(shoppingCart);
			Date d=new Date();
			order.setOrderno("no"+d.getTime());
			user.setUserid(userid);
			
			addr.setUser(user);
			List<Address> addrlist = addressService.queryAddress(addr);
			//System.out.println(userid+"-----------------------");
			//addr.setArea("重庆邮电大学");
			addr = addressService.getAddress(addrlist.get(0).getAddressid());
			order.setAddress(addr);
			user.setUserid(userid);
			order.setUser(user);
			order.setUsertel("1883812312321");
			order.setState(1);
			order.setCreatetime(new Date());
			order.setOrdertime(new Date());
			orderService.saveOrder(order);
			
			
			for(int i=0; i<shoppingcartlist.size(); i++){
				orderdetail.setOrder(order);
				orderdetail.setGoods(shoppingcartlist.get(i).getGoods());
				orderdetail.setGoodsname(shoppingcartlist.get(i).getGoods().getGoodsname());
				orderdetail.setGoodsphoto(shoppingcartlist.get(i).getGoods().getPhoto());
				orderdetail.setPrice(shoppingcartlist.get(i).getGoods().getPrice());
				orderdetail.setNum(shoppingcartlist.get(i).getGoodsnum());
				orderdetailService.saveOrderdetail(orderdetail);
			}
			
			
			user.setUserid(userid);
			Shoppingcart s = new Shoppingcart();
			s.setUser(user);
			shoppingcartlist = shoppingCartService.queryShoppingcart(s);
			for(int i=0; i<shoppingcartlist.size(); i++){
				shoppingCartService.delShoppingcart(shoppingcartlist.get(i).getShoppingcartid());
			}
	}
	
	@Action("orderdetail")
	public String orderdetail(){
		System.out.println(orderno+"------------------");
		order.setOrderno(orderno);
		List<Order> orderlist = orderService.queryOrder(order);
		
		order = orderService.getOrder(orderlist.get(0).getOrderid());
		
		orderdetail.setOrder(order);
		
		
		
		orderdetaillist = orderdetailService.queryOrderdetail(orderdetail);
		
		System.out.println(orderdetaillist.size()+"-----------------------");
		return "orderdetail";
	}

}