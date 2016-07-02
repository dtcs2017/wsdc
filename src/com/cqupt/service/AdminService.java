package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Admin;

/**
 * 
 * @Description: 管理员注册信息持久化处理类
 * @author huangtao
 * @since 2015-12-17
 * @see
 */
public interface AdminService {
	
	/**
	 * @Description: 管理员注册信息保存
	 * @param Admin
	 *            管理员注册形象
	 * @return Admin 注册用户信息返回
	 */
	public Admin saveAdmin(Admin Admin);

	/**
	 * @Description: 管理员删除
	 * @param adminId
	 *            管理员ID
	 */
	public void delAdmin(int adminId);

	/**
	 * @Description: 管理员更新
	 * @param Admin
	 *            管理员信息
	 */
	public Admin updateAdmin(Admin admin);

	  /**
     * 
    * @Description: 管理员数据查询
    * @param  Admin 查詢條件
    * @return List<Admin>    返回类型 
   
     */
	public List<Admin> queryAdmin(Admin admin);
	
	/**
	 * @Description: 分页查询管理员信息
	 * @param Admin
	 *            查詢條件
	 * @param pageBean
	 *            pageBean
	 * @return List<Admin> 返回类型
	 */
	public PageBean queryAdminByPage(Admin Admin, PageBean pageBean);
	

}
