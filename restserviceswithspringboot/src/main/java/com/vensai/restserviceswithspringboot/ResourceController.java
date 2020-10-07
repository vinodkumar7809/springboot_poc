package com.vensai.restserviceswithspringboot;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class ResourceController {

	@Autowired
	ResourceRepository resourceRepository;

	@GetMapping("/resources")
	public List<Resource> retriveAllResources() {
		return resourceRepository.findAll();
	}

	@GetMapping("/resources/id/{id}")
	public ResponseEntity<Object> retriveResource(@PathVariable int id) {
		Optional<Resource> resource = resourceRepository.findById(id);
		
		 if (!resource.isPresent()) 
			 throw new UserNotFoundException("id-"+id); 
		 EntityModel<Resource> resourceObj = EntityModel.of(resource.get());
		 WebMvcLinkBuilder link = linkTo(methodOn(this.getClass()).retriveAllResources());
		 resourceObj.add(link.withRel("all-resources"));
		return ResponseEntity.ok(resourceObj);
	}

	@PostMapping("/resources")
	public ResponseEntity<Object> saveResource(@Valid @RequestBody Resource resource) {
		Resource savedResource = resourceRepository.save(resource);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("id/{id}")
				.buildAndExpand(savedResource.getId()).toUri();
		
		// URI location =
		// ServletUriComponentsBuilder.fromCurrentRequest().path("id/{id}")
		// .buildAndExpand(savedResource.getId()).toUri();

		return ResponseEntity.created(location).build();
	}

}
