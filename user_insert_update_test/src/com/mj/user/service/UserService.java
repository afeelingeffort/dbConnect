package com.mj.user.service;

import com.mj.user.dao.UserDAO;
import com.mj.user.dto.UserDTO;

public class UserService {
	private UserDAO userDAO;
	
	public UserService() {
		userDAO = new UserDAO();
	}
	
	public int insertSQL(UserDTO userDTO) {
		int rowCount = 0;
		rowCount = userDAO.insert(userDTO);
		return rowCount;
	}
}
