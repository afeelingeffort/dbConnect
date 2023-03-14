package com.tenco.myblog.dao;

import com.tenco.myblog.dto.BlogDTO;

public interface IBlogDAO {

	BlogDTO select(int id);

	int delete(int boardId);
}
