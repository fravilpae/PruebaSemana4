package com.curso.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.1 02/01/2025
 */
@Entity
@Table(name = "vuelos")
public class Vuelo {

	@Id
	@Column(name = "id_vuelo")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idVuelo;
	
	@Column(length = 200)
	private String compania;
	
	@Column(name = "fecha_vuelo")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime fechaVuelo;  //En la base de datos es un Timestamp
	
	@Column(precision = 6)
	private double precio;
	
	@Column(name = "plazas_disponibles")
	private int plazasDisponibles;
	
	@Column(length = 200)
	private String destino;			//Destino del avión
	
	@JsonManagedReference
	@OneToMany(mappedBy = "vuelo", cascade = CascadeType.REMOVE)
	private List<Reserva> reservas = new ArrayList<Reserva>();

	public Vuelo() {
		super();
	}

	public Vuelo(int idVuelo, String compania, LocalDateTime fechaVuelo, double precio, int plazasDisponibles, String destino) {
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

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
}
