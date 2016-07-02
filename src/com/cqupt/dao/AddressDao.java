package com.cqupt.dao;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Address;

public interface AddressDao {
	
	
	public Address saveAddress(Address address);
	public void delAddress(int addressId);
	public Address updateAddress(Address address);
	public Address getAdress(int id);
	public List<Address> queryAddress(Address address);
	public PageBean queryAddressByPage(Address address, PageBean pageBean);

}
