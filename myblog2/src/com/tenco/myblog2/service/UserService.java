package com.tenco.myblog2.service;

import com.tenco.myblog2.dao.UserDao;
import com.tenco.myblog2.dto.UserDto;

public class UserService {
	
	private UserDao userDao;
	
	public UserService() {
		userDao = new UserDao();
	}
	
	public UserDto select(int userId) {
		return userDao.select(userId); 
	}
}
