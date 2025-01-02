package com.curso.model;

import java.time.LocalDateTime;

/**
 * Clase DTO de la entidad Vuelo
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
 */
public class VueloDTO {

	private int idVuelo;
	private String compania;
	private LocalDateTime fechaVuelo;
	private double precio;
	private int plazasDisponibles;
	private String destino;
	
	public VueloDTO() {
		super();
	}

	public VueloDTO(int idVuelo, String compania, LocalDateTime fechaVuelo, double precio, int plazasDisponibles, String destino) {
		super();
		this.idVuelo = idVuelo;
		this.compania = compania;
		this.fechaVuelo = fechaVuelo;
		this.precio = precio;
		this.plazasDisponibles = plazasDisponibles;
		this.destino = destino;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getCompania() {
		return compania;
	}

	public void setCompania(String compania) {
		this.compania = compania;
	}

	public LocalDateTime getFechaVuelo() {
		return fechaVuelo;
	}

	public void setFechaVuelo(LocalDateTime fechaVuelo) {
		this.fechaVuelo = fechaVuelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getPlazasDisponibles() {
		return plazasDisponibles;
	}

	public void setPlazasDisponibles(int plazasDisponibles) {
		this.plazasDisponibles = plazasDisponibles;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}
}
