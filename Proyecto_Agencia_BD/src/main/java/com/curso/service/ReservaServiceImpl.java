package com.curso.service;

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
		repository.save(reserva);
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
