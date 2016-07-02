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
import com.cqupt.domain.User;
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
@Namespace("/")
@Results({ @Result(name = "login", location = "/pages/user/index.jsp"),
	       @Result(name = "index", location="home/index", type="redirectAction"),
	       @Result(name = "register", location = "/pages/user/Register.jsp"),
        })
public class LoginAction extends BaseAction {
	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 5572405848705072190L;
	
	static Logger logger = LogManager.getLogger(LoginAction.class.getName());
	/**
	 * 用于接收用户提交的信息
	 */
	User user = new User();
	/**
	 * 注册业务处理
	 */
	UserService userService;
	
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
	/*
	 * @Description: 用户登录
	 * @author: lsx
	 * @since: 2015/12/25
	 * 
	 */
	@Action("login")
	public String login(){
		user.setEmail(email);
		user.setPassword(password);
		List<User> list = userService.queryUser(user);
		if(list.size() != 0){
			int userid = list.get(0).getUserid();
			user = userService.getUser(userid);
			ActionContext.getContext().getSession().put("userid", userid);
			return "index";
		}
		return "login";
	}
	
	@Action("register")
	public String register() {

		try {
			logger.debug("用户注册开始...");
			
			List<User> list = userService.queryUser(user);
			if(list.size()==0)
			{
				user.setPhoto("默认图片地址");
				user.setCreatetime(new Date());
				// 调用业务处理类进行注册业务处理
				User u = userService.saveUser(user);
				logger.debug(u.getUsername() + "用户注册成功...");

				return "login";
			}
			else
			{
				logger.debug("用户注册异常...");
				addFieldError("error", "用戶名重复!");
				return "register";
			}		
		
		} catch (Exception e) {
			e.printStackTrace();
			logger.debug("用户注册异常...");
			addFieldError("error", "用戶主注册异常,请联系管理员!");
			return "register";

		}

	}


}
