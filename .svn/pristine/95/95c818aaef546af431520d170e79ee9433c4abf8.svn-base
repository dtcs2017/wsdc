package com.cqupt.service;


import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.domain.Address;
import com.cqupt.domain.Admin;
import com.cqupt.domain.User;

public class AddressServiceTest {
	static ApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}

	@Test
	public void testSaveAddress() throws Exception {
		AddressService addressService = (AddressService) context.getBean("addressService");
		Address address = new Address();
		address.setArea("安徽省安庆市马庙镇育儿村");
		User user = new User();
		user.setUserid(1);
		address.setUser(user);
		Address a = addressService.saveAddress(address);
		Assert.assertNotNull(a.getAddressid());
		
	}
	
	@Test
	public void testDelAddress() throws Exception {
		AddressService addressService = (AddressService) context.getBean("addressService");
		
		addressService.delAddress(2);
		
		
	}
	
	@Test
	public void testUpdateAddress() throws Exception {
		AddressService addressService = (AddressService) context.getBean("addressService");
		Address address = new Address();
		address.setArea("安徽省安庆市马庙镇育儿村aaa");
		User user = new User();
		user.setUserid(2);
		address.setUser(user);
		Address a = addressService.saveAddress(address);

		Assert.assertNotNull(a.getAddressid());
		
		a.setArea("安徽省安庆市马庙镇育儿村bbb");
		User user2 = new User();
		user2.setUserid(2);
		a.setUser(user2);
		Address a2 = addressService.updateAddress(a);

		Assert.assertNotNull(a2.getAddressid());
		
	}
	
	@Test
	public void testQuery(){
		AddressService addressService = (AddressService) context.getBean("addressService");
		Address address = new Address();
		address.setAddressid(1);
		List<Address> list = addressService.queryAddress(address);
		Address addr = (Address) list.get(0);
		Assert.assertEquals("123", addr.getUser().getPassword());
	}
	
	public static void main(String[] args){
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
		AddressService addressService = (AddressService) context.getBean("addressService");
		Address address = new Address();
		//address.setAddressid(1);
		User user = new User();
		user.setUserid(1);
		address.setUser(user);
		List list = addressService.queryAddress(address);
		Address addr = (Address) list.get(0);
		System.out.println(addr.getUser().getPassword());
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
