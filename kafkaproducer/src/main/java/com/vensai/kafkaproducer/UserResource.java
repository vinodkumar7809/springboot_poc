package com.vensai.kafkaproducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka")
public class UserResource {
	
	@Autowired	
	private KafkaTemplate<String, User> template;
	
	private static final String TOPIC ="mytopic";
	
	@GetMapping(value="/publish/{id}/{name}")
	public String post(@PathVariable("id") String id,
			@PathVariable("name") String name) {
		template.send(TOPIC, new User(id,name));
		
		return "Published Successfully.........";
		
	}

}
