package com.cqupt.domain;
// Generated 2015-12-16 11:15:13 by Hibernate Tools 4.3.1.Final

import java.util.Date;

import com.cqupt.common.BaseEntity;

/**
 * Usercomment generated by hbm2java
 */
public class Usercomment extends BaseEntity {

	private Integer usercommentid;
	private Shop shop;
	private User user;
	private String content;
	private Date createtime;
	private int state;

	
	public Integer getUsercommentid() {
		return usercommentid;
	}

	public void setUsercommentid(Integer usercommentid) {
		this.usercommentid = usercommentid;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatetime() {
		return this.createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public int getState() {
		return this.state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
