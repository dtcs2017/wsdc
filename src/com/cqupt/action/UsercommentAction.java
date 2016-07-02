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

import java.util.Date;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.cqupt.common.BaseAction;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Shop;
import com.cqupt.domain.User;
import com.cqupt.domain.Usercomment;
import com.cqupt.service.ShopService;
import com.cqupt.service.UserService;
import com.cqupt.service.UsercommentService;
import com.opensymphony.xwork2.ActionContext;


/**
 * 
 * @author Administrator
 *
 */
@Namespace("/usercomment")
@Results({ @Result(name = "commentlist", location = "/pages/commentlist.jsp"),
		@Result(name = "commentadd", location = "queryCommentByPage", type="redirectAction") })
public class UsercommentAction extends BaseAction {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 5572405848705072190L;
	
	private int shopid;
	private String content;
	Shop shop=new Shop();
	ShopService shopService;
	User user=new User();
	UserService userService;
	Usercomment usercomment=new Usercomment();
	UsercommentService usercommentService;
	PageBean pageBean=new PageBean();
	
	@Action("addComment")
	public String addComment() throws Exception{
		int userid = (Integer) ActionContext.getContext().getSession().get("userid");
		user=userService.getUser(userid);
		usercomment.setShop(shop);
		usercomment.setUser(user);
		usercomment.setContent(content);
		usercomment.setCreatetime(new Date());
		usercommentService.saveUsercomment(usercomment);
		return "commentadd";
	}
	
	@Action("queryCommentByPage")
	public String queryCommentByPage() throws Exception{
		System.out.println(shopid+"_____________________");
		shop=shopService.getShop(shopid);
		usercomment.setShop(shop);
		pageBean.setPageSize(10);
		pageBean=usercommentService.queryUsercommentByPage(usercomment, pageBean);
		return "commentlist";
	}
	
	public int getShopid() {
		return shopid;
	}

	public void setShopid(int shopid) {
		this.shopid = shopid;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Usercomment getUsercomment() {
		return usercomment;
	}

	public void setUsercomment(Usercomment usercomment) {
		this.usercomment = usercomment;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public void setShopService(ShopService shopService) {
		this.shopService = shopService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setUsercommentService(UsercommentService usercommentService) {
		this.usercommentService = usercommentService;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
