package com.mj.albums;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AlbumDAO implements IAlbumDAO {

	private Connection conn;

	private PreparedStatement pstmt;
	private ResultSet rs;

	public AlbumDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public int insert(AlbumDTO dto) {
		int rowCount = 0;
		String sql = " INSERT INTO albums " + " VALUES(?, ?, ? )";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getUserId());
			pstmt.setInt(2, dto.getId());
			pstmt.setString(3, dto.getTitle());

			rowCount = pstmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("AlbumDAO 에러");
			e.printStackTrace();
		}

		return rowCount;
	}

	//select는 결과집합을 반환하기 때문에 DTO를 반환해야 함
	@Override
	public AlbumDTO select(int id) {
		AlbumDTO dto = null;
		String sql = " SELECT * FROM albums "
				+ " WHERE id = ? ";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				dto = new AlbumDTO();
				
				dto.setUserId(rs.getInt("userId"));
				dto.setId(rs.getInt("id"));
				dto.setTitle(rs.getString("title"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int delete(int id) {
		int rowCount = 0;
		String sql = " DELETE FROM albums "
				+ " WHERE id = ? ";
		
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			rowCount = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	@Override
	public int update(int id, int targetId, int targetUserId) {
		int rowCount = 0;
		String sql = " UPDATE todo "
				+ " SET id = ? "
				+ " WHERE id = ? AND userId = ? ";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.setInt(2, targetId);
			pstmt.setInt(3, targetUserId);
			
			rowCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("update문에서 에러 발생");
			e.printStackTrace();
		}
		return rowCount;
	}
}
