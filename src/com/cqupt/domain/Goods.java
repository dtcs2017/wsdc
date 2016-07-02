package com.cqupt.domain;
// Generated 2015-12-16 11:15:13 by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.cqupt.common.BaseEntity;

/**
 * Goods generated by hbm2java
 */
public class Goods extends BaseEntity {

	private Integer goodsid;
	private Shop shop;
	private Goodscategory goodscateogry;
	private String goodsname;
	private int sales;
	private double price;
	private String photo;
	private String introduc;
	private int sort;
	private int state;
	private Date createtime;
	private Set orderdetails = new HashSet(0);
	private Set shoppingcarts = new HashSet(0);
	private Set usercomments = new HashSet(0);

	
	public Goodscategory getGoodscateogry() {
		return goodscateogry;
	}

	public void setGoodscateogry(Goodscategory goodscateogry) {
		this.goodscateogry = goodscateogry;
	}

	public Integer getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(Integer goodsid) {
		this.goodsid = goodsid;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public int getSales() {
		return this.sales;
	}

	public void setSales(int sales) {
		this.sales = sales;
	}

	public double getPrice() {
		return this.price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getIntroduc() {
		return this.introduc;
	}

	public void setIntroduc(String introduc) {
		this.introduc = introduc;
	}

	public int getSort() {
		return this.sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Set getOrderdetails() {
		return this.orderdetails;
	}

	public void setOrderdetails(Set orderdetails) {
		this.orderdetails = orderdetails;
	}

	public Set getShoppingcarts() {
		return this.shoppingcarts;
	}

	public void setShoppingcarts(Set shoppingcarts) {
		this.shoppingcarts = shoppingcarts;
	}

	public Set getUsercomments() {
		return this.usercomments;
	}

	public void setUsercomments(Set usercomments) {
		this.usercomments = usercomments;
	}

}