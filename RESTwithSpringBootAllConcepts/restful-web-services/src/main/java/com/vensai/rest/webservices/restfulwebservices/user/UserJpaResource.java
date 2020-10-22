package com.vensai.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.sound.midi.ControllerEventListener;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserJpaResource {

	@Autowired
	private UserDaoService daoService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;

	@GetMapping(path = "/jpa/users")
	public List<User> retriveAllUsers() {
		return userRepo.findAll();

	}

	@GetMapping(path = "/jpa/users/{id}")
	public User getOne(@PathVariable int id) {
		Optional<User> user = userRepo.findById(id);
		 if (!user.isPresent()) {
			 throw new UserNotFoundException("id-"+ id);
			 
//			 Resource<User> resource = new Resource<User>(user.get());
//			ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retriveAllUsers());
//			 resource.add(linlTo.withRel("all-users")); 
		 }
		return user.get(); 
	}

	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
//		User savedUser = daoService.save(user);
		User savedUser = userRepo.save(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build(); 

	}
	
	@DeleteMapping("/jpa/users/{id}")
	public void deleteUser(@PathVariable int id) {
	   userRepo.deleteById(id);
	}
	
	@GetMapping(path = "/jpa/users/{id}/posts")
	public List<Post> retriveAllUsers(@PathVariable int id) {
		Optional<User> findById = userRepo.findById(id);
		if (!findById.isPresent()) {
			throw new UserNotFoundException("id-"+ id);
		}
        return findById.get().getPosts();
	}
	
	@PostMapping("/jpa/users/{id}/posts")
	public ResponseEntity<Object> createUser(@PathVariable int id , @RequestBody Post post) {
		Optional<User> userOptional = userRepo.findById(id);
		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id-"+ id);
		}
		User user = userOptional.get();
		post.setUser(user);
		
//		User savedUser = daoService.save(user);
		postRepo.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(post.getId())
				.toUri();
		return ResponseEntity.created(location).build();

	}
}
