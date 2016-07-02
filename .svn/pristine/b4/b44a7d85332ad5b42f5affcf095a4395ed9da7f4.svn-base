package com.cqupt.dao;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Areacate;

/**
 * 
 * @Description: 区域类别信息持久化处理类
 * @author huangtao
 * @since 2015-12-17
 * @see
 */
public interface AreacateDao {
	
	/**
	 * @Description: 区域类别信息保存
	 * @param areacate
	 *            区域类别形象
	 * @return areacate 注册区域类别信息返回
	 */
	public Areacate saveAreacate(Areacate areacate);

	/**
	 * @Description: 区域类别删除
	 * @param areacateId
	 *            区域类别ID
	 */
	public void delAreacate(int areacateId);

	/**
	 * @Description: 区域类别更新
	 * @param areacate
	 *            区域类别信息
	 */
	public Areacate updateAreacate(Areacate areacate);
	
	/*
	 * 获取实体
	 */
	
	public Areacate getAreacate(int id);

	/**
	 * 
	 * @Description: 区域类别数据查询
	 * @param areacate
	 *            查詢條件
	 * @return List<areacate> 返回类型
	 */
	public List<Areacate> queryAreacate(Areacate areacate);


	/**
	 * @Description: 分页查询区域类别信息
	 * @param areacate
	 *            查詢條件
	 * @param startIndex
	 *            開始
	 * @return List<areacate> 返回类型
	 */
	public PageBean queryAreacateByPage(Areacate areacate, PageBean pageBean);
	
	/*
	 * 递归实现区域无限级分类
	 */
	public List<Areacate> genCate(List<Areacate> list, int pid, int level,String keyword);

}
