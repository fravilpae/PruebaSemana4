package com.curso.service;

import java.util.List;

import com.curso.model.Vuelo;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
public interface VueloService {

	List<Vuelo> findByPlazasDisponiblesGreaterThanEqual(int plazas);
	String actualizarPlazas(int idVuelo, int plazas);
	List<Vuelo> findFuturos();
	
	//Métodos necesarios para la parte de cliente
	Vuelo findById(int id);
}
