package com.cqupt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqupt.common.BaseDao;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Shopreplay;

public class ShopreplayDaoImpl extends BaseDao<Shopreplay> implements ShopreplayDao{

	@Override
	public Shopreplay saveShopreply(Shopreplay shopreplay) {
		return save(shopreplay);
	}

	@Override
	public void delShopreply(int shopreplayId) {
		delete(Shopreplay.class, shopreplayId);
	}

	@Override
	public Shopreplay updateShopreply(Shopreplay shopreplay) {
		return update(shopreplay);
	}

	@Override
	public List<Shopreplay> queryShopreply(Shopreplay shopreplay) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("FROM Shopreplay WHERE 1=1 ");
		
		if(shopreplay != null){
			if(shopreplay.getShopreplayid()>=0){
				hql.append(" AND shopreplayid=:shopreplayid ");
				params.put("shopreplayid", shopreplay.getShopreplayid());
			}
			if(shopreplay.getShop() != null){
				hql.append(" AND shop=:shop ");
				params.put("shop", shopreplay.getShop());
			}
			if(shopreplay.getUser() != null){
				hql.append(" AND user=:user ");
				params.put("user", shopreplay.getUser());
			}
			if (shopreplay.getContent() != null) {
				hql.append(" AND content LIKE:content ");
				params.put("content", "%" + shopreplay.getContent() + "%");
			}
		}
		return  findByNamedParam(hql.toString(), params);
	}

	@Override
	public PageBean queryShopreplyByPage(Shopreplay shopreplay,
			PageBean pageBean) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("FROM Shopreplay WHERE 1=1 ");

		if(shopreplay != null){
			if(shopreplay.getShopreplayid()>=0){
				hql.append(" AND shopreplayid=:shopreplayid ");
				params.put("shopreplayid", shopreplay.getShopreplayid());
			}
			if(shopreplay.getShop() != null){
				hql.append(" AND shop=:shop ");
				params.put("shop", shopreplay.getShop());
			}
			if(shopreplay.getUser() != null){
				hql.append(" AND user=:user ");
				params.put("user", shopreplay.getUser());
			}
			if (shopreplay.getContent() != null) {
				hql.append(" AND content LIKE:content ");
				params.put("content", "%" + shopreplay.getContent() + "%");
			}
		}

		return findPageByQuery(hql.toString(), params, pageBean);
	}
	
	

}
