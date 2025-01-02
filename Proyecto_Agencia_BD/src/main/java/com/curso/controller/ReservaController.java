package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Reserva;
import com.curso.service.ReservaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
 */
@Tag(name = "Reservas", description = "Métodos de reservas")
@RestController
@RequestMapping("/reservas")
public class ReservaController {
	
	@Autowired
	private ReservaService service;
	
	@Operation(summary = "Obtener la lista de reservas", description = "Devuelve una lista con todas las reservas", responses = {
		@ApiResponse(responseCode = "200", description = "Reservas encontradas")
	})
	@GetMapping
	public ResponseEntity<List<Reserva>> getReservas() {
		List<Reserva> reservas = service.findAll();
		return ResponseEntity.ok(reservas);
	}
	
	@Operation(summary = "Crea una reserva", description = "Crea una reserva a partir de los datos añadidos en el cuerpo", responses = {
		@ApiResponse(responseCode = "201", description = "Reserva creada"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida")
	})
	@PostMapping
	public ResponseEntity<String> addReserva(@RequestBody Reserva r) {
		service.save(r);
		return new ResponseEntity<>("Reserva creada", HttpStatus.CREATED);
	}
	
	@GetMapping("/{idHotel}")
	public ResponseEntity<List<Reserva>> getReservasPorHotelId(@PathVariable("idHotel") int idHotel) {
		List<Reserva> reservas = service.findReservasPorHotel(idHotel);
		return ResponseEntity.ok(reservas);
	}

}
