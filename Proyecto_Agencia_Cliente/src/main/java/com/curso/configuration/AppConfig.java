package com.curso.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
/**
 * @author Francisco Manuel VIllalobos
 * @version 1.0 31/12/2024
 */
@Configuration
public class AppConfig {
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
