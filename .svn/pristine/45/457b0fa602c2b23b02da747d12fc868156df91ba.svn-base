package com.cqupt.service;

import java.util.List;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cqupt.domain.Admin;
import com.cqupt.domain.User;

public class AdminServiceTest {
	static ApplicationContext context = null;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext(new String[] {
				"resources/spring-common-context.xml",
				"resources/spring-bean-context.xml" });
	}

	@Test
	public void testSaveUser() throws Exception {
		AdminService adminService = (AdminService) context.getBean("adminService");
		Admin admin = new Admin();
		admin.setUsername("管理员2");
		admin.setPassword("1234");
		Admin a = adminService.saveAdmin(admin);
		Assert.assertNotNull(a.getAdminid());
		
	}
	
	@Test
	public void testDelAdmin() throws Exception {
		AdminService adminService = (AdminService) context.getBean("adminService");
		int adminId = 2;
		adminService.delAdmin(adminId);
		
		
	}
	
	@Test
	public void testUpdateAdmin() throws Exception {
		AdminService adminService = (AdminService) context.getBean("adminService");
		Admin admin = new Admin();
		admin.setAdminid(4);
		admin.setUsername("管理员修改2");
		admin.setPassword("1234");
		Admin a = adminService.updateAdmin(admin);
		Assert.assertNotNull(a.getAdminid());
		
	}
	
	@Test
	public void testQueryAdmin(){
		AdminService adminService = (AdminService) context.getBean("adminService");
		Admin admin = new Admin();
		admin.setAdminid(1);
		List<Admin> list = adminService.queryAdmin(admin);
		Assert.assertEquals("admin", list.get(0).getUsername());
	}
	
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
}
