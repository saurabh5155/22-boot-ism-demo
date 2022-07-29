package com;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@PostMapping("/signup")
	public String saveUser() {
		return "Save User";
	}
}
