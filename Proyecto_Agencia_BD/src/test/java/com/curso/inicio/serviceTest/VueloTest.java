package com.curso.inicio.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curso.model.Vuelo;
import com.curso.repository.VueloRepository;
import com.curso.service.VueloService;
/**
 * Testing sobre la entidad de Vuelo
 * @author Francisco Manuel Villalobos
 * @version 02/01/2025
 */
@SpringBootTest
class VueloTest {
	
	@Autowired
	VueloRepository repository;
	
	@Autowired
	VueloService service;
	
	@Test
	void contextLoads() {
		assertNotNull(repository);
		assertNotNull(service);
	}
	
	@Test
	void findByPlazasDisponiblesGreaterThanEqualTest() {
		List<Vuelo> vuelos = service.findByPlazasDisponiblesGreaterThanEqual(1000);
		assertTrue(vuelos.isEmpty());
		vuelos = service.findByPlazasDisponiblesGreaterThanEqual(3);
		assertFalse(vuelos.isEmpty());
	}
	
	@Test
	void findVueloPorIdTest() {
		Vuelo vuelo = service.findById(32133);
		assertNull(vuelo);
		vuelo = service.findById(1);
		assertEquals("Iberia", vuelo.getCompania());
	}
	
	@Test
	void findVuelosFuturosTest() {
		List<Vuelo> vuelos = service.findFuturos();
		for(Vuelo v: vuelos) {
			assertTrue(v.getFechaVuelo().isAfter(LocalDateTime.now()));
		}
	}
	
	@Test
	void actualizarPlazasVueloTest() {
		Vuelo v = service.findById(1);
		int plazas = v.getPlazasDisponibles();
		String noId = service.actualizarPlazas(342134, 2);
		assertEquals("El vuelo con id 342134 no se ha encontrado.", noId);
		String negativo = service.actualizarPlazas(1, -4);
		assertEquals("No se pueden reservar plazas negativas.", negativo);
		
		String reservado = service.actualizarPlazas(1, 1);
		assertEquals("Vuelo reservado.", reservado);
		
		v.setPlazasDisponibles(plazas);
		repository.save(v);
	}

}
