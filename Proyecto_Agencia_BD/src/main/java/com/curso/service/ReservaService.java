package com.curso.service;

import java.util.List;

import com.curso.model.Reserva;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
public interface ReservaService {

	List<Reserva> findAll();
	void save(Reserva reserva);
	List<Reserva> findByHotel(int id);
	
	//Método que solo uso en test
	Reserva findById(int id);
}
