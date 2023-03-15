package ch01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;

public class MainTest3_post {

	public static void main(String[] args) {

		// 내가 지금 배우고 있는 건 Json
		
		// URL https://jsonplaceholder.typicode.com/posts/19
		// connection
		// conn.setRequestMethod("GET") 사용 후 .connect()로 연결
		// I/O
		// POST <-- 단 ch01패키지에서 만들기
		// 값을 담았다면 콘솔창에 출력

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts/19");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			// 요청 방식 - 웹 서버로부터 리소스를 가져온다.
			conn.setRequestMethod("GET");
			conn.connect();

			// 요청 후 응답을 얻어옴
			int statusCode = conn.getResponseCode();
//			System.out.println(statusCode); //200

			// 제대로 연결이 됐을 때 (statusCode가 200이면) 실행됨
			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;

				StringBuffer sb = new StringBuffer();

				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}
				
				String str = sb.toString();
				Gson gson = new Gson();
				Post post = gson.fromJson(str, Post.class);
				
				System.out.println("userId : "+post.getUserId());
				System.out.println("id : "+post.getId());
				System.out.println("title : "+post.getTitle());
				System.out.println("body : "+post.getBody());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
