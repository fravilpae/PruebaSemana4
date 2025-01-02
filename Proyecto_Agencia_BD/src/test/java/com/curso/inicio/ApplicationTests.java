package com.curso.inicio;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.curso.repository.HotelRepository;
import com.curso.repository.ReservaRepository;
import com.curso.repository.VueloRepository;
import com.curso.service.HotelService;
import com.curso.service.ReservaService;
import com.curso.service.VueloService;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
@SpringBootTest
class ApplicationTests {
	
	@Autowired
	HotelRepository hotelRepository;
	
	@Autowired
	VueloRepository vueloRepository;
	
	@Autowired
	ReservaRepository reservaRepository;
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	VueloService vueloService;
	
	@Autowired
	ReservaService reservaService;

	@Test
	void contextLoads() {
		assertNotNull(hotelRepository);
		assertNotNull(hotelService);
		assertNotNull(vueloRepository);
		assertNotNull(vueloService);
		assertNotNull(reservaRepository);
		assertNotNull(reservaService);
	}

}
