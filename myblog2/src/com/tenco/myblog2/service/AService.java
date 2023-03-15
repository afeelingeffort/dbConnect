package com.tenco.myblog2.service;

import com.tenco.myblog2.dao.ADao;

public class AService {
	ADao aDao;
	
	public AService() {
		aDao = new ADao();
	}
	
	public String select(String msg) {
		//AS(null) --> AC(null)
		String msg2 = aDao.select(msg);
		return msg2;
	}
}
