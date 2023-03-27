package com.mj.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mj.user.dto.UserDTO;
import com.mj.user.utils.DBHelper;

public class UserDAO implements IUserDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		conn = DBHelper.getInstance().getConnection();
	}
	
	@Override
	public int insert(UserDTO dto) {
		int rowCount = 0;
		String sql = " INSERT INTO user (id, username, password, email, address, userRole) "
				+ " VALUES(?, ?, ?, ?, ?, ?) ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getId());
			pstmt.setString(2, dto.getUsername());
			pstmt.setString(3, dto.getPassword());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getAddress());
			pstmt.setString(6, dto.getUserRole());
			
			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public int update(int id, int targetId, int tagetPassword) {
		return 0;
	}

}
