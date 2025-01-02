# Proyecto agencia de viajes

Este repositorio contiene cuatro microservicios desarrollados en Spring Boot para gestionar una agencia de viajes. Los tres microservicios son hoteles, vuelos y reservas. La aplicación utiliza una base de datos MySQL de la que se adjuntan los scripts en el proyecto de base de datos, en la carpeta Source. Expone sus funcionalidades a través de una API REST que se muestran a través del navegador.

### Características principales

- Arquitectura basada en microservicios
- Uso de base de datos MySQL.
- Relaciona los microservicios de hoteles, vuelos y reservas con las reservas realizadas por los clientes.
- Exposición de endpoints para interactura con todas las entidades.

### Tecnologías utilizadas

- **Spring Boot**: Infraestructura para microservicios eficiente.
- **Swagger**: Documentación y visualización de API RESTful.
- **JUnit**: Marco para pruebas unitarias en Java.

### Inicio Rápido

- **Clonar el repositorio**: git clone https://github.com/fravilpae/PruebaSemana4.git

- **Acceder al directorio del proyecto**: cd xxx

- **Arrancar en servidores ambos proyectos**

### Entidades

- Hotel: Representa a un hotel con las propiedades id del hotel, nombre, categoría,  precio, disponibilidad, plazas y lugar.

- Vuelo: Representa a un vuelo con las propiedades id del vuelo, compañía, fecha del vuelo, precio, plazas disponibles y destino.

- Reserva: Representa a una reserva con las propiedades id de la reserva, nombre, dni, hotel y vuelo.

- Reserva Cliente: Representa a una reserva realizada por un cliente, con las propiedades id del vuelo, id del hotel, nombre del cliente, dni y personas.

## Servicio Hotel

Este microservicio proporciona funcionalidades para la gestión de hoteles.

### Funcionalidades

- Listar hoteles
- Encontrar hotel por nombre
- Actualizar las plazas de un hotel
- Encontrar hotel por su id
- Listar hoteles disponibles

### Endpoints

**Puerto 8080**

- **Listar hoteles**
    - **URL: /hoteles**
    - **Método: GET**

- **Encontrar hotel por nombre**
    - **URL: /hoteles/nombre/{nombre}**
    - **Método: GET**

- **Actualizar las plazas de un hotel**
    - **URL: /hoteles/{idHotel}/{plazas}**
    - **Método: PUT**

- **Encontrar hotel por su id**
    - **URL: /hoteles/{idHotel}**
    - **Método: GET**

- **Listar hoteles disponibles**
	- **URL: /hoteles/disponibles**
	- **Método: GET**

## Servicio Vuelo

Este microservicio proporciona funcionalidades para la gestión de vuelos.

### Funcionalidades

- Encontrar vuelos con suficientes plazas disponibles
- Actualizar las plazas de un vuelo
- Encontrar vuelo por su id
- Encontrar vuelos futuros

### Endpoints

**Puerto 8080**

- **Encontrar vuelos con suficientes plazas disponibles**
	- **URL: /vuelos/plazas/{plazas}**
	- **Método: GET**

- **Actualizar las plazas de un vuelo**
	- **URL: /vuelos/{idVuelo}/{plazas}**
	- **Método: PUT**

- **Encontar vuelo por su id**
	- **URL: /vuelos/{idVuelo}**
	- **Método: GET**
	
- **Encontrar vuelos futuros**
	- **URL: /vuelos/futuros**
	- **Método: GET**

## Servicio Reserva

Este microservicio proporciona funcionalidades para la gestión de reservas.

### Funcionalidades

- Listar las reservas
- Guardar una reserva
- Encontrar reservas de un hotel

### Endpoints

**Puerto 8080**

- **Listar las reservas**
	- **URL: /reservas**
	- **Método: GET**

- **Guardar una reserva**
	- **URL: /reservas**
	- **Método: POST**

- **Encontrar reservas de un hotel**
	- **URL: /reservas/{idHotel}**
	- **Método: GET**

## Servicio Reserva Cliente

Este interaccionará con los servicios de hotel, vuelo y reserva para ofrecer su funcionalidad. Los datos que caracterizan la reserva de un cliente son:

id del hotel (numérico entero)

id del vuelo (numérico entero)

nombre del cliente (texto)

dni del cliente (texto)

número de personas de la reserva (numérico entero)

### Funcionalidades

- Realizar una reserva: Utiliza los microservicios de hotel y vuelo para validar los datos enviados, y si son buenos utiliza el microservicio de reserva para crearlo, y los microservicios de hotel y vuelo para actualizar las plazas de cada uno.

- Obtener las reservas de un hotel: Utiliza el microservicio de hotel para obtener el hotel a partir de su nombre y luego el microservicio de reservas para obtener las reservas a partir de la id del hotel.

- Obtener los hoteles disponibles: Utiliza el microservicio de hotel para obtener los hoteles que están disponibles.

- Obtener los vuelos futuros: Utiliza el microservicio de hotel para obtener los vuelos que ocurrirán en el futuro.

- Obtener los vuelos disponibles por plazas: Utiliza el microservicio de hotel para obtener los vuelos con un mínimo de plazas disponibles.

### Endpoints

**Puerto 9000**

- **Realizar una reserva**
	- **URL: /reservas**
	- **Método: POST**

- **Obtener reservas de un hotel**
	- **URL: /reservas/{nombreHotel}**
	- **Método: GET**
	
- **Obtener hoteles disponibles**
	- **URL: /hoteles**
	- **Método: GET**
	
- **Obtener vuelos futuros**
	- **URL: /vuelos**
	- **Método: GET**

- **Obtener vuelos disponibles por plazas**
	- **URL: /vuelos/{plazas}**
	- **Método: GET**

## Estado proyecto

En desarrollo (2-1-2025): Implementado al 90%
			  Falta implementar tests
