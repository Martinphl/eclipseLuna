package com.framework.spring.impl;

import com.framework.spring.HelloWorld;

public class StrutsHelloWorld implements HelloWorld {

	@Override
	public void sayHello() {
		System.out.println("Struts Hello World!");
	}


}
