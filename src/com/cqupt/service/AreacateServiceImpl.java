/*
 *@Project: framework 
 *@Package: com.cqupt.service
 *@File: AreacateServiceImpl.java 
 *@Date: 2015-12-11 
 *@author: huangtao
 *@Copyright: V1.0 www.cqupt.edu.cn Inc. All rights reserved. 
 *@Description: 本内容仅限于公司内部传阅，禁止外泄以及用于其他的商业目的 
 */
package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.AreacateDao;
import com.cqupt.domain.Areacate;

public class AreacateServiceImpl implements AreacateService {
	AreacateDao areacateDao;

	/**
	 * Description:
	 * 
	 * @param Areacate
	 *           
	 * @return
	 * @see com.cqupt.service.AreacateService#saveAreacate(com.cqupt.domain.Areacate)
	 */
	@Override
	public Areacate saveAreacate(Areacate areacate) {
		// 调用持久化处理类进行数据保存
		return areacateDao.saveAreacate(areacate);
	}

	/**
	 * Description:
	 * 
	 * @param AreacateId
	 * @see com.cqupt.service.AreacateService#delAreacate(java.lang.String)
	 */
	@Override
	public void delAreacate(int areacateId) {
		areacateDao.delAreacate(areacateId);

	}

	/**
	 * Description:
	 * 
	 * @param Areacate
	 * @see com.cqupt.service.AreacateService#updateAreacate(com.cqupt.domain.Areacate)
	 */
	@Override
	public Areacate updateAreacate(Areacate areacate) {
		
		return areacateDao.updateAreacate(areacate);
	}
	
	/*
	 * 获取实体
	 */
	
	public Areacate getAreacate(int id){
		return areacateDao.getAreacate(id);
	}

	/**
	 * Description:
	 * 
	 * @param AreacateId
	 * @return
	 * @see com.cqupt.service.AreacateService#queryAreacate(java.lang.String)
	 */
	@Override
	public List<Areacate> queryAreacate(Areacate areacate) {

		return areacateDao.queryAreacate(areacate);
	}

	/**
	 * @return the AreacateDao
	 */
	public AreacateDao getAreacateDao() {
		return areacateDao;
	}

	/**
	 * @param AreacateDao
	 *            the AreacateDao to set
	 */
	public void setAreacateDao(AreacateDao areacateDao) {
		this.areacateDao = areacateDao;
	}

	/**
	 * Description:
	 * 
	 * @param Areacate
	 * @param startIndex
	 * @return
	 * @see com.cqupt.service.AreacateService#queryAreacateByPage(com.cqupt.domain.Areacate,
	 *      PageBean)
	 */
	@Override
	public PageBean queryAreacateByPage(Areacate areacate, PageBean pageBean) {
		// TODO Auto-generated method stub
		return areacateDao.queryAreacateByPage(areacate, pageBean);
	}
	
	/*
	 * 递归实现区域无限分类
	 */
	public List<Areacate> genCate(List<Areacate> list, int pid, int level,String keyword){
		return areacateDao.genCate(list, pid, level, keyword);
	}

}
