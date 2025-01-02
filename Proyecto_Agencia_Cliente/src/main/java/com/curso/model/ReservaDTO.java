package com.curso.model;
/**
 * Clase DTO de la entidad Reserva
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
 */
public class ReservaDTO {

	private int idReserva;
	private String nombreCliente;
	private String dni;
	private HotelDTO hotel;
	private VueloDTO vuelo;
	
	public ReservaDTO() {
		super();
	}
	
	public ReservaDTO(String nombreCliente, String dni, HotelDTO hotel, VueloDTO vuelo) {
		super();
		this.nombreCliente = nombreCliente;
		this.dni = dni;
		this.hotel = hotel;
		this.vuelo = vuelo;
	}


	public ReservaDTO(int idReserva, String nombreCliente, String dni, HotelDTO hotel, VueloDTO vuelo) {
		this(nombreCliente, dni, hotel, vuelo);
		this.idReserva = idReserva;
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

	public HotelDTO getHotel() {
		return hotel;
	}

	public void setHotel(HotelDTO hotel) {
		this.hotel = hotel;
	}

	public VueloDTO getVuelo() {
		return vuelo;
	}

	public void setVuelo(VueloDTO vuelo) {
		this.vuelo = vuelo;
	}
}
