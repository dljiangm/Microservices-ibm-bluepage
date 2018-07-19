package com.mirco.app.func;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Config {
	
	@Value("${bluepage.url.byemail}")
	private String bluepageUrl;
	
	@Value("${rest.timeout.connect}")
	private int connectTimeout;
	
	@Value("${rest.timeout.read}")
	private int readTimeOut;
	
	public int getConnectTimeout() {
		return connectTimeout;
	}

	public void setConnectTimeout(int connectTimeout) {
		this.connectTimeout = connectTimeout;
	}

	public int getReadTimeOut() {
		return readTimeOut;
	}

	public void setReadTimeOut(int readTimeOut) {
		this.readTimeOut = readTimeOut;
	}

	public String getBluepageUrl() {
		return bluepageUrl;
	}
	
	public void setBluepageUrl(String bluepageUrl) {
		this.bluepageUrl = bluepageUrl;
	}

	@Bean
	RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();  
		requestFactory.setConnectTimeout(this.getConnectTimeout());
		requestFactory.setReadTimeout(this.getReadTimeOut());
		return new RestTemplate(requestFactory);
	}
}
