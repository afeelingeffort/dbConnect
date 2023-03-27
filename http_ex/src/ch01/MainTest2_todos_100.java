package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;

public class MainTest2_todos_100 {

	public static void main(String[] args) {

		try {
			// http로 통신을 하기 위해 URL 클래스를 이용하여 가져올 가상데이터의 주소를 넣어준다.
			// 그 다음 HttpURLConnection을 이용하여 url과 연결해준다.
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/100");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// http 요청 --> 2가지 방식 (GET, POST)
			conn.setRequestMethod("GET");
			conn.connect(); // 스트림이 연결됨

			int statusCode = conn.getResponseCode();
//			System.out.println(statusCode); // 200 : 통신 O / 404 : 통신X 요청 URL이 없다.

			if (statusCode == 200) {
				// conn 사용
				// 내용을 읽어오기 위한 입력 스트림
				// 기반 스트림 + 보조 스트림 : 데코레이션 패턴
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;

				StringBuffer sb = new StringBuffer();

				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				// System.out.println(sb.toString());

				// JSON Parsing 해보기 -> 문자열 --> Java Object 변환

				String str = sb.toString();
				Gson gson = new Gson();
				Todo todo = gson.fromJson(str, Todo.class); // runtime시점에 생성

				System.out.println("id : " + todo.getId());
				System.out.println("userId : " + todo.getUserId());
				System.out.println("title : " + todo.getTitle());
				System.out.println("completed : " + todo.isCompleted());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main

}
