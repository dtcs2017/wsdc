/*
 *@Project: framework 
 *@Package: com.cqupt.dao
 *@File: AreacateDaoImpl.java 
 *@Date: 2015-12-11 
 *@author: chenyongzheng
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqupt.common.BaseDao;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Areacate;

/**
 * 
 * @Description: 区域类别信息处理实现类
 * @author huangtao
 * @since 2015-12-11
 * @see com.cqupt.common.BaseDao
 * @see com.cqupt.dao.AreacateDao
 * 
 */
public class AreacateDaoImpl extends BaseDao<Areacate> implements AreacateDao {

	/**
	 * Description: 用戶注册信息保存
	 * 
	 * @param Areacate
	 * @return
	 * @see com.cqupt.dao.AreacateDao#saveAreacate(com.cqupt.domain.Areacate)
	 */
	@Override
	public Areacate saveAreacate(Areacate areacate) {
		// 调用持久化处理层保持区域类别注册信息
		
		return save(areacate);
	}

	/**
	 * Description:区域类别删除
	 * 
	 * @param AreacateId
	 * @see com.cqupt.dao.AreacateDao#delAreacate(java.lang.String)
	 */
	@Override
	public void delAreacate(int areacateId) {
		delete(Areacate.class, areacateId);

	}

	/**
	 * Description:区域类别更新
	 * 
	 * @param Areacate
	 * @see com.cqupt.dao.AreacateDao#updateAreacate(com.cqupt.domain.Areacate)
	 */
	@Override
	public Areacate updateAreacate(Areacate areacate) {
		return update(areacate);

	}
	
	/*
	 * 获取实体
	 */
	
	public Areacate getAreacate(int id){
		return get(Areacate.class, id);
	}

	/**
	 * Description:
	 * 
	 * @param Areacate
	 * @return
	 * @see com.cqupt.dao.AreacateDao#queryAreacate(com.cqupt.domain.Areacate)
	 */
	@Override
	public List<Areacate> queryAreacate(Areacate areacate) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("FROM Areacate WHERE 1=1 ");
		
		if(areacate != null){
			if(areacate.getAreacateid() != null){
				hql.append(" AND areacateid=:areacateid ");
				params.put("areacateid", areacate.getAreacateid());
			}
			if(areacate.getPid() != null){
				hql.append(" AND pid=:pid ");
				params.put("pid", areacate.getPid());
			}
			if (areacate.getArea() != null) {
				hql.append(" AND area LIKE:area ");
				params.put("area", "%" + areacate.getArea() + "%");
			}
		}
		List<Areacate> list = findByNamedParam(hql.toString(), params);
		return list;
	}

	@Override
	public PageBean queryAreacateByPage(Areacate areacate, PageBean pageBean) {

		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("FROM Areacate WHERE 1=1 ");

		if(areacate != null){
			if(areacate.getAreacateid() != null){
				hql.append(" AND areacateid=:areacateid ");
				params.put("areacateid", areacate.getAreacateid());
			}
			if(areacate.getPid() != null){
				hql.append(" AND pid=:pid ");
				params.put("pid", areacate.getPid());
			}
			if (areacate.getArea() != null) {
				hql.append(" AND area LIKE:area ");
				params.put("area", "%" + areacate.getArea() + "%");
			}
		}
		
		return findPageByQuery(hql.toString(), params, pageBean);
	}
	
	/*
	 * 递归实现区域无限级分类
	 * @see com.cqupt.dao.AreacateDao#genCate(java.util.List, int, int, java.lang.String)
	 */
	public List<Areacate> genCate(List<Areacate> list, int pid, int level,String keyword){
		List<Areacate> resultlist = new ArrayList<Areacate>();
		if (level == 10)
			return resultlist;
		String l = "";
		for (int i = 0; i < level; i++) {
			l += "　";
		}
		l = l + "└";
		for (Areacate categorylist : list) {
			if (categorylist.getPid() == pid) {
				Areacate cate = new Areacate();
				cate.setPid(categorylist.getPid());
				cate.setAreacateid(categorylist.getAreacateid());
				cate.setArea(l + categorylist.getArea());
				resultlist.add(cate);
				genCate(list, categorylist.getAreacateid(), level + 1,
						keyword);
			}

		}
		return resultlist;  
	}

}
