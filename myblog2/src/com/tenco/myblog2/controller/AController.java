package com.tenco.myblog2.controller;

import com.tenco.myblog2.service.AService;

public class AController {
	
	AService aService;
	
	public AController() {
		aService = new AService();
	}
	
	public String select(String msg) {
		String msg1 = aService.select(msg);
		return msg1;
	}
}
