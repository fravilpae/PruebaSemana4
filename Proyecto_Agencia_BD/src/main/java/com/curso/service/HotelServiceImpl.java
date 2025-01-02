package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Hotel;
import com.curso.repository.HotelRepository;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 30/12/2024
 */
@Service
public class HotelServiceImpl implements HotelService {
	
	@Autowired
	private HotelRepository repository;

	@Override
	public List<Hotel> findAll() {
		return repository.findAll();
	}

	@Override
	public Hotel findByNombre(String nombre) {
		return repository.findByNombreIgnoreCase(nombre).orElse(null);
	}

	@Override
	public Hotel findById(int id) {
		return repository.findById(id).orElse(null);
	}

	/**
	 * Actualiza las plazas de un hotel "tras realizar una reserva".
	 * Comprueba que el hotel tiene plazas suficientes disponibles para realizarse.
	 * Si se agotan las plazas, el hotel deja de estar disponible.
	 * 
	 * @param idHotel id del hotel que se va a actualizar
	 * @param plazas Número de plazas que se van a ocupar
	 */
	@Override
	public String actualizarPlazasHotel(int idHotel, int plazas) {
		Hotel hotelAModificar = repository.findById(idHotel).orElse(null);
		if (hotelAModificar != null) {
			if (plazas <= hotelAModificar.getPlazas()) {
				hotelAModificar.setPlazas(hotelAModificar.getPlazas()-plazas);
				if(hotelAModificar.getPlazas()==0) {
					hotelAModificar.setDisponible(false);
				}
				repository.save(hotelAModificar);
				return "Hotel reservado";
			} else {
				throw new RuntimeException("El hotel no tiene las suficientes plazas para la reserva.");
			}
		} else {
			return "El hotel con id "+idHotel+" no se ha encontrado.";
		}
	}

	/**
	 * Devuelve la lista de todos los hoteles que están disponibles
	 */
	@Override
	public List<Hotel> findHotelesDisponibles() {
		return repository.findAllByDisponibleTrue();
	}

}
