package com.mj.user.dao;

import com.mj.user.dto.UserDTO;

// insert, update
public interface IUserDAO {
	int insert(UserDTO dto);
	int update(int id, int targetId, int tagetPassword);
}
