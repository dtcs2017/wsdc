/*
 *@Project: framework 
 *@Package: com.cqupt.dao
 *@File: UserDaoImpl.java 
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
import com.cqupt.domain.Address;
import com.cqupt.domain.User;

/**
 * 
 * @Description: 用户信息处理实现类
 * @author chenyongzheng
 * @since 2015-12-11
 * @see com.cqupt.common.BaseDao
 * @see com.cqupt.dao.UserDao
 * 
 */
public class UserDaoImpl extends BaseDao<User> implements UserDao {

	/**
	 * Description: 用戶注册信息保存
	 * 
	 * @param user
	 * @return
	 * @see com.cqupt.dao.UserDao#saveUser(com.cqupt.domain.User)
	 */
	@Override
	public User saveUser(User user) {
		// 调用持久化处理层保持用户注册信息
		return save(user);
	}

	/**
	 * Description:用户删除
	 * 
	 * @param userId
	 * @see com.cqupt.dao.UserDao#delUser(java.lang.String)
	 */
	
	public void delUser(int userId) {
		
		delete(User.class, userId);
	}

	/**
	 * Description:用户更新
	 * 
	 * @param user
	 * @see com.cqupt.dao.UserDao#updateUser(com.cqupt.domain.User)
	 */
	@Override
	public User updateUser(User user) {
		
		return update(user);

	}
	
	public User getUser(int id){
		return get(User.class, id);
	}

	/**
	 * Description:
	 * 
	 * @param user
	 * @return
	 * @see com.cqupt.dao.UserDao#queryUser(com.cqupt.domain.User)
	 */
	@Override
	public List<User> queryUser(User user) {
		StringBuffer sb = new StringBuffer("FROM User WHERE 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(user != null){
			if(user.getUserid() != null){
				sb.append(" AND userid=:userid ");
				params.put("userid", user.getUserid() );
			}
			if (user.getEmail() != null) {
				sb.append(" AND email=:email ");
				params.put("email", user.getEmail());
			}
			if (user.getUsername() != null) {
				sb.append(" AND username LIKE:username ");
				params.put("username", "%" + user.getUsername() + "%");
			}
			if (user.getPassword() != null) {
				sb.append(" AND password=:password ");
				params.put("password", user.getPassword());
			}
		}
		List<User> list = findByNamedParam(sb.toString(), params);
		return list;
	}

	@Override
	public PageBean queryUserByPage(User user, PageBean pageBean) {

		Map<String, Object> parms = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("FROM User WHERE 1=1 ");

		if(user != null){
			if(user.getUserid() != null){
				hql.append(" AND userid=:userid ");
				parms.put("userid", user.getUserid() );
			}
			if (user.getUsername() != null) {
				hql.append(" AND username LIKE:username ");
				parms.put("username", "%" + user.getUsername() + "%");
			}
		}

		return findPageByQuery(hql.toString(), parms, pageBean);
	}

}
