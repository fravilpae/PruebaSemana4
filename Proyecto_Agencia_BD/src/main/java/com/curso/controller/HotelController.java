package com.curso.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.model.Hotel;
import com.curso.service.HotelService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.1 02/01/2025
 */
@Tag(name = "Hoteles", description = "Métodos de hoteles")
@RestController
@RequestMapping("/hoteles")
public class HotelController {

	@Autowired
	private HotelService service;
	
	@Operation(summary = "Obtener todos los hoteles", description = "Devuelve una lista de todos los hoteles", responses = {
			@ApiResponse(responseCode = "200", description = "Hoteles encontrados")
	})
	@GetMapping()
	public ResponseEntity<List<Hotel>> getHoteles() {
		List<Hotel> hoteles = service.findAll();
		return ResponseEntity.ok(hoteles);
	}
	
	@Operation(summary = "Obtener todos los hoteles disponibles", description = "Devuelve una lista de todos los hoteles con plazas libres", responses = {
			@ApiResponse(responseCode = "200", description = "Hoteles encontrados")
	})
	@GetMapping("/disponibles")
	public ResponseEntity<List<Hotel>> getHotelesDisponibles() {
		List<Hotel> hoteles = service.findDisponibles();
		return ResponseEntity.ok(hoteles);
	}
	
	@Operation(summary = "Obtener un hotel dado su id", description = "Devuelve un hotel cuya id coincide con la de la URL", responses = {
			@ApiResponse(responseCode = "200", description = "Hotel encontrado"),
			@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
			@ApiResponse(responseCode = "404", description = "Hotel no encontrado")
		})
		@GetMapping("/{id}")
		public ResponseEntity<Hotel> getHotelPorId(@PathVariable("id") int id) {
			Hotel hotel = service.findById(id);
			if (hotel != null) {
				return ResponseEntity.ok(hotel);
			} else {
				return ResponseEntity.notFound().build();
			}
		}
	
	@Operation(summary = "Obtener un hotel dado su nombre", description = "Devuelve un hotel cuyo nombre coincide con el de la URL", responses = {
		@ApiResponse(responseCode = "200", description = "Hotel encontrado"),
		@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
		@ApiResponse(responseCode = "404", description = "Hotel no encontrado")
	})
	@GetMapping("/nombre/{nombre}")
	public ResponseEntity<Hotel> getHotelPorNombre(@PathVariable("nombre") String nombre) {
		Hotel hotel = service.findByNombre(nombre);
		if (hotel != null) {
			return ResponseEntity.ok(hotel);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "Actualizar las plazas disponibles de un hotel",
			description = "Disminuye las plazas del hotel indicado en el primer parámetro la cantidad de plazas indicadas en el segundo parámetro",
			responses = {
				@ApiResponse(responseCode = "204", description = "Hotel actualizado"),
				@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
				@ApiResponse(responseCode = "404", description = "Hotel no encontrado")
			})
	@PutMapping("/{idHotel}/{plazas}")
	public ResponseEntity<String> actualizarPlazasHotel(@PathVariable("idHotel") int idHotel, @PathVariable("plazas") int plazas) {
		try {
			String mensaje = service.actualizarPlazas(idHotel, plazas);
			return new ResponseEntity<>(mensaje, mensaje.equals("Hotel reservado") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
