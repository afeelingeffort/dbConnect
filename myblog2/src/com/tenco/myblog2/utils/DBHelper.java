package com.tenco.myblog2.utils;

import java.sql.Connection;

public class DBHelper {
	
	// 1. Connection 객체를 얻는 연습
	// 주소, 계정, 비번, 등등 ..
	
	private static final String DB_HOST = "localhost";
	private static final String DB_PORT = "3306"; 
	private static final String DB_DATABASE_NAME = "myblog";
	private static final String DB_CHARSET = "UTF-8";
	private static final String DB_USER_NAME = "bloguser";
	private static final String DB_PASSWORD = "1q2w3e4r5t";
	
	private Connection conn;
	
	private static DBHelper dbHelper;
	
	
}
