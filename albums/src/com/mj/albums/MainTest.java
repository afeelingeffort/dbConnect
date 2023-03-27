package com.mj.albums;

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

		AlbumController albumController = new AlbumController();

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/albums");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int statusCode = conn.getResponseCode();

			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

				String line = null;
				StringBuffer sb = new StringBuffer();
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				String result = sb.toString();
				Gson gson = new Gson();

//				AlbumDTO album = gson.fromJson(result, AlbumDTO.class);
//
//				System.out.println("userId : " + album.getUserId());
//				System.out.println("id : " + album.getId());
//				System.out.println("title : " + album.getTitle());

				Type listType = new TypeToken<List<AlbumDTO>>() {
				}.getType();

				ArrayList<AlbumDTO> userList = gson.fromJson(result, listType);
				System.out.println(userList.toString());

				for (int i = 0; i < userList.size(); i++) {
					albumController.requestInsertAlbum(userList.get(i));
				}
				
//				for (AlbumDTO albumDTO : userList) {
//					System.out.println(albumDTO.getId());
//					System.out.println(albumDTO.getUserId());
//					System.out.println(albumDTO.getTitle());
//				}
			}
		} catch (Exception e) {
			System.out.println("main에서 에러 발생");
			e.printStackTrace();
		}

		//int insertRow = albumController.requestInsertAlbum(dto);

		//System.out.println(insertRow);

//		AlbumDTO dto = albumController.requestSelectAlbum(2);
//		System.out.println(dto);
//		
//		int result = albumController.requestDeleteAlbum(101);
//		System.out.println(result);
		
		int result = albumController.requestUpdate(5, 1, 1);
		System.out.println(result);
	}

}
