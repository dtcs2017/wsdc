package com.cqupt.service;

import java.util.List;

import com.cqupt.common.PageBean;
import com.cqupt.dao.ShopreplayDao;
import com.cqupt.domain.Shopreplay;

public class ShopreplayServiceImpl implements ShopreplayService{
	
	ShopreplayDao shopreplayDao;
	
	
	

	public ShopreplayDao getShopreplayDao() {
		return shopreplayDao;
	}

	public void setShopreplayDao(ShopreplayDao shopreplayDao) {
		this.shopreplayDao = shopreplayDao;
	}

	@Override
	public Shopreplay saveShopreply(Shopreplay shopreplay) {
		
		return shopreplayDao.saveShopreply(shopreplay);
	}

	@Override
	public void delShopreply(int shopreplayId) {
		delShopreply(shopreplayId);
		
	}

	@Override
	public Shopreplay updateShopreply(Shopreplay shopreplay) {
		return updateShopreply(shopreplay);
	}

	@Override
	public List<Shopreplay> queryShopreply(Shopreplay shopreplay) {
		return queryShopreply(shopreplay);
	}

	@Override
	public PageBean queryShopreplyByPage(Shopreplay shopreplay,
			PageBean pageBean) {
		return queryShopreplyByPage(shopreplay, pageBean);
	}

}
