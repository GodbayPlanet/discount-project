package com.discount.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

public class RESTemplate {

	@SuppressWarnings("unused")
	private RestTemplate restTemplate;
	
	@Autowired
	public RESTemplate() {
		this.restTemplate = restTemplate();
	}

	/**
	 * Defining RestTemplate Bean.
	 * 
	 * @return
	 */
	@Bean
	public static RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
