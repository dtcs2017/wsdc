/*
 *@Project: framework 
 *@Package: com.cqupt.common
 *@File: BaseEntity.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.common;

import java.io.Serializable;

/**
 * 
 * @Description: 基础实体类，所有实体类型的基类
 * @author chenyongzheng
 * @since 2015-12-11
 * @see
 * 
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = -4407949974001635348L;
	/**
	 * 实体ID
	 */
	private String id;
	/**
	 * 实体版本
	 */
	private Integer version;
	/**
	 * 删除标志
	 */
	private Boolean delFlag;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	/**
	 * @return the delFlag
	 */
	public Boolean getDelFlag() {
		return delFlag;
	}

	/**
	 * @param delFlag the delFlag to set
	 */
	public void setDelFlag(Boolean delFlag) {
		this.delFlag = delFlag;
	}
	
	
}
