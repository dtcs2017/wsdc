package com.cqupt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqupt.common.BaseDao;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Shop;
import com.cqupt.domain.Shopcategory;

public class ShopDaoImpl extends BaseDao<Shop> implements ShopDao {

	@Override
	public Shop saveShop(Shop shop) {
		// TODO Auto-generated method stub
		return save(shop);
	}

	@Override
	public void delShop(int id) {
		// TODO Auto-generated method stub
        delete(Shop.class, id);
	}

	@Override
	public Shop updateShop(Shop shop) {
		// TODO Auto-generated method stub
		return update(shop);
	}

	@Override
	public List<Shop> queryShop(Shop shop) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("FROM Shop s WHERE 1=1 ");
		Map<String,Object> parms=new HashMap<String,Object>();
		if(shop!=null){
			if(shop.getShopcategory()!=null&&shop.getShopcategory().getCategory().trim()!=null){
				sb.append(" AND s.shopcategory=:shopcategory ");
				parms.put("shopcategory", shop.getShopcategory());
			}
			if(shop.getShopname()!=null){
				sb.append(" AND s.shopname=:shopname ");
				parms.put("shopname", shop.getShopname());
			}
			if(shop.getShoploginname()!=null){
				sb.append(" AND s.shoploginname=:shoploginname ");
				parms.put("shoploginname", shop.getShoploginname());
			}
			if(shop.getPassword()!=null){
				sb.append(" AND s.password=:password ");
				parms.put("password", shop.getPassword());
			}
			if(shop.getState()==1){
				sb.append(" AND s.state=:state ");
				parms.put("state", shop.getState());
			}
		}
		return findByNamedParam(sb.toString(),parms);
	}

	@Override
	public PageBean queryShopByPage(Shop shop, PageBean pageBean) {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer("FROM Shop s WHERE 1=1");
		Map<String,Object> parms=new HashMap<String,Object>();
		if(shop!=null){
			if(shop.getShopcategory()!=null&&shop.getShopcategory().getCategory().trim()!=null){
				sb.append(" AND s.shopcategory=:shopcategory ");
				parms.put("shopcategory", shop.getShopcategory());
			}
			if(shop.getShopname()!=null){
				sb.append(" AND s.shopname=:shopname ");
				parms.put("shopname", shop.getShopname());
			}
			if(shop.getState()==1){
				sb.append(" AND s.state=:state ");
				parms.put("state", shop.getState());
			}
			if(shop.getRank()>=0){
				sb.append(" order by s.rank desc ");
			}
		}
		return findPageByQuery(sb.toString(),parms,pageBean);
	}
	
	public Shop getShop(int id){
		return get(Shop.class,id);
	}
	
	public Shop loadShop(int id){
		return load(Shop.class, id);
	}

}
