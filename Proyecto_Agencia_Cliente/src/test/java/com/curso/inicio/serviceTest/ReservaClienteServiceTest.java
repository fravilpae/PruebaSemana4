package com.curso.inicio.serviceTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curso.model.HotelDTO;
import com.curso.model.ReservaDTO;
import com.curso.model.VueloDTO;
import com.curso.service.ReservaClienteService;

/**
 * Testing para la entidad de ReservaCliente
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
@SpringBootTest
class ReservaClienteServiceTest {
	
	@Autowired
	ReservaClienteService service;
	
	@Test
	void contextLoads() {
		assertNotNull(service);
	}
	
	@Test
	void getReservasPorNombreHotelTest() {
		List<ReservaDTO> reservas = service.getReservasPorNombreHotel("Hotel 1");
		assertFalse(reservas.isEmpty());
	}
	
	@Test
	void getHotelesDisponiblesTest() {
		List<HotelDTO> hoteles = service.getHotelesDisponibles();
		for (HotelDTO h: hoteles) {
			assertTrue(h.isDisponible());
		}
	}
	
	@Test
	void getVuelosPorPlazasTest() {
		List<VueloDTO> vuelos = service.getVuelosPorPlazas(3);
		assertFalse(vuelos.isEmpty());
	}
	
	@Test
	void getVuelosFuturosTest() {
		List<VueloDTO> vuelos = service.getVuelosFuturos();
		assertFalse(vuelos.isEmpty());
		
	}
	
	/*@Test
	void realizarReservaTest() {
		TODO - Implementar test
	}*/

}
