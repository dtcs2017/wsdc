package com.cqupt.domain;
// Generated 2015-12-16 11:15:13 by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

import com.cqupt.common.BaseEntity;

/**
 * Address generated by hbm2java
 */
public class Address extends BaseEntity {

	private Integer addressid;
	private User user;
	private String area;
	private Set orders = new HashSet();


	public Integer getAddressid() {
		return addressid;
	}

	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Set getOrders() {
		return this.orders;
	}

	public void setOrders(Set orders) {
		this.orders = orders;
	}

}
