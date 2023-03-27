package com.mj.todos;

public interface ITodoDAO {
	int insert(TodoDTO todoDTO);

	int delete(int id); // id기반으로 삭제하기

	TodoDTO select(int id); // id기반 검색
	
	int update(TodoDTO todoDTO, int id);
}
