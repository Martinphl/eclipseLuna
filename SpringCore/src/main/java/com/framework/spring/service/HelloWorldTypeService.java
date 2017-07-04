package com.framework.spring.service;

import java.util.HashMap;
import java.util.Map;

import com.framework.spring.HelloWorld;

public class HelloWorldTypeService {
	public Map<String, HelloWorld> helloMap = new HashMap<String, HelloWorld>();

	public Map<String, HelloWorld> getHelloMap() {
		return helloMap;
	}

	public void setHelloMap(Map<String, HelloWorld> helloMap) {
		this.helloMap = helloMap;
	}

	public HelloWorldTypeService() {
	}

	public void sayHelloService(String type) {
		this.getHelloMap().get(type).sayHello();
	}

}
