/*
 *@Project: framework 
 *@Package: com.cqupt.exception
 *@File: SystemException.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.exception;

import com.cqupt.common.BaseException;

/**
 * 
 * @Description: 系统异常类
 * @author chenyongzheng
 * @since 2015-12-11
 * @see fully-qualified-classname
 * 
 */
public class SystemException extends BaseException {

	private static final long serialVersionUID = 9201384227663904240L;
	/**
	 * 异常信息
	 */
	String errMsg;

	public SystemException(String errMsg) {
		this.errMsg = errMsg;
	}

	/**
	 * Description:
	 * 
	 * @return
	 * @see com.cqupt.common.BaseException#getErrCode()
	 */
	@Override
	public String getErrCode() {
		return "message.exception.system_error";
	}

	/**
	 * Description:
	 * 
	 * @return
	 * @see com.cqupt.common.BaseException#getArguments()
	 */
	@Override
	public Object[] getArguments() {
		return null;
	}

	/**
	 * Description:
	 * 
	 * @return
	 * @see com.cqupt.common.BaseException#getErrMsg()
	 */
	@Override
	public String getErrMsg() {
		return errMsg;
	}

}