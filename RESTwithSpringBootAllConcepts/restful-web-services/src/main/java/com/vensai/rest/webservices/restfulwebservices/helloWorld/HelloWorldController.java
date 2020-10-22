package com.vensai.rest.webservices.restfulwebservices.helloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
//	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
//	another annotation to improove above line
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello-India";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello-World");
	}
	
	@GetMapping(path = "/hello-world/path-variable/{name}")
	public HelloWorldBean helloWorldBeanPathVariable(@PathVariable String name) {
		return new HelloWorldBean(String.format("Hello-World, %s", name));
	}
	
	@GetMapping(path = "/hello-world-internationalized")
	public String helloWorldInternalized() {
		
		return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}

}
