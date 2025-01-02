package com.curso.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * @author Francisco Manuel Villalobos
 * @version 1.1 02/01/2025
 */
@Entity
@Table(name = "hoteles")
public final class Hotel {

	@Id
	@Column(name = "id_hotel")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHotel;
	
	@Column(unique = true, length = 200)
	private String nombre;
	
	@Enumerated(EnumType.STRING)
	private Categoria categoria;	//En la base de datos se interpreta como un Varchar
	
	@Column(precision = 6)
	private double precio;		 //En la base de datos se interpreta como Decimal(6,2)
	
	private boolean disponible;  //En la base de datos se interpreta como TinyInt(1) -> 1 = Sí, 0 = No
	
	private int plazas; 		 //Número de plazas disponibles en el hotel

	@Column(length = 200)
	private String lugar; 		//Lugar del hotel
	
	@JsonManagedReference
	@OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
	private List<Reserva> reservas = new ArrayList<Reserva>();
	
	public Hotel() {
		super();
	}

	public Hotel(int idHotel, String nombre, Categoria categoria, double precio, boolean disponible, int plazas, String lugar) {
		super();
		this.idHotel = idHotel;
		this.nombre = nombre;
		this.categoria = categoria;
		this.precio = precio;
		this.disponible = disponible;
		this.plazas = plazas;
		this.lugar = lugar;
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public List<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
}
