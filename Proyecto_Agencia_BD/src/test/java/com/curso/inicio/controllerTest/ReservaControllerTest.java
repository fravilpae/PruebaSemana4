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

import com.curso.model.Categoria;
import com.curso.model.Hotel;
import com.curso.model.Reserva;
import com.curso.model.Vuelo;
import com.curso.service.ReservaService;

/**
 * Testing sobre la clase Controller de Reserva
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
@SpringBootTest
@AutoConfigureMockMvc
class ReservaControllerTest {
	
	@MockitoBean
	private ReservaService service;
	
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		Hotel h = new Hotel(1, "Hotel 1", Categoria.Una_estrella, 12.12, true, 30, "Sevilla");
		Vuelo v = new Vuelo(1, "Iberia",LocalDateTime.of(2025, 3, 15, 8, 30), 150.50, 98, "Sevilla");
		Reserva r = new Reserva(1, "Pepito", "12345678S", h, v);
		when(service.findAll()).thenReturn(Arrays.asList(r));
		when(service.findByHotel(1)).thenReturn(Arrays.asList(r));
	}

	@Test
	void getReservasTest() throws Exception {
		mockMvc.perform(get("/reservas"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].dni", is("12345678S")));
	}
	
	@Test
	void getReservasPorNombreHotelTest() throws Exception {
		mockMvc.perform(get("/reservas/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].dni", is("12345678S")));
	}
	
	@Test
	void crearReservaTest() {
		//TODO - Implementar test
	}

}
