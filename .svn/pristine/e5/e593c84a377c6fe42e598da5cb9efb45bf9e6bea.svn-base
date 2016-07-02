package com.cqupt.dao;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqupt.common.BaseDao;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Shoppingcart;

public class ShoppingCartDaoImpl extends BaseDao<Shoppingcart> implements ShoppingCartDao{
	
    public Shoppingcart saveShoppingCart(Shoppingcart shoppingCart){
    	shoppingCart.setCreatetime(new Date());
    	return save(shoppingCart);
    }
	
	public void delShoppingCart(int id){
		delete(Shoppingcart.class, id);
	}
	
	public Shoppingcart getShoppingCart(int id){
		return get(Shoppingcart.class, id);
	}
	
	public Shoppingcart updateShoppingCart(Shoppingcart shoppingCart){
		return update(shoppingCart);
	}

	public List<Shoppingcart> queryShoppingCart(Shoppingcart shoppingCart){
		StringBuffer sb = new StringBuffer("FROM Shoppingcart sc WHERE 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(shoppingCart != null){
			if(shoppingCart.getShoppingcartid()!=null){
				sb.append(" AND sc.shoppingcartid=:shoppingcartid ");
				params.put("shoppingcartid", shoppingCart.getShoppingcartid());
			}
			if(shoppingCart.getGoods() != null && !shoppingCart.getGoods().equals("")){
				sb.append(" AND sc.goods=:goods ");
				params.put("goods", shoppingCart.getGoods());
			}
			if(shoppingCart.getUser() != null && !shoppingCart.getUser().equals("")){
				sb.append(" AND sc.user=:user ");
				params.put("user", shoppingCart.getUser());
			}
		}
		List<Shoppingcart> list = findByNamedParam(sb.toString(), params);
		return list;
	}
	
	public PageBean findPageByQuery(Shoppingcart shoppingCart, PageBean pageBean){
		StringBuffer sb = new StringBuffer("FROM Shoppingcart sc WHERE 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		if(shoppingCart != null){
			if(shoppingCart.getUser().getUserid() != null){
				sb.append(" sc.user=:user ");
				params.put("user", shoppingCart.getUser());
			}
		}
		return findPageByQuery(sb.toString(), params, pageBean);
	}

	
}
