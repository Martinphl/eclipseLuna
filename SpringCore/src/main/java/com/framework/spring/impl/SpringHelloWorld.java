package com.framework.spring.impl;

import com.framework.spring.HelloWorld;

public class SpringHelloWorld implements HelloWorld {

	@Override
	public void sayHello() {
		System.out.println("Spring Hello World!");
	}

}
