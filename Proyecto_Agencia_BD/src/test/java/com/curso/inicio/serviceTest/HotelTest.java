package com.curso.inicio.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curso.model.Hotel;
import com.curso.repository.HotelRepository;
import com.curso.service.HotelService;

/**
 * Testing sobre la entidad de Hotel
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
@SpringBootTest
class HotelTest {

	@Autowired
	HotelRepository repository;
	@Autowired
	HotelService service;
	
	@Test
	void contextLoads() {
		assertNotNull(repository);
		assertNotNull(service);
	}
	
	@Test
	void findAllTest() {
		List<Hotel> hoteles = service.findAll();
		assertNotNull(hoteles);
	}
	
	@Test
	void findByIdTest() {
		Hotel hotel = service.findById(1);
		assertEquals("Hotel 1", hotel.getNombre());
		hotel = service.findById(24523);
		assertNull(hotel);
	}
	
	@Test
	void findByNombreTest() {
		Hotel hotel = service.findByNombre("Hotel 1");
		assertEquals(1, hotel.getIdHotel());
		hotel = service.findByNombre("Patata");
		assertNull(hotel);
	}
	
	@Test
	void findHotelesDisponiblesTest() {
		List<Hotel> hoteles = service.findDisponibles();
		for (Hotel h: hoteles) {
			assertTrue(h.isDisponible());
		}
	}
	
	@Test
	void actualizarPlazasHotelTest() {
		String noId = service.actualizarPlazas(31413, 1);
		assertEquals("El hotel con id 31413 no se ha encontrado.", noId);
		String negativo = service.actualizarPlazas(1, -4);
		assertEquals("No se pueden reservar plazas negativas.", negativo);
		Hotel hotel = service.findById(1);
		int plazas = hotel.getPlazas();
		String reserva = service.actualizarPlazas(1, 1);
		assertEquals("Hotel reservado.", reserva);
		
		hotel.setPlazas(plazas);
		repository.save(hotel);
		
		
	}

}
