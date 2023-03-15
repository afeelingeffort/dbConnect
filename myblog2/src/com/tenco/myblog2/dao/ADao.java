package com.tenco.myblog2.dao;

public class ADao {
	
	public String select(String msg) {
		String copyMsg = " [[>> " + msg + " <<]] ";
		return copyMsg;
	}
}
