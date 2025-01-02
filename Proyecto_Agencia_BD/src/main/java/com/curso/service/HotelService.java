package com.curso.service;

import java.util.List;

import com.curso.model.Hotel;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 30/12/2024
 */
public interface HotelService {

	List<Hotel> findAll();
	Hotel findByNombre(String nombre);
	String actualizarPlazasHotel(int idHotel, int plazas);
	
	//Métodos necesarios para la parte de cliente
	Hotel findById(int id);
	List<Hotel> findHotelesDisponibles();
}
