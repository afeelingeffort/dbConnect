package swingDBConnect_project;

public class MainTest {

	public static void main(String[] args) {
		UserController userController = new UserController();
//		SimpleDateFormat date1 = new SimpleDateFormat("yyyy-MM-dd");
//		Date date = date1.parse("2022-04-03");

//		UserDTO userDTO = new UserDTO(3, "2022-08-18", 200000, 500000, 100000, "ㅁㄴㅇㄹ");
//		userController.requestInsertByDTO(userDTO);

//		int result = userController.requestDeleteById(2);
//		System.out.println(result);

//		UserDTO result = userController.requestSelectById(3);
//		System.out.println(result);

//		int result = userController.requestUpdate(3, "2055-05-12", 13654, 56416);
		
		UserJoinDTO userJoinDTO = new UserJoinDTO("asdf", "fd", "asdf", "asdf", "asdf");
		String result = userController.requestSignUp(userJoinDTO, "localhost");
		System.out.println(result);
		
	}

}
