package com.micro.app.func;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	@Autowired
	private BluepageService bluepageService;
	
    @GetMapping("/bluepage/{email:.+}")
	public String simple(@PathVariable String email) throws Exception {
    		return this.bluepageService.get(email);
	}
    
}
