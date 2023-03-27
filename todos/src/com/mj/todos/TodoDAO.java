package com.mj.todos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TodoDAO implements ITodoDAO {
	private Connection conn;

	private PreparedStatement pstmt;
	private ResultSet rs;

	public TodoDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public int insert(TodoDTO todoDTO) {
		int rowCount = 0;
		String sql = " INSERT INTO todo " + " VALUES(?, ?, ?, ?) ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, todoDTO.getUserId());
			pstmt.setInt(2, todoDTO.getId());
			pstmt.setString(3, todoDTO.getTitle());
			pstmt.setBoolean(4, todoDTO.isCompleted());

			rowCount = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("TodoDAO insert 오류 발생");
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public int delete(int id) {
		int rowCount = 0;
		String sql = " DELETE FROM todo " + " WHERE id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public TodoDTO select(int id) {
		TodoDTO todoDTO = null;
		String sql = " SELECT * FROM todo " + " WHERE id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				todoDTO = new TodoDTO();

				todoDTO.setUserId(rs.getInt("userId"));
				todoDTO.setId(rs.getInt("id"));
				todoDTO.setTitle(rs.getString("title"));
				todoDTO.setCompleted(rs.getBoolean("completed"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return todoDTO;
	}

	@Override
	public int update(TodoDTO todoDTO, int id) {
		int rowCount = 0;
		String sql = " UPDATE todo " + " SET id = ? " + " WHERE id = ? ";
		

		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(id, rowCount);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}
}
