package com.curso.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.model.Vuelo;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 30/12/2024
 */
public interface VueloRepository extends JpaRepository<Vuelo, Integer> {

	List<Vuelo> findByPlazasDisponiblesGreaterThanEqual(int plazas);
	List<Vuelo> findAllByFechaVueloAfter(LocalDateTime hoy);
}
