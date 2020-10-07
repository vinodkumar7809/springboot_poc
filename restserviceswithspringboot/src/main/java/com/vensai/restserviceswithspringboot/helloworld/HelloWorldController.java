package com.vensai.restserviceswithspringboot.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
//	@RequestMapping(method = RequestMethod.GET, path="/hello-world")
	@GetMapping("/hello-world")
	public String helloWorld() {
		return "Hello-world";
	}
	
	@GetMapping(path = "/hello-world-bean")
	public User helloWorldBean() {
		return new User("Hello-World");
	}
	
	@GetMapping("/hello-world-user/path-variable/{name}")
	public User helloWorldUser(@PathVariable String name) {
		return new User(name);
	}
}
