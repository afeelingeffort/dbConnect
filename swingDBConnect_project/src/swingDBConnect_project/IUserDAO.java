package swingDBConnect_project;

import java.util.ArrayList;

public interface IUserDAO {
	int insert(UserDTO userDTO);

	ArrayList<UserDTO> select(); // 전체 조회

	UserDTO select(int id); // 아이디 기반 조회

	int delete(int id); // id 기반 데이터 삭제

	int update(int id, String targetDate, int targetUserMoney, int targetUserDeposit); // 매개변수 보류
	
	int saveUser(UserJoinDTO userJoinDTO);
}
