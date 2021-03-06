/*
 *@Project: framework 
 *@Package: com.cqupt.common
 *@File: BaseAction.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.common;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * @Description: 所有Action类的基类
 * @author chenyongzheng
 * @since 2015-12-11
 * @see com.opensymphony.xwork2.ActionSupport
 * 
 */
public class BaseAction extends ActionSupport {

	/**
	 * @Fields serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @Description: 获取Session对象
	 * @param 参数说明
	 * @return Map<String,Object> 返回类型
	 * @throws 异常说明
	 */
	protected Map<String, Object> getSession() {
		ActionContext ctx = ActionContext.getContext();
		return ctx.getSession();
	}

	/**
	 * 
	 * @Description: 获取HttpServletRequest对象
	 * @param 参数说明
	 * @return HttpServletRequest 返回类型
	 * @throws 异常说明
	 */
	protected HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * 
	 * @Description: 获取HttpServletResponse对象
	 * @param 参数说明
	 * @return HttpServletResponse 返回类型
	 * @throws 异常说明
	 */
	protected HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

}
