package com.tenco.myblog2;

import com.tenco.myblog2.controller.AController;
import com.tenco.myblog2.controller.UserController;
import com.tenco.myblog2.dto.UserDto;

public class MainTest1 {

	public static void main(String[] args) {

		// select(); 를 호출할 거임
		// main -> AController -> AService -> ADao 
		// 결과 받아보기
		// " [[>> " + msg + " <<]] "
		
		AController ac = new AController();
		String acResult = ac.select("ㅎㅇ");
		System.out.println(acResult);
		
		System.out.println("-----------------------");
		// 2. 
		// 2 - 1 DBHelper 만들기
		// 2 - 1 UserController 만들기
		// 2 - 2 UserService 만들기
		// 2 - 3 UserDao 만들기
		// UserDao -> UserService -> UserController -> main
		UserController uc = new UserController();
		UserDto responceDto = uc.select(1);
		System.out.println(responceDto);
		
	} // end of main
	
}
