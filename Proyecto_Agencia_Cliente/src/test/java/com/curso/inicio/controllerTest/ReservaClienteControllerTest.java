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

import com.curso.model.HotelDTO;
import com.curso.model.ReservaDTO;
import com.curso.model.VueloDTO;
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
		HotelDTO h = new HotelDTO(1, "Hotel 1", "Una_estrella", 12.12, true, 30, "Sevilla");
		VueloDTO v = new VueloDTO(1, "Iberia",LocalDateTime.of(2025, 3, 15, 8, 30), 150.50, 98, "Sevilla");
		ReservaDTO r = new ReservaDTO(1, "Pepito", "12345678S", h, v);
		when(service.getHotelesDisponibles()).thenReturn(Arrays.asList(h));
		when(service.getReservasPorNombreHotel("Hotel 1")).thenReturn(Arrays.asList(r));
		when(service.getVuelosFuturos()).thenReturn(Arrays.asList(v));
		when(service.getVuelosPorPlazas(2)).thenReturn(Arrays.asList(v));
	}
	
	@Test
	void getReservasDeHotelTest() throws Exception {
		mockMvc.perform(get("/reservas/Hotel 1"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].dni", is("12345678S")));
	}
	
	@Test
	void getHotelesDisponiblesTest() throws Exception {
		mockMvc.perform(get("/hoteles"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].nombre", is("Hotel 1")));
	}
	
	@Test
	void getVuelosFuturosTest() throws Exception {
		mockMvc.perform(get("/vuelos"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].compania", is("Iberia")));
	}
	
	@Test
	void getVuelosPorPlazasTest() throws Exception {
		mockMvc.perform(get("/vuelos/2"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$[0].compania", is("Iberia")));
	}
	
	@Test
	void realizarReservaTest() {
		//TODO - Implementar test
	}

}
