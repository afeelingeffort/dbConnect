package ch02;

import com.google.gson.JsonObject;

public class JsonMainTest1 {

	// main 함수
	public static void main(String[] args) {

		// 출발
		// JSON 형식의 문자열을 만드는 방법
		// 1. 직접 형식을 지켜서 만들어준다.
		String myJson = "{\r\n"
				+ "	\"name\" : \"티모\"\r\n"
				+ "}";
		
		JsonObject jsonObject1 = new JsonObject();
		// { } <-- 여기까지 만든 거임.
		jsonObject1.addProperty("name", "티모");
		System.out.println(jsonObject1);
	} // end of main

}
