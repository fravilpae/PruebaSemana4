package com.curso.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
 */
@Entity
@Table(name = "reservas")
public class Reserva {
//Una reserva pertenece a un hotel y un vuelo
//Un hotel puede tener n reservas
//Un vuelo puede tener n reservas
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reserva")
	private int idReserva;
	
	@Column(name = "nombre_cliente", length = 255)
	private String nombreCliente;
	
	@Column(length = 9)
	private String dni;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_hotel")
	private Hotel hotel;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "id_vuelo")
	private Vuelo vuelo;

	public Reserva() {
		super();
	}

	public Reserva(int idReserva, String nombreCliente, String dni, Hotel hotel, Vuelo vuelo) {
		super();
		this.idReserva = idReserva;
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.hotel = hotel;
		this.vuelo = vuelo;
	}

	public int getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(int idReserva) {
		this.idReserva = idReserva;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Vuelo getVuelo() {
		return vuelo;
	}

	public void setVuelo(Vuelo vuelo) {
		this.vuelo = vuelo;
	}
}
