package com.tenco.myblog;

import com.tenco.myblog.controller.BlogController;

public class MainTest1 {

	public static void main(String[] args) {

		// DBHelper 연결 코드 테스트
//		DBHelper dbHelper = DBHelper.getInstance();
//		dbHelper.getConnection();
//		System.out.println("main 에서 주소값 찍음 : " + dbHelper);

		// select(int id) 코드 테스트
		BlogController blogController = new BlogController();
		// BlogDTO dto = blogController.requestBoardContentById(3);
		// System.out.println(dto);
		
		// delete(int boardId, int userId) 코드 테스트
		int result = blogController.requestDeleteBoardById(30, 3);
		System.out.println(result);
		
		
		
	} // end of main

}
