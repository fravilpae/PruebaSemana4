package com.curso.model;
/**
 * Clase DTO de la entidad Hotel
 * @author Francisco Manuel Villalobos
 * @version 1.0 31/12/2024
 */
public class HotelDTO {

	private int idHotel;
	private String nombre;
	private String categoria;
	private double precio;
	private boolean disponible;
	private int plazas;
	private String lugar;
	
	
	public HotelDTO() {
		super();
	}


	public HotelDTO(int idHotel, String nombre, String categoria, double precio, boolean disponible, int plazas,
			String lugar) {
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


	public String getCategoria() {
		return categoria;
	}


	public void setCategoria(String categoria) {
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
}
