package com.cqupt.dao;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Usercomment;

public interface UsercommentDao {
	
	public Usercomment saveUsercomment(Usercomment usercomment);
	public void delUsercomment(int usercommentId);
	public Usercomment getUsercomment(int id);
	public Usercomment updateUsercomment(Usercomment usercomment);
	public List<Usercomment> queryUsercomment(Usercomment usercomment);
	public PageBean queryUsercommentByPage(Usercomment usercomment, PageBean pageBean);

}
