package com.curso.service;

import java.util.List;

import com.curso.model.Hotel;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.1 02/01/2025
 */
public interface HotelService {

	List<Hotel> findAll();
	Hotel findByNombre(String nombre);
	String actualizarPlazas(int idHotel, int plazas);
	
	//Métodos necesarios para la parte de cliente
	Hotel findById(int id);
	List<Hotel> findDisponibles();
}
