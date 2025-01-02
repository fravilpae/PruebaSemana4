package com.curso.service;

import java.util.List;

import com.curso.model.HotelDTO;
import com.curso.model.ReservaCliente;
import com.curso.model.ReservaDTO;
import com.curso.model.VueloDTO;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
 */
public interface ReservaClienteService {

	void realizarReserva(ReservaCliente reserva);
	List<ReservaDTO> getReservasPorNombreHotel(String nombreHotel);
	List<HotelDTO> getHotelesDisponibles();
	List<VueloDTO> getVuelosPorPlazas(int plazas);
	List<VueloDTO> getVuelosFuturos(); 
}
