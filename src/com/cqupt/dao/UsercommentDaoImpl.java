package com.cqupt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqupt.common.BaseDao;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Usercomment;

public class UsercommentDaoImpl extends BaseDao<Usercomment> implements UsercommentDao{

	@Override
	public Usercomment saveUsercomment(Usercomment usercomment) {
		
		return save(usercomment);
	}

	@Override
	public void delUsercomment(int usercommentId) {
		this.delete(Usercomment.class, usercommentId);
		
	}

	@Override
	public Usercomment updateUsercomment(Usercomment usercomment) {
		
		return update(usercomment);
	}

	@Override
	public List<Usercomment> queryUsercomment(Usercomment usercomment) {
		
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("FROM Usercomment WHERE 1=1 ");
		
		if(usercomment != null){
			if(usercomment.getUsercommentid()>=0){
				hql.append(" AND usercommentid=:usercommentid ");
				params.put("usercommentid", usercomment.getUsercommentid());
			}
			if(usercomment.getShop() != null){
				hql.append(" AND shop=:shop ");
				params.put("shop", usercomment.getShop());
			}
			if(usercomment.getUser() != null){
				hql.append(" AND user=:user ");
				params.put("user", usercomment.getUser());
			}
			if (usercomment.getContent() != null) {
				hql.append(" AND content LIKE:content ");
				params.put("content", "%" + usercomment.getContent() + "%");
			}
		}
		return  findByNamedParam(hql.toString(), params);
	}

	@Override
	public PageBean queryUsercommentByPage(Usercomment usercomment,
			PageBean pageBean) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer hql = new StringBuffer("FROM Usercomment WHERE 1=1 ");

		if(usercomment != null){
			if(usercomment.getUsercommentid()!=null){
				hql.append(" AND usercommentid=:usercommentid ");
				params.put("usercommentid", usercomment.getUsercommentid());
			}
			if(usercomment.getShop() != null){
				hql.append(" AND shop=:shop ");
				params.put("shop", usercomment.getShop());
			}
			if(usercomment.getUser() != null){
				hql.append(" AND user=:user ");
				params.put("user", usercomment.getUser());
			}
			if (usercomment.getContent() != null) {
				hql.append(" AND content LIKE:content ");
				params.put("content", "%" + usercomment.getContent() + "%");
			}
		}

		return findPageByQuery(hql.toString(), params, pageBean);
	}

	@Override
	public Usercomment getUsercomment(int id) {
		
		return get(Usercomment.class, id);
	}

}
