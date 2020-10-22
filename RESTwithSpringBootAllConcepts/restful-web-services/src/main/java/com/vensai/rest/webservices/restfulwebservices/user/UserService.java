package com.vensai.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserService {

	@Autowired
	private UserDaoService daoService;

	@GetMapping(path = "/users")
	public List<User> retriveAllUsers() {
		return daoService.findAll();

	}

	@GetMapping(path = "/users/{id}")
	public User getOne(@PathVariable int id) {
		 User userObj = daoService.getOne(id);	 
		 if (userObj == null) {
			 throw new UserNotFoundException("id-"+ id);
		 }
		return userObj; 
	}

	@PostMapping("/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = daoService.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = daoService.deleteById(id);
		if (user == null) {
			throw new UserNotFoundException("id-"+ id);	
		}
		
	}
}
