package com.project.LLM.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.JdkClientHttpRequestFactory;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@Configuration
public class CommunicationConfig {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate(new JdkClientHttpRequestFactory());
	}
	

}
