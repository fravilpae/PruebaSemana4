package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.HotelDTO;
import com.curso.model.ReservaCliente;
import com.curso.model.ReservaDTO;
import com.curso.model.VueloDTO;
import com.curso.service.ReservaClienteService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.1 02/01/2025
 */
@Tag(name = "Reservas Cliente", description = "Métodos de reserva de un cliente")
@RestController
public class ReservaClienteController {
	
	@Autowired
	private ReservaClienteService service;
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@Operation(description = "Realizar una reserva",
			summary = "Se crea una reserva en la base de datos y se actualizan el hotel y vuelo correspondientes", responses = {
		@ApiResponse(responseCode = "201", description = "Reserva realizada"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida")
	})
	@PostMapping(value = "/reservas")
	public ResponseEntity<String> realizarReserva(@Valid @RequestBody ReservaCliente reservaCliente) {
		try {
			service.realizarReserva(reservaCliente);
			return new ResponseEntity<>("Reserva realizada", HttpStatus.CREATED);
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@Operation(description = "Obtener reservas de un hotel", summary = "Obtiene las reservas a partir del nombre de un hotel", responses = {
		@ApiResponse(responseCode = "200", description = "Reservas encontradas"),
		@ApiResponse(responseCode = "404", description = "Hotel no encontrado"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida")
	})
	@GetMapping(value = "/reservas/{nombre}")
	public ResponseEntity<List<ReservaDTO>> getReservasDeHotel(@PathVariable("nombre") String nombreHotel) {
		List<ReservaDTO> reservas = service.getReservasPorNombreHotel(nombreHotel);
		return new ResponseEntity<>(reservas, reservas != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}
	
	@Operation(description = "Obtener hoteles disponibles", summary = "Obtiene los hoteles que están disponibles", responses = {
			@ApiResponse(responseCode = "200", description = "Hoteles encontrados")
		})
	@GetMapping("/hoteles")
	public ResponseEntity<List<HotelDTO>> getHotelesDisponibles() {
		List<HotelDTO> hoteles = service.getHotelesDisponibles();
		return ResponseEntity.ok(hoteles);
	}
	
	@Operation(description = "Obtener vuelos futuros", summary = "Obtiene los vuelos que ocurren en el futuro", responses = {
			@ApiResponse(responseCode = "200", description = "Vuelos encontrados")
		})
	@GetMapping("/vuelos")
	public ResponseEntity<List<VueloDTO>> getVuelosFuturos() {
		List<VueloDTO> vuelos = service.getVuelosFuturos();
		return ResponseEntity.ok(vuelos);
	}
	
	@Operation(description = "Obtener vuelos disponibles por plazas", summary = "Obtiene los vuelos con un mínimo de plazas disponibles", responses = {
			@ApiResponse(responseCode = "200", description = "Vuelos encontrados")
		})
	@GetMapping("/vuelos/{plazas}")
	public ResponseEntity<List<VueloDTO>> getVuelosPorPlazas(@PathVariable("plazas") int plazas) {
		List<VueloDTO> vuelos = service.getVuelosPorPlazas(plazas);
		return ResponseEntity.ok(vuelos);
	}

}
