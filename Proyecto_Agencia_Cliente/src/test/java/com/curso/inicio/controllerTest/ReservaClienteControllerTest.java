package com.curso.inicio.controllerTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.service.ReservaClienteService;

/**
 * Testing sobre la clase Controller de ReservaCliente
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
@SpringBootTest
@AutoConfigureMockMvc
class ReservaClienteControllerTest {

	@MockitoBean
	private ReservaClienteService service;
	
	@Autowired
	private MockMvc mockMvc;
	
	@BeforeEach
	void setUp() throws Exception {
		//TODO - Implementar tests
	}
	
	@Test
	void getReservasDeHotelTest() {
		
	}
	
	@Test
	void getHotelesDisponiblesTest() {
		
	}
	
	@Test
	void getVuelosFuturosTest() {
		
	}
	
	@Test
	void getVuelosPorPlazasTest() {
		
	}
	
	@Test
	void realizarReservaTest() {
		
	}

}
