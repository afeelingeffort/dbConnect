package com.mj.user;

import com.mj.user.controller.UserController;
import com.mj.user.dto.UserDTO;

public class MainTest {

	public static void main(String[] args) {
		UserController controller = new UserController();
		UserDTO userDTO = new UserDTO(11, "누구게", "894535", "124ewdcsf@asdf", "어디게", "USER");
		controller.requestInsertUser(userDTO);
	}

}
