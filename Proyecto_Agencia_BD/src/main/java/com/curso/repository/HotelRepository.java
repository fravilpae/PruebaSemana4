package com.curso.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Hotel;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 30/12/2024
 */
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

	Optional<Hotel> findByNombreIgnoreCase(String nombre);
	List<Hotel> findAllByDisponibleTrue();
}
