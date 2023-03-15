package ch01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class MainTest5_user {

	public static void main(String[] args) {

		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/users/1");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int statusCode = conn.getResponseCode();
			if(statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				String line = null;
				
				StringBuffer sb = new StringBuffer();
				
				while((line = reader.readLine())!=null) {
					sb.append(line);
				}
				
				String str = sb.toString();
				Gson gson = new Gson();
				User user = gson.fromJson(str, User.class);
				
				System.out.println("id : "+user.getId());
				System.out.println("name : "+user.getName());
				System.out.println("username : "+user.getUsername());
				System.out.println("email : "+user.getEmail());
				System.out.println("phone : "+user.getPhone());
				System.out.println("website : "+user.getWebsite());

				
			}
			

//			String line = null;
//			StringBuffer sb = new StringBuffer();
//			while ((line = reader.readLine()) != null) {
//				sb.append(line);
//			}
//			
//			String result = sb.toString();
//			Gson gson = new Gson();
//			
//			Type listType = new TypeToken<List<User>>() {}.getType();
//			
//			ArrayList<User> userList = gson.fromJson(result, listType);
//			
//			for (User user : userList) {
//				System.out.println(user);
//			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main

}
