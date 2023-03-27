package com.mj.todos;

public class TodoService {
	private TodoDAO todoDAO;

	public TodoService() {
		todoDAO = new TodoDAO();
	}

	public int todoInsert(TodoDTO todoDTO) {
		int rowCount = 0;
		rowCount = todoDAO.insert(todoDTO);
		return rowCount;
	}

	// 몇 행이 삭제 됐는지 알고 싶으면 int, 삭제 여부를 알고 싶으면 boolean
	public boolean todoDelete(int id) {
		int rowCount = 0;
		rowCount = todoDAO.delete(id);
		return false;
	}
	
	//select
	public TodoDTO todoSelect(int id) {
		TodoDTO todoDTO = todoDAO.select(id);
		return todoDTO;
	}
}
