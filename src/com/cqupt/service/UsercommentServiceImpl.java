package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.UsercommentDao;
import com.cqupt.domain.Usercomment;

public class UsercommentServiceImpl implements UsercommentService{
	
	
	UsercommentDao usercommentDao;
	
	

	public UsercommentDao getUsercommentDao() {
		return usercommentDao;
	}

	public void setUsercommentDao(UsercommentDao usercommentDao) {
		this.usercommentDao = usercommentDao;
	}
	

	@Override
	public Usercomment saveUsercomment(Usercomment usercomment) {
		
		return usercommentDao.saveUsercomment(usercomment);
	}

	@Override
	public void delUsercomment(int usercommentId) {
		usercommentDao.delUsercomment(usercommentId);
		
	}
	
	public Usercomment getUsercomment(int id){
		return usercommentDao.getUsercomment(id);
	}

	@Override
	public Usercomment updateUsercomment(Usercomment usercomment) {
		
		return usercommentDao.updateUsercomment(usercomment);
	}

	@Override
	public List<Usercomment> queryUsercomment(Usercomment usercomment) {
		
		return usercommentDao.queryUsercomment(usercomment);
	}

	@Override
	public PageBean queryUsercommentByPage(Usercomment usercomment,
			PageBean pageBean) {
		
		return usercommentDao.queryUsercommentByPage(usercomment, pageBean);
	}

}
