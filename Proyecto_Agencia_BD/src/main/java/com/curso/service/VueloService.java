package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 30/12/2024
 */
public interface VueloService {

	List<Vuelo> findByPlazasDisponiblesGreaterThanEqual(int plazas);
	String actualizarPlazasVuelo(int idVuelo, int plazas);
	List<Vuelo> findVuelosFuturos();
	
	//Métodos necesarios para la parte de cliente
	Vuelo findById(int id);
}
