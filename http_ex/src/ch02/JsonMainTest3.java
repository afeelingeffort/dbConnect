package ch02;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class JsonMainTest3 {

	// main 함수
	public static void main(String[] args) {

		// []
		JsonArray jsonArray = new JsonArray();
		System.out.println(jsonArray); // []

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name", "티모");
		System.out.println(jsonArray);
		System.out.println("===================");
		System.out.println(jsonObject);

		System.out.println("===================");
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);
		jsonArray.add(jsonObject);

		System.out.println(jsonArray);

		//인덱스로 꺼내는 방법 
		JsonObject targetObject = jsonArray.get(2).getAsJsonObject();
		System.out.println(targetObject);
		
		System.out.println("===================");

		JsonArray jsonArray2 = new JsonArray();
		JsonObject jsonObject2 = new JsonObject();
		JsonObject jsonObject3 = new JsonObject();
		JsonObject jsonObject4 = new JsonObject();

		jsonObject2.addProperty("userId", 1);
		jsonObject2.addProperty("id", 1);
		jsonObject2.addProperty("title", "delectus aut autem");
		jsonObject2.addProperty("completed", false);

		jsonObject3.addProperty("userId", 1);
		jsonObject3.addProperty("id", 2);
		jsonObject3.addProperty("title", "quis ut nam facilis et officia qui");
		jsonObject3.addProperty("completed", false);

		jsonObject4.addProperty("userId", 1);
		jsonObject4.addProperty("id", 3);
		jsonObject4.addProperty("title", "fugiat veniam minus");
		jsonObject4.addProperty("completed", false);

		jsonArray2.add(jsonObject2);
		jsonArray2.add(jsonObject3);
		jsonArray2.add(jsonObject4);

		System.out.println(jsonArray2);

		System.out.println("=======================");

	} // end of main

}
