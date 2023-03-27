package swingDBConnect_project;

import java.sql.Array;
import java.util.ArrayList;

public class UserService {
	private UserDAO userDAO;

	public UserService() {
		userDAO = new UserDAO();
	}

	public int insertByDTO(UserDTO userDTO) {
		int resultRow = 0;
		resultRow = userDAO.insert(userDTO);
		return resultRow;
	}

	public UserDTO selectById(int id) {
		UserDTO userDTO = userDAO.select(id);
		return userDTO;
	}

	public ArrayList<UserDTO> selectAll() {
		ArrayList<UserDTO> userDTO = new ArrayList<>();
		userDTO = userDAO.select();
		return userDTO;
	}

	public int deleteById(int id) {
		int resultRow = 0;
		resultRow = userDAO.delete(id);
		return resultRow;
	}

	public int updateById(int id, String targetDate, int targetUserMoney, int targetUserDeposit) {
		int resultRow = 0;
		resultRow = userDAO.update(id, targetDate, targetUserMoney, targetUserDeposit);
		return resultRow;
	}

	public String singUp(UserJoinDTO userJoinDTO) {
		String msg = "";
		if(userJoinDTO.getUsername().equals("")) {
			msg = "사용자 아이디를 입력해주세요";
			System.out.println(msg);
			return msg;
		}
		int resultRow = userDAO.saveUser(userJoinDTO);
		return resultRow + "";
	}
	
	
}
