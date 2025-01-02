package com.curso.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Vuelo;
import com.curso.repository.VueloRepository;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.1 02/01/2025
 */
@Service
public class VueloServiceImpl implements VueloService {
	
	@Autowired
	private VueloRepository repository;

	/**
	 * Devuelve todos los vuelos que tienen tantas plazas disponibles como indicadas en el parámetro
	 * 
	 * @param plazas Número de plazas que se desean reservar en el avión
	 */
	@Override
	public List<Vuelo> findByPlazasDisponiblesGreaterThanEqual(int plazas) {
		return repository.findByPlazasDisponiblesGreaterThanEqual(plazas);
	}

	/**
	 * Actualiza el vuelo indicado, restando el número de plazas a reservar del número de plazas disponibles del avión
	 * 
	 * @param idVuelo Id del vuelo que se va a reservar
	 * @param plazas Número de plazas a reservar en el avión
	 */
	@Override
	public String actualizarPlazas(int idVuelo, int plazas) {
		if (plazas <= 0) {
			return "No se pueden reservar plazas negativas.";
		}
		Vuelo vueloAModificar = repository.findById(idVuelo).orElse(null);
		if (vueloAModificar != null) {
			if (plazas <= vueloAModificar.getPlazasDisponibles()) {
				vueloAModificar.setPlazasDisponibles(vueloAModificar.getPlazasDisponibles()-plazas);
				repository.save(vueloAModificar);
				return "Vuelo reservado.";
			} else {
				throw new RuntimeException("El vuelo no tiene las suficientes plazas para la reserva.");
			}
		} else {
			return "El vuelo con id "+idVuelo+" no se ha encontrado.";
		}
	}

	@Override
	public Vuelo findById(int id) {
		return repository.findById(id).orElse(null);
	}

	/**
	 * Devuelve los vuelos futuros a cuando se ejecuta el método
	 */
	@Override
	public List<Vuelo> findFuturos() {
		LocalDateTime hoy = LocalDateTime.now();
		return repository.findAllByFechaVueloAfter(hoy);
	}

}
