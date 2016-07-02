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
import com.cqupt.domain.Admin;
import com.cqupt.service.AdminService;
import com.opensymphony.xwork2.ActionContext;

/**
 * 
 * @Description: 后台登录功能实现
 * @author lsx
 * @since 2015-12-25
 * @see com.cqupt.common.BaseAction
 * 
 */
@Namespace("/adminhome")
@Results({ @Result(name = "adminlogin", location = "/pages/admin/adminlogin.jsp"),
	       @Result(name = "adminindex", location="/pages/admin/adminindex.jsp")
         })
public class AdminLoginAction extends BaseAction {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8322416580312004021L;
	static Logger logger = LogManager.getLogger(AdminLoginAction.class.getName());
	
	Admin admin = new Admin();
	
	AdminService adminService;

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	
	/*
	 * 管理员登录名
	 */
	String adminname;
	/*
	 * 管理员登录密码
	 */
	String adminpassword;
	
	public String getAdminname() {
		return adminname;
	}

	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	@Action("adminlogin")
	public String adminLogin(){
		admin.setUsername(adminname);
		admin.setPassword(adminpassword);
		List<Admin> list = adminService.queryAdmin(admin);
		if(list.size() != 0){
			ActionContext.getContext().getSession().put("admin", list);
			return "adminindex";
		}
		return "adminlogin";
	}
	
}
