package com.curso.inicio.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.service.VueloService;

/**
 * Testing sobre la clase Controller de Vuelo
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
@SpringBootTest
@AutoConfigureMockMvc
class VueloControllerTest {
	
	@MockitoBean
	private VueloService service;
	
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		//TODO - Implementar tests
	}

	@Test
	void vuelosDisponiblesPorPlazasTest() {
		
	}
	
	@Test
	void vuelosPorIdTest() {
		
	}
	
	@Test
	void obtenerVuelosFuturosTest() {
		
	}
	
	@Test
	void actualizarPlazasVueloTest() {
		
	}

}
