package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class MainTest1 {

	public static void main(String[] args) {
		// Client --> Web Server --> dataBase
		// Client <-- Web Server <-- dataBase

		// 기본 자바표준 기술인 http 클래스를 이용하여 http 통신을 통해서
		// 데이터를 요청하고 응답 받아 보는 기술을 확인해보자.

		// 프로토콜://회사 주소(호스트 주소)/
		// https://jsonplaceholder.typicode.com/todos

		// http통신을 하기 위해 필요한 준비물
		// URL 클래스
		// HttpURLConnection 클래스가 필요
		try {
			
			// http로 통신을 하기 위해 URL 클래스를 이용하여 가져올 가상데이터의 주소를 넣어준다.
			// 그 다음 HttpURLConnection을 이용하여 url과 연결해준다.
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");

			// ctrl + T 눌러 상속관계 확인 --> 다운캐스팅 해줘야 함
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int statusCode = conn.getResponseCode();
			System.out.println("statusCode : " + statusCode);

			// 내용을 읽어오기 위한 입력 스트림
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

			StringBuffer sb = new StringBuffer();
			String line = null;

			// null이 아닐 때까지 반복 -> null이 되면 반복문 종료
			// reader.readLine() --> null 만나면 더이상 읽을 데이터가 없음
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}

			// .toString() : StringBuffer를 String 타입으로 변환
			String resultStr = sb.toString();
			System.out.println(resultStr);

			// Gson 라이브러리 가지고 오고 설정하는 방법
			// gson 대표적인 사용법 및 개념
			Gson gson = new Gson();
//			Todo todo = new Todo();

			JsonObject jsonObject = new JsonObject();
			jsonObject.addProperty("userId", 1);
			jsonObject.addProperty("id", 1);

			String jsonStr = gson.toJson(jsonObject);

			System.out.println(jsonStr);

		} catch (Exception e) {
			e.printStackTrace();
		}
	} // end of main

}
