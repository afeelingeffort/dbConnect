package com.mj.user.controller;

import com.mj.user.dto.UserDTO;
import com.mj.user.service.UserService;

public class UserController {
	public UserService userService;
	
	public UserController() {
		userService = new UserService();
	}
	
	public int requestInsertUser(UserDTO userDTO) {
		int rowCount = 0;
		rowCount = userService.insertSQL(userDTO);
		return rowCount;
	}
}
