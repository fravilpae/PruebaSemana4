package com.curso.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curso.model.Reserva;
import com.curso.repository.ReservaRepository;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
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
		repository.save(reserva);
	}

	@Override
	public List<Reserva> findReservasPorHotel(int id) {
		return repository.findAllByHotel(id);
	}

}
