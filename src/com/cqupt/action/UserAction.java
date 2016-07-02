/*
 *@Project: framework 
 *@Package: com.cqupt.action 
 *@File: UserAction.java 
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
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.cqupt.common.BaseAction;
import com.cqupt.common.GlobalConst;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Address;
import com.cqupt.domain.Order;
import com.cqupt.domain.User;
import com.cqupt.service.AddressService;
import com.cqupt.service.OrderService;
import com.cqupt.service.UserService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @Description: 用户注册功能的实现
 * @author lsx
 * @since 2015-12-25
 * @see com.cqupt.common.BaseAction
 * 
 */
/**@ParentPackage(value = "frontpackage")*/
@Namespace("/user")
@Results({ @Result(name = "login", location = "/pages/user/login.jsp"),
	       @Result(name = "index", location = "/pages/index.jsp"),
	       @Result(name = "myinfo", location = "/pages/myinfo.jsp"),
	       @Result(name = "myaddress", location = "/pages/myaddress.jsp"),
	       @Result(name = "myorder", location = "/pages/myorder.jsp")
        })
public class UserAction extends BaseAction {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 5572405848705072190L;
	
	User user = new User();
	
	Address address = new Address();
	
	Order order = new Order();
	
	UserService userService;
	
	AddressService addressService;
	
	OrderService orderService;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	String username;
	String email;
	String password;
	
	boolean success = false;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public void setAddressService(AddressService addressService) {
		this.addressService = addressService;
	}
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	@Action("index")
	public String index(){
		return "index";
	}
	
	@Action("myinfo")
	public String myinfo(){
		int userid = (Integer) ActionContext.getContext().getSession().get("userid");
		user = userService.getUser(userid);
		return "myinfo";
	}
	
	@Action("myinfoupdate")
	public String myinfoupdate(){
		int userid = (Integer) ActionContext.getContext().getSession().get("userid");
		User u = new User();
		u = userService.getUser(userid);
		u.setUsername(user.getUsername());
		u.setPassword(user.getPassword());
		u.setSex(user.getSex());
		u.setRealname(user.getRealname());
		u.setTel(user.getTel());
		u.setEmail(user.getEmail());
		userService.updateUser(u);
		return "myinfo";
	}
	
	@Action("myaddress")
	public String myaddress(){
		int userid = (Integer) ActionContext.getContext().getSession().get("userid");
		Address addr = new Address();
		User u = new User();
		u.setUserid(userid);
		addr.setUser(u);
		List<Address> addrlist = addressService.queryAddress(addr);
		address = addrlist.get(0);
		//System.out.println(addr.getUser().getUserid()+"--------------------------");
		return "myaddress";
	}
	
	@Action("myaddressupdate")
	public String myaddressupdate(){
		System.out.println("myaddressupdate=-----------------");
		int id = address.getAddressid();
		Address addr = new Address();
		addr = addressService.getAddress(id);
		System.out.println(address.getAddressid()+address.getArea()+"---------------------");
		addr.setArea(address.getArea());
		addressService.updateAddress(addr);
		return "myaddress";
	}
	
	@Action("myaddressaddop")
	public String myaddressaddop(){
		int userid = (Integer) ActionContext.getContext().getSession().get("userid");
		User u = new User();
		u.setUserid(userid);
		address.setUser(u);
		addressService.saveAddress(address);
		return "myaddress";
	}
	List<Order> orderlist;
	
	public List<Order> getOrderlist() {
		return orderlist;
	}
	public void setOrderlist(List<Order> orderlist) {
		this.orderlist = orderlist;
	}
	@Action("myorder")
	public String myorder(){
		int userid = (Integer) ActionContext.getContext().getSession().get("userid");
		User u = new User();
		u.setUserid(userid);
		order.setUser(u);
		orderlist = orderService.queryOrder(order);
		return "myorder";
	}

}
