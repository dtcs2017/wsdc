package com.cqupt.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cqupt.common.BaseDao;
import com.cqupt.common.PageBean;
import com.cqupt.domain.Address;

public class AddressDaoImpl extends BaseDao<Address> implements AddressDao{

	@Override
	public Address saveAddress(Address address) {
		
		return save(address);
	}

	@Override
	public void delAddress(int addressId) {
		delete(Address.class, addressId);
		
	}

	@Override
	public Address updateAddress(Address address) {
		
		return update(address);
	}

	public Address getAdress(int id){
		return get(Address.class, id);
	}
	@Override
	public List<Address> queryAddress(Address address) {
		StringBuffer sb = new StringBuffer("FROM Address WHERE 1=1 ");
		Map<String, Object> params = new HashMap<String, Object>();
		
		if(address != null){
			if(address.getAddressid() != null){
				sb.append(" AND addressid=:addressid ");
				params.put("addressid", address.getAddressid());
			}
			if(address.getUser() != null){
				sb.append(" AND user=:user ");
				params.put("user", address.getUser());
			}
			if (address.getArea() != null) {
				sb.append(" AND area LIKE:area ");
				params.put("area", "%" + address.getArea() + "%");
			}
		}
		List<Address> list = findByNamedParam(sb.toString(), params);
		return list;
	}

	@Override
	public PageBean queryAddressByPage(Address address, PageBean pageBean) {
		Map<String, Object> params = new HashMap<String, Object>();
		StringBuffer sb = new StringBuffer("FROM Address WHERE 1=1 ");
		
		if(address != null){
			if(address.getAddressid() != null){
				sb.append(" AND addressid=:addressid ");
				params.put("addressid", address.getAddressid());
			}
			if (address.getArea() != null) {
				sb.append(" AND area LIKE:area ");
				params.put("area", "%" + address.getArea() + "%");
			}
			if(address.getUser() != null){
				sb.append(" AND user=:user");
				params.put("user", address.getUser());
			}
			
		}

		return findPageByQuery(sb.toString(), params, pageBean);
	}
	
	
	

}
