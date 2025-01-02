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

import com.curso.model.Vuelo;
import com.curso.service.VueloService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 30/12/2024
 */
@Tag(name = "Vuelos", description = "Métodos de vuelos")
@RestController
@RequestMapping("/vuelos")
public class VueloController {
	
	@Autowired
	private VueloService service;
	
	@Operation(summary = "Obtener los vuelos disponibles por plazas",
			description = "Obtiene una lista de todos los vuelos que tienen las suficientes plazas indicadas en el parámetro", 
			responses = {
				@ApiResponse(responseCode = "200", description = "Vuelos encontrados"),
				@ApiResponse(responseCode = "400", description = "Solicitud inválida")
			})
	@GetMapping("/plazas/{plazas}")
	public ResponseEntity<List<Vuelo>> vuelosDisponiblesPorPlazas(@PathVariable("plazas") int plazas) {
		List<Vuelo> vuelos = service.findByPlazasDisponiblesGreaterThanEqual(plazas);
		return ResponseEntity.ok(vuelos);
	}
	
	@Operation(summary = "Obtener el vuelo dada su id",
			description = "Obtiene el vuelo cuya id es indicada en el parámetro", 
			responses = {
				@ApiResponse(responseCode = "200", description = "Vuelo encontrado"),
				@ApiResponse(responseCode = "404", description = "No se ha encontrado vuelo"),
				@ApiResponse(responseCode = "400", description = "Solicitud inválida")
			})
	@GetMapping("/{id}")
	public ResponseEntity<Vuelo> vuelosPorId(@PathVariable("id") int id) {
		Vuelo vuelo = service.findById(id);
		if (vuelo != null) {
			return ResponseEntity.ok(vuelo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@Operation(summary = "Actualizar las plazas disponibles de un vuelo",
			description = "Disminuye las plazas del vuelo indicado en el primer parámetro la cantidad de plazas indicadas en el segundo parámetro",
			responses = {
				@ApiResponse(responseCode = "204", description = "Vuelo actualizado"),
				@ApiResponse(responseCode = "400", description = "Solicitud inválida"),
				@ApiResponse(responseCode = "404", description = "Vuelo no encontrado")
			})
	@PutMapping("/{idVuelo}/{plazas}")
	public ResponseEntity<String> actualizarPlazasVuelo(@PathVariable("idVuelo") int idVuelo, @PathVariable("plazas") int plazas) {
		try {
			String mensaje = service.actualizarPlazasVuelo(idVuelo, plazas);
			return new ResponseEntity<>(mensaje, mensaje.equals("Vuelo reservado") ? HttpStatus.OK : HttpStatus.NOT_FOUND);
		} catch (RuntimeException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@Operation(summary = "Obtener los vuelos que ocurrirán en el futuro",
			description = "Obtiene una lista de todos los vuelos que tienen lugar en el futuro", 
			responses = {
				@ApiResponse(responseCode = "200", description = "Vuelos encontrados"),
				@ApiResponse(responseCode = "400", description = "Solicitud inválida")
			})
	@GetMapping("/futuros")
	public ResponseEntity<List<Vuelo>> obtenerVuelosFuturos() {
		List<Vuelo> vuelos = service.findVuelosFuturos();
		return ResponseEntity.ok(vuelos);
	}

}
