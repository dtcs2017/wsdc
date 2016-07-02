package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.AddressDao;
import com.cqupt.domain.Address;

public class AddressServiceImpl implements AddressService{
	
	AddressDao addressDao;
	
	

	public AddressDao getAddressDao() {
		return addressDao;
	}

	public void setAddressDao(AddressDao addressDao) {
		this.addressDao = addressDao;
	}

	@Override
	public Address saveAddress(Address address) {
		
		return addressDao.saveAddress(address);
	}

	@Override
	public void delAddress(int addressId) {
		addressDao.delAddress(addressId);
		
	}
	
	public Address getAddress(int id){
		return addressDao.getAdress(id);
	}

	@Override
	public Address updateAddress(Address address) {
		
		return addressDao.updateAddress(address);
	}

	@Override
	public List<Address> queryAddress(Address address) {
		// TODO Auto-generated method stub
		return addressDao.queryAddress(address);
	}

	@Override
	public PageBean queryAddressByPage(Address address, PageBean pageBean) {
		
		return addressDao.queryAddressByPage(address, pageBean);
	}
	
	

}
