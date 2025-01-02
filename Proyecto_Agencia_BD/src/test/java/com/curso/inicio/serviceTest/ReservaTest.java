package com.curso.inicio.serviceTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curso.model.Reserva;
import com.curso.repository.ReservaRepository;
import com.curso.service.ReservaService;

/**
 * Testing para la entidad de Reserva
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
@SpringBootTest
class ReservaTest {
	
	@Autowired
	ReservaRepository repository;
	
	@Autowired
	ReservaService service;
	
	@Test
	void contextLoads() {
		assertNotNull(repository);
		assertNotNull(service);
	}
	
	@Test
	void findAllTest() {
		List<Reserva> reservas = service.findAll();
		assertNotNull(reservas);
	}
	
	@Test
	void saveTest() {
		Reserva reserva = service.findAll().get(0);
		Reserva reserva2 = new Reserva("Juan", "24524521R", reserva.getHotel(), reserva.getVuelo());
		service.save(reserva2);
		List<Reserva> reservas = service.findAll();
		Reserva reservaGuardada = reservas.get(reservas.size()-1);
		assertTrue(reservaGuardada.getDni().equals(reserva2.getDni()));
		
		repository.delete(reservaGuardada);
	}
	
	@Test
	void findReservasPorHotelTest() {
		List<Reserva> reservas = service.findByHotel(1);
		for(Reserva r: reservas) {
			assertTrue(r.getHotel().getIdHotel() == 1);
		}
		reservas = service.findByHotel(342);
		assertTrue(reservas.isEmpty());
	}

}
