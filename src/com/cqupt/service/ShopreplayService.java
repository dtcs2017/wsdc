package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.domain.Shopreplay;

public interface ShopreplayService {
	
	public Shopreplay saveShopreply(Shopreplay shopreplay);
	public void delShopreply(int shopreplayId);
	public Shopreplay updateShopreply(Shopreplay shopreplay);
	public List<Shopreplay> queryShopreply(Shopreplay shopreplay);
	public PageBean queryShopreplyByPage(Shopreplay shopreplay, PageBean pageBean);

}
