package com.xbz.service.impl;

import com.xbz.service.DemoService;

public class DemoServiceImpl implements DemoService {

	public String sayHello(String name) {
		System.out.println("init : " + name);
		return "hello " + name;
	}

}
