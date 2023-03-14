package com.tenco.myblog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.tenco.myblog.dto.BlogDTO;
import com.tenco.myblog.utils.DBHelper;

public class BlogDAO implements IBlogDAO{

	private Connection conn;
	
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public BlogDAO() {
		conn = DBHelper.getInstance().getConnection();
	}
	
	@Override
	public BlogDTO select(int id) {
		BlogDTO blogDTO = null;
		String query = " SELECT * "
				+ " FROM board "
				+ " WHERE id = ? ";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				blogDTO = new BlogDTO();
				
				blogDTO.setId(rs.getInt("id"));
				blogDTO.setTitle(rs.getString("title"));
				blogDTO.setContent(rs.getString("content"));
				blogDTO.setReadCount(rs.getInt("readCoung"));
				blogDTO.setUserId(rs.getInt("userId"));
			}
		} catch (SQLException e) {
			System.out.println(">> BlogDAO select에서 에러 발생 <<");
			e.printStackTrace();
		}
		
		return blogDTO;
	}

	@Override
	public int delete(int boardId) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
