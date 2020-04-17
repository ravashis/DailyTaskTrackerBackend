package com.dailytasktracker.rest.webservices.rest.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins="*")
@RestController
public class BasicAuthenticationController {
	
	@GetMapping("/basicauth")
	public AuthenticationBean basicAuthentication() {
		return new AuthenticationBean("You are authenticated");
		
	}

}
