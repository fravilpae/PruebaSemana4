package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
 */
@SpringBootApplication(scanBasePackages = {
		"com.curso.controller",
		"com.curso.service",
		"com.curso.configuration"
})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
