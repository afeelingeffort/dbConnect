package com.tenco.myblog.service;

import com.tenco.myblog.dao.BlogDAO;
import com.tenco.myblog.dto.BlogDTO;

public class BlogService {
	private BlogDAO blogDAO;
	
	public BlogService() {
		blogDAO = new BlogDAO();
	}
	
	public BlogDTO selectByBoardId(int id) {
		BlogDTO resultDTO = blogDAO.select(id);
		return resultDTO;
	}
}
