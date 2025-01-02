package com.curso.inicio;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curso.service.ReservaClienteService;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
@SpringBootTest
class ApplicationTests {
	
	@Autowired
	ReservaClienteService service;

	@Test
	void contextLoads() {
		assertNotNull(service);
	}

}
