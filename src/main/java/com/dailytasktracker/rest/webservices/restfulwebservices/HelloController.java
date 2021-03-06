package com.dailytasktracker.rest.webservices.restfulwebservices;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
//@CrossOrigin(origins="http://localhost:4200")
@CrossOrigin(origins="*")
public class HelloController {

	@GetMapping("/")
	public String getHello() {
		return "Hello, I am a web service";
	}
	
	@GetMapping("/user/{name}")
	public User getUserHello(@PathVariable String name) {
		//throw new RuntimeException("Something went Wrong");
		return new User(name); 
	}
}
