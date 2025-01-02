package com.curso.service;

import java.util.List;

import com.curso.model.Reserva;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
 */
public interface ReservaService {

	List<Reserva> findAll();
	void save(Reserva reserva);
	List<Reserva> findReservasPorHotel(int id);
}
