package com.curso.inicio.controllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import com.curso.model.Vuelo;
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
		Vuelo v = new Vuelo(1, "Iberia",LocalDateTime.of(2025, 3, 15, 8, 30), 150.50, 98, "Sevilla");
		when(service.findById(1)).thenReturn(v);
		when(service.findFuturos()).thenReturn(Arrays.asList(v));
		when(service.findByPlazasDisponiblesGreaterThanEqual(2)).thenReturn(Arrays.asList(v));
	}

	@Test
	void vuelosDisponiblesPorPlazasTest() throws Exception {
		mockMvc.perform(get("/vuelos/plazas/2"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].compania", is("Iberia")));
	}
	
	@Test
	void vuelosPorIdTest() throws Exception {
		mockMvc.perform(get("/vuelos/1"))
			.andExpect(status().isOk());
		mockMvc.perform(get("/vuelos/24323"))
			.andExpect(status().isNotFound());
	}
	
	@Test
	void obtenerVuelosFuturosTest() throws Exception {
		mockMvc.perform(get("/vuelos/futuros"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].compania", is("Iberia")));
	}
	
	@Test
	void actualizarPlazasVueloTest() {
		//TODO - Implementar test
	}

}
