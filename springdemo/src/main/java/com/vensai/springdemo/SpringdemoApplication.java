package com.vensai.springdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringdemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringdemoApplication.class, args);
		
		System.out.println("Welcome To Spring Boot App......");
		
//		Developer dev = new Developer();
		Developer bean = context.getBean(Developer.class);
		bean.show();
		
		Developer bean1 = context.getBean(Developer.class);
		bean1.show();
	}

}
