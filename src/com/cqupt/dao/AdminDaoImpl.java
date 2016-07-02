/*
 *@Project: framework 
 *@Package: com.cqupt.dao
 *@File: AdminDaoImpl.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqupt.common.BaseDao;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Admin;

/**
 * 
 * @Description: 管理员信息处理实现类
 * @author huangtao
 * @since 2015-12-11
 * @see com.cqupt.common.BaseDao
 * @see com.cqupt.dao.AdminDao
 * 
 */
public class AdminDaoImpl extends BaseDao<Admin> implements AdminDao {

	/**
	 * Description: 用戶注册信息保存
	 * 
	 * @param Admin
	 * @return
	 * @see com.cqupt.dao.AdminDao#saveAdmin(com.cqupt.domain.Admin)
	 */
	@Override
	public Admin saveAdmin(Admin admin) {
		// 调用持久化处理层保持用户注册信息
		
		return save(admin);
	}

	/**
	 * Description:用户删除
	 * 
	 * @param AdminId
	 * @see com.cqupt.dao.AdminDao#delAdmin(java.lang.String)
	 */
	@Override
	public void delAdmin(int adminId) {
		delete(Admin.class,adminId);

	}

	/**
	 * Description:用户更新
	 * 
	 * @param admin
	 * @see com.cqupt.dao.AdminDao#updateAdmin(com.cqupt.domain.Admin)
	 */
	@Override
	public Admin updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		return update(admin);

	}

	/**
	 * Description:
	 * 
	 * @param Admin
	 * @return
	 * @see com.cqupt.dao.AdminDao#queryAdmin(com.cqupt.domain.Admin)
	 */
	@Override
	public List<Admin> queryAdmin(Admin admin) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("FROM Admin WHERE 1=1 ");	
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(admin != null){
			if(admin.getUsername() != null && admin.getUsername().trim().length()>0){
				sb.append(" AND username=:username ");
				params.put("username", admin.getUsername());
			}
			if(admin.getPassword()!=null && admin.getPassword().trim().length()>0){
				sb.append(" AND password=:password ");
				params.put("password", admin.getPassword());
			}
		}
		List<Admin> list = findByNamedParam(sb.toString(), params);
		return list;
	}

	@Override
	public PageBean queryAdminByPage(Admin admin, PageBean pageBean) {

		Map<String, Object> parms = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("FROM admin WHERE 1=1 ");

		if (admin.getUsername() != null) {
			hql.append(" AND username LIKE:username ");
			parms.put("username", "%" + admin.getUsername() + "%");
		}

		return findPageByQuery(hql.toString(), parms, pageBean);
	}

}
