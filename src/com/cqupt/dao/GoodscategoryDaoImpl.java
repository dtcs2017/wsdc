package com.cqupt.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqupt.common.BaseDao;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Address;
import com.cqupt.domain.Goodscategory;

public class GoodscategoryDaoImpl extends BaseDao<Goodscategory> implements GoodscategoryDao {

	@Override
	public Goodscategory saveGoods(Goodscategory goodscategory) {
		return save(goodscategory);
	}

	@Override
	public void delGoodscategory(int goodscategoryid) {
		delete(Goodscategory.class,goodscategoryid);

	}

	@Override
	public Goodscategory updategoodscategory(Goodscategory goods) {
		return update(goods);
	}
	
	@Override
	public Goodscategory getGoodscategory(int id){
		return get(Goodscategory.class, id);
	}

	@Override
	public List<Goodscategory> queryGoods(Goodscategory goodscategory) {
		Map<String, Object> parms = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("FROM Goodscategory WHERE 1=1 ");
		
		if(goodscategory != null){
			if(goodscategory.getGoodscategoryid() != null){
				hql.append(" AND goodscategoryid=:goodscategoryid ");
				parms.put("goodscategoryid", goodscategory.getGoodscategoryid());
			}
			if(goodscategory.getPid() >=0){
				hql.append(" AND pid=:pid ");
				parms.put("pid", goodscategory.getPid());
			}
			if(goodscategory.getCategory() != null && goodscategory.getCategory().trim().length()>0){
				hql.append(" AND category=:category ");
				parms.put("category", goodscategory.getCategory());
			}
		}
		return findByNamedParam(hql.toString(), parms);
	}

	@Override
	public PageBean queryGoodsByPage(Goodscategory goodscategory,
			PageBean pageBean) {
		Map<String, Object> parms = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("FROM Goodscategory WHERE 1=1 ");

		if(goodscategory != null){
			if(goodscategory.getGoodscategoryid() != null){
				hql.append(" AND goodscategoryid=:goodscategoryid ");
				parms.put("goodscategoryid", goodscategory.getGoodscategoryid());
			}
			if(goodscategory.getPid() >=0){
				hql.append(" AND pid=:pid ");
				parms.put("pid", goodscategory.getPid());
			}
			if(goodscategory.getCategory() != null && goodscategory.getCategory().trim().length()>0){
				hql.append(" AND category=:category ");
				parms.put("category", goodscategory.getCategory());
			}
		}

		return findPageByQuery(hql.toString(), parms, pageBean);
	}
}
