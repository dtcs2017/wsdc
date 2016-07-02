package com.cqupt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqupt.common.BaseDao;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Shopcategory;

public class ShopcategoryDaoImpl extends BaseDao<Shopcategory> implements ShopcategoryDao {

	@Override
	public Shopcategory saveShopcategory(Shopcategory shopcategory) {
		// TODO Auto-generated method stub
		return save(shopcategory);
	}

	@Override
	public void delShopcategory(int id) {
		// TODO Auto-generated method stub
        delete(Shopcategory.class, id);
	}

	@Override
	public Shopcategory updateShopcategory(Shopcategory shopcategory) {
		// TODO Auto-generated method stub
		return update(shopcategory);
	}

	@Override
	public List<Shopcategory> queryShopcategory(Shopcategory shopcategory) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("FROM Shopcategory s WHERE 1=1 ");
		Map<String,Object> parms=new HashMap<String,Object>();
		if(shopcategory!=null){
		     if(shopcategory.getCategory()!=null){
			sb.append(" AND s.category=:category ");
			parms.put("category", shopcategory.getCategory());
		}
		}
		return findByNamedParam(sb.toString(),parms);
	}

	@Override
	public PageBean queryShopcategoryByPage(Shopcategory shopcategory,
			PageBean pageBean) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("FROM Shopcategory s WHERE 1=1");
		Map<String,Object> parms=new HashMap<String,Object>();
		if(shopcategory!=null){
		    if(shopcategory.getCategory()!=null){
			    sb.append("AND s.category=:category");
			    parms.put("category", shopcategory.getCategory());
		    }
		}
		return findPageByQuery(sb.toString(),parms,pageBean);
	}
	
	public Shopcategory getShopcategory(int id){
		return get(Shopcategory.class,id);
	}
}
