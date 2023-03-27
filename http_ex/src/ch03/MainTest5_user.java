package ch03;

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
			URL url = new URL("https://jsonplaceholder.typicode.com/users");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();

			int statusCode = conn.getResponseCode();
			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//				String line = null;
//				
//				StringBuffer sb = new StringBuffer();
//				
//				while((line = reader.readLine())!=null) {
//					sb.append(line);
//				}
//				
//				String str = sb.toString();
//				Gson gson = new Gson();
//				
//				User user = gson.fromJson(str, User.class);
//				Address address = gson.fromJson(str, Address.class);
//				Company company = gson.fromJson(str, Company.class);
//				
//				System.out.println("id : "+user.getId());
//				System.out.println("name : "+user.getName());
//				System.out.println("username : "+user.getUsername());
//				System.out.println("email : "+user.getEmail());
//				System.out.println("phone : "+user.getPhone());
//				System.out.println("website : "+user.getWebsite());
//
//				System.out.println("street : "+address.getStreet());
//				System.out.println("suite : "+address.getSuite());
//				System.out.println("city : "+address.getCity());
//				System.out.println("zipcode : "+address.getZipcode());
//				
//				System.out.println("lat : "+address.getGeo().getLat());
//				System.out.println("lng : "+address.getGeo().getLng());
//				
//				System.out.println("name : "+company.getName());
//				System.out.println("catchPhrase : "+company.getCatchPhrase());
//				System.out.println("bs : "+company.getBs());

				String line = null;
				StringBuffer sb = new StringBuffer();
				while ((line = reader.readLine()) != null) {
					sb.append(line);
				}

				// User안에 Address를 넣어야 함
				String result = sb.toString();
				Gson gson = new Gson();

				
				// reflection 기법 : 실행됐을 때 생성
				Type listType = new TypeToken<List<User>>() {
				}.getType();
				
				
//				Type listType2 = new TypeToken<List<Address>>() {
//				}.getType();
//				Type listType3 = new TypeToken<List<Company>>() {
//				}.getType();
//				Type listType4 = new TypeToken<List<Geo>>() {
//				}.getType();

				// 지금 콘솔창에 나와 있는 형식대로 출력할 순 없나요 ? 
				ArrayList<User> userList = gson.fromJson(result, listType);
				System.out.println(userList.toString()); // 이렇게 하면 됨.
				
				//ArrayList<Address> userList2 = gson.fromJson(result, listType2);
				//ArrayList<Company> userList3 = gson.fromJson(result, listType3);
				//ArrayList<Geo> userList4 = gson.fromJson(result, listType4);

				// 이거 써서 실제로 어디에 사용되나요 ? 왜, 어디에 쓰는지 모르겠어요
				// Json 서버와 클라이언트 간의 통신을 주고 받을 때 사용하기 때문에 무조건 사용됨
				
				// 이렇게 사용하는 이유는 나중에 화면에 하나씩 찍어야하기 때문에 
				for (User user : userList) {
					System.out.println(user.getId());
					System.out.println(user.getName());
					System.out.println(user.getUsername());
					System.out.println(user.getEmail());
					
					System.out.println(user.getAddress().getStreet());
					System.out.println(user.getAddress().getSuite());
					System.out.println(user.getAddress().getCity());
					System.out.println(user.getAddress().getZipcode());
					
					System.out.println(user.getAddress().getGeo().getLat());
					System.out.println(user.getAddress().getGeo().getLng());
					
					System.out.println(user.getPhone());
					System.out.println(user.getWebsite());
					
					System.out.println(user.getCompany().getName());
					System.out.println(user.getCompany().getCatchPhrase());
					System.out.println(user.getCompany().getBs());
				}
				
//				for (Address address : userList2) {
//					System.out.println(address);
//				}
//				
//				for(Company company : userList3) {
//					System.out.println(company);
//				}
//
//				for (Geo geo : userList4) {
//					System.out.println(geo);
//				}
				
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	} // end of main

}
