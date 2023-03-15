package com.tenco.myblog2.controller;

import com.tenco.myblog2.dto.UserDto;
import com.tenco.myblog2.service.UserService;

public class UserController {

	UserService userService;

	public UserController() {
		userService = new UserService();
	}

	public UserDto select(int userId) {
		return userService.select(userId);
	}
}
