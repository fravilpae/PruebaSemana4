package com.curso.inicio.controllerTest;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import com.curso.service.HotelService;

/**
 * Testing sobre la clase Controller de Hotel
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
@SpringBootTest
@AutoConfigureMockMvc
class HotelControllerTest {
	
	@MockitoBean
	private HotelService service;
	
	@Autowired
	private MockMvc mockMvc;

	@BeforeEach
	void setUp() throws Exception {
		Hotel hotel = new Hotel(1, "Hotel 1", Categoria.Una_estrella, 12.12, true, 30, "Sevilla");
		when(service.findById(1)).thenReturn(hotel);
		when(service.findByNombre("Hotel 1")).thenReturn(hotel);
		when(service.findAll()).thenReturn(Arrays.asList(hotel));
		when(service.findDisponibles()).thenReturn(Arrays.asList(hotel));
	}

	@Test
	void getHotelesTest() throws Exception {
		mockMvc.perform(get("/hoteles"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].nombre", is("Hotel 1")));
	}
	
	@Test
	void getHotelesDisponiblesTest() throws Exception {
		mockMvc.perform(get("/hoteles/disponibles"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].nombre", is("Hotel 1")));
	}
	
	@Test
	void getHotelPorIdTest() throws Exception {
		mockMvc.perform(get("/hoteles/1"))
			.andExpect(status().isOk());
		mockMvc.perform(get("/hoteles/24323"))
			.andExpect(status().isNotFound());
	}
	
	@Test
	void getHotelPorNombreTest() throws Exception {
		mockMvc.perform(get("/hoteles/nombre/Hotel 1"))
			.andExpect(status().isOk());
		mockMvc.perform(get("/hoteles/nombre/Patata"))
			.andExpect(status().isNotFound());
	}
	
	/*@Test
	void actualizarPlazasHotelTest() throws Exception { TODO - Implementar test
		
	}*/

}
