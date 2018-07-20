package com.micro.app.func;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BluepageService {

	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	Config config;
	
	public String get(String email) {
		
		if (!this.check(email)) {
			return String.format("%s, E-mail address is not currect.", email);
		}
		ResponseEntity<String> data = restTemplate.getForEntity(this.config.getBluepageUrl().replace("#EMAIL", email), String.class);
		if (data.getStatusCode().equals(HttpStatus.OK) && data.hasBody()) {
			return data.getBody().toString();
		}
		
		return "";
	}
	
	private boolean check(String email) {
		String regex = "^(.*)@(.*)ibm.com$";
	    Pattern pattern = Pattern.compile(regex);
	    Matcher matcher = pattern.matcher((CharSequence) email);
	    return matcher.matches();
	}
	
}
