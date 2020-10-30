package com.vensai.demoactuator.demoactuator;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("product")
public class AppController {
	
	@GetMapping
	public List<String> getProducts() {
		
		return Arrays.asList("product1","product2","product3");
	}
	
	@PostMapping
	public String saveProduct(@RequestBody String name) {
		return "New item:"+ name;
		
	}

}
