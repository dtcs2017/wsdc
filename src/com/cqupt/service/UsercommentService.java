package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Usercomment;

public interface UsercommentService {

	public Usercomment saveUsercomment(Usercomment usercomment);
	public void delUsercomment(int usercommentId);
	public Usercomment updateUsercomment(Usercomment usercomment);
	public Usercomment getUsercomment(int id);
	public List<Usercomment> queryUsercomment(Usercomment usercomment);
	public PageBean queryUsercommentByPage(Usercomment usercomment, PageBean pageBean);
}
