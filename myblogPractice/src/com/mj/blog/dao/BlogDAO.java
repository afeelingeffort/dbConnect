package com.mj.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mj.blog.dto.BlogDTO;
import com.mj.blog.utils.DBHelper;

public class BlogDAO implements IBlogDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public BlogDAO() {
		conn = DBHelper.getInstance().getConnection();
	}

	@Override
	public BlogDTO select(int id) {
		BlogDTO blogDTO = null;
		
		
		return blogDTO;
	}

}
