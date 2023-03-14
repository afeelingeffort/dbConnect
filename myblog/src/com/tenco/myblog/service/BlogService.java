package com.tenco.myblog.service;

import com.tenco.myblog.dao.BlogDAO;
import com.tenco.myblog.dto.BlogDTO;

// 입력한 값의 형식을 확인, DAO를 이용해서 활용하는 ..!
public class BlogService {

	private BlogDAO blogDAO;

	public BlogService() {
		blogDAO = new BlogDAO();
	}

	// 하나의 게시글 찾는 로직 만들기
	public BlogDTO selectByBoardId(int id) {
		BlogDTO resultDTO = blogDAO.select(id);

		return resultDTO;
	}

	public int deleteBoardById(int boardId, int userId) {

		int resultRow = 0;

		// 검증 : userId 값과 blogWriterId
		// board 테이블에 있는 작성자의 userId 값이 같은지 확인
		BlogDTO blogDTO = selectByBoardId(boardId);

		//blogDto null일 때 방어적 코드 작성
		if (blogDTO != null) {
			int blogWriterId = blogDTO.getUserId();

			// 같은 사람이다. 를 인증하기 위한 if문
			if (blogWriterId == userId) {
				// 삭제 요청 처리
				resultRow = blogDAO.delete(boardId);
			}
		}

		return resultRow;
	}
}
