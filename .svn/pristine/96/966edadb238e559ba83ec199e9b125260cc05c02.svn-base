/*
 *@Project: framework 
 *@Package: com.cqupt.service
 *@File: AdminServiceImpl.java 
 *@Date: 2015-12-11 
 *@author: huangtao
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.AdminDao;
import com.cqupt.domain.Admin;

public class AdminServiceImpl implements AdminService {
	AdminDao adminDao;

	/**
	 * Description:用户信息保存
	 * 
	 * @param Admin
	 *            用戶信息
	 * @return
	 * @see com.cqupt.service.AdminService#saveAdmin(com.cqupt.domain.Admin)
	 */
	@Override
	public Admin saveAdmin(Admin admin) {
		// 调用持久化处理类进行数据保存
		return adminDao.saveAdmin(admin);
	}

	/**
	 * Description:
	 * 
	 * @param AdminId
	 * @see com.cqupt.service.AdminService#delAdmin(java.lang.String)
	 */
	@Override
	public void delAdmin(int adminId) {
		adminDao.delAdmin(adminId);

	}

	/**
	 * Description:
	 * 
	 * @param Admin
	 * @see com.cqupt.service.AdminService#updateAdmin(com.cqupt.domain.Admin)
	 */
	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return adminDao.updateAdmin(admin);
	}

	/**
	 * Description:
	 * 
	 * @param AdminId
	 * @return
	 * @see com.cqupt.service.AdminService#queryAdmin(java.lang.String)
	 */
	@Override
	public List<Admin> queryAdmin(Admin admin) {

		return adminDao.queryAdmin(admin);
	}

	/**
	 * @return the AdminDao
	 */
	public AdminDao getAdminDao() {
		return adminDao;
	}

	/**
	 * @param AdminDao
	 *            the AdminDao to set
	 */
	public void setAdminDao(AdminDao adminDao) {
		this.adminDao = adminDao;
	}

	/**
	 * Description:
	 * 
	 * @param Admin
	 * @param startIndex
	 * @return
	 * @see com.cqupt.service.AdminService#queryAdminByPage(com.cqupt.domain.Admin,
	 *      PageBean)
	 */
	@Override
	public PageBean queryAdminByPage(Admin admin, PageBean pageBean) {
		// TODO Auto-generated method stub
		return adminDao.queryAdminByPage(admin, pageBean);
	}

}
