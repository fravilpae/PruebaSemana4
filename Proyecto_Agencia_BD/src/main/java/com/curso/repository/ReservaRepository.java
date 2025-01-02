package com.curso.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.curso.model.Reserva;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
 */
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
	
	@Query("SELECT r FROM Reserva r WHERE r.hotel.id = ?1")
	List<Reserva> findAllByHotel(int id);

}
