/*
*@Project: framework 
*@Package: com.cqupt.exception
*@File: UnsupportOperationException.java 
*@Date: 2015-12-11 
*@author: chenyongzheng
*@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
*@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
*/
package com.cqupt.exception;

import com.cqupt.common.BaseException;
/**
 * 
* @Description: 操作不支持是异常
* @author chenyongzheng
* @since 2015-12-11
* @see com.cqupt.common.BaseException
*
 */
public class UnsupportOperationException extends BaseException {

	private static final long serialVersionUID = 8987653560756819884L;
	/**
	 * 异常信息
	 */
	String errMsg;

	public UnsupportOperationException(String errMsg) {
		this.errMsg = errMsg;
	}

	@Override
	public String getErrCode() {
		return "message.exception.unsupport_oper";
	}

	@Override
	public Object[] getArguments() {
		
		return null;
	}

	@Override
	public String getErrMsg() {
	
		return errMsg;
	}

}