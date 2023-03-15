package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonMainTest4 {

	public static void main(String[] args) {
		JsonArray jsonArray1 = new JsonArray();

		JsonObject jsonObject1 = new JsonObject();
		JsonObject jsonObject2 = new JsonObject();
		JsonObject jsonObject3 = new JsonObject();

		jsonObject1.addProperty("name", "홍길동");
		jsonObject1.addProperty("age", 20);
		jsonObject1.addProperty("address", "부산");

		jsonObject2.addProperty("name", "이순신");
		jsonObject2.addProperty("age", 33);
		jsonObject2.addProperty("address", "서울");

		jsonObject3.addProperty("name", "세종대왕");
		jsonObject3.addProperty("age", 59);
		jsonObject3.addProperty("address", "세종시");

		jsonArray1.add(jsonObject1);
		jsonArray1.add(jsonObject2);
		jsonArray1.add(jsonObject3);
		System.out.println(jsonArray1);

		System.out.println("===========================");
		JsonObject jsonObject4 = new JsonObject();

		//todoList 안에 배열을 선언해야 됨
		JsonObject jsonObject5 = new JsonObject();
		JsonObject jsonObject6 = new JsonObject();
		jsonObject5.addProperty("id", 1);
		jsonObject5.addProperty("title", "청소");
		jsonObject5.addProperty("complete", false);
		
		jsonObject6.addProperty("id", 2);
		jsonObject6.addProperty("title", "영어공부");
		jsonObject6.addProperty("complete", true);
		
		JsonArray jsonArray2 = new JsonArray();
		jsonArray2.add(jsonObject5);
		jsonArray2.add(jsonObject6);

		// jsonArray2가 부모니까 들어갈 수 있음
		// jsonArray2.toString()을 써서 문자열로 '\' 들어갔던 거임
		jsonObject4.add("todoList", jsonArray2);

		JsonArray jsonArray3 = new JsonArray();
		jsonArray3.add(jsonObject5);

		jsonObject4.addProperty("server_name", "server_1");

		System.out.println(jsonObject4);
	} // end of main

}
