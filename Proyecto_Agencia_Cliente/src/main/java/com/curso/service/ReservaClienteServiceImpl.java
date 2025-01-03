package com.curso.service;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.curso.model.HotelDTO;
import com.curso.model.ReservaCliente;
import com.curso.model.ReservaDTO;
import com.curso.model.VueloDTO;
/**
 * @author Francisco Manuel Villalobos
 * @version 1.1 02/01/2025
 */
@Service
public class ReservaClienteServiceImpl implements ReservaClienteService {
	
	@Autowired
	private RestTemplate template;
	
	private static final String URL_HOTELES = "http://localhost:8080/hoteles";
	private static final String URL_VUELOS = "http://localhost:8080/vuelos";
	private static final String URL_RESERVAS = "http://localhost:8080/reservas";

	/**
	 * Realiza la reserva de un vuelo y un hotel.
	 * Valida que los datos de la reserva son correctos.
	 * Si los datos son correctos, se publica la reserva y se actualizan los datos del vuelo y hotel elegidos.
	 * 
	 * @Param reservaCliente Reserva de un cliente.
	 */
	@Override
	public void realizarReserva(ReservaCliente reservaCliente) {
		HotelDTO hotel = template.getForObject(URL_HOTELES+"/"+reservaCliente.getIdHotel(), HotelDTO.class);
		VueloDTO vuelo = template.getForObject(URL_VUELOS+"/"+reservaCliente.getIdVuelo(), VueloDTO.class);
		validarReserva(reservaCliente, hotel, vuelo);
		ReservaDTO reserva = new ReservaDTO(reservaCliente.getNombre(), reservaCliente.getDni(), hotel, vuelo);
		template.postForLocation(URL_RESERVAS, reserva);
		template.put(URL_VUELOS+"/"+reservaCliente.getIdVuelo()+"/"+reservaCliente.getPersonas(),null);
		template.put(URL_HOTELES+"/"+reservaCliente.getIdHotel()+"/"+reservaCliente.getPersonas(),null);

	}

	/**
	 * Método útil para validar los datos de la reserva antes de realizarla.
	 * Comprueba que las plazas no sobrepasen las plazas del hotel y del vuelo.
	 * Comprueba que el vuelo se diriga hacia la misma dirección en la que se encuentra el hotel.
	 * Comprueba que el vuelo reservado es futuro
	 */
	private void validarReserva(ReservaCliente reserva, HotelDTO hotel, VueloDTO vuelo) {
		if(hotel.getPlazas()< reserva.getPersonas() || hotel.isDisponible()==false) {
			throw new RuntimeException("El hotel no se encuentra disponible");
		} else if (vuelo.getPlazasDisponibles()< reserva.getPersonas()) {
			throw new RuntimeException("El vuelo no dispone de las suficientes plazas");
		} else if (!(hotel.getLugar().equalsIgnoreCase(vuelo.getDestino()))) {
			throw new RuntimeException("El vuelo no se dirige hacia la dirección del hotel");
		} else if (vuelo.getFechaVuelo().isBefore(LocalDateTime.now())) {
			throw new RuntimeException("El vuelo ocurrió en el pasado. No puede ser reservado");
		}
	}

	/**
	 * Método que busca las reservas realizadas en un hotel específico
	 * 
	 * @param nombreHotel Nombre del hotel buscado
	 */
	@Override
	public List<ReservaDTO> getReservasPorNombreHotel(String nombreHotel) {
		HotelDTO hotel = template.getForObject(URL_HOTELES + "/nombre/" + nombreHotel, HotelDTO.class);
		if (hotel != null) {
			List<ReservaDTO> reservas = Arrays.asList(template.getForObject(URL_RESERVAS + "/" + hotel.getIdHotel(), ReservaDTO[].class));
			return reservas;
		} else {
			return null;
		}
	}

	/**
	 * Método que devuelve los hoteles que se encuentran disponibles
	 */
	@Override
	public List<HotelDTO> getHotelesDisponibles() {
		return Arrays.asList(template.getForObject(URL_HOTELES+"/disponibles", HotelDTO[].class));
	}

	/**
	 * Método que busca los vuelos con suficientes plazas disponibles como indicadas en el parámetro
	 * 
	 * @param plazas Número de plazas mínimo que debe tener el avión
	 */
	@Override
	public List<VueloDTO> getVuelosPorPlazas(int plazas) {
		return Arrays.asList(template.getForObject(URL_VUELOS+"/plazas/"+plazas, VueloDTO[].class));
	}

	/**
	 * Método que busca los vuelos futuros
	 */
	@Override
	public List<VueloDTO> getVuelosFuturos() {
		return Arrays.asList(template.getForObject(URL_VUELOS+"/futuros", VueloDTO[].class));
	}

}
