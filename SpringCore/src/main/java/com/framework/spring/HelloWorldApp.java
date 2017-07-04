package com.framework.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.framework.spring.service.HelloWorldTypeService;

public class HelloWorldApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.xml");
		HelloWorldTypeService typeService = (HelloWorldTypeService) context
				.getBean("helloWorldtypeService");
		typeService.sayHelloService(new String("Struts"));

		// HelloWorldService service = (HelloWorldService) context
		// .getBean("helloWorldService");
		// HelloWorld hw = service.getHello();
		// hw.sayHello();

	}
}
