package com.curso.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Reserva;
import com.curso.repository.ReservaRepository;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 02/01/2025
 */
@Service
public class ReservaServiceImpl implements ReservaService {
	
	@Autowired
	private ReservaRepository repository;

	@Override
	public List<Reserva> findAll() {
		return repository.findAll();
	}

	@Override
	public void save(Reserva reserva) {
		validarDatos(reserva);
		repository.save(reserva);
	}

	/**
	 * Comprueba que los datos son válidos para realizar la reserva.
	 * Comprueba que el vuelo se diriga a la dirección del hotel y que el vuelo sea futuro
	 * @param reserva Reserva a guardar
	 */
	private void validarDatos(Reserva reserva) {
		if (!(reserva.getHotel().getLugar().equalsIgnoreCase(reserva.getVuelo().getDestino()))) {
			throw new RuntimeException("El vuelo no se dirige hacia la dirección del hotel");
		} else if (reserva.getVuelo().getFechaVuelo().isBefore(LocalDateTime.now())) {
			throw new RuntimeException("El vuelo ocurrió en el pasado. No puede ser reservado");
		}
	}

	@Override
	public List<Reserva> findByHotel(int id) {
		return repository.findAllByHotel(id);
	}

	@Override
	public Reserva findById(int id) {
		return repository.findById(id).orElse(null);
	}

}
