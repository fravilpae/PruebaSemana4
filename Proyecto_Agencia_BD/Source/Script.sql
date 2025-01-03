CREATE DATABASE agencia;
USE agencia;

CREATE TABLE `hoteles` (
  `id_hotel` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(200) NOT NULL UNIQUE,
  `categoria` VARCHAR(200) NOT NULL,
  `precio` DECIMAL(6,2) NOT NULL,
  `disponible` BOOLEAN NOT NULL,
  `plazas` INT NOT NULL,
  `lugar` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id_hotel`));
 
CREATE TABLE `vuelos` (
  `id_vuelo` INT NOT NULL AUTO_INCREMENT,
  `compania` VARCHAR(200) NOT NULL,
  `fecha_vuelo` DATETIME NOT NULL,
  `precio` DECIMAL(6,2) NOT NULL,
  `plazas_disponibles` INT NOT NULL,
  `destino` VARCHAR(200) NOT NULL,
  PRIMARY KEY (`id_vuelo`));
  
CREATE TABLE `reservas` (
  `id_reserva` INT NOT NULL AUTO_INCREMENT,
  `nombre_cliente` VARCHAR(255) NOT NULL,
  `dni` VARCHAR(9) NOT NULL,
  `id_hotel` INT NOT NULL,
  `id_vuelo` INT NOT NULL,
  PRIMARY KEY (`id_reserva`));

ALTER TABLE `reservas` ADD CONSTRAINT `reservas_fk0` FOREIGN KEY (`id_hotel`) REFERENCES `hoteles`(`id_hotel`) ON DELETE CASCADE;
ALTER TABLE `reservas` ADD CONSTRAINT `reservas_fk1` FOREIGN KEY (`id_vuelo`) REFERENCES `vuelos`(`id_vuelo`) ON DELETE CASCADE;
  
INSERT INTO `hoteles` (`nombre`, `categoria`, `precio`, `disponible`, `plazas`, `lugar`) VALUES ('Hotel 1', 'Una_estrella', '20.95', '1', '28', 'Sevilla');
INSERT INTO `hoteles` (`nombre`, `categoria`, `precio`, `disponible`, `plazas`, `lugar`) VALUES ('Hotel 2', 'Dos_estrellas', '27.95', '1', '30', 'Madrid');
INSERT INTO `hoteles` (`nombre`, `categoria`, `precio`, `disponible`, `plazas`, `lugar`) VALUES ('Hotel 3', 'Tres_estrellas', '33.95', '1', '30', 'Barcelona');
INSERT INTO `hoteles` (`nombre`, `categoria`, `precio`, `disponible`, `plazas`, `lugar`) VALUES ('Hotel 4', 'Cuatro_estrellas', '64.95', '1', '30', 'Nueva York');
INSERT INTO `hoteles` (`nombre`, `categoria`, `precio`, `disponible`, `plazas`, `lugar`) VALUES ('Hotel 5', 'Cinco_estrellas', '99.95', '0', '0', 'Sevilla');
INSERT INTO `hoteles` (`nombre`, `categoria`, `precio`, `disponible`, `plazas`, `lugar`) VALUES ('Hotel 6', 'Sin_estrellas', '15.95', '1', '30', 'Sevilla');

INSERT INTO `vuelos` (`compania`, `fecha_vuelo`, `precio`, `plazas_disponibles`, `destino`) VALUES ('Iberia', '2025-03-15 08:30:00', '150.50', '98', 'Sevilla');
INSERT INTO `vuelos` (`compania`, `fecha_vuelo`, `precio`, `plazas_disponibles`, `destino`) VALUES ('Ryanair', '2024-02-20 14:45:00', '75.99', '120', 'Málaga');
INSERT INTO `vuelos` (`compania`, `fecha_vuelo`, `precio`, `plazas_disponibles`, `destino`) VALUES ('Air Europa', '2024-03-10 19:00:00', '180.00', '80', 'Madrid');
INSERT INTO `vuelos` (`compania`, `fecha_vuelo`, `precio`, `plazas_disponibles`, `destino`) VALUES ('Vueling', '2024-01-22 06:15:00', '95.30', '150', 'Barcelona');
INSERT INTO `vuelos` (`compania`, `fecha_vuelo`, `precio`, `plazas_disponibles`, `destino`) VALUES ('Lufthansa', '2024-02-25 22:30:00', '220.75', '60', 'Dubái');
INSERT INTO `vuelos` (`compania`, `fecha_vuelo`, `precio`, `plazas_disponibles`, `destino`) VALUES ('Delta', '2024-03-05 10:00:00', '350.00', '50', 'Nueva York');
INSERT INTO `vuelos` (`compania`, `fecha_vuelo`, `precio`, `plazas_disponibles`, `destino`) VALUES ('American Airlines', '2024-01-18 16:20:00', '400.99', '45', 'Los Ángeles');
INSERT INTO `vuelos` (`compania`, `fecha_vuelo`, `precio`, `plazas_disponibles`, `destino`) VALUES ('KLM', '2024-02-28 09:10:00', '200.00', '70', 'Sevilla');
INSERT INTO `vuelos` (`compania`, `fecha_vuelo`, `precio`, `plazas_disponibles`, `destino`) VALUES ('British Airways', '2024-03-15 20:40:00', '300.25', '55', 'Inglaterra');
INSERT INTO `vuelos` (`compania`, `fecha_vuelo`, `precio`, `plazas_disponibles`, `destino`) VALUES ('EasyJet', '2024-01-12 12:50:00', '85.75', '110', 'Madrid');

INSERT INTO `reservas` (`nombre_cliente`, `dni`, `id_hotel`, `id_vuelo`) VALUES ('Pepito', '12345678S', '1', '1');
