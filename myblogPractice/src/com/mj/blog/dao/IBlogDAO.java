package com.mj.blog.dao;

import com.mj.blog.dto.BlogDTO;

public interface IBlogDAO {
	BlogDTO select(int id);
}
