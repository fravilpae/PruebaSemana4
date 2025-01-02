package com.curso.model;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
 */
public class ReservaCliente {
	
	private int idVuelo;
	private int idHotel;
	private String nombre;
	private String dni;
	private int personas;
	
	public ReservaCliente() {
		super();
	}

	public ReservaCliente(int idVuelo, int idHotel, String nombre, String dni, int personas) {
		super();
		this.idVuelo = idVuelo;
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.dni = dni;
		this.personas = personas;
	}

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public int getIdHotel() {
		return idHotel;
	}

	public void setIdHotel(int idHotel) {
		this.idHotel = idHotel;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getPersonas() {
		return personas;
	}

	public void setPersonas(int personas) {
		this.personas = personas;
	}
}
