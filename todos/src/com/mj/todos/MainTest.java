package com.mj.todos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest {

	public static void main(String[] args) {
		TodoController tc = new TodoController();

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos");
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			connection.connect();

			int responseCode = connection.getResponseCode();

			if (responseCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

				String line = null;
				StringBuffer sb = new StringBuffer();

				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				String result = sb.toString();
				Gson gson = new Gson();

				Type listType = new TypeToken<List<TodoDTO>>() {
				}.getType();


				ArrayList<TodoDTO> todoList = gson.fromJson(result, listType);
				System.out.println(todoList.toString());

				for (int i = 0; i < todoList.size(); i++) {
					tc.RequestInsertTodo(todoList.get(i));
				}

			}

		} catch (Exception e) {
			System.out.println("main에서 에러 발생");
			e.printStackTrace();
		}

//		TodoDTO dto = new TodoDTO(100, 100, "asdf", false);
//		tc.RequestInsertTodo(dto);
		
//		tc.RequestDeleteTodo(100);
		
		TodoDTO dto = tc.requestSelect(3);
		System.out.println(dto);
	}

}
