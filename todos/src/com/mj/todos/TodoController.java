package com.mj.todos;

public class TodoController {
	private TodoService todoService;

	public TodoController() {
		todoService = new TodoService();
	}

	public int RequestInsertTodo(TodoDTO todoDTO) {
		int result = todoService.todoInsert(todoDTO);
		return result;
	}

	public boolean RequestDeleteTodo(int id) {
		boolean result = todoService.todoDelete(id);
		return result;
	}
	
	public TodoDTO requestSelect(int id) {
		TodoDTO todoDTO = todoService.todoSelect(id);
		return todoDTO;
	}
}
