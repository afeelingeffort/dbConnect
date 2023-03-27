package swingDBConnect_project;

import java.util.ArrayList;

public class UserController {
	private UserService userService;

	public UserController() {
		userService = new UserService();
	}

	public int requestInsertByDTO(UserDTO userDTO) {
		int resultCount = 0;
		resultCount = userService.insertByDTO(userDTO);
		return resultCount;
	}

	public UserDTO requestSelectById(int id) {
		UserDTO userDTO = userService.selectById(id);
		return userDTO;
	}

	public ArrayList<UserDTO> requestSelect() {
		ArrayList<UserDTO> userDTO = new ArrayList<>();
		userDTO = userService.selectAll();
		return userDTO;
	}

	public int requestDeleteById(int id) {
		int resultCount = 0;
		resultCount = userService.deleteById(id);
		return resultCount;
	}

	public int requestUpdate(int id, String targetDate, int targetUserMoney, int targetUserDeposit) {
		int resultCount = 0;
		resultCount = userService.updateById(id, targetDate, targetUserMoney, targetUserDeposit);
		return resultCount;
	}
	
	public String requestSignUp(UserJoinDTO userJoinDTO, String host) {
		String response = "외부에서는 회원가입이 안됩니다.";
		
		if(host.equals("localhost")) {
			response = userService.singUp(userJoinDTO);
		}
		
		return response;
	}
}
