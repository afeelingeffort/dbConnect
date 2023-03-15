package com.tenco.myblog;

import com.tenco.myblog.controller.BlogController;
import com.tenco.myblog.dto.BlogDTO;

public class MainTest1 {

	public static void main(String[] args) {

		// select(int id) 코드 테스트
		BlogController blogController = new BlogController();
//		BlogDTO dto = blogController.requestBoardContentById(4);
//		System.out.println(dto);

		// delete(int boardId, int userId) 코드 테스트
		int result = blogController.requestDeleteBoardById(4, 3);
		System.out.println(result);

	} // end of main

}
