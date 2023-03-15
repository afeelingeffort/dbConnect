package com.tenco.myblog.dao;

import com.tenco.myblog.dto.BlogDTO;

// public abstract 생략 
public interface IBlogDAO {

	void select(); // 전체 조회

	BlogDTO select(int id); // id 기반으로 조회

	int delete(int boardId); // boardId 기반으로 삭제

}
